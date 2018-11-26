package main;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Component;

public class IntroductionPanel extends JPanel {

	private final String title= "Hostel Allotment System";
	private final String introduction = "This is a java based desktop application which is"
			+ "used to allot hostels of our college on the basis of ranks got by the students";
	/**
	 * Create the panel.
	 */
	public IntroductionPanel() {
		setBackground(SystemColor.window);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("Next ->");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.ViewPanel(new LoginPanel());
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 122, 351, 2);
		add(separator);
		btnNewButton.setBounds(145, 373, 309, 32);
		add(btnNewButton);
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 73, 351, 38);
		add(lblNewLabel);
		
		JTextPane lblIntro = new JTextPane();
		lblIntro.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		lblIntro.setBackground(new Color(70, 130, 180));
		lblIntro.setForeground(new Color(255, 255, 255));
		lblIntro.setFont(new Font("SimSun", Font.BOLD, 18));
		lblIntro.setToolTipText("Introduction to this project");
		lblIntro.setEditable(false);
		lblIntro.setText(introduction);
		lblIntro.setBounds(132, 145, 362, 113);
		add(lblIntro);
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		label.setIcon(new ImageIcon("..\\Pics\\pic1.jpg"));
		label.setBounds(0, 0, 600, 600);
		add(label);
		
	}
}
