package com.naveen.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class UniversityImplementation {
	
	public static void main(String[] args) {
		UniversityImplementation ui = new UniversityImplementation();
		
		
		ArrayList<College> colleges = new ArrayList<College>();
		colleges.add(new College("ABC"));
		colleges.add(new College("BMS"));
		colleges.add(new College("PES"));
		
		
	//	ui.insertUniversity("MANGALURU", "Karnatka", colleges);
		ui.listAll();
	}
	
	public void insertUniversity(String name, String state, ArrayList<College> college){
		Session session = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = null;
		Integer univID = null;
		
		try{
			tx = session.beginTransaction();
			
			University univ = new University(name, state);
			univ.setColleges(college);
			univID = (Integer) session.save(univ);
			
			tx.commit();
				
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("university added is "  + univID);		
		session.close();
	}
	
	public void listAll(){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		List<University> univList = session.createQuery("FROM University").list();
		
		try{
			tx = session.beginTransaction();
			Iterator<University> itr = univList.iterator();
			
			while(itr.hasNext()){
				University temp = itr.next();
				
				System.out.println("university Name is " + temp.getName());
				System.out.println("State is " + temp.getState());
				Iterator<College> itr1 = temp.getColleges().iterator();
				
				while(itr1.hasNext()){
					College col = itr1.next();
					System.out.println(col.getCollegeName());
				}
			}
			tx.commit();
		}catch(Exception e){
			System.out.println("-----------" + e);
		}
		session.close();
	}
}
