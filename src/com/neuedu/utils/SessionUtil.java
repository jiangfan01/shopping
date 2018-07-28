package com.neuedu.utils;

import com.neuedu.model.User;

public class SessionUtil {
	public static boolean loginFalg = false;
	public static User user;
	
	public static void setLogin(User user0) {
		user = user0;
		loginFalg = true;
	}
	public static boolean isLogin() {
		return loginFalg;
	}
}
