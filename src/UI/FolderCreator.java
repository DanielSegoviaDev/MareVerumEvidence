package UI;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import Controller.GeneralController;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FolderCreator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File index;
	private boolean flag;
	/**
	 * Create the frame.
	 */
	public FolderCreator(GeneralController GC, Menu frame) {
		setResizable(false);
		
		flag = false;
		setTitle("EVIDENCIAS MARE VERUM || Crear carpetas");
		
		ImageIcon EMV = new ImageIcon("Images/EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon = new ImageIcon("Images/LogoMareVerum.png");
		
		
		
		JScrollPane s = new JScrollPane();
		s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		s.setBounds(80, 229, 601, 200);
		contentPane.add(s);
		final JList<String> subjects = new JList<String>(new DefaultListModel<String>());
		subjects.setForeground(Color.BLACK);
		s.setViewportView(subjects);
		subjects.setFont(new Font("Cooper Black", Font.PLAIN, 45));
		subjects.setToolTipText("Aqu\u00ED se muestran las materias Seleccionadas");
		
	    JLabel label = new JLabel("");
	    label.setFont(new Font("Cooper Black", Font.PLAIN, 20));
	    label.setBounds(44, 183, 520, 30);
	    contentPane.add(label);
		
		
		
		JButton btnCrearCarpetas = new JButton("CREAR CARPETAS");
		btnCrearCarpetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(((DefaultListModel<String>) subjects.getModel()).isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Seleccione una evidencia para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if (label.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ingrese una dirección para sus carpetas contenedoras", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else {
				
					GC.generateFolders(index.getAbsolutePath());
    		    	JOptionPane.showMessageDialog(null,"¡Se han creado las carpetas de materias correctamente!");
				
    		    	dispose();
					frame.setVisible(true);
    		    	((DefaultListModel<String>) subjects.getModel()).removeAllElements();
				
				}
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Direcci\u00F3n");
		btnNewButton_1.addActionListener(new ActionListener() {
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
	    		    
	    		    label.setText(index.getAbsolutePath());
	    		    
	    		   
	    		}
				
			}
		});
		btnNewButton_1.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnNewButton_1.setBounds(630, 131, 135, 40);
		contentPane.add(btnNewButton_1);
		btnCrearCarpetas.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnCrearCarpetas.setBounds(266, 460, 250, 76);
		contentPane.add(btnCrearCarpetas);
		
		JButton btnBack = new JButton("< Volver");
		btnBack.setToolTipText("Volver al menu principal");
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(0, 0, 110, 30);
		contentPane.add(btnBack);
		
		JLabel lblSeleccioneElArchivo = new JLabel("SELECCIONE EL ARCHIVO DE EVIDENCIAS: ");
		lblSeleccioneElArchivo.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblSeleccioneElArchivo.setBounds(26, 67, 601, 30);
		contentPane.add(lblSeleccioneElArchivo);
		
		JButton btnNewButton = new JButton("Archivo");
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flag = true;
				//Creamos el objeto JFileChooser
	    		JFileChooser fc=new JFileChooser();
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ppt files", "ppt");
	    		fc.setFileFilter(filter);
	    		 
	    		//Indicamos lo que podemos seleccionar
	    		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    		 
	    		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	    		int selection=fc.showOpenDialog(contentPane);
	    		 
	    		//Si el usuario, pincha en aceptar
	    		if(selection==JFileChooser.APPROVE_OPTION){
	    		 
	    			
	    		    //Seleccionamos el fichero
	    		    index = fc.getSelectedFile();
	    		    GC.readEvidence(index.getAbsolutePath());
	    		    
	    		   
	    		    
	    		}
	    		else 
	    		{
	    			flag = false;
	    		}
			}
		});
		btnNewButton.setBounds(601, 63, 120, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblSeleccioneDondeSe = new JLabel("SELECCIONE DONDE SE VAN A CREAR LAS CARPETAS:");
		lblSeleccioneDondeSe.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblSeleccioneDondeSe.setBounds(26, 132, 601, 38);
		contentPane.add(lblSeleccioneDondeSe);
	    
	    JLabel labelWall = new JLabel("");
	    labelWall.setEnabled(false);
	    labelWall.setBounds(0, 0, 794, 571);
	    ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
	    
		JLabel lblVv = new JLabel("V 1.1v");
		lblVv.setBounds(738, 547, 46, 14);
		contentPane.add(lblVv);
	    labelWall.setIcon(wall);
	    contentPane.add(labelWall);
	    contentPane.add(labelWall);
	    
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
	    
	    
	}
}
