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
        Pila pila = new Pila();
        expr = expr.replace(" ", "");

        for (int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);

            //  Si el carácter es un operando (número o 'x')
            if(Utilidades.esOperando(c)) {
                NodoArbol nuevoNodo = new NodoArbol(c);
                pila.apilar(nuevoNodo);
            }//  Si el carácter es un operador (+, -, *, /)
            else if (Utilidades.esOperador(c)) {
                // Verificamos que haya al menos dos operandos en la pila para operar
                if (pila.getNumElementos() < 2) {
                    System.out.println("Hay un error en la expresión");
                    return; // Detenemos la construcción del árbol
                }

                // El primer elemento extraído es el hijo DERECHO
                NodoArbol hijoDerecho = pila.desapilar();
                // El segundo elemento extraído es el hijo IZQUIERDO
                NodoArbol hijoIzquierdo = pila.desapilar();

                // Creamos el nodo operador y lo apilamos
                NodoArbol nuevoNodo = new NodoArbol(c, hijoIzquierdo, hijoDerecho);
                pila.apilar(nuevoNodo);
            }// Si es un carácter inválido
            else
                System.out.println("Caracter " + c + " inválido");
        }

        // Verificación final de la estructura
        if (pila.getNumElementos() == 1)
            raiz = pila.desapilar();
        else
            System.out.println("Hay un error en la expresión");

    }

    // ------------------------------------------------------------------------
    // TODO Ejercicio 2
    // ------------------------------------------------------------------------
    public void mostrarExpresion() {
        if (raiz == null) {
            return;
        }

        String resultado = obtenerExpresionRec(raiz);

        if (resultado == null) {
            // El árbol está mal formado. Al ser void, informamos por consola.
            System.out.println("Error: El árbol de expresión está mal formado.");
        } else {
            // Si la raíz es un operador, el método recursivo habrá envuelto toda
            // la expresión en paréntesis. El enunciado pide que la expresión
            // completa NO esté envuelta, así que los eliminamos.
            if (Utilidades.esOperador(raiz.getDato()) && resultado.startsWith("(") && resultado.endsWith(")")) {
                resultado = resultado.substring(1, resultado.length() - 1);
            }
            System.out.println(resultado);
        }
    }

    /**
     * Método recursivo auxiliar para construir la cadena en notación infija.
     * Realiza un recorrido de orden central (Izquierda - Raíz - Derecha).
     * @return La expresión en formato String, o null si el subárbol está mal formado.
     */
    private String obtenerExpresionRec(NodoArbol nodo) {
        if (nodo == null) {
            return null;
        }

        boolean esOperando = Utilidades.esOperando(nodo.getDato());
        boolean esOperador = Utilidades.esOperador(nodo.getDato());

        // CASO BASE: Es un operando (hoja)
        if (esOperando) {
            // Validación: un operando no puede tener hijos
            if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
                return null;
            }
            return String.valueOf(nodo.getDato());
        }

        // CASO RECURSIVO: Es un operador (nodo interno)
        if (esOperador) {
            // Validación: un operador necesita obligatoriamente dos operandos/hijos
            if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                return null;
            }

            String subExpresionIzq = obtenerExpresionRec(nodo.getIzquierdo());
            String subExpresionDer = obtenerExpresionRec(nodo.getDerecho());

            // Si alguna de las ramas falló, propagamos el null hacia arriba
            if (subExpresionIzq == null || subExpresionDer == null) {
                return null;
            }

            // Envolvemos la operación en paréntesis para mantener la precedencia
            return "(" + subExpresionIzq + nodo.getDato() + subExpresionDer + ")";
        }

        // Si el carácter almacenado no es ni operando ni operador
        return null;
    }

    // ------------------------------------------------------------------------
    // TODO Ejercicio 3
    // ------------------------------------------------------------------------
    public Double calcularValor() {
        //  Si el árbol está vacío, devolver 0
        if (raiz == null) {
            return 0.0;
        }
        return calcularValorRec(raiz);
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
