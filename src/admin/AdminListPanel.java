package admin;

import javax.swing.JPanel;

import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class AdminListPanel extends Panel {

	/**
	 * Create the panel.
	 */
	public AdminListPanel(ResultSet rs,int rows,int cols,String colHeaders[]) {
		setBackground(Color.WHITE);
		
		setLayout(null);
		int rowGap=10;
		int colGap=10;
		int colSize=150;
		int rowSize=50;
		System.out.println(rows+" "+cols);
		for(int i=0;i<colHeaders.length;i++){
			System.out.println(colHeaders[i]);
		}
		setBounds(0,0,cols*(colSize+colGap)+100,rows*(rowSize+rowGap));
		
		JLabel lblSrNo = new JLabel("Sr No.");
		lblSrNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSrNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSrNo.setBounds(colGap, rowGap, colSize,rowSize);
		add(lblSrNo);
		for(int i=1;i<=cols;i++){
			JLabel lbl = new JLabel(colHeaders[i-1]);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lbl.setBounds(colGap+i*colSize, rowGap, colSize,rowSize);
			add(lbl);
		}
		try {
			int i=1;
			rs.previous();
			while(rs.next()){
				JLabel lbl = new JLabel(""+i+" .");
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setBounds(colGap, rowGap+i*rowSize, colSize,rowSize);
				add(lbl);
				for(int j=1;j<=cols;j++){
					JLabel lbl1 = new JLabel(rs.getString(j));
					lbl1.setHorizontalAlignment(SwingConstants.CENTER);
					lbl1.setBounds(colGap+j*colSize, rowGap+i*rowSize, colSize,rowSize);
					add(lbl1);
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
