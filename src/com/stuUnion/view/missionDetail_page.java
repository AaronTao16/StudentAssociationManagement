package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.stuUnion.dao.MissionDao;
import com.stuUnion.model.DepMission;
import com.stuUnion.model.userType;
import com.stuUnion.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class missionDetail_page extends JFrame {

	private JPanel contentPane;
	private userType userType1;
	private Object userObject;
	private int flag;
	private DepMission dm;
	private JTextField mTitleTextField;
	private JLabel startTimeLabel;
	private JTextField startTimeTextField;
	private JLabel endTimeLabel;
	private JTextField endTimeTextField;
	private JLabel perNameLabel;
	private JTextField perNameTextField;
	private JLabel memNameLabel;
	private JTextField memNameTextField;
	private JLabel departmentLabel;
	private JTextField departmentTextField;
	private JLabel mContentLabel;
	private JScrollPane scrollPane;
	private JTextArea mContentTextArea;
	private JLabel gradeLabel;
	private JTextField gradeTextField;
	private JButton confirmButton;
	private JLabel progressLabel;
	private JTextField progressTextField;



	/**
	 * Create the frame.
	 */
	public missionDetail_page(userType userType1, Object userObject, int flag, DepMission dm) {
		this.userType1 = userType1;
		this.userObject = userObject;
		this.flag = flag;
		this.dm = dm;
		setTitle("\u4EFB\u52A1\u8BE6\u60C5");
		setSize(475, 530);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel Label = new JLabel("\u4EFB\u52A1\u6807\u9898\uFF1A");
		
		mTitleTextField = new JTextField();
		mTitleTextField.setColumns(10);
		
		startTimeLabel = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		
		startTimeTextField = new JTextField();
		startTimeTextField.setToolTipText("\u683C\u5F0F\uFF1A2019-01-01");
		startTimeTextField.setColumns(10);
		
		endTimeLabel = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		
		endTimeTextField = new JTextField();
		endTimeTextField.setToolTipText("\u683C\u5F0F\uFF1A2019-01-01");
		endTimeTextField.setColumns(10);
		
		perNameLabel = new JLabel("\u8D1F\u8D23\u4EBA\uFF1A");
		perNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		perNameTextField = new JTextField();
		perNameTextField.setColumns(10);
		
		memNameLabel = new JLabel("\u8D1F\u8D23\u6210\u5458\uFF1A");
		
		memNameTextField = new JTextField();
		memNameTextField.setColumns(10);
		
		departmentLabel = new JLabel("\u8D1F\u8D23\u90E8\u95E8\uFF1A");
		
		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		
		mContentLabel = new JLabel("\u4E3B\u8981\u5185\u5BB9\uFF1A");
		
		scrollPane = new JScrollPane();
		
		gradeLabel = new JLabel("\u5F97\u5206\uFF1A");
		
		gradeTextField = new JTextField();
		gradeTextField.setColumns(10);
		
		confirmButton = new JButton("\u786E\u8BA4");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag == 1) {
					createMission(e);
				}
				if(flag == 3) {
					updateMission(e);
				}
			}
		});
		
		progressLabel = new JLabel("\u8FDB\u5EA6\uFF1A");
		
		progressTextField = new JTextField();
		progressTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(progressLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressTextField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(gradeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeTextField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(confirmButton)
							.addGap(41))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(mContentLabel)
								.addComponent(memNameLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(Label)
										.addGap(0)
										.addComponent(mTitleTextField))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(startTimeLabel)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(perNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(0)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(startTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(endTimeLabel)
												.addGap(0)
												.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(perNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(departmentLabel)
												.addGap(0)
												.addComponent(departmentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(memNameTextField))
										.addGap(1)))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
							.addGap(39))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(Label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(mTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(startTimeLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(startTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(endTimeLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(perNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(24)
								.addComponent(perNameLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(departmentLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(departmentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(memNameLabel)
						.addComponent(memNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(mContentLabel)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(progressLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(confirmButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(progressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(gradeLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(gradeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		mContentTextArea = new JTextArea();
		scrollPane.setViewportView(mContentTextArea);
		contentPane.setLayout(gl_contentPane);
		if(flag == 1) {
			gradeLabel.setVisible(false);
			gradeTextField.setVisible(false);
		}
		
		if(flag == 2) {
			confirmButton.setVisible(false);
			checkMission();
		}
		
		if(flag == 3) {
			if("部长".equals(userType1.getType())) {
				gradeLabel.setVisible(false);
				gradeTextField.setVisible(false);
			}
			mTitleTextField.setText(dm.getmTitle());
			startTimeTextField.setText(dm.getStartTime());
			endTimeTextField.setText(dm.getEndTime());
			perNameTextField.setText(dm.getPerName());
			memNameTextField.setText(dm.getMemName());
			departmentTextField.setText(dm.getDepartment());
			mContentTextArea.setText(dm.getmContent());
			gradeTextField.setText(dm.getGrade()+"");
			progressTextField.setText(dm.getProgress());
		}
	}


	//查看任务
	private void checkMission() {
		// TODO Auto-generated method stub
		mTitleTextField.setEditable(false);
		startTimeTextField.setEditable(false);
		endTimeTextField.setEditable(false);
		perNameTextField.setEditable(false);
		memNameTextField.setEditable(false);
		departmentTextField.setEditable(false);
		mContentTextArea.setEditable(false);
		gradeTextField.setEditable(false);
		progressTextField.setEditable(false);
		
		mTitleTextField.setText(dm.getmTitle());
		startTimeTextField.setText(dm.getStartTime());
		endTimeTextField.setText(dm.getEndTime());
		perNameTextField.setText(dm.getPerName());
		memNameTextField.setText(dm.getMemName());
		departmentTextField.setText(dm.getDepartment());
		mContentTextArea.setText(dm.getmContent());
		gradeTextField.setText(dm.getGrade()+"");
		progressTextField.setText(dm.getProgress());
		gradeTextField.setText(dm.getGrade()+"");
	}


	//新建任务
	private void createMission(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(StringUtil.isNull(mTitleTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务标题不能为空！");
			return;
		}
		if(StringUtil.isNull(startTimeTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务开始时间不能为空！");
			return;
		}
		if(StringUtil.isNull(endTimeTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务结束时间不能为空！");
			return;
		}
		if(StringUtil.isNull(perNameTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务负责人不能为空！");
			return;
		}
		if(StringUtil.isNull(departmentTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务负责部门不能为空！");
			return;
		}
		if(StringUtil.isNull(mContentTextArea.getText())) {
			JOptionPane.showMessageDialog(this, "任务内容不能为空！");
			return;
		}
		
		DepMission dm1 = new DepMission();
		dm1.setmTitle(mTitleTextField.getText());
		dm1.setStartTime(startTimeTextField.getText());
		dm1.setEndTime(endTimeTextField.getText());
		dm1.setPerName(perNameTextField.getText());
		dm1.setDepartment(departmentTextField.getText());
		dm1.setMemName(memNameTextField.getText());
		dm1.setProgress(progressTextField.getText());
		dm1.setmContent(mContentTextArea.getText());
		//dm.setGrade(Float.parseFloat(gradeTextField.getText()));
		MissionDao mDao = new MissionDao();
		if(!mDao.createMission(dm1)) {
			JOptionPane.showMessageDialog(this, "创建失败！");
			return;
		}
		JOptionPane.showMessageDialog(this, "创建成功！");
		mDao.closeDao();
		dispose();
	}
	
	//更新任务
	protected void updateMission(ActionEvent e) {
		// TODO Auto-generated method stub
		if(StringUtil.isNull(mTitleTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务标题不能为空！");
			return;
		}
		if(StringUtil.isNull(startTimeTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务开始时间不能为空！");
			return;
		}
		if(StringUtil.isNull(endTimeTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务结束时间不能为空！");
			return;
		}
		if(StringUtil.isNull(perNameTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务负责人不能为空！");
			return;
		}
		if(StringUtil.isNull(departmentTextField.getText())) {
			JOptionPane.showMessageDialog(this, "任务负责部门不能为空！");
			return;
		}
		if(StringUtil.isNull(mContentTextArea.getText())) {
			JOptionPane.showMessageDialog(this, "任务内容不能为空！");
			return;
		}
		
		DepMission dm1 = new DepMission();
		dm1.setId(dm.getId());
		dm1.setmTitle(mTitleTextField.getText());
		dm1.setStartTime(startTimeTextField.getText());
		dm1.setEndTime(endTimeTextField.getText());
		dm1.setPerName(perNameTextField.getText());
		dm1.setDepartment(departmentTextField.getText());
		dm1.setMemName(memNameTextField.getText());
		dm1.setProgress(progressTextField.getText());
		dm1.setmContent(mContentTextArea.getText());
		dm1.setGrade(Float.parseFloat(gradeTextField.getText()));
		MissionDao mDao = new MissionDao();
		if(!mDao.updateMission(dm1)) {
			JOptionPane.showMessageDialog(this, "更新失败！");
			return;
		}
		JOptionPane.showMessageDialog(this, "更新成功！");
		mDao.closeDao();
		dispose();
	}
}
