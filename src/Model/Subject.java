package Model;

import java.util.Vector;

public class Subject {
	
	private String name;
	private int position;
	private Vector<Integer> monthPositons;
	private Vector<String> months;
	private Vector<byte[]> pictures;
	
	public Subject(String Name, int position, Vector<Integer> monthPosition, Vector<byte[]> pictures, String period) {
		
		this.months = new Vector<String>();
		
		this.name = Name;
		this.position = position;
		this.monthPositons = new Vector<Integer>();
		this.monthPositons = monthPosition;
		this.pictures = new Vector<byte[]>();
		this.pictures = pictures;
		
		if(period.equals("Marzo - Noviembre") || period.equals("Periodo"))
		{
			months.add("Marzo");
			months.add("Abril");
			months.add("Mayo");
			months.add("Junio");
			months.add("Julio");
			months.add("Agosto");
			months.add("Septiembre");
			months.add("Octubre");
			months.add("Noviembre");
		} else {
			months.add("Agosto");
			months.add("Septiembre");
			months.add("Octubre");
			months.add("Noviembre");
			months.add("Diciembre");
			months.add("Enero");
			months.add("Febrero");
			months.add("Marzo");
			months.add("Abril");
		}
		
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}


	public Vector<Integer> getMonthPositions() {
		return monthPositons;
	}


	public Vector<byte[]> getPictures() {
		return pictures;
	}

	public void setPictures(byte[] pictureData, int index) {
		pictures.set(index, pictureData);
	}

}
