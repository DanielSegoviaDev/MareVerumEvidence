package Model;

import java.util.Vector;

public class Evidence {
	
	private Vector<String> subjects;
	private Vector<String> period;
	private String path;
	
	public Evidence (Vector<String> subjects, String period, String path) {
		this.subjects = new Vector<String>();
		this.subjects = subjects;
		
		if(period.equals("Marzo - Noviembre") || period.equals("Periodo"))
		{
			this.period.add("Marzo");
			this.period.add("Abril");
			this.period.add("Mayo");
			this.period.add("Junio");
			this.period.add("Julio");
			this.period.add("Agosto");
			this.period.add("Septiembre");
			this.period.add("Octubre");
			this.period.add("Noviembre");
		} else {
			this.period.add("Agosto");
			this.period.add("Septiembre");
			this.period.add("Octubre");
			this.period.add("Noviembre");
			this.period.add("Diciembre");
			this.period.add("Enero");
			this.period.add("Febrero");
			this.period.add("Marzo");
			this.period.add("Abril");
		}
		
		this.path = path;
		
	}

	public Vector<String> getSubjects() {
		return subjects;
	}
	
	public void addSubjects(String subject) {
		subjects.add(subject);
		
	}

	public Vector<String> getPeriod() {
		return period;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String newPath) {
		path = newPath;
	}
	
	

}
