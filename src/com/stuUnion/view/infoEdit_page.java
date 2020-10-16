package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.stuUnion.dao.AdminDao;
import com.stuUnion.dao.MemberDao;
import com.stuUnion.dao.MinisterDao;
import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;
import com.stuUnion.model.userType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.Canvas;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;


public class infoEdit_page extends JFrame{
	
	public static userType userType1;
	public static Object userObject;
	
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
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InfoEdit frame = new InfoEdit();
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
	public infoEdit_page(userType userType1,Object userObject) {
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
		nameDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		nameDispTextField.setBounds(365, 97, 100, 26);
		contentPane.add(nameDispTextField);
		nameDispTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		passwordLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u5BC6\u7801.png")));
		passwordLabel.setBounds(500, 100, 75, 20);
		contentPane.add(passwordLabel);
		
		JLabel stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		stuNumLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		stuNumLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u5B66\u53F7.png")));
		stuNumLabel.setBounds(290, 140, 75, 20);
		contentPane.add(stuNumLabel);
		
		stuNumDispTextField = new JTextField();
		stuNumDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		stuNumDispTextField.setBounds(365, 137, 100, 26);
		contentPane.add(stuNumDispTextField);
		stuNumDispTextField.setColumns(10);
		
		JLabel classLabel = new JLabel("\u73ED\u7EA7\uFF1A");
		classLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		classLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		classLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		classLabel.setBounds(500, 140, 75, 20);
		contentPane.add(classLabel);
		
		classDispTextField = new JTextField();
		classDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		classDispTextField.setBounds(575, 137, 100, 26);
		contentPane.add(classDispTextField);
		classDispTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("\u72B6\u6001\uFF1A");
		statusLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		statusLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		statusLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u72B6\u6001.png")));
		statusLabel.setBounds(290, 180, 75, 20);
		contentPane.add(statusLabel);
		
		JLabel phoneLabel = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		phoneLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		phoneLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u8054\u7CFB\u7535\u8BDD.png")));
		phoneLabel.setBounds(265, 260, 100, 20);
		contentPane.add(phoneLabel);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		nameLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/userName.png")));
		nameLabel.setBounds(290, 100, 75, 20);
		contentPane.add(nameLabel);
		
		JLabel depLabel = new JLabel("\u90E8\u95E8\uFF1A");
		depLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		depLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		depLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u90E8\u95E8.png")));
		depLabel.setBounds(500, 180, 75, 20);
		contentPane.add(depLabel);
		
		JLabel polLabel = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		polLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		polLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		polLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u653F\u6CBB\u9762\u8C8C.png")));
		polLabel.setBounds(475, 220, 100, 20);
		contentPane.add(polLabel);
		
		JLabel emailLabel = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		emailLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u7535\u5B50\u90AE\u7BB1.png")));
		emailLabel.setBounds(475, 260, 100, 20);
		contentPane.add(emailLabel);
		
		JLabel personalProfile_Label = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB\uFF1A");
		personalProfile_Label.setHorizontalAlignment(SwingConstants.LEFT);
		personalProfile_Label.setFont(new Font("黑体", Font.PLAIN, 16));
		personalProfile_Label.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u4E2A\u4EBA\u7B80\u4ECB.png")));
		personalProfile_Label.setBounds(285, 300, 120, 20);
		contentPane.add(personalProfile_Label);
		
		JButton confirm_button = new JButton("\u786E\u8BA4\u4FEE\u6539");//确认修改键
		confirm_button.setFont(new Font("黑体", Font.PLAIN, 18));
		confirm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editInfo(e);
			}
		});
		confirm_button.setBounds(610, 450, 120, 30);
		contentPane.add(confirm_button);
		
		photo_Pane = new JTabbedPane(JTabbedPane.TOP);
		photo_Pane.setBounds(60, 80, 185, 227);
		contentPane.add(photo_Pane);
				
		//创建滚动板 指定显示组件
		JScrollPane introPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		introPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		introPane.setBounds(285, 330, 380, 110);
		contentPane.add(introPane);
		
		introDispTextArea = new JTextArea();
		introDispTextArea.setFont(new Font("黑体", Font.PLAIN, 16));
		introDispTextArea.setLineWrap(true);
		introDispTextArea.setWrapStyleWord(true);
		introPane.setViewportView(introDispTextArea);
		
		JLabel posLabel = new JLabel("\u804C\u4F4D\uFF1A");
		posLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		posLabel.setIcon(new ImageIcon(infoEdit_page.class.getResource("/images/\u804C\u52A1 \u804C\u4F4D.png")));
		posLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		posLabel.setBounds(290, 220, 75, 20);
		contentPane.add(posLabel);
		
		statusDispTextField = new JTextField();
		statusDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		statusDispTextField.setColumns(10);
		statusDispTextField.setBounds(365, 177, 100, 26);
		contentPane.add(statusDispTextField);
		
		posDispTextField = new JTextField();
		posDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		posDispTextField.setColumns(10);
		posDispTextField.setBounds(365, 217, 100, 26);
		contentPane.add(posDispTextField);
		
		depDispTextField = new JTextField();
		depDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		depDispTextField.setColumns(10);
		depDispTextField.setBounds(575, 177, 100, 26);
		contentPane.add(depDispTextField);
		
		polDispTextField = new JTextField();
		polDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		polDispTextField.setColumns(10);
		polDispTextField.setBounds(575, 217, 100, 26);
		contentPane.add(polDispTextField);
		
		phoneDispTextField = new JTextField();
		phoneDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		phoneDispTextField.setColumns(10);
		phoneDispTextField.setBounds(365, 257, 100, 26);
		contentPane.add(phoneDispTextField);
		
		emailDispTextField = new JTextField();
		emailDispTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailDispTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		emailDispTextField.setColumns(10);
		emailDispTextField.setBounds(575, 257, 100, 26);
		contentPane.add(emailDispTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("黑体", Font.PLAIN, 16));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(575, 97, 100, 26);
		contentPane.add(passwordTextField);
		
		showInfo(userType1,userObject);
	}

	private void showInfo(userType userType1, Object userObject) {
		// TODO Auto-generated method stub
		// 显示个人信息
		this.userType1 = userType1;
		this.userObject = userObject;
		
		if ("指导老师/主席团".equals(userType1.getType())) {
			String name = "未填";
			String password;
			int stuNum = 00000000;
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String email = "未填";
			String politic = "未填";
			String intro = "未填";

			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin adminTmp1 = new Admin();
			Admin admin = (Admin) userObject;
			adminTmp = adminDao.displayInfo(admin);
			adminTmp1 = adminDao.login(admin);
			adminDao.closeDao();

			password = adminTmp1.getPassword();
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
			String password;
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String politic = "未填";
			String intro = "未填";

			MinisterDao ministerDao = new MinisterDao();
			Minister minTmp = new Minister();
			Minister minTmp1 = new Minister();
			Minister min = (Minister) userObject;
			minTmp = ministerDao.displayInfo(min);
			minTmp1 = ministerDao.login(min);
			ministerDao.closeDao();

			password = minTmp1.getPassword();
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
			String password;
			int stuNum = 00000000;
			String stuClass = "未填";
			String dep = "未填";
			String position = "未填";
			String status = "未填";
			String phone = "未填";
			String politic = "未填";
			String intro = "未填";

			MemberDao memberDao = new MemberDao();
			Member memTmp = new Member();
			Member memTmp1 = new Member();
			Member mem = (Member) userObject;
			memTmp = memberDao.displayInfo(mem);
			memTmp1 = memberDao.login(mem);
			memberDao.closeDao();

			password = memTmp1.getPassword();
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

			Admin adminTmp = new Admin();//修改密码
			Admin adminTmp1 = new Admin();//修改个人信息
			Admin admin = (Admin) userObject;
			adminTmp.setUserName(admin.getUserName());
			adminTmp1.setUserName(admin.getUserName());

			adminTmp.setPassword(passwordTextField.getText());
			
			adminTmp1.setName(nameDispTextField.getText());
			adminTmp1.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			adminTmp1.setStuClass(classDispTextField.getText());
			adminTmp1.setDep(depDispTextField.getText());
			adminTmp1.setPosition(posDispTextField.getText());
			adminTmp1.setStatus(statusDispTextField.getText());
			adminTmp1.setPhone(phoneDispTextField.getText());
			adminTmp1.setEmail(emailDispTextField.getText());
			adminTmp1.setPolitic(polDispTextField.getText());
			adminTmp1.setIntro(introDispTextArea.getText());
			
			AdminDao adminDao = new AdminDao();
			if(adminDao.updateInfo(adminTmp) && adminDao.updatePerInfo(adminTmp1)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			adminDao.closeDao();
		}
		
		if ("部长".equals(userType1.getType())) {
			
			Minister minTmp = new Minister();//修改密码
			Minister minTmp1 = new Minister();//修改个人信息
			Minister min = (Minister) userObject;
			minTmp.setUserName(min.getUserName());
			minTmp1.setUserName(min.getUserName());

			minTmp.setPassword(passwordTextField.getText());
			
			minTmp1.setName(nameDispTextField.getText());
			minTmp1.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			minTmp1.setStuClass(classDispTextField.getText());
			minTmp1.setDep(depDispTextField.getText());
			minTmp1.setPosition(posDispTextField.getText());
			minTmp1.setStatus(statusDispTextField.getText());
			minTmp1.setPhone(phoneDispTextField.getText());
			minTmp1.setEmail(emailDispTextField.getText());
			minTmp1.setPolitic(polDispTextField.getText());
			minTmp1.setIntro(introDispTextArea.getText());
			
			MinisterDao minDao = new MinisterDao();
			if(minDao.updateInfo(minTmp) && minDao.updatePerInfo(minTmp1)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			minDao.closeDao();
		}
		
		if ("干事".equals(userType1.getType())) {
			
			Member memTmp = new Member();//修改密码
			Member memTmp1 = new Member();//修改个人信息
			Member mem = (Member) userObject;
			memTmp.setUserName(mem.getUserName());
			memTmp1.setUserName(mem.getUserName());

			memTmp.setPassword(passwordTextField.getText());
			
			memTmp1.setName(nameDispTextField.getText());
			memTmp1.setStuNum(Integer.parseInt(stuNumDispTextField.getText()));
			memTmp1.setStuClass(classDispTextField.getText());
			memTmp1.setDep(depDispTextField.getText());
			memTmp1.setPosition(posDispTextField.getText());
			memTmp1.setStatus(statusDispTextField.getText());
			memTmp1.setPhone(phoneDispTextField.getText());
			memTmp1.setEmail(emailDispTextField.getText());
			memTmp1.setPolitic(polDispTextField.getText());
			memTmp1.setIntro(introDispTextArea.getText());
			
			MemberDao memDao = new MemberDao();
			if(memDao.updateInfo(memTmp) && memDao.updatePerInfo(memTmp1)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
			}
			memDao.closeDao();
		}
	}
}


