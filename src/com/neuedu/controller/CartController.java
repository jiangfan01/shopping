package com.neuedu.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.neuedu.model.Cart;
import com.neuedu.model.Product;
import com.neuedu.service.CartService;
import com.neuedu.utils.SessionUtil;

public class CartController {
	CartService cs = new CartService();
	UserController uc = new UserController();
	Scanner in = new Scanner(System.in);
	

	public void addProToCart(Product p, int pnum) {
		cs.addProToCart(p,pnum);
	}

	public void showCart() {
		OrderController oc = new OrderController();
		ProductController pc = new ProductController();
		if(!SessionUtil.loginFalg) {
			System.out.println("您还没有登陆！1、注册/2、登陆");
			int n = in.nextInt();
			if(n == 1) {
				uc.register();
			}else {
				uc.login();
			}
		}
		List<Map<String,Object>> cartList = cs.showCart(SessionUtil.user);
		System.out.println("********" +SessionUtil.user.getUsername() + "的购物车信息：" + "********");
		double totalPrice = 0;
		for(int i=0;i<cartList.size();i++) {
			System.out.println("****编号：        " + (i+1) + "\t\t\t****");
			System.out.println("****商品名称：\t" + pc.getProductBypid((int)cartList.get(i).get("pid")).getPname() + "\t\t****");
			System.out.println("****购买数量：\t" + (int)cartList.get(i).get("pnum") + "\t\t****");
			totalPrice += (double)cartList.get(i).get("totalprice");
		}
		System.out.println("****购买数量：" + "总共应付款" + totalPrice + " RMB ****");
		System.out.println("************************************");
		System.out.println("是否下单？   1、是/2、否");
		int isOrder = in.nextInt();
		if(isOrder==1) {
			System.out.println("请输入下单的编号：");
			int order = in.nextInt();
			Cart cart = new Cart((int)cartList.get(order-1).get("userid"), (int)cartList.get(order-1).get("pid"),(int)cartList.get(order-1).get("pnum"),(double)cartList.get(order-1).get("totalprice"));
			cart.setCid(order);
			oc.createOrder(cart);
		}
	}
}
