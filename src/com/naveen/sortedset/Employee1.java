package com.naveen.sortedset;

import java.util.SortedSet;

public class Employee1 {
	private int id;
	private String fName;
	private String lName;
	private double salary;
	private SortedSet certificates1;
	
	public Employee1() {
		
	}

	public Employee1(String fName, String lName, double salary) {
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public SortedSet getCertificates1() {
		return certificates1;
	}

	public void setCertificates1(SortedSet certificates1) {
		this.certificates1 = certificates1;
	}

}
