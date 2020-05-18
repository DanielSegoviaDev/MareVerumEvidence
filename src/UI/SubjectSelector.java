package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
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
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInThisSeccion = new JTextPane();
		txtpnInThisSeccion.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnInThisSeccion.setText("\r\n\r\nEn esta seccion, usted va a poder agregar sus materias. Escriba cada una de ellas separadas por c\u00F3mas.\r\n\r\nEjemplo: \r\n\r\nMatem\u00E1ticas, F\u00EDsica, Literatura, etcetera.");
		txtpnInThisSeccion.setBackground(new Color(0, 0, 0));
		txtpnInThisSeccion.setForeground(new Color(255, 255, 255));
		txtpnInThisSeccion.setEditable(false);
		txtpnInThisSeccion.setBounds(200, 0, 234, 261);
		contentPane.add(txtpnInThisSeccion);
		
		final JTextPane textPaneSubjets = new JTextPane();
		JScrollPane s = new JScrollPane();
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    s.setBounds(10, 11, 180, 210);
	    contentPane.add(s);
	    s.setViewportView(textPaneSubjets);
		
		JButton addSubjetsButton = new JButton("Agregar Materias");
		addSubjetsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String subjects = textPaneSubjets.getText();
				
				System.out.println(subjects);
				GC.getTextFromTP(subjects);
			}
		});
		addSubjetsButton.setBounds(10, 227, 180, 23);
		contentPane.add(addSubjetsButton);
	}

}
