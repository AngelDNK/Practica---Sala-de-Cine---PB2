package ar.edu.unlam.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.dominio.Sala;

public class InterfazSalaDeSala {

	public static void main(String[] args) {

		int opcionSeleccionada = 0, filas = 0, columnas = 0;

		Scanner teclado = new Scanner(System.in);

		System.out.println("Bienvenido a la Sala de Cine");
		System.out.println("Ingrese la cantidad de Filas de su Cine");
		filas = teclado.nextInt();
		System.out.println("Ingrese la cantidad de Columnas de su Cine");
		columnas = teclado.nextInt();
		Sala nuevaSala = new Sala(filas, columnas);

		do {

			menuDeOpciones();
			opcionSeleccionada = teclado.nextInt();
			switch (opcionSeleccionada) {
			case 1:
				mapaDeButacas(nuevaSala);
				break;
			case 2:
				ocuparButaca(nuevaSala, teclado);
				break;
			case 3:
				consultarTotalButaca(nuevaSala);
			case 4:

				break;
			case 5:
				System.out.println("Gracias, Vuelva Pronto :D");
				break;
			default:
				System.out.println("Error, opcion incorrecta");
				break;
			}

		} while (opcionSeleccionada != 4);

	}

	public static void menuDeOpciones() {
		System.out.println("***Menu de Opciones***");
		System.out.println("\n1- Mapa de Butacas" + "\n2- Ocupar Butaca" + "\n3- Consultar total de Butacas Ocupadas"
				+ "\n4- Ocupar Butacas Contiguas" + "\n5- Salir");
	}

	public static void mapaDeButacas(Sala sala) {
		System.out.println("Butacas del Cine");
		System.out.println(sala);
		System.out.println("-------------------------------------");
	}

	public static void ocuparButaca(Sala sala, Scanner teclado) {
		int numeroDeFila, numeroDeColumna;

		do {
			System.out.println("Ingrese el numero de la fila de su Butaca - Entre 1 y " + sala.getFilas());
			numeroDeFila = teclado.nextInt();

		} while (numeroDeFila >= sala.getFilas());

		do {
			System.out.println("Ingrese el numero de la columna de su Butaca - Entre 1 y " + sala.getColumnas());
			numeroDeColumna = teclado.nextInt();
		} while (numeroDeColumna >= sala.getColumnas());

		if (sala.ocuparButaca(numeroDeFila, numeroDeColumna)) {
			System.out.println("La butaca se Ocupo correctamente");
		} else {
			System.out.println("La butaca no se Ocupo correctamente");
		}
	}

	public static void consultarTotalButaca(Sala sala) {
		System.out.println("La cantidad de butacas ocupadas es: " + sala.consultarTotalButacasOcupadas());
	}

	public static void ocuparButacasContiguas(Sala sala, Scanner teclado) {

		int fila, columna, cantidad;

		System.out.println("Ingrese la Fila de las Butacas ");
		fila = teclado.nextInt();
		System.out.println("Ingrese la Columna de las Butacas ");
		columna = teclado.nextInt();
		System.out.println("Ingrese la cantidad de Butacas deseadas");
		cantidad = teclado.nextInt();
		if (columna + cantidad > sala.getColumnas()) {
			System.out.println("No puede ocupar mas butacas que la cantidad maxima de columnas ");
			menuDeOpciones();
		}
		
		if(sala.consultarButacasContiguas(fila, columna, cantidad) == true) {
			sala.ocuparButacasContiguas(fila, columna, cantidad);
			System.out.println("Las butacas se ocuparon exitosamente");
		}else {
			System.out.println("No se pudieron ocupar las butacas correctamente");
		}
	}

}
