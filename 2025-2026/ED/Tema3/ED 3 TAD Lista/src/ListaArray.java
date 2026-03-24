public class ListaArray {
    private static final int CAPACIDAD_INICIAL = 5;

    private int[] elementos;
    private int numElementos;
    private int capacidad;

    // Inicializa una lista vacía (sin elementos)
    public ListaArray() {
        elementos = new int[CAPACIDAD_INICIAL];
        capacidad = CAPACIDAD_INICIAL;
        numElementos = 0;
    }

    // Determina si la lista está vacía o no (sin elementos)
    public boolean vacia() {
        return numElementos == 0;
    }

    // Añade un nuevo dato al final de la lista
    public void insertar(int dato) {
        if (numElementos == capacidad) {   // No cabe el dato
            this.doblarCapacidad();
        }
        elementos[numElementos] = dato;
        numElementos++;
    }

    // Duplica el tamaño del array
    private void doblarCapacidad() {
        capacidad = capacidad * 2;
        int[] elementosNuevo = new int[capacidad];
        for (int i = 0; i < numElementos; i ++) {
            elementosNuevo[i] = elementos[i];
        }
        elementos = elementosNuevo;
    }


    // Devuelve el elemento que ocupa una posicion dada.
    // Si no existe la posición, devuelve -1
    public int getElemento(int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return -1;
        } else {
            return elementos[posicion];
        }
    }

    // Almacena elemento en la posicion indicada por posicion
    // Si la posición es incorrecta, devuelve false
    public boolean setElemento(int dato, int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return false;
        } else {
            elementos[posicion] = dato;
            return true;
        }
    }

    // Borra la primera ocurrencia del parámetro dato (si existe)
    public boolean borrar(int dato) {
        int actual = 0;
        boolean encontrado = false;
        while (actual < numElementos && !encontrado) {
            if (elementos[actual] == dato) {
                encontrado = true;
            } else {
                actual++;
            }
        }
        if (encontrado) {  // Borrar actual
            for (int i = actual; i < numElementos - 1; i++) {
                elementos[i] = elementos[i + 1];   //Rellenar hueco dejado por actual
            }
            numElementos--;
            return true;
        } else {
            return false;
        }
    }

    // Devuelve la primera posición en la que se encuentra el parámetro dato (si existe)
    public int posicion(int dato) {
        int actual = 0;
        boolean encontrado = false;
        while (actual < numElementos && !encontrado) {
            if (elementos[actual] == dato) {
                encontrado = true;
            } else {
                actual++;
            }
        }
        if (encontrado) {
            return actual;
        } else {
            return -1;
        }
    }

    // Determina si el parámetro dato existe en la lista.
    public boolean contiene(int dato) {
        return this.posicion(dato) >= 0;
    }

    // Devuelve el número de elementos que tiene la lista
    public int getNumElementos() {
         return numElementos;
    }

    // Devuelve una representación de la lista en forma de String.
    public String toString() {
        String resultado = "[";
        if (!this.vacia()) {
            resultado += elementos[0];
            for (int i = 1; i < numElementos; i++) {
                resultado += "," + elementos[i];
            }
        }
        resultado += "]";
        return resultado;
    }

}
