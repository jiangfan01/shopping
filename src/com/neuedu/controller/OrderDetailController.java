package com.neuedu.controller;

import java.util.List;
import java.util.Map;

import com.neuedu.model.OrderDetail;
import com.neuedu.service.OrderDetailService;

public class OrderDetailController {
	OrderDetailService ods = new OrderDetailService();

	public void addOrderDetail(OrderDetail orderDetail) {
		ods.addOrderDetail(orderDetail);
		
	}

	public List<Map<String,Object>> getOrderDetailByoid(int oid) {
		
		return ods.getOrderDetailByoid(oid);
		
	}



}
