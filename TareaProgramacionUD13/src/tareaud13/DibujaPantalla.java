package tareaud13;

import java.util.Scanner;

public class DibujaPantalla {
	
	// VARIABLES STATIC

	static Scanner sc = new Scanner(System.in);
	static Pantalla p = new Pantalla();
	
	// MAIN

	public static void main(String[] args) {
		invocarSwitch();
	}
	
	// SWITCH OPCIONES

	public static void invocarSwitch() {

		// MENÚ OPCIONES

		System.out.println("-----Seleccione una opción (a-f):-----");
		System.out.println("a) Añadir una figura.");
		System.out.println("b) Modificar figuras.");
		System.out.println("c) Mostrar la pantalla.");
		System.out.println("d) Área de la pantalla.");
		System.out.println("e) Listar figuras.");
		System.out.println("f) Salir.");
		System.out.println("--------------------------------------");

		String letra = sc.nextLine();

		while (!letra.equals("a") && !letra.equals("b") && !letra.equals("c")
				&& !letra.equals("d") && !letra.equals("e") && !letra.equals("f")) {
			System.out.println("No le he entendido, escriba una letra entre la 'a' y la 'f'.");
			letra = sc.nextLine();
		}

		// CASOS SWITCH
		
		switch (letra) {

		// CASO a: AÑADIR FIGURA
		
		case "a":
			System.out.println("¿Rectángulo (r) o Triángulo (t)?");
			letra = sc.nextLine();
			while (!letra.equals("r") && !letra.equals("t")) {
				System.out.println("No le he entendido, escriba 'r' o 't'.");
				letra = sc.nextLine();
			}
			if (letra.equals("r")) {
				System.out.println("Introduzca la base:");
				int base = sc.nextInt();
				System.out.println("Introduzca la altura:");
				int altura = sc.nextInt();
				Rectangulo r = new Rectangulo(base, altura, '*');
				sc.nextLine();
				r.setCaracter(cambiarCaracter());
				p.anadeFigura(r);
				System.out.println("Figura creada con éxito.\n");
				invocarSwitch();
			}
			else {
				System.out.println("Introduzca el lado:");
				int lado = sc.nextInt();
				System.out.println("Introduzca el tipo (a-d):");
				sc.nextLine();
				String tipo = sc.nextLine();
				while (!tipo.equals("a") && !tipo.equals("b") && !tipo.equals("c") && !tipo.equals("d")) {
					System.out.println("No le he entendido, escriba una letra entre la 'a' y la 'd'.");
					letra = sc.nextLine();
				}
				Triangulo t = new Triangulo(lado, tipo, '*');
				t.setCaracter(cambiarCaracter());
				p.anadeFigura(t);
				System.out.println("Figura creada con éxito.\n");
				invocarSwitch();
			}
			break;

		// CASO b: MODIFICAR CARACTER DE TODAS LAS FIGURAS
			
		case "b":
			if (p.isEmpty()) {
				System.out.println("No hay ninguna figura a modificar.\n");
			}
			else {
				char nuevoCaracter = cambiarCaracter();
				p.modificarFigura(nuevoCaracter);
			}
			invocarSwitch();
			break;

		// CASO c: DIBUJAR FIGURAS
			
		case "c":
			p.muestraPantalla();
			invocarSwitch();
			break;

		// CASO d: CALCULAR ÁREA TOTAL
			
		case "d":
			p.areaPantalla();
			invocarSwitch();
			break;

		// CASO e: LISTAR FIGURAS
			
		case "e":
			if (p.isEmpty()) {
				System.out.println("No hay ninguna figura a listar.\n");
			}
			else {
				p.listaFiguras();
			}
			invocarSwitch();
			break;

		// CASO f: SALIR
			
		case "f":
			System.out.println("Hasta pronto.");
			break;
		}
	}

	// FUNCIÓN QUE DEVUELVE UN CARACTER
	
	public static char cambiarCaracter() {		
		System.out.println("Introduzca un caracter:");
		String entrada = sc.nextLine();

		while (entrada.length() > 1) {
			System.out.println("Por favor, introduzca un solo caracter:");
			entrada = sc.nextLine();
		}

		char ch = entrada.charAt(0);
		return ch;
	}

}
