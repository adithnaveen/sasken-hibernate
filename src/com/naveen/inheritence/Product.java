package com.naveen.inheritence;

public class Product {
	private int pId;
	private String pName;
	private String pDesc;
	private double pPrice;
	
	public Product(){
		
	}

	public Product(String pName, String pDesc, double pPrice) {
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}


	public void  printInfo() {
		System.out.println("Product [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc
				+ ", pPrice=" + pPrice + "]");
	}
	
	
	
	
	
	
	
}
