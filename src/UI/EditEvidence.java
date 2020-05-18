package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class EditEvidence extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ppPath;
	private File index;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public EditEvidence(GeneralController GC) {
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
		
		Choice subjectChoice = new Choice();
		subjectChoice.setBounds(10, 50, 120, 20);
		contentPane.add(subjectChoice);
		
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
		
		
		
		JButton ppSelectButton = new JButton("Seleccione archivo");
		ppSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Creamos el objeto JFileChooser
	    		JFileChooser fc=new JFileChooser();
	    		 
	    		//Indicamos lo que podemos seleccionar
	    		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    		 
	    		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	    		int selection=fc.showOpenDialog(contentPane);
	    		 
	    		//Si el usuario, pincha en aceptar
	    		if(selection==JFileChooser.APPROVE_OPTION){
	    		 
	    			
	    		    //Seleccionamos el fichero
	    		    index = fc.getSelectedFile();
	    		    
	    		    ppPath.setText(index.getAbsolutePath());
	    		    
	    		    ppPath.setEditable(false);
	    		    
	    		    String path = index.getAbsolutePath();
	    		    File file = new File(path);
	    		    
	    		    if(GC.acceptExtension(file))
	    		    {
	    		    	GC.readEvidence(path);
	    		    	
	    		    	int position = GC.compareEvidencePath(path);
	    		    	
	    		    	if(position != -1)
	    		    	
	    		    	{
   		
	    		    		Vector<String> subjects = new Vector<String>();
	    		    		Vector<String> period = new Vector<String>();
	    		    		
	    		    		subjects = GC.getEvidences().elementAt(position).getSubjects();
	    		    		period = GC.getEvidences().elementAt(position).getPeriod();
	    		    		
	    		    		subjectChoice.removeAll();
	    		    		mesChoice.removeAll();
	    		    		
	    		    		for(int i = 0; i <= subjects.size()-1; i++ ) 
	    		    		{
	    		    			subjectChoice.add(subjects.elementAt(i));
	    		    		}
	    		    		
	    		    		for(int i = 0; i <= period.size()-1; i++)
	    		    		{
	    		    			mesChoice.add(period.elementAt(i));
	    		    		}
	    		    	}
    	
	    		    }
	    		    
	    		}
			}
		});
		ppSelectButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ppSelectButton.setBounds(263, 10, 161, 23);
		contentPane.add(ppSelectButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 434, 2);
		contentPane.add(separator);
		
		
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
		pickButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc=new JFileChooser();
	    		 
	    		//Indicamos lo que podemos seleccionar
				fc.setMultiSelectionEnabled(true);
	    		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    		
	    		 
	    		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	    		int selection=fc.showOpenDialog(contentPane);
	    		 
	    		//Si el usuario, pincha en aceptar
	    		if(selection==JFileChooser.APPROVE_OPTION)
	    		{
	    			File[] images = fc.getSelectedFiles();
	    			
	    		} 
				
			}
		});
		pickButton.setBounds(159, 81, 89, 23);
		contentPane.add(pickButton);
	}
}
