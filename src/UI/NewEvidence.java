package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JList;

import javax.swing.JScrollPane;

import java.awt.Choice;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Color;

public class NewEvidence extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private File index;


	/**
	 * Create the frame.
	 */
	public NewEvidence(GeneralController GC) {
		setTitle("EVIDENCIAS MARE VERUM  || Crear Evidencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelArchivo = new JLabel("Nombre del Archivo:");
		lblNombreDelArchivo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNombreDelArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelArchivo.setToolTipText("(El nombre con el que se va a guardar el archivo)");
		lblNombreDelArchivo.setBounds(14, 11, 144, 20);
		contentPane.add(lblNombreDelArchivo);
		
		nameField = new JTextField();
		nameField.setBounds(168, 11, 260, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JButton subjSelectorButton = new JButton("Seleccionar Materias");
		subjSelectorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectSelector newSelector = new SubjectSelector(GC);
				newSelector.setVisible(true);
				
			}
		});
		subjSelectorButton.setFont(new Font("Arial", Font.PLAIN, 12));
		subjSelectorButton.setToolTipText("Las materias que conforman su Ciclo Lectivo");
		subjSelectorButton.setBounds(14, 81, 167, 23);
		contentPane.add(subjSelectorButton);
		
		
		
		JScrollPane s = new JScrollPane();
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    s.setBounds(197, 71, 214, 87);
	    contentPane.add(s);
	    JList<String> subjects = new JList<String>(new DefaultListModel<String>());
	    subjects.setFont(new Font("Arial", Font.PLAIN, 15));
	    subjects.setToolTipText("Aqu\u00ED se muestran las materias Seleccionadas");
	    s.setViewportView(subjects);
	    
	    addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e) {
	    		 for(int i = 0; i <= GC.getSubjectVector().size() - 1; i++)
	    		 { 
	    		    ((DefaultListModel<String>) subjects.getModel()).addElement(GC.getSubjectVector().elementAt(i));
	    		 }
	    	}
	    });
	    
	    JSeparator separator = new JSeparator();
	    separator.setBounds(6, 44, 422, 7);
	    contentPane.add(separator);
	    
	    Choice periodSelector = new Choice();
	    periodSelector.setFont(new Font("Arial Black", Font.PLAIN, 14));
	    periodSelector.setBounds(14, 124, 167, 20);
	    periodSelector.add("Periodo");
	    periodSelector.add("Marzo - Noviembre");
	    periodSelector.add("Agosto - Abril");
	    contentPane.add(periodSelector);
	  
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setBounds(6, 184, 422, 7);
	    contentPane.add(separator_1);
	    
	    JLabel labelPath = new JLabel("Ej... C:\\Users\\User\\Documents");
	    labelPath.setFont(new Font("Arial", Font.PLAIN, 12));
	    labelPath.setBounds(14, 194, 241, 20);
	    contentPane.add(labelPath);
	   
	    
	    JButton pathSelectorButton = new JButton("Seleccione la Ruta");
	    pathSelectorButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//Creamos el objeto JFileChooser
	    		JFileChooser fc=new JFileChooser();
	    		 
	    		//Indicamos lo que podemos seleccionar
	    		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    		 
	    		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	    		int seleccion=fc.showOpenDialog(contentPane);
	    		 
	    		//Si el usuario, pincha en aceptar
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
	    		 
	    			
	    		    //Seleccionamos el fichero
	    		    index = fc.getSelectedFile();
	    		    
	    		    labelPath.setText(index.getAbsolutePath());
	    		    
	    		   
	    		}
	    	}});
	    pathSelectorButton.setToolTipText("Donde se va a Guardar el archivo");
	    pathSelectorButton.setBounds(278, 193, 151, 23);
	    contentPane.add(pathSelectorButton);
	    
	    JButton constructEvidenceB = new JButton("CREAR EVIDENCIA");
	    constructEvidenceB.setFont(new Font("Arial Black", Font.PLAIN, 12));
	    constructEvidenceB.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		System.out.println(index.getAbsolutePath());
	    		
	    		System.out.println("-------------------");
	    		
	    		System.out.println(index.getAbsolutePath() + "\\" +  nameField.getText());
	    		
	    		GC.newEvidence(periodSelector.getSelectedItem(), index.getAbsolutePath() + "\\" +  nameField.getText() + ".ppt");
	    	}
	    });
	    constructEvidenceB.setBounds(125, 225, 167, 23);
	    contentPane.add(constructEvidenceB);
	    
	 
	    
	    

		
		
		
		
		
	}
}
