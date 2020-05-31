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
import java.awt.SystemColor;

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
					
					Splash splash = new Splash();
					splash.setLocationRelativeTo(null);
					splash.setVisible(true);
					 Thread.sleep(5000);
					 splash.dispose();
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
			
		 this.setResizable(false);
		 
		ImageIcon EMV = new ImageIcon("Images/EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		
		
		setTitle("EVIDENCIAS MARE VERUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoDeNuevo = new JLabel("\u00A1Bienvenido/a de nuevo!");
		lblBienvenidoDeNuevo.setForeground(Color.BLACK);
		lblBienvenidoDeNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDeNuevo.setFont(new Font("Cooper Black", Font.PLAIN, 50));
		lblBienvenidoDeNuevo.setBounds(0, 60, 794, 117);
		contentPane.add(lblBienvenidoDeNuevo);
		
		final JButton newEvidenceButton = new JButton("NUEVA \r\nEVIDENCIA");
		newEvidenceButton.setForeground(Color.BLACK);
		newEvidenceButton.setBackground(SystemColor.menu);
		newEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEvidence evidence = new NewEvidence(GC, frame);
				evidence.setLocationRelativeTo(null);
				evidence.setVisible(true);
				frame.setVisible(false);
				
			}
		});
	
		
		newEvidenceButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		newEvidenceButton.setBounds(29, 220, 320, 150);
		contentPane.add(newEvidenceButton);
		
		JButton editEvidenceButton = new JButton("AGREGAR FOTOS");
		editEvidenceButton.setForeground(Color.BLACK);
		editEvidenceButton.setBackground(SystemColor.menu);
		editEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddImage newE = new AddImage(GC, frame);
				newE.setLocationRelativeTo(null);
				newE.setVisible(true);
				dispose();
			}
		});
		editEvidenceButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		editEvidenceButton.setBounds(425, 220, 320, 150);
		contentPane.add(editEvidenceButton);
		
		JLabel labelWall = new JLabel("");
		labelWall.setEnabled(false);
		labelWall.setBounds(0, 0, 794, 571);
		ImageIcon icon = new ImageIcon("Images/LogoMareVerum.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		
		JButton btnFolders = new JButton("CREAR CARPETAS CONTENEDORAS");
		btnFolders.setForeground(new Color(0, 0, 0));
		btnFolders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FolderCreator fc = new FolderCreator(GC, frame);
				fc.setLocationRelativeTo(null);
				fc.setVisible(true);
				dispose();
				
			}
		});
		btnFolders.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnFolders.setBounds(29, 404, 448, 100);
		contentPane.add(btnFolders);
		
		JButton btnCrearCaratula = new JButton("CARATULA");
		btnCrearCaratula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newHead head = new newHead(GC, frame);
				head.setLocationRelativeTo(null);
				dispose();
				head.setVisible(true);
			}
		});
		btnCrearCaratula.setForeground(Color.BLACK);
		btnCrearCaratula.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnCrearCaratula.setBounds(519, 404, 225, 100);
		contentPane.add(btnCrearCaratula);
		
		JLabel lblVv = new JLabel("V 1.0");
		lblVv.setBounds(748, 557, 46, 14);
		contentPane.add(lblVv);
		labelWall.setIcon(wall);
		contentPane.add(labelWall);
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		
	}
}