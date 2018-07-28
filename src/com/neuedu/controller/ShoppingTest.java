package com.neuedu.controller;

import java.util.Scanner;
import java.util.UUID;

import com.neuedu.model.Product;
import com.neuedu.utils.SessionUtil;

public class ShoppingTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		UserController uc = new UserController();
		
		ProTypeController ptc = new ProTypeController();
		ProductController pc = new ProductController();
		CartController cc = new CartController();
		ManagerController mc = new ManagerController();
		while(true) {
			System.out.println("**********************************");
			System.out.println("*                                *");
			System.out.println("*        欢迎打开★ ★购物商城                      *");
			System.out.println("*                                *");
			System.out.println("**********************************");
			System.out.println("请选择功能：");
			System.out.println("1、注册");
			System.out.println("2、登陆");
			System.out.println("3、打开首页");
			System.out.println("4、打开购物车");
			System.out.println("0、管理员登陆");
			int function = in.nextInt();
			switch(function) {
				case 1 :
						uc.register();
					break;
				case 2 :
						uc.login();
					break;
				case 3 :
						ptc.showProType();
					break;
				case 4 :
						cc.showCart();
					break;
				case 0 :
						mc.login();
					break;
				default : 
					System.out.println("该功能不存在！！！！！！");
					break;
			}
		}
	}

}
