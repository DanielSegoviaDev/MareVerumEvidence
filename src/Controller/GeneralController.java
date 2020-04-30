package Controller;


import java.util.Vector;

import Model.Evidence;
import Model.Subject;

public class GeneralController {
	
	private Vector<Evidence> evidence;
	private Vector<Subject> subjects;
	
	public GeneralController() 
	
	{
		evidence = new Vector<Evidence>();
		subjects = new Vector<Subject>();
	}
	
	public void newEvidence(String period, Vector<String> Subject, String path ) 
	
	{
	
		
		
	}
	
	
	public void getSubjects(){
		FileController file = new FileController();
		
		
		subjects = file.exportSubjects(); 
	}
	
}
