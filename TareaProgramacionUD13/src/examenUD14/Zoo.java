package examenUD14;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {

	static Scanner sc = new Scanner(System.in);

	private ArrayList<Habitat> listaHabitats;
	private ArrayList<EmpleadoZoo> listaCuidadores;
	private ArrayList<Animal> listaTotalAnimales;

	public Zoo() {
		listaHabitats = new ArrayList<Habitat>();
		listaCuidadores = new ArrayList<EmpleadoZoo>();
		listaTotalAnimales = new ArrayList<Animal>();
	}

	public ArrayList<Habitat> getListaHabitats() {
		return listaHabitats;
	}

	public ArrayList<EmpleadoZoo> getListaCuidadores() {
		return listaCuidadores;
	}
	
	public ArrayList<Animal> getListaTotalAnimales() {
		return listaTotalAnimales;
	}
	
	public void imprimirAnimales() {
		for (int i=0; i<listaTotalAnimales.size(); i++) {
			System.out.println(listaTotalAnimales.get(i).toString());
		}
	}
	
	public void imprimirTodo() {
		System.out.println("Animales:");
		for (int i=0; i<listaTotalAnimales.size(); i++) {
			System.out.println(listaTotalAnimales.get(i).toString());
		}
		System.out.println("Habitats:");
		for (int i=0; i<listaHabitats.size(); i++) {
			System.out.println(listaHabitats.get(i).toString());
		}
		System.out.println("Cuidadores:");
		for (int i=0; i<listaCuidadores.size(); i++) {
			System.out.println(listaCuidadores.get(i).toString());
		}
	}

	public void agregarHabitat() {
		// PEDIMOS NOMBRE HABITAT
		System.out.println("Introduce el nombre del nuevo hábitat:");
		String nombreNuevoHabitat = sc.nextLine();

		for (int i = 0; i < listaHabitats.size(); i++) {
			while (listaHabitats.get(i).getNombre().equalsIgnoreCase(nombreNuevoHabitat)) {
				System.out.println("Ya existe el habitat " + nombreNuevoHabitat + ", introduce otro:");
				nombreNuevoHabitat = sc.nextLine();
			}
		}

		// CREAMOS LISTA DE ANIMALES VACÍA
		ArrayList<Animal> listaAnimalesNuevoHabitat = new ArrayList<Animal>();
		// CREAMOS NUEVO HABITAT
		Habitat nuevoHabitat = new Habitat(nombreNuevoHabitat, listaAnimalesNuevoHabitat);
		listaHabitats.add(nuevoHabitat);
		System.out.println("El habitat " + nombreNuevoHabitat + " ha sido creado.\n");
				
		System.out.println("¿Deseas añadir animales? (SI/NO)");
		String respuesta = sc.nextLine();

		while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
			System.out.println("No te he entendido, ¿deseas añadir un animal? (SI/NO)");
			respuesta = sc.nextLine();
		}

		if (respuesta.equalsIgnoreCase("SI")) {
			// LLAMAMOS A AGREGAR ANIMALES EN HABITAT
			agregarAnimalesEnHabitat(nuevoHabitat);
		} else if (respuesta.equalsIgnoreCase("NO")) {
			System.out.println("");
		}

	}

	public void eliminarHabitat() {

		if (listaHabitats.isEmpty()) {
			System.out.println("Aún no ha creado ningún habitat.\n");
		}

		else {
			// PEDIMOS NOMBRE HABITAT
			System.out.println("Introduce el nombre del hábitat que quieres eliminar:");
			String nombreEliminarHabitat = sc.nextLine();
			int contador = 0;
			for (int i = 0; i < listaHabitats.size(); i++) {
				if (listaHabitats.get(i).getNombre().equalsIgnoreCase(nombreEliminarHabitat)) {
					listaHabitats.remove(i);
					System.out.println("El habitat " + nombreEliminarHabitat + " ha sido eliminado.\n");
				} else {
					contador++;
				}
			}
			if (contador > 0) {
				System.out.println("No existe ningún habitat con ese nombre.\n");
			}
		}
	}

	public void agregarAnimalesEnHabitat(Habitat habitat) {

		System.out.println("Introduce el nombre del animal que quieres añadir al habitat:");
		String nombreAnimal = sc.nextLine();

		if (habitat.getListaAnimales().isEmpty()) {
			System.out.println("Añade el género del animal:");
			String generoAnimal = sc.nextLine();
			System.out.println("Añade la especie del animal:");
			String especieAnimal = sc.nextLine();
			System.out.println("Añade la edad del animal:");
			String edadAnimalString = sc.nextLine();
			for (int j = 0; j < edadAnimalString.length(); j++) {
				while (!Character.isDigit(edadAnimalString.charAt(j))) {
					System.err.println("Intruduce una edad válida:");
					edadAnimalString = sc.nextLine();
				}
			}
			int edadAnimal = Integer.parseInt(edadAnimalString);

			System.out.println("\nDebes especificar un cuidador para el animal, ¿quieres crear uno nuevo? (SI/NO)");
			String respuesta = sc.nextLine();

			while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
				System.out.println("No te he entendido, ¿quieres crear uno nuevo? (SI/NO)");
				respuesta = sc.nextLine();
			}

			if (respuesta.equalsIgnoreCase("SI")) {
				agregarCuidador();
			}

			System.out.println(
					"Escribe el número de empleado del cuidador existente que quieres especificar para el animal:");
			String numeroCuidadorString = sc.nextLine();
			for (int j = 0; j < numeroCuidadorString.length(); j++) {
				while (!Character.isDigit(numeroCuidadorString.charAt(j))) {
					System.err.println("Intruduce un número válido:");
					numeroCuidadorString = sc.nextLine();
				}
			}
			int numeroCuidador = Integer.parseInt(numeroCuidadorString);
			int contadorCuidadores = 0;
			for (int j = 0; j < listaCuidadores.size(); j++) {
				if (listaCuidadores.get(j).getNumEmpleado() == numeroCuidador) {
					contadorCuidadores++;

					Animal nuevoAnimal = new Animal(nombreAnimal, generoAnimal, especieAnimal, edadAnimal, habitat,
							listaCuidadores.get(j));

					habitat.getListaAnimales().add(nuevoAnimal);
					listaTotalAnimales.add(nuevoAnimal);

					System.out.println("El animal " + nombreAnimal + " ha sido creado y añadido al habitat "
							+ habitat.getNombre() + ".\n");
				
				}
			}
			if (contadorCuidadores == 0) {
				System.err.println("No existe ningún cuidador con ese número de empleado.");
				System.out.println("No se pudo terminar de crear al animal.\n");
			}

		} else {
			int contador = 0;
			for (int i = 0; i < habitat.getListaAnimales().size(); i++) {
				if (habitat.getListaAnimales().get(i).getNombre().equalsIgnoreCase(nombreAnimal)) {
					contador++;
				}
			}
			if (contador > 0) {
				System.out.println("El animal " + nombreAnimal + " ya está en el habitat " + habitat.getNombre() + ".");
			} else {
				System.out.println("Añade el género del animal:");
				String generoAnimal = sc.nextLine();
				System.out.println("Añade la especie del animal:");
				String especieAnimal = sc.nextLine();
				System.out.println("Añade la edad del animal:");
				String edadAnimalString = sc.nextLine();
				for (int j = 0; j < edadAnimalString.length(); j++) {
					while (!Character.isDigit(edadAnimalString.charAt(j))) {
						System.err.println("Intruduce una edad válida:");
						edadAnimalString = sc.nextLine();
					}
				}
				int edadAnimal = Integer.parseInt(edadAnimalString);

				System.out.println("Debes especificar un cuidador para el animal, ¿quieres crear uno nuevo? (SI/NO)");
				String respuesta = sc.nextLine();

				while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
					System.out.println("No te he entendido, ¿quieres crear uno nuevo? (SI/NO)");
					respuesta = sc.nextLine();
				}

				if (respuesta.equalsIgnoreCase("SI")) {
					agregarCuidador();
				}

				System.out.println(
						"Escribe el número de empleado del cuidador existente que quieres especificar para el animal:");
				String numeroCuidadorString = sc.nextLine();
				for (int j = 0; j < numeroCuidadorString.length(); j++) {
					while (!Character.isDigit(numeroCuidadorString.charAt(j))) {
						System.err.println("Intruduce un número válido:");
						numeroCuidadorString = sc.nextLine();
					}
				}
				int numeroCuidador = Integer.parseInt(numeroCuidadorString);
				int contadorCuidadores = 0;
				for (int j = 0; j < listaCuidadores.size(); j++) {
					if (listaCuidadores.get(j).getNumEmpleado() == numeroCuidador) {
						contadorCuidadores++;

						Animal nuevoAnimal = new Animal(nombreAnimal, generoAnimal, especieAnimal, edadAnimal, habitat,
								listaCuidadores.get(j));

						habitat.getListaAnimales().add(nuevoAnimal);
						listaTotalAnimales.add(nuevoAnimal);

						System.out.println("El animal " + nombreAnimal + " ha sido creado y añadido al habitat "
								+ habitat.getNombre() + ".\n");
					}
				}
				if (contadorCuidadores == 0) {
					System.out.println("No existe ningún cuidador con ese número de empleado.");
				}
			}
		}
	}

	public void eliminarAnimalesEnHabitat(Habitat habitat) {

		if (habitat.getListaAnimales().isEmpty()) {
			System.err.println("El habitat " + habitat.getNombre() + " no tiene animales.\n");
		}

		else {
			System.out.println("Introduce el nombre del animal que quieres eliminar del habitat:");
			String nombreAnimal = sc.nextLine();

			for (int i = 0; i < habitat.getListaAnimales().size(); i++) {
				if (habitat.getListaAnimales().get(i).getNombre().equalsIgnoreCase(nombreAnimal)) {
					habitat.getListaAnimales().remove(i);
					System.out.println(
							"El animal " + nombreAnimal + " fue eliminado del habitat " + habitat.getNombre() + ".");
				} else {
					System.out.println("El habitat " + habitat.getNombre() + " no contiene ningún animal llamado "
							+ nombreAnimal + ".");
				}
			}
		}
	}

	public void agregarCuidador() {
		System.out.println("Introduce el número de empleado del cuidador:");
		String numeroCuidadorString = sc.nextLine();

		if (listaCuidadores.isEmpty()) {
			for (int j = 0; j < numeroCuidadorString.length(); j++) {
				while (!Character.isDigit(numeroCuidadorString.charAt(j))) {
					System.err.println("Intruduce un número válido:");
					numeroCuidadorString = sc.nextLine();
				}
			}
			int numeroCuidador = Integer.parseInt(numeroCuidadorString);

			System.out.println("Introduce el nombre del cuidador:");
			String nombreCuidador = sc.nextLine();
			System.out.println("Introduce el apellido del cuidador:");
			String apellidoCuidador = sc.nextLine();
			System.out.println("Introduce el salario del cuidador:");
			String salarioCuidadorString = sc.nextLine();
			for (int j = 0; j < salarioCuidadorString.length(); j++) {
				while (!Character.isDigit(salarioCuidadorString.charAt(j))) {
					System.err.println("Intruduce un salario válido:");
					salarioCuidadorString = sc.nextLine();
				}
			}
			int salarioCuidador = Integer.parseInt(salarioCuidadorString);

			EmpleadoZoo nuevoCuidador = new EmpleadoZoo(numeroCuidador, nombreCuidador, apellidoCuidador,
					salarioCuidador);
			listaCuidadores.add(nuevoCuidador);

			System.out.println("Se ha creado el cuidador " + nombreCuidador + " " + apellidoCuidador
					+ " con número de empleado " + numeroCuidador + ".\n");
		}

		else {
			int contador = 0;
			for (int i = 0; i < listaCuidadores.size(); i++) {
				if (Integer.toString(listaCuidadores.get(i).getNumEmpleado()).equals(numeroCuidadorString)) {
					contador++;
				}
			}
			if (contador > 0) {
				System.out.println("Ya existe un cuidador con número de empleado " + numeroCuidadorString);
			} else {

				for (int j = 0; j < numeroCuidadorString.length(); j++) {
					while (!Character.isDigit(numeroCuidadorString.charAt(j))) {
						System.err.println("Intruduce un número válido:");
						numeroCuidadorString = sc.nextLine();
					}
				}
				int numeroCuidador = Integer.parseInt(numeroCuidadorString);

				System.out.println("Introduce el nombre del cuidador:");
				String nombreCuidador = sc.nextLine();
				System.out.println("Introduce el apellido del cuidador:");
				String apellidoCuidador = sc.nextLine();
				System.out.println("Introduce el salario del cuidador:");
				String salarioCuidadorString = sc.nextLine();
				for (int j = 0; j < salarioCuidadorString.length(); j++) {
					while (!Character.isDigit(salarioCuidadorString.charAt(j))) {
						System.err.println("Intruduce un salario válido:");
						salarioCuidadorString = sc.nextLine();
					}
				}
				int salarioCuidador = Integer.parseInt(salarioCuidadorString);

				EmpleadoZoo nuevoCuidador = new EmpleadoZoo(numeroCuidador, nombreCuidador, apellidoCuidador,
						salarioCuidador);
				listaCuidadores.add(nuevoCuidador);

				System.out.println("Se ha creado el cuidador " + nombreCuidador + apellidoCuidador
						+ " con número de empleado " + numeroCuidador + ".");
			}
		}
	}

	public void eliminarCuidador() {

		if (listaCuidadores.isEmpty()) {
			System.out.println("Aún no se ha creado ningún cuidador.\n");
		}

		else {
			System.out.println("Introduce el número de empleado del cuidador:");
			String numeroCuidadorString = sc.nextLine();

			int contador = 0;
			for (int i = 0; i < listaCuidadores.size(); i++) {
				if (Integer.toString(listaCuidadores.get(i).getNumEmpleado()).equals(numeroCuidadorString)) {
					contador++;
					listaCuidadores.remove(i);
					System.out.println("Se ha eliminado el cuidador con número de empleado " + numeroCuidadorString
							+ " correctamente.");
				}
			}
			if (contador == 0) {
				System.out.println("No existe el cuidador con número de empleado " + numeroCuidadorString + ".");
			}
		}
	}
}
