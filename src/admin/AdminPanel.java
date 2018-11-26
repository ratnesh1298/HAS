package admin;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;

import main.MainFrame;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

import database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AdminPanel extends JPanel {
	private ScrollPane scrollPane;
	private Panel panel;
	private JComboBox selectYear;
	private JComboBox sortBy;
	private JLabel lblNoRecordsFound; 
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new AdminLoginPanel());
				JOptionPane.showMessageDialog(null, "Logout successfully!");
			}
		});
		
		selectYear = new JComboBox();
		selectYear.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "Final"}));
		selectYear.setBounds(425, 131, 133, 20);
		add(selectYear);
		
		sortBy = new JComboBox();
		sortBy.setModel(new DefaultComboBoxModel(new String[] {"Roll_number", "Branch", "Category", "Percentage"}));
		sortBy.setBounds(425, 106, 133, 20);
		add(sortBy);
		
		panel = new Panel();
		
		
		scrollPane = new ScrollPane();
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(240, 255, 240));
		separator_1.setBounds(231, 101, 1, 50);
		add(separator_1);
		btnLogout.setBounds(10, 11, 89, 23);
		add(btnLogout);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setForeground(Color.WHITE);
		lblAdminPanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setBounds(234, 44, 131, 20);
		add(lblAdminPanel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(226, 75, 148, 2);
		add(separator);
		
		JLabel lblRegisteredUsers = new JLabel("Registered Users :");
		lblRegisteredUsers.setForeground(new Color(240, 255, 240));
		lblRegisteredUsers.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblRegisteredUsers.setBounds(75, 118, 144, 14);
		add(lblRegisteredUsers);
		
		JLabel lblSortBy = new JLabel("Sort By :");
		lblSortBy.setForeground(new Color(240, 255, 240));
		lblSortBy.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblSortBy.setBounds(263, 106, 103, 14);
		add(lblSortBy);
		
		JLabel lblShowResultsOf = new JLabel("Show result's of :");
		lblShowResultsOf.setForeground(new Color(240, 255, 240));
		lblShowResultsOf.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblShowResultsOf.setBounds(263, 131, 152, 14);
		add(lblShowResultsOf);
		
		JButton btnGenerateListOf = new JButton("Generate List of Registered students");
		btnGenerateListOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// fetch user details
				String condition = sortBy.getModel().getSelectedItem().toString();
				int year = selectYear.getSelectedIndex() + 1;
				String query = "SELECT name,roll_number,percentage,category,contact_number,branch,contact_person_name,contact_person_number,dob,is_hostler_last_year FROM user,user_data WHERE roll_number=roll_number_fk AND contact_number is not null AND year="+year+" ORDER BY "+condition.toLowerCase();
				ResultSet dataResultSet = Database.db.selectQuery(query);
				
				try {
					ResultSetMetaData rsmd = (ResultSetMetaData) dataResultSet.getMetaData();
					int col= rsmd.getColumnCount();
					int row=0;
					ArrayList<String> rollNumbers = new ArrayList<String>();
					ArrayList<String> names = new ArrayList<String>();
					
					ArrayList<String> colHeaders = new ArrayList<String>();
					while(dataResultSet.next()){
						rollNumbers.add(dataResultSet.getString("roll_number"));
						names.add(dataResultSet.getString("name"));
						System.out.println(dataResultSet.getString("roll_number")+"   "+dataResultSet.getString("name"));
						row++;
					}
					for(int i=1;i<=col;i++){
						colHeaders.add(rsmd.getColumnName(i).toString());
					}
					if(row>0){
						try{
							AdminPanel.this.remove(lblNoRecordsFound);
						}catch(NullPointerException e){
							
						}
						
						String x[] = new String[col];
						colHeaders.toArray(x);
						dataResultSet.first();
						scrollPane.add(new AdminListPanel(dataResultSet, row, col,x));
						scrollPane.setBounds(50, 246, 495, 289);
						AdminPanel.this.add(scrollPane);
						AdminPanel.this.add(label);
						AdminPanel.this.repaint();
						AdminPanel.this.revalidate();
					}else{
						try{
							AdminPanel.this.remove(scrollPane);
						}catch(NullPointerException e){
							
						}
						lblNoRecordsFound = new JLabel("No records found");
						lblNoRecordsFound.setForeground(new Color(240, 230, 140));
						lblNoRecordsFound.setHorizontalAlignment(SwingConstants.CENTER);
						lblNoRecordsFound.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
						lblNoRecordsFound.setBounds(224, 274, 168, 34);
						AdminPanel.this.add(lblNoRecordsFound);
						AdminPanel.this.add(label);
						AdminPanel.this.repaint();
						AdminPanel.this.revalidate();
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (NullPointerException e){
					e.printStackTrace();
				}
			}
		});
		btnGenerateListOf.setBounds(134, 180, 331, 23);
		add(btnGenerateListOf);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("..\\Pics\\pic4.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);
	}
}
