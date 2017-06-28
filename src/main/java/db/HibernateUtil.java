package db;


import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static boolean isSessionfactoryCreated;
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		if (!isSessionfactoryCreated) {
			try {
				Configuration configuration = new Configuration();
				configuration.addAnnotatedClass(Game.class);
				configuration.addAnnotatedClass(Player.class);
				configuration.addAnnotatedClass(Season.class);
				configuration.addAnnotatedClass(Shot.class);
				configuration.addAnnotatedClass(ShotType.class);
				configuration.addAnnotatedClass(ShotZone.class);
				configuration.addAnnotatedClass(Team.class);
				configuration.configure(getHibernateCfg());

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				if (sessionFactory != null) {
					isSessionfactoryCreated = true;
				}
			} catch (Throwable e) {
				System.err.println("Initial SessionFactory creation failed.\n" + e);
				e.printStackTrace();
				throw new ExceptionInInitializerError(e);
			}
		}

		return sessionFactory;
	}

	private static String getHibernateCfg() {
		return "hibernate.cfg.xml";
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
