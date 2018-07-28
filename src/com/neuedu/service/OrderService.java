package com.neuedu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.dao.OrderDao;
import com.neuedu.model.Order;
import com.neuedu.utils.SessionUtil;


public class OrderService {
	OrderDao od = new OrderDao();

	public boolean createOrder(Order order) {
		od.addOrder(order);
		if(od.getOrderByordernum(order.getOrdernum()).size()!=0) {
			return true;
		}
		return false;
	}

	public List<Map<String, Object>> showOrder() {
		List<Map<String, Object>> orderList = new ArrayList();
		orderList = od.getAllOrder();
		return orderList;
	}

	public Order getOrderByOrdernum(String ordernum) {
		List<Map<String, Object>> orderList = od.getOrderByordernum(ordernum);
		try {
			Order order = new Order(ordernum, (int)orderList.get(0).get("userid"),orderList.get(0).get("phone").toString(), orderList.get(0).get("orderaddress").toString(), orderList.get(0).get("ordername").toString());
			order.setOid((int)orderList.get(0).get("oid"));
			return order;
		} catch (Exception e) {
			return null;
		}
	}


}
