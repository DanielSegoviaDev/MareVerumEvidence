package UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SubjectSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SubjectSelector(final GeneralController GC) {
		setTitle("EVIDENCIAS MARE VERUM || Agregar materias");
		
		ImageIcon EMV = new ImageIcon("EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInThisSeccion = new JTextPane();
		txtpnInThisSeccion.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		txtpnInThisSeccion.setText("\r\n\r\nEn esta secci\u00F3n, usted va a poder agregar sus materias. Escriba cada una de ellas separadas por c\u00F3mas.\r\n\r\nEjemplo: \r\n\r\nMatem\u00E1ticas, F\u00EDsica, Literatura, etcetera.");
		txtpnInThisSeccion.setBackground(new Color(169, 169, 169));
		txtpnInThisSeccion.setForeground(new Color(0, 0, 0));
		txtpnInThisSeccion.setEditable(false);
		txtpnInThisSeccion.setBounds(302, 0, 282, 361);
		contentPane.add(txtpnInThisSeccion);
		
		final JTextPane textPaneSubjets = new JTextPane();
		textPaneSubjets.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		JScrollPane s = new JScrollPane();
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    s.setBounds(10, 11, 270, 290);
	    contentPane.add(s);
	    s.setViewportView(textPaneSubjets);
		
		JButton addSubjetsButton = new JButton("Agregar Materias");
		addSubjetsButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		addSubjetsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textPaneSubjets.getText().equals(""))
				{
					
				String subjects = textPaneSubjets.getText();
				
				System.out.println(subjects);
				GC.getTextFromTP(subjects);
				JOptionPane.showMessageDialog(null, "Se han añadido las materias");
				dispose();
				
				}
				
				else
				
				{
					JOptionPane.showMessageDialog(null, "Ingrese al menos una materia para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		addSubjetsButton.setBounds(10, 312, 267, 38);
		contentPane.add(addSubjetsButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(169, 169, 169));
		textPane.setEditable(false);
		textPane.setEnabled(false);
		textPane.setBounds(290, 0, 12, 361);
		contentPane.add(textPane);
	}
}