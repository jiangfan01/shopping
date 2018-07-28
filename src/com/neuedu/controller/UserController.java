package com.neuedu.controller;

import java.util.Scanner;

import com.neuedu.model.User;
import com.neuedu.service.UserService;

public class UserController {
	UserService us = new UserService();
	Scanner in = new Scanner(System.in);
	public void register() {
		System.out.println("------------注册界面------------");
		String username = "";
		while(true) {
			System.out.println("用户名：");
			username = in.nextLine();
			if(us.checkUser(username)) {
				System.out.println("该用户名已存在，请重新输入！");
			}
			break;
		}
		String password = "";
		while(true) {
			System.out.println("密码：");
			password = in.nextLine();
			System.out.println("确认密码：");
			String pwd = in.nextLine();
			if(password.equals(pwd)) {
				break;
			}
			System.out.println("两次密码输入的不一致，请重新输入!");
		}
		System.out.println("联系方式：");
		String phone = in.nextLine();
		System.out.println("emil:");
		String emil = in.nextLine();
		User user = new User(username, password, phone, emil);
		if(us.register(user)) {
			System.out.println("注册成功！");
			System.out.println("是否进入登陆界面？(y/n)");
			String c = in.nextLine();
			if("y".equals(c)) {
				login();
			}
		}else{
			System.out.println("发生未知错误，注册失败！");
		}
	}
	
	
	public void login() {
		System.out.println("------------登陆界面------------");
		System.out.println("用户名：");
		String username = in.nextLine();
		System.out.println("密码：");
		String password = in.nextLine();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(us.login(user)) {
			System.out.println("登陆成功！欢迎" + user.getUsername() + "!");
		}else {
			System.out.println("用户名或密码错误！登陆失败！");
		}
		
	}
		

}
