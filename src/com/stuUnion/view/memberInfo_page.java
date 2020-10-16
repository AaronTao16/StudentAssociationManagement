package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.stuUnion.dao.AdminDao;
import com.stuUnion.dao.ClassDao;
import com.stuUnion.dao.MemberDao;
import com.stuUnion.dao.MinisterDao;
import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;
import com.stuUnion.model.userType;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class memberInfo_page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static userType userType1;
	public static Object userObject;
	private JTextField searchTextField;
	private JComboBox searchComboBox;

	/**
	 * Create the frame.
	 */
	public memberInfo_page(userType userType1, Object userObject) {
		setTitle("\u6210\u5458\u4FE1\u606F\u7BA1\u7406");
		this.userType1 = userType1;
		this.userObject = userObject;
		setSize(835, 487);
		this.setLocationRelativeTo(null);
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();

		JButton checkButton = new JButton("\u67E5\u770B");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkRow(e);
			}
		});

		JButton refreshButton = new JButton("\u5237\u65B0");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setTable();
			}
		});

		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow(e);
			}
		});
		deleteButton.setVisible(false);
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);

		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent as) {
				serachInfo(as);
			}
		});

		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] { "\u59D3\u540D", "\u72B6\u6001", "\u90E8\u95E8",
				"\u804C\u4F4D", "\u653F\u6CBB\u9762\u8C8C" }));

		JButton changeGradeButton = new JButton("\u6743\u9650\u5347\u7EA7");
		changeGradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				changeGrade(ag);
			}
		});
		changeGradeButton.setVisible(false);
		
		JButton editButton = new JButton("\u4FEE\u6539");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRow(e);
			}
		});
		editButton.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(changeGradeButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(refreshButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkButton)
						.addComponent(refreshButton)
						.addComponent(deleteButton)
						.addComponent(changeGradeButton)
						.addComponent(editButton))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				int rindex = table.getSelectedRow();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u5B66\u53F7", "\u73ED\u7EA7", "\u72B6\u6001", "\u90E8\u95E8", "\u804C\u4F4D", "\u653F\u6CBB\u9762\u8C8C", "\u8054\u7CFB\u7535\u8BDD", "\u7535\u5B50\u90AE\u7BB1"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(135);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		setTableColumnLeft(table);
		getContentPane().setLayout(groupLayout);
		if ("ָ����ʦ/��ϯ��".equals(userType1.getType())) {
			editButton.setVisible(true);
			deleteButton.setVisible(true);
			changeGradeButton.setVisible(true);
		}
		if ("����".equals(userType1.getType())) {
			editButton.setVisible(true);
		}
		setTable();

	}

	protected void changeGrade(ActionEvent ag) {
		// TODO Auto-generated method stub
		int rindex = table.getSelectedRow();
		int cindex = table.getSelectedColumn();
		int flag = 0;
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		String name = dft.getValueAt(table.getSelectedRow(), 0).toString();
		
		if(rindex == -1 && cindex == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ����Ȩ�޵�������!");
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "ȷ������"+ name +"��Ȩ����") != JOptionPane.OK_OPTION) {
			return;
		}
		
		int stuNum = Integer.parseInt(dft.getValueAt(table.getSelectedRow(), 1).toString());
		String usertype = dft.getValueAt(table.getSelectedRow(), 5).toString();
		
		if ("����".equals(usertype)) {
			Admin admin = new Admin();
			Minister min = new Minister();
			min.setStuNum(stuNum);
			
			MinisterDao minDao = new MinisterDao();
			min = minDao.checkInfo(min);//��ȡ������Ϣ
			min.setPassword(minDao.password(min));//��ȡ��¼����
			if(minDao.delete(min.getStuNum())) {
				flag = 1;
			}
			minDao.closeDao();
			
			AdminDao adminDao = new AdminDao();
			if(flag == 1 && adminDao.createMin(min)) {
				JOptionPane.showMessageDialog(this, "Ȩ������Ϊָ����ʦ/��ϯ��!");
			}
			adminDao.closeDao();
		}
		if ("����".equals(usertype)) {
			Member mem = new Member();
			Minister min = new Minister();
			mem.setStuNum(stuNum);
			
			MemberDao memDao = new MemberDao();
			mem = memDao.checkInfo(mem);//��ȡ������Ϣ
			mem.setPassword(memDao.password(mem));//��ȡ��¼����
			if(memDao.delete(mem.getStuNum())) {
				flag = 1;
			}
			memDao.closeDao();
			
			MinisterDao minDao = new MinisterDao();
			if(flag == 1 && minDao.createMin(mem)) {
				JOptionPane.showMessageDialog(this, "Ȩ������Ϊ����!");
			}
			minDao.closeDao();
		}
		setTable();
	}

	protected void checkRow(ActionEvent e) {
		// TODO Auto-generated method stub
		int flag = 1;
		int rindex = table.getSelectedRow();
		int cindex = table.getSelectedColumn();
		if(rindex == -1 && cindex == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�鿴��������!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		int stuNum = Integer.parseInt(dft.getValueAt(table.getSelectedRow(), 1).toString());
		String usertype = dft.getValueAt(table.getSelectedRow(), 5).toString();
		String password;

		if ("��ϯ".equals(usertype) || "�Ÿ�".equals(usertype) || "ָ����ʦ".equals(usertype)) {
			userType ut = userType.ADMIN;
			Admin admin = new Admin();
			admin.setStuNum(stuNum);
			AdminDao ad = new AdminDao();
			admin = ad.checkInfo(admin);
			ad.closeDao();
			new memInfoEdit_page(ut, admin, flag).setVisible(true);
		}
		if ("����".equals(usertype)) {
			userType ut = userType.MINISTER;
			Minister min = new Minister();
			min.setStuNum(stuNum);
			MinisterDao minDao = new MinisterDao();
			min = minDao.checkInfo(min);
			minDao.closeDao();
			new memInfoEdit_page(ut, min, flag).setVisible(true);
		}
		if ("����".equals(usertype)) {
			userType ut = userType.MEMBER;
			Member mem = new Member();
			mem.setStuNum(stuNum);
			MemberDao memDao = new MemberDao();
			mem = memDao.checkInfo(mem);
			memDao.closeDao();
			new memInfoEdit_page(ut, mem, flag).setVisible(true);
		}
	}

	// ��������������Ա
	protected void serachInfo(ActionEvent as) {
		// TODO Auto-generated method stub

		String condition = searchComboBox.getSelectedItem().toString();
		String result = searchTextField.getText();
		if (result.isEmpty()) {
			setTable();
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);

		Admin ad = new Admin();
		Member mem = new Member();
		Minister min = new Minister();
		AdminDao aDao = new AdminDao();
		List<Admin> aList = aDao.getInfoList(ad);
		aDao.closeDao();
		MemberDao memDao = new MemberDao();
		List<Member> memList = memDao.getInfoList(mem);
		memDao.closeDao();
		MinisterDao minDao = new MinisterDao();
		List<Minister> minList = minDao.getInfoList(min);
		minDao.closeDao();

		if ("����".equals(condition)) {
			for (Admin a : aList) {
				if (result.equals(a.getName())) {
					Vector v1 = new Vector();
					v1.add(a.getName());
					v1.add(a.getStuNum());
					v1.add(a.getStuClass());
					v1.add(a.getStatus());
					v1.add(a.getDep());
					v1.add(a.getPosition());
					v1.add(a.getPolitic());
					v1.add(a.getPhone());
					v1.add(a.getEmail());
					dft.addRow(v1);
				}
			}

			for (Member m1 : memList) {
				if (result.equals(m1.getName())) {
					Vector v1 = new Vector();
					v1.add(m1.getName());
					v1.add(m1.getStuNum());
					v1.add(m1.getStuClass());
					v1.add(m1.getStatus());
					v1.add(m1.getDep());
					v1.add(m1.getPosition());
					v1.add(m1.getPolitic());
					v1.add(m1.getPhone());
					v1.add(m1.getEmail());
					dft.addRow(v1);
				}
			}

			for (Minister m2 : minList) {
				if (result.equals(m2.getName())) {
					Vector v1 = new Vector();
					v1.add(m2.getName());
					v1.add(m2.getStuNum());
					v1.add(m2.getStuClass());
					v1.add(m2.getStatus());
					v1.add(m2.getDep());
					v1.add(m2.getPosition());
					v1.add(m2.getPolitic());
					v1.add(m2.getPhone());
					v1.add(m2.getEmail());
					dft.addRow(v1);
				}
			}
		}

		if ("״̬".equals(condition)) {
			for (Admin a : aList) {
				if (result.equals(a.getStatus())) {
					Vector v1 = new Vector();
					v1.add(a.getName());
					v1.add(a.getStuNum());
					v1.add(a.getStuClass());
					v1.add(a.getStatus());
					v1.add(a.getDep());
					v1.add(a.getPosition());
					v1.add(a.getPolitic());
					v1.add(a.getPhone());
					v1.add(a.getEmail());
					dft.addRow(v1);
				}
			}

			for (Member m1 : memList) {
				if (result.equals(m1.getStatus())) {
					Vector v1 = new Vector();
					v1.add(m1.getName());
					v1.add(m1.getStuNum());
					v1.add(m1.getStuClass());
					v1.add(m1.getStatus());
					v1.add(m1.getDep());
					v1.add(m1.getPosition());
					v1.add(m1.getPolitic());
					v1.add(m1.getPhone());
					v1.add(m1.getEmail());
					dft.addRow(v1);
				}
			}

			for (Minister m2 : minList) {
				if (result.equals(m2.getStatus())) {
					Vector v1 = new Vector();
					v1.add(m2.getName());
					v1.add(m2.getStuNum());
					v1.add(m2.getStuClass());
					v1.add(m2.getStatus());
					v1.add(m2.getDep());
					v1.add(m2.getPosition());
					v1.add(m2.getPolitic());
					v1.add(m2.getPhone());
					v1.add(m2.getEmail());
					dft.addRow(v1);
				}
			}
		}

		if ("����".equals(condition)) {
			for (Admin a : aList) {
				if (result.equals(a.getDep())) {
					Vector v1 = new Vector();
					v1.add(a.getName());
					v1.add(a.getStuNum());
					v1.add(a.getStuClass());
					v1.add(a.getStatus());
					v1.add(a.getDep());
					v1.add(a.getPosition());
					v1.add(a.getPolitic());
					v1.add(a.getPhone());
					v1.add(a.getEmail());
					dft.addRow(v1);
				}
			}

			for (Member m1 : memList) {
				if (result.equals(m1.getDep())) {
					Vector v1 = new Vector();
					v1.add(m1.getName());
					v1.add(m1.getStuNum());
					v1.add(m1.getStuClass());
					v1.add(m1.getStatus());
					v1.add(m1.getDep());
					v1.add(m1.getPosition());
					v1.add(m1.getPolitic());
					v1.add(m1.getPhone());
					v1.add(m1.getEmail());
					dft.addRow(v1);
				}
			}

			for (Minister m2 : minList) {
				if (result.equals(m2.getDep())) {
					Vector v1 = new Vector();
					v1.add(m2.getName());
					v1.add(m2.getStuNum());
					v1.add(m2.getStuClass());
					v1.add(m2.getStatus());
					v1.add(m2.getDep());
					v1.add(m2.getPosition());
					v1.add(m2.getPolitic());
					v1.add(m2.getPhone());
					v1.add(m2.getEmail());
					dft.addRow(v1);
				}
			}
		}

		if ("ְλ".equals(condition)) {
			for (Admin a : aList) {
				if (result.equals(a.getPosition())) {
					Vector v1 = new Vector();
					v1.add(a.getName());
					v1.add(a.getStuNum());
					v1.add(a.getStuClass());
					v1.add(a.getStatus());
					v1.add(a.getDep());
					v1.add(a.getPosition());
					v1.add(a.getPolitic());
					v1.add(a.getPhone());
					v1.add(a.getEmail());
					dft.addRow(v1);
				}
			}

			for (Member m1 : memList) {
				if (result.equals(m1.getPosition())) {
					Vector v1 = new Vector();
					v1.add(m1.getName());
					v1.add(m1.getStuNum());
					v1.add(m1.getStuClass());
					v1.add(m1.getStatus());
					v1.add(m1.getDep());
					v1.add(m1.getPosition());
					v1.add(m1.getPolitic());
					v1.add(m1.getPhone());
					v1.add(m1.getEmail());
					dft.addRow(v1);
				}
			}

			for (Minister m2 : minList) {
				if (result.equals(m2.getPosition())) {
					Vector v1 = new Vector();
					v1.add(m2.getName());
					v1.add(m2.getStuNum());
					v1.add(m2.getStuClass());
					v1.add(m2.getStatus());
					v1.add(m2.getDep());
					v1.add(m2.getPosition());
					v1.add(m2.getPolitic());
					v1.add(m2.getPhone());
					v1.add(m2.getEmail());
					dft.addRow(v1);
				}
			}
		}

		if ("������ò".equals(condition)) {
			for (Admin a : aList) {
				if (result.equals(a.getPolitic())) {
					Vector v1 = new Vector();
					v1.add(a.getName());
					v1.add(a.getStuNum());
					v1.add(a.getStuClass());
					v1.add(a.getStatus());
					v1.add(a.getDep());
					v1.add(a.getPosition());
					v1.add(a.getPolitic());
					v1.add(a.getPhone());
					v1.add(a.getEmail());
					dft.addRow(v1);
				}
			}

			for (Member m1 : memList) {
				if (result.equals(m1.getPolitic())) {
					Vector v1 = new Vector();
					v1.add(m1.getName());
					v1.add(m1.getStuNum());
					v1.add(m1.getStuClass());
					v1.add(m1.getStatus());
					v1.add(m1.getDep());
					v1.add(m1.getPosition());
					v1.add(m1.getPolitic());
					v1.add(m1.getPhone());
					v1.add(m1.getEmail());
					dft.addRow(v1);
				}
			}

			for (Minister m2 : minList) {
				if (result.equals(m2.getPolitic())) {
					Vector v1 = new Vector();
					v1.add(m2.getName());
					v1.add(m2.getStuNum());
					v1.add(m2.getStuClass());
					v1.add(m2.getStatus());
					v1.add(m2.getDep());
					v1.add(m2.getPosition());
					v1.add(m2.getPolitic());
					v1.add(m2.getPhone());
					v1.add(m2.getEmail());
					dft.addRow(v1);
				}
			}
		}

		if (dft.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "�������Ϊ�գ�");
		}
	}

	private void setTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		Admin ad = new Admin();
		Member mem = new Member();
		Minister min = new Minister();
		AdminDao aDao = new AdminDao();
		List<Admin> aList = aDao.getInfoList(ad);
		aDao.closeDao();
		for (Admin a : aList) {
			Vector v1 = new Vector();
			v1.add(a.getName());
			v1.add(a.getStuNum());
			v1.add(a.getStuClass());
			v1.add(a.getStatus());
			v1.add(a.getDep());
			v1.add(a.getPosition());
			v1.add(a.getPolitic());
			v1.add(a.getPhone());
			v1.add(a.getEmail());
			dft.addRow(v1);
		}

		MemberDao memDao = new MemberDao();
		List<Member> memList = memDao.getInfoList(mem);
		memDao.closeDao();
		for (Member m1 : memList) {
			Vector v1 = new Vector();
			v1.add(m1.getName());
			v1.add(m1.getStuNum());
			v1.add(m1.getStuClass());
			v1.add(m1.getStatus());
			v1.add(m1.getDep());
			v1.add(m1.getPosition());
			v1.add(m1.getPolitic());
			v1.add(m1.getPhone());
			v1.add(m1.getEmail());
			dft.addRow(v1);
		}

		MinisterDao minDao = new MinisterDao();
		List<Minister> minList = minDao.getInfoList(min);
		memDao.closeDao();
		for (Minister m2 : minList) {
			Vector v1 = new Vector();
			v1.add(m2.getName());
			v1.add(m2.getStuNum());
			v1.add(m2.getStuClass());
			v1.add(m2.getStatus());
			v1.add(m2.getDep());
			v1.add(m2.getPosition());
			v1.add(m2.getPolitic());
			v1.add(m2.getPhone());
			v1.add(m2.getEmail());
			dft.addRow(v1);
		}
	}

	protected void deleteRow(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ��������!");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "��ȷ��ɾ��ô��") != JOptionPane.OK_OPTION) {
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		int stuNum = Integer.parseInt(dft.getValueAt(table.getSelectedRow(), 1).toString());
		String userType = dft.getValueAt(table.getSelectedRow(), 5).toString();

		if ("��ϯ".equals(userType) || "�Ÿ�".equals(userType) || "ָ����ʦ".equals(userType)) {
			AdminDao adminDao = new AdminDao();
			if (adminDao.delete(stuNum)) {
				JOptionPane.showMessageDialog(this, "ɾ���ɹ�!");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��!");
			}
			adminDao.closeDao();
		}
		if ("����".equals(userType)) {
			MinisterDao minDao = new MinisterDao();
			if (minDao.delete(stuNum)) {
				JOptionPane.showMessageDialog(this, "ɾ���ɹ�!");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��!");
			}
			minDao.closeDao();
		}
		if ("����".equals(userType)) {
			MemberDao memDao = new MemberDao();
			if (memDao.delete(stuNum)) {
				JOptionPane.showMessageDialog(this, "ɾ���ɹ�!");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��!");
			}
			memDao.closeDao();
		}
		setTable();
	}

	protected void editRow(ActionEvent e) {
		// TODO Auto-generated method stub
		int flag = 2;
		int rindex = table.getSelectedRow();
		int cindex = table.getSelectedColumn();
		if(rindex == -1 && cindex == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�༭��������!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		int stuNum = Integer.parseInt(dft.getValueAt(table.getSelectedRow(), 1).toString());
		String usertype = dft.getValueAt(table.getSelectedRow(), 5).toString();

		if ("��ϯ".equals(usertype) || "�Ÿ�".equals(usertype) || "ָ����ʦ".equals(usertype)) {
			if(userType1.equals(userType.MINISTER)) {
				JOptionPane.showMessageDialog(this, "�����޸ģ�");
				return;
			}
			userType ut = userType.ADMIN;
			Admin admin = new Admin();
			admin.setStuNum(stuNum);
			AdminDao ad = new AdminDao();
			admin = ad.checkInfo(admin);
			ad.closeDao();
			new memInfoEdit_page(ut, admin, flag).setVisible(true);
		}
		if ("����".equals(usertype)) {
			if(userType1.equals(userType.MINISTER)) {
				JOptionPane.showMessageDialog(this, "�����޸ģ�");
				return;
			}
			userType ut = userType.MINISTER;
			Minister min = new Minister();
			min.setStuNum(stuNum);
			MinisterDao minDao = new MinisterDao();
			min = minDao.checkInfo(min);
			minDao.closeDao();
			new memInfoEdit_page(ut, min, flag).setVisible(true);
		}

		if ("����".equals(usertype)) {
			userType ut = userType.MEMBER;
			Member mem = new Member();
			mem.setStuNum(stuNum);
			MemberDao memDao = new MemberDao();
			mem = memDao.checkInfo(mem);
			memDao.closeDao();
			new memInfoEdit_page(ut, mem, flag).setVisible(true);
		}
		
	}
	public void setTableColumnLeft(JTable table) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.LEFT);
		table.setDefaultRenderer(Object.class, r);
	}
}
