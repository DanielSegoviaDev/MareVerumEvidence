package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

import java.awt.Choice;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;


public class NewEvidence extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private File index;

	private final Menu frame;


	/**
	 * Create the frame.
	 */
	public NewEvidence(final GeneralController GC, final Menu frame) {
		
		
		this.frame = frame;
		
		this.setResizable(false);
		
		ImageIcon EMV = new ImageIcon("Images/EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		setTitle("EVIDENCIAS MARE VERUM  || Crear Evidencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelArchivo = new JLabel("Nombre del Archivo:");
		lblNombreDelArchivo.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		lblNombreDelArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelArchivo.setToolTipText("(El nombre con el que se va a guardar el archivo)");
		lblNombreDelArchivo.setBounds(80, 21, 388, 49);
		contentPane.add(lblNombreDelArchivo);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Cooper Black", Font.BOLD, 25));
		nameField.setBounds(470, 27, 308, 41);
		contentPane.add(nameField);
		nameField.setColumns(10);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBounds(10, 82, 768, 7);
	    contentPane.add(separator);
	    
	    final Choice periodSelector = new Choice();
	    periodSelector.setFont(new Font("Cooper Black", Font.PLAIN, 29));
	    periodSelector.setBounds(236, 259, 300, 40);
	    periodSelector.add("Periodo...");
	    periodSelector.add("Marzo - Noviembre");
	    periodSelector.add("Agosto - Abril");
	    
	    Choice cyclesSelector = new Choice();
	    cyclesSelector.setFont(new Font("Cooper Black", Font.PLAIN, 29));
	    cyclesSelector.setBounds(236, 181, 300, 40);
	    
	    cyclesSelector.add("Ciclo...");
	    cyclesSelector.add("Crianza 3");
	    cyclesSelector.add("Crianza 4");
	    cyclesSelector.add("Crianza 5");
	    cyclesSelector.add("Gramática 1");
	    cyclesSelector.add("Gramática 2");
	    cyclesSelector.add("Gramática 3");
	    cyclesSelector.add("Gramática 4");
	    cyclesSelector.add("Gramática 5");
	    cyclesSelector.add("Gramática 6");	    
	    cyclesSelector.add("Lógica 1");
	    cyclesSelector.add("Lógica 2");
	    cyclesSelector.add("Lógica 3");
	    cyclesSelector.add("Retórica 1");
	    cyclesSelector.add("Retórica 2");
	    cyclesSelector.add("Retórica 3");	 
	    
	    
	    contentPane.add(cyclesSelector);
	    contentPane.add(periodSelector);
	  
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setBounds(10, 352, 768, 7);
	    contentPane.add(separator_1);
	    
	    JSeparator separator_1_1 = new JSeparator();
	    separator_1_1.setBounds(10, 440, 768, 7);
	    contentPane.add(separator_1_1);
	    
	    
	    final JLabel labelPath = new JLabel("Ej... C:\\Users\\User\\Documents");
	    labelPath.setFont(new Font("Cooper Black", Font.PLAIN, 25));
	    labelPath.setBounds(10, 378, 431, 37);
	    contentPane.add(labelPath);
	   
	    
	    JButton pathSelectorButton = new JButton("Seleccione la Ruta");
	    pathSelectorButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
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
	    pathSelectorButton.setBounds(451, 370, 327, 48);
	    contentPane.add(pathSelectorButton);
	    
	    JButton constructEvidenceB = new JButton("CREAR EVIDENCIA");
	    constructEvidenceB.setFont(new Font("Cooper Black", Font.PLAIN, 25));
	    constructEvidenceB.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(nameField.getText().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Ingrese un nombre para su evidencia", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else if(cyclesSelector.getSelectedItem().equals("Ciclo..."))
	    		{
	    			JOptionPane.showMessageDialog(null, "Seleccione un ciclo valido para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else if(periodSelector.getSelectedItem().equals("Periodo..."))
	    		{
	    			JOptionPane.showMessageDialog(null, "Seleccione un periodo valido para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else if(index == null)
	    		{
	    			JOptionPane.showMessageDialog(null, "Ingrese la ruta donde se va a guardar su evidencia", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else 
	    		{	
	    		System.out.println(index.getAbsolutePath());
	    		
	    		System.out.println("-------------------");
	    		
	    		System.out.println(index.getAbsolutePath() + "\\" +  nameField.getText());
	    		
	    		String filePath = index.getAbsolutePath() + "\\" +  nameField.getText() + ".ppt";
	    		
	    		GC.updateSubjectsNamesVector(cyclesSelector.getSelectedItem());
	    		
	    		if (GC.newEvidence(periodSelector.getSelectedItem(), filePath))
	    		{
	    			JOptionPane.showMessageDialog(null,"¡Se ha creado su evidencia correctamente!");
	    			
	    			if(JOptionPane.showConfirmDialog(null, "Desea crear una carpeta contenedora de materias?","",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    			{
	    	    		//Creamos el objeto JFileChooser
	    	    		JFileChooser fc=new JFileChooser();
	    	    		 
	    	    		//Indicamos lo que podemos seleccionar
	    	    		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    	    
	    	    		 
	    	    		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	    	    		int seleccion=fc.showOpenDialog(contentPane);
	    	    		 
	    	    		//Si el usuario, pincha en aceptar
	    	    		if(seleccion==JFileChooser.APPROVE_OPTION){
	    	    		 
	    	    			
	    	    		    //Seleccionamos el fichero
	    	    		    File directory = fc.getSelectedFile();
	    	    		    
	    	    		    GC.generateFolders(directory.getAbsolutePath());
	    	    		    
	    	    		    JOptionPane.showMessageDialog(null,"¡Se han creado las carpetas de materias correctamente!");
	    	    		}
	    				
	    				
	    			}
	    			
	    			closeWind();
		    		
	    		}
	    		else
	    		{
					JOptionPane.showMessageDialog(null, "Ingrese un nombre diferente al archivo para continuar");
	    		}

	    		}
	    	}
	    });
	    constructEvidenceB.setBounds(255, 471, 293, 54);
	    contentPane.add(constructEvidenceB);
	    
	    JButton btnBack = new JButton("< Volver");
	    btnBack.setToolTipText("Volver al menu principal");
	    btnBack.setFont(new Font("Cooper Black", Font.PLAIN, 16));
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		closeWind();

	    		
	    	}
	    });
	    btnBack.setBounds(0, 0, 115, 27);
	    contentPane.add(btnBack);
	    
	    JLabel labelWall = new JLabel("");
	    labelWall.setEnabled(false);
	    labelWall.setBounds(0, 0, 794, 571);
		ImageIcon icon = new ImageIcon("Images/LogoMareVerum.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		
				JLabel lblVv = new JLabel("V 1.0");
				lblVv.setBounds(748, 557, 46, 14);
				contentPane.add(lblVv);
		
		JLabel lblSeleccioneCicloY = new JLabel("SELECCIONE CICLO Y PERIODO");
		lblSeleccioneCicloY.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneCicloY.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		lblSeleccioneCicloY.setBounds(69, 119, 589, 37);
		contentPane.add(lblSeleccioneCicloY);
		labelWall.setIcon(wall);
	    contentPane.add(labelWall);
		
		
	}
	
    private void closeWind() {
		dispose();
		frame.setVisible(true);
    }
}