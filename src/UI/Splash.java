package UI;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.awt.AWTUtilities;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setResizable(false);
		
		AWTUtilities.setWindowOpaque(this, false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSDD = new JLabel("");
		lblSDD.setBounds(0, 0, 700, 450);
		ImageIcon icon = new ImageIcon("Images/Logo Personal.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(lblSDD.getWidth(), lblSDD.getHeight(), Image.SCALE_SMOOTH));
		lblSDD.setIcon(wall);
		contentPane.add(lblSDD);
		
		JLabel lblEnColaboracinCon = new JLabel("Con colaboraci\u00F3n de @ElviVilchez");
		lblEnColaboracinCon.setForeground(new Color(128, 128, 128));
		lblEnColaboracinCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnColaboracinCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnColaboracinCon.setBounds(40, 321, 647, 88);
		contentPane.add(lblEnColaboracinCon);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 25, 450);
		contentPane.add(panel_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(0, 0, 50, 450);
		contentPane.add(panel);
		
		
	}
}
