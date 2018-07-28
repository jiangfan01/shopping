package com.neuedu.dao;

import com.neuedu.model.Manager;
import com.neuedu.model.Product;
import com.neuedu.utils.JDBCUtil;

public class ManagerDao {

	public boolean getManager(Manager m) {
		String sql = "select * from manager where mname = ? and password = ?";
		Object[] objs = {m.getMname(),m.getPassword()};
		if(JDBCUtil.executeQuery(sql, objs).size()!=0) {
			return true;
		}
		return false;
		
	}

	public void addProduct(Product product) {
		String sql = "insert into product values(null,?,?,?,?,?)";
		Object[] objs = {product.getPname(),product.getPdesc(),product.getPrice(),product.getStock(),product.getPtid()};
		JDBCUtil.executeUpdate(sql, objs);
	}
	
}
