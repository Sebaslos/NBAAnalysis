package service;

public class TestService {

	public <T> T add(T t) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(t);
//		session.getTransaction().commit();
//		session.close();
		return t;
	}

	/*
	public void insertData() {
		// set player
		Player player = new Player();
		player.setId(2544L);
		player.setName("LeBron James");
		player.setFirstPosition("Forward");
		add(player);

		// set team
		Team team = new Team();
		team.setId(234355L);
		team.setName("Cavaliers");
		add(team);

		Team team2 = new Team();
		team2.setId(234356L);
		team2.setName("Thunder");
		add(team2);

		// set shot zone
		ShotZone zone = new ShotZone();
		zone.setArea("center");
		zone.setRanges("8 FT");
		zone.setTitle("center 8 FT");
		add(zone);

		ShotZone zone1 = new ShotZone();
		zone1.setArea("center");
		zone1.setRanges("8-16 FT");
		zone1.setTitle("center 8-16 FT");
		add(zone1);

		ShotZone zone2 = new ShotZone();
		zone2.setArea("center");
		zone2.setRanges("16-24 FT");
		zone2.setTitle("center 16-24 FT");
		add(zone2);

		ShotZone zone3 = new ShotZone();
		zone3.setArea("center");
		zone3.setRanges("24 FT+");
		zone3.setTitle("center 24 FT+");
		add(zone3);

		ShotZone zone4 = new ShotZone();
		zone4.setArea("left side");
		zone4.setRanges("8-16 FT");
		zone4.setTitle("left side 8-16 FT");
		add(zone4);

		ShotZone zone5 = new ShotZone();
		zone5.setArea("left side");
		zone5.setRanges("16-24 FT");
		zone5.setTitle("left side 16-24 FT");
		add(zone5);

		zone = new ShotZone();
		zone.setArea("left side");
		zone.setRanges("24 FT+");
		zone.setTitle("left side 24 FT+");
		add(zone);

		zone = new ShotZone();
		zone.setArea("left center");
		zone.setRanges("16-24 FT");
		zone.setTitle("left center 16-24 FT");
		add(zone);

		zone = new ShotZone();
		zone.setArea("left center");
		zone.setRanges("24 FT+");
		zone.setTitle("left center 24 FT+");
		add(zone);

		zone = new ShotZone();
		zone.setArea("right side");
		zone.setRanges("8-16 FT");
		zone.setTitle("right side 8-16 FT");
		add(zone);

		zone = new ShotZone();
		zone.setArea("right side");
		zone.setRanges("16-24 FT");
		zone.setTitle("right side 16-24 FT");
		add(zone);

		zone = new ShotZone();
		zone.setArea("right side");
		zone.setRanges("24 FT+");
		zone.setTitle("right side 24 FT+");
		add(zone);

		zone = new ShotZone();
		zone.setArea("right center");
		zone.setRanges("16-24 FT");
		zone.setTitle("right center 16-24 FT");
		add(zone);

		zone = new ShotZone();
		zone.setArea("right center");
		zone.setRanges("24 FT+");
		zone.setTitle("right center 24 FT+");
		add(zone);


		// set shot type
		ShotType type = new ShotType();
		type.setType("Alley Oop");
		add(type);

		ShotType type1 = new ShotType();
		type1.setType("Bank Shot");
		add(type1);

		ShotType type2 = new ShotType();
		type2.setType("Dunk");
		add(type2);

		ShotType type3 = new ShotType();
		type3.setType("Fadeaway");
		add(type3);

		ShotType type4 = new ShotType();
		type4.setType("Finger Roll");
		add(type4);

		ShotType type5 = new ShotType();
		type5.setType("Hook Shot");
		add(type5);

		type = new ShotType();
		type.setType("Jump Shot");
		add(type);

		type = new ShotType();
		type.setType("Layup");
		add(type);

		type = new ShotType();
		type.setType("Tip Shot");
		add(type);

		// set season
		Season season = new Season();
		season.setId(123L);
		season.setTitle("2014-15");
		season.setType("Regular season");
		add(season);

		// set game
		Game game = new Game();
		game.setId(233L);
		game.setDate(new Date());
		game.setHtm(team);
		game.setVtm(team2);
		game.setSeason(season);
		game.setHtmPoints(124);
		game.setVtmPoints(112);
		add(game);

		// set shot
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
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type1);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
//		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type2);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type4);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type2);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type1);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type1);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type2);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type3);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type4);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type5);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type2);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type2);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type1);
		shot.setShotZone(zone2);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type4);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(false);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type3);
		shot.setShotZone(zone3);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type3);
		shot.setShotZone(zone5);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type4);
		shot.setShotZone(zone5);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);

		shot = new Shot();
		shot.setPlayer(player);
		shot.setTeam(team);
		shot.setGame(game);
		shot.setShotType(type5);
		shot.setShotZone(zone4);
		shot.setPosX(13);
		shot.setPosY(23);
		shot.setDistance(7);
		shot.setTime(new Date());
		shot.setMade(true);
		add(shot);
	}
	*/

}
