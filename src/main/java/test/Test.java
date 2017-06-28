package test;


import db.HibernateUtil;
import model.*;
import nbadatautils.DataImportUtil;
import nbadatautils.NBADataUtil;
import nbadatautils.PlayerDataUtil;
import nbadatautils.TeamDataUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

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

	public static void main(String[] args) {
//		init();
//		TestService service = new TestService();
//		service.insertData();

//		show();

		importData();

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
//		System.out.println(playerUtil.getPlayerInfo("201935"));
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
//		vars.put("Season", "2013-14");
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
	}

}
