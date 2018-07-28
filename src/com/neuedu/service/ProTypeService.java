package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.ProTypeDao;

public class ProTypeService {
	ProTypeDao ptd = new ProTypeDao();

	public List<Map<String,Object>> showProType() {
		return ptd.getAllType();
	}
}
