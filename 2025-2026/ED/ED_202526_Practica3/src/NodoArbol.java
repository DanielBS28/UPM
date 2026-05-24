public class NodoArbol {
	private char dato;
	private NodoArbol izquierda, derecha;

	public NodoArbol(char dato) {
		this.dato = dato;
		izquierda = derecha = null;
	}

	public NodoArbol(char dato, NodoArbol izquierda, NodoArbol derecha) {
		this.dato = dato;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public NodoArbol getIzquierdo() {
		return izquierda;
	}

	public NodoArbol getDerecho() {
		return derecha;
	}

	public char getDato () {
		return dato;
	}

	public void setIzquierda(NodoArbol izquierda) {
		this.izquierda = izquierda;
	}

	public void setDerecha(NodoArbol derecha) {
		this.derecha = derecha;
	}

	public void setDato (char dato) {
		this.dato =dato;
	}

}
