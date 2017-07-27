package service;


import db.HibernateUtil;
import model.Team;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class TeamService extends AbstractService<Team> {

	public List get3PointShotTrend() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"Team.name, " +
				"month(Game.date) month, Game.date, " +
				"COUNT(if(Shot.distance < 24, null, 1)) AS attemp3, " +
				"COUNT(Shot.id) AS attemptSum " +
				"FROM " +
				"Shot, Team, Game, Season " +
				"WHERE " +
				"    Shot.game_id = Game.id AND " +
				"    Shot.team_id = Team.id AND " +
				"	 Team.name = 'Cavaliers' AND " +
				"    Game.season_id = Season.id AND " +
				"    Season.title = '2014-15' AND " +
				"	 Season.type = 'Regular Season' " +
				"GROUP BY " +
				"    Team.name, month(Game.date), Game.date " +
				"WITH ROLLUP";

		NativeQuery query = session.createNativeQuery(sql);
		List list = query.getResultList();
		session.close();
		return list;
	}

	public List get3PointShotTrend(String teamName, String season, String seasonType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"	month(Game.date) month, Game.date, " +
				"	COUNT(if(ShotZone.ranges = '24 FT+', 1, NULL)) AS attemp3, " +
				"	COUNT(Shot.id) AS attemptSum " +
				"FROM " +
				"	Shot, ShotZone, Team, Game, Season " +
				"WHERE " +
				"   Shot.game_id = Game.id AND " +
				"   Shot.team_id = Team.id AND " +
				"   Shot.zone_id = ShotZone.id AND " +
				"	Team.name = :teamName AND " +
				"   Game.season_id = Season.id AND " +
				"   Season.title = :season AND " +
				"	Season.type = :seasonType " +
				"GROUP BY " +
				"   month(Game.date), Game.date " +
				"WITH ROLLUP";

		NativeQuery query = session.createNativeQuery(sql)
				.setParameter("teamName", teamName)
				.setParameter("season", season)
				.setParameter("seasonType", seasonType);
		List list = query.getResultList();
		session.close();
		return list;
	}

	public List get3PointShotZone(String teamName, String season, String seasonType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT " +
				"	title, madeNum, attemptNum, " +
				"   round(ifnull(madeNum/attemptNum, 0)*100, 1) AS quote " +
				"FROM ( " +
				"SELECT  " +
				"   ShotZone.title, " +
				"   COUNT(if(isMade = 1, 1, NULL)) AS madeNum, " +
				"   COUNT(Shot.id) AS attemptNum " +
				"FROM  " +
				"	Shot, ShotZone, Team, Game, Season " +
				"WHERE " +
				"   Shot.game_id = Game.id AND " +
				"   Shot.team_id = Team.id AND " +
				"   Shot.zone_id = ShotZone.id AND " +
				"   ShotZone.ranges = '24 FT+' AND " +
				"   Team.name = :teamName AND  " +
				"   Game.season_id = Season.id AND " +
				"   Season.title = :season AND " +
				"	Season.type = :seasonType " +
				"GROUP BY " +
				"	ShotZone.title " +
				"WITH ROLLUP " +
				") AS T;";

		NativeQuery query = session.createNativeQuery(sql)
				.setParameter("teamName", teamName)
				.setParameter("season", season)
				.setParameter("seasonType", seasonType);
		List list = query.getResultList();
		session.close();
		return list;
	}

}
