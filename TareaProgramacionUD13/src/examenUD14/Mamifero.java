package examenUD14;

public class Mamifero extends Animal {

	private String desplazamiento;

	public Mamifero(String nombre, String genero, String especie, int edad, EmpleadoZoo cuidador,
			String desplazamiento) {
		super(nombre, genero, especie, edad, cuidador);
		this.desplazamiento = desplazamiento;
	}

	public Mamifero(String nombre, String genero, String especie, int edad, Habitat habitat, EmpleadoZoo cuidador,
			String desplazamiento) {
		super(nombre, genero, especie, edad, habitat, cuidador);
		this.desplazamiento = desplazamiento;
	}

}