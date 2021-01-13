package com.naveen.querylanguage;

import java.util.List;

//import net.sf.ehcache.search.expression.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;
import com.naveen.Employee;

public class EmployeeQueries {
	public static void main(String[] args) {
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = null;
		
		tx = session.beginTransaction();

		
		// list of queries
//		String hql = "FROM Employee";
//		String hql = "FROM com.naveen.Employee";
//		String hql = "FROM com.naveen.Employee  e";
		
		//order by
		//String hql = "FROM Employee e where e.salary>1000 order by e.empName desc, e.salary desc";

		
		// named query 
		String hql = "FROM Employee e where e.salary >:mysal";

		
		
		Query query = session.createQuery(hql);
		query.setParameter("mysal", 2000);
		List<Employee> resultList  = query.list();
		
		for(Employee temp : resultList){
		
			System.out.println("Empid is " + temp.getEmpId() +", Emp Name is " + temp.getEmpName() +", Emp Salary is " + temp.getSalary());
		}

		System.out.println("--------------------------------------");
		
//		hql = "select E.empName FROM Employee  E";
		hql = "select E.empName FROM Employee  E where empName= 'kumar'";
		List resultList1  = session.createQuery(hql).list();
	
		
		for(Object temp : resultList1){
			
			System.out.println("Empid is " + temp.toString());// +", Emp Name is " + temp.getEmpName() +", Emp Salary is " + temp.getSalary());
		}
	
		
		// pagination
		hql ="FROM Employee order by salary desc";
		query = session.createQuery(hql);
		query.setFirstResult(2);
		query.setMaxResults(5);
		List<Employee> resultList2 = query.list();
		
		// pagination
		System.out.println("-----------pagination---------");
		
		for(Employee temp : resultList2){
			System.out.println(temp.getEmpName());
		}
		
		System.out.println("pagination using criteria");
		
		// pagination using criteria
		org.hibernate.Criteria ccr = session.createCriteria(Employee.class);
		ccr.setFirstResult(1);
		ccr.setMaxResults(4);
		List<Employee> results = ccr.list();
		
		for(Employee temp : results){
			System.out.println(temp);
		}
		
		

		
	}
}
