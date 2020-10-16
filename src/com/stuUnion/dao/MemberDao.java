package com.stuUnion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;

public class MemberDao extends BaseDao {

	//��¼����
	public Member login(Member mem) {
		String sql = "SELECT * FROM member WHERE userName = ? and password = ?";
		Member memRst = null;
		
		//��sql��䴫�����ݿ����
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, mem.getUserName());
			prst.setString(2, mem.getPassword());
			
			ResultSet rs = prst.executeQuery();
			if(rs.next()) {
				memRst = new Member();
				memRst.setId(rs.getInt("id"));
				memRst.setUserName(rs.getInt("userName"));
				memRst.setPassword(rs.getString("password"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memRst;
	}
	
	//��������ʾ������Ϣ����
	public Member displayInfo(Member me){
		PreparedStatement prst = null;
		Member MIRst = null;
		String sql1 = "select * from mempersoninfo where userName = ?";
		
		try {
			prst = con.prepareStatement(sql1); //��sql��䴫�����ݿ��������
			prst.setInt(1, me.getUserName());
			ResultSet rs2 = prst.executeQuery();
			if(rs2.next()){
				MIRst = new Member();
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
	
	//ע�᷽��
	public boolean signUpUser(Member ms) {
		PreparedStatement prst = null;
		Member MSRst = null;
		String sql2 = "INSERT INTO member (userName, password)VALUES (?,?)";
		
		try {
			prst = con.prepareStatement(sql2);
			prst.setInt(1, ms.getUserName());
			prst.setString(2, ms.getPassword());
			if(prst.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//��ʾ��Ա��Ϣ
	public List<Member> getInfoList(Member mem) {
		List<Member> memList = new ArrayList<Member>();
		String sql = "select * from mempersoninfo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Member MSRst = new Member();
				MSRst.setName(rs.getString("name"));
				MSRst.setStuNum(rs.getInt("stuNum"));
				MSRst.setStuClass(rs.getString("class"));
				MSRst.setStatus(rs.getString("status"));
				MSRst.setDep(rs.getString("dep"));
				MSRst.setPosition(rs.getString("position"));
				MSRst.setPhone(rs.getString("phone"));
				MSRst.setEmail(rs.getString("email"));
				MSRst.setIntro(rs.getString("intro"));
				MSRst.setPolitic(rs.getString("politic"));
				
				memList.add(MSRst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memList;
	}
	
	//�û���Ϣ¼�������Ϣ���ݱ�
	public void createInfo(Member ms) {
		PreparedStatement prst = null;
		Member MSRst = null;
		String sql3 = "INSERT INTO mempersoninfo (userName,stuNum,position) VALUES (?,?,?)";
		
		try {
			prst = con.prepareStatement(sql3);
			prst.setInt(1, ms.getUserName());
			prst.setInt(2, ms.getUserName());
			prst.setString(3, "����");
			prst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���¸��˵�¼��Ϣ
	public boolean updateInfo(Member mem) {
		PreparedStatement prst = null;
		String sql = "UPDATE member set password = ? where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, mem.getPassword());
			prst.setInt(2, mem.getUserName());
			if(prst.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updatePerInfo(Member mem) {
		PreparedStatement prst = null;
		String sql = "UPDATE mempersoninfo set name = ?, stuNum = ?, class = ?, dep = ?, position = ?, status = ?, phone = ?, email = ?, politic = ?, intro = ? where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, mem.getName());
			prst.setInt(2, mem.getStuNum());
			prst.setString(3, mem.getStuClass());
			prst.setString(4, mem.getDep());
			prst.setString(5, mem.getPosition());
			prst.setString(6, mem.getStatus());
			prst.setString(7, mem.getPhone());
			prst.setString(8, mem.getEmail());
			prst.setString(9, mem.getPolitic());
			prst.setString(10, mem.getIntro());
			prst.setInt(11, mem.getUserName());
			if(prst.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//ɾ����Ա
	public boolean delete(int stuNum) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "delete from member where userName = ?";
		String sql2 = "delete from mempersoninfo where stuNum = ?";

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
	
	//������Ҫ�鿴�ĳ�Ա��Ϣ
	public Member checkInfo(Member me){
		PreparedStatement prst = null;
		Member MIRst = null;
		String sql1 = "select * from mempersoninfo where userName = ?";
		
		try {
			prst = con.prepareStatement(sql1); //��sql��䴫�����ݿ��������
			prst.setInt(1, me.getStuNum());
			ResultSet rs2 = prst.executeQuery();
			if(rs2.next()){
				MIRst = new Member();
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
	
	//��ȡ����
	public String password(Member mem) {
		String password = null;
		PreparedStatement prst = null;
		String sql = "select password from member where username = ?;";
		
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, mem.getUserName());
			ResultSet rs = prst.executeQuery();
			if(rs.next()){
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}
