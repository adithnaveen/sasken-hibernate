package com.naveen;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class EmployeeImpl {
	private static SessionFactory factory;
//	private static SessionFactory sessionFactory;
	//private static ServiceRegistry serviceRegistry;
	
	
	public static void main(String[] args) {
		try {
			// if you dont specify any value for configure method by default it will 
			// refer to hibernate.cfg.xml
			
//			factory = new Configuration().configure().buildSessionFactory();

			factory = HibernateUtil.getFactory();
			System.out.println("Factory constructed... ");
//			serviceRegistry = new ServiceRegistryBuilder().applySettings(
//		            new Configuration().configure("hibernate1.cfg.xml").getProperties()).build();
//		
		    
		 /*   serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    */
//		    sessionFactory = new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory(serviceRegistry);

		     EmployeeImpl empImpl = new EmployeeImpl();
			// System.out.println("Employee inserted is " + empImpl.addEmployee(102, "Kanchan", 2212));
			
			 empImpl.getAllEmployee();
			// empImpl.updateEmployee(1, 3343);
			//empImpl.delete(2);
			
		  //   empImpl.getEmployee(123);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void getEmployee(int empId){
		Session session = factory.openSession();
		Employee temp;
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
///			temp = (Employee) session.get(Employee.class, empId);
			temp = (Employee) session.load(Employee.class, empId);
			
			System.out.println("Empid Name is " + temp.getEmpName());
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
	
	public Integer addEmployee(int empId, String empName, int salary){
		Session session = factory.openSession();
		
		Transaction tx = null;
		Integer employeeId = null;
		try {
			tx = session.beginTransaction();
			Employee e = new Employee(empId, empName, salary);
			// when you say save the object gets persisted 
			employeeId =(Integer) session.save(e);
			// the value will be saved only on commit 
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeeId;
	}
	
	
	
	public void getAllEmployee(){
		Session session = factory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			List employees = session.createQuery("FROM com.naveen.Employee").list();
			
			
			Iterator<Employee> newItr = employees.iterator();
			while(newItr.hasNext()){
				System.out.println(newItr.next().toString());
			}
			
			
			for(Iterator itr = employees.iterator(); itr.hasNext();){
				Employee temp = (Employee) itr.next();
				
				System.out.println("Emp Id is "  + temp.getEmpId() +"\nEmp Name is " + 
						temp.getEmpName() +"\nEmp Salary is " + temp.getSalary());
			}
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee(int empId, int salary){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Employee temp = (Employee) session.get(Employee.class, empId);
			temp.setSalary(salary);
			tx.commit();
			getAllEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void delete(int empId){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empId);
			System.out.println(employee);
			session.delete(employee);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Sorry Employee not found " + e );
		}
	}
}
	
	
	
	
