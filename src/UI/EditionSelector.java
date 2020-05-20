package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EditionSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public EditionSelector(GeneralController GC, Menu frame) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon EMV = new ImageIcon("EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());

		contentPane.setLayout(null);
		
		JButton btnAgregarFotosA = new JButton("Agregar fotos a las Evidencias");
		btnAgregarFotosA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddImage newE = new AddImage(GC, frame);
				newE.setLocationRelativeTo(null);
				newE.setVisible(true);
				dispose();
			}
		});
		btnAgregarFotosA.setBounds(10, 129, 187, 104);
		contentPane.add(btnAgregarFotosA);
		
		JButton btnEditarLasImagenes = new JButton("Editar las imagenes de una Evidencia");
		btnEditarLasImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditImage EE = new EditImage(GC, frame);
				EE.setLocationRelativeTo(null);
				EE.setVisible(true);
				dispose();
				
			}
		});
		btnEditarLasImagenes.setBounds(210, 129, 200, 104);
		contentPane.add(btnEditarLasImagenes);
		
		JLabel lblquDeseaHacer = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblquDeseaHacer.setHorizontalAlignment(SwingConstants.CENTER);
		lblquDeseaHacer.setBounds(134, 82, 158, 14);
		contentPane.add(lblquDeseaHacer);
		
	    JButton btnBack = new JButton("< Volver");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		frame.setVisible(true);
	    		
	    	}
	    });
	    btnBack.setBounds(10, 11, 89, 23);
	    contentPane.add(btnBack);
	    
	    JLabel labelWall = new JLabel("");
	    labelWall.setEnabled(false);
	    labelWall.setBounds(0, 0, 784, 561);
		ImageIcon icon = new ImageIcon("LogoMareVerum.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		labelWall.setIcon(wall);
	    contentPane.add(labelWall);
	}
}
