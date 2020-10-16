package com.stuUnion.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.stuUnion.dao.MissionDao;
import com.stuUnion.model.DepMission;
import com.stuUnion.model.userType;

public class mission_page extends JFrame {
	private JPanel contentPane;
	private JTable missionTable;
	private JButton createMissionButton;
	private JButton editMissionButton;
	private JButton deleteMissionButton;

	public static userType userType1;
	public static Object userObject;

	/**
	 * Create the frame.
	 */
	public mission_page(userType userType1, Object userObject) {
		this.userType1 = userType1;
		this.userObject = userObject;
		setTitle("\u4EFB\u52A1\u8BE6\u60C5\u7BA1\u7406");
		setBackground(Color.GRAY);
		setSize(850, 535);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 13));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("\u90E8\u95E8\u4EFB\u52A1\u8BE6\u60C5");
		titleLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\icon\\\u5EFA\u8BAE_wps\u56FE\u7247.png"));
		titleLabel.setBackground(new Color(0, 0, 0));
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 832, 73);
		contentPane.add(titleLabel);

		JButton preButton = new JButton("\u4E3B\u5E2D\u56E2");
		preButton.setFont(new Font("宋体", Font.PLAIN, 16));
		preButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));

		preButton.setBounds(15, 90, 130, 55);
		preButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreMission(e);
			}

		});
		contentPane.add(preButton);

		JButton banGongButton = new JButton("\u529E\u516C\u5BA4");
		banGongButton.setFont(new Font("宋体", Font.PLAIN, 16));
		banGongButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));
		banGongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBMission(e);
			}
		});
		banGongButton.setBounds(15, 145, 130, 55);
		contentPane.add(banGongButton);

		JButton zuZhiButton = new JButton("\u7EC4\u7EC7\u90E8");
		zuZhiButton.setFont(new Font("宋体", Font.PLAIN, 16));
		zuZhiButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));
		zuZhiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showZMission(e);
			}
		});
		zuZhiButton.setBounds(15, 200, 130, 55);
		contentPane.add(zuZhiButton);

		JButton wenTiButton = new JButton("\u6587\u4F53\u90E8");
		wenTiButton.setFont(new Font("宋体", Font.PLAIN, 16));
		wenTiButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));
		wenTiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showWMission(e);
			}
		});
		wenTiButton.setBounds(15, 255, 130, 55);
		contentPane.add(wenTiButton);

		JButton xuanChuanButton = new JButton("\u5BA3\u4F20\u90E8");
		xuanChuanButton.setFont(new Font("宋体", Font.PLAIN, 16));
		xuanChuanButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));
		xuanChuanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showXMission(e);
			}
		});
		xuanChuanButton.setBounds(15, 310, 130, 55);
		contentPane.add(xuanChuanButton);

		JButton jianChaButton = new JButton("\u76D1\u5BDF\u90E8");
		jianChaButton.setFont(new Font("宋体", Font.PLAIN, 16));
		jianChaButton.setIcon(new ImageIcon(
				"C:\\Users\\dell\\Desktop\\StudentInfo (1)\\StudentInfo\\src\\images\\\u804C\u79F0\u8BC4\u5B9A.png"));
		jianChaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJMission(e);
			}
		});
		jianChaButton.setBounds(15, 365, 130, 55);
		contentPane.add(jianChaButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 90, 670, 330);
		contentPane.add(scrollPane);

		missionTable = new JTable();
		missionTable.setFont(new Font("宋体", Font.PLAIN, 16));
		missionTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4EFB\u52A1\u6807\u9898", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u8D1F\u8D23\u4EBA", "\u8FDB\u5EA6", "\u5F97\u5206"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		missionTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		missionTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		missionTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		missionTable.getColumnModel().getColumn(4).setPreferredWidth(55);
		missionTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		missionTable.setRowHeight(25);
		scrollPane.setViewportView(missionTable);
		setTableColumnLeft(missionTable);
		scrollPane.setViewportView(missionTable);

		JButton checkMissionButton = new JButton("\u67E5\u770B\u4EFB\u52A1");
		checkMissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkMission(e);
			}
		});
		checkMissionButton.setFont(new Font("宋体", Font.PLAIN, 16));
		checkMissionButton.setBounds(705, 434, 110, 27);
		contentPane.add(checkMissionButton);

		createMissionButton = new JButton("\u53D1\u5E03\u4EFB\u52A1");
		createMissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 1;
				DepMission dm = new DepMission();
				new missionDetail_page(userType1, userObject, flag, dm).setVisible(true);
			}
		});
		createMissionButton.setFont(new Font("宋体", Font.PLAIN, 16));
		createMissionButton.setBounds(580, 434, 110, 27);
		contentPane.add(createMissionButton);

		editMissionButton = new JButton("\u7F16\u8F91\u4EFB\u52A1");
		editMissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editMission(e);
			}
		});
		editMissionButton.setFont(new Font("宋体", Font.PLAIN, 16));
		editMissionButton.setBounds(455, 434, 110, 27);
		contentPane.add(editMissionButton);

		deleteMissionButton = new JButton("\u5220\u9664\u4EFB\u52A1");
		deleteMissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMission(e);
			}
		});
		deleteMissionButton.setFont(new Font("宋体", Font.PLAIN, 16));
		deleteMissionButton.setBounds(330, 435, 110, 27);
		contentPane.add(deleteMissionButton);

		if ("部长".equals(userType1.getType())) {
			deleteMissionButton.setVisible(false);
		}
		if ("干事".equals(userType1.getType())) {
			createMissionButton.setVisible(false);
			editMissionButton.setVisible(false);
			deleteMissionButton.setVisible(false);
		}
		setTable();
	}

	// 任务管理页面初始化
	private void setTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}

	}

	// 显示主席团发布任务
	protected void showPreMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("主席团");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 显示组织部发布任务
	protected void showZMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("组织部");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 显示宣传部发布任务
	protected void showXMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("宣传部");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 显示文体部发布任务
	protected void showWMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("文体部");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 显示监察部发布任务
	protected void showJMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("监察部");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 显示办公室发布任务
	protected void showBMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		dft.setRowCount(0);
		DepMission dm = new DepMission();
		dm.setDepartment("办公室");
		MissionDao mDao = new MissionDao();
		List<DepMission> mList = mDao.getPreMissionList(dm);
		mDao.closeDao();
		for (DepMission m : mList) {
			Vector v = new Vector();
			v.add(m.getmTitle());
			v.add(m.getStartTime());
			v.add(m.getEndTime());
			v.add(m.getPerName());
			v.add(m.getProgress());
			v.add(m.getGrade());
			dft.addRow(v);
		}
	}

	// 查看任务
	protected void checkMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		int index = missionTable.getSelectedRow();
		if (index == -1) {
			setTable();
			JOptionPane.showMessageDialog(this, "选中任意任务可查看详情");
			return;
		}
		int flag = 2;
		DepMission dm = new DepMission();
		DepMission dmTmp = new DepMission();
		dm.setmTitle(dft.getValueAt(missionTable.getSelectedRow(), 0).toString());
		dm.setStartTime(dft.getValueAt(missionTable.getSelectedRow(), 1).toString());
		dm.setEndTime(dft.getValueAt(missionTable.getSelectedRow(), 2).toString());
		MissionDao mDao = new MissionDao();
		dmTmp = mDao.searchMission(dm);
		mDao.closeDao();
		new missionDetail_page(userType1, userObject, flag, dmTmp).setVisible(true);
	}

	//编辑任务
	protected void editMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		int index = missionTable.getSelectedRow();
		if (index == -1) {
			setTable();
			JOptionPane.showMessageDialog(this, "请选中要编辑的数据");
			return;
		}
		int flag = 3;
		DepMission dm = new DepMission();
		DepMission dmTmp = new DepMission();
		dm.setmTitle(dft.getValueAt(missionTable.getSelectedRow(), 0).toString());
		dm.setStartTime(dft.getValueAt(missionTable.getSelectedRow(), 1).toString());
		dm.setEndTime(dft.getValueAt(missionTable.getSelectedRow(), 2).toString());
		MissionDao mDao = new MissionDao();
		dmTmp = mDao.searchMission(dm);
		mDao.closeDao();
		if (JOptionPane.showConfirmDialog(null, "确定要编辑"+ dm.getmTitle() +"吗?") == JOptionPane.OK_OPTION) {
			new missionDetail_page(userType1, userObject, flag, dmTmp).setVisible(true);
		}
	}
	
	//删除任务
	protected void deleteMission(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) missionTable.getModel();
		int index = missionTable.getSelectedRow();
		if (index == -1) {
			setTable();
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}

		DepMission dmTmp = new DepMission();
		dmTmp.setmTitle(dft.getValueAt(missionTable.getSelectedRow(), 0).toString());
		dmTmp.setStartTime(dft.getValueAt(missionTable.getSelectedRow(), 1).toString());
		dmTmp.setEndTime(dft.getValueAt(missionTable.getSelectedRow(), 2).toString());
		
		if (JOptionPane.showConfirmDialog(null, "确定要删除"+ dmTmp.getmTitle() +"吗?") != JOptionPane.OK_OPTION) {
			return;
		}

		MissionDao mDao = new MissionDao();
		if(!mDao.deleteMission(dmTmp)) {
			JOptionPane.showMessageDialog(this,"删除失败！");
		}
		JOptionPane.showMessageDialog(this,"删除成功！");
	}
	
	public void setTableColumnLeft(JTable table) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.LEFT);
		table.setDefaultRenderer(Object.class, r);
	}
}