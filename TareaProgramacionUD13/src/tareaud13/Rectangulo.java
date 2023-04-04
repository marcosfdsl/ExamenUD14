package tareaud13;

public class Rectangulo implements Figura {
	
	// ATRIBUTOS
	
	private int base;
	private int altura;
	private char caracter;

	// CONSTRUCTOR
	
	public Rectangulo(int base, int altura, char caracter) {
		this.base = base;
		this.altura = altura;
		this.caracter = caracter;
	}
	
	// MÉTODOS
	
	@Override
	public String nombre () {
		return "Rectángulo de base " + base + " y altura " + altura + ".";
	}

	@Override
	public void dibujar() {
		for (int i=0; i<altura; i++) {
			for(int j=0; j<base; j++) {
				System.out.print(caracter);
			}
			System.out.println();
		}
	}

	@Override
	public int area() {
		int area = base * altura;
		return area;
	}

	@Override
	public void setCaracter(char ch) {
		caracter = ch;
	}

	@Override
	public char getCaracter() {
		return caracter;
	}
	
}