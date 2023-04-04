package tareaud13;

public class Triangulo implements Figura {
	
	// ATRIBUTOS
	
	private int lado;
	private String tipo;
	private char caracter;
	
	// CONSTRUCTOR
	
	public Triangulo(int lado, String tipo, char caracter) {
		this.lado = lado;
		this.tipo = tipo;
		this.caracter = caracter;
	}
	
	// MÉTODOS
	
	@Override
	public String nombre () {
		return "Triángulo de tipo '" + tipo + "' y lado " + lado + ".";
	}

	@Override
	public void dibujar() {
		if (tipo.equals("a")) {
			for (int i=0; i<lado; i++) {
				for (int j=0; j<(lado-i); j++) {
					System.out.print(caracter);
				}
				System.out.println();
			}
		}

		else if (tipo.equals("b")) {
			for (int i=0; i<lado; i++) {
				for (int k=0; k<i; k++) {
					System.out.print(" ");
				}
				for (int j=0; j<(lado-i); j++) {
					System.out.print(caracter);
				}
				System.out.println();
			}
		}
		
		else if (tipo.equals("c")) {
			for (int i=lado; i>0; i--) {
				for (int j=0; j<(lado-(i-1)); j++) {
					System.out.print(caracter);
				}
				System.out.println();
			}
		}
		
		else {
			for (int i=lado; i>0; i--) {
				for (int k=0; k<(i-1); k++) {
					System.out.print(" ");
				}
				for (int j=0; j<(lado-(i-1)); j++) {
					System.out.print(caracter);
				}
				System.out.println();
			}
		}
	}

	@Override
	public int area() {
		int area = (lado * lado)/2;
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