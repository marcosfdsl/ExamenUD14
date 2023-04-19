package examenUD14;

public class Reptil extends Animal {

	private String colorEscamas;

	public Reptil(String nombre, String genero, String especie, int edad, EmpleadoZoo cuidador, String colorEscamas) {
		super(nombre, genero, especie, edad, cuidador);
		this.colorEscamas = colorEscamas;
	}
	
	public Reptil(String nombre, String genero, String especie, int edad, Habitat habitat, EmpleadoZoo cuidador, String colorEscamas) {
		super(nombre, genero, especie, edad, habitat, cuidador);
		this.colorEscamas = colorEscamas;
	}
	
}
