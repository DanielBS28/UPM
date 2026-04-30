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

	//Ejercicio 4, apartado a
	public void mostrarClavesDescendentes(){

		mostrarClavesDescendentesRec(raiz);

	}

	private void mostrarClavesDescendentesRec(NodoArbol nodo) {

		if(nodo  != null) {
			this.mostrarClavesDescendentesRec(nodo.getDerecho());
			System.out.print(nodo.getClave() + " ");
			this.mostrarClavesDescendentesRec(nodo.getIzquierdo());
		}
	}

	//Ejercicio 4, apartado b
	public void mostrarUnHijoDescendentes(){

		mostrarUnHijoDescendentesRec(raiz);

	}

	private void mostrarUnHijoDescendentesRec(NodoArbol nodo) {

		if(nodo  != null) {
			this.mostrarUnHijoDescendentesRec(nodo.getDerecho());
			if((nodo.getIzquierdo() == null && nodo.getDerecho() != null) ||
					(nodo.getIzquierdo() != null && nodo.getDerecho() == null))
			System.out.print(nodo.getClave() + " ");
			this.mostrarUnHijoDescendentesRec(nodo.getIzquierdo());
		}
	}

	//Ejercicio 4 apartado a
	public void mostrarClavesEntreDos(int menor, int mayor){
		mostrarClavesEntreDosRec(raiz, menor, mayor);
	}

	private void mostrarClavesEntreDosRec(NodoArbol nodo, int menor, int mayor) {

		if(nodo != null){
			if(nodo.getClave() < menor)
				mostrarClavesEntreDosRec(nodo.getDerecho(), menor, mayor);
			else if(nodo.getClave() >= mayor){
				mostrarClavesEntreDosRec(nodo.getIzquierdo(), menor , mayor);
			}
			else {
				mostrarClavesEntreDosRec(nodo.getIzquierdo(), menor, mayor);
				System.out.print(nodo.getClave() +" ");
				mostrarClavesEntreDosRec(nodo.getDerecho(), menor, mayor);
			}
		}
	}

}
