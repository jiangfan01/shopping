package com.neuedu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.dao.ProductDao;
import com.neuedu.model.ProType;

public class ProductService {
	ProductDao pd = new ProductDao();
	
	public List<Map<String,Object>> getProductBytype(ProType proType){
		List<Map<String,Object>> proList = pd.getProductBytype(proType);
		return proList;
	}
	public List<Map<String,Object>> getProductBypid(int pid){
		List<Map<String,Object>> proList = pd.getProductBypid(pid);
		return proList;
	}
}
