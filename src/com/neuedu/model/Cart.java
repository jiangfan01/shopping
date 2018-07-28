package com.neuedu.model;

public class Cart {
	private int cid;
	private int userid;
	private int pid;
	private int pnum;
	private double totalprice;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Cart(int userid, int pid, int pnum, double totalprice) {
		super();
		this.userid = userid;
		this.pid = pid;
		this.pnum = pnum;
		this.totalprice = totalprice;
	}
	public Cart() {}
}
