package com.neuedu.service;

import com.neuedu.dao.ManagerDao;
import com.neuedu.model.Manager;
import com.neuedu.model.Product;

public class ManagerService {
	ManagerDao md = new ManagerDao();
	public boolean login(Manager m) {
		if(md.getManager(m)) {
			return true;
		}
		return false;
		
	}
	public void addProduct(Product product) {
		md.addProduct(product);
		
	}

}
