public class Pila {

    private Nodo cima;
    private int numElementos;

    public Pila() {   // Iniciar pila vacía
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(int dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    public int desapilar() {
        int valor;
        if (this.vacia()) {
            valor = -1;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public int getCima() {
        int valor;
        if (this.vacia()) {
            valor = -1;
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
	
