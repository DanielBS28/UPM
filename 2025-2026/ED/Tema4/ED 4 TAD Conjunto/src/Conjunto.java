public class Conjunto {

	private NodoArbol raiz;
	private int numElementos;

	public Conjunto() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacio() {
		return raiz == null;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public boolean contiene(int valor) {
		return this.contieneRec(raiz, valor);
	}

	private boolean contieneRec(NodoArbol nodo, int valor) {
		boolean resultado;
		if (nodo == null) {
			resultado = false;
		} else if (nodo.getClave() == valor) {
			resultado = true;
		} else if (nodo.getClave() > valor) {
			resultado = this.contieneRec(nodo.getIzquierdo(), valor);
		} else {
			resultado = this.contieneRec(nodo.getDerecho(), valor);
		}
		return resultado;
	}


	public void insertar(int valor) {
		raiz = this.insertarRec(raiz, valor);
	}

	private NodoArbol insertarRec(NodoArbol nodo, int valor){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(valor);
			numElementos++;
		} else if (valor < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), valor);
			nodo.setIzquierdo(nuevoIzq);
		} else if (valor > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), valor);
			nodo.setDerecho(nuevoDer);
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	public boolean borrar(int valor) {
		int previousNumElementos = numElementos;
		raiz = this.borrarRec(raiz, valor);
		return (numElementos < previousNumElementos);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int valor) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > valor) {  // Subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), valor);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < valor) {  // Subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), valor);
			nodo.setDerecho(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoArbol nuevoIzq = this.cambiarPorMenor(nodo,
						nodo.getIzquierdo());
				nodo.setIzquierdo(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoArbol cambiarPorMenor(NodoArbol nodoBorrar, NodoArbol nodoMenor) {
		if (nodoMenor.getDerecho() != null) {   // Subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		} else {  // Encontrado nodo menor inmediato
			nodoBorrar.setClave(nodoMenor.getClave()); // Cambiar datos
			return nodoMenor.getIzquierdo();
			// Devolver subarbol izquierdo de menor inmediato
		}
	}
}
