package com.neuedu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.model.Product;
import com.neuedu.model.User;
import com.neuedu.utils.JDBCUtil;

public class CartDao {

	public void add(Product p, int pnum, User user) {
		String sql = "insert into cart values(?,?,?,?,?)";
		Object[] objs = {null,user.getUserid(),p.getPid(),pnum,p.getPrice()*pnum};
		JDBCUtil.executeUpdate(sql, objs);
		
	}

	public List<Map<String, Object>> getCart(User user) {
		List<Map<String, Object>> cartList = new ArrayList<>();
		String sql = "select * from cart where userid = ?";
		Object[] objs = {user.getUserid()};
		cartList = JDBCUtil.executeQuery(sql, objs);
		return cartList;
	}
	
}
