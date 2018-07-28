package com.neuedu.model;

public class Product {
	private int pid;
	private String pname;
	private String pdesc;
	private double price;
	private int stock;
	private int ptid;
	
	public Product() {}
	public Product(String pname, String pdesc, double price, int stock, int ptid) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.price = price;
		this.stock = stock;
		this.ptid = ptid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", price=" + price + ", stock=" + stock
				+ ", ptid=" + ptid + "]";
	}
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
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
}
