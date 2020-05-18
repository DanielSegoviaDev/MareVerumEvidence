package UI;

import java.awt.Image;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.FileController;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class EditImage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Vector<String>photoPath;
	
	
	//private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen","jpg");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditImage frame = new EditImage();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EditImage() {
		


		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubject = new JLabel("MATERIA");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblSubject.setBounds(136, 10, 68, 20);
		contentPane.add(lblSubject);
		
		JLabel lblMonth = new JLabel("MES");
		lblMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(356, 10, 68, 20);
		contentPane.add(lblMonth);
		
		
		//Instance the controller
		final FileController FC = new FileController();
		
		
		//Shows list of subjects

		Vector<String> listSubject = new Vector<String>();
		listSubject = FC.getSubjects("C:\\Users\\elviv\\Desktop\\Elvi.ppt");
	
		final Choice choiceSubjects = new Choice();
		choiceSubjects.setBounds(10, 10, 120, 20);
		for (int i = 0; i <= listSubject.size()-1;i++)
		{
			choiceSubjects.add(listSubject.elementAt(i));
		}
		contentPane.add(choiceSubjects);
		
		
		//Shows list of months
		final Choice choiceMonth = new Choice();
		Vector<String> listMonth = new Vector<String>();
		choiceMonth.setBounds(230, 10, 120, 20);
		for (int i = 0; i <=listMonth.size() -1; i++)
		{
			choiceMonth.add(listMonth.elementAt(i));
		}
		contentPane.add(choiceMonth);
		
		
		final JLabel lblNewLabeltext = new JLabel("Seleccione la foto que desee remplazar");
		lblNewLabeltext.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabeltext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabeltext.setBounds(10, 75, 414, 20);
		contentPane.add(lblNewLabeltext);
		lblNewLabeltext.setVisible(false);
		
		FC.getSubject(choiceSubjects.getSelectedItem()); //Nos posicionamos en la materia seleccionada
		
		byte[] img0 = FC.getSubject(choiceSubjects.getSelectedItem()).getPicture(choiceMonth.getSelectedItem(), 0);
		byte[] img1 = FC.getSubject(choiceSubjects.getSelectedItem()).getPicture(choiceMonth.getSelectedItem(), 0);
		byte[] img2 = FC.getSubject(choiceSubjects.getSelectedItem()).getPicture(choiceMonth.getSelectedItem(), 0);
		byte[] img3 = FC.getSubject(choiceSubjects.getSelectedItem()).getPicture(choiceMonth.getSelectedItem(), 0);
		
		
		ImageIcon imagen1 = new ImageIcon(img0);
		ImageIcon imagen2 = new ImageIcon(img1);
		ImageIcon imagen3 = new ImageIcon(img2);
		ImageIcon imagen4 = new ImageIcon(img3);
		
		
		
		
		
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
	    			photoPath.add(fc.getSelectedFile().toString());
	    		}	
	    		
			}
		});
		btnImage1.setBounds(10, 115, 90, 90);
		btnImage1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(btnImage1.getWidth(), btnImage1.getHeight(), Image.SCALE_SMOOTH)));
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
    			photoPath.add(fc.getSelectedFile().toString());
	    		}
		}
		});
		btnImage2.setBounds(116, 115, 90, 90);
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
    			photoPath.add(fc.getSelectedFile().toString());
	    		}
				
			}
		});
		btnImage3.setBounds(222, 115, 90, 90);
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
    			photoPath.add(fc.getSelectedFile().toString());
	    		}
			}
		});
		btnImage4.setBounds(334, 115, 90, 90);
		btnImage4.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(btnImage4.getWidth(), btnImage4.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(btnImage4);
		btnImage4.setVisible(false);
		
						
		
		
		JButton btnUploadIMG = new JButton("Cargar Imagenes");
		btnUploadIMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (choiceMonth.getSelectedIndex()> 0 && choiceSubjects.getSelectedIndex() > 0)
				{
					lblNewLabeltext.setVisible(true);
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
		btnUploadIMG.setBounds(146, 41, 140, 23);
		contentPane.add(btnUploadIMG);
		
		
		
		
		
		JButton btnSaveChanges = new JButton("Guardar Cambios");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FC.addImages(choiceSubjects.getSelectedItem(), choiceMonth.getSelectedItem(), photoPath, "path");	
			}
		});
		btnSaveChanges.setBounds(284, 227, 140, 23);
		contentPane.add(btnSaveChanges);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(10, 227, 89, 23);
		contentPane.add(btnCancel);
	}

}