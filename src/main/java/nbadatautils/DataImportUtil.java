package nbadatautils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import json.PlayerInfo;
import json.Shotchart;
import json.TeamInfo;
import model.*;
import service.DBService;
import util.MessageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataImportUtil {

	private DBService dbService = new DBService();
	private Gson gson = new Gson();

	private PlayerDataUtil playerUtil = new PlayerDataUtil();
	private TeamDataUtil teamUtil = new TeamDataUtil();

	private void init() {
		importSeasonData();
		importShotZoneData();
	}

	public void importData(Season season) {
		init();

		// get all teams in a season
		System.out.println("getting team list ... ");
		MessageFactory.write("getting team list ... ");
		List<TeamInfo> teamInfoList = teamUtil.getTeamList();
		System.out.println("get " + teamInfoList.size() + " teams data");
		MessageFactory.write("get " + teamInfoList.size() + " teams data");

		List<Team> teamList = new ArrayList<>();
		for (TeamInfo teamInfo : teamInfoList) {
			System.out.println();
			// if team already in database, do nothing
			Team team = dbService.findById(Long.valueOf(teamInfo.getTeamId()), Team.class);
			if (team != null) {
				System.out.println("team " + teamInfo.getAbbreviation() + " is already in database");
				MessageFactory.write("team " + teamInfo.getAbbreviation() + " is already in database");
			} else {
				// get team common information
				System.out.println("getting team " + teamInfo.getAbbreviation() + " common information ... ");
				MessageFactory.write("import team " + teamInfo.getAbbreviation());
				TeamInfo info = teamUtil.getTeamInfo(teamInfo.getTeamId(), season.getTitle(), season.getType());
				System.out.println("getting finished");

				// save team data to database
				team = saveTeamData(info);
			}
			teamList.add(team);
		}

		for (Team team : teamList) {
			// get roster of team
			System.out.println("");
			System.out.println("getting roster of " + team.getName() + " ... ");
			MessageFactory.write("getting roster of " + team.getName() + " ... ");
			List<PlayerInfo> playerInfoList = teamUtil.getRoster(String.valueOf(team.getId()), season.getTitle());
			System.out.println("get " + playerInfoList.size() + " players");
			MessageFactory.write("get " + playerInfoList.size() + " players of " + team.getName());

			for (PlayerInfo playerInfo : playerInfoList) {
				Player player = dbService.findById(Long.valueOf(playerInfo.getPersonId()), Player.class);
				if (player != null) {
					System.out.println("player " + playerInfo.getName() + " is already in database");
					MessageFactory.write("player " + playerInfo.getName() + " is already in database");
				} else {
					// get player common information
					System.out.println("getting player " + playerInfo.getName() + " common information ... ");
					MessageFactory.write("import " + team.getName() + "/" + playerInfo.getName());
					PlayerInfo info = playerUtil.getPlayerInfo(playerInfo.getPersonId());
					System.out.println("getting finished");

					// save player data to database
					savePlayerData(info);
				}

			}

			MessageFactory.writeProcess();		// process + 1

			saveShotData(team, season);

			MessageFactory.writeProcess();		// process + 1
		}

		MessageFactory.write("import finished");
	}


	private void saveShotData(Team team, Season season) {
		// get all shotcharts of Team in this season
		System.out.println("getting all shotcharts of " + team.getName());
		MessageFactory.write("import all shotcharts of " + team.getName());
		List<Shotchart> shotcharts = teamUtil.getShotcharts(team.getId().toString(), season.getTitle(), season.getType());
		System.out.println("getting finished");

		System.out.println("saving shot data...");
		for (Shotchart shotchart : shotcharts) {
			String id = shotchart.getGameId() + shotchart.getGameEventId();

			Shot shot = dbService.findById(Long.valueOf(id), Shot.class);
			if (shot != null) {
				continue;
			} else {
				shot = new Shot();
			}

			// set id
			shot.setId(Long.valueOf(id));

			// set player
			Player player = dbService.findById(Long.valueOf(shotchart.getPlayerId()), Player.class);
			if (player == null) {
				PlayerInfo info = playerUtil.getPlayerInfo(shotchart.getPlayerId());
				player = savePlayerData(info);
			}
			shot.setPlayer(player);

			// set team
			shot.setTeam(team);

			// get and set shotType
			ShotType shotType = dbService.findShotType(shotchart.getShotType());
			if (shotType == null) {
				shotType = new ShotType();
				shotType.setType(shotchart.getShotType());
				shotType = dbService.add(shotType);
			}
			shot.setShotType(shotType);

			// get and set shotZone
			ShotZone shotZone = parseShotZone(shotchart);
			shot.setShotZone(shotZone);

			// set and save game
			Game game = dbService.findById(Long.valueOf(shotchart.getGameId()), Game.class);
			if (game == null) {
				game = saveGameData(shotchart, season);
				System.out.println("a new game saved");
			}
			shot.setGame(game);

			shot.setPosX(shotchart.getLocX());
			shot.setPosY(shotchart.getLocY());
			shot.setDistance(shotchart.getDistance());

			// not calculated with period
			shot.setTime(shotchart.getRemainMinutes() + ":" + shotchart.getRemainSeconds());

			shot.setMade(shotchart.getShotMadeFlag()==1);

			dbService.add(shot);
		}
		System.out.println("shot data save finished");
	}

	/**
	 * 1 + 30 + 30 + 30? + 13*30 + 30 = 511
	 * first import all team data
	 * then import all game data of every team ?
	 * then import all player info of every team
	 * and then import all shotcharts of every team
	 *
	 * 1 + 30 + 30 + 13*30 + 13*30 = 841
	 */

	private String parseRange(int range) {
		if (range < 8) {
			return "8 FT";
		} else if (range >= 8 && range < 16) {
			return "8-16 FT";
		} else if (range >= 16 && range < 24) {
			return "16-24 FT";
		} else {
			return "24 FT+";
		}
	}

	private ShotZone parseShotZone(Shotchart shotchart) {
		ShotZone zone;
		String area = "";
		String ranges;

		String a = shotchart.getShotZoneArea();
		int r = shotchart.getDistance();

		switch (shotchart.getShotZoneBasic()) {
			case "Restricted Area":
				area = "center";
				break;
			case "In The Paint (Non-RA)":
				area = "center";
				break;
			case "Mid-Range":
				if (a.equals("Center(C)")) {
					area = "center";
				} else if (a.equals("Left Side(L)")) {
					area = "left side";
				} else if (a.equals("Right Side(R)")) {
					area = "right side";
				} else if (a.equals("Left Side Center(LC)")) {
					area = "left center";
				} else if (a.equals("Right Side Center(RC)")) {
					area = "right center";
				}
				break;
			case "Left Corner 3":
				area = "left side";
				break;
			case "Right Corner 3":
				area = "right side";
				break;
			case "Above the Break 3":
				if (a.equals("Center(C)")) {
					area = "center";
				} else if (a.equals("Left Side Center(LC)")) {
					area = "left center";
				} else if (a.equals("Right Side Center(RC)")) {
					area = "right center";
				} else if (a.equals("Back Court(BC)")) {
					area = "backcourt";
				}
				break;
			case "Backcourt":
				area = "backcourt";
				break;
		}
		ranges = parseRange(r);
		String title = area + " " + ranges;
		zone = dbService.findByTitle(title, ShotZone.class);

		return zone;
	}

	private Game saveGameData(Shotchart shotchart, Season season) {
		Game game = new Game();
		game.setId(Long.valueOf(shotchart.getGameId()));

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			game.setDate(dateFormat.parse(shotchart.getGameDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Season s = dbService.findSeason(season.getTitle(), season.getType());
		if (s == null) {
			Season newSeason = new Season();
			newSeason.setTitle(season.getTitle());
			newSeason.setType(season.getType());
			s = dbService.add(newSeason);
		}
		game.setSeason(s);

		Team htm = dbService.findTeamByAbbr(shotchart.getHtm());
		Team vtm = dbService.findTeamByAbbr(shotchart.getVtm());
		game.setHtm(htm);
		game.setVtm(vtm);

		dbService.add(game);

		return game;
	}

	private Player savePlayerData(PlayerInfo info) {
		Player player = new Player();
		player.setId(Long.valueOf(info.getPersonId()));
		player.setName(info.getName());

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			player.setBirthdate(dateFormat.parse(info.getBirthdate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		player.setHeight(info.getHeight());
		if (!info.getWeight().isEmpty())
			player.setWeight(Integer.parseInt(info.getWeight()));

		player.setSchool(info.getSchool());
		player.setCountry(info.getCountry());
		player.setSeasonExp(Integer.parseInt(info.getSeasonExp()));

		String position = info.getPosition();
		if (position.contains("-")) {
			String [] ps = position.split("-");
			player.setFirstPosition(ps[0]);
			player.setSecondPosition(ps[1]);
		} else {
			player.setFirstPosition(position);
		}

		player.setFromYear(Integer.parseInt(info.getFromYear()));
		player.setToYear(Integer.parseInt(info.getToYear()));

		if (!info.getDraftYear().equals("Undrafted")) {
			player.setDraftYear(Integer.parseInt(info.getDraftYear()));
			player.setDraftRound(Integer.parseInt(info.getDraftRound()));
			player.setDraftNumber(Integer.parseInt(info.getDraftNumber()));
		}

		System.out.println("save player data of " + player.getName() + " to database");
		dbService.add(player);
		System.out.println("save finished");

		return player;
	}

	private Team saveTeamData(TeamInfo info) {
		Team team = new Team();
		team.setId(Long.valueOf(info.getTeamId()));
		team.setName(info.getName());
		team.setCity(info.getCity());
		team.setAbbreviation(info.getAbbreviation());
		team.setConference(info.getConference());
		team.setDivision(info.getDivision());

		System.out.println("save team data of " + team.getName() + " to database");
		dbService.add(team);
		System.out.println("save finished");

		return team;
	}

	private void importShotTypeData() {
		if (!dbService.isEmpty("ShotType"))
			return;

		try (Reader reader = new FileReader("src/main/resources/data/shotTypeData.json")) {
			List<ShotType> typeList = gson.fromJson(reader, new TypeToken<List<ShotType>>() {}.getType());
			for (ShotType shotType : typeList) {
				dbService.add(shotType);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void importShotZoneData() {
		if (!dbService.isEmpty("ShotZone"))
			return;

		try (Reader reader = new FileReader("src/main/resources/data/shotZoneData.json")) {
			List<ShotZone> zoneList = gson.fromJson(reader, new TypeToken<List<ShotZone>>() {}.getType());
			for (ShotZone shotZone : zoneList) {
				shotZone.setTitle(shotZone.getArea() + " " + shotZone.getRanges());
				dbService.add(shotZone);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void importSeasonData() {
		if (!dbService.isEmpty("Season"))
			return;

		try (Reader reader = new FileReader("src/main/resources/data/seasonData.json")) {
			List<Season> seasonList = gson.fromJson(reader, new TypeToken<List<Season>>() {}.getType());
			for (Season season : seasonList) {
				dbService.add(season);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void importTeamData() {
//		try (Reader reader = new FileReader("src/main/resources/data/teamData.json")) {
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
