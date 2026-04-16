public class NodoArbol {

	private int clave;
	private Alumno dato;
	private NodoArbol izquierdo, derecho;

	public NodoArbol(int clave, Alumno dato) {
		this.clave = clave;
		this.dato = dato;
		this.izquierdo = null;
		this.derecho = null;
	}

	public Alumno getDato() { return dato; }

	public void setDato(Alumno dato) { this.dato = dato; }

	public int getClave() {return clave; }

	public void setClave(int clave) { this.clave = clave; }

	public NodoArbol getIzquierdo() { return izquierdo; }

	public void setIzquierdo(NodoArbol izquierdo) { this.izquierdo = izquierdo; }

	public NodoArbol getDerecho() { return derecho; }

	public void setDerecho(NodoArbol derecho) { this.derecho = derecho;}

}