package service;


import db.HibernateUtil;
import model.Player;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class PlayerService extends AbstractService<Player> {

	public List getZoneShotQuote(String playerName, String season, String seasonType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"title, madeNum, attemptNum, " +
				"round(ifnull(madeNum/attemptNum, 0)*100, 1) AS quote " +
				"FROM ( " +
				"SELECT " +
				"ShotZone.title, " +
				"COUNT(if(isMade = 1, 1, NULL)) AS madeNum, " +
				"COUNT(*) AS attemptNum " +
				"FROM  " +
				"Shot, Player, ShotZone, Game, Season " +
				"WHERE " +
				"Shot.player_id = Player.id AND " +
				"Shot.zone_id = ShotZone.id AND " +
				"Shot.game_id = Game.id AND " +
				"Game.season_id = Season.id AND " +
				"Season.title = :season AND " +
				"Season.type = :seasonType AND " +
				"Player.name = :playerName " +
				"GROUP BY " +
				"ShotZone.title " +
				"WITH ROLLUP " +
				") AS T;";

		NativeQuery query = session.createNativeQuery(sql)
				.setParameter("playerName", playerName)
				.setParameter("season", season)
				.setParameter("seasonType", seasonType);
		List list = query.getResultList();
		session.close();
		return list;
	}

	public List getTypeShotQuote(String playerName, String season, String seasonType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"type, madeNum, attemptNum, " +
				"    round(ifnull(madeNum/attemptNum, 0)*100, 1) AS quote " +
				"FROM ( " +
				"SELECT  " +
				"ShotType.type, " +
				"COUNT(if(isMade = 1, 1, NULL)) AS madeNum, " +
				"COUNT(*) AS attemptNum " +
				"FROM " +
				"Shot, Player, ShotType, Game, Season " +
				"WHERE " +
				"Shot.player_id = Player.id AND " +
				"Shot.type_id = ShotType.id AND " +
				"Shot.game_id = Game.id AND " +
				"Game.season_id = Season.id AND " +
				"Season.title = :season AND " +
				"Season.type = :seasonType AND " +
				"Player.name = :playerName " +
				"GROUP BY " +
				"ShotType.type " +
				"WITH ROLLUP " +
				") AS T;";

		NativeQuery query = session.createNativeQuery(sql)
				.setParameter("playerName", playerName)
				.setParameter("season", season)
				.setParameter("seasonType", seasonType);
		List list = query.getResultList();
		session.close();
		return list;
	}


	public List getTypeShotQuoteInZone(String playerName, String season, String seasonType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"	ShotZone.title zone," +
				"	ShotType.type, " +
				"   COUNT(if(isMade = 1, 1, NULL)) AS madeNum," +
				"   COUNT(*) AS attemptNum " +
				"FROM " +
				"	Shot, ShotType, ShotZone, Player, Game, Season " +
				"WHERE " +
				"	Shot.type_id = ShotType.id and" +
				"   Shot.zone_id = ShotZone.id and" +
				"   Shot.player_id = Player.id and" +
				"   Shot.game_id = Game.id and" +
				"   Game.season_id = Season.id and" +
				"   Player.name = :playerName and" +
				"   Season.title = :season and" +
				"   Season.type = :seasonType " +
				"GROUP BY" +
				"	ShotZone.title, ShotType.type " +
				"WITH ROLLUP " +
				"UNION " +
				"SELECT " +
				"	ShotZone.title zone," +
				"	ShotType.type, " +
				"   COUNT(if(isMade = 1, 1, NULL)) AS madeNum," +
				"   COUNT(*) AS attemptNum " +
				"FROM " +
				"	Shot, ShotType, ShotZone, Player, Game, Season " +
				"WHERE " +
				"	Shot.type_id = ShotType.id and" +
				"   Shot.zone_id = ShotZone.id and" +
				"   Shot.player_id = Player.id and" +
				"   Shot.game_id = Game.id and" +
				"   Game.season_id = Season.id and" +
				"   Player.name = :playerName and" +
				"   Season.title = :season and " +
				"   Season.type = :seasonType " +
				"GROUP BY" +
				"	ShotType.type, ShotZone.title " +
				"WITH ROLLUP;";

		NativeQuery query = session.createNativeQuery(sql)
				.setParameter("playerName", playerName)
				.setParameter("season", season)
				.setParameter("seasonType", seasonType);
		List list = query.getResultList();
		session.close();
		return list;
	}

}
