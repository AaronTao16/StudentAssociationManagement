package com.stuUnion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;
import com.stuUnion.model.eClass;
import com.stuUnion.util.JDBCUtil;

public class AdminDao extends BaseDao {

	public Admin login(Admin admin) {
		String sql = "SELECT * FROM admin WHERE userName = ? and password = ?";
		Admin adminRst = null;

		// 用sql语句传给数据库对象
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getUserName());
			prst.setString(2, admin.getPassword());

			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				adminRst = new Admin();
				adminRst.setId(rs.getInt("id"));
				adminRst.setUserName(rs.getInt("userName"));
				adminRst.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adminRst;
	}

	// 创建登录信息
	public boolean createMin(Minister min) {
		PreparedStatement prst = null, prst1 = null;
		String sql = "INSERT INTO admin (userName,password) VALUES (?,?)";
		String sql1 = "INSERT INTO apersoninfo (userName,name,class,dep,position,status,stuNum,politic,intro,email,phone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, min.getUserName());
			prst.setString(2, min.getPassword());

			prst1 = con.prepareStatement(sql1);
			prst1.setInt(1, min.getUserName());
			prst1.setString(2, min.getName());
			prst1.setString(3, min.getStuClass());
			prst1.setString(4, min.getDep());
			prst1.setString(5, "主席团");
			prst1.setString(6, min.getStatus());
			prst1.setInt(7, min.getStuNum());
			prst1.setString(8, min.getPolitic());
			prst1.setString(9, min.getIntro());
			prst1.setString(10, min.getEmail());
			prst1.setString(11, min.getPhone());

			if (prst.executeUpdate() > 0 && prst1.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Admin displayInfo(Admin ai) {
		PreparedStatement prst = null;
		Admin AIRst = null;
		String sql1 = "select * from apersoninfo where userName = ?";

		try {
			prst = con.prepareStatement(sql1); // 把sql语句传给数据库操作对象
			prst.setInt(1, ai.getUserName());
			ResultSet rs2 = prst.executeQuery();
			if (rs2.next()) {
				AIRst = new Admin();
				AIRst.setId(rs2.getInt("id"));
				AIRst.setUserName(rs2.getInt("username"));
				AIRst.setName(rs2.getString("name"));
				AIRst.setStuNum(rs2.getInt("stuNum"));
				AIRst.setStuClass(rs2.getString("class"));
				AIRst.setStatus(rs2.getString("status"));
				AIRst.setDep(rs2.getString("dep"));
				AIRst.setPosition(rs2.getString("position"));
				AIRst.setPhone(rs2.getString("phone"));
				AIRst.setEmail(rs2.getString("email"));
				AIRst.setIntro(rs2.getString("intro"));
				AIRst.setPolitic(rs2.getString("politic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AIRst;
	}

	// 显示成员信息
	public List<Admin> getInfoList(Admin ad) {
		List<Admin> aList = new ArrayList<Admin>();
		String sql = "select * from apersoninfo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin AIRst = new Admin();
				AIRst.setName(rs.getString("name"));
				AIRst.setStuNum(rs.getInt("stuNum"));
				AIRst.setStuClass(rs.getString("class"));
				AIRst.setStatus(rs.getString("status"));
				AIRst.setDep(rs.getString("dep"));
				AIRst.setPosition(rs.getString("position"));
				AIRst.setPhone(rs.getString("phone"));
				AIRst.setEmail(rs.getString("email"));
				AIRst.setIntro(rs.getString("intro"));
				AIRst.setPolitic(rs.getString("politic"));

				aList.add(AIRst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aList;
	}

	// 更新个人登录信息
	public boolean updateInfo(Admin ad) {
		PreparedStatement prst = null;
		String sql = "UPDATE admin set password = ? where username = ?;";

		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, ad.getPassword());
			prst.setInt(2, ad.getUserName());
			if (prst.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updatePerInfo(Admin ad) {
		PreparedStatement prst = null;
		String sql = "UPDATE apersoninfo set name = ?, stuNum = ?, class = ?, dep = ?, position = ?, status = ?, phone = ?, email = ?, politic = ?, intro = ? where username = ?;";

		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, ad.getName());
			prst.setInt(2, ad.getStuNum());
			prst.setString(3, ad.getStuClass());
			prst.setString(4, ad.getDep());
			prst.setString(5, ad.getPosition());
			prst.setString(6, ad.getStatus());
			prst.setString(7, ad.getPhone());
			prst.setString(8, ad.getEmail());
			prst.setString(9, ad.getPolitic());
			prst.setString(10, ad.getIntro());
			prst.setInt(11, ad.getUserName());
			if (prst.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 删除成员
	public boolean delete(int stuNum) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "delete from admin where userName = ?";
		String sql2 = "delete from apersoninfo where stuNum = ?";

		try {
			prst1 = con.prepareStatement(sql1);
			prst2 = con.prepareStatement(sql2);
			prst1.setInt(1, stuNum);
			prst2.setInt(1, stuNum);
			if (prst1.executeUpdate() > 0 && prst2.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// 搜索需要查看的成员信息
	public Admin checkInfo(Admin ai) {
		PreparedStatement prst = null;
		Admin AIRst = null;
		String sql1 = "select * from apersoninfo where userName = ?";

		try {
			prst = con.prepareStatement(sql1); // 把sql语句传给数据库操作对象

			prst.setInt(1, ai.getStuNum());
			ResultSet rs2 = prst.executeQuery();
			if (rs2.next()) {
				AIRst = new Admin();
				AIRst.setId(rs2.getInt("id"));
				AIRst.setUserName(rs2.getInt("username"));
				AIRst.setName(rs2.getString("name"));
				AIRst.setStuNum(rs2.getInt("stuNum"));
				AIRst.setStuClass(rs2.getString("class"));
				AIRst.setStatus(rs2.getString("status"));
				AIRst.setDep(rs2.getString("dep"));
				AIRst.setPosition(rs2.getString("position"));
				AIRst.setPhone(rs2.getString("phone"));
				AIRst.setEmail(rs2.getString("email"));
				AIRst.setIntro(rs2.getString("intro"));
				AIRst.setPolitic(rs2.getString("politic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AIRst;
	}
}
