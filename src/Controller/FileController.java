package Controller;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import Model.Evidence;
import Model.Subject;

public class FileController {
	
	private XMLSlideShow ppt;
	private Vector<byte[]> images; 
	private Vector<Subject> subjects;
	

	public FileController() {
		subjects = new Vector<Subject>();
	}
	
	public boolean newEvidence(Evidence evidence) {
		
		Vector<String>period = new Vector<String>();
		period = evidence.getPeriod();
		Vector<String> subjects = new Vector<String>();
		subjects = evidence.getSubjects();
		String path = evidence.getPath();
		
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

					textContent.setText(subjects.elementAt(i)).setFontSize(80.);
					
														//Horizontal, vertical, ancho, alto
					
					textContent.setAnchor(new Rectangle2D.Double(28.32* 3, 28.32* 9, 28.32 * 20, 28.32 * 3));
					slide.removeShape(slide.getPlaceholder(1));
					
					
						for(int j = 0; j<= 8; j++)
						{
						XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
						XSLFSlide contentSlide = ppt.createSlide(contentLayout);
						XSLFTextShape month = contentSlide.getPlaceholder(0);
						month.setText(period.elementAt(j));
						month.setAnchor(new Rectangle2D.Double( 28.32 * 0.94 , 28.32 * 0.42, 28.32 * 24, 28.32 * 2));
						contentSlide.removeShape(contentSlide.getPlaceholder(1));

						}
					
					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				//anexo de fotos
				
				XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
				XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
				XSLFSlide contentSlide = ppt.createSlide(contentLayout);
				XSLFTextShape anexo  = contentSlide.getPlaceholder(0);
				anexo.setText("ANEXO FOTOGRÁFICO");
				anexo.setAnchor(new Rectangle2D.Double( 28.32 * 0.94 , 28.32 * 0.42, 28.32 * 24, 28.32 * 2));
				contentSlide.removeShape(contentSlide.getPlaceholder(1));
				
				//tamaño de diapositiva 28 x 22
				ppt.setPageSize(new java.awt.Dimension(737, 623));
				
				FileOutputStream out = new FileOutputStream(file);
				ppt.write(out);
				out.close();
				ppt.close();
				return true;
				
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} else {
			
			if (JOptionPane.showConfirmDialog(null, "El archivo que esta tratando de crear ya existe, ¿desea sobreescribirlo?","",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
				try
				{
					
					//remove all slides
					
					File fileDeleted = new File(evidence.getPath());

					Files.deleteIfExists(fileDeleted.toPath());
					
					
					ppt = new XMLSlideShow();
					


			
					
					for(int i = 0 ; i <=subjects.size()-1 ; i++) {
						try {
							
							XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
							XSLFSlideLayout titleLayout = defaultMaster.getLayout(SlideLayout.TITLE);
							XSLFSlide slide = ppt.createSlide(titleLayout);

							
							XSLFTextShape textContent = slide.getPlaceholder(0);

							textContent.setText(subjects.elementAt(i)).setFontSize(80.);
							
																//Horizontal, vertical, ancho, alto
							
							textContent.setAnchor(new Rectangle2D.Double(28.32* 3, 28.32* 9, 28.32 * 20, 28.32 * 3));
							slide.removeShape(slide.getPlaceholder(1));
							
						
						
						for(int j = 0; j<= 8; j++) {
							XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
							XSLFSlide contentSlide = ppt.createSlide(contentLayout);
							XSLFTextShape month = contentSlide.getPlaceholder(0);
							month.setText(period.elementAt(j));
							month.setAnchor(new Rectangle2D.Double( 28.32 * 0.94 , 28.32 * 0.42, 28.32 * 24, 28.32 * 2));
							contentSlide.removeShape(contentSlide.getPlaceholder(1));

						}
						
						
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					//anexo de fotos
					
					XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
					XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
					XSLFSlide contentSlide = ppt.createSlide(contentLayout);
					XSLFTextShape anexo  = contentSlide.getPlaceholder(0);
					anexo.setText("ANEXO FOTOGRÁFICO");
					anexo.setAnchor(new Rectangle2D.Double( 28.32 * 0.94 , 28.32 * 0.42, 28.32 * 24, 28.32 * 2));
					contentSlide.removeShape(contentSlide.getPlaceholder(1));
					
					//tamaño de diapositiva 28 x 22
					
					ppt.setPageSize(new java.awt.Dimension(737, 623));
					
					FileOutputStream out = new FileOutputStream(file);
					ppt.write(out);
					out.close();
					
					ppt.close();
					
					return true;
					
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				return false;
			}
		}
		return false;
		
		
		
		
		
	}
	

	
	public void newHead(String student, String idNumber, byte[] picture, String subject, String year, String path) {
		
		File file = new File(path);
		
		try 
		{
			ppt = new XMLSlideShow(new FileInputStream(file));
		
			List<XSLFSlide> slides = ppt.getSlides();
			
			if(slides.get(0).getTitle() != null) {
				ppt.removeSlide(0);
				
				//nombre alumno
				XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
				XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
				XSLFSlide contentSlide = ppt.createSlide(contentLayout);
				XSLFTextShape anexo  = contentSlide.getPlaceholder(0);
				anexo.setText(student);					//Horizontal, vertical, ancho, alto
				anexo.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 0.41, 28.32 * 24, 28.32 * 2));
				contentSlide.removeShape(contentSlide.getPlaceholder(1));
				
				//Id del alumno
				XSLFTextBox idBox = contentSlide.createTextBox();
				XSLFTextParagraph idTextP = idBox.addNewTextParagraph();
				idTextP.setTextAlign(TextAlign.CENTER);
				idBox.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 2.52, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText = idTextP.addNewTextRun();
				idText.setText(idNumber);
				idText.setFontSize(40.0);
				
				//añadimos foto del alumno
				Rectangle2D picSize = new Rectangle2D.Double( 28.32 * 2.7 , 28.32 * 5.03, 28.32 * 20, 28.32 * 13);
				XSLFPictureData pd = ppt.addPicture(picture, PictureData.PictureType.JPEG);
				XSLFPictureShape pic = contentSlide.createPicture(pd);
				pic.setAnchor(picSize);
				
				//Materia
				XSLFTextBox idBox1 = contentSlide.createTextBox();
				XSLFTextParagraph idTextP1 = idBox1.addNewTextParagraph();
				idTextP1.setTextAlign(TextAlign.CENTER);
				idBox1.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 18.19, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText1 = idTextP1.addNewTextRun();
				idText1.setText(subject);
				idText1.setFontSize(40.0);
				
				//año cursado
				XSLFTextBox idBox2 = contentSlide.createTextBox();
				XSLFTextParagraph idTextP2 = idBox2.addNewTextParagraph();
				idTextP2.setTextAlign(TextAlign.CENTER);
				idBox2.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 19.88, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText2 = idTextP2.addNewTextRun();
				idText2.setText(year);
				idText2.setFontSize(30.0);
				
				ppt.setSlideOrder(contentSlide, 0);
			} 
			else 
			{	
				
				
				//nombre alumno
				XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
				XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
				XSLFSlide contentSlide = ppt.createSlide(contentLayout);
				XSLFTextShape anexo  = contentSlide.getPlaceholder(0);
				anexo.setText(student);					//Horizontal, vertical, ancho, alto
				anexo.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 0.41, 28.32 * 24, 28.32 * 2));
				contentSlide.removeShape(contentSlide.getPlaceholder(1));
				
				//Id del alumno
				XSLFTextBox idBox = contentSlide.createTextBox();
				XSLFTextParagraph idTextP = idBox.addNewTextParagraph();
				idTextP.setTextAlign(TextAlign.CENTER);
				idBox.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 2.52, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText = idTextP.addNewTextRun();
				idText.setText(idNumber);
				idText.setFontSize(40.0);
				
				//añadimos foto del alumno
				Rectangle2D picSize = new Rectangle2D.Double( 28.32 * 2.7 , 28.32 * 5.03, 28.32 * 20, 28.32 * 13);
				XSLFPictureData pd = ppt.addPicture(picture, PictureData.PictureType.JPEG);
				XSLFPictureShape pic = contentSlide.createPicture(pd);
				pic.setAnchor(picSize);
				
				//Materia
				XSLFTextBox idBox1 = contentSlide.createTextBox();
				XSLFTextParagraph idTextP1 = idBox1.addNewTextParagraph();
				idTextP1.setTextAlign(TextAlign.CENTER);
				idBox1.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 18.19, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText1 = idTextP1.addNewTextRun();
				idText1.setText(subject);
				idText1.setFontSize(40.0);
				
				//año cursado
				XSLFTextBox idBox2 = contentSlide.createTextBox();
				XSLFTextParagraph idTextP2 = idBox2.addNewTextParagraph();
				idTextP2.setTextAlign(TextAlign.CENTER);
				idBox2.setAnchor(new Rectangle2D.Double( 28.32 * 0.7 , 28.32 * 19.88, 28.32 * 24, 28.32 * 2));
				XSLFTextRun idText2 = idTextP2.addNewTextRun();
				idText2.setText(year);
				idText2.setFontSize(30.0);
			
				ppt.setSlideOrder(contentSlide, 0);
			}
			
			FileOutputStream out = new FileOutputStream(file);
			ppt.write(out);
			out.close();
			ppt.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public boolean ReadEvidence(String path) 
	{
		
		//variables from the function
		String subject ="";
		int position = -1;
		Vector<Integer> monthPosition = new Vector<Integer>();
		Vector<byte[]> pictures = new Vector<byte[]>();
		Vector<byte[]> subjectsPictures = new Vector<byte[]>();
		Vector<String> subjectNames = new Vector<String>();
		
		int counter = 1;

		
		String period = "";
		int count = 0; 
		
		
		File file = new File(path);
		
		if(!file.exists()) {
			return false;
		} else {
			try {
				
				
				ppt = new XMLSlideShow(new FileInputStream(file));
				List<XSLFSlide> slides = ppt.getSlides();
				
				readImages(path);
				pictures.addAll(images);
				System.out.println(images.isEmpty());
				System.out.println(images.size());
				subjectNames.removeAllElements();
				subjects.removeAllElements();
				
				int forSentenceIndex = detectAnnexed(slides);
				
				
				for(int i = 0; i<= forSentenceIndex; i++) {
					XSLFSlide slide = slides.get(i);
					
					if(slide.getTitle() == null) {
						

						
						XSLFTextShape titlePlaceHolder = slide.getPlaceholder(0);
						subject = titlePlaceHolder.getText();
						position = slide.getSlideNumber() - 1;
						subjectNames.add(subject);
						count+=1;
					} 
					
					else 
					
					{
						if(i == 0) {
							
							counter = 2;
							count++;
						}
						else
						
						{
	
						monthPosition.add(slide.getSlideNumber() - 1);
						readSlideImage(pictures, subjectsPictures, slide.getSlideNumber());
						//1
							if( i ==  counter ) 	
							{
								
								if(counter == 1)
									counter = 10;
								else
									counter =11; 
								
								if(slide.getTitle().equals("Marzo")) 
								{
								
									period = "Marzo - Noviembre";
						
								} 
								
								else 
								
								{
									period = " ";
								}

							}
						
							count+=1;
						
							//10
							if (count == counter) {
							
								Subject newSubject = new Subject(subject, position, monthPosition, subjectsPictures, period);
								
								subjects.add(newSubject);
								
								if (counter == 11) {
									count = 1;
								}
								else 
								{
									count = 0;
								}
								
								monthPosition.removeAllElements();
								subjectsPictures.removeAllElements();
							
							}
						}
					}
					
				}

				
				
				GeneralController GC = GeneralController.getController();
				GC.newInstanceOfEvidence(subjectNames, period, path);
				
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
			
			//borrar para que no se pisen
			String title = position.getTitle();
			ppt.removeSlide(index);
			
			//recrear la slide
			
			XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
			XSLFSlideLayout contentLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
			XSLFSlide contentSlide = ppt.createSlide(contentLayout);
			XSLFTextShape monthC = contentSlide.getPlaceholder(0);
			monthC.setText(title);						//Horizontal, vertical, ancho, alto
			monthC.setAnchor(new Rectangle2D.Double( 28.32 * 0.94 , 28.32 * 0.42, 28.32 * 24, 28.32 * 2));
			contentSlide.removeShape(contentSlide.getPlaceholder(1));
			
			//añadirla donde va 
			XSLFSlide slideChange = slides.get(slides.size() -1);
			ppt.setSlideOrder(slideChange, index);
			
			//retomarla
			XSLFSlide positionPick = slides.get(index);
			
			
			byte[] pictureData0 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(0)));
			byte[] pictureData1 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(1)));
			byte[] pictureData2 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(2)));
			byte[] pictureData3 = IOUtils.toByteArray(new FileInputStream(photoPath.elementAt(3)));
			
														//Horizontal, vertical, ancho, alto
			
			Rectangle2D rect = new Rectangle2D.Double( 28.32 * 0 , 28.32 * 3, 28.32 * 13, 28.32 * 9.5);
			Rectangle2D rect1 = new Rectangle2D.Double( 28.32 * 13 , 28.32 * 3, 28.32 * 13, 28.32 * 9.5);
			Rectangle2D rect2 = new Rectangle2D.Double( 28.32 * 0 , 28.32 * 12.5, 28.32 * 13, 28.32 * 9.5);
			Rectangle2D rect3 = new Rectangle2D.Double( 28.32 * 13 , 28.32 * 12.5, 28.32 * 13, 28.32 * 9.5);
			
			XSLFPictureData pd = ppt.addPicture(pictureData0, PictureData.PictureType.JPEG);
			XSLFPictureData pd1 = ppt.addPicture(pictureData1, PictureData.PictureType.JPEG);
			XSLFPictureData pd2 = ppt.addPicture(pictureData2, PictureData.PictureType.JPEG);
			XSLFPictureData pd3 = ppt.addPicture(pictureData3, PictureData.PictureType.JPEG);
			
			XSLFPictureShape pic = positionPick.createPicture(pd);
			XSLFPictureShape pic1 = positionPick.createPicture(pd1);
			XSLFPictureShape pic2 = positionPick.createPicture(pd2);
			XSLFPictureShape pic3 = positionPick.createPicture(pd3);
			
			pic.setAnchor(rect);
			pic1.setAnchor(rect1);
			pic2.setAnchor(rect2);
			pic3.setAnchor(rect3);
			
			
			FileOutputStream out = new FileOutputStream(file);
			ppt.write(out);
			out.close();
			ppt.close();
			
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
	
	
	
	public Vector<String> getNameSubjects(String path){
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
	
	private int detectAnnexed(List<XSLFSlide> slides)
	{
		for(int i = 0; i < slides.size(); i++)
		{
			XSLFSlide slide = slides.get(i);
			if(slide.getTitle() != null && slide.getTitle().equals("ANEXO FOTOGRÁFICO")) {
				return i;
			}
		}
		
		return slides.size()-1;
	}
	
	private void readSlideImage(Vector<byte[]> images, Vector<byte[]> subjectImages, int slideNumber) {
		
		int limit = slideNumber % 10;
		
		int maxImages = images.size();
		
		
		if(limit == 0) {
			
			if(maxImages >= 35) {
				for(int i = 0; i <= 35; i++) {
					subjectImages.add(images.elementAt(i));
				}
			}else {
				for(int i = 0; i <= 35; i++) {
					if(i >= maxImages) {
						subjectImages.add("null".getBytes());
					}else {
						subjectImages.add(images.elementAt(i));
					}
				}
			}
		}else if(limit == 1) { 
			if(maxImages>=72) {
				for(int i = 36; i<=72; i++) {
					subjectImages.add(images.elementAt(i));
				}
			} else {
				for(int i = 36; i<=72; i++) {
					if(i >= maxImages) {
						subjectImages.add("null".getBytes());
					} else {
						subjectImages.add(images.elementAt(i));
					}
				}
			}
			
		
		} else {
			if(limit % 2 == 0) {
				
				int index = (36 * limit ) + 1;
				if(maxImages>= index+36) {
					for(int i = index; i<= index + 36; i++ ) {
						subjectImages.add(images.elementAt(i));
					}
				} else {
					
					for(int i = index; i<= index + 36; i++ ) { 
						if(i >= maxImages) {
							subjectImages.add("null".getBytes());
						} else {
							subjectImages.add(images.elementAt(i));
						}
					}	
				}
				
			}else {
				
				int index = (36 * limit ) + (limit - 1);
				
				if(maxImages>= index+36) {
					for(int i = index; i<= index + 36; i++ ) {
						subjectImages.add(images.elementAt(i));
					}
				} else {
					
					for(int i = index; i<= index + 36; i++ ) { 
						if(i >= maxImages) {
							subjectImages.add("null".getBytes());
						} else {
							subjectImages.add(images.elementAt(i));
						}
					}	
				}
				
			}
		}
		
	
	
	
	}
	
	
}	