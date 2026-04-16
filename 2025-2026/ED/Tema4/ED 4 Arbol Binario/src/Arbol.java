import java.util.ArrayDeque;

public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(int dato) {
        raiz = new NodoArbol(dato, null, null);
    }

    public Arbol(int dato, Arbol izquierdo, Arbol derecho) {
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

    public void amplitud2() {
        ArrayDeque<NodoArbol> cola = new ArrayDeque<NodoArbol>();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                NodoArbol nodo = cola.remove();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.add(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.add(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }


    //Ejemplo: método que recorre el árbol para determinar si contiene un dato.
    public boolean contiene(int valor) {
        return this.contieneRec(raiz, valor);
    }

    private boolean contieneRec(NodoArbol nodo, int valor) {
        // Búsqueda por preorden
        boolean resultado;
        if (nodo == null) {
            resultado = false;
        } else if (nodo.getDato() == valor) {
            resultado = true;
        } else {
            resultado = this.contieneRec(nodo.getIzquierdo(), valor);
            if (resultado == false) {
                resultado = this.contieneRec(nodo.getDerecho(), valor);
            }
        }
        return resultado;
    }

    private boolean contieneRec2(NodoArbol nodo, int valor) {
        boolean resultado;
        if (nodo == null) {
            resultado = false;
        } else {
            resultado = nodo.getDato() == valor ||
                    this.contieneRec2(nodo.getIzquierdo(), valor) ||
                    this.contieneRec2(nodo.getDerecho(), valor);
        }
        return resultado;
    }


}
