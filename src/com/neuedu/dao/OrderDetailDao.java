package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.model.OrderDetail;
import com.neuedu.utils.JDBCUtil;

public class OrderDetailDao {

	public void add(OrderDetail orderDetail) {
		String sql = "insert into orderdetail values(null,?,?,?)";
		Object[] objs = {orderDetail.getOid(),orderDetail.getPid(),orderDetail.getPnum()};
		JDBCUtil.executeUpdate(sql, objs);
		
	}

	public List<Map<String, Object>> getOrderDetailByoid(int oid) {
		String sql = "select * from order0 o1,orderdetail o2 where o1.oid = o2.oid and o1.oid = ?";
		Object[] objs = {oid};
		return JDBCUtil.executeQuery(sql, objs);
	}

}
