package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.stuUnion.dao.AdminDao;
import com.stuUnion.dao.MemberDao;
import com.stuUnion.dao.MinisterDao;
import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;
import com.stuUnion.model.userType;
import javax.swing.JTextArea;

public class memInfoEdit_page extends JFrame {

	public static userType userType1;
	public static Object userObject;
	public static int flag;
	
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField nameDispTextField;
	private JTextField stuNumDispTextField;
	private JTextField classDispTextField;
	private JTabbedPane photo_Pane;
	private JTextField statusDispTextField;
	private JTextField posDispTextField;
	private JTextField depDispTextField;
	private JTextField polDispTextField;
	private JTextField phoneDispTextField;
	private JTextField emailDispTextField;
	private JTextField passwordTextField;
	private JTextArea introDispTextArea;

	/**
	 * Create the frame.
	 */
	public memInfoEdit_page(userType userType1,Object userObject, int flag) {
		this.userType1 = userType1;
		this.userObject = userObject;
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539\u754C\u9762");
		setSize(770, 530);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel infoEditor_label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		infoEditor_label.setHorizontalAlignment(SwingConstants.CENTER);
		infoEditor_label.setFont(new Font("黑体", Font.PLAIN, 18));
		infoEditor_label.setBounds(270, 15, 185, 25);
		contentPane.add(infoEditor_label);
		
		nameDispTextField = new JTextField();
		nameDispTextField.setEditable(false);
		nameDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		nameDispTextField.setBounds(373, 80, 100, 26);
		contentPane.add(nameDispTextField);
		nameDispTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//password_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\password.png"));
		passwordLabel.setBounds(498, 83, 75, 20);
		contentPane.add(passwordLabel);
		
		JLabel stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		stuNumLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//id_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u5B66\u53F7 (1).png"));
		stuNumLabel.setBounds(298, 123, 75, 20);
		contentPane.add(stuNumLabel);
		
		stuNumDispTextField = new JTextField();
		stuNumDispTextField.setEditable(false);
		stuNumDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		stuNumDispTextField.setBounds(373, 120, 100, 26);
		contentPane.add(stuNumDispTextField);
		stuNumDispTextField.setColumns(10);
		
		JLabel classLabel = new JLabel("\u73ED\u7EA7\uFF1A");
		classLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		classLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//class_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u73ED\u7EA7\u540D\u79F0.png"));
		classLabel.setBounds(498, 123, 75, 20);
		contentPane.add(classLabel);
		
		classDispTextField = new JTextField();
		classDispTextField.setEditable(false);
		classDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		classDispTextField.setBounds(573, 120, 100, 26);
		contentPane.add(classDispTextField);
		classDispTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("\u72B6\u6001\uFF1A");
		statusLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		statusLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//major_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u4E13\u4E1A.png"));
		statusLabel.setBounds(298, 163, 75, 20);
		contentPane.add(statusLabel);
		
		JLabel phoneLabel = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		phoneLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//phoneNumber_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u8054\u7CFB\u7535\u8BDD.png"));
		phoneLabel.setBounds(293, 243, 80, 20);
		contentPane.add(phoneLabel);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//userName_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\userName.png"));
		nameLabel.setBounds(298, 83, 75, 20);
		contentPane.add(nameLabel);
		
		JLabel depLabel = new JLabel("\u90E8\u95E8\uFF1A");
		depLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		depLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//department_Llabel.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u804C\u52A1 \u804C\u4F4D.png"));
		depLabel.setBounds(498, 163, 75, 20);
		contentPane.add(depLabel);
		
		JLabel polLabel = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		polLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//politicStatus_label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u653F\u6CBB\u9762\u8C8C.png"));
		polLabel.setBounds(493, 203, 80, 20);
		contentPane.add(polLabel);
		
		JLabel emailLabel = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		emailLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		//email_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u7535\u5B50\u90AE\u7BB1.png"));
		emailLabel.setBounds(493, 243, 80, 20);
		contentPane.add(emailLabel);
		
		JLabel personalProfile_Label = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB\uFF1A");
		personalProfile_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		personalProfile_Label.setFont(new Font("黑体", Font.PLAIN, 16));
		//personalProfile_Label.setIcon(new ImageIcon("E:\\\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\\stuUnionInfo_xinhe\\src\\images\\\u4E2A\u4EBA\u7B80\u4ECB.png"));
		personalProfile_Label.setBounds(293, 283, 80, 20);
		contentPane.add(personalProfile_Label);
		
		JButton confirm_button = new JButton("\u786E\u8BA4\u4FEE\u6539");//确认修改键
		confirm_button.setFont(new Font("黑体", Font.PLAIN, 18));
		confirm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editInfo(e);
			}
		});
		confirm_button.setBounds(580, 440, 120, 30);
		contentPane.add(confirm_button);
		
		photo_Pane = new JTabbedPane(JTabbedPane.TOP);
		photo_Pane.setBounds(60, 76, 185, 227);
		contentPane.add(photo_Pane);
				
		//创建滚动板 指定显示组件
		JScrollPane introPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		introPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		introPane.setBounds(293, 313, 380, 110);
		contentPane.add(introPane);
		
		introDispTextArea = new JTextArea();
		introDispTextArea.setFont(new Font("黑体", Font.PLAIN, 16));
		introDispTextArea.setLineWrap(true);
		introDispTextArea.setWrapStyleWord(true);
		introPane.setViewportView(introDispTextArea);
		
		JLabel posLabel = new JLabel("\u804C\u4F4D\uFF1A");
		posLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		posLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		posLabel.setBounds(298, 203, 75, 20);
		contentPane.add(posLabel);
		
		statusDispTextField = new JTextField();
		statusDispTextField.setEditable(false);
		statusDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		statusDispTextField.setColumns(10);
		statusDispTextField.setBounds(373, 160, 100, 26);
		contentPane.add(statusDispTextField);
		
		posDispTextField = new JTextField();
		posDispTextField.setEditable(false);
		posDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		posDispTextField.setColumns(10);
		posDispTextField.setBounds(373, 200, 100, 26);
		contentPane.add(posDispTextField);
		
		depDispTextField = new JTextField();
		depDispTextField.setEditable(false);
		depDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		depDispTextField.setColumns(10);
		depDispTextField.setBounds(573, 160, 100, 26);
		contentPane.add(depDispTextField);
		
		polDispTextField = new JTextField();
		polDispTextField.setEditable(false);
		polDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		polDispTextField.setColumns(10);
		polDispTextField.setBounds(573, 200, 100, 26);
		contentPane.add(polDispTextField);
		
		phoneDispTextField = new JTextField();
		phoneDispTextField.setEditable(false);
		phoneDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		phoneDispTextField.setColumns(10);
		phoneDispTextField.setBounds(373, 240, 100, 26);
		contentPane.add(phoneDispTextField);
		
		emailDispTextField = new JTextField();
		emailDispTextField.setEditable(false);
		emailDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		emailDispTextField.setColumns(10);
		emailDispTextField.setBounds(573, 240, 100, 26);
		contentPane.add(emailDispTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setEditable(false);
		passwordTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(573, 80, 100, 26);
		contentPane.add(passwordTextField);
		if(flag == 1) {
			confirm_button.setVisible(false);
		}
		if(flag == 2) {
			nameDispTextField.setEditable(true);
			stuNumDispTextField.setEditable(true);
			classDispTextField.setEditable(true);
			statusDispTextField.setEditable(true);
			posDispTextField.setEditable(true);
			depDispTextField.setEditable(true);
			polDispTextField.setEditable(true);
			phoneDispTextField.setEditable(true);
			emailDispTextField.setEditable(true);
			introDispTextArea.setEditable(true);
		}
		showInfo(userType1,userObject);
	}

	private void showInfo(userType userType1, Object userObject) {
		// TODO Auto-generated method stub
		// 显示个人信息
		this.userType1 = userType1;
		this.userObject = userObject;
		
		if ("指导老师/主席团".equals(userType1.getType())) {
			String name = "未填";
			String password = "******";
			int stuNum = 00000000;
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String email = "未填";
			String politic = "未填";
			String intro = "未填";
			Object userObject1 = userObject;

			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin) userObject1;
			adminTmp = adminDao.displayInfo(admin);
			adminDao.closeDao();
			
			passwordTextField.setText(password);
			name = adminTmp.getName();
			nameDispTextField.setText(name);

			stuNum = adminTmp.getStuNum();
			stuNumDispTextField.setText(stuNum + "");

			stuClass = adminTmp.getStuClass();
			classDispTextField.setText(stuClass);

			dep = adminTmp.getDep();
			depDispTextField.setText(dep);

			position = adminTmp.getPosition();
			posDispTextField.setText(position);

			status = adminTmp.getStatus();
			statusDispTextField.setText(status);

			phone = adminTmp.getPhone();
			phoneDispTextField.setText(phone);
			
			email = adminTmp.getEmail();
			emailDispTextField.setText(email);

			politic = adminTmp.getPolitic();
			polDispTextField.setText(politic);

			intro = adminTmp.getIntro();
			introDispTextArea.setText(intro);
		}
		
		if ("部长".equals(userType1.getType())) {
			String name = "未填";
			int stuNum = 00000000;
			String password = "******";
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String politic = "未填";
			String intro = "未填";
			Object userObject1 = userObject;

			MinisterDao ministerDao = new MinisterDao();
			Minister minTmp = new Minister();
			Minister min = (Minister) userObject1;
			minTmp = ministerDao.displayInfo(min);
			ministerDao.closeDao();

			passwordTextField.setText(password);
			
			name = minTmp.getName();
			nameDispTextField.setText(name);

			stuNum = minTmp.getStuNum();
			stuNumDispTextField.setText(stuNum + "");

			stuClass = minTmp.getStuClass();
			classDispTextField.setText(stuClass);

			dep = minTmp.getDep();
			depDispTextField.setText(dep);

			position = minTmp.getPosition();
			posDispTextField.setText(position);

			status = minTmp.getStatus();
			statusDispTextField.setText(status);

			phone = minTmp.getPhone();
			phoneDispTextField.setText(phone);

			politic = minTmp.getPolitic();
			polDispTextField.setText(politic);

			intro = minTmp.getIntro();
			introDispTextArea.setText(intro);
		}
		
		if ("干事".equals(userType1.getType())) {
			String name = "未填";
			String password ="******";
			int stuNum = 00000000;
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String politic = "未填";
			String intro = "未填";
			Object userObject1 = userObject;

			MemberDao memberDao = new MemberDao();
			Member memTmp = new Member();
			Member mem = (Member) userObject1;
			memTmp = memberDao.displayInfo(mem);
			memberDao.closeDao();

			passwordTextField.setText(password);
			
			name = memTmp.getName();
			nameDispTextField.setText(name);

			stuNum = memTmp.getStuNum();
			stuNumDispTextField.setText(stuNum + "");

			stuClass = memTmp.getStuClass();
			classDispTextField.setText(stuClass);

			dep = memTmp.getDep();
			depDispTextField.setText(dep);

			position = memTmp.getPosition();
			posDispTextField.setText(position);

			status = memTmp.getStatus();
			statusDispTextField.setText(status);

			phone = memTmp.getPhone();
			phoneDispTextField.setText(phone);

			politic = memTmp.getPolitic();
			polDispTextField.setText(politic);

			intro = memTmp.getIntro();
			introDispTextArea.setText(intro);
		}
	}
	
	protected void editInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "确定更改吗？") != JOptionPane.OK_OPTION) {
			return;
		}
		
		if ("指导老师/主席团".equals(userType1.getType())) {

			Admin adminTmp = new Admin();//修改个人信息
			Admin admin = (Admin) userObject;
			adminTmp.setUserName(admin.getUserName());
			
			adminTmp.setName(nameDispTextField.getText());
			adminTmp.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			adminTmp.setStuClass(classDispTextField.getText());
			adminTmp.setDep(depDispTextField.getText());
			adminTmp.setPosition(posDispTextField.getText());
			adminTmp.setStatus(statusDispTextField.getText());
			adminTmp.setPhone(phoneDispTextField.getText());
			adminTmp.setEmail(emailDispTextField.getText());
			adminTmp.setPolitic(polDispTextField.getText());
			adminTmp.setIntro(introDispTextArea.getText());
			
			AdminDao adminDao = new AdminDao();
			if(adminDao.updatePerInfo(adminTmp)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			adminDao.closeDao();
		}
		
		if ("部长".equals(userType1.getType())) {
			
			Minister minTmp = new Minister();//修改个人信息
			Minister min = (Minister) userObject;
			minTmp.setUserName(min.getUserName());
			
			minTmp.setName(nameDispTextField.getText());
			minTmp.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			minTmp.setStuClass(classDispTextField.getText());
			minTmp.setDep(depDispTextField.getText());
			minTmp.setPosition(posDispTextField.getText());
			minTmp.setStatus(statusDispTextField.getText());
			minTmp.setPhone(phoneDispTextField.getText());
			minTmp.setEmail(emailDispTextField.getText());
			minTmp.setPolitic(polDispTextField.getText());
			minTmp.setIntro(introDispTextArea.getText());
			
			MinisterDao minDao = new MinisterDao();
			if(minDao.updatePerInfo(minTmp)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			minDao.closeDao();
		}
		
		if ("干事".equals(userType1.getType())) {
			
			Member memTmp = new Member();//修改个人信息
			Member mem = (Member) userObject;
			memTmp.setUserName(mem.getUserName());

			memTmp.setName(nameDispTextField.getText());
			memTmp.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			memTmp.setStuClass(classDispTextField.getText());
			memTmp.setDep(depDispTextField.getText());
			memTmp.setPosition(posDispTextField.getText());
			memTmp.setStatus(statusDispTextField.getText());
			memTmp.setPhone(phoneDispTextField.getText());
			memTmp.setEmail(emailDispTextField.getText());
			memTmp.setPolitic(polDispTextField.getText());
			memTmp.setIntro(introDispTextArea.getText());
			
			MemberDao memDao = new MemberDao();
			if(memDao.updatePerInfo(memTmp)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			memDao.closeDao();
		}
	}
}