package examenUD14;

public class Animal {

	private String nombre;
	private String genero;
	private String especie;
	private int edad;
	private Habitat habitat;
	private EmpleadoZoo cuidador;

	public Animal(String nombre, String genero, String especie, int edad, EmpleadoZoo cuidador) {
		this.nombre = nombre;
		this.genero = genero;
		this.especie = especie;
		this.edad = edad;
		this.cuidador = cuidador;
	}

	public Animal(String nombre, String genero, String especie, int edad, Habitat habitat, EmpleadoZoo cuidador) {
		this.nombre = nombre;
		this.genero = genero;
		this.especie = especie;
		this.edad = edad;
		this.habitat = habitat;
		this.cuidador = cuidador;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	public void setCuidador(EmpleadoZoo cuidador) {
		this.cuidador = cuidador;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", genero=" + genero + ", especie=" + especie + ", edad=" + edad + ", habitat="
				+ habitat.getNombre() + ", cuidador=" + cuidador.getNumEmpleado() + "]";
	}

}
