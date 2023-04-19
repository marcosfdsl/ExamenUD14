package examenUD14;

import java.util.ArrayList;
import java.util.TreeSet;

public class Habitat {
	
	private String nombre;
	private ArrayList<Animal> listaAnimales;
	
	public Habitat(String nombre, ArrayList<Animal> listaAnimales) {
		this.nombre = nombre;
		this.listaAnimales = listaAnimales;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Animal> getListaAnimales() {
		return listaAnimales;
	}
	
	public void ordenarAnimales() {
		TreeSet<Animal> animalesOrdenados = new TreeSet<Animal>();
		// TERMINAR
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + "]";
	}

}
