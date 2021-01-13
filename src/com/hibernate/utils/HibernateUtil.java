package com.hibernate.utils;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	static SessionFactory factory = null;
	public static SessionFactory getFactory(){
		  return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//		 Configuration configuration  = new Configuration().configure();
		
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//					applySettings(configuration.getProperties());
		
		// SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
		// return factory;
	}
	
	public static SessionFactory getFactory(String fileName){
		  return new Configuration().configure(fileName).buildSessionFactory();

		// Configuration configuration  = new Configuration().configure(fileName);
		
	//	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	//				applySettings(configuration.getProperties());
		
		// SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
		//return factory;
	}
	
	
}
