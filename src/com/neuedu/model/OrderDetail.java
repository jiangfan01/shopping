package com.neuedu.model;

public class OrderDetail {
	private int odid;
	private int oid;
	private int pid;
	private int pnum;
	
	public OrderDetail() {}
	@Override
	public String toString() {
		return "OrderDetail [odid=" + odid + ", oid=" + oid + ", pid=" + pid + ", pnum=" + pnum + "]";
	}
	public OrderDetail(int oid, int pid, int pnum) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.pnum = pnum;
	}
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	
	
}
