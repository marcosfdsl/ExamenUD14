package tareaud13;

import java.util.ArrayList;

public class Pantalla {
	
	// ATRIBUTOS
	
	private ArrayList<Figura> f = new ArrayList<>();

	// CONSTRUCTOR (su única función es llamar a los métodos de su clase Pantalla desde la clase DibujaPantalla)
	
	public Pantalla() {
	}

	// MÉTODO QUE AÑADE UNA FIGURA AL ArrayList f
	
	public void anadeFigura(Figura figura) {
		f.add(figura);
	}
	
	// MÉTODO QUE MODIFICA EL CARACTER DE TODAS LAS FIGURAS
	
	public void modificarFigura(char ch) {
		for (int i=0; i<f.size(); i++) {
			f.get(i).setCaracter(ch);
		}
		System.out.println("Se ha modificado el caracter de todas las figuras.\n");
	}

	// MÉTODO QUE IMPRIME LA DESCRIPCIÓN DE CADA FIGURA EN UNA LISTA
	
	public void listaFiguras() {
		for (int i=0; i<f.size(); i++) {
			System.out.println("Figura " + (i+1) + ": " + f.get(i).nombre());
		}
		System.out.println();
	}
	
	// MÉTODO QUE CALCULA EL ÁREA TOTAL DE TODAS LAS FIGURAS
	
	public int areaPantalla() {
		int areaTotal = 0;
		for (int i=0; i<f.size(); i++) {
			areaTotal+=f.get(i).area();
		}
		return areaTotal;
	}
	
	// MÉTODO QUE DIBUJA TODAS LAS FIGURAS
	
	public void muestraPantalla() {
		if (f.isEmpty()) {
			System.out.println("No hay ninguna figura a mostrar.\n");
		}
		
		else {
			System.out.println("Las figuras que has añadido son:");
			for (int i=0; i<f.size(); i++) {
				System.out.println();
				f.get(i).dibujar();
			}
			System.out.println();
		}
	}
	
	// MÉTODOS PARA COMPROBAR SI EL ArrayList f ESTÁ VACÍO
	
	public boolean isEmpty() {
		boolean empty = f.isEmpty();
		return empty;
	}
	
}
