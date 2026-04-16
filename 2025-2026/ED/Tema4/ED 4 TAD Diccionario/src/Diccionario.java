public class Diccionario {

	private NodoArbol raiz;
	private int numElementos;

	public Diccionario() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacio() {
		return raiz == null;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public Alumno getElemento(int clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Alumno getElementoRec(NodoArbol nodo, int clave) {
		Alumno resultado;
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

	public boolean contiene(int clave) {
		return (getElemento(clave) != null);
	}


	public void insertar(int clave, Alumno dato) {
		raiz = this.insertarRec(raiz, clave, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, int clave, Alumno dato){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(clave, dato);
			numElementos++;
		} else if (clave < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), clave, dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (clave > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), clave, dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			nodo.setDato(dato);
		}
		return nodo;    // Devolver nodo (puede haber cambiado)
	}


	public void borrar(int clave) {
		raiz = this.borrarRec(raiz, clave);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
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
		if (nodoMenor.getDerecho() == null) {   // Es menor inmediato
			// Cambiar datos
			nodoBorrar.setClave(nodoMenor.getClave());
			nodoBorrar.setDato(nodoMenor.getDato());
			// Devolver subarbol izquierdo de menor inmediato
			return nodoMenor.getIzquierdo();
		} else {  // Buscar menor inmediato en subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		}
	}






}
