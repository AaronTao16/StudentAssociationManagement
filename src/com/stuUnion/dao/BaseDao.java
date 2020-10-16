package com.stuUnion.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.stuUnion.util.JDBCUtil;

/**
 * 
 * @author Administrator
 *创建数据库连接对象
 */
public class BaseDao {
	public Connection con =  new JDBCUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
