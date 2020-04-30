package Controller;


import java.util.Vector;

import Model.Evidence;
import Model.Subject;

public class GeneralController {
	
	private Vector<Evidence> evidence;
	private Vector<Subject> subjects;
	private FileController file;
	
	public GeneralController() 
	
	{
		evidence = new Vector<Evidence>();
		subjects = new Vector<Subject>();
		file = new FileController();
	}
	
	public void newEvidence(String period, Vector<String> Subject, String path ) 
	
	{
		Evidence instance = new Evidence(Subject, period, path);
		this.evidence.add(instance);
		
		file.newEvidence(instance);
		
	}
	
	public void readEvidence(String path) {
		
		if(file.ReadEvidence(path)) {
			getSubjects();
		}
		
	}
	
	public void setPicture(byte[] pictureData, int index, String month, String subject, String path) {
		if(existEvidence(path)) {
			int position = file.getMonthPosition(month, subject, path);
			Subject changerSubjectPicture = getSubjectForPosition(position);
			changerSubjectPicture.setPictures(pictureData, index);
		}else {
			System.out.println("Evidence dosen´t exist, please, create one");
		}
		
	}
	
	
	public void getSubjects(){
		subjects = file.exportSubjects(); 
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
	
	public Subject getSubjectForPosition(int monthPosition) {
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
	
}
