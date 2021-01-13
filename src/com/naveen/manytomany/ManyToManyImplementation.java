package com.naveen.manytomany;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class ManyToManyImplementation {
	public static void main(String[] args) {
		ManyToManyImplementation mtm = new ManyToManyImplementation();
		
		HashSet certificates = new HashSet();
		certificates.add(new Certificate2("BCA"));
		certificates.add(new Certificate2("M.Tech"));
		certificates.add(new Certificate2("PGDCA"));
		
		
		Employee2 emp = new Employee2("Naveen", "Kumar", 4444);
		emp.setCertificates(certificates);
		
		mtm.addEmployee(emp);
	}
	
	
	public void addEmployee(Employee2 emp){
		Session session = HibernateUtil.getFactory().openSession();
		// session.beginTransaction();
		Transaction tx = null;
		Integer empId  = null;
		
		try {
			tx = session.beginTransaction();
			empId = (Integer) session.save(emp);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		System.out.println("EmpId is "  + empId);
	}
	
}
