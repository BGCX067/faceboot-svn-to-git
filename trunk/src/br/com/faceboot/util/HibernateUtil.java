package br.com.faceboot.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static Session session;

	static {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public static void geraBanco() {
		SchemaExport export = new SchemaExport(new Configuration().configure());

		export.create(true, true);
	}

	public static Session getSession() {
		if (session == null || !session.isOpen() || !session.isConnected()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
