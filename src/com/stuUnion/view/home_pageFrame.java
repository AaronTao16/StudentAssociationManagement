package com.stuUnion.view;

import java.awt.BorderLayout;
import java.awt.Color;
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

import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class home_pageFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	public static userType userType1;
	public static Object userObject;

	private JLabel nameDispLabel;
	private JLabel stuNumDispLabel;
	private JLabel classDispLabel;
	private JLabel depDispLabel;
	private JLabel posDispLabel;
	private JLabel statusDispLabel;
	private JLabel phoneDispLabel;
	private JLabel polDispLabel;
	private JLabel emailDispLabel;
	private JTextArea introDispTextArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					home_pageFrame frame = new home_pageFrame();
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
	public home_pageFrame(userType userType1,Object userObject) {
		this.userType1 = userType1;
		this.userObject = userObject;
		setResizable(false);
		setTitle("\u4FE1\u5408\u5B66\u751F\u4F1A\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(870, 570);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dispalyInfoPanel = new JPanel();
		dispalyInfoPanel.setBackground(SystemColor.window);
		dispalyInfoPanel.setBounds(0, 0, 240, 523);
		contentPane.add(dispalyInfoPanel);
		dispalyInfoPanel.setLayout(null);
		
		JLabel imageLabel = new JLabel("\u7167\u7247");
		imageLabel.setIcon(new ImageIcon(home_pageFrame.class.getResource("/images/homeIcon.jpg")));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(35, 10, 180, 167);
		dispalyInfoPanel.add(imageLabel);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		nameLabel.setBounds(35, 180, 55, 20);
		dispalyInfoPanel.add(nameLabel);
		
		nameDispLabel = new JLabel("\u672A\u586B");
		nameDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		nameDispLabel.setBounds(95, 180, 90, 20);
		dispalyInfoPanel.add(nameDispLabel);
		
		JLabel classLabel = new JLabel("\u73ED\u7EA7\uFF1A");
		classLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		classLabel.setBounds(35, 240, 55, 20);
		dispalyInfoPanel.add(classLabel);
		
		JLabel stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		stuNumLabel.setBounds(35, 210, 55, 20);
		dispalyInfoPanel.add(stuNumLabel);
		
		stuNumDispLabel = new JLabel("\u672A\u586B");
		stuNumDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		stuNumDispLabel.setBounds(95, 210, 90, 20);
		dispalyInfoPanel.add(stuNumDispLabel);
		
		classDispLabel = new JLabel("\u672A\u586B");
		classDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		classDispLabel.setBounds(95, 240, 90, 20);
		dispalyInfoPanel.add(classDispLabel);
		
		JLabel statusLabel = new JLabel("\u72B6\u6001\uFF1A");
		statusLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		statusLabel.setBounds(35, 270, 55, 20);
		dispalyInfoPanel.add(statusLabel);
		
		JLabel depLabel = new JLabel("\u90E8\u95E8\uFF1A");
		depLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		depLabel.setBounds(35, 300, 55, 20);
		dispalyInfoPanel.add(depLabel);
		
		JLabel posLabel = new JLabel("\u804C\u4F4D\uFF1A");
		posLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		posLabel.setBounds(35, 330, 55, 20);
		dispalyInfoPanel.add(posLabel);
		
		statusDispLabel = new JLabel("\u672A\u586B");
		statusDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		statusDispLabel.setBounds(95, 270, 90, 20);
		dispalyInfoPanel.add(statusDispLabel);
		
		depDispLabel = new JLabel("\u672A\u586B");
		depDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		depDispLabel.setBounds(95, 300, 90, 20);
		dispalyInfoPanel.add(depDispLabel);
		
		posDispLabel = new JLabel("\u672A\u586B");
		posDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		posDispLabel.setBounds(95, 330, 90, 20);
		dispalyInfoPanel.add(posDispLabel);
		
		JLabel polLabel = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		polLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		polLabel.setBounds(35, 360, 85, 20);
		dispalyInfoPanel.add(polLabel);
		
		polDispLabel = new JLabel("\u672A\u586B");
		polDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		polDispLabel.setBounds(120, 360, 65, 20);
		dispalyInfoPanel.add(polDispLabel);
		
		JLabel phoneLabel = new JLabel("\u7535\u8BDD\uFF1A");
		phoneLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		phoneLabel.setBounds(35, 390, 85, 20);
		dispalyInfoPanel.add(phoneLabel);
		
		phoneDispLabel = new JLabel("\u672A\u586B");
		phoneDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		phoneDispLabel.setBounds(95, 393, 100, 20);
		dispalyInfoPanel.add(phoneDispLabel);
		
		JLabel emailLabel = new JLabel("\u90AE\u7BB1\uFF1A");
		emailLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		emailLabel.setBounds(35, 420, 85, 20);
		dispalyInfoPanel.add(emailLabel);
		
		emailDispLabel = new JLabel("\u672A\u586B");
		emailDispLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		emailDispLabel.setBounds(95, 420, 100, 20);
		dispalyInfoPanel.add(emailDispLabel);
		
		introDispTextArea = new JTextArea();
		introDispTextArea.setWrapStyleWord(true);
		introDispTextArea.setText("\u6682\u65E0\u4E2A\u4EBA\u7B80\u4ECB");
		introDispTextArea.setLineWrap(true);
		introDispTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		introDispTextArea.setBounds(35, 450, 178, 58);
		introDispTextArea.setBorder(BorderFactory.createEmptyBorder());
		dispalyInfoPanel.add(introDispTextArea);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(SystemColor.window);
		menuPanel.setBounds(240, 0, 619, 523);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JButton memInfoButton = new JButton("\u6210\u5458\u4FE1\u606F");
		memInfoButton.setBackground(Color.LIGHT_GRAY);
		memInfoButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		memInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				memInfo(ae);
			}
		});
		memInfoButton.setBounds(120, 130, 140, 60);
		menuPanel.add(memInfoButton);
		
		JButton missionButton = new JButton("\u4EFB\u52A1\u8BE6\u60C5");
		missionButton.setBackground(Color.LIGHT_GRAY);
		missionButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		missionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mission_page(userType1, userObject).setVisible(true);
			}
		});
		missionButton.setBounds(330, 130, 140, 60);
		menuPanel.add(missionButton);
		
		JButton perInfoButton = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		perInfoButton.setBackground(Color.LIGHT_GRAY);
		perInfoButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		perInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new infoEdit_page(userType1, userObject).setVisible(true);
			}
		});
		perInfoButton.setBounds(120, 235, 140, 60);
		menuPanel.add(perInfoButton);
		
		JButton eClassButton = new JButton("\u73ED\u7EA7\u8003\u6838");
		eClassButton.setBackground(Color.LIGHT_GRAY);
		eClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eClass(e);
			}
		});
		eClassButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		eClassButton.setBounds(330, 235, 140, 60);
		menuPanel.add(eClassButton);
		
		JButton logOutButton = new JButton("\u6CE8\u9500");
		logOutButton.setBackground(Color.LIGHT_GRAY);
		logOutButton.setFont(new Font("»ªÎÄÖÐËÎ", Font.BOLD, 16));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aelo) {
				logOut(aelo);
			}
		});
		logOutButton.setBounds(510, 0, 100, 27);
		menuPanel.add(logOutButton);
		
		JButton aboutButton = new JButton("\u5173\u4E8E");
		aboutButton.setBackground(Color.LIGHT_GRAY);
		aboutButton.setFont(new Font("»ªÎÄÖÐËÎ", Font.BOLD, 16));
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aea) {
				showAbout(aea);
			}
		});
		aboutButton.setBounds(405, 0, 100, 27);
		menuPanel.add(aboutButton);
		
		JButton eDepButton = new JButton("\u90E8\u95E8\u8003\u6838");
		eDepButton.setBackground(Color.LIGHT_GRAY);
		eDepButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		eDepButton.setBounds(330, 340, 140, 60);
		menuPanel.add(eDepButton);
		
		JButton ePersonButton = new JButton("\u4E2A\u4EBA\u8003\u6838");
		ePersonButton.setBackground(Color.LIGHT_GRAY);
		ePersonButton.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.PLAIN, 16));
		ePersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ePersonButton.setBounds(120, 340, 140, 60);
		menuPanel.add(ePersonButton);
	
//		desktopPane = new JDesktopPane();
//		desktopPane.setBackground(new Color(0, 128, 128));
//		contentPane.add(desktopPane, BorderLayout.CENTER);
//		setLocationRelativeTo(null);
//		setAuthority();
		
		showInfo(userType1,userObject);
		
	}

	protected void memInfo(ActionEvent ae) {
	// TODO Auto-generated method stub
		memberInfo_page mi = new memberInfo_page(userType1,userObject);
		mi.setVisible(true);
}

	protected void eClass(ActionEvent e) {
	// TODO Auto-generated method stub
		eClass_page ec = new eClass_page(userType1,userObject);
		ec.setVisible(true);
		//desktopPane.add(ec);
}

	private void showInfo(userType userType1, Object userObject) {
		// TODO Auto-generated method stub
		// ÏÔÊ¾¸öÈËÐÅÏ¢
		this.userType1 = userType1;
		this.userObject = userObject;
		
		if ("Ö¸µ¼ÀÏÊ¦/Ö÷Ï¯ÍÅ".equals(userType1.getType())) {
			String name = "Î´Ìî";
			int stuNum = 00000000;
			String stuClass = "Î´Ìî";
			String dep = "Î´Ìî";
			String position = "Î´Ìî";
			String status = "Î´Ìî";
			String phone = "Î´Ìî";
			String email = "Î´Ìî";
			String politic = "Î´Ìî";
			String intro = "Î´Ìî";

			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin) userObject;
			adminTmp = adminDao.displayInfo(admin);
			adminDao.closeDao();

			name = adminTmp.getName();
			nameDispLabel.setText(name);

			stuNum = adminTmp.getStuNum();
			stuNumDispLabel.setText(stuNum + "");

			stuClass = adminTmp.getStuClass();
			classDispLabel.setText(stuClass);

			dep = adminTmp.getDep();
			depDispLabel.setText(dep);

			position = adminTmp.getPosition();
			posDispLabel.setText(position);

			status = adminTmp.getStatus();
			statusDispLabel.setText(status);

			phone = adminTmp.getPhone();
			phoneDispLabel.setText(phone);
			
			email = adminTmp.getEmail();
			emailDispLabel.setText(email);

			politic = adminTmp.getPolitic();
			polDispLabel.setText(politic);

			intro = adminTmp.getIntro();
			introDispTextArea.setText(intro);
		}
		
		if ("²¿³¤".equals(userType1.getType())) {
			String name = "Î´Ìî";
			int stuNum = 00000000;
			String stuClass = "Î´Ìî";
			String dep = "Î´Ìî";
			String position = "Î´Ìî";
			String status = "Î´Ìî";
			String phone = "Î´Ìî";
			String email = "Î´Ìî";
			String politic = "Î´Ìî";
			String intro = "Î´Ìî";

			MinisterDao ministerDao = new MinisterDao();
			Minister minTmp = new Minister();
			Minister min = (Minister) userObject;
			minTmp = ministerDao.displayInfo(min);
			ministerDao.closeDao();

			name = minTmp.getName();
			nameDispLabel.setText(name);

			stuNum = minTmp.getStuNum();
			stuNumDispLabel.setText(stuNum + "");

			stuClass = minTmp.getStuClass();
			classDispLabel.setText(stuClass);

			dep = minTmp.getDep();
			depDispLabel.setText(dep);

			position = minTmp.getPosition();
			posDispLabel.setText(position);

			status = minTmp.getStatus();
			statusDispLabel.setText(status);

			phone = minTmp.getPhone();
			phoneDispLabel.setText(phone);
			
			email = minTmp.getEmail();
			emailDispLabel.setText(email);

			politic = minTmp.getPolitic();
			polDispLabel.setText(politic);

			intro = minTmp.getIntro();
			introDispTextArea.setText(intro);
		}
		
		if ("¸ÉÊÂ".equals(userType1.getType())) {
			String name = "Î´Ìî";
			int stuNum = 00000000;
			String stuClass = "Î´Ìî";
			String dep = "Î´Ìî";
			String position = "Î´Ìî";
			String status = "Î´Ìî";
			String phone = "Î´Ìî";
			String email = "Î´Ìî";
			String politic = "Î´Ìî";
			String intro = "Î´Ìî";

			MemberDao memberDao = new MemberDao();
			Member memTmp = new Member();
			Member mem = (Member) userObject;
			memTmp = memberDao.displayInfo(mem);
			memberDao.closeDao();

			name = memTmp.getName();
			nameDispLabel.setText(name);

			stuNum = memTmp.getStuNum();
			stuNumDispLabel.setText(stuNum + "");

			stuClass = memTmp.getStuClass();
			classDispLabel.setText(stuClass);

			dep = memTmp.getDep();
			depDispLabel.setText(dep);

			position = memTmp.getPosition();
			posDispLabel.setText(position);

			status = memTmp.getStatus();
			statusDispLabel.setText(status);

			phone = memTmp.getPhone();
			phoneDispLabel.setText(phone);
			
			email = memTmp.getEmail();
			emailDispLabel.setText(email);

			politic = memTmp.getPolitic();
			polDispLabel.setText(politic);

			intro = memTmp.getIntro();
			introDispTextArea.setText(intro);
		}
		
//		if ("Íù½ì³ÉÔ±".equals(userType1.getType())) {
//			String name = "Î´Ìî";
//			int stuNum = 00000000;
//			String stuClass = "Î´Ìî";
//			String dep = "Î´Ìî";
//			String position = "Î´Ìî";
//			String status = "Î´Ìî";
//			String phone = "Î´Ìî";
//			String politic = "Î´Ìî";
//			String intro = "Î´Ìî";
//
//			AdminDao adminDao = new AdminDao();
//			Admin adminTmp = new Admin();
//			Admin admin = (Admin) userObject;
//			adminTmp = adminDao.displayInfo(admin);
//			adminDao.closeDao();
//
//			name = adminTmp.getName();
//			nameDispLabel.setText(name);
//
//			stuNum = adminTmp.getStuNum();
//			stuNumDispLabel.setText(stuNum + "");
//
//			stuClass = adminTmp.getStuClass();
//			classDispLabel.setText(stuClass);
//
//			dep = adminTmp.getDep();
//			depDispLabel.setText(dep);
//
//			position = adminTmp.getPosition();
//			posDispLabel.setText(position);
//
//			status = adminTmp.getStatus();
//			statusDispLabel.setText(status);
//
//			phone = adminTmp.getPhone();
//			phoneDispLabel.setText(phone);
//
//			politic = adminTmp.getPolitic();
//			polDispLabel.setText(politic);
//
//			intro = adminTmp.getIntro();
//			introDispLabel.setText(intro);
//		}
	}
	protected void logOut(ActionEvent aelo) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "È·¶¨×¢ÏúÂð£¿") == JOptionPane.OK_OPTION){
			this.dispose();
			logIn_page l = new logIn_page();
			l.setVisible(true);
		}
	}

	protected void showAbout(ActionEvent aea) {
		// TODO Auto-generated method stub
		String aboutInfo = "ÈçÓÐÈÎºÎÎÊÌâ£¬ÏêÇéÇë×ÉÑ¯¹ÜÀíÔ±\nÒ¶Ë¼Áú£º18607103686\nÁ¬Ïþæ¥£º18727593065 \nÃ÷ÃÄ£º18872088297 \n½­º½£º18062648272 \nÌÕÜ²£º15007172681 ";
		JOptionPane.showMessageDialog(this, aboutInfo);
	}
}
