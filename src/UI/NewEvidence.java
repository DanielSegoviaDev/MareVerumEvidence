package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GeneralController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Choice;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private boolean flag;
	private final Menu frame;


	/**
	 * Create the frame.
	 */
	public NewEvidence(final GeneralController GC, final Menu frame) {
		
		flag = false;
		
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
		
		JButton subjSelectorButton = new JButton("Seleccionar Materias");
		subjSelectorButton.setBackground(new Color(255, 240, 245));
		subjSelectorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = true;
				SubjectSelector newSelector = new SubjectSelector(GC);
				newSelector.setLocationRelativeTo(null);
				newSelector.setVisible(true);
				
			}
		});
		subjSelectorButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		subjSelectorButton.setToolTipText("Las materias que conforman su Ciclo Lectivo");
		subjSelectorButton.setBounds(20, 166, 300, 54);
		contentPane.add(subjSelectorButton);
		
		
		
		JScrollPane s = new JScrollPane();
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    s.setBounds(330, 100, 448, 230);
	    contentPane.add(s);
	    final JList<String> subjects = new JList<String>(new DefaultListModel<String>());
	    subjects.setForeground(Color.BLACK);
	    s.setViewportView(subjects);
	    subjects.setFont(new Font("Cooper Black", Font.PLAIN, 35));
	    subjects.setToolTipText("Aqu\u00ED se muestran las materias Seleccionadas");
	    
	    addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e) {
	    		 ((DefaultListModel<String>) subjects.getModel()).removeAllElements();
	    		 
	    		 if(flag) 
	    		 {
	    			 for(int i = 0; i <= GC.getSubjectVector().size() - 1; i++)
	    			 { 
	    			
	    				 ((DefaultListModel<String>) subjects.getModel()).addElement(GC.getSubjectVector().elementAt(i));
	    			 }
	    		}
	    	}
	    });
	    
	    JSeparator separator = new JSeparator();
	    separator.setBounds(10, 82, 768, 7);
	    contentPane.add(separator);
	    
	    final Choice periodSelector = new Choice();
	    periodSelector.setFont(new Font("Cooper Black", Font.PLAIN, 30));
	    periodSelector.setBounds(20, 237, 300, 30);
	    periodSelector.add("Periodo");
	    periodSelector.add("Marzo - Noviembre");
	    periodSelector.add("Agosto - Abril");
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
	    		else if(((DefaultListModel<String>) subjects.getModel()).isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null, "Ingrese al menos una materia para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else if(periodSelector.getSelectedItem().equals("Periodo"))
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
		    		((DefaultListModel<String>) subjects.getModel()).removeAllElements();
		    		
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
	    		((DefaultListModel<String>) subjects.getModel()).removeAllElements();

	    		
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
		labelWall.setIcon(wall);
	    contentPane.add(labelWall);
		
		
	}
	
    private void closeWind() {
		dispose();
		frame.setVisible(true);
		flag = false;
    }

}