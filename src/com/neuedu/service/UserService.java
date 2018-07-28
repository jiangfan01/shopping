package com.neuedu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.dao.UserDao;
import com.neuedu.model.User;
import com.neuedu.utils.SessionUtil;

public class UserService {
	UserDao ud = new UserDao();
	
	public boolean checkUser(String username) {
		User user = new User();
		user.setUsername(username);
		List<Map<String,Object>> userList = new ArrayList<>();
		userList = ud.getUser(user);
		if(userList.size()!=0) {
			return true;
		}
		return false;
	}

	public boolean register(User user) {
		return ud.save(user);		
	}
	
	public boolean login(User user) {
		List<Map<String,Object>> userList = new ArrayList<>();
		userList = ud.getUser(user);
		if(userList.size()!=0) {
			User u = new User(userList.get(0).get("username").toString(),userList.get(0).get("password").toString(),userList.get(0).get("phone").toString(),userList.get(0).get("emil").toString());
			u.setUserid((int)userList.get(0).get("userid"));
			SessionUtil.setLogin(u);
			return true;
		}else {
			return false;
		}
	}
	public String getUsernameByUserid(int userid) {
		List<Map<String,Object>> user0 = ud.getUserByuserid(userid);
		return user0.get(0).get("username").toString();
	}
}
