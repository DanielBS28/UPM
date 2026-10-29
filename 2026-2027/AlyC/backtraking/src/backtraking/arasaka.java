package backtraking;

public class arasaka {
	
	public static int maxPeticiones(int N, int[] origen, int[] destino) {
	    // En lugar de un solo 'int falta', el estado de los edificios es un array de balances
	    int[] balance = new int[N];
	    for (int i = 0; i < N; i++) {
	        balance[i] = 0;
	    }

	    // Como queremos MAXIMIZAR peticiones, inicializamos el récord a 0
	    Entero mejorPeticiones = new Entero(0);
	    int peticionesActuales = 0;

	    maxPeticionesAux(origen, destino, balance, 0, peticionesActuales, mejorPeticiones);

	    return mejorPeticiones.getValor();
	}

	private static void maxPeticionesAux(int[] origen, int[] destino, int[] balance, 
	                                     int nivel, int peticionesActuales, Entero mejorPeticiones) {
	    // 1. CASO BASE: Hemos llegado al final del vector de peticiones
	    if (nivel == origen.length) {
	        // Comprobamos si 'falta == 0' en TODOS los edificios (todo el vector balance a 0)
	        boolean valido = true;
	        int i = 0;
	        while (i < balance.length && valido) {
	            if (balance[i] != 0) {
	                valido = false;
	            }
	            i++;
	        }

	        // Si es una solución válida y supera nuestro récord (Maximizar -> '>'), actualizamos
	        if (valido && peticionesActuales > mejorPeticiones.getValor()) {
	            mejorPeticiones.setValor(peticionesActuales);
	        }
	    } 
	    // 2. CASO RECURSIVO
	    else {
	        int cMax = 1; // Decisión binaria: 0 (no aprobar petición) o 1 (aprobar petición)

	        for (int c = 0; c <= cMax; c++) {
	            // A. ANOTAR (Exactamente igual que con 'falta', pero usando 1 * c)
	            balance[origen[nivel]] = balance[origen[nivel]] + 1 * c;
	            balance[destino[nivel]] = balance[destino[nivel]] - 1 * c;
	            peticionesActuales = peticionesActuales + 1 * c;
	            nivel++;

	            // B. LLAMADA RECURSIVA
	            maxPeticionesAux(origen, destino, balance, nivel, peticionesActuales, mejorPeticiones);

	            // C. DESANOTAR (Siempre, en orden inverso, empezando por nivel--)
	            nivel--;
	            peticionesActuales = peticionesActuales - 1 * c;
	            balance[destino[nivel]] = balance[destino[nivel]] + 1 * c;
	            balance[origen[nivel]] = balance[origen[nivel]] - 1 * c;
	        }
	    }
	}

}
