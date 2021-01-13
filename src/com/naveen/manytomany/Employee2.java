package com.naveen.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Employee2 {
	private int empId;
	private String fName;
	private String lName;
	private double salary;
	private Set<Certificate2> certificates = new HashSet<Certificate2>();

	public Employee2(){}
	public Employee2(String fName, String lName, double salary) {
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
	}

	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Set<Certificate2> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<Certificate2> certificates) {
		this.certificates = certificates;
	}


}
