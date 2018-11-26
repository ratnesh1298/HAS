package user;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import main.LoginPanel;
import main.MainFrame;
import database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegisterPanel extends JPanel {
	private JTextField roll_number;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		setOpaque(false);
		setLayout(null);
		
		JLabel lblNewUserRegistration = new JLabel("New User Registration");
		lblNewUserRegistration.setForeground(new Color(240, 248, 255));
		lblNewUserRegistration.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewUserRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUserRegistration.setBounds(199, 51, 201, 27);
		add(lblNewUserRegistration);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(199, 76, 201, 2);
		add(separator);
		
		JLabel lblRollNo = new JLabel("Roll no.");
		lblRollNo.setForeground(new Color(211, 211, 211));
		lblRollNo.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblRollNo.setBounds(199, 147, 89, 14);
		add(lblRollNo);
		
		roll_number = new JTextField();
		roll_number.setBounds(308, 144, 156, 20);
		add(roll_number);
		roll_number.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblName.setBounds(199, 180, 89, 14);
		add(lblName);
		
		name = new JTextField();
		name.setBounds(308, 177, 156, 20);
		add(name);
		name.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblPassword.setBounds(199, 219, 89, 14);
		add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(308, 216, 156, 20);
		add(password);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setContentAreaFilled(false);
		btnRegister.setForeground(new Color(240, 248, 255));
		btnRegister.setFont(new Font("Serif", Font.BOLD, 18));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String,String> data = new HashMap<String,String>();
				data.put("name",name.getText());
				data.put("password",password.getText());
				data.put("roll_number", roll_number.getText());
				if(Database.db.insertQuery("user",data)){
					data.clear();
					data.put("roll_number_fk", roll_number.getText());
					if(Database.db.insertQuery("user_data", data)){
						JOptionPane.showMessageDialog(null, "Successfully Registered");
						MainFrame.ViewPanel(new LoginPanel());
					}
				}else{
					System.out.println("Not registered");
				}
			}
		});
		btnRegister.setBounds(254, 282, 115, 37);
		add(btnRegister);
		
		JButton btnBack = new JButton("<-");
		btnBack.setForeground(new Color(230, 230, 250));
		btnBack.setContentAreaFilled(false);
		btnBack.setDefaultCapable(false);
		btnBack.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new LoginPanel());
			}
		});
		btnBack.setBounds(10, 11, 75, 37);
		add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("..\\Pics\\pic5.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);

	}
}
