package UI;

import java.awt.Image;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controller.GeneralController;

import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class EditImage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Vector<String>photoPath;
	private Model.Subject subject;
	private JTextField textPath;
	private File index;

	
	public EditImage (final GeneralController GC, final Menu frame) {
		
		Dimension dim=super.getToolkit().getScreenSize();
		
	    super.setSize(dim);
		
		photoPath = new Vector<String>();
		photoPath.add("");
		photoPath.add("");
		photoPath.add("");
		photoPath.add("");
		
		setTitle("EVIDENCIAS MARE VERUM || Editar Imagenes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textPath = new JTextField();
		textPath.setBounds(10, 11, 240, 20);
		contentPane.add(textPath);
		textPath.setColumns(10);
		
		
		//CHOISES
		final Choice choiceSubjects = new Choice();
		choiceSubjects.setBounds(10, 63, 120, 20);
		contentPane.add(choiceSubjects);
		
		
		
		final Choice choiceMonth = new Choice();
		choiceMonth.setBounds(230, 63, 120, 20);
		contentPane.add(choiceMonth);
		
		
		
		JButton btnChargerPath = new JButton("Seleccione archivo");
		btnChargerPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
	    		    textPath.setText(index.getAbsolutePath());
	    		    textPath.setEditable(false);
	    		    
	    		    String path = index.getAbsolutePath();
	    		    File file = new File(path);
	    		    
	    		    if(GC.acceptExtension(file))
	    		    {
	    		    	GC.readEvidence(path);
	    		    	
	    		    	int position = GC.compareEvidencePath(path);
	    		    	
	    		    	if(position != -1)
	    		    	
	    		    	{
   		
	    		    		Vector<String> listSubject = new Vector<String>();
	    		    		Vector<String> listMonth = new Vector<String>();
	    		    		
	    		    		listSubject = GC.getEvidences().elementAt(position).getSubjects();
	    		    		listMonth = GC.getEvidences().elementAt(position).getPeriod();
	    		    		
	    		    		choiceSubjects.removeAll();
	    		    		choiceMonth.removeAll();
	    		    		
	    		    		for(int i = 0; i <= listSubject.size()-1; i++ ) 
	    		    		{
	    		    			choiceSubjects.add(listSubject.elementAt(i));
	    		    		}
	    		    		
	    		    		for(int i = 0; i <= listMonth.size()-1; i++)
	    		    		{
	    		    			choiceMonth.add(listMonth.elementAt(i));
	    		    		}
	    		    	}
    	
	    		    }
	    		}
				
			}
		});
		btnChargerPath.setBounds(260, 10, 164, 23);
		contentPane.add(btnChargerPath);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 414, 2);
		contentPane.add(separator);
		
		
		JLabel lblSubject = new JLabel("MATERIA");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblSubject.setBounds(136, 63, 68, 20);
		contentPane.add(lblSubject);
		
		JLabel lblMonth = new JLabel("MES");
		lblMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(356, 63, 68, 20);
		contentPane.add(lblMonth);
		
		

		
		final JLabel lblNewLabeltext = new JLabel("Seleccione la foto que desee remplazar");
		lblNewLabeltext.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabeltext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabeltext.setBounds(10, 128, 414, 20);
		contentPane.add(lblNewLabeltext);
		lblNewLabeltext.setVisible(false);
		
		


		


		//System.out.println(subject.getPicture(1, 1));

		ImageIcon imagen2 = new ImageIcon("C:\\Users\\elviv\\Downloads\\wolf.png");
		ImageIcon imagen3 = new ImageIcon("C:\\Users\\elviv\\Downloads\\wolf.png");
		ImageIcon imagen4 = new ImageIcon("C:\\Users\\elviv\\Downloads\\wolf.png");
	


		
		//IMAGE1
		final JButton btnImage1 = new JButton();
		btnImage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		JFileChooser fc=new JFileChooser();
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
	    		
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
	    		 	
	    		    //Seleccionamos el fichero
	    		    File fichero=fc.getSelectedFile();
	    			ImageIcon Nimagen1 = new ImageIcon(fc.getSelectedFile().toString());		    
	    		    System.out.println(fc.getSelectedFile().toString());
	    			btnImage1.setIcon(new ImageIcon(Nimagen1.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
	    			//Save image url
	    			photoPath.set(0,fc.getSelectedFile().getAbsolutePath());
	    		}	
	    		
			}
		});
		btnImage1.setBounds(10, 168, 90, 90);
		
		contentPane.add(btnImage1);
		btnImage1.setVisible(false);
		
		
		
		
		
		
		
		//IMAGE2
		final JButton btnImage2 = new JButton();
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		JFileChooser fc=new JFileChooser();
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen2 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage2.setIcon(new ImageIcon(Nimagen2.getImage().getScaledInstance(btnImage2.getWidth(), btnImage2.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(1,fc.getSelectedFile().getAbsolutePath());
	    		}
		}
		});
		btnImage2.setBounds(116, 168, 90, 90);
		btnImage2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(btnImage2.getWidth(), btnImage2.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage2);
		btnImage2.setVisible(false);
		
		
		
		
		
		//IMAGE3
		final JButton btnImage3 = new JButton();
		btnImage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		JFileChooser fc=new JFileChooser();
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen3 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage3.setIcon(new ImageIcon(Nimagen3.getImage().getScaledInstance(btnImage3.getWidth(), btnImage3.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(2,fc.getSelectedFile().getAbsolutePath());
	    		}
				
			}
		});
		btnImage3.setBounds(222, 168, 90, 90);
		btnImage3.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(btnImage3.getWidth(), btnImage3.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage3);
		btnImage3.setVisible(false);
		
		
		
		//IMAGE4
		final JButton btnImage4 = new JButton();
		btnImage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		JFileChooser fc=new JFileChooser();
	    		
	    		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    		
	    		int seleccion=fc.showOpenDialog(contentPane);
				
				
	    		if(seleccion==JFileChooser.APPROVE_OPTION){
				
    			ImageIcon Nimagen4 = new ImageIcon(fc.getSelectedFile().toString());		    
    		    System.out.println(fc.getSelectedFile().toString());
    			btnImage4.setIcon(new ImageIcon(Nimagen4.getImage().getScaledInstance(btnImage4.getWidth(), btnImage4.getHeight(), Image.SCALE_SMOOTH)));
    			photoPath.set(3,fc.getSelectedFile().getAbsolutePath());
	    		}
			}
		});
		btnImage4.setBounds(334, 168, 90, 90);
		btnImage4.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(btnImage4.getWidth(), btnImage4.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage4);
		btnImage4.setVisible(false);
		
						
		
		
		JButton btnUploadIMG = new JButton("Cargar Imagenes");
		btnUploadIMG.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Materia: "+choiceSubjects.getSelectedIndex());
				System.out.println("Mes :"+choiceMonth.getSelectedIndex());
				if(choiceSubjects.getSelectedIndex()==0)
				{
					subject = GC.getSubjectForPosition(1);
				}
				else
				{
					subject = GC.getSubjectForPosition(choiceSubjects.getSelectedIndex()*11);
				}
				
				
				System.out.println(subject.getName());
				
				Vector<byte[]> pp = subject.getPictures();				
				
				for (int i = 0; i < pp.size()-1; i++) {
					String nullPoint = new String(pp.elementAt(i));
					System.out.println(i+"  "+nullPoint.equals("null"));
				}
				
				byte[] im0 = subject.getPicture(choiceSubjects.getSelectedIndex(), 0);
				System.out.println(im0);

				
				ImageIcon imagen1 = new ImageIcon(im0);
				String nullPoint = new String(im0);
				System.out.println(nullPoint.equals("null"));
				
				System.out.println();
				//SI SELECCIONA, HACEMOS VISIBLE LAS FOTOS
				if (choiceMonth.getSelectedIndex()>= 0 && choiceSubjects.getSelectedIndex() >= 0)
				{
					
					lblNewLabeltext.setVisible(true);
					btnImage1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
					btnImage1.setVisible(true);
					btnImage2.setVisible(true);
					btnImage3.setVisible(true);
					btnImage4.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccione el periodo y el mes", "Error", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnUploadIMG.setBounds(146, 94, 140, 23);
		contentPane.add(btnUploadIMG);
		
		
		
		
		
		JButton btnSaveChanges = new JButton("Guardar Cambios");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//GC.addImages(choiceSubject.getSelectedItem(),choiceMonth.getSelectedItem(), photoPath, path);
			//FC.addImages(choiceSubjects.getSelectedItem(), choiceMonth.getSelectedItem(), photoPath, "path");	
			}
		});
		btnSaveChanges.setBounds(284, 280, 140, 23);
		contentPane.add(btnSaveChanges);
		
		
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(10, 280, 89, 23);
		contentPane.add(btnCancel);
		
		
	}
}