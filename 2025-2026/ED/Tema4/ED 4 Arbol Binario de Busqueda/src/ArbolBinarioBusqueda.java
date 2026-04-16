public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	public boolean vacio() {
		return raiz == null;
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
		} else if (valor < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), valor);
			nodo.setIzquierdo(nuevoIzq);
		} else if (valor > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), valor);
			nodo.setDerecho(nuevoDer);
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}

}
