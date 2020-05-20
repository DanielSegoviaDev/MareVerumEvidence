package UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Menu frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					frame = new Menu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		 final GeneralController GC = GeneralController.getController();
			
		 
		 
		ImageIcon EMV = new ImageIcon("EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		
		
		setTitle("EVIDENCIAS MARE VERUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoDeNuevo = new JLabel("\u00A1Bienvenido/a de nuevo!");
		lblBienvenidoDeNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDeNuevo.setFont(new Font("Cooper Black", Font.PLAIN, 50));
		lblBienvenidoDeNuevo.setBounds(25, 41, 718, 117);
		/*
		ImageIcon II = new ImageIcon("bienvenido.png");

		ImageIcon welcome = new ImageIcon(II.getImage().getScaledInstance(lblBienvenidoDeNuevo.getWidth(), lblBienvenidoDeNuevo.getHeight(), Image.SCALE_SMOOTH));
		lblBienvenidoDeNuevo.setIcon(welcome);
		 */
		contentPane.add(lblBienvenidoDeNuevo);
		
		final JButton newEvidenceButton = new JButton("NUEVA \r\nEVIDENCIA");
		newEvidenceButton.setForeground(Color.BLACK);
		newEvidenceButton.setBackground(new Color(255, 245, 238));
		newEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEvidence evidence = new NewEvidence(GC, frame);
				evidence.setLocationRelativeTo(null);
				evidence.setVisible(true);
				frame.setVisible(false);
				
			}
		});
	
		
		newEvidenceButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		newEvidenceButton.setBounds(101, 185, 250, 200);
		contentPane.add(newEvidenceButton);
		
		JButton editEvidenceButton = new JButton("EDITAR EVIDENCIAS");
		editEvidenceButton.setBackground(new Color(255, 245, 238));
		editEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditionSelector newES = new EditionSelector(GC, frame);
				newES.setLocationRelativeTo(null);
				newES.setVisible(true);
				frame.setVisible(false);
			}
		});
		editEvidenceButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		editEvidenceButton.setBounds(425, 185, 250, 200);
		contentPane.add(editEvidenceButton);
		
		JLabel labelWall = new JLabel("");
		labelWall.setEnabled(false);
		labelWall.setBounds(0, 0, 784, 561);
		ImageIcon icon = new ImageIcon("LogoMareVerum.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		labelWall.setIcon(wall);
		contentPane.add(labelWall);
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		
	}
}