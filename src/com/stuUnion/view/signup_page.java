package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.stuUnion.dao.MemberDao;
import com.stuUnion.model.Member;
import com.stuUnion.model.userType;
import com.stuUnion.util.StringUtil;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signup_page extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	JComboBox userTypeComboBox;
	private JPasswordField passwordTextField1;
	private JPasswordField passwordTextField2;


	/**
	 * Create the frame.
	 */
	public signup_page() {
		setResizable(false);
		setTitle("\u6CE8\u518C");
		this.setSize(450, 360);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		userNameLabel.setFont(new Font("华文宋体", Font.BOLD, 16));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		userNameTextField.setSize(130,30);
		
		passwordTextField1 = new JPasswordField();
		passwordTextField1.setFont(new Font("华文宋体", Font.BOLD, 16));
		passwordTextField1.setSize(130,30);
		
		passwordTextField2 = new JPasswordField();
		passwordTextField2.setFont(new Font("华文宋体", Font.BOLD, 16));
		passwordTextField2.setSize(130,30);
		
		JLabel passwordLabel1 = new JLabel("\u5BC6\u7801\uFF1A");
		passwordLabel1.setFont(new Font("华文宋体", Font.BOLD, 16));
		passwordLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel passwordLabel2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		passwordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel2.setFont(new Font("华文宋体", Font.BOLD, 16));
		userNameTextField.setFont(new Font("华文宋体", Font.BOLD, 16));
		
		JLabel userTypeLabel = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		userTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userTypeLabel.setFont(new Font("华文宋体", Font.BOLD, 16));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(
				new DefaultComboBoxModel(new userType[] { userType.MEMBER, userType.OLDMEMBER }));
		userTypeComboBox.setFont(new Font("华文宋体", Font.BOLD, 16));
		
		JButton signupButton = new JButton("\u6CE8\u518C");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp(e);
			}
		});
		signupButton.setFont(new Font("华文宋体", Font.BOLD, 16));
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(signupButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordLabel2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTextField2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userTypeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordLabel1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTextField1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
					.addGap(103))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(62, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameLabel)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLabel1)
						.addComponent(passwordTextField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLabel2)
						.addComponent(passwordTextField2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userTypeLabel)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(signupButton)
					.addGap(44))
		);
		contentPane.setLayout(gl_contentPane);

		
	}

	protected void signUp(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password1 = passwordTextField1.getText().toString();
		String password2 = passwordTextField2.getText().toString();
		userType selectedItem = (userType)userTypeComboBox.getSelectedItem();
		
		if (StringUtil.isNull(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if (StringUtil.isNull(password1)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		if(StringUtil.isNull(password2)) {
			JOptionPane.showMessageDialog(this, "请再次输入密码！");
			return;
		}
		
		if(!StringUtil.isEqual(password1, password2)) {
			JOptionPane.showMessageDialog(this, "两次密码不一致！");
			return;
		}
		
		
		if("干事".equals(selectedItem.getType())) {
			Member memTemp = new Member();
			memTemp.setUserName(Integer.parseInt(userName));
			memTemp.setPassword(password1);
			MemberDao md = new MemberDao();
			if(md.signUpUser(memTemp)) {
				md.createInfo(memTemp);
				JOptionPane.showMessageDialog(this, "注册成功！");
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "用户名已存在!");
			}
			md.closeDao();
			
		}
	}
}
