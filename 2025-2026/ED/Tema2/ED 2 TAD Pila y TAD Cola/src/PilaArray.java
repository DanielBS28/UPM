public class PilaArray {
    final static int MAXIMO = 100;  // Constante

    private int[] vector;  // Datos de la pila
    private int cima;   // Posición de la cima de la pila

    public PilaArray() {
        vector = new int[MAXIMO];
        cima = -1;    // Valor indicativo de que la pila está vacía.
    }

    public boolean vacia() {
        return cima == -1;
    }

    public void apilar(int dato) {
        if (cima == MAXIMO - 1) {
            System.out.println("Error: pila llena");
        } else {
            cima++;
            vector[cima] = dato;

        }
    }

    public int desapilar() {
        int valor;
        if (!this.vacia()) {
            valor = vector[cima];
            cima--;
        } else {
            valor = -1;
        }
        return valor;
    }

    public int getCima() {
        int valor;
        if (!this.vacia()) {
            valor = vector[cima];
        } else {
            valor = -1;
        }
        return valor;
    }

    public int getNumElementos() {
        return cima + 1;
    }

    public String toString() {
        String resultado = "Cima -> [";
        if (!this.vacia()) {
            resultado += vector[cima];
            for (int i = cima - 1; i >= 0; i--) {
                resultado += "," + vector[i];
            }
        }
        resultado += "]";
        return resultado;
    }
}
