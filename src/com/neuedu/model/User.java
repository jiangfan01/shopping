package com.neuedu.model;

public class User {
	private int userid;
	private String username;
	private String password;
	private String phone;
	private String emil;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmil() {
		return emil;
	}
	public void setEmil(String emil) {
		this.emil = emil;
	}
	public User(String username, String password, String phone, String emil) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.emil = emil;
	}
	public User() {}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
