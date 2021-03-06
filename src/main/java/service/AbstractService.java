package service;


import db.HibernateUtil;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractService<T> {

	private Class<T> clazz;

	public AbstractService() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T find(final Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T t = session.get(clazz, id);
		session.close();
		return t;
	}

	public List<T> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> list = session.createQuery("from " + clazz.getName()).list();
		return list;
	}

	public T add(T t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(t);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	public T update(T t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();
		return t;
	}

}
