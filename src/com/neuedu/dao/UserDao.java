package com.neuedu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.model.User;
import com.neuedu.utils.JDBCUtil;

public class UserDao {

	public List<Map<String, Object>> getUser(User user) {
		List<Map<String, Object>> userList = new ArrayList<>();
		String sql = "select * from user where username = ? and password = ?";
		Object[] objs = {user.getUsername(),user.getPassword()};
		return JDBCUtil.executeQuery(sql, objs);
	}
	
	public boolean save(User user) {
		String sql = "insert into user values(?,?,?,?,?)";
		Object[] objs = {null,user.getUsername(),user.getPassword(),user.getPhone(),user.getEmil()};
		JDBCUtil.executeUpdate(sql, objs);
		if(getUser(user).size()!=0) {
			return true;
		}
		return false;
	}
	
	public List<Map<String,Object>> getUserByuserid(int userid){
		String sql = "select * from user where userid = ?";
		Object[] objs = {userid};
		List<Map<String,Object>> userList = JDBCUtil.executeQuery(sql, objs);
		return userList;
	}

}
