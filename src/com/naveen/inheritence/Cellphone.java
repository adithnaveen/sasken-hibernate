package com.naveen.inheritence;

public class Cellphone extends Product{
	private String type;		// ordinary or smart
	private String os;		// iOS, Windows, Android
	private String connectivity; 	//GSM, CDMA;
	
	
	
	
	public Cellphone() {
	}
	public Cellphone(String type, String os, String connectivity, String pName, String pDesc, double pPrice) {
		super(pName, pDesc, pPrice);
		this.type = type;
		this.os = os;
		this.connectivity = connectivity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getConnectivity() {
		return connectivity;
	}
	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println( "Cellphone [type=" + type + ", os=" + os + ", connectivity="
				+ connectivity + "]");
	}
}
