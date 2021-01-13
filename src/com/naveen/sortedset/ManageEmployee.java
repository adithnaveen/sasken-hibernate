package com.naveen.sortedset;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class ManageEmployee {
	public static void main(String[] args) {
		ManageEmployee me = new ManageEmployee();
		me.listAllEmployees();
	}
	
	public void listAllEmployees(){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		
		tx = session.beginTransaction();
		List<Employee1> employees = session.createQuery("FROM com.naveen.sortedset.Employee1").list();
		
		Iterator<Employee1> itr = employees.iterator();
		
		while(itr.hasNext()){
			Employee1 emp = itr.next();
			
			System.out.println("Emp Name is " + emp.getfName() +", "+ emp.getlName());
			System.out.println("Emp Salary is " + emp.getSalary());
			
			SortedSet certificates = emp.getCertificates1();
			
			Iterator<Certificate1> itr1 = certificates.iterator();
			
			while(itr1.hasNext()){
				Certificate1 c = itr1.next();
				
				System.out.println(c.getName());
			}
			
			
			
			
		}
		
	}
	
}
