package com.stuUnion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;

public class MinisterDao extends BaseDao {

	public Minister login(Minister minister) {
		String sql = "SELECT * FROM minister WHERE userName = ? and password = ?";
		Minister ministerRst = null;
		
		//用sql语句传给数据库对象
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, minister.getUserName());
			prst.setString(2, minister.getPassword());
			
			ResultSet rs = prst.executeQuery();
			if(rs.next()) {
				ministerRst = new Minister();
				ministerRst.setId(rs.getInt("id"));
				ministerRst.setUserName(rs.getInt("userName"));
				ministerRst.setPassword(rs.getString("password"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ministerRst;
	}
	
	//创建登录信息
	public boolean createMin(Member mem) {
		PreparedStatement prst = null, prst1 = null;
		String sql = "INSERT INTO minister (userName,password) VALUES (?,?)";
		String sql1 = "INSERT INTO minpersoninfo (userName,name,class,dep,position,status,stuNum,politic,intro,email,phone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, mem.getUserName());
			prst.setString(2, mem.getPassword());
			
			prst1 = con.prepareStatement(sql1);
			prst1.setInt(1, mem.getUserName());
			prst1.setString(2, mem.getName());
			prst1.setString(3, mem.getStuClass());
			prst1.setString(4, mem.getDep());
			prst1.setString(5, "部长");
			prst1.setString(6, mem.getStatus());
			prst1.setInt(7, mem.getStuNum());
			prst1.setString(8, mem.getPolitic());
			prst1.setString(9, mem.getIntro());
			prst1.setString(10, mem.getEmail());
			prst1.setString(11, mem.getPhone());

			if(prst.executeUpdate()>0 && prst1.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Minister displayInfo(Minister mi){
		PreparedStatement prst = null;
		Minister MIRst = null;
		String sql1 = "select * from minpersoninfo where userName = ?";
		
		try {
			prst = con.prepareStatement(sql1); //把sql语句传给数据库操作对象
			prst.setInt(1, mi.getUserName());
			ResultSet rs2 = prst.executeQuery();
			if(rs2.next()){
				MIRst = new Minister();
				MIRst.setId(rs2.getInt("id"));
				MIRst.setUserName(rs2.getInt("username"));
				MIRst.setName(rs2.getString("name"));
				MIRst.setStuNum(rs2.getInt("stuNum"));
				MIRst.setStuClass(rs2.getString("class"));
				MIRst.setStatus(rs2.getString("status"));
				MIRst.setDep(rs2.getString("dep"));
				MIRst.setPosition(rs2.getString("position"));
				MIRst.setPhone(rs2.getString("phone"));
				MIRst.setEmail(rs2.getString("email"));
				MIRst.setIntro(rs2.getString("intro"));
				MIRst.setPolitic(rs2.getString("politic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MIRst;
	}
	
	public List<Minister> getInfoList(Minister min) {
		List<Minister> minList = new ArrayList<Minister>();
		String sql = "select * from minpersoninfo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Minister MIRst = new Minister();
				MIRst.setName(rs.getString("name"));
				MIRst.setStuNum(rs.getInt("stuNum"));
				MIRst.setStuClass(rs.getString("class"));
				MIRst.setStatus(rs.getString("status"));
				MIRst.setDep(rs.getString("dep"));
				MIRst.setPosition(rs.getString("position"));
				MIRst.setPhone(rs.getString("phone"));
				MIRst.setEmail(rs.getString("email"));
				MIRst.setIntro(rs.getString("intro"));
				MIRst.setPolitic(rs.getString("politic"));
				
				minList.add(MIRst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minList;
	}
	
	//更新个人登录信息
	public boolean updateInfo(Minister min) {
		PreparedStatement prst = null;
		String sql = "UPDATE minster set password = ? where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, min.getPassword());
			prst.setInt(2, min.getUserName());
			if(prst.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updatePerInfo(Minister min) {
		PreparedStatement prst = null;
		String sql = "UPDATE minpersoninfo set name = ?, stuNum = ?, class = ?, dep = ?, position = ?, status = ?, phone = ?, email = ?, politic = ?, intro = ? where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, min.getName());
			prst.setInt(2, min.getStuNum());
			prst.setString(3, min.getStuClass());
			prst.setString(4, min.getDep());
			prst.setString(5, min.getPosition());
			prst.setString(6, min.getStatus());
			prst.setString(7, min.getPhone());
			prst.setString(8, min.getEmail());
			prst.setString(9, min.getPolitic());
			prst.setString(10, min.getIntro());
			prst.setInt(11, min.getUserName());
			if(prst.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//删除成员
	public boolean delete(int stuNum) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "delete from minister where userName = ?";
		String sql2 = "delete from minpersoninfo where stuNum = ?";

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
	
	//搜索需要查看的成员信息
	public Minister checkInfo(Minister mi){
		PreparedStatement prst = null;
		Minister MIRst = null;
		String sql1 = "select * from minpersoninfo where userName = ?";
		
		try {
			prst = con.prepareStatement(sql1); //把sql语句传给数据库操作对象
			prst.setInt(1, mi.getStuNum());
			ResultSet rs2 = prst.executeQuery();
			if(rs2.next()){
				MIRst = new Minister();
				MIRst.setId(rs2.getInt("id"));
				MIRst.setUserName(rs2.getInt("username"));
				MIRst.setName(rs2.getString("name"));
				MIRst.setStuNum(rs2.getInt("stuNum"));
				MIRst.setStuClass(rs2.getString("class"));
				MIRst.setStatus(rs2.getString("status"));
				MIRst.setDep(rs2.getString("dep"));
				MIRst.setPosition(rs2.getString("position"));
				MIRst.setPhone(rs2.getString("phone"));
				MIRst.setEmail(rs2.getString("email"));
				MIRst.setIntro(rs2.getString("intro"));
				MIRst.setPolitic(rs2.getString("politic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MIRst;
	}
	
	//获取密码
	public String password(Minister mem) {
		String password = null;
		PreparedStatement prst = null;
		String sql = "select password from minister where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, mem.getUserName());
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}
