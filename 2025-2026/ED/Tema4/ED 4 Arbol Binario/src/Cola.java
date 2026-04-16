public class Cola {
    private Nodo inicio, fin;
    private int numElementos;

    public Cola() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia() {   // Comprueba si la cola est� vac�a
        return inicio == null;
    }

    public void encolar(NodoArbol dato) {    // Coloca dato al final de la cola
        Nodo nuevo = new Nodo(dato, null);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        } else {
            inicio = nuevo;
        }
        fin = nuevo;
        numElementos++;
    }

    public NodoArbol desencolar() {
        NodoArbol resultado;
        if (this.vacia()) {
            resultado = null;
        } else {
            resultado = inicio.getDato();
            inicio = inicio.getSiguiente();
            if (inicio == null) {  // La cola se queda vac�a
                fin = null;
            }
            numElementos--;
        }
        return resultado;
    }

    public NodoArbol getPrimero() {
        NodoArbol resultado;
        if (this.vacia()) {
            resultado = null;
        } else {
            resultado = inicio.getDato();
        }
        return resultado;
    }

    public int getNumElementos() {
        return numElementos;
    }


}