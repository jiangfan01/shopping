package com.neuedu.model;

public class Order {
	private int oid;
	private String ordernum;
	private int userid;
	private String phone;
	public Order(String ordernum, int userid, String phone, String orderaddress, String ordername) {
		super();
		this.ordernum = ordernum;
		this.userid = userid;
		this.phone = phone;
		this.orderaddress = orderaddress;
		this.ordername = ordername;
	}
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordernum=" + ordernum + ", userid=" + userid + ", phone=" + phone
				+ ", orderaddress=" + orderaddress + ", ordername=" + ordername + "]";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String orderaddress;
	private String ordername;
	
	public Order() {}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
}
