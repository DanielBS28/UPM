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
    // ------------------------------------------------------------------------
    public Double calcularValor() {
        //  Si el árbol está vacío, devolver 0
        if (raiz == null) {
            return 0.0;
        }
        return calcularValorRec(raiz);
    }
    /**
     * Método recursivo auxiliar para calcular el valor de la expresión.
     * Realiza un recorrido Postorden (Izquierda - Derecha - Raíz).
     * * @param nodo El nodo actual que se está evaluando.
     * @return El resultado numérico de la evaluación, o null si hay incógnitas/errores.
     */
    private Double calcularValorRec(NodoArbol nodo) {
        // Manejo defensivo en caso de anomalía estructural
        if (nodo == null) {
            return null;
        }

        char dato = nodo.getDato();

        //  Caso Base: El nodo es un operando (hoja)
        if (Utilidades.esOperando(dato)) {
            //  Si el operando es la incógnita, el cálculo se anula
            if (dato == 'x' || dato == 'X') {
                return null;
            }
            //  Convertir el carácter numérico a Double
            return (double) Utilidades.pasarAEntero(dato);
        }

        //  Caso Recursivo: El nodo es un operador
        if (Utilidades.esOperador(dato)) {
            // Calcular primero el subárbol izquierdo y luego el derecho
            Double valorIzquierdo = calcularValorRec(nodo.getIzquierdo());
            Double valorDerecho = calcularValorRec(nodo.getDerecho());

            //  Propagación de errores. Si algún hijo devolvió null,
            // no podemos operar, así que subimos el null al nivel anterior.
            if (valorIzquierdo == null || valorDerecho == null) {
                return null;
            }

            //  Aplicamos el operador correspondiente
            switch (dato) {
                case '+':
                    return valorIzquierdo + valorDerecho;
                case '-':
                    return valorIzquierdo - valorDerecho;
                case '*':
                    return valorIzquierdo * valorDerecho;
                case '/':
                    // Control de error matemático adicional división  de 0
                    if (valorDerecho == 0.0) {
                        return null;
                    }
                    return valorIzquierdo / valorDerecho;
                default:
                    return null;
            }
        }

        // Por seguridad, si el carácter no es ni operando ni operador
        return null;
    }



    public boolean hayDivisionPorCero() {
        return hayDivisionPorCeroRec(raiz);
    }

    /**
     * Método recursivo auxiliar para buscar divisiones por cero en la estructura.
     * @param nodo El nodo actual que se está evaluando.
     * @return true si existe alguna división por cero en el subárbol, false en caso contrario.
     */
    private boolean hayDivisionPorCeroRec(NodoArbol nodo) {
        // Caso Base: Árbol vacío o llegamos a un nodo hoja (operando)
        if (nodo == null || Utilidades.esOperando(nodo.getDato())) {
            return false;
        }

        //  Comprobación recursiva de los subárboles inferiores
        boolean errorEnIzquierda = hayDivisionPorCeroRec(nodo.getIzquierdo());
        boolean errorEnDerecha = hayDivisionPorCeroRec(nodo.getDerecho());

        // Si ya se ha detectado el error en alguna rama inferior, propagamos el true
        if (errorEnIzquierda || errorEnDerecha) {
            return true;
        }

        // Si el nodo actual es una división
        if (nodo.getDato() == '/') {
            // Evaluamos matemáticamente todo el subárbol que actúa como denominador
            // Aprovechamos el método privado que construimos en el Ejercicio 3
            Double valorDenominador = calcularValorRec(nodo.getDerecho());

            // Si el valor no es null (no hay incógnitas) y es exactamente 0.0
            if (valorDenominador != null && valorDenominador == 0.0) {
                return true;
            }
        }

        // Si hemos superado todas las validaciones, este subárbol es seguro
        return false;
    }

    /**
     */
    public void simplificarIdentidades() {
        // Actualizamos la raíz global por si la simplificación llega hasta lo más alto
        raiz = simplificarIdentidadesRec(raiz);
    }
    /**
     * Método recursivo para simplificar el árbol mediante identidades algebraicas.
     * Utiliza un recorrido Postorden para reestructurar de abajo hacia arriba.
     * * @param nodo El nodo actual que se está evaluando y posiblemente reemplazando.
     * @return El nodo resultante tras aplicar la simplificación (puede ser el mismo, o su hijo).
     */
    private NodoArbol simplificarIdentidadesRec(NodoArbol nodo) {
        //  Caso Base: Árbol vacío o rama finalizada
        if (nodo == null) {
            return null;
        }

        // Si el nodo es un operando (hoja), no hay operación que simplificar
        if (Utilidades.esOperando(nodo.getDato())) {
            return nodo;
        }

        // Fase de Descenso (Postorden):
        // Simplificamos primero las ramas inferiores y actualizamos los punteros del nodo actual.
        nodo.setIzquierda(simplificarIdentidadesRec(nodo.getIzquierdo()));
        nodo.setDerecha(simplificarIdentidadesRec(nodo.getDerecho()));

        //  Fase de Evaluación y Puenteo
        char operador = nodo.getDato();
        NodoArbol izq = nodo.getIzquierdo();
        NodoArbol der = nodo.getDerecho();

        // Verificamos si los hijos contienen los valores literales '0' o '1'
        boolean izqEsCero = (izq != null && izq.getDato() == '0');
        boolean derEsCero = (der != null && der.getDato() == '0');
        boolean izqEsUno  = (izq != null && izq.getDato() == '1');
        boolean derEsUno  = (der != null && der.getDato() == '1');

        // Evaluamos las 6 reglas algebraicas
        if (operador == '+') {
            if (izqEsCero) return der; // 0 + x -> Devuelve subárbol derecho
            if (derEsCero) return izq; // x + 0 -> Devuelve subárbol izquierdo
        }
        else if (operador == '-') {
            if (derEsCero) return izq; // x - 0 -> Devuelve subárbol izquierdo
        }
        else if (operador == '*') {
            if (izqEsUno) return der;  // 1 * x -> Devuelve subárbol derecho
            if (derEsUno) return izq;  // x * 1 -> Devuelve subárbol izquierdo
        }
        else if (operador == '/') {
            if (derEsUno) return izq;  // x / 1 -> Devuelve subárbol izquierdo
        }

        // Si no se cumplió ninguna regla, el nodo se mantiene en su sitio
        return nodo;
    }

    public void podarAnulaciones() {
        // Actualizamos la raíz global por si la poda anula el árbol por completo
        raiz = podarAnulacionesRec(raiz);
    }
    /**
     * Método recursivo para podar ramas anuladas por multiplicaciones o divisiones por cero.
     * @param nodo El nodo actual que se está evaluando.
     * @return El nodo resultante tras aplicar la poda.
     */
    private NodoArbol podarAnulacionesRec(NodoArbol nodo) {
        //  Caso Base: Árbol vacío o rama finalizada
        if (nodo == null) {
            return null;
        }

        // Si el nodo es un operando (hoja), no hay operación que podar
        if (Utilidades.esOperando(nodo.getDato())) {
            return nodo;
        }

        // Fase de Descenso (Postorden):
        // Procesamos primero las ramas inferiores para colapsarlas si es posible.
        nodo.setIzquierda(podarAnulacionesRec(nodo.getIzquierdo()));
        nodo.setDerecha(podarAnulacionesRec(nodo.getDerecho()));

        //  Fase de Evaluación de Poda
        char operador = nodo.getDato();
        NodoArbol izq = nodo.getIzquierdo();
        NodoArbol der = nodo.getDerecho();

        // Comprobamos si los hijos directos son literalmente el valor '0'
        boolean izqEsCero = (izq != null && izq.getDato() == '0');
        boolean derEsCero = (der != null && der.getDato() == '0');

        // 5. Aplicación de las reglas de anulación mediante mutación del nodo
        if (operador == '*') {
            //  x * 0 -> 0  ||  0 * x -> 0
            if (izqEsCero || derEsCero) {
                nodo.setDato('0');        // El operador se convierte en un operando '0'
                nodo.setIzquierda(null);  // Cortamos la rama izquierda
                nodo.setDerecha(null);    // Cortamos la rama derecha
            }
        }
        else if (operador == '/') {
            //  0 / x -> 0
            if (izqEsCero) {
                nodo.setDato('0');        // El operador se convierte en un operando '0'
                nodo.setIzquierda(null);  // Cortamos la rama izquierda (que ya era '0')
                nodo.setDerecha(null);    // Cortamos la rama derecha entera
            }
        }

        // Devolvemos el nodo (que puede seguir siendo un operador, o haber mutado a hoja)
        return nodo;
    }

    public void sustituirIncognita(ArbolExpresion sustitucion) {
        // En caso de que el árbol de sustitución sea nulo, se aborta la operación
        if (sustitucion == null || sustitucion.raiz == null) {
            return;
        }

        // Se actualiza la raíz global por si el propio árbol base era únicamente una 'x'
        raiz = sustituirIncognitaRec(raiz, sustitucion);
    }

    /**
     * Método recursivo para localizar y sustituir las incógnitas por copias profundas de un subárbol.
     * @param nodo El nodo actual que se está evaluando.
     * @param sustitucion El árbol de expresión que contiene el subárbol a insertar.
     * @return El nodo original, o la raíz del nuevo subárbol si se produjo una sustitución.
     */
    private NodoArbol sustituirIncognitaRec(NodoArbol nodo, ArbolExpresion sustitucion) {
        //  Caso Base: Se alcanzó el final de una rama
        if (nodo == null) {
            return null;
        }

        //Condición de Sustitución: Se encuentra la incógnita
        if (nodo.getDato() == 'x' || nodo.getDato() == 'X') {
            // Se genera una copia profunda e independiente del árbol de sustitución
            ArbolExpresion copiaIndependiente = sustitucion.copy();

            // Al estar dentro de la clase ArbolExpresion, podemos acceder a la variable privada 'raiz'
            // de la instancia 'copiaIndependiente'
            return copiaIndependiente.raiz;
        }

        //  Fase Recursiva: Si no es una 'x', procesamos sus hijos y actualizamos los enlaces
        nodo.setIzquierda(sustituirIncognitaRec(nodo.getIzquierdo(), sustitucion));
        nodo.setDerecha(sustituirIncognitaRec(nodo.getDerecho(), sustitucion));

        // Se devuelve el nodo inalterado para reconstruir el nivel superior
        return nodo;
    }
}
