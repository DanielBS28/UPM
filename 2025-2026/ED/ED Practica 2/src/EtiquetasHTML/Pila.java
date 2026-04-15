package EtiquetasHTML;

public class Pila {

    private Nodo cima;
    private int numElementos;

    public Pila() {   // Iniciar pila vac�a
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(String dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    public String desapilar() {
        String valor;
        if (this.vacia()) {
            valor = null;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public String getCima() {
        String valor;
        if (this.vacia()) {
            valor = null;
        } else {
            valor = cima.getDato();
        }
        return valor;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public String toString() {
        String resultado = "Cima -> [";
        if (!this.vacia()) {
            resultado += cima.getDato();
            Nodo aux = cima.getSiguiente();
            while (aux != null) {
                resultado += "," + aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        resultado += "]";
        return resultado;
    }

}
	
