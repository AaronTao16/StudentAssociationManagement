package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.stuUnion.dao.AdminDao;
import com.stuUnion.dao.MemberDao;
import com.stuUnion.dao.MinisterDao;
import com.stuUnion.model.Admin;
import com.stuUnion.model.Member;
import com.stuUnion.model.Minister;
import com.stuUnion.model.userType;
import com.stuUnion.util.StringUtil;

public class logIn_page extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn_page frame = new logIn_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Create the frame.
	 */
	public logIn_page() {
		setResizable(false);
		setTitle("\u4FE1\u5408\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(520, 375);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setBackground(Color.WHITE);

		JLabel logoImgLabel = new JLabel("");
		logoImgLabel.setBounds(97, 15, 325, 80);
		logoImgLabel.setIcon(new ImageIcon(logIn_page.class.getResource("/images/loginImg.png")));

		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setBounds(150, 115, 90, 25);
		userNameLabel.setFont(new Font("华文宋体", Font.BOLD, 16));
		userNameLabel.setIcon(new ImageIcon(logIn_page.class.getResource("/images/userName.png")));

		userNameField = new JTextField();
		userNameField.setHorizontalAlignment(SwingConstants.LEFT);
		userNameField.setBounds(240, 115, 130, 30);
		userNameField.setFont(new Font("华文宋体", Font.BOLD, 16));
		userNameField.setColumns(10);

		JLabel passwordLabel = new JLabel("\u5BC6   \u7801\uFF1A");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(150, 160, 90, 25);
		passwordLabel.setIcon(new ImageIcon(logIn_page.class.getResource("/images/password.png")));
		passwordLabel.setFont(new Font("华文宋体", Font.BOLD, 16));

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(240, 160, 130, 30);
		passwordField.setFont(new Font("华文宋体", Font.BOLD, 16));
		passwordField.setColumns(10);

		JLabel userTypeLabel = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		userTypeLabel.setBounds(135, 208, 105, 25);
		userTypeLabel.setIcon(new ImageIcon(logIn_page.class.getResource("/images/userType.png")));
		userTypeLabel.setFont(new Font("华文宋体", Font.BOLD, 16));

		userTypeComboBox = new JComboBox();
		userTypeComboBox.setBounds(240, 205, 155, 30);
		userTypeComboBox.setModel(
				new DefaultComboBoxModel(new userType[] { userType.ADMIN, userType.MINISTER, userType.MEMBER, userType.OLDMEMBER }));
		userTypeComboBox.setFont(new Font("华文宋体", Font.BOLD, 16));

		JButton signUpButton = new JButton("\u6CE8\u518C");
		signUpButton.setBounds(120, 260, 90, 35);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				singupAct(ae1);
			}
		});
		signUpButton.setFont(new Font("华文宋体", Font.BOLD, 16));

		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setBounds(310, 260, 90, 35);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("华文宋体", Font.BOLD, 16));
		contentPane.setLayout(null);
		contentPane.add(passwordLabel);
		contentPane.add(userNameLabel);
		contentPane.add(passwordField);
		contentPane.add(userNameField);
		contentPane.add(userTypeLabel);
		contentPane.add(signUpButton);
		contentPane.add(userTypeComboBox);
		contentPane.add(loginButton);
		contentPane.add(logoImgLabel);
	}

	protected void singupAct(ActionEvent ae1) {
		// TODO Auto-generated method stub
		signup_page frame = new signup_page();
		frame.setVisible(true);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameField.getText().toString();
		String password = passwordField.getText().toString();
		userType selectedItem = (userType) userTypeComboBox.getSelectedItem();

		if (StringUtil.isNull(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if (StringUtil.isNull(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}

		Admin admin = null;
		if ("指导老师/主席团".equals(selectedItem.getType())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setUserName(Integer.parseInt(userName));
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();

			if (admin == null) {
				JOptionPane.showMessageDialog(this, "用户名密码或用户类型错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getType() + "】：" + admin.getUserName() + "登录本系统！");
			this.dispose();
			new home_pageFrame(selectedItem, admin).setVisible(true);
			
		}
		
		if ("部长".equals(selectedItem.getType())) {
			Minister minTemp = new Minister();
			minTemp.setUserName(Integer.parseInt(userName));
			minTemp.setPassword(password);
			MinisterDao mid = new MinisterDao();
			minTemp = mid.login(minTemp);
			mid.closeDao();
			if (minTemp == null) {
				JOptionPane.showMessageDialog(this, "用户名密码或用户类型错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getType() + "】：" + minTemp.getUserName() + "登录本系统！");
			this.dispose();
			new home_pageFrame(selectedItem, minTemp).setVisible(true);
			
		}
		
		if ("干事".equals(selectedItem.getType())) {
			Member memTemp = new Member();
			memTemp.setUserName(Integer.parseInt(userName));
			memTemp.setPassword(password);
			MemberDao md = new MemberDao();
			memTemp = md.login(memTemp);
			md.closeDao();
			if (memTemp == null) {
				JOptionPane.showMessageDialog(this, "用户名密码或用户类型错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getType() + "】：" + memTemp.getUserName() + "登录本系统！");
			this.dispose();
			new home_pageFrame(selectedItem, memTemp).setVisible(true);
			
		}
		
	}
}
