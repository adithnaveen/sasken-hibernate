package com.naveen.list;

import java.util.List;

public class University {
	private int uid;
	private String name;
	private String state;
	private List colleges;
	

	
	public University(){}
	public University(String name, String state) {
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List getColleges() {
		return colleges;
	}
	public void setColleges(List colleges) {
		this.colleges = colleges;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
