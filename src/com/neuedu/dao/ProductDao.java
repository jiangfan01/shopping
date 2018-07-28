package com.neuedu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.model.ProType;
import com.neuedu.model.Product;
import com.neuedu.utils.JDBCUtil;

public class ProductDao {
	
	public List<Map<String,Object>> getProductBypid(int pid){
		List<Map<String,Object>> proList = new ArrayList<>();
		String sql = "select * from product where pid = ?";
		Object[] objs = {pid};
		proList = JDBCUtil.executeQuery(sql, objs);
		return proList;
	}
	public List<Map<String,Object>> getProductBytype(ProType proType){
		List<Map<String,Object>> proList = new ArrayList();
		String sql = "select * from product where ptid = ?";
		Object[] objs = {proType.getPtid()};		
		proList = JDBCUtil.executeQuery(sql, objs);
		return proList;
	}
}
