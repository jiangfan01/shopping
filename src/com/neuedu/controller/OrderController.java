package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.neuedu.model.Cart;
import com.neuedu.model.Order;
import com.neuedu.model.OrderDetail;
import com.neuedu.service.OrderService;
import com.neuedu.service.UserService;
import com.neuedu.utils.SessionUtil;

public class OrderController {
	OrderService os = new OrderService();
	Scanner in = new Scanner(System.in);

	public boolean createOrder(Cart cart) {
		OrderDetailController odc = new OrderDetailController();
		System.out.println("请输入订单信息：");
		System.out.println("订单号：");
		String ordernum = in.nextLine();
		System.out.println("收获人：");
		String ordername = in.nextLine();
		System.out.println("收货地址：");
		String orderaddress = in.nextLine();
		System.out.println("收货人电话：");
		String phone = in.nextLine();
		Order order = new Order(ordernum, SessionUtil.user.getUserid(),phone, orderaddress, ordername);
		if(os.createOrder(order)) {
			Order order0 = getOrderByOrdernum(ordernum);			
			OrderDetail orderDetail = new OrderDetail(order0.getOid(), cart.getPid(), cart.getPnum());
			odc.addOrderDetail(orderDetail);
			return true;
		}
		return false;
		
	}
	public void showOrder(){
		List<Map<String,Object>> orderList = new ArrayList<>();
		OrderDetailController odc = new OrderDetailController();
		ProductController pc = new ProductController();
		UserService us = new UserService();
		orderList = os.showOrder();
		for(int i=0;i<orderList.size();i++) {
			System.out.println("*****************************************************");
			System.out.println("订单号：\t\t" + orderList.get(i).get("ordernum"));
			System.out.println("所属用户id： \t" + orderList.get(i).get("userid"));
			System.out.println("收货人：\t\t" + orderList.get(i).get("ordername"));
			System.out.println("收货人电话：\t" + orderList.get(i).get("phone"));
			System.out.println("收货地址：\t\t" + orderList.get(i).get("orderaddress"));
			System.out.println("*****************************************************");
		}
		
		System.out.println("是否查看订单详情？  1、是/2、否");
		int islook = in.nextInt();
		if(islook==1) {
			in.nextLine();
			System.out.println("输入要查看的订单号:");
			String ordernum = in.nextLine();
			Order order = getOrderByOrdernum(ordernum);
			if(order==null) {
				System.out.println("此订单不存在！！！请检查订单号输入是否错误！");
			}else {
				List<Map<String,Object>> orderDetailList = odc.getOrderDetailByoid(order.getOid());
				System.out.println("***********************************");
				System.out.println("*该订单详情如下：\t\t\t***");
				System.out.println("*下单人：\t" + us.getUsernameByUserid((int)orderDetailList.get(0).get("userid")) + "\t\t***");
				System.out.println("*订单号：\t" + ordernum + "\t\t***");
				System.out.println("*收货人：\t" + orderDetailList.get(0).get("ordername") + "\t\t\t***");
				System.out.println("*收货人联系方式：\t" + orderDetailList.get(0).get("phone") + "\t***");
				System.out.println("*收货地址：\t" + orderDetailList.get(0).get("orderaddress") + "\t\t***");
				System.out.println("*商品名称：\t" + pc.getProductBypid((int)orderDetailList.get(0).get("pid")).getPname() + "\t\t***");
				System.out.println("*商品数量：\t" + orderDetailList.get(0).get("pnum") + "\t\t***");
				System.out.println("***********************************");
				System.out.println();
			}
		}
	}
	
	public Order getOrderByOrdernum(String ordernum) {
		Order order = new Order();
		order = os.getOrderByOrdernum(ordernum);
		return order;
	}

}
