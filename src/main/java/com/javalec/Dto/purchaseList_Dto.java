package com.javalec.Dto;

public class purchaseList_Dto {
	
	//Field
	String pName;
	String mId;
	int pId;
	int pQty;
	String pDate;
	
	
	
	//Constructor
	public purchaseList_Dto() {
		
	}

	
	

	public purchaseList_Dto(String pName, String mId, int pId, int pQty, String pDate) {
		super();
		this.pName = pName;
		this.mId = mId;
		this.pId = pId;
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
	
		
}
