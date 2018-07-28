package com.neuedu.controller;

import java.util.Scanner;

import com.neuedu.model.Manager;
import com.neuedu.model.Product;
import com.neuedu.service.ManagerService;

public class ManagerController {
	Scanner in = new Scanner(System.in);
	ManagerService ms = new ManagerService();

	public void login() {
		OrderController oc = new OrderController();
		System.out.println("--------------管理员界面--------------");
		System.out.println("用户名：");
		String mname = in.nextLine();
		System.out.println("密码：");
		String password = in.nextLine();
		Manager m = new Manager(mname,password);
		if(ms.login(m)) {
			System.out.println("管理员登陆成功！");
			System.out.println("请选择功能：");
			System.out.println("===================");
			System.out.println("===  1、添加商品     ===");
			System.out.println("===  2、查看订单     ===");
			System.out.println("===================");
			int function = in.nextInt();
			switch(function) {
				case 1 :
					System.out.println("输入商品类型： 1、服饰   2、数码   3、食品   4、学习");
					int type = in.nextInt();
					System.out.println("商品名称：");
					in.nextLine();
					String pname = in.nextLine();
					System.out.println("商品描述：");
					String pdesc = in.nextLine();
					System.out.println("商品价格：");
					double price = in.nextDouble();
					System.out.println("库存:");
					int stock = in.nextInt();
					Product product = new Product(pname, pdesc, price, stock, type);
					ms.addProduct(product);
					break;
				case 2 :
					oc.showOrder();
					break;
				default :
					break;
			}
		}else {
			System.out.println("你是假的管理员！！！！");
		}
		
	}

}
