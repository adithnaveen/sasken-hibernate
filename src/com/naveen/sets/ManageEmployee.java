package com.naveen.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.utils.HibernateUtil;

public class ManageEmployee {
	private static SessionFactory factory;
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		ManageEmployee me = new ManageEmployee();
		HashSet certificates = new HashSet();
		certificates.add(new Certificate("PMP"));
		certificates.add(new Certificate("BCA"));
		certificates.add(new Certificate("O Level"));
		certificates.add(new Certificate("M.Tech"));
		
		
		System.out.println("insertion " + me.addEmployee("Vinod", "K", 2212, certificates));
		me.listAllEmployees();
		
	}
	
	
	public Integer addEmployee(String fName, String lName, int salary, Set cert){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer empId = null;
		
		try {
			tx = session.beginTransaction();
			Employee emp = new Employee(fName, lName, salary);
			emp.setCertificates(cert);
			empId = (Integer) session.save(emp);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return empId;
	}
	
	public void listAllEmployees(){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		
		
		try {
			tx = session.beginTransaction();
			List empList = session.createQuery("FROM Employee").list();
			
			Iterator<Employee> itr = empList.iterator();
			
			while(itr.hasNext()){
				Employee temp = itr.next();
				System.out.println("Employee Id is " + temp.getEmpId());
				System.out.println("Employee Name is " + temp.getFirstName() +","+ temp.getLastName());
				System.out.println("Employee Salary is " + temp.getSalary());
				Set certificates = temp.getCertificates();
				
				for(Iterator<Certificate> itr1 = certificates.iterator(); itr1.hasNext();){
					Certificate cert = itr1.next();
					System.out.println("\t\tCertificate Name is " + cert.getName()) ;
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
				
	}
	
	
	void updateEmployee(int empId, int salary){
		// refer code in com.naveen.employeeImpl	
	}
	
	void deleteEmployee(int empId){
		// refer code in com.naveen.employeeImpl		
	}
	
	
	
	
	
	
	
	
	
	
	
}
