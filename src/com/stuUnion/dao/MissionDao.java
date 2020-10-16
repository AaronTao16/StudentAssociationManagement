package com.stuUnion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stuUnion.model.DepMission;
import com.stuUnion.model.eClass;

public class MissionDao extends BaseDao {

	//获取全部任务
	public List<DepMission> getMissionList(DepMission dm) {
		List<DepMission> mList = new ArrayList<DepMission>();
		String sql = "select * from mission";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DepMission m = new DepMission();
				m.setmTitle(rs.getString("mTitle"));
				m.setmContent(rs.getString("mContent"));
				m.setDepartment(rs.getString("department"));
				m.setPerName(rs.getString("perName"));
				m.setMemName(rs.getString("memName"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setProgress(rs.getString("progress"));
				m.setGrade(rs.getFloat("grade"));
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	//获取不同部门发布任务
	public List<DepMission> getPreMissionList(DepMission dm) {
		List<DepMission> mList = new ArrayList<DepMission>();
		String sql = "select * from mission where department = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dm.getDepartment());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DepMission m = new DepMission();
				m.setmTitle(rs.getString("mTitle"));
				m.setmContent(rs.getString("mContent"));
				m.setDepartment(rs.getString("department"));
				m.setPerName(rs.getString("perName"));
				m.setMemName(rs.getString("memName"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setProgress(rs.getString("progress"));
				m.setGrade(rs.getFloat("grade"));
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	//创建新任务
	public boolean createMission(DepMission dp) {
		PreparedStatement ps = null;
		String sql = "insert into mission (mTitle,mContent,department,perName, memName,startTime,endTime,progress,grade) value (?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dp.getmTitle());
			ps.setString(2, dp.getmContent());
			ps.setString(3, dp.getDepartment());
			ps.setString(4, dp.getPerName());
			ps.setString(5, dp.getMemName());
			ps.setString(6, dp.getStartTime());
			ps.setString(7, dp.getEndTime());
			ps.setString(8, dp.getProgress());
			ps.setFloat(9, dp.getGrade());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//查找任务
	public DepMission searchMission(DepMission dm) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select * from mission where mTitle = ? and startTime = ? and endTime = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getmTitle());
			ps.setString(2, dm.getStartTime());
			ps.setString(3, dm.getEndTime());
			rs = ps.executeQuery();
			if(rs.next()) {
				dm.setId(rs.getInt("id"));
				dm.setmTitle(rs.getString("mTitle"));
				dm.setmContent(rs.getString("mContent"));
				dm.setDepartment(rs.getString("department"));
				dm.setPerName(rs.getString("perName"));
				dm.setMemName(rs.getString("memName"));
				dm.setStartTime(rs.getString("startTime"));
				dm.setEndTime(rs.getString("endTime"));
				dm.setProgress(rs.getString("progress"));
				dm.setGrade(rs.getFloat("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dm;
	}
	
	//创建新任务
		public boolean updateMission(DepMission dp) {
			PreparedStatement ps = null;
			String sql = "update mission set mTitle = ?,mContent = ?,department = ?,perName = ?,memName = ?,startTime = ?,endTime = ?,progress = ?,grade = ? where id = ?";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dp.getmTitle());
				ps.setString(2, dp.getmContent());
				ps.setString(3, dp.getDepartment());
				ps.setString(4, dp.getPerName());
				ps.setString(5, dp.getMemName());
				ps.setString(6, dp.getStartTime());
				ps.setString(7, dp.getEndTime());
				ps.setString(8, dp.getProgress());
				ps.setFloat(9, dp.getGrade());
				ps.setInt(10, dp.getId());
				if(ps.executeUpdate()>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		//删除任务
		public boolean deleteMission(DepMission dm) {
			PreparedStatement ps = null;
			String sql = "delete from mission where mTitle = ? and startTime = ? and endTime = ?";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dm.getmTitle());
				ps.setString(2, dm.getStartTime());
				ps.setString(3, dm.getEndTime());
				if(ps.executeUpdate()>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
}
