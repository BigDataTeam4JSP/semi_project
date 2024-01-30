package com.javalec.Dto;

public class purchaseinsert_Dto {
	
	// Field
	String mid;
	int pid;
	int qty;
	int size;
	String date;
	
	// Constructor
	public purchaseinsert_Dto(String mid, int pid, int qty, int size, String date) {
		super();
		this.mid = mid;
		this.pid = pid;
		this.qty = qty;
		this.size = size;
		this.date = date;
	}

	// Method
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
