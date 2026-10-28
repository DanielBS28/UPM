package backtraking;

public class litros_maximo {
	
	/**
	 * 
	 * Enunciado del Ejercicio de Práctica: "Empaquetado Exacto de Pedidos"
	 * Un centro logístico dispone de varios modelos de contenedores. 
	 * De cada modelo i conocemos:Su capacidad exacta (en litros), almacenada en el vector capacidad[i].
	 * El stock disponible (número máximo de contenedores que tenemos de ese modelo), 
	 * almacenado en el vector stock[i].
	 * 
	 * Queremos determinar si es posible distribuir una mercancía de volumen total Vtotal llenando 
	 * por completo una combinación de estos contenedores, 
	 * de forma que la suma de las capacidades de los contenedores elegidos sea exactamente igual 
	 * a Vtotal.
	 * 
	 * Se pide implementar un algoritmo en Java, basado en el esquema de Backtracking, con la
	 * siguiente cabecera: public static int[] empaquetadoExacto(int[] capacidad, int[] stock, 
	 * int Vtotal)
	 * 
		Lo que debe devolver el método:
		El método debe devolver un vector de enteros int[] (de longitud capacidad.length), 
		donde cada posición $i$ indique cuántos contenedores del modelo $i$ se han utilizado 
		para conseguir el volumen exacto Vtotal.No se pide minimizar ni maximizar el número 
		de contenedores: basta con encontrar una combinación válida y detener la búsqueda.
		Si no existe ninguna combinación posible que sume exactamente Vtotal, el método deberá
		 devolver el vector con 0 en todas sus posiciones.
	 */

	
	public static int[] empaquetadoExacto(int[] capacidad, int[] stock, 
			  int Vtotal) {
		
		Booleano exito = new Booleano(false);
		int[] solucion = new int[capacidad.length];
		int falta = Vtotal;
		
		for(int i = 0; i<solucion.length; i++)
			solucion[i] = 0;
		
		empaquetadoExactoAux(capacidad, stock, falta, solucion,0, exito);
		empaquetadoExactoCombinatorio(capacidad, stock, falta, solucion,0, exito);
		
		return solucion;
		
	}

	private static void empaquetadoExactoAux(int[] capacidad, int[] stock, int falta, int[] solucion, int nivel, Booleano exito) {
		
		if(nivel == capacidad.length && falta == 0)
			exito.setValor(true);
		else if(nivel < capacidad.length) {
			int c = 0;
			int cMax = Math.min(stock[nivel], falta/capacidad[nivel]);
			while(c <= cMax && !exito.getValor()) {
				
				falta = falta - capacidad[nivel]*c;
				solucion[nivel] = c;
				nivel++;
				empaquetadoExactoAux(capacidad, stock, falta, solucion, nivel, exito);
				if(!exito.getValor()) {
					nivel--;
					solucion[nivel] = 0;
					falta = falta + capacidad[nivel]*c;
				}
				c++;
			}
		}
		
	}
	private static void empaquetadoExactoCombinatorio(int[] capacidad, int[] stock, int falta, int[] solucion,int cInicial, Booleano exito) {
		
		if(falta == 0)
			exito.setValor(true);
		else {
			
			int c = cInicial;
			while(c < capacidad.length && !exito.getValor()) {
				if(falta >= capacidad[c] && stock[c] > 0) {
					falta = falta - capacidad[c];
					stock[c]--;
					solucion[c]++;
					empaquetadoExactoCombinatorio(capacidad, stock, falta, solucion, c, exito);
					if(!exito.getValor()) {
						falta = falta + capacidad[c];
						stock[c]++;
						solucion[c]--;
					}
				}
				c++;

			}
		}
			
	}
	
}
