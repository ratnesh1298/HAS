package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MainFrame {
	public static JFrame frame;
	
	private static final long serialVersionUID = 1L;
	

	public static void ViewPanel(JPanel panel){
		frame.repaint();
		frame.revalidate();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 30, 30);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setTitle("Hostel Allotment System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewPanel(new IntroductionPanel());
	}

}
