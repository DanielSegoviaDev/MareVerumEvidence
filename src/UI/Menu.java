package UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
		setTitle("EVIDENCIAS MARE VERUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoDeNuevo = new JLabel("Bienvenido de Nuevo! ");
		lblBienvenidoDeNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDeNuevo.setFont(new Font("Arial", Font.BOLD, 14));
		lblBienvenidoDeNuevo.setBounds(129, 23, 173, 30);
		contentPane.add(lblBienvenidoDeNuevo);
		
		JButton newEvidenceButton = new JButton("NUEVA \r\nEVIDENCIA");
		newEvidenceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newEvidenceButton.setBackground(new Color(60, 90, 115));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newEvidenceButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		
		
		newEvidenceButton.setForeground(Color.BLACK);
		newEvidenceButton.setBackground(Color.LIGHT_GRAY);
		newEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEvidence evidence = new NewEvidence();
				evidence.setVisible(true);
				
			}
		});
	
		
		newEvidenceButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		newEvidenceButton.setBounds(42, 82, 173, 100);
		contentPane.add(newEvidenceButton);
		
		JButton editEvidenceButton = new JButton("EDITA EVIDENCIAS");
		editEvidenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEvidence newE = new EditEvidence();
				newE.setVisible(true);
			}
		});
		editEvidenceButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		editEvidenceButton.setBounds(225, 82, 180, 100);
		contentPane.add(editEvidenceButton);
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		
	}
}
