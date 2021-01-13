package com.naveen.inheritence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		Product products[]={
				
				new Television(22, "LCD", "90000", "LG", "FULL HD", 4480),
				new Television(41, "LED", "290000", "LG", "FULL HD", 44870),
				new Cellphone("Smart", "ios", "GSM", "mobile", "hand Device", 2000),
				new Cellphone("Smart", "Android", "GSM", "mobile", "hand Device", 2000)
		};

		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		for(Product temp : products ){
			session.save(temp);
			
		}
		
		tx.commit();
		
		System.out.println("Products Saved");
	}
}
