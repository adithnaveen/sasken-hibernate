package com.naveen.createquery;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class EmployeeScalarQuery {
	public static void main(String[] args) {
		EmployeeScalarQuery sc = new EmployeeScalarQuery();
		sc.listEmployees();
	}
	
	public void listEmployees(){
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String sql="select empName, empSal from employee11";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List list = query.list();
		
		for(Object obj : list){
			Map map = (Map)obj;
			
			System.out.println("Name is " + map.get("empName"));
			System.out.println("Salary is " + map.get("empSal"));
		}
	}
	
	
}
