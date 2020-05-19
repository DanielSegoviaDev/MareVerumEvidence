package UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		
		JLabel lblBienvenidoDeNuevo = new JLabel("Bienvenido de Nuevo! ");
		lblBienvenidoDeNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDeNuevo.setFont(new Font("Arial", Font.BOLD, 14));
		lblBienvenidoDeNuevo.setBounds(129, 23, 173, 30);
		contentPane.add(lblBienvenidoDeNuevo);
		
		final JButton newEvidenceButton = new JButton("NUEVA \r\nEVIDENCIA");
		newEvidenceButton.setForeground(Color.BLACK);
		newEvidenceButton.setBackground(Color.LIGHT_GRAY);
		newEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEvidence evidence = new NewEvidence(GC, frame);
				evidence.setLocationRelativeTo(null);
				evidence.setVisible(true);
				frame.setVisible(false);
				
			}
		});
	
		
		newEvidenceButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		newEvidenceButton.setBounds(42, 82, 173, 100);
		contentPane.add(newEvidenceButton);
		
		JButton editEvidenceButton = new JButton("EDITA EVIDENCIAS");
		editEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddImage newE = new AddImage(GC, frame);
				newE.setLocationRelativeTo(null);
				frame.setVisible(false);
				newE.setVisible(true);
			}
		});
		editEvidenceButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		editEvidenceButton.setBounds(225, 82, 180, 100);
		contentPane.add(editEvidenceButton);
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		
	}
}