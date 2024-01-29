package com.javalec.Dto;

public class productList_Dto {
	
	//Field
	int pId;
	String pName;
	int pPrice;
	String pColor;
	String pImgPath;
	
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
	

	public productList_Dto(int pId, String pName, String pImgPath) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pImgPath = pImgPath;
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


	public String getpImgPath() {
		return pImgPath;
	}


	public void setpImgPath(String pImgPath) {
		this.pImgPath = pImgPath;
	}
	
	

}
	
