package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.ScrollPane;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import com.stuUnion.dao.ClassDao;
import com.stuUnion.model.eClass;
import com.stuUnion.model.userType;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class eClass_page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static userType userType1;
	public static Object userObject;


	/**
	 * Create the frame.
	 */
	public eClass_page(userType userType1,Object userObject) {
		setResizable(false);
		setTitle("\u73ED\u7EA7\u91CF\u5316\u8003\u6838");
		this.userType1 = userType1;
		this.userObject = userObject;
		setBounds(100, 100, 835, 487);
		this.setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		
		JButton createClassButton = new JButton("\u65B0\u5EFA");
		createClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newEClass_page ec = new newEClass_page();
				ec.setVisible(true);
			}
		});
		createClassButton.setVisible(false);
		
		JButton editButton = new JButton("\u7F16\u8F91");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRow(e);
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
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(createClassButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(refreshButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editButton)
						.addComponent(refreshButton)
						.addComponent(createClassButton)
						.addComponent(deleteButton))
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
				" \u73ED\u7EA7", "\u5B66\u671F", "\u7B2C\u4E00\u6708", "\u7B2C\u4E8C\u6708", "\u7B2C\u4E09\u6708", "\u7B2C\u56DB\u6708", "\u603B\u5F97\u5206"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		if ("指导老师/主席团".equals(userType1.getType()) || "部长".equals(userType1.getType())) {
			createClassButton.setVisible(true);
			deleteButton.setVisible(true);
		}
		setTable();
		
	}

	protected void editRow(ActionEvent e) {
		// TODO Auto-generated method stub
		int rindex = table.getSelectedRow();
		int cindex = table.getSelectedColumn();
		if(rindex == -1 && cindex == -1){
			JOptionPane.showMessageDialog(this, "请选中要编辑的数据行!");
			return;
		}

		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		String className = dft.getValueAt(rindex, 0).toString();
		String term = dft.getValueAt(rindex, 1).toString();
		if(cindex == 0 || cindex == 1 || cindex == 6) {
			JOptionPane.showMessageDialog(this, "请选中要编辑的月份!");
			return;
		}
		String month = dft.getColumnName(cindex).toString();
		if (JOptionPane.showConfirmDialog(this, "确定要修改" + className + "班在" + term + "学期" + month + "的数据吗?") == JOptionPane.OK_OPTION) {
			editEClass_page ec = new editEClass_page(className, term, month);
			ec.setVisible(true);
		}
	}

	protected void deleteRow(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		String className = dft.getValueAt(table.getSelectedRow(), 0).toString();
		String term = dft.getValueAt(table.getSelectedRow(), 1).toString();
		ClassDao classDao = new ClassDao();
		if(classDao.delete(className, term)){
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		classDao.closeDao();
		
		setTable();
	}

	private void setTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		eClass eclass = new eClass();
		ClassDao ecDao = new ClassDao();
		List<eClass> classList = ecDao.getClassList(eclass);
		for(eClass ec : classList) {
			Vector v = new Vector();
			float total = 0;
			int flag = 0;
			v.add(ec.getClassName());
			v.add(ec.getYear());
			if(0 != ec.getGrade1())
				flag++;
			if(0 != ec.getGrade2())
				flag++;
			if(0 != ec.getGrade3())
				flag++;
			if(0 != ec.getGrade4())
				flag++;
			total = (float) ((ec.getGrade1() + ec.getGrade2() + ec.getGrade3() + ec.getGrade4())/flag);
			total = (float) Math.round(total * 100)/100;
			v.add(ec.getGrade1());
			v.add(ec.getGrade2());
			v.add(ec.getGrade3());
			v.add(ec.getGrade4());
			v.add(total);
			dft.addRow(v);
		}
		ecDao.closeDao();
	}
	
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		table.getSelectedRow();
		//editClassNameTextField.setText(dft.getValueAt(table.getSelectedRow(), 1).toString());
		//editClassInfoTextArea.setText(dft.getValueAt(table.getSelectedRow(), 2).toString());
	}
}
