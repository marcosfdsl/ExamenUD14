package examenUD14;

public class Ave extends Animal {

	private double longitudPico;
	private boolean rapaz;
	
	public Ave(String nombre, String genero, String especie, int edad, EmpleadoZoo cuidador, int longitudPico,
			boolean rapaz) {
		super(nombre, genero, especie, edad, cuidador);
		this.longitudPico = longitudPico;
		this.rapaz = rapaz;
	}
	
	public Ave(String nombre, String genero, String especie, int edad, Habitat habitat, EmpleadoZoo cuidador, int longitudPico,
			boolean rapaz) {
		super(nombre, genero, especie, edad, habitat, cuidador);
		this.longitudPico = longitudPico;
		this.rapaz = rapaz;
	}

}
