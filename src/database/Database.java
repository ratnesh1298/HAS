package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import user.UserPanel;
import main.MainFrame;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Database {
	public static Database db = new Database();
	private final String dbName="has";
	public Connection con;
	private final String username="root";
	private final String password="";
	private Database(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded successfully.");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);
			System.out.println("Connection established successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found : "+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("Connection not established : "+e.getMessage());
			new Thread(new Runnable() {
				
				public void run() {
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						run();
					}
				}
			}).start();
		}
	}
	public boolean insertQuery(String table,HashMap data){
		try{
			boolean flag = true;
			String query = "INSERT INTO "+table+"(";
			Set<Map.Entry<String,String>> set = data.entrySet();
			for(Map.Entry<String,String> me : set){
				if(flag) flag = false;
				else query+=",";
				query+=me.getKey();
			}
			flag = true;
			query+=") VALUES(";
			for(Map.Entry<String,String> me : set){
				if(flag) flag = false;
				else query+=",";
				query+="'"+me.getValue()+"'";
			}
			query+=")";
			System.out.println(query);
			PreparedStatement ps = (PreparedStatement) db.con.prepareStatement(query);
			ps.execute();
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error-"+e.getMessage());
		}
		return false;
	}
	public ResultSet selectQuery(String query){
		try {
			PreparedStatement ps = (PreparedStatement) db.con.prepareStatement(query);
			return (ResultSet) ps.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error : "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public boolean checkUserIntoDatabse(String roll_number,String password){
		String query = "SELECT id from user where roll_number='"+roll_number+"' and password='"+password+"'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) db.con.prepareStatement(query);
			ResultSet rs = (ResultSet) ps.executeQuery();
			try{
				rs.next();
				if(rs.getRow()==1){
					return true;
				}else{
					JOptionPane.showMessageDialog(null, "Wrong username/password");
				}
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkAdminIntoDatabse(String roll_number,String password){
		String query = "SELECT id from admin where admin_id='"+roll_number+"' and password='"+password+"'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) db.con.prepareStatement(query);
			ResultSet rs = (ResultSet) ps.executeQuery();
			try{
				rs.next();
				if(rs.getRow()==1){
					return true;
				}else{
					JOptionPane.showMessageDialog(null, "Wrong username/password");
				}
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
