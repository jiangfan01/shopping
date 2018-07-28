package com.neuedu.model;

public class ProType {
	private int ptid;
	private String typename;
	
	public ProType() {}
	public ProType(String typename) {
		super();
		this.typename = typename;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
