package com.javalec.Dto;

public class productList_Dto {
	
	//Field
	int pId;
	String pName;
	int pPrice;
	String pColor;
	
	//Constructor
	public productList_Dto() {
		
	}
	

	public productList_Dto(int pId, String pName, int pPrice, String pColor) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pColor = pColor;
	}
	

	public productList_Dto(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}

	//Method

	
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


	public int getpPrice() {
		return pPrice;
	}


	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public String getpColor() {
		return pColor;
	}


	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	
	

}
	
