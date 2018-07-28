package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.neuedu.model.ProType;
import com.neuedu.model.Product;
import com.neuedu.service.ProductService;
import com.neuedu.utils.SessionUtil;

public class ProductController {
	ProductService ps = new ProductService();
	Scanner in = new Scanner(System.in);
	UserController uc = new UserController();
	CartController cc = new CartController();
	
	public Product getProductBypid(int pid) {
		List<Map<String,Object>> proList = ps.getProductBypid(pid);
		Product p = new Product(proList.get(0).get("pname").toString(),proList.get(0).get("pdesc").toString(),(double)proList.get(0).get("price"),(int)proList.get(0).get("stock"),(int)proList.get(0).get("ptid"));
		p.setPid((int)proList.get(0).get("pid"));
		return p;
	}
	public void showProductBytype(int type) {
		List<Map<String,Object>> proList = new ArrayList();
		switch(type) {
			case 1 :
				ProType pt1 = new ProType();
				pt1.setPtid(1);
				proList = ps.getProductBytype(pt1);
				for(int i=0;i<proList.size();i++) {
					System.out.println("***************************");
					System.out.println("*商品编号：" + proList.get(i).get("pid") +"\t\t***");
					System.out.println("*商品名称：" + proList.get(i).get("pname") + "\t\t***");
					System.out.println("*商品价格：" + proList.get(i).get("price") + "\t\t***");
					System.out.println("*商品库存：" + proList.get(i).get("stock") + "\t\t***");
					System.out.println("***************************");
					System.out.println("商品描述：" + proList.get(i).get("pdesc"));
					System.out.println("**************************************************************");
					
				}
				break;
			case 2 :
				ProType pt2 = new ProType();
				pt2.setPtid(2);
				proList = ps.getProductBytype(pt2);
				for(int i=0;i<proList.size();i++) {
					System.out.println("***************************");
					System.out.println("*商品编号：" + proList.get(i).get("pid") +"\t\t***");
					System.out.println("*商品名称：" + proList.get(i).get("pname") + "\t\t***");
					System.out.println("*商品价格：" + proList.get(i).get("price") + "\t\t***");
					System.out.println("*商品库存：" + proList.get(i).get("stock") + "\t\t***");
					System.out.println("***************************");
					System.out.println("商品描述：" + proList.get(i).get("pdesc"));
					System.out.println("**************************************************************");
					
				}
				break;
			case 3 :
				ProType pt3 = new ProType();
				pt3.setPtid(3);
				proList = ps.getProductBytype(pt3);
				for(int i=0;i<proList.size();i++) {
					System.out.println("***************************");
					System.out.println("*商品编号：" + proList.get(i).get("pid") +"\t\t***");
					System.out.println("*商品名称：" + proList.get(i).get("pname") + "\t\t***");
					System.out.println("*商品价格：" + proList.get(i).get("price") + "\t\t***");
					System.out.println("*商品库存：" + proList.get(i).get("stock") + "\t\t***");
					System.out.println("***************************");
					System.out.println("商品描述：" + proList.get(i).get("pdesc"));
					System.out.println("**************************************************************");
					
				}
				break;
			case 4 :
				ProType pt4 = new ProType();
				pt4.setPtid(4);
				proList = ps.getProductBytype(pt4);
				for(int i=0;i<proList.size();i++) {
					System.out.println("***************************");
					System.out.println("*商品编号：" + proList.get(i).get("pid") +"\t\t***");
					System.out.println("*商品名称：" + proList.get(i).get("pname") + "\t\t***");
					System.out.println("*商品价格：" + proList.get(i).get("price") + "\t\t***");
					System.out.println("*商品库存：" + proList.get(i).get("stock") + "\t\t***");
					System.out.println("***************************");
					System.out.println("商品描述：" + proList.get(i).get("pdesc"));
					System.out.println("**************************************************************");
					
				}
				break;
		}
		System.out.println("请输入要加入购物车的商品编号和数量：");
		int pid = in.nextInt();
		int pnum = in.nextInt();
		if(!SessionUtil.loginFalg) {
			System.out.println("您还没有登陆！1、注册/2、登陆");
			int n = in.nextInt();
			if(n == 1) {
				uc.register();
			}else {
				uc.login();
			}
			System.out.println("请输入要加入购物车的商品编号和数量：");
			pid = in.nextInt();
			pnum = in.nextInt();
		}
		Product p = getProductBypid(pid);
		cc.addProToCart(p,pnum);
	}
}
