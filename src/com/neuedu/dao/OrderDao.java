package com.neuedu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.model.Order;
import com.neuedu.utils.JDBCUtil;

public class OrderDao {

	public void addOrder(Order order) {
		String sql = "insert into order0 values(null,?,?,?,?,?)";
		Object[] objs = {order.getOrdernum(),order.getUserid(),order.getOrderaddress(),order.getPhone(),order.getOrdername()};
		JDBCUtil.executeUpdate(sql, objs);
	}

	public List<Map<String,Object>> getOrderByordernum(String ordernum){
		List<Map<String,Object>> orderList = new ArrayList<>();
		String sql = "select * from order0 where ordernum = ?";
		Object[] objs = {ordernum};
		orderList = JDBCUtil.executeQuery(sql, objs);
		return orderList;
	}

	public List<Map<String, Object>> getAllOrder() {
		List<Map<String, Object>> orderList = new ArrayList<>();
		String sql = "select * from order0";
		Object[] objs = {};
		orderList = JDBCUtil.executeQuery(sql, objs);
		return orderList;
	}
}
