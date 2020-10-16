package com.stuUnion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stuUnion.model.eClass;
import com.stuUnion.view.eClass_page;

public class ClassDao extends BaseDao {

	public List<eClass> getClassList(eClass ec) {
		List<eClass> eList = new ArrayList<eClass>();
		String sql = "select * from eclass";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet eq = ps.executeQuery();
			while (eq.next()) {
				eClass es = new eClass();
				es.setClassName(eq.getString("classname"));
				es.setYear(eq.getString("year"));
				es.setGrade1(eq.getFloat("grade1"));
				es.setGrade2(eq.getFloat("grade2"));
				es.setGrade3(eq.getFloat("grade3"));
				es.setGrade4(eq.getFloat("grade4"));
				// es.setTotal(eq.getDouble("total"));
				eList.add(es);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eList;
	}

	// 创建前判断是否已存在总分表
	public boolean isExistInEClass(eClass ec) {
		PreparedStatement prst = null;
		String sql = "select * from eclass where className = ? and year = ?";

		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, ec.getClassName());
			prst.setString(2, ec.getYear());
			ResultSet eq = prst.executeQuery();
			while (eq.next()) {
				if (null != eq) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 创建前判断是否已存在得分细则表
	public boolean isSameInEGrade(eClass ec) {
		PreparedStatement prst = null;
		String sql = "select * from egradedetail where className = ? and year = ? and month = ?";

		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, ec.getClassName());
			prst.setString(2, ec.getYear());
			prst.setString(3, ec.getMonth());
			ResultSet eq = prst.executeQuery();
			while (eq.next()) {
				if (null != eq) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 将相同班级学期的不同月份数据插入得分细则表
	public boolean insertEGrade(eClass ec) {
		PreparedStatement prst1 = null;
		String sql1 = "insert into egradedetail (year,className,month,grade1_1,grade1_2,grade1_3,grade1_4,grade1_5,grade2_1,grade2_2,grade2_3,grade2_4,grade2_5,grade2_6,grade3_1,grade3_2,grade3_3,grade3_4,grade3_5,grade3_6,"
				+ "grade4_1,grade4_2, grade4_3, grade4_4, total) Value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		try {
			prst1 = con.prepareStatement(sql1);
			prst1.setString(1, ec.getYear());
			prst1.setString(2, ec.getClassName());
			prst1.setString(3, ec.getMonth());
			prst1.setFloat(4, ec.getGrade1_1());
			prst1.setFloat(5, ec.getGrade1_2());
			prst1.setFloat(6, ec.getGrade1_3());
			prst1.setFloat(7, ec.getGrade1_4());
			prst1.setFloat(8, ec.getGrade1_5());
			prst1.setFloat(9, ec.getGrade2_1());
			prst1.setFloat(10, ec.getGrade2_2());
			prst1.setFloat(11, ec.getGrade2_3());
			prst1.setFloat(12, ec.getGrade2_4());
			prst1.setFloat(13, ec.getGrade2_5());
			prst1.setFloat(14, ec.getGrade2_6());
			prst1.setFloat(15, ec.getGrade3_1());
			prst1.setFloat(16, ec.getGrade3_2());
			prst1.setFloat(17, ec.getGrade3_3());
			prst1.setFloat(18, ec.getGrade3_4());
			prst1.setFloat(19, ec.getGrade3_5());
			prst1.setFloat(20, ec.getGrade3_6());
			prst1.setFloat(21, ec.getGrade4_1());
			prst1.setFloat(22, ec.getGrade4_2());
			prst1.setFloat(23, ec.getGrade4_3());
			prst1.setFloat(24, ec.getGrade4_4());
			prst1.setFloat(25, ec.getTotal());
			
			if(prst1.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 更新细分表
	public boolean updateEGrade(eClass ec) {
		PreparedStatement prst = null;

		try {
				String sql = "update egradedetail set grade1_1 =?, grade1_2 =?, grade1_3 =?, grade1_4 =?, grade1_5 =?, grade2_1 =?, grade2_2 =?, grade2_3 =?,grade2_4 =?,grade2_5 =?,grade2_6=?,grade3_1=?,grade3_2=?,grade3_3=?,grade3_4=?,grade3_5=?,grade3_6=?," 
						+ "grade4_1=?,grade4_2=?, grade4_3=?, grade4_4=?, total=? where year = ? and className = ? and month = ?;";
				prst = con.prepareStatement(sql);
				
				prst.setFloat(1, ec.getGrade1_1());
				prst.setFloat(2, ec.getGrade1_2());
				prst.setFloat(3, ec.getGrade1_3());
				prst.setFloat(4, ec.getGrade1_4());
				prst.setFloat(5, ec.getGrade1_5());
				prst.setFloat(6, ec.getGrade2_1());
				prst.setFloat(7, ec.getGrade2_2());
				prst.setFloat(8, ec.getGrade2_3());
				prst.setFloat(9, ec.getGrade2_4());
				prst.setFloat(10, ec.getGrade2_5());
				prst.setFloat(11, ec.getGrade2_6());
				prst.setFloat(12, ec.getGrade3_1());
				prst.setFloat(13, ec.getGrade3_2());
				prst.setFloat(14, ec.getGrade3_3());
				prst.setFloat(15, ec.getGrade3_4());
				prst.setFloat(16, ec.getGrade3_5());
				prst.setFloat(17, ec.getGrade3_6());
				prst.setFloat(18, ec.getGrade4_1());
				prst.setFloat(19, ec.getGrade4_2());
				prst.setFloat(20, ec.getGrade4_3());
				prst.setFloat(21, ec.getGrade4_4());
				prst.setFloat(22, ec.getTotal());
				prst.setString(23, ec.getYear());
				prst.setString(24, ec.getClassName());
				prst.setString(25, ec.getMonth());

			if(prst.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//合并（更新）总分表中的相同班级学期的不同月份数据
	public boolean updateEClass(eClass ec) {
		PreparedStatement prst = null;

		try {
			if ("第一月".equals(ec.getMonth())) {
				String sql = "update eclass set grade1 = ? where year = ? and className = ?;";
				prst = con.prepareStatement(sql);
				prst.setFloat(1, ec.getTotal());
				prst.setString(2, ec.getYear());
				prst.setString(3, ec.getClassName());
			}
			if ("第二月".equals(ec.getMonth())) {
				String sql = "update eclass set grade2 = ? where year = ? and className = ?;";
				prst = con.prepareStatement(sql);
				prst.setFloat(1, ec.getTotal());
				prst.setString(2, ec.getYear());
				prst.setString(3, ec.getClassName());
			}
			if ("第三月".equals(ec.getMonth())) {
				String sql = "update eclass set grade3 = ? where year = ? and className = ?;";
				prst = con.prepareStatement(sql);
				prst.setFloat(1, ec.getTotal());
				prst.setString(2, ec.getYear());
				prst.setString(3, ec.getClassName());
			}
			if ("第四月".equals(ec.getMonth())) {
				String sql = "update eclass set grade4 = ? where year = ? and className = ?;";
				prst = con.prepareStatement(sql);
				prst.setFloat(1, ec.getTotal());
				prst.setString(2, ec.getYear());
				prst.setString(3, ec.getClassName());
			}
			if(prst.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// 创建、编辑班级量化考核数据
	public boolean createECList(eClass ec) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "insert into egradedetail (year,className,month,grade1_1,grade1_2,grade1_3,grade1_4,grade1_5,grade2_1,grade2_2,grade2_3,grade2_4,grade2_5,grade2_6,grade3_1,grade3_2,grade3_3,grade3_4,grade3_5,grade3_6,"
				+ "grade4_1,grade4_2, grade4_3, grade4_4, total) Value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		try {
			prst1 = con.prepareStatement(sql1);
			prst1.setString(1, ec.getYear());
			prst1.setString(2, ec.getClassName());
			prst1.setString(3, ec.getMonth());
			prst1.setFloat(4, ec.getGrade1_1());
			prst1.setFloat(5, ec.getGrade1_2());
			prst1.setFloat(6, ec.getGrade1_3());
			prst1.setFloat(7, ec.getGrade1_4());
			prst1.setFloat(8, ec.getGrade1_5());
			prst1.setFloat(9, ec.getGrade2_1());
			prst1.setFloat(10, ec.getGrade2_2());
			prst1.setFloat(11, ec.getGrade2_3());
			prst1.setFloat(12, ec.getGrade2_4());
			prst1.setFloat(13, ec.getGrade2_5());
			prst1.setFloat(14, ec.getGrade2_6());
			prst1.setFloat(15, ec.getGrade3_1());
			prst1.setFloat(16, ec.getGrade3_2());
			prst1.setFloat(17, ec.getGrade3_3());
			prst1.setFloat(18, ec.getGrade3_4());
			prst1.setFloat(19, ec.getGrade3_5());
			prst1.setFloat(20, ec.getGrade3_6());
			prst1.setFloat(21, ec.getGrade4_1());
			prst1.setFloat(22, ec.getGrade4_2());
			prst1.setFloat(23, ec.getGrade4_3());
			prst1.setFloat(24, ec.getGrade4_4());
			prst1.setFloat(25, ec.getTotal());

			if ("第一月".equals(ec.getMonth())) {
				String sql2 = "insert into eclass (year,className,grade1) value (?,?,?)";
				prst2 = con.prepareStatement(sql2);
				prst2.setString(1, ec.getYear());
				prst2.setString(2, ec.getClassName());
				prst2.setFloat(3, ec.getTotal());
			}
			if ("第二月".equals(ec.getMonth())) {
				String sql2 = "insert into eclass (year,className,grade2) value (?,?,?)";
				prst2 = con.prepareStatement(sql2);
				prst2.setString(1, ec.getYear());
				prst2.setString(2, ec.getClassName());
				prst2.setFloat(3, ec.getTotal());
			}
			if ("第三月".equals(ec.getMonth())) {
				String sql2 = "insert into eclass (year,className,grade3) value (?,?,?)";
				prst2 = con.prepareStatement(sql2);
				prst2.setString(1, ec.getYear());
				prst2.setString(2, ec.getClassName());
				prst2.setFloat(3, ec.getTotal());
			}
			if ("第四月".equals(ec.getMonth())) {
				String sql2 = "insert into eclass (year,className,grade4) value (?,?,?)";
				prst2 = con.prepareStatement(sql2);
				prst2.setString(1, ec.getYear());
				prst2.setString(2, ec.getClassName());
				prst2.setFloat(3, ec.getTotal());
			}
			if (prst1.executeUpdate() > 0 && prst2.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// 删除班级量化考核数据
	public boolean delete(String className, String term) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "delete from eclass where className = ? and year = ?";
		String sql2 = "delete from egradedetail where className = ? and year = ?";

		try {
			prst1 = con.prepareStatement(sql1);
			prst2 = con.prepareStatement(sql2);
			prst1.setString(1, className);
			prst1.setString(2, term);
			prst2.setString(1, className);
			prst2.setString(2, term);
			if (prst1.executeUpdate() > 0 && prst2.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// 编辑时读取班级量化考核细则评分
	public eClass displayECList(eClass ec) {
		PreparedStatement prst1 = null, prst2 = null;
		String sql1 = "select * from egradedetail where className = ? and year = ? and month = ?";

		try {
			prst1 = con.prepareStatement(sql1);
			prst1.setString(1, ec.getClassName());
			prst1.setString(2, ec.getYear());
			prst1.setString(3, ec.getMonth());
			ResultSet eq = prst1.executeQuery();
			while (eq.next()) {
				ec.setClassName(eq.getString("className"));
				ec.setYear(eq.getString("year"));
				ec.setMonth(eq.getString("month"));
				ec.setGrade1_1(eq.getFloat("grade1_1"));
				ec.setGrade1_2(eq.getFloat("grade1_2"));
				ec.setGrade1_3(eq.getFloat("grade1_3"));
				ec.setGrade1_4(eq.getFloat("grade1_4"));
				ec.setGrade1_5(eq.getFloat("grade1_5"));
				ec.setGrade2_1(eq.getFloat("grade2_1"));
				ec.setGrade2_2(eq.getFloat("grade2_2"));
				ec.setGrade2_3(eq.getFloat("grade2_3"));
				ec.setGrade2_4(eq.getFloat("grade2_4"));
				ec.setGrade2_5(eq.getFloat("grade2_5"));
				ec.setGrade2_6(eq.getFloat("grade2_6"));
				ec.setGrade3_1(eq.getFloat("grade3_1"));
				ec.setGrade3_2(eq.getFloat("grade3_2"));
				ec.setGrade3_3(eq.getFloat("grade3_3"));
				ec.setGrade3_4(eq.getFloat("grade3_4"));
				ec.setGrade3_5(eq.getFloat("grade3_5"));
				ec.setGrade3_6(eq.getFloat("grade3_6"));
				ec.setGrade4_1(eq.getFloat("grade4_1"));
				ec.setGrade4_2(eq.getFloat("grade4_2"));
				ec.setGrade4_3(eq.getFloat("grade4_3"));
				ec.setGrade4_4(eq.getFloat("grade4_4"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ec;
	}
}
