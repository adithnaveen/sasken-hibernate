package com.naveen.sets;

public class Certificate {
	private int id;
	private String name;
	
	public Certificate(){}
	public Certificate(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean equals(Object obj) {
		
		
		if (obj == null)
				return false;
		
		if(!obj.getClass().equals(obj.getClass()))
			return false;
		
		Certificate cer = (Certificate) obj;
		
			if(this.id == cer.getId() && this.name.equals(cer.getName()))
				return true;
			
		return false;
	}

	@Override
	public int hashCode() {

		int temp = 0;
		temp = (id + name).hashCode();
		return temp;
	}
	
	

	
	
}
