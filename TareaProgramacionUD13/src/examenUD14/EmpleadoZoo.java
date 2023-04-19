package examenUD14;

public class EmpleadoZoo {

	private int numEmpleado;
	public String nombre;
	public String apellido;
	public int salario;

	public EmpleadoZoo(int numEmpleado, String nombre, String apellido, int salario) {
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
	}

	public void Alimentar(int cantidadEnGramos) {

	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	@Override
	public String toString() {
		return "[numEmpleado=" + numEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ "]";
	}

}
