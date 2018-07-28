package com.neuedu.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.neuedu.service.ProTypeService;

public class ProTypeController {
	ProTypeService pts = new ProTypeService();
	Scanner in = new Scanner(System.in);
	ProductController pc = new ProductController();
	
	public void showProType() {
		List<Map<String, Object>> proTypeList = pts.showProType();
		System.out.println("-------------欢迎来到★★商城首页--------------");
		System.out.println("-----------------商品类型-------------------");
		for(int i=0;i<proTypeList.size();i++) {
			System.out.println("-----------------" +(i+1) + "、" + proTypeList.get(i).get("typename") + "--------------------" );
		}
		System.out.println("------------------------------------------");
		
		System.out.println("请选择商品类型编号：");
		int type = in.nextInt();
		pc.showProductBytype(type);
		
		
	}

}
