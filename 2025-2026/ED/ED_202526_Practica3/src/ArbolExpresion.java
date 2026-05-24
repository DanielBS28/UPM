public class ArbolExpresion {

    private NodoArbol raiz;

    public ArbolExpresion() {
        raiz = null;
    }

    public ArbolExpresion(char dato) {
        raiz = new NodoArbol(dato, null, null);
    }

    public ArbolExpresion(char dato, ArbolExpresion izquierdo, ArbolExpresion derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Copia idéntica del árbol de expresión
     * @return
     */
    public ArbolExpresion copy() {
        ArbolExpresion res = new ArbolExpresion();
        res.raiz = this.copy(raiz);
        return res;
    }
    private NodoArbol copy(NodoArbol nodo) {
        NodoArbol res = null;
        if (nodo != null) {
            res = new NodoArbol(nodo.getDato());
            res.setIzquierda(this.copy(nodo.getIzquierdo()));
            res.setDerecha(this.copy(nodo.getDerecho()));
        }
        return res;
    }

    // ------------------------------------------------------------------------
    // TODO Ejercicio 1
    // ------------------------------------------------------------------------
    public ArbolExpresion(String expr) {
        raiz = null;

        // TODO Ejercicio 1:
        // Construir el árbol de expresión a partir de una cadena en notación
        // postfija utilizando la estructura auxiliar Pila.
    }

    // ------------------------------------------------------------------------
    // TODO Ejercicio 2
    // ------------------------------------------------------------------------
    public void mostrarExpresion() {
        // TODO Ejercicio 2:
        // Mostrar el contenido del árbol en notación infija.
    }

    // ------------------------------------------------------------------------
    // TODO Ejercicio 3
    // ------------------------------------------------------------------------
    public Double calcularValor() {
        // TODO Ejercicio 3:
        // Calcular el valor numérico de la expresión almacenada en el árbol.
        return null;
    }

    /**
     * TODO Ejercicio 4
     * @return
     */
    public boolean hayDivisionPorCero() {
        // TODO Ejercicio 4:
        // Comprobar si existe alguna división cuyo denominador evalúa a cero.
        return false;
    }

    /**
     * TODO Ejercicio 5
     * @return
     */
    public void simplificarIdentidades() {
        // TODO Ejercicio 5:
        // Simplificar el árbol aplicando las identidades algebraicas del enunciado.
    }

    /**
     * TODO Ejercicio 6
     */
    public void podarAnulaciones() {
        // TODO Ejercicio 6:
        // Podar las ramas anuladas según las reglas del enunciado.
    }

    /**
     * TODO Ejercicio 7
     */
    public void sustituirIncognita(ArbolExpresion expr) {
        // TODO Ejercicio 7:
        // Sustituir cada aparición de la incógnita por una copia del árbol recibido.
    }
}
