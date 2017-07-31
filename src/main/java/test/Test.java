package test;


import db.HibernateUtil;
import json.Shotchart;
import model.*;
import nbadatautils.DataImportUtil;
import nbadatautils.NBADataUtil;
import nbadatautils.PlayerDataUtil;
import nbadatautils.TeamDataUtil;
import org.hibernate.Session;
import service.DBService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static <T> void output(List<T> objects) {
		int i = 1;
		for (T t : objects) {
			System.out.print(i++ + " ");
			System.out.println(t);
		}
	}

	public static void dbAdd(Object o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}

	public static void init() {
		Team team = new Team();
		team.setId(234355L);
		team.setName("huston rocket");
		dbAdd(team);
		Team team2 = new Team();
		team2.setId(234356L);
		team2.setName("thunder");
		dbAdd(team2);

		Player player = new Player();
		player.setId(242341L);
		player.setName("james");
		player.setFirstPosition("guard");
		player.setSecondPosition("forward");
		dbAdd(player);

		ShotType type = new ShotType();
		type.setType("dunk shot");
		dbAdd(type);
		ShotType type1 = new ShotType();
		type1.setType("layup shot");
		dbAdd(type1);

		ShotZone zone = new ShotZone();
		zone.setArea("left side");
		zone.setRanges("8 FT");
		zone.setTitle("left side 8 FT");
		dbAdd(zone);
		ShotZone zone1 = new ShotZone();
		zone1.setArea("right side");
		zone1.setRanges("8 FT");
		zone1.setTitle("right side 8 FT");
		dbAdd(zone1);

		Season season = new Season();
		season.setId(123L);
		season.setTitle("2014-15");
		season.setType("regular season");
		dbAdd(season);

		Game game = new Game();
		game.setId(233L);
		game.setDate(new Date());
		game.setHtm(team);
		game.setVtm(team2);
		game.setSeason(season);
		game.setHtmPoints(124);
		game.setVtmPoints(112);
		dbAdd(game);

		Shot shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type);
		shot.setShotZone(zone);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
//		shot.setTime(new Date());
		shot.setMade(true);
		dbAdd(shot);
	}

	private static String parseRange(String range) {
/*		if (range < 8) {
			return "8 FT";
		} else if (range >= 8 && range < 16) {
			return "8-16 FT";
		} else if (range >= 16 && range < 24) {
			if (area.equals("left side") || area.equals("right side")) {
				if (range > 21) {
					return "24 FT+";
				}
			}
			return "16-24 FT";
		} else {
			return "24 FT+";
		}*/

		if (range.equals("Less Than 8 ft.")) {
			return "8 FT";
		} else if (range.equals("8-16 ft.")) {
			return "8-16 FT";
		} else if (range.equals("16-24 ft.")) {
			return "16-24 FT";
		} else {
			return "24 FT+";
		}
	}


	public static void updateZone() {
		DBService dbService = new DBService();
		PlayerDataUtil playerUtil = new PlayerDataUtil();
		List<Shotchart> shotcharts = playerUtil.getShotcharts("2544", "2014-15");

		String odate = "";
		int i = 0;
		int sum = 0;
		int is = 0;

		int n = 0;
		for (Shotchart shotchart : shotcharts) {
			String id = shotchart.getGameId() + shotchart.getGameEventId();
			Shot shot = dbService.findById(Long.valueOf(id), Shot.class);

			if (shot != null) {
				ShotZone shotZone = shot.getShotZone();
				String area = shotZone.getArea();
				String ranges = parseRange(shotchart.getShotZoneRange());

				String title = area + " " + ranges;
				ShotZone zone = dbService.findByTitle(title, ShotZone.class);

				shot.setShotZone(zone);
				dbService.update(shot);
			}

/*			n++;

			if (shotchart.getType().equals("3PT Field Goal")) {
				sum++;
			}

			String date = shotchart.getGameDate();
			if (odate.equals(date)) {
				if (shotchart.getType().equals("3PT Field Goal")) {
					i++;
				}

				if (n == shotcharts.size()) {
					System.out.println(date + ": " + i);
					is += i;
				}

			} else {
				System.out.println(odate + ": " + i);
				odate = date;

				is += i;

				i = 0;

				if (shotchart.getType().equals("3PT Field Goal")) {
					i++;
				}
			}*/
		}

	}

	public static void main(String[] args) {
//		init();
//		TestService service = new TestService();
//		service.insertData();

		show();

//		importData();

//		updateZone();
	}

	public  static void importData() {
		DataImportUtil util = new DataImportUtil();
		Season season = new Season();
		season.setTitle("2014-15");
		season.setType("Regular Season");
		util.importData(season);
	}

	public static void show() {
		NBADataUtil util = new NBADataUtil();

		PlayerDataUtil playerUtil = new PlayerDataUtil();
		TeamDataUtil teamUtil = new TeamDataUtil();

		// player information
		System.out.println(playerUtil.getPlayerInfo("201935"));
//		System.out.println(playerUtil.getPlayerInfo("201566"));

//		System.out.println(playerUtil.getPlayerInfo("203946"));

		// all player
//		output(playerUtil.getPlayerList("2015-16"));

		// player game log
//		output(playerUtil.getPlayerGameLogs("201935", "2015-16", "Regular Season"));

		// all team
//		output(teamUtil.getTeamList());

		// team information
//		System.out.println(teamUtil.getTeamInfo("1610612766", "2014-15", "Regular Season"));

		// team roster
//		output(teamUtil.getRoster("1610612760", "2014-15"));

		// team game log
//		output(teamUtil.getTeamGameLogs("1610612745", "2015-16", "Regular Season"));

		// box score
//		Map<String, String> vars = new HashMap<>();
//		vars.put("GameID", "0021401219");
//		vars.put("Season", "2014-15");
//		vars.put("SeasonType", "Regular Season");
//		vars.put("RangeType", "0");
//		vars.put("StartPeriod", "0");
//		vars.put("EndPeriod", "0");
//		vars.put("StartRange", "0");
//		vars.put("EndRange", "0");
//
//		System.out.println(util.getJson("boxscoreplayertrackv2", vars));

		// dashboard of player/team
//		Map<String, String> vars = new HashMap<>();
//		vars.put("PlayerID", "201935");
//		vars.put("TeamID", "1610612745");
//		vars.put("MeasureType", "Base");
//		vars.put("PerMode", "PerGame");
//		vars.put("PlusMinus", "N");
//		vars.put("PaceAdjust", "N");
//		vars.put("Rank", "N");
//		vars.put("LeagueID", "00");
//		vars.put("Season", "2015-16");
//		vars.put("SeasonType", "Regular Season");
//		vars.put("PORound", "0");
//		vars.put("Outcome", "");
//		vars.put("Location", "");
//		vars.put("Month", "0");
//		vars.put("SeasonSegment", "");
//		vars.put("DateFrom", "");
//		vars.put("DateTo", "");
//		vars.put("OpponentTeamID", "0");
//		vars.put("VsConference", "");
//		vars.put("VsDivision", "");
//		vars.put("GameSegment", "");
//		vars.put("Period", "0");
//		vars.put("ShotClockRange", "");
//		vars.put("LastNGames", "0");

//		System.out.println(util.getJson("playerdashboardbyshootingsplits", vars));
//		System.out.println(util.getJson("playerdashboardbygeneralsplits", vars));
//		System.out.println(util.getJson("teamdashboardbygeneralsplits", vars));

		// play by play
//		Map<String, String> vars = new HashMap<>();
//		vars.put("GameID", "0021600989");
//		vars.put("StartPeriod", "0");
//		vars.put("EndPeriod", "0");
//
//		System.out.println(util.getJson("playbyplay", vars));

		// shotcharts
//		Map<String, String> vars = new HashMap<>();
//		vars.put("PlayerID", "2544");     //bz
//		vars.put("PlayerID", "0");
//		vars.put("TeamID", "0");          // bz
//		vars.put("TeamID", "1610612739");
//		vars.put("GameID", "0021501195");   // bz
//		vars.put("GameID", "");
//		vars.put("LeagueID", "00");
//		vars.put("Season", "2014-15");
//		vars.put("SeasonType", "Regular Season");
//		vars.put("Outcome", "");
//		vars.put("Location", "");
//		vars.put("Month", "0");
//		vars.put("SeasonSegment", "");
//		vars.put("DateFrom", "");
//		vars.put("DateTo", "");
//		vars.put("OpponentTeamID", "0");
//		vars.put("VsConference", "");
//		vars.put("VsDivision", "");
//		vars.put("PlayerPosition", "");
//		vars.put("GameSegment", "");
//		vars.put("Period", "0");
//		vars.put("LastNGames", "0");
//		vars.put("AheadBehind", "");
//		vars.put("ContextMeasure", "FGM");
//		vars.put("ClutchTime", "");
//		vars.put("RookieYear", "");

//		System.out.println(util.getJson("shotchartdetail", vars));
//		output(util.getResultAsString("shotchartdetail", vars));

//		output(playerUtil.getShotcharts("2544", "2014-15"));
//		output(teamUtil.getShotcharts("1610612739", "2014-15", "Regular Season"));
	}

}
