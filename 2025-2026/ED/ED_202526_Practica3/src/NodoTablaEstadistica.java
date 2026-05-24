public class NodoTablaEstadistica {
	private Double dato;
	private Double clave;
	private NodoTablaEstadistica izquierda, derecha;

	public NodoTablaEstadistica(Double clave, Double dato) {
		this.clave = clave;
		this.dato = dato;
		izquierda = derecha = null;
	}

	public NodoTablaEstadistica(Double dato, NodoTablaEstadistica izquierda, NodoTablaEstadistica derecha) {
		this.dato = dato;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public NodoTablaEstadistica getIzquierdo() {
		return izquierda;
	}

	public NodoTablaEstadistica getDerecho() {
		return derecha;
	}

	public Double getClave() {
		return clave;
	}

	public void setClave(Double clave) {
		this.clave = clave;
	}

	public Double getDato () {
		return dato;
	}

	public void setIzquierda(NodoTablaEstadistica izquierda) {
		this.izquierda = izquierda;
	}

	public void setDerecha(NodoTablaEstadistica derecha) {
		this.derecha = derecha;
	}

	public void setDato (Double dato) {
		this.dato =dato;
	}

}
