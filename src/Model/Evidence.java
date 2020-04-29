package Model;

import java.util.Vector;

public class Evidence {
	
	private Vector<Subject> subjects;
	private String periodo;
	
	public Evidence (Vector<Subject> subjects, String periodo) {
		this.subjects = new Vector<Subject>();
		this.subjects = subjects;
		this.periodo = periodo;
		
	}

	public Vector<Subject> getSubjects() {
		return subjects;
	}
	
	public void addSubjects(Subject subject) {
		subjects.add(subject);
		
	}

	public String getPeriodo() {
		return periodo;
	}
	
	

}
