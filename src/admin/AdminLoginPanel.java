package admin;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.LoginPanel;
import main.MainFrame;
import database.Database;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class AdminLoginPanel extends JPanel {

	private JTextField admin_id;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	public AdminLoginPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ID");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setBounds(193, 172, 63, 14);
		add(lblNewLabel);
		
		admin_id = new JTextField();
		admin_id.setToolTipText("Login ID");
		admin_id.setBounds(287, 169, 142, 20);
		add(admin_id);
		admin_id.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_1.setBounds(192, 214, 63, 14);
		add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setToolTipText("Password");
		password.setBounds(287, 211, 142, 20);
		add(password);
		password.setColumns(30);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(new Color(245, 222, 179));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Database.db.checkAdminIntoDatabse(admin_id.getText(), password.getText())){
					MainFrame.ViewPanel(new AdminPanel());
				}
			}
		});
		btnNewButton.setBounds(246, 266, 108, 23);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.activeCaption);
		separator.setForeground(new Color(250, 250, 210));
		separator.setBounds(268, 166, 1, 70);
		add(separator);
		
		JButton btnBack = new JButton("<-");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setContentAreaFilled(false);
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new LoginPanel());
			}
		});
		btnBack.setBounds(10, 11, 70, 36);
		add(btnBack);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setForeground(new Color(250, 250, 210));
		lblAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(246, 62, 106, 23);
		add(lblAdminLogin);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(238, 96, 122, 2);
		add(separator_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("..\\Pics\\pic2.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);

	}
}
