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
	
	public void eliminarAnimal(Animal animal) {
		listaAnimales.remove(animal);
	}

	public String listaNombreAnimales() {
		String lista = "";
		for (int i=0; i<listaAnimales.size(); i++) {
			lista+= listaAnimales.get(i).getNombre() + ", ";
		}
		return lista;
	}
	
	@Override
	public String toString() {
		return "[nombre=" + nombre + ", animales=(" + listaNombreAnimales() + ")]";
	}

}
