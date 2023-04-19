package examenUD14;

import java.util.Scanner;

public class ZooMain {

	static Scanner sc = new Scanner(System.in);
	static Zoo zoo = new Zoo();
	
	public static void main(String[] args) {
		
		System.out.println("--------------------------------MENÚ--------------------------------");
		System.out.println("1. Agregar y eliminar animales del zoológico.");
		System.out.println("2. Agregar y eliminar hábitats del zoológico.");
		System.out.println("3. Agregar y eliminar cuidadores del zoológico.");
		System.out.println("4. Asignar animales a hábitats específicos.");
		System.out.println("5. Asignar cuidadores a animales específicos.");
		System.out.println("6. Mostrar información detallada de cada animal, hábitat y cuidador.");
		System.out.println("7. Mostrar los animales del zoo ordenados por edad.");
		System.out.println("8. Salir.");
		System.out.println("--------------------------------------------------------------------");
		
		pedirNumero();

	}
	
	public static void pedirNumero() {
		String numString = sc.nextLine();
		int contador = 0;
		for (int i=0; i<numString.length(); i++) {
			if (!Character.isDigit(numString.charAt(i))) {
				contador+=1;
			}
		}
		if (contador>0) {
			System.err.println("Debes escribir un número entre el 1 y el 8.");
			pedirNumero();
		}
		else {
			int num = Integer.parseInt(numString);
			if (num<1||num>8) {
				System.err.println("Debes escribir un número entre el 1 y el 8.");
				pedirNumero();	
			}
			else {
				switchMenu(num);
			}
		}
	}
	
	public static void switchMenu(int num) {
		
		
		
		zoo.getListaHabitats();
		zoo.getListaCuidadores();
		
		switch (num) {
		
		case 1:
			caso1(zoo);
			main(null);
			break;
			
		case 2:
			System.out.println("Para agregar habitats escriba 0, para eliminar escriba 1:");
			String AgregarOEliminar = sc.nextLine();
			
			while (!AgregarOEliminar.equals("0")&&!AgregarOEliminar.equals("1")) {
				System.err.println("Introduzca una opción válida:");
				AgregarOEliminar = sc.nextLine();
			}

			if (AgregarOEliminar.equals("0")) {
				zoo.agregarHabitat();
			}
			else {
				zoo.eliminarHabitat();
			}
			main(null);
			break;
			
		case 3:
			System.out.println("Para agregar cuidadores escriba 0, para eliminar escriba 1:");
			String AgregarOEliminar2 = sc.nextLine();
			
			while (!AgregarOEliminar2.equals("0")&&!AgregarOEliminar2.equals("1")) {
				System.err.println("Introduzca una opción válida:");
				AgregarOEliminar2 = sc.nextLine();
			}

			if (AgregarOEliminar2.equals("0")) {
				zoo.agregarCuidador();
			}
			else {
				zoo.eliminarCuidador();
			}
			main(null);
			break;
			
		case 4:
			
			if (zoo.getListaHabitats().isEmpty()) {
				System.out.println("Aún no se ha creado ningún habitat.\n");
			}
			else {
				System.out.println("¿Qué animal deseas asignar a un nuevo habitat?");
				String animal = sc.nextLine();
				
				int contador = 0;
				
				for (int i=0; i<zoo.getListaTotalAnimales().size(); i++) {
					if (animal.equalsIgnoreCase(zoo.getListaTotalAnimales().get(i).getNombre())) {
						contador++;
						System.out.println("bien");
					}
				}
				
				if (contador==0) {
					System.err.println("No existe el animal introducido.\n");
				}
			}
			main(null);
			break;
			
		case 5:
			main(null);
			break;
			
		case 6:
			main(null);
			break;
			
		case 7:
			zoo.imprimirAnimales();
			System.out.println();
			main(null);
			break;
			
		case 8:
			System.out.println("¡Hasta pronto!");
			break;
		}
	}

	public static void caso1(Zoo zoo) {
	
		System.out.println("Para agregar animales escriba 0, para eliminar escriba 1:");
		String AgregarOEliminar = sc.nextLine();
		
		while (!AgregarOEliminar.equals("0")&&!AgregarOEliminar.equals("1")) {
			System.err.println("Introduzca una opción válida:");
			AgregarOEliminar = sc.nextLine();
		}

		if (AgregarOEliminar.equals("0")) {
			if (zoo.getListaHabitats().isEmpty()) {
				System.out.println("Para agregar un animal primero debe crear un habitat al que añadirlo.\n");
			}
			else {
				System.out.println("¿A qué habitat deseas añadir el animal?");
				String habitat = sc.nextLine();
				
				int contador = 0;
				
				for (int i=0; i<zoo.getListaHabitats().size(); i++) {
					if (habitat.equalsIgnoreCase(zoo.getListaHabitats().get(i).getNombre())) {
						contador++;
						zoo.agregarAnimalesEnHabitat(zoo.getListaHabitats().get(i));
					}
				}
				
				if (contador==0) {
					System.err.println("No existe el habitat introducido.\n");
				}
			}
		}
		
		else {
			if (zoo.getListaHabitats().isEmpty()) {
				System.out.println("Aún no se ha creado ningún animal.\n");
			}
			else {
				System.out.println("Escriba el nombre del hábitat del cuál quiere eliminar al animal.");
				String habitat = sc.nextLine();
				
				int contador = 0;
				
				for (int i=0; i<zoo.getListaHabitats().size(); i++) {
					if (habitat.equalsIgnoreCase(zoo.getListaHabitats().get(i).getNombre())) {
						contador++;
						zoo.eliminarAnimalesEnHabitat(zoo.getListaHabitats().get(i));
					}
				}
				
				if (contador==0) {
					System.err.println("No existe el habitat introducido.\n");
				}
			}
		}	
		
	}
}
