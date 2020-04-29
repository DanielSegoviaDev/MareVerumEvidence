package Controller;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import Model.Subject;

public class FileController {
	
	private XMLSlideShow ppt;
	private Vector<byte[]> images; 
	private Vector<Subject> subjects;
	

	public FileController() {
		subjects = new Vector<Subject>();
	}
	
	public void newEvidence(Vector<String>period, Vector<String> subjects, String path) {
		
		File file = new File(path);
	
		
		
		if(!file.exists())
		
		{
			try
			{
				ppt = new XMLSlideShow();
				
				
				for(int i = 0 ; i <=subjects.size()-1 ; i++) {
					try {
						
					
					XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
					XSLFSlideLayout titleLayout = defaultMaster.getLayout(SlideLayout.TITLE);
					XSLFSlide slide = ppt.createSlide(titleLayout);
					XSLFTextShape textContent = slide.getPlaceholder(0);
					textContent.setText(subjects.elementAt(i));
					textContent.setAnchor(new Rectangle2D.Double(28.32*3, 28.32*9, 28.32 * 20, 28.32*3));
					slide.removeShape(slide.getPlaceholder(1));
					
					
					for(int j = 0; j<= 8; j++) {
						XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
						XSLFSlide contentSlide = ppt.createSlide(contentLayout);
						XSLFTextShape month = contentSlide.getPlaceholder(0);
						month.setText(period.elementAt(j));
						month.setAnchor(new Rectangle2D.Double( 28.32 * 1 , 28.32 * 0, 28.32 * 24, 28.32 * 2));
						contentSlide.removeShape(contentSlide.getPlaceholder(1));
					}
					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				FileOutputStream out = new FileOutputStream(file);
				ppt.write(out);
				out.close();
				
				
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} else {
			int input = JOptionPane.showConfirmDialog(null, "El archivo que esta tratando de crear ya existe, desea sobreescribirlo");
			if (input == 0) {
				try
				{
					ppt = new XMLSlideShow();
					
					
					for(int i = 0 ; i <=subjects.size()-1 ; i++) {
						try {
							
						
						XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
						XSLFSlideLayout titleLayout = defaultMaster.getLayout(SlideLayout.TITLE);
						XSLFSlide slide = ppt.createSlide(titleLayout);
						XSLFTextShape textContent = slide.getPlaceholder(0);
						textContent.setText(subjects.elementAt(i));
						textContent.setAnchor(new Rectangle2D.Double(28.32*3, 28.32*9, 28.32 * 20, 28.32*3));
						slide.removeShape(slide.getPlaceholder(1));
						
						
						for(int j = 0; j<= 8; j++) {
							XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
							XSLFSlide contentSlide = ppt.createSlide(contentLayout);
							XSLFTextShape month = contentSlide.getPlaceholder(0);
							month.setText(period.elementAt(j));
							month.setAnchor(new Rectangle2D.Double( 28.32 * 1 , 28.32 * 0, 28.32 * 24, 28.32 * 2));
							contentSlide.removeShape(contentSlide.getPlaceholder(1));
						}
						
						
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					FileOutputStream out = new FileOutputStream(file);
					ppt.write(out);
					out.close();
					
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un nombre diferente al archivo para continuar");
			}
		}
		
		
		
		
		
	}
	
	public boolean ReadEvidence(String path) 
	{
		String subject ="", month;
		int position = -1;
		Vector<Integer> monthPosition = new Vector<Integer>();
		Vector<byte[]> pictures = new Vector<byte[]>();
		String period;
		int count = 0; 
		
		
		File file = new File(path);
		
		if(!file.exists()) {
			return false;
		} else {
			try {
				ppt = new XMLSlideShow(new FileInputStream(file));
				List<XSLFSlide> slides = ppt.getSlides();
				
				for(int i = 0; i<= slides.size()-1; i++) {
					XSLFSlide slide = slides.get(i);
					
					if(slide.getTitle() == null) {
						XSLFTextShape titlePlaceHolder = slide.getPlaceholder(0);
						subject = titlePlaceHolder.getText();
						position = slide.getSlideNumber() - 1;
						count+=1;
					} else {
						month = slide.getTitle();
						monthPosition.add(slide.getSlideNumber());
						if( i ==  1 && month.equals("Marzo")) 
							period = "Marzo - Noviembre";
						
						else 
							period = " ";
						count+=1;
						if (count == 10) {
							Subject newSubject = new Subject(subject, position, monthPosition, pictures, period);
							count = 0;
							subjects.add(newSubject);
						}
					 }
						
				}
				ppt.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		return true;
		}
	}
	
	public int getSubjectPosition(String subject, String path) {
		int position = -1;
		
		File file = new File(path);
		if(!file.exists()) {
			return -1;
		}else {
			try {
				ppt = new XMLSlideShow(new FileInputStream(file));
				List<XSLFSlide> slides = ppt.getSlides();
				for(int i = 0; i<= slides.size() -1; i++) {
					XSLFSlide select = slides.get(i);
					XSLFTextShape textPlaceholder = select.getPlaceholder(0);
					String text = textPlaceholder.getText();
					
					if(subject.equals(text)) 
						position = select.getSlideNumber() -1;	
				}
				
				ppt.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return position;
	}
	
	public int getMonthPosition(String month, String subject, String path) {
		int subjectPosition = getSubjectPosition(subject, path);
		int monthPosition = -1;
		
		File file = new File(path);
		
		if(!file.exists()) {
			return -1;
		}else {
			try {
				ppt = new XMLSlideShow(new FileInputStream(file));
				List<XSLFSlide> slides = ppt.getSlides();
			
				
			for(int i = 1; i<=9; i++) {
				XSLFSlide slide = slides.get(subjectPosition + i);
				XSLFTextShape monthPlaceholder = slide.getPlaceholder(0);
				
				if(month.equals(monthPlaceholder.getText())) 
					monthPosition = slide.getSlideNumber() - 1;	
				}
			
			
			
			ppt.close();
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return monthPosition;
	}
		
	
	public void addImages(String subject, String month, Vector<String>photoPath, String path) {
		
		File file = new File((path));
		int index = getMonthPosition(month, subject, path);
		
		try {
			ppt = new XMLSlideShow(new FileInputStream(file));
			
			
			
			List<XSLFSlide> slides = ppt.getSlides();
			XSLFSlide position = slides.get(index);
			
			
			byte[] pictureData0 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(0)));
			byte[] pictureData1 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(1)));
			byte[] pictureData2 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(2)));
			byte[] pictureData3 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(3)));
			
			Rectangle2D rect = new Rectangle2D.Double( 28.32 * 0 , 28.32 * 3, 28.32 * 12, 28.32 * 9);
			Rectangle2D rect1 = new Rectangle2D.Double( 28.32 * 14 , 28.32 * 3, 28.32 * 12, 28.32 * 9);
			Rectangle2D rect2 = new Rectangle2D.Double( 28.32 * 0 , 28.32 * 13, 28.32 * 12, 28.32 * 9);
			Rectangle2D rect3 = new Rectangle2D.Double( 28.32 * 14 , 28.32 * 13, 28.32 * 12, 28.32 * 9);
			
			XSLFPictureData pd = ppt.addPicture(pictureData0, PictureData.PictureType.JPEG);
			XSLFPictureData pd1 = ppt.addPicture(pictureData1, PictureData.PictureType.JPEG);
			XSLFPictureData pd2 = ppt.addPicture(pictureData2, PictureData.PictureType.JPEG);
			XSLFPictureData pd3 = ppt.addPicture(pictureData3, PictureData.PictureType.JPEG);
			
			XSLFPictureShape pic = position.createPicture(pd);
			XSLFPictureShape pic1 = position.createPicture(pd1);
			XSLFPictureShape pic2 = position.createPicture(pd2);
			XSLFPictureShape pic3 = position.createPicture(pd3);
			
			pic.setAnchor(rect);
			pic1.setAnchor(rect1);
			pic2.setAnchor(rect2);
			pic3.setAnchor(rect3);
			
			
			FileOutputStream out = new FileOutputStream(file);
			ppt.write(out);
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Vector<byte[]> readImages(String path) {
		images = new Vector<byte[]>();
		
		try {
			 ppt = new XMLSlideShow(new FileInputStream(path));
			
			
			 for(XSLFPictureData data : ppt.getPictureData()) {					
					 images.add(data.getData());
				}
			 
			 
				
				ppt.close();
				
		} catch(Exception e) {
					e.printStackTrace();
		}
			
		return images;
		
	}
	
	public Vector<String> getSubjects(String path){
		Vector<String> subjects = new Vector<String>();
			File file = new File(path);
			try {
			ppt = new XMLSlideShow(new FileInputStream(file));
				List<XSLFSlide> slides = ppt.getSlides();
				
				for(int i = 0; i <= slides.size()-1; i++) {
					XSLFSlide selectSlide = slides.get(i);
					if(selectSlide.getTitle() == null) {
						XSLFTextShape text = selectSlide.getPlaceholder(0);
						subjects.add(text.getText());
					}
				}
				
				ppt.close();
			
			} catch (Exception e){
				e.printStackTrace();
			}
		
		return subjects;
	}
		
	public Vector<Subject> exportSubjects(){
		return subjects;
	}
}	
