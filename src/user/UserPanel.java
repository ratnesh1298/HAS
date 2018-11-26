package user;

import javax.net.ssl.HostnameVerifier;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import database.Database;

import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.Box;

import main.LoginPanel;
import main.MainFrame;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class UserPanel extends JPanel {
	private JLabel name;
	private JTextField totalMarks;
	private JTextField obtainedMarks;
	private JLabel roll_number;
	private JTextField ePersonName;
	private JTextField ePersonNumber;
	private JTextField ePersonRelation;
	private ResultSet userData;
	public String rollNumber;
	private JTextField contact_number;
	private JComboBox branchSpinner;
	private JComboBox dateYearSpinner;
	private JComboBox daySpinner;
	private JComboBox categorySpinner;
	private JComboBox yearSpinner;
	private JComboBox monthSpinner;
	private JCheckBox chckbxAreYouHostler;
	private JLabel percentage;

	/**
	 * Create the panel.
	 */
	public UserPanel(String rollNumber) {
		this.rollNumber = rollNumber;
		setBackground(SystemColor.window);
		setLayout(null);
		try {
			userData = (ResultSet) Database.db.selectQuery("SELECT * FROM user,user_data WHERE roll_number='"+rollNumber+"' AND roll_number_fk=roll_number");
			userData.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		chckbxAreYouHostler = new JCheckBox("Are you hostler last year");
		chckbxAreYouHostler.setBounds(45, 470, 234, 23);
		add(chckbxAreYouHostler);
		
		categorySpinner = new JComboBox();
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("GEN");
		categories.add("OBC");
		categories.add("SBC");
		categories.add("SC");
		categories.add("ST");
		categorySpinner.setModel(new DefaultComboBoxModel(categories.toArray()));
		categorySpinner.setBounds(130, 192, 131, 18);
		try {
			categorySpinner.setSelectedIndex(categories.indexOf(userData.getString("category")));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		add(categorySpinner);
		
		yearSpinner = new JComboBox();
		yearSpinner.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "Final"}));
		yearSpinner.setBounds(395, 144, 86, 18);
		try {
			yearSpinner.setSelectedIndex(userData.getInt("year")-1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (NullPointerException e){
			
		}
		add(yearSpinner);
		
		branchSpinner = new JComboBox();
		ArrayList<String> branches = new ArrayList<String>();
		branches.add("Architecture");
		branches.add("BCT");
		branches.add("Chemical");
		branches.add("Civil");
		branches.add("Computer Science");
		branches.add("ECC");
		branches.add("ECE");
		branches.add("EEE");
		branches.add("Electrical");
		branches.add("IT");
		branches.add("Mechanical");
		branches.add("Mining");
		branches.add("P&I");
		branchSpinner.setModel(new DefaultComboBoxModel(branches.toArray()));
		branchSpinner.setBounds(130, 167, 131, 18);
		try {
			branchSpinner.setSelectedIndex(branches.indexOf(userData.getString("branch")));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		add(branchSpinner);
		
		monthSpinner = new JComboBox();
		monthSpinner.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		monthSpinner.setBounds(460, 171, 65, 18);
		try {
			monthSpinner.setSelectedIndex(userData.getDate("dob").getMonth()+1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		add(monthSpinner);
		
		daySpinner = new JComboBox();
		daySpinner.setModel(new DefaultComboBoxModel(new String[] {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		daySpinner.setBounds(395, 171, 55, 18);
		try {
			daySpinner.setSelectedIndex(userData.getDate("dob").getDate());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		add(daySpinner);
		
		dateYearSpinner = new JComboBox();
		dateYearSpinner.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"}));
		dateYearSpinner.setBounds(535, 171, 55, 18);
		try {
			dateYearSpinner.setSelectedIndex((userData.getDate("dob").getYear()-89));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		add(dateYearSpinner);
		
		JLabel lblRegistrationFrom = new JLabel("Registration From");
		lblRegistrationFrom.setForeground(new Color(47, 79, 79));
		lblRegistrationFrom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRegistrationFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationFrom.setBounds(213, 40, 174, 24);
		add(lblRegistrationFrom);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(200, 75, 200, 2);
		add(separator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(45, 144, 75, 14); 
		add(lblName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblBranch.setForeground(new Color(0, 0, 0));
		lblBranch.setBounds(45, 169, 75, 14);
		add(lblBranch);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblCategory.setForeground(new Color(0, 0, 0));
		lblCategory.setBounds(45, 194, 75, 14);
		add(lblCategory);
		
		JLabel lblPercentage = new JLabel("Total Marks");
		lblPercentage.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblPercentage.setForeground(new Color(0, 0, 0));
		lblPercentage.setBounds(45, 247, 101, 14);
		add(lblPercentage);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblRollNo.setForeground(new Color(0, 0, 0));
		lblRollNo.setBounds(45, 297, 101, 14);
		add(lblRollNo);
		
		JLabel lblNewLabel = new JLabel("Marks Obtained");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(45, 272, 101, 14);
		add(lblNewLabel);
		
		JLabel lblPercentage_1 = new JLabel("Percentage");
		lblPercentage_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblPercentage_1.setForeground(new Color(0, 0, 0));
		lblPercentage_1.setBounds(328, 272, 75, 14);
		add(lblPercentage_1);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblYear.setForeground(new Color(0, 0, 0));
		lblYear.setBounds(282, 144, 75, 14);
		add(lblYear);
		
		JLabel lblEmergencyContactDetails = new JLabel("Emergency Contact Details");
		lblEmergencyContactDetails.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblEmergencyContactDetails.setForeground(new Color(0, 0, 128));
		lblEmergencyContactDetails.setBounds(45, 332, 200, 14);
		add(lblEmergencyContactDetails);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(45, 352, 200, 2);
		add(separator_1);
		
		JLabel lblPersonsName = new JLabel("Person's name");
		lblPersonsName.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblPersonsName.setForeground(new Color(0, 0, 0));
		lblPersonsName.setBounds(45, 369, 101, 14);
		add(lblPersonsName);
		
		JLabel lblContactNo = new JLabel("Contact no.");
		lblContactNo.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblContactNo.setForeground(new Color(0, 0, 0));
		lblContactNo.setBounds(45, 394, 101, 14);
		add(lblContactNo);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblRelation.setForeground(new Color(0, 0, 0));
		lblRelation.setBounds(45, 419, 101, 14);
		add(lblRelation);
		
		JLabel lblOtherDetails = new JLabel("Other details");
		lblOtherDetails.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblOtherDetails.setForeground(new Color(0, 0, 128));
		lblOtherDetails.setBounds(45, 444, 115, 14);
		add(lblOtherDetails);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(45, 461, 100, 2);
		add(separator_2);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new LoginPanel());
				JOptionPane.showMessageDialog(null, "Logout Successfully!");
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		add(btnNewButton);
		
		name = new JLabel();
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setForeground(new Color(0, 100, 0));
		try {
			name.setText(userData.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		name.setBounds(130, 141, 131, 20);
		add(name);
		
		totalMarks = new JTextField();
		totalMarks.setBounds(186, 244, 112, 20);
		try {
			totalMarks.setText(""+userData.getInt("total_marks"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		add(totalMarks);
		totalMarks.setColumns(10);
		
		obtainedMarks = new JTextField();
		obtainedMarks.setBounds(186, 269, 112, 20);
		try {
			obtainedMarks.setText(""+userData.getInt("marks_obtained"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		add(obtainedMarks);
		obtainedMarks.setColumns(10);
		obtainedMarks.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				float per = Float.parseFloat(obtainedMarks.getText())/Float.parseFloat(totalMarks.getText());
				percentage.setText(per*100+" %");
			}
		});
		
		roll_number = new JLabel();
		roll_number.setFont(new Font("Tahoma", Font.BOLD, 12));
		roll_number.setForeground(new Color(0, 0, 205));
		try {
			roll_number.setText(userData.getString("roll_number"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roll_number.setBounds(186, 294, 112, 20);
		add(roll_number);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblDateOfBirth.setForeground(new Color(0, 0, 0));
		lblDateOfBirth.setBounds(282, 169, 103, 14);
		add(lblDateOfBirth);
		
		percentage = new JLabel("0.00%");
		percentage.setFont(new Font("Tahoma", Font.BOLD, 12));
		percentage.setForeground(new Color(47, 79, 79));
		percentage.setBounds(413, 272, 80, 14);
		try{
			float per = (float)userData.getInt("marks_obtained")/(float)userData.getInt("total_marks");
			per*=100;
			percentage.setText(""+per+" %");
		}catch (SQLException e){
			e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		add(percentage);
		
		ePersonName = new JTextField();
		ePersonName.setBounds(156, 366, 138, 20);
		add(ePersonName);
		try {
			ePersonName.setText(userData.getString("contact_person_name"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		ePersonName.setColumns(10);
		
		ePersonNumber = new JTextField();
		ePersonNumber.setBounds(156, 391, 138, 20);
		add(ePersonNumber);
		try {
			ePersonNumber.setText(userData.getString("contact_person_number"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		ePersonNumber.setColumns(10);
		
		ePersonRelation = new JTextField();
		ePersonRelation.setBounds(156, 416, 138, 20);
		add(ePersonRelation);
		try {
			ePersonRelation.setText(userData.getString("contact_person_relation"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		ePersonRelation.setColumns(10);
		
		JButton btnSaveDetails = new JButton("Save Details");
		btnSaveDetails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// validate information
				if(validateInformation()){
					// save details
					String query = "UPDATE user_data SET "
							+ "branch = ?,"
							+ "year = ?,"
							+ "dob = ?,"
							+ "contact_number = ?,"
							+ "category = ?,"
							+ "total_marks = ?,"
							+ "marks_obtained=?,"
							+ "contact_person_name=?,"
							+ "contact_person_number=?,"
							+ "contact_person_relation=?,"
							+ "percentage = ?,"
							+ "is_hostler_last_year=?"
							+ " WHERE roll_number_fk=?";
					try {
						float percentage = Float.parseFloat(obtainedMarks.getText())/Float.parseFloat(totalMarks.getText());
						percentage*=100;
						String date = ""+dateYearSpinner.getModel().getSelectedItem().toString()+"-"+monthSpinner.getSelectedIndex()+"-"+daySpinner.getModel().getSelectedItem().toString();
						PreparedStatement ps = (PreparedStatement) Database.db.con.prepareStatement(query);
						ps.setString(1,branchSpinner.getModel().getSelectedItem().toString());
						ps.setInt(2, yearSpinner.getSelectedIndex()+1);
						ps.setString(3,date);
						ps.setString(4,contact_number.getText());
						ps.setString(5, categorySpinner.getModel().getSelectedItem().toString());
						ps.setInt(6, Integer.parseInt(totalMarks.getText()));
						ps.setInt(7,Integer.parseInt(obtainedMarks.getText()));
						ps.setString(8,ePersonName.getText());
						ps.setString(9,ePersonNumber.getText());
						ps.setString(10, ePersonRelation.getText());
						ps.setFloat(11,percentage);
						ps.setBoolean(12, chckbxAreYouHostler.isSelected());
						ps.setString(13,UserPanel.this.rollNumber);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Saved Details successfully!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
		});
		btnSaveDetails.setBounds(235, 514, 122, 23);
		add(btnSaveDetails);
		
		JLabel lblPersonalDetails = new JLabel("Personal Details");
		lblPersonalDetails.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblPersonalDetails.setForeground(new Color(0, 0, 128));
		lblPersonalDetails.setBounds(45, 106, 115, 14);
		add(lblPersonalDetails);
		
		JLabel lblAcademicDetails = new JLabel("Academic details");
		lblAcademicDetails.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblAcademicDetails.setForeground(new Color(0, 0, 128));
		lblAcademicDetails.setBounds(45, 219, 138, 14);
		add(lblAcademicDetails);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(45, 126, 125, 2);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(45, 237, 115, 2);
		add(separator_4);
		
		JLabel lblContactNo_1 = new JLabel("Contact no.");
		lblContactNo_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		lblContactNo_1.setForeground(new Color(0, 0, 0));
		lblContactNo_1.setBounds(282, 194, 105, 14);
		add(lblContactNo_1);
		
		contact_number = new JTextField();
		contact_number.setBounds(395, 193, 86, 20);
		add(contact_number);
		try {
			contact_number.setText(userData.getString("contact_number"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		contact_number.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("..\\Pics\\pic6.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);

	}
	private boolean validateInformation(){
		if(contact_number.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Empty Contact no.");
			return false;
		}
		if(ePersonName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Emergency person's name is empty");
			return false;
		}
		if(ePersonNumber.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Emergency contact number is empty");
			return false;
		}
		if(ePersonRelation.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Emergency contact person's relation is empty");
			return false;
		}
		if(contact_number.getText().length()!=10){
			JOptionPane.showMessageDialog(null, "Invalid contact number");
			return false;
		}
		if(ePersonNumber.getText().length()!=10){
			JOptionPane.showMessageDialog(null, "Invalid emergency contact number");
			return false;
		}
		if(daySpinner.getSelectedIndex()==0 || dateYearSpinner.getSelectedIndex()==0 || monthSpinner.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null, "Invalid DOB");
		}
		try{
			branchSpinner.getModel().getSelectedItem().toString();
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Invalid branch");
		}
		try{
			categorySpinner.getModel().getSelectedItem().toString();
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Invalid category");
		}
		try{
			yearSpinner.getModel().getSelectedItem().toString();
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Invalid Year");
		}
		return true;
	}
	
}
