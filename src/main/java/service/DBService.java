package service;


import db.HibernateUtil;
import model.Season;
import model.ShotType;
import model.Team;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DBService {

	public <T> T add(T t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	public <T> T findById(Long id, Class<T> type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T object = session.get(type, id);
		session.close();
		return object;
	}

	public <T> T findByTitle(String title, Class<T> type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from " + type.getName() + " where title=:title";
		Query query = session.createQuery(hql).setParameter("title", title);
		T object = (T) query.uniqueResult();
		session.close();
		return object;
	}

	public ShotType findShotType(String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from model.ShotType where type=:type";
		Query query = session.createQuery(hql).setParameter("type", type);
		ShotType object = (ShotType) query.uniqueResult();
		session.close();
		return object;
	}

	public Season findSeason(String title, String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from model.Season where title=:title and type=:type";
		Query query = session.createQuery(hql)
						.setParameter("title", title)
						.setParameter("type", type);
		try {
			Season season = (Season) query.getSingleResult();
			session.close();
			return season;
		} catch (Exception e) {
			session.close();
			return null;
		}

	}

	public Team findTeamByAbbr(String abbr) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from model.Team t where t.abbreviation=:abbr ";
		Query query = session.createQuery(hql).setParameter("abbr", abbr);
		Team team = (Team) query.uniqueResult();
		session.close();
		return team;
	}

	public boolean isEmpty(String tablename) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from " + tablename;
		Query query = session.createQuery(hql);
		List result = query.list();

		if (result.isEmpty())
			return true;
		else
			return false;
	}

}
