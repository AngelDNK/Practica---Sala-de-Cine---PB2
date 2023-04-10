package ar.edu.unlam.pb2.dominio;

public class Sala {

	private int butacasTotales;
	private int filas = 0;
	private int columnas = 0;
	private Boolean[][] butacas;

	public Sala(int filas, int columnas) {

		this.butacasTotales = butacasTotales;
		this.filas = filas;
		this.columnas = columnas;
		butacas = new Boolean[filas][columnas];

	}

	public boolean consultarButaca(int fila, int columna) {
		boolean seConsultoButaca = false;
		if (butacas[fila][columna] == null) {
			seConsultoButaca = true;
		}

		return seConsultoButaca;
	}

	public boolean ocuparButaca( int fila, int columna) {
		boolean seOcupoButaca = false;
		if (consultarButaca(fila, columna)) {
			butacas[fila][columna] = true;
			seOcupoButaca = true;
		}

		return seOcupoButaca;

	}

	public boolean consultarTotalButacasOcupadas() {
		boolean seConsultoTotalDeButacasOcupadas = false;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < j; j++) {
				if (butacas[i][j] == true) {
					seConsultoTotalDeButacasOcupadas = true;
				}
			}
		}

		return seConsultoTotalDeButacasOcupadas;
	}

	public boolean consultarButacasContiguas(int fila, int columna, int cantidad) {
		boolean hayEspacioPara = false;
		for (int i = 0; i < cantidad; i++) {
			if (butacas[fila][columna + i] == false) {
				hayEspacioPara = true;
			}
		}

		return hayEspacioPara;
	}

	public void ocuparButacasContiguas(int fila, int columna, int cantidad) {
		if (consultarButacasContiguas(fila, columna, columna)) {
			for (int i = 0; i <= cantidad; i++) {
				butacas[fila][columna + i] = true;
			}
		}
	}

	public String toString() {
		String mapaDeButacas = "";

		for (int fila = 0; fila < filas; fila++) {

			mapaDeButacas += "\n-------------------------\n|";

			for (int columna = 0; columna < butacas[fila].length; columna++) {
				if (butacas[fila][columna] == null) {
					mapaDeButacas += " L |";
				} else {
					mapaDeButacas += " O |";
				}
			}

		}
		return mapaDeButacas;

	}

	public int getButacasTotales() {
		return butacasTotales;
	}

	public void setButacasTotales(int butacasTotales) {
		this.butacasTotales = butacasTotales;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Boolean[][] getButacas() {
		return butacas;
	}

	public void setButacas(Boolean[][] butacas) {
		this.butacas = butacas;
	}
}
