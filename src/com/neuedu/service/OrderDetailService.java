package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.OrderDetailDao;
import com.neuedu.model.OrderDetail;

public class OrderDetailService {
	OrderDetailDao odd = new OrderDetailDao();

	public void addOrderDetail(OrderDetail orderDetail) {
		odd.add(orderDetail);
		
	}

	public List<Map<String,Object>> getOrderDetailByoid(int oid) {
		
		return  odd.getOrderDetailByoid(oid);
	}

}
