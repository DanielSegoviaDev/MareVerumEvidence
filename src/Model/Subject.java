package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.apache.commons.compress.utils.IOUtils;

public class Subject {
	
	private String name;
	private int position;
	private Vector<Integer> monthPositons;
	private Vector<String> months;
	private Vector<byte[]> pictures;
	private boolean flag = true;
	
	public Subject(String Name, int position, Vector<Integer> monthPosition, Vector<byte[]> pictures, String period) {
		
		this.months = new Vector<String>();
		
		this.name = Name;
		this.position = position;
		this.monthPositons = new Vector<Integer>();
		this.monthPositons.addAll(monthPosition);
		this.pictures = new Vector<byte[]>();
		this.pictures.addAll(pictures);
		
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
		
		String nullOption = new String(pictures.get(0));
		if(!nullOption.equals("null")) {
			flag = false; 
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
		if(flag)
			return pictures;
		else 
			return null;
	}

	public void setPictures(byte[] pictureData, int index) {
		pictures.set(index, pictureData);
	}
	
	
	public void addPictures(Vector<String> picturePath, String month) throws FileNotFoundException, IOException {
		
		
		
		// añadir el month para que se añada segun el mes las fotos
		int monthNumber = 0;
		for(int i = 0; i<=8; i++) { 
			if(month.equals(months.elementAt(i)))
				monthNumber = months.indexOf(months.elementAt(i));
		}
		
		int vectorPosition = 0;
		
		vectorPosition = monthNumber * 4;

		
		String nullController = new String(pictures.elementAt(vectorPosition));
		
		if(nullController.equals("null")) {
			
			byte[] pictureData0 = IOUtils.toByteArray(new FileInputStream(picturePath.elementAt(0)));
			byte[] pictureData1 = IOUtils.toByteArray(new FileInputStream(picturePath.elementAt(1)));
			byte[] pictureData2 = IOUtils.toByteArray(new FileInputStream(picturePath.elementAt(2)));
			byte[] pictureData3 = IOUtils.toByteArray(new FileInputStream(picturePath.elementAt(3)));
			
			pictures.add(vectorPosition, pictureData0);
			pictures.add(vectorPosition+1,pictureData1);
			pictures.add(vectorPosition+2, pictureData2);
			pictures.add(vectorPosition+3, pictureData3);
		}

	}

	public byte[] getPicture(int month, int imageNumber)
	{
		if (month == 0)
		{
			return pictures.elementAt(imageNumber);
		}
		else
		{
			month = 4 * month;
			return pictures.elementAt(month+imageNumber);
		}
	}
}