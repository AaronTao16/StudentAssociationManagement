package com.stuUnion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/xinhe_info?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=GMT"; //地址
	private String dbUserName = "root"; //用户名
	private String dbPassword = "12345.6"; //密码
	private String jdbcName = "com.mysql.cj.jdbc.Driver"; //驱动名称
	
	/**
	 * 获取数据库 
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbUrl,dbUserName, dbPassword);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭数据库
	 */
	public void closeCon (Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}

	
	public static void main(String[] args) {
		JDBCUtil jdbcUtil = new JDBCUtil();
		try {
			jdbcUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
