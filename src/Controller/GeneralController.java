package Controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Model.Evidence;
import Model.Subject;

public class GeneralController {
	
	private Vector<Evidence> evidence;
	private Vector<Subject> subjects;
	private FileController fileController;
	private Vector<String> subjectVector;
	
	public GeneralController() 
	
	{
		evidence = new Vector<Evidence>();
		subjects = new Vector<Subject>();
		fileController = new FileController();
	}
	
	public void newEvidence(String period, String path ) 
	
	{
		Evidence instance = new Evidence(subjectVector, period, path);
		this.evidence.add(instance);
		
		fileController.newEvidence(instance);
		
	}
	
	public void readEvidence(String path) 
	
	{
		
		if(fileController.ReadEvidence(path)) {
			getSubjects();
		}
		
	}
	
	public void addImages(String subject, String month, Vector<String>photoPath, String path) throws FileNotFoundException, IOException 
	
	{
		if(existEvidence(path)) {
			int position = fileController.getMonthPosition(month, subject, path);
			Subject selectedSubject = getSubjectForPosition(position);
			
			selectedSubject.addPictures(photoPath, month);
		}
		
	}
	
	public void setPicture(byte[] pictureData, int index, String month, String subject, String path) 
	
	{
		
		if(existEvidence(path)) {
			int position = fileController.getMonthPosition(month, subject, path);
			Subject changerSubjectPicture = getSubjectForPosition(position);
			changerSubjectPicture.setPictures(pictureData, index);
			
			fileController.setImages(changerSubjectPicture, path);
			
		}
		
		else 
		{
			System.out.println("Evidence doesn´t exist, please, create one");
		}
		
	}
	
	
	public void getSubjects()
	{
		subjects = fileController.exportSubjects(); 
	}
	
	public boolean existEvidence(String path) {
		if(evidence.size() != 0) {
		
			for(int i = 0; i<= evidence.size()-1; i++) {
				if(evidence.get(i).getPath().equals(path))
					return true;
			}
		}
		return false;
	}
	
	
	
	private Subject getSubjectForPosition(int monthPosition) {
		Vector<Integer> positions = new Vector<Integer>();
		
		for(int i = 0; i<= subjects.size() -1; i++) {
			positions = subjects.elementAt(i).getMonthPositions();
			for(int j = 0; j<= positions.size()-1; j++) {
				if(monthPosition == positions.elementAt(j)) {
						Subject subject= subjects.elementAt(i);
						return subject;
				}
			}
		}
		
		return null;
	}
	
	
	public void getTextFromTP(String TP)	
	
	{
		subjectVector = new Vector<String>();
		
		String[] elements = TP.split(", ");
		
		for(int i = 0; i <= elements.length -1; i++) 
		{
			subjectVector.add(elements[i]);
		}
		
		
	}
	
	
	
}
