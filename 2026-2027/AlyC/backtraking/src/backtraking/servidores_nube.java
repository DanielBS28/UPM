package backtraking;

public class servidores_nube {
	
	
	/*
	 * Enunciado de Examen: "Contratación Óptima de Servidores en la Nube"Problema (2.5 puntos). 
	 * Una empresa tecnológica necesita configurar un clúster que sume una capacidad de procesamiento 
	 * exacta de Ctotal núcleos de CPU. Para ello, un proveedor cloud le ofrece varios tipos de 
	 * servidores.
	 * De cada tipo de servidor i conocemos:
	 * El número de núcleos que aporta cada unidad, almacenado en el vector nucleos[i].
	 * El coste de alquiler (en euros por hora) de cada unidad, almacenado en el vector coste[i].
	 * El número máximo de servidores disponibles de ese tipo, almacenado en el vector disponibles[i].
	 * 
	 * Queremos encontrar qué combinación de servidores permite alcanzar exactamente los 
	 * Ctotal núcleos requeridos minimizando el coste total de alquiler.
	 * 
	 * Se pide: Implementar un algoritmo en Java, basado en el esquema de Selección Óptima, 
	 * con la siguiente cabecera: public static int[] contratacionOptima(int[] nucleos, int[] coste,
	 *  int[] disponibles, int Ctotal)
	 *  
	 *  
	 *	Valor de retorno: El método deberá devolver un vector de enteros int[] 
	 *(con tantos elementos como tipos de servidores haya), 
	 *donde cada posición $i$ indique cuántas unidades del servidor de tipo i se han contratado 
	 *en la solución óptima. Si ninguna combinación permite alcanzar exactamente
	 * Ctotal núcleos, el vector devuelto contendrá 0 en todas sus posiciones.
	 * 
	 * Aclaraciones: Todos los valores de los vectores son mayores que 0. 
	 * No es necesario implementar las clases Booleano ni Entero.
	 * 
	 * 
	 * 
	 * */
	
	public static int[] contratacionOptima(int[] nucleos, int[] coste,
			  int[] disponibles, int Ctotal) {
		
		int [] solucionActual = new int[nucleos.length];
		int [] solucion = new int[nucleos.length];

		for(int i = 0; i< solucion.length; i++) {
			solucion[i] = 0;
			solucionActual[i] = 0;
		}
		Entero mejorPresupuesto = new Entero(Integer.MAX_VALUE);
		int presupuestoActual = 0;
		
		contratacionOptimaAux(nucleos, coste, disponibles, Ctotal, solucion, solucionActual, mejorPresupuesto, presupuestoActual, 0);
		return solucion;
		
	}

	private static void contratacionOptimaAux(int[] nucleos, int[] coste, int[] disponibles, int falta, int[] solucion,int[] solucionActual,
			Entero mejorPresupuesto, int presupuestoActual, int nivel) {
		
		if(nivel == solucion.length) {
			if(falta == 0 && presupuestoActual < mejorPresupuesto.getValor()) {
				mejorPresupuesto.setValor(presupuestoActual);
				for(int i = 0; i < solucion.length ; i++)
					solucion[i] = solucionActual[i];
			}
		}else {
			
			int c = 0;
			int cMax = Math.min(disponibles[nivel], falta/nucleos[nivel]);
			
			while(c <= cMax) {
				falta = falta - nucleos[nivel]*c;
				solucionActual[nivel] = c;
				presupuestoActual = presupuestoActual + coste[nivel] * c;
				nivel++;
				
				if (presupuestoActual < mejorPresupuesto.getValor()) {
	                contratacionOptimaAux(nucleos, coste, disponibles, falta, solucion, 
	                                      solucionActual, mejorPresupuesto, presupuestoActual, nivel);
	            }
				
				nivel--;
				solucionActual[nivel]=0;
				presupuestoActual = presupuestoActual - coste[nivel] * c;
				falta = falta + nucleos[nivel]*c;
				
				c++;
			}
		}
		
	}

}
