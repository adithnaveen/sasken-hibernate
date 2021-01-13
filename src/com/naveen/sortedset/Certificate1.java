package com.naveen.sortedset;

public class Certificate1 implements Comparable<Certificate1> {
	private int id;
	private String name;

	public Certificate1(){}
	public Certificate1(String name) {
		this.setName(name);
	}

	@Override
	public int compareTo(Certificate1 arg0) {
		return this.name.compareTo(arg0.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
