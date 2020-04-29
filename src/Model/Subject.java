package Model;

import java.io.File;
import java.util.Vector;

public class Subject {
	
	private String nombre;
	private int posicion;
	private Vector<Integer> posicionMeses;
	private Vector<String> meses;
	private Vector<byte[]> fotos;
	
	public Subject(String nombre, int posicion, Vector<Integer> posicionMeses, Vector<byte[]> fotos, String periodo) {
		
		this.meses = new Vector<String>();
		
		this.nombre = nombre;
		this.posicion = posicion;
		this.posicionMeses = new Vector<Integer>();
		//this.fotos = fotos;
		
		
		if(periodo.equals("Marzo - Noviembre") || periodo.equals("Periodo"))
		{
			meses.add("Marzo");
			meses.add("Abril");
			meses.add("Mayo");
			meses.add("Junio");
			meses.add("Julio");
			meses.add("Agosto");
			meses.add("Septiembre");
			meses.add("Octubre");
			meses.add("Noviembre");
		} else {
			meses.add("Agosto");
			meses.add("Septiembre");
			meses.add("Octubre");
			meses.add("Noviembre");
			meses.add("Diciembre");
			meses.add("Enero");
			meses.add("Febrero");
			meses.add("Marzo");
			meses.add("Abril");
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPosicion() {
		return posicion;
	}


	public Vector<Integer> getPosicionMeses() {
		return posicionMeses;
	}


	public Vector<byte[]> getFotos() {
		return fotos;
	}

	public void setFotos(File fotos) {
		//this.fotos = fotos;
	}

}
