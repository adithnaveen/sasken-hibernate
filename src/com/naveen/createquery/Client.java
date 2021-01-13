package com.naveen.createquery;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.hibernate.utils.HibernateUtil;
import com.naveen.Employee;

public class Client {
	public static void main(String[] args) {
		Criteria cr = HibernateUtil.getFactory().openSession().createCriteria(Employee.class);
		
//		cr.add(Restrictions.eq("salary", 2222));
//		cr.add(Restrictions.ge("salary", 3222));
//		cr.add(Restrictions.like("empName", "%cott%"));
//		cr.add(Restrictions.between("salary", 2222, 3333));
//		cr.add(Restrictions.isNull("salary"));
//		cr.add(Restrictions.isNotNull("salary"));
		
		List<Employee> list = cr.list();
		
		for(Employee temp : list){
			System.out.println(temp.getEmpId() +", " + temp.getEmpName() +", " + temp.getSalary());
		}
		System.out.println("----------------------------------------------------");
		
		/// you can create and or condition 
		Criterion salary = Restrictions.gt("salary", 2322);
		Criterion name = Restrictions.like("empName", "nave%");
		
//		LogicalExpression orExp = Restrictions.or(salary, name);
//		cr.add(orExp);

		LogicalExpression andExp = Restrictions.and(salary, name);
		cr.add(andExp);

		List<Employee> list1 =cr.list();
		
		for(Employee temp : list1){
			System.out.println(temp.getEmpId() +", " + temp.getEmpName() +", " + temp.getSalary());

		}
		
		
		
		
		
	}
}
