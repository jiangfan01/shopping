package com.neuedu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.dao.CartDao;
import com.neuedu.model.Product;
import com.neuedu.model.User;
import com.neuedu.utils.SessionUtil;

public class CartService {
	CartDao cd = new CartDao();

	public void addProToCart(Product p, int pnum) {
		cd.add(p,pnum,SessionUtil.user);
		
	}

	public List<Map<String, Object>> showCart(User user) {
		List<Map<String, Object>> cartList = new ArrayList();
		cartList = cd.getCart(user);
		return cartList;
	}
}
