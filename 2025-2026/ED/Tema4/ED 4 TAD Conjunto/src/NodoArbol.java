public class NodoArbol {

	private int clave;
	private NodoArbol izquierdo, derecho;

	public NodoArbol(int clave) {
		this.clave = clave;
		this.izquierdo = null;
		this.derecho = null;
	}

	public int getClave() {return clave; }

	public void setClave(int clave) { this.clave = clave; }

	public NodoArbol getIzquierdo() { return izquierdo; }

	public void setIzquierdo(NodoArbol izquierdo) { this.izquierdo = izquierdo; }

	public NodoArbol getDerecho() { return derecho; }

	public void setDerecho(NodoArbol derecho) { this.derecho = derecho;}

}