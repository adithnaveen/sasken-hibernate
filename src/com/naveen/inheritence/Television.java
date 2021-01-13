package com.naveen.inheritence;

public class Television extends Product {
	private int size;			// in inches
	private String screenType;		// LED, LCD, PLASMA
	private String resolution;
	
	

	public Television() {
	}

	public Television(int size, String screenType, String resolution, String pName, String pDesc, double pPrice) {
		super(pName, pDesc, pPrice);
		this.size = size;
		this.screenType = screenType;
		this.resolution = resolution;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	
	public void  printInfo() {
		super.printInfo();
		System.out.println("Television [size=" + size + ", screenType=" + screenType
				+ ", resolution=" + resolution + "]");
	}	
}

