package com.naveen.manytoone;



/*
 * many to one refer changes in Customer.hbm.xml 
 * for one to one relationship just make the property as uniq
 * for one to many relationship you can achieve the same with set which 
 * we have learnt earlier
 */
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class ManyToOneImplementation {
	public static void main(String[] args) {
		
		ManyToOneImplementation m = new ManyToOneImplementation();
		
		
		Address a = new Address("test", "Beng", "Karnataka", "560052");
		
		m.addAddress(a);
		Customer c = new Customer("Naveen", "Kumar", 10000, a);
		Customer c1 = new Customer("Kanchan", "Naveen", 2000, a);
		m.insertCustomer(c);
		m.insertCustomer(c1);
	}
	
	
	public void addAddress(Address address){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		Integer addressId = null;
		try{
			tx = session.beginTransaction();
			addressId = (Integer) session.save(address);
			
			tx.commit();
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("Address id created is " + addressId);
		session.close();
	}
	
	public void insertCustomer(Customer c){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		Integer custId = null;
		
		try {
			tx = session.beginTransaction();
			custId = (Integer) session.save(c);
			tx.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("Customer id created is " + custId);
		
	}
	
	
}
