public class Cola {
    private Nodo inicio, fin;
    private int numElementos;

    public Cola() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia() {   // Comprueba si la cola está vacía
        return inicio == null;
    }

    public void encolar(int dato) {    // Coloca dato al final de la cola
        Nodo nuevo = new Nodo(dato, null);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        } else {
            inicio = nuevo;
        }
        fin = nuevo;
        numElementos++;
    }

    public int desencolar() {
        int resultado;
        if (this.vacia()) {
            resultado = -1;
        } else {
            resultado = inicio.getDato();
            inicio = inicio.getSiguiente();
            if (inicio == null) {  // La cola se queda vacía
                fin = null;
            }
            numElementos--;
        }
        return resultado;
    }

    public int getPrimero() {
        int resultado;
        if (this.vacia()) {
            resultado = -1;
        } else {
            resultado = inicio.getDato();
        }
        return resultado;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public String toString() {
        String resultado = "Primero -> [";
        if (!this.vacia()) {
            resultado += inicio.getDato();
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                resultado += "," + actual.getDato();
                actual = actual.getSiguiente();
            }
        }
        resultado += "]";
        return resultado;
    }

}