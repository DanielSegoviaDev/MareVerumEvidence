package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.GeneralController;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AddImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ppPath;
	private File index;
	Vector<String>photoPath;

	/**
	 * Launch the application.
	/**
	 * Create the frame.
	 */
	public AddImage(final GeneralController GC, final Menu frame) {
		
		photoPath = new Vector<String>();
		photoPath.add("");
		photoPath.add("");
		photoPath.add("");
		photoPath.add("");
		
		this.setResizable(false);
		
		ImageIcon EMV = new ImageIcon("Images/EvidenciasMareVerum.png");
		setIconImage(EMV.getImage());
		
		setTitle("EVIDENCIAS MARE VERUM || Agregar fotos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ppPath = new JTextField();
		ppPath.setToolTipText("(Aqu\u00ED aparece la ruta de tu archivo)");
		ppPath.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		ppPath.setBounds(147, 24, 456, 30);
		contentPane.add(ppPath);
		ppPath.setColumns(10);
		
		final Choice subjectChoice = new Choice();
		subjectChoice.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		subjectChoice.setBounds(20, 96, 442, 35);
		contentPane.add(subjectChoice);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblMateria.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblMateria.setBounds(468, 87, 145, 44);
		contentPane.add(lblMateria);
		
		final Choice monthChoice = new Choice();
		monthChoice.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		monthChoice.setBounds(654, 96, 193, 20);
		contentPane.add(monthChoice);
		
		JLabel lblMes = new JLabel("MES");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblMes.setBounds(853, 87, 90, 44);
		contentPane.add(lblMes);
		
		
		
		JButton ppSelectButton = new JButton("Seleccione archivo");
		ppSelectButton.setToolTipText("(Donde esta guardado su archivo)");
		ppSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
	    		    
	    		    String path = index.getAbsolutePath();
	    		    File file = new File(path);
	    		    
	    		    if(GC.acceptExtension(file))
	    		    {
	    		    	GC.readEvidence(path);
	    		    	System.out.println("lei la evidencia");	    		    	
	    		    	
	    		    	int position = GC.compareEvidencePath(path);
	    		    	
	    		    	if(position != -1)
	    		    	
	    		    	{
   		
	    		    		Vector<String> subjects = new Vector<String>();
	    		    		Vector<String> period = new Vector<String>();
	    		    		
	    		    		subjects = GC.getEvidences().elementAt(position).getSubjects();
	    		    		period = GC.getEvidences().elementAt(position).getPeriod();
	    		    		
	    		    		subjectChoice.removeAll();
	    		    		monthChoice.removeAll();
	    		    		
	    		    		for(int i = 0; i <= subjects.size()-1; i++ ) 
	    		    		{
	    		    			subjectChoice.add(subjects.elementAt(i));
	    		    		}
	    		    		
	    		    		for(int i = 0; i <= period.size()-1; i++)
	    		    		{
	    		    			monthChoice.add(period.elementAt(i));
	    		    		}
	    		    	}
    	
	    		    }
	    		    
	    		}
			}
		});
		ppSelectButton.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		ppSelectButton.setBounds(613, 15, 330, 40);
		contentPane.add(ppSelectButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 71, 964, 2);
		contentPane.add(separator);
		
		
		ImageIcon image = new ImageIcon("Images/imageMissing.png");
		
		
		//IMAGE1
		final JButton btnImage1 = new JButton();
		btnImage1.setToolTipText("\u00A1Este es un bot\u00F3n seleccionable! Activame para seleccionar una foto para tu evidencia");
		
		btnImage1.setBounds(0, 151, 240, 240);
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
	    		    System.out.println(fc.getSelectedFile().toString());
	    			btnImage1.setIcon(new ImageIcon(Nimagen1.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
	    			//Save image url
	    			photoPath.set(0, fc.getSelectedFile().getAbsolutePath());
	    		}	
	    		
			}
		});
		
		
		
		
		
		
		
		
		//IMAGE2
		final JButton btnImage2 = new JButton();
		btnImage2.setToolTipText("\u00A1Este es un bot\u00F3n seleccionable! Activame para seleccionar una foto para tu evidencia");
		
		btnImage2.setBounds(245, 151, 240, 240);
		btnImage2.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage2.getWidth(), btnImage2.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage2);
		
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		JFileChooser fc=new JFileChooser();
	    		
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
	    		fc.setFileFilter(filter);
	    		 
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen2 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage2.setIcon(new ImageIcon(Nimagen2.getImage().getScaledInstance(btnImage2.getWidth(), btnImage2.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(1, fc.getSelectedFile().getAbsolutePath());
	    	}
		}
		});
		
		
		
		
		
		
		//IMAGE3
		final JButton btnImage3 = new JButton();
		btnImage3.setToolTipText("\u00A1Este es un bot\u00F3n seleccionable! Activame para seleccionar una foto para tu evidencia");
		
		btnImage3.setBounds(500, 151, 240, 240);
		btnImage3.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage3.getWidth(), btnImage3.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage3);
		
		btnImage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		JFileChooser fc=new JFileChooser();
	    		
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
	    		fc.setFileFilter(filter);
	    		 
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen3 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage3.setIcon(new ImageIcon(Nimagen3.getImage().getScaledInstance(btnImage3.getWidth(), btnImage3.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(2, fc.getSelectedFile().getAbsolutePath());
	    		
	    		}
		
			}
		});
	
		
		
		
		//IMAGE4
		final JButton btnImage4 = new JButton();
		btnImage4.setToolTipText("\u00A1Este es un bot\u00F3n seleccionable! Activame para seleccionar una foto para tu evidencia");
		
		btnImage4.setBounds(744, 151, 240, 240);
		btnImage4.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage4.getWidth(), btnImage4.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage4);
		
		btnImage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		JFileChooser fc=new JFileChooser();
	    		
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
	    		fc.setFileFilter(filter);
	    		 
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen4 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage4.setIcon(new ImageIcon(Nimagen4.getImage().getScaledInstance(btnImage4.getWidth(), btnImage4.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(3, fc.getSelectedFile().getAbsolutePath());
	    		}
			}
		});
	
		
		
		
		JButton addButton = new JButton("A\u00D1ADIR FOTOS");
		addButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					if(ppPath.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Seleccione una evidencia para poder continuar", "No se puede continuar", JOptionPane.ERROR_MESSAGE);
					}
					else if(photoPath.elementAt(0).equals("") || photoPath.elementAt(1).equals("") || photoPath.elementAt(2).equals("") || photoPath.elementAt(3).equals("") )
					{
						JOptionPane.showMessageDialog(null, "Debe completar todas las imagenes para continuar", "No se puede continuar", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						GC.addImages(subjectChoice.getSelectedItem(), monthChoice.getSelectedItem(), photoPath, index.getAbsolutePath());
						JOptionPane.showMessageDialog(null, "Se han añadido las fotos en el mes de "  + monthChoice.getSelectedItem() + " en la materia " + subjectChoice.getSelectedItem());
						if(JOptionPane.showConfirmDialog(null, "¿Desea seguir añadiendo fotos?","", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							photoPath.set(0, "");
							photoPath.set(1, "");
							photoPath.set(2, "");
							photoPath.set(3, "");
							
							btnImage1.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
							contentPane.add(btnImage1);
							btnImage2.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
							contentPane.add(btnImage1);
							btnImage3.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
							contentPane.add(btnImage1);
							btnImage4.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
							contentPane.add(btnImage1);
						}
						else
						{
				    		dispose();
				    		frame.setVisible(true);
						}
					}
				
				
				
				
				
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		addButton.setBounds(363, 432, 250, 46);
		contentPane.add(addButton);
		
	    JButton btnBack = new JButton("< Volver");
	    btnBack.setToolTipText("Volver al menu principal");
	    btnBack.setFont(new Font("Cooper Black", Font.PLAIN, 18));
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		frame.setVisible(true);
	    		
	    	}
	    });
	    btnBack.setBounds(0, 0, 110, 30);
	    contentPane.add(btnBack);
	    
	    JLabel labelWall = new JLabel("");
	    labelWall.setEnabled(false);
	    labelWall.setBounds(0, 0, 994, 571);
	    ImageIcon icon = new ImageIcon("Images/LogoMareVerum.png");
		ImageIcon wall = new ImageIcon(icon.getImage().getScaledInstance(labelWall.getWidth(), labelWall.getHeight(), Image.SCALE_SMOOTH));
		
		JLabel lblVv = new JLabel("V 1.0");
		lblVv.setBounds(948, 557, 46, 14);
		contentPane.add(lblVv);
		
		labelWall.setIcon(wall);
	    contentPane.add(labelWall);
	}
}