package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditEvidence extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ppPath;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public EditEvidence() {
		setTitle("EVIDENCIAS MARE VERUM || Editar evidencias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ppPath = new JTextField();
		ppPath.setBounds(10, 11, 243, 20);
		contentPane.add(ppPath);
		ppPath.setColumns(10);
		
		JButton ppSelectButton = new JButton("Seleccione archivo");
		ppSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		ppSelectButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ppSelectButton.setBounds(263, 10, 161, 23);
		contentPane.add(ppSelectButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 434, 2);
		contentPane.add(separator);
		
		Choice subjetChoice = new Choice();
		subjetChoice.setBounds(10, 50, 120, 20);
		contentPane.add(subjetChoice);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblMateria.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMateria.setBounds(136, 50, 68, 20);
		contentPane.add(lblMateria);
		
		Choice mesChoice = new Choice();
		mesChoice.setBounds(230, 50, 120, 20);
		contentPane.add(mesChoice);
		
		JLabel lblMes = new JLabel("MES");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMes.setBounds(356, 50, 46, 20);
		contentPane.add(lblMes);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 127, 90, 90);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(114, 127, 90, 90);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(219, 127, 90, 90);
		contentPane.add(label_2);
		
		JLabel label_2_1 = new JLabel("");
		label_2_1.setBounds(334, 127, 90, 90);
		contentPane.add(label_2_1);
		
		JButton addButton = new JButton("A\u00D1ADIR FOTOS");
		addButton.setBounds(50, 227, 148, 23);
		contentPane.add(addButton);
		
		JButton cancelButton = new JButton("CANCELAR");
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 12));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(219, 227, 148, 23);
		contentPane.add(cancelButton);
		
		JButton pickButton = new JButton("FOTOS");
		pickButton.setBounds(159, 81, 89, 23);
		contentPane.add(pickButton);
	}
}
