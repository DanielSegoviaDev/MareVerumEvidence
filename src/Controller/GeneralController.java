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
	
	// crea la caratula directamente en el documento, no hace falta guardarse el dato porque no se va a modificar, salvo que sea manualmente
	
	public void newHead(String student, String idNumber, byte[] picture, String subject, String year, String path) {
		
		fileController.newHead(student, idNumber, picture, subject, year, path);
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
	
	//cambiar funcion, para q las materias se agregen por a�os, no obteniendo los datos de una lista.
	
	public void updateSubjectsNamesVector(String TP)	
	
	{
		subjectsNames = new Vector<String>();
	
		
		if(TP.equals("Crianza 3") || TP.equals("Crianza 4")) 
		{
			
			subjectsNames.add("Arte, M�sica y Literatura");
			subjectsNames.add("Naturaleza");
			subjectsNames.add("Actividades Sensoriales");
			subjectsNames.add("Motricidad");
			subjectsNames.add("Educaci�n F�sica");
		}
		else if(TP.equals("Crianza 5"))
		{
			subjectsNames.add("Arte, M�sica y Literatura");
			subjectsNames.add("Naturaleza");
			subjectsNames.add("Actividades Sensoriales");
			subjectsNames.add("Motricidad");
			subjectsNames.add("Educaci�n F�sica");
			subjectsNames.add("Habilidades L�gico-Matem�ticas");
			subjectsNames.add("Habilidades Ling��sticas");
			
		}
		else if(TP.equals("Gram�tica 1") || TP.equals("Gram�tica 2") || TP.equals("Gram�tica 3"))
		{
			subjectsNames.add("Lenguaje");
			subjectsNames.add("Conocimiento del Entorno Social");
			subjectsNames.add("Conocimiento del Entorno Natural");
			subjectsNames.add("Matem�tica");
			subjectsNames.add("Apreciaci�n del Arte");
			subjectsNames.add("Bellas Artes");
			subjectsNames.add("Educaci�n F�sica");
		}
		
		else if(TP.equals("Gram�tica 4") || TP.equals("Gram�tica 5") || TP.equals("Gram�tica 6"))
		{
			subjectsNames.add("Lenguaje");
			subjectsNames.add("Conocimiento del Entorno Social");
			subjectsNames.add("Conocimiento del Entorno Natural");
			subjectsNames.add("Matem�tica");
			subjectsNames.add("Apreciaci�n del Arte");
			subjectsNames.add("Bellas Artes");
			subjectsNames.add("Educaci�n F�sica");
			subjectsNames.add("Idioma");
		}
		
		else if(TP.equals("L�gica 1") || TP.equals("L�gica 2") || TP.equals("L�gica 3"))
		{
			subjectsNames.add("Lenguaje");
			subjectsNames.add("Filosof�a");
			subjectsNames.add("L�gica");
			subjectsNames.add("Bellas artes");
			subjectsNames.add("Historia");
			subjectsNames.add("Geograf�a");
			subjectsNames.add("Ciencias");
			subjectsNames.add("Matem�tica");
			subjectsNames.add("Idioma extranjero");
			subjectsNames.add("Lat�n");
			subjectsNames.add("Educaci�n F�sica");
		}
		else if(TP.equals("Ret�rica 1") || TP.equals("Ret�rica 2") || TP.equals("Ret�rica 3")) 
		{
			subjectsNames.add("Lenguaje");
			subjectsNames.add("Filosof�a");
			subjectsNames.add("Ret�rica");
			subjectsNames.add("Bellas artes");
			subjectsNames.add("Historia");
			subjectsNames.add("Geograf�a");
			subjectsNames.add("Ciencias");
			subjectsNames.add("Matem�tica");
			subjectsNames.add("Idioma extranjero");
			subjectsNames.add("Lat�n");
			subjectsNames.add("Educaci�n F�sica");
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