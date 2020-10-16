package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.stuUnion.dao.ClassDao;
import com.stuUnion.model.eClass;
import com.stuUnion.util.StringUtil;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class newEClass_page extends JFrame {

	private JPanel contentPane;
	private JTextField classNameTextField;
	private JTextField termTextField;
	private JTable table;
	private JComboBox monthComboBox;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					newEClass_page frame = new newEClass_page();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public newEClass_page() {
		setSize(550, 700);
		this.setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel classNameLabel = new JLabel("\u73ED\u7EA7\uFF1A");

		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);

		JLabel termLabel = new JLabel("\u5B66\u671F\uFF1A");

		termTextField = new JTextField();
		termTextField.setColumns(10);

		JLabel monthLabel = new JLabel("\u6708\u4EFD\uFF1A");

		JScrollPane scrollPane = new JScrollPane();

		JButton confirmButton = new JButton("\u63D0\u4EA4");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aeec) {
				submitEClass(aeec);
			}
		});

		monthComboBox = new JComboBox();
		monthComboBox.addItem("第一月");
		monthComboBox.addItem("第二月");
		monthComboBox.addItem("第三月");
		monthComboBox.addItem("第四月");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(40).addComponent(classNameLabel)
										.addGap(0).addComponent(classNameTextField).addGap(25).addComponent(termLabel)
										.addGap(0).addComponent(termTextField).addGap(25).addComponent(monthLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, 91,
												GroupLayout.PREFERRED_SIZE)
										.addGap(40))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(457, Short.MAX_VALUE)
										.addComponent(confirmButton).addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(35).addComponent(classNameTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(40).addComponent(classNameLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(40).addComponent(termLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(35)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(termTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(monthLabel).addComponent(monthComboBox,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE).addComponent(confirmButton)
				.addContainerGap()));

		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "", "\u515A\u7EC4\u7EC7\u60C5\u51B5\uFF086\u5206\uFF09", "\u7EC4\u7EC7\u90E8", new Float(0.0f) },
				{ null, "\u56E2\u7EC4\u7EC7\u6D3B\u52A8\uFF086\u5206\uFF09", "\u7EC4\u7EC7\u90E8", new Float(0.0f) },
				{ "\u601D\u60F3\u6559\u80B2\uFF0830\u5206\uFF09", "\u5B66\u751F\u4F1A\u6D3B\u52A8\uFF086\u5206\uFF09",
						"\u7EC4\u7EC7\u90E8", new Float(0.0f) },
				{ null, "\u793E\u56E2\u6D3B\u52A8 \uFF086\u5206\uFF09", "\u7EC4\u7EC7\u90E8", new Float(0.0f) },
				{ null, "\u5BA3\u4F20\u5EFA\u8BBE \uFF086\u5206\uFF09", "\u5BA3\u4F20\u90E8", new Float(0.0f) },
				{ null, "", null, null },
				{ null, "\u8BFE\u7A0B\u5B66\u4E60 \uFF0810\u5206\uFF09", "\u529E\u516C\u5BA4", new Float(0.0f) },
				{ "", "\u5B66\u79D1\u7ADE\u8D5B \uFF086\u5206\uFF09", "\u529E\u516C\u5BA4", new Float(0.0f) },
				{ "\u5B66\u98CE\u5EFA\u8BBE\uFF0840\u5206\uFF09", "\u79D1\u7814\u521B\u65B0 \uFF086\u5206\uFF09",
						"\u6587\u4F53\u90E8", new Float(0.0f) },
				{ null, "\u793E\u4F1A\u5B9E\u8DF5 \uFF0810\u5206\uFF09", "\u6587\u4F53\u90E8", new Float(0.0f) },
				{ null, "\u6280\u80FD\u8BC1\u4E66 \uFF086\u5206\uFF09", "\u6587\u4F53\u90E8", new Float(0.0f) },
				{ null, "\u5B66\u4E1A\u9884\u8B66 \uFF082\u5206\uFF09", "\u529E\u516C\u5BA4", new Float(0.0f) },
				{ null, null, null, null },
				{ null, "\u4F53\u80B2\u6D3B\u52A8 \uFF089\u5206\uFF09", "\u76D1\u5BDF\u90E8", new Float(0.0f) },
				{ null, "\u536B\u751F\u6D3B\u52A8 \uFF089\u5206\uFF09", "\u529E\u516C\u5BA4", new Float(0.0f) },
				{ "\u65E5\u5E38\u7BA1\u7406\uFF0830\u5206\uFF09",
						"\u665A\u70B9\u540D\u3001\u665A\u5F52 \uFF085\u5206\uFF09", "\u76D1\u5BDF\u90E8",
						new Float(0.0f) },
				{ null, "\u73ED\u7EA7\u5B66\u4E60 \uFF085\u5206\uFF09", "\u529E\u516C\u5BA4", new Float(0.0f) },
				{ null, "\u5176\u4ED6\u96C6\u4F53\u6D3B\u52A8 \uFF082\u5206\uFF09", "\u529E\u516C\u5BA4",
						new Float(0.0f) },
				{ null, "\u9644\u5F55", "\u6587\u4F53\u90E8", new Float(0.0f) }, { "", null, null, null },
				{ "\u603B\u5206", null, null, null }, { null, "\u4EBA\u8EAB\u5B89\u5168", "\u529E\u516C\u5BA4", null },
				{ null, "\u5BDD\u5BA4\u5B89\u5168", "\u529E\u516C\u5BA4", null },
				{ "\u5B89\u5168\u7A33\u5B9A", "\u8FDD\u7EAA\u8FDD\u6CD5", "\u529E\u516C\u5BA4", null },
				{ null, "\u7F51\u7EDC\u5B89\u5168", "\u529E\u516C\u5BA4", null },
				{ null, "\u610F\u8BC6\u5F62\u6001", "\u529E\u516C\u5BA4", null }, },
				new String[] { "\u4E00\u7EA7\u6307\u6807", "\u4E8C\u7EA7\u6307\u6807", "\u8D1F\u8D23\u90E8\u95E8",
						"\u5F97\u5206" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(126);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.setRowHeight(30);
		setTableColumnCenter(table);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitEClass(ActionEvent aeec) {
		// TODO Auto-generated method stub
		String className, term, month;
		float grade1_1, grade1_2, grade1_3, grade1_4, grade1_5, grade1;
		float grade2_1, grade2_2, grade2_3, grade2_4, grade2_5, grade2_6, grade2;
		float grade3_1, grade3_2, grade3_3, grade3_4, grade3_5, grade3_6, grade3;
		float grade4_1, grade4_2, grade4_3, grade4_4, grade4, total;
		className = classNameTextField.getText().toString();
		term = termTextField.getText().toString();
		month = (String) monthComboBox.getSelectedItem();

		if (StringUtil.isNull(className)) {
			JOptionPane.showMessageDialog(this, "班级不能为空！");
			return;
		}
		if (StringUtil.isNull(term)) {
			JOptionPane.showMessageDialog(this, "学期不能为空！");
			return;
		}

		grade1_1 = Float.parseFloat(table.getValueAt(0, 3).toString());
		grade1_2 = Float.parseFloat(table.getValueAt(1, 3).toString());
		grade1_3 = Float.parseFloat(table.getValueAt(2, 3).toString());
		grade1_4 = Float.parseFloat(table.getValueAt(3, 3).toString());
		grade1_5 = Float.parseFloat(table.getValueAt(4, 3).toString());
		grade1 = grade1_1 + grade1_2 + grade1_3 + grade1_4 + grade1_5;
		if(StringUtil.outOfRange6(grade1_1)) {
			JOptionPane.showMessageDialog(this, "党组织情况得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade1_2)) {
			JOptionPane.showMessageDialog(this, "团组织活动得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade1_3)) {
			JOptionPane.showMessageDialog(this, "学生会活动得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade1_4)) {
			JOptionPane.showMessageDialog(this, "社团活动得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade1_5)) {
			JOptionPane.showMessageDialog(this, "宣传建设得分超过上限！");
			return;
		}

		grade2_1 = Float.parseFloat(table.getValueAt(6, 3).toString());
		grade2_2 = Float.parseFloat(table.getValueAt(7, 3).toString());
		grade2_3 = Float.parseFloat(table.getValueAt(8, 3).toString());
		grade2_4 = Float.parseFloat(table.getValueAt(9, 3).toString());
		grade2_5 = Float.parseFloat(table.getValueAt(10, 3).toString());
		grade2_6 = Float.parseFloat(table.getValueAt(11, 3).toString());
		grade2 = grade2_1 + grade2_2 + grade2_3 + grade2_4 + grade2_5 + grade2_6;
		if(StringUtil.outOfRange10(grade2_1)) {
			JOptionPane.showMessageDialog(this, "课程学习得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade2_2)) {
			JOptionPane.showMessageDialog(this, "学科竞赛得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade2_3)) {
			JOptionPane.showMessageDialog(this, "科研创新得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange10(grade2_4)) {
			JOptionPane.showMessageDialog(this, "社会实践得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange6(grade2_5)) {
			JOptionPane.showMessageDialog(this, "技能证书得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange2(grade2_6)) {
			JOptionPane.showMessageDialog(this, "学业预警得分超过上限！");
			return;
		}

		grade3_1 = Float.parseFloat(table.getValueAt(13, 3).toString());
		grade3_2 = Float.parseFloat(table.getValueAt(14, 3).toString());
		grade3_3 = Float.parseFloat(table.getValueAt(15, 3).toString());
		grade3_4 = Float.parseFloat(table.getValueAt(16, 3).toString());
		grade3_5 = Float.parseFloat(table.getValueAt(17, 3).toString());
		grade3_6 = Float.parseFloat(table.getValueAt(18, 3).toString());
		grade3 = grade3_1 + grade3_2 + grade3_3 + grade3_4 + grade3_5 + grade3_6;
		if(StringUtil.outOfRange9(grade3_1)) {
			JOptionPane.showMessageDialog(this, "体育活动得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange9(grade3_2)) {
			JOptionPane.showMessageDialog(this, "卫生活动得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange5(grade3_3)) {
			JOptionPane.showMessageDialog(this, "晚点名、晚归得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange5(grade3_4)) {
			JOptionPane.showMessageDialog(this, "班级学习得分超过上限！");
			return;
		}
		if(StringUtil.outOfRange2(grade3_5)) {
			JOptionPane.showMessageDialog(this, "其他集体活动得分超过上限！");
			return;
		}
		
		table.setValueAt(grade1, 5, 3);
		table.setValueAt(grade2, 12, 3);
		table.setValueAt(grade3, 19, 3);
		total = grade1 + grade2 + grade3;
		table.setValueAt(total, 20, 3);

		ClassDao cd = new ClassDao();
		eClass ec = new eClass();
		ec.setGrade1_1(grade1_1);
		ec.setGrade1_2(grade1_2);
		ec.setGrade1_3(grade1_3);
		ec.setGrade1_4(grade1_4);
		ec.setGrade1_5(grade1_5);
		ec.setGrade2_1(grade2_1);
		ec.setGrade2_2(grade2_2);
		ec.setGrade2_3(grade2_3);
		ec.setGrade2_4(grade2_4);
		ec.setGrade2_5(grade2_5);
		ec.setGrade2_6(grade2_6);
		ec.setGrade3_1(grade3_1);
		ec.setGrade3_2(grade3_2);
		ec.setGrade3_3(grade3_3);
		ec.setGrade3_4(grade3_4);
		ec.setGrade3_5(grade3_5);
		ec.setGrade3_6(grade3_6);
		ec.setTotal(total);

		ec.setClassName(className);
		ec.setYear(term);
		ec.setMonth(month);
		
		if (cd.isExistInEClass(ec)) {
			if (cd.isSameInEGrade(ec)) {
				JOptionPane.showMessageDialog(this, className + "在" + term + "学期" + month + "的数据已创建，请直接修改！");
				return;
			} else {
				if(cd.insertEGrade(ec) && cd.updateEClass(ec)) {
					JOptionPane.showMessageDialog(this, "更新班级信息成功！");
					this.dispose();
				}
			}
		} else {
			if (cd.createECList(ec)) {
				JOptionPane.showMessageDialog(this, "新建班级信息成功！");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "新建班级信息失败！");
				return;
			}
		}
		cd.closeDao();
	}

	public void setTableColumnCenter(JTable table) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
	}
}
