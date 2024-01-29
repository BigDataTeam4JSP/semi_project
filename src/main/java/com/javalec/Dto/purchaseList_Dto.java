package com.javalec.Dto;

public class purchaseList_Dto {
	
	//Field
	String pName;
	String pColor;
	String mId;
	int cSize;
	int pQty;
	String pDate;
	
	//Constructor
	public purchaseList_Dto() {
		
	}

	public purchaseList_Dto(String pName, String pColor, String mId, int cSize, int pQty, String pDate) {
		super();
		this.pName = pName;
		this.pColor = pColor;
		this.mId = mId;
		this.cSize = cSize;
		this.pQty = pQty;
		this.pDate = pDate;
	}

	// Method
	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getcSize() {
		return cSize;
	}

	public void setcSize(int cSize) {
		this.cSize = cSize;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	
		
}
