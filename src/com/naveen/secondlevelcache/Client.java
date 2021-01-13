package com.naveen.secondlevelcache;

import org.hibernate.Session;

import com.hibernate.utils.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		Client c = new Client();
		c.storeData();

		System.out.println("stored country");
	}
	
	public void storeData(){
		
		Session session =HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Country c = new Country();
		c.setCountryId(101);
		c.setCountryName("India");
		
		session.save(c);
		session.getTransaction().commit();
		
		
	}
}
