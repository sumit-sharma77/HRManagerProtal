package com.nagarro.hrmanagerREST.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {

	private SessionFactory sessionFactory;

	private HibernateSessionUtil() {
		try {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HibernateSessionUtil getInstance() {
		return new HibernateSessionUtil();
	}
	
	public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();
        
        return session;
    }

}
