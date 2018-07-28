package com.neuedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/shopping?autoReconnect=true&useSSL=false";
			String user = "root";
			String password = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executeUpdate(String sql,Object[] objs) {
		try {
			getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
					ps = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static List<Map<String,Object>> executeQuery(String sql,Object[] objs){
		List<Map<String,Object>> list = new ArrayList<>();
		try {
			getConnection();
			ps = conn.prepareStatement(sql);
			if(objs != null) {
				for(int i=0;i<objs.length;i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData columns = rs.getMetaData();
			int columnsCount = columns.getColumnCount();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				for(int i=0;i<columnsCount;i++) {					
					String name =columns.getColumnName(i+1);
					Object obj = rs.getObject(i+1);
					map.put(name, obj);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(ps != null) {
					ps.close();
					ps = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
