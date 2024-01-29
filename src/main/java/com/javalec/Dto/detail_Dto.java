package com.javalec.Dto;

public class detail_Dto {
	
	// Field
	int pid;
	String pname;
	int pprice;
	String pcolor;
	String pcontent;
	String pimgpath;
	int seq;
	String psize;
	String pqty;

	// Constructor
	public detail_Dto(int pid, String pname, int pprice, String pcolor, String pcontent, String pimgpath, int seq,
			String psize, String pqty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pcolor = pcolor;
		this.pcontent = pcontent;
		this.pimgpath = pimgpath;
		this.seq = seq;
		this.psize = psize;
		this.pqty = pqty;
	}

	// Method
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public String getPqty() {
		return pqty;
	}

	public void setPqty(String pqty) {
		this.pqty = pqty;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPimgpath() {
		return pimgpath;
	}

	public void setPimgpath(String pimgpath) {
		this.pimgpath = pimgpath;
	}

}
