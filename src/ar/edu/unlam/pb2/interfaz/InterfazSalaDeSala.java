package ar.edu.unlam.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.dominio.Sala;

public class InterfazSalaDeSala {

	

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int filas, columnas,opcionSeleccionada = 0;
		
		System.out.println("Bienvenido a la sala de cine");
		System.out.println("Ingrese la cantidad de Filas de su cine");
		filas = teclado.nextInt();
		System.out.println("Ingrese la cantidad de Columnas de su cine");
		columnas = teclado.nextInt();
		Sala sala = new Sala(filas, columnas);
		sala.liberarButacas();
		
	do {
			mostrarMenuPrincipal();
			switch (opcionSeleccionada) {
			case 1:
				imprimirSala(sala);
				break;
			case 2:
				ocuparButaca(sala, teclado);
				break;
			case 3:
				consultarOcupadas(sala);
				break;
			case 4:
				consultarContiguas(sala, teclado);
				break;
			case 5:
				System.out.println("Gracias Vuelva pronto! :D");
				break;
			default:
				System.out.println("Error, vuelva a intentarlo");
				break;
			}
		} while (opcionSeleccionada != 5);
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido al Menu Principal" 
						+ "\n1---------> Mostrar estado de las butacas"
						+ "\n2---------> Ocupar butaca" 
						+ "\n3---------> Consultar cantidad TOTAL de butacas OCUPADAS"
						+ "\n4---------> Ocupar butacas contiguas" 
						+ "\n0---------> SALIR");
	}

	public static void imprimirSala(Sala sala) {
		for (Integer i = 0; i < sala.getFilas(); i++) {
			for (Integer j = 0; j < sala.getColumnas(); j++) {
				if (sala.getButacas()[i][j] == false) {
					System.out.print("L ");
				} else {
					System.out.print("O ");
				}

			}
			
		}
	}

	public static void ocuparButaca(Sala sala, Scanner teclado) {
		Integer numerodefila;
		Integer numerodecolumna;
		do {
			System.out.println("Ingrese el Numero de la Fila de su Butaca, entre 1 y " + sala.getFilas());

			numerodefila = teclado.nextInt() - 1;
		} while (numerodefila >= sala.getFilas());

		do {
			System.out.println("Ingrese el Numero de la Columna de su Butaca, entre 1 y " + sala.getColumnas());
			numerodecolumna = teclado.nextInt() - 1;
		} while (numerodecolumna >= sala.getColumnas());

		if (sala.ocuparButaca(numerodefila, numerodecolumna)) {
			System.out.println("Su butaca se ocupo correctamente");
		} else {
			System.out.println("La Butaca no se Ocupar");
		}
	}

	public static void consultarOcupadas(Sala sala) {
		System.out.println(" La Cantidad total de Butacas ocupadas es " + sala.consultarTotalOcupadas());
	}

	public static void consultarContiguas(Sala sala, Scanner teclado) {

		System.out.println("Ingrese la Fila de su Butaca inicial");
		Integer fila = teclado.nextInt();
		System.out.println("Ingrese la Columna de su Butaca inicial");
		Integer columna = teclado.nextInt();
		System.out.println("Ingrese la cantidad de asientos que deseada");
		Integer cantidad = teclado.nextInt();
		if (columna + cantidad > sala.getColumnas()) {
			System.out.println("No puede ocupar mas butacas que la cantidad maxima de columnas");
			
		}

		if (sala.comprobarButcasContiguas(fila - 1, columna - 1, cantidad - 1) == true) {
			sala.ocuparButcasContiguas(fila - 1, columna - 1, cantidad - 1);
			System.out.println("Ocupadas correctamente");
		} else {
			System.out.println("No hay dicha cantidad de butacas contiguas en esa fila y columna");
		}
	}

	
	}

