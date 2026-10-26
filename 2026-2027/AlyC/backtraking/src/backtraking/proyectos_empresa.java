package backtraking;

public class proyectos_empresa {
	
/**
 * • Enunciado del Ejercicio de Práctica: "La Selección de Proyectos I+D"
• Una empresa de software dispone de un conjunto de n proyectos de I+D. 
De cada proyecto i conocemos su coste económico (en miles de euros), almacenado en un vector coste[i],
 y los beneficios estimados que reportará a la empresa, almacenados en un vector beneficio[i]. 
 La dirección de la empresa cuenta con un presupuesto máximo estricto MaxPresupuesto para invertir. 
 El objetivo es encontrar el subconjunto de proyectos que, sin superar en total el MaxPresupuesto, 
 maximicen el beneficio total obtenido.
 
• Se pide implementar un algoritmo en Java, basado en el esquema de Selección Óptima, 
con la siguiente cabecera: 
boolean[] proyectosOptimos (int[] coste, int[] beneficio, int MaxPresupuesto)
• Lo que debe devolver el método: El método debe devolver un vector de valores boolean[] 
de la misma longitud que los vectores de entrada, con valor true en las posiciones
 de los proyectos que han sido seleccionados por el algoritmo y false en el resto. 
 Si ningún subconjunto cumple con el presupuesto (o si la mejor opción deja beneficio 0), 
 el vector contendrá false en todas sus posiciones.
 
 
 
*/
 
	
	public static boolean [] proyectosOptimos(int[]coste, int[]beneficio, int maxPresupuesto) {
		
		boolean [] solucion = new boolean[coste.length];
		boolean [] mejorSolucion = new boolean[coste.length];

		for(int i = 0; i < coste.length; i++) {
			solucion[i] = false;
			mejorSolucion[i] = false;
		}
		Entero mejorPresupuesto = new Entero(Integer.MIN_VALUE);
		proyectosOptimosAux(coste, beneficio, maxPresupuesto, solucion, mejorSolucion, mejorPresupuesto,0, 0,0);
		
		
		return mejorSolucion;
	}

	private static void proyectosOptimosAux(int[] coste, int[] beneficio, int maxPresupuesto, boolean[] solucion,
		boolean[] mejorSolucion, Entero mejorPresupuesto, int nivel, int costeActual, int beneficioActual) {
		
		if(nivel == coste.length) {
			if(beneficioActual > mejorPresupuesto.getValor()) {
				for(int i = 0; i < coste.length; i++)
					mejorSolucion[i] = solucion[i];
				mejorPresupuesto.setValor(beneficioActual);
			}
		}else {
			for(int c = 0; c < 2; c++) {
				
				if(c == 0|| costeActual + coste[nivel] <= maxPresupuesto) {
					costeActual = costeActual + coste[nivel]*c;
					beneficioActual = beneficioActual + beneficio[nivel]*c;
					solucion[nivel] = (c == 1);

					nivel++;					
					proyectosOptimosAux(coste, beneficio, maxPresupuesto, solucion, mejorSolucion, mejorPresupuesto, nivel, costeActual, beneficioActual);
					nivel--;
					costeActual = costeActual - coste[nivel]*c;
					beneficioActual = beneficioActual - beneficio[nivel]*c;
					solucion[nivel] = false;
						

				}
			}
		}
		
		
	
}


}
