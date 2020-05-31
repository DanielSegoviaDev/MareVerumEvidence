package UI;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.compress.utils.IOUtils;

import Controller.GeneralController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Choice;

public class newHead extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfId;
	private JTextField ppPath;
	private byte[] photo;
	private File index;
	private JTextField tfAno;
	private String photoP;

	public newHead(GeneralController GC, Menu frame) {
		setTitle("EVIDENCIAS MARE VERUM || Crear Caratula");
		
		photoP="";
		
		this.setResizable(false);
		 
		ImageIcon EMV = new ImageIcon("Images/EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("< Volver");
		btnBack.setToolTipText("Volver al menu principal");
		btnBack.setFont(new Font("Cooper Black", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(0, 0, 110, 30);
		contentPane.add(btnBack);
		ImageIcon icon = new ImageIcon("Images/LogoMareVerum.png");
		
		JButton btnNewButton = new JButton("Archivo");
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
	    		    
	    		    ppPath.setText(index.getAbsolutePath());
	    		    
	    		    ppPath.setEditable(false);
  
	    		}

			}
		});
		btnNewButton.setBounds(627, 24, 120, 40);
		contentPane.add(btnNewButton);
		
		ppPath = new JTextField();
		ppPath.setToolTipText("(Aqu\u00ED aparece la ruta de tu archivo)");
		ppPath.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		ppPath.setBounds(150, 29, 456, 30);
		contentPane.add(ppPath);
		ppPath.setColumns(10);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		tfName.setBounds(20, 152, 365, 30);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfId = new JTextField();
		tfId.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		tfId.setBounds(20, 230, 365, 30);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNombreDelAlumno = new JLabel("NOMBRE Y APELLIDO: ");
		lblNombreDelAlumno.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblNombreDelAlumno.setBounds(20, 115, 365, 20);
		contentPane.add(lblNombreDelAlumno);
		
		JLabel lblNewLabel = new JLabel("MATRICULA: ");
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 199, 365, 20);
		contentPane.add(lblNewLabel);
		
		//IMAGE1
		
				ImageIcon image = new ImageIcon("Images/imageMissing.png");
				final JButton btnImage1 = new JButton();
				btnImage1.setToolTipText("\u00A1Este es un bot\u00F3n seleccionable! Activame para seleccionar una foto para tu evidencia");
				
				btnImage1.setBounds(455, 183, 315, 220);
				btnImage1.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
				contentPane.add(btnImage1);
				
				btnImage1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
			    		JFileChooser fc=new JFileChooser();
			    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
			    		fc.setFileFilter(filter);
			    		 
			    		
			    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
			    		
			    		int seleccion=fc.showOpenDialog(contentPane);
			    		
			    		if(seleccion==JFileChooser.APPROVE_OPTION){
			    		 	
			    		    //Seleccionamos el fichero
			    			ImageIcon Nimagen1 = new ImageIcon(fc.getSelectedFile().toString());		    

			    			btnImage1.setIcon(new ImageIcon(Nimagen1.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
			    			//Save image url
			    			String photoPath =  fc.getSelectedFile().getAbsolutePath();
			    			try {
								photo = IOUtils.toByteArray(new FileInputStream(photoPath));
								photoP = photoPath; 
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    		}	
			    		
					}
				});
				
				Choice cyclesSelector = new Choice();
				cyclesSelector.setFont(new Font("Cooper Black", Font.PLAIN, 20));
				cyclesSelector.setBounds(20, 308, 365, 44);
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
				
		
		
		
		JLabel lblImagenDelAlumno = new JLabel("IMAGEN DEL ALUMNO:");
		lblImagenDelAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenDelAlumno.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lblImagenDelAlumno.setBounds(478, 152, 258, 20);
		contentPane.add(lblImagenDelAlumno);
		
		JButton btnAgregarCaratula = new JButton("AGREGAR CARATULA");
		btnAgregarCaratula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ppPath.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Seleccione una evidencia para poder agregar una caratula", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if(tfName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ingrese el Nombre y Apellido del Alumno", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if(tfId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ingrese una Matricula valida para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if(photoP.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ingrese una foto para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if(cyclesSelector.getSelectedItem().equals("Ciclo...")) 
				{
					JOptionPane.showMessageDialog(null, "Seleccione un ciclo valido para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else if(tfAno.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Ingrese el año cursado para continuar", "No es posible continuar", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				
				GC.newHead(tfName.getText(), tfId.getText(), photo, cyclesSelector.getSelectedItem(), tfAno.getText(), index.getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Se ha creado correctamente la caratula.");
				
				dispose();
				frame.setVisible(true);
				}
			}
		});
		btnAgregarCaratula.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnAgregarCaratula.setBounds(240, 470, 300, 50);
		contentPane.add(btnAgregarCaratula);
		
		JLabel lblMater = new JLabel("CICLO: ");
		lblMater.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblMater.setBounds(20, 282, 365, 20);
		contentPane.add(lblMater);
		
		JLabel lblAo = new JLabel("A\u00D1O:");
		lblAo.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblAo.setBounds(20, 358, 365, 25);
		contentPane.add(lblAo);
		

		
		tfAno = new JTextField();
		tfAno.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		tfAno.setBounds(20, 390, 365, 30);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		
		JLabel labelWall = new JLabel("");
		labelWall.setEnabled(false);
		labelWall.setBounds(0, 0, 794, 571);
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 794, 2);
		contentPane.add(separator);
		
		JLabel lblV = new JLabel("V 1.0");
		lblV.setBounds(758, 557, 36, 14);
		contentPane.add(lblV);
		labelWall.setIcon(wall);
	    contentPane.add(labelWall);
		
		
	}
}
