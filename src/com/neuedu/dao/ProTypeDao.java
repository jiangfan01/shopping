package com.neuedu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.utils.JDBCUtil;


public class ProTypeDao {

	public List<Map<String, Object>> getAllType() {
		List<Map<String, Object>> proTypeList = new ArrayList();
		String sql = "select * from protype";
		Object[] objs = {};
		proTypeList = JDBCUtil.executeQuery(sql, objs);
		return proTypeList;
	}

}
