package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.model.ProType;
import com.neuedu.service.ProductService;

public class test {

	/*public static void main(String[] args) {
		ProTypecontroller p = new ProTypecontroller();
		p.showProType();
			

	}*/
	/*public static void main(String[] args) {
		ProductService ps = new ProductService();
		List<Map<String,Object>> proList = new ArrayList();
		ProType pt1 = new ProType();
		pt1.setPtid(1);
		proList = ps.getProductBytype(pt1);
		for(int i=0;i<proList.size();i++) {
			System.out.println("***********************");
			System.out.println("*商品编号：" + proList.get(i).get("pid") +"          ***");
			System.out.println("*商品名称：" + proList.get(i).get("pname") + "         ***");
			System.out.println("*商品价格：" + proList.get(i).get("price") + "     ***");
			System.out.println("*商品库存：" + proList.get(i).get("stock") + "       ***");
			System.out.println("*************************");
			System.out.println("商品描述：" + proList.get(i).get("pdesc"));
			System.out.println("**************************************************************");
			
			
		}
	}*/
}
