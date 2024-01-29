package com.javalec.Dto;

public class aProduct_Dto {
	
	int pId;
	String pName;
	String pColor;
	String pPrice;
	int pSize;
	int pQty;
	
	
	public aProduct_Dto() {
		
	}

	public aProduct_Dto(int pId, String pName, String pColor, String pPrice) {
		this.pId = pId;
		this.pName = pName;
		this.pColor = pColor;
		this.pPrice = pPrice;
	}
	
	public aProduct_Dto(int pId, String pName, String pColor, String pPrice, int pSize, int pQty) {
		this.pId = pId;
		this.pName = pName;
		this.pColor = pColor;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pQty = pQty;
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

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	
	

}
