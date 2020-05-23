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
	private Vector<String> subjectsNames;
	
	private static GeneralController GC;
	
	
	private GeneralController() 
	
	{
		evidence = new Vector<Evidence>();
		subjects = new Vector<Subject>();
		fileController = new FileController();
		subjectsNames = new Vector<String>();
	}
	
	private void getSubjects()
	{

		subjects = fileController.exportSubjects(); 
		System.out.println(subjects.size());

		subjectsNames.removeAllElements();
		
		
		for(int i = 0; i <= subjects.size()-1; i++)
		{
			subjectsNames.add(subjects.elementAt(i).getName());
		}
	}
	
	private Subject getSubjectForPosition(int monthPosition) {
		Vector<Integer> positions = new Vector<Integer>();
		
		for(int i = 0; i<= subjects.size() -1; i++) {
			positions.addAll(subjects.elementAt(i).getMonthPositions()); 
			for(int j = 0; j<= positions.size()-1; j++) {
				if(monthPosition == positions.elementAt(j)) {
						Subject subject= subjects.elementAt(i);
						return subject;
				}
			}
		}
		
		return null;
	}
	
	
	public static GeneralController getController() {
		if(GC == null)  
		{
			GC = new GeneralController();
			
		}
		
		return GC;
		
	}
	
	
	public boolean newEvidence(String period, String path) 
	
	{
		Evidence instance = new Evidence(subjectsNames, period, path);
		this.evidence.add(instance);
		
		return fileController.newEvidence(instance);
		
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
			
			fileController.addImages(subject, month, photoPath, path);
		}
		
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
	
	
	public void getTextFromTP(String TP)	
	
	{
		subjectsNames = new Vector<String>();
		
		String[] elements = TP.split(",");
		
		for(int i = 0; i <= elements.length -1; i++) 
		{
			elements[i]= elements[i].trim();
		}
		
		
		
		for(int i = 0; i <= elements.length -1; i++) 
		{
			subjectsNames.add(elements[i]);
		}
		
		
	}
	
	public Vector<String> getSubjectVector()
	{
		return subjectsNames;
	}
	
	public boolean acceptExtension (File dir) {
        return dir.getName().endsWith(".ppt");
    }
	
	
	public void newInstanceOfEvidence(Vector<String> subjects, String period, String path) 
	
	{
		Evidence instance = new Evidence(subjects, period, path);
		this.evidence.add(instance);
	}
	
	public Vector<Evidence> getEvidences(){
		return evidence;
	}
	
	public int compareEvidencePath(String path) {
		
		for(int i = 0; i <= evidence.size()-1; i++)
		{
			if(evidence.elementAt(i).getPath().equals(path))
				return i;
		}
		
		return -1;
	}
	
	public boolean generateFolders(String path)
	{
		File file = new File(path+ "\\" + "Materias");
		
		file.mkdir();
		
		for(int i = 0; i <= subjectsNames.size() -1; i++)
		{
			File mkdir = new File(path + "\\" + "Materias" + "\\" + subjectsNames.elementAt(i));
			mkdir.mkdir();
		}
		
		return true;
	}
	
	
}