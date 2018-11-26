package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import user.RegisterPanel;
import user.UserPanel;
import admin.AdminLoginPanel;
import database.Database;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginPanel extends JPanel {
	private JTextField roll_number;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No.");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(158, 165, 101, 20);
		add(lblNewLabel);
		
		roll_number = new JTextField();
		roll_number.setToolTipText("Login ID");
		roll_number.setBounds(286, 165, 142, 20);
		add(roll_number);
		roll_number.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(158, 207, 101, 20);
		add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setToolTipText("Password");
		password.setBounds(286, 207, 142, 20);
		add(password);
		password.setColumns(30);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new LineBorder(new Color(250, 235, 215), 1, true));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// check user in databse
				if(Database.db.checkUserIntoDatabse(roll_number.getText(), password.getText())){
					UserPanel up = new UserPanel(roll_number.getText());
					MainFrame.ViewPanel(up);
				}
				// if credentials are valid goto user panel
			}
		});
		btnNewButton.setBounds(243, 264, 108, 29);
		add(btnNewButton);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setForeground(new Color(255, 255, 255));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(243, 298, 108, 14);
		add(lblOr);
		
		JLabel lblRegister = new JLabel("New Registration :");
		lblRegister.setForeground(new Color(255, 255, 255));
		lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(146, 322, 133, 20);
		add(lblRegister);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.activeCaption);
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(255, 165, 1, 70);
		add(separator);
		
		JButton btnBack = new JButton("<-");
		btnBack.setContentAreaFilled(false);
		btnBack.setDefaultCapable(false);
		btnBack.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new IntroductionPanel());
			}
		});
		btnBack.setBounds(10, 11, 45, 29);
		add(btnBack);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBorder(new LineBorder(new Color(250, 235, 215), 1, true));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new RegisterPanel());
			}
		});
		btnNewButton_1.setBounds(310, 321, 108, 29);
		add(btnNewButton_1);
		
		JButton lblOnlyForAdmin = new JButton("Administration Panel");
		lblOnlyForAdmin.setBorder(new LineBorder(new Color(250, 235, 215), 1, true));
		lblOnlyForAdmin.setContentAreaFilled(false);
		lblOnlyForAdmin.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOnlyForAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new AdminLoginPanel());
			}
		});
		lblOnlyForAdmin.setBounds(183, 386, 235, 29);
		add(lblOnlyForAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("Login/Sign UP");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 28));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(177, 82, 245, 29);
		add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(177, 122, 245, 2);
		add(separator_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("..\\Pics\\pic3.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);

	}
}
