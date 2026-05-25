import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("LanguageDetectionInspection")
public class TablaEstadistica {

	private NodoTablaEstadistica raiz;
	private int numElementos;

	public TablaEstadistica() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacio() {
		return raiz == null;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public Double getElemento(Double clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Double getElementoRec(NodoTablaEstadistica nodo, Double clave) {
		Double resultado;
		if (nodo == null) {
			resultado = null;
		} else if (nodo.getClave() == clave) {
			resultado = nodo.getDato();
		} else if (nodo.getClave() > clave) {
			resultado = this.getElementoRec(nodo.getIzquierdo(), clave);
		} else {
			resultado = this.getElementoRec(nodo.getDerecho(), clave);
		}
		return resultado;
	}

	public boolean contiene(Double clave) {
		return (getElemento(clave) != null);
	}


	public void insertar(Double clave, Double dato) {
		raiz = this.insertarRec(raiz, clave, dato);
	}

	private NodoTablaEstadistica insertarRec(NodoTablaEstadistica nodo, Double clave, Double dato){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoTablaEstadistica(clave, dato);
			numElementos++;
		} else if (clave < nodo.getClave()) {    // Subárbol izquierdo
			NodoTablaEstadistica nuevoIzq = this.insertarRec(nodo.getIzquierdo(), clave, dato);
			nodo.setIzquierda(nuevoIzq);
		} else if (clave > nodo.getClave()) {    // Subárbol derecho
			NodoTablaEstadistica nuevoDer = this.insertarRec(nodo.getDerecho(), clave, dato);
			nodo.setDerecha(nuevoDer);
		} else {      // Clave repetida
			nodo.setDato(dato);
		}
		return nodo;    // Devolver nodo (puede haber cambiado)
	}


	public void borrar(Double clave) {
		raiz = this.borrarRec(raiz, clave);
	}

	private NodoTablaEstadistica borrarRec(NodoTablaEstadistica nodo, Double clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Subarbol izquierdo
			NodoTablaEstadistica nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierda(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Subarbol derecho
			NodoTablaEstadistica nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
			nodo.setDerecha(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoTablaEstadistica nuevoIzq = this.cambiarPorMenor(nodo,
						nodo.getIzquierdo());
				nodo.setIzquierda(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoTablaEstadistica cambiarPorMenor(NodoTablaEstadistica nodoBorrar, NodoTablaEstadistica nodoMenor) {
		if (nodoMenor.getDerecho() == null) {   // Es menor inmediato
			// Cambiar datos
			nodoBorrar.setClave(nodoMenor.getClave());
			nodoBorrar.setDato(nodoMenor.getDato());
			// Devolver subarbol izquierdo de menor inmediato
			return nodoMenor.getIzquierdo();
		} else {  // Buscar menor inmediato en subárbol derecho
			NodoTablaEstadistica nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecha(nuevoDer);
			return nodoMenor;
		}
	}

	/**
	 * Constructor desde tabla CSV
	 */
	public static TablaEstadistica cargarDesdeFichero(String rutaFichero) {
		double[][] datos = TablaEstadistica.leerTablaEstadistica(rutaFichero);
		TablaEstadistica res;
		if (datos == null) {
			System.out.printf("Error al cargar datos de %s\n", rutaFichero);
			res = null;
		} else {
			res = new TablaEstadistica();
			res.raiz = TablaEstadistica.construirBalanceado(datos, 0, datos.length - 1);
			res.numElementos = datos.length;
		}
		return res;
	}

	private static NodoTablaEstadistica construirBalanceado(double[][] datos, int inicio, int fin) {
		if (inicio > fin) {
			return null;
		}

		int medio = (inicio + fin) / 2;
		NodoTablaEstadistica nodo = new NodoTablaEstadistica(datos[medio][0], datos[medio][1]);
		nodo.setIzquierda(TablaEstadistica.construirBalanceado(datos, inicio, medio - 1));
		nodo.setDerecha(TablaEstadistica.construirBalanceado(datos, medio + 1, fin));
		return nodo;
	}

	private static double[][] leerTablaEstadistica(String rutaArchivo) {
		double[][] datosTabla;
		// Primero contamos el número de líneas para crear el array
		int numLineas = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			while (br.readLine() != null) {
				numLineas++;
			}
		} catch (IOException e) {
			System.err.println("Error al contar líneas del archivo: " + e.getMessage());
			return null;
		}

		// Ahora leemos el archivo y llenamos el array
		datosTabla = new double[numLineas][2]; // Cada sala tiene 2 datos (z, probabilidad)
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				String[] datosStr = linea.trim().split(",");
				for (int j = 0; j < datosStr.length; j++) {
					datosTabla[i][j] = Double.parseDouble(datosStr[j]);
				}
				i++;
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
			return null;
		}

		return datosTabla;
	}

	// Ejercicio 8: Búsqueda de proximidad en Árbol Binario de Búsqueda
	public double consultarMasCercano(double clave) {
		if (raiz == null) {
			return 0.0;
		}

		//  método recursivo
		NodoTablaEstadistica nodoMasCercano = consultarMasCercanoRec(raiz, clave);

		return nodoMasCercano.getDato();
	}

	/**
	 * Método recursivo que explora el ABB buscando la clave matemática más cercana.
	 * @param nodo El nodo actual en evaluación.
	 * @param claveBuscada El valor objetivo al que queremos aproximarnos.
	 * @return El nodo cuya clave tiene la menor diferencia absoluta con la claveBuscada.
	 */
	private NodoTablaEstadistica consultarMasCercanoRec(NodoTablaEstadistica nodo, double claveBuscada) {
		//  Caso Base: Se llega a una rama vacía
		if (nodo == null) {
			return null;
		}

		//  Coincidencia Exacta: Si la clave es idéntica, la distancia es 0.
		// Es imposible encontrar un candidato mejor.
		if (nodo.getClave() == claveBuscada) {
			return nodo;
		}

		NodoTablaEstadistica mejorHijo = null;

		//  Fase de Descenso
		// Si el valor que buscamos es menor que la clave del nodo actual,
		// la lógica del ABB dice que los valores más cercanos estarán a la izquierda.
		if (claveBuscada < nodo.getClave()) {
			mejorHijo = consultarMasCercanoRec(nodo.getIzquierdo(), claveBuscada);
		} else {
			// Si es mayor, estarán a la derecha.
			mejorHijo = consultarMasCercanoRec(nodo.getDerecho(), claveBuscada);
		}

		// Fase de Retorno y Comparación:
		// Si la llamada recursiva devolvió null, significa que el nodo actual es una hoja.
		// Al no haber más descendientes, el nodo actual es el mejor candidato de esta rama.
		if (mejorHijo == null) {
			return nodo;
		}

		// Se calcula la distancia absoluta entre el objetivo y los dos candidatos:
		// el nodo actual y el mejor nodo encontrado en las profundidades de sus hijos.
		double distActual = Math.abs(nodo.getClave() - claveBuscada);
		double distHijo = Math.abs(mejorHijo.getClave() - claveBuscada);

		// 5. Resolución del ganador
		if (distHijo < distActual) {
			return mejorHijo;
		} else if (distActual < distHijo) {
			return nodo;
		} else {
			// Desempate: Si ambas distancias son exactamente iguales,
			// el enunciado especifica que se debe devolver la clave de menor valor.
			if (nodo.getClave() < mejorHijo.getClave()) {
				return nodo;
			} else {
				return mejorHijo;
			}
		}
	}
}
