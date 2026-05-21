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

    //Ejercicio 1, apartado a.

    public int numDatos(){
        return numDatosRec(raiz);
    }

    private int numDatosRec(NodoArbol raiz) {

        if(raiz == null)
            return 0;
        else
            return 1 + numDatosRec(raiz.getDerecho()) + numDatosRec(raiz.getIzquierdo());
        //En cada llamada le sumo 1. Y cada vez que subo para arriba le devuelvo los que tenía abajo
    }

    //Ejercicio 1, apartado b.

    public int numDatosIterativo() {
        Cola cola = new Cola();
        int contador = 0;
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                contador++;
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        return contador;
    }

    //Ejercicio 1, apartado d

    public int numHojas(){
        return numHojasRec(raiz);
    }

    private int numHojasRec(NodoArbol raiz) {
        int resultado = 0;
        if(raiz == null)
            resultado = 0;
        else {
            if (raiz.getIzquierdo() == null && raiz.getDerecho() == null)
                resultado = 1;
            else
                resultado = numHojasRec(raiz.getIzquierdo()) + numHojasRec(raiz.getDerecho());
        }
        return resultado;
    }

    //Ejercicio 1, apartado i
    public int altura(){
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol raiz) {

        if(raiz == null)
            return 0;
        else
            return 1+ Math.max(alturaRec(raiz.getIzquierdo()), alturaRec(raiz.getDerecho()));
    }

    // Ejercicio 1, apartado g

    public void preOrdenNivel() {
        System.out.print("Preorden: ");
        this.preOrdenNivelRec(raiz,1);
        System.out.println();
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " en nivel: "+ nivel);
            this.preOrdenNivelRec(nodo.getIzquierdo(), nivel+1);
            this.preOrdenNivelRec(nodo.getDerecho(), nivel +1);
        }
    }

    //Ejercicio 1 apartado h.

    public int sumaDatosNivel(int nivel){

        return sumaDatosNivelRec(nivel, raiz, 1);
    }


    public int sumaDatosNivelRec(int nivel, NodoArbol nodo, int nivelNodo){

        if(nodo == null)
            return 0;
        else if (nivelNodo == nivel)
            return nodo.getDato();
        else // Nivel nodo < nivel
            return sumaDatosNivelRec(nivel, nodo.getIzquierdo(), nivelNodo+1) +
                    sumaDatosNivelRec(nivel, nodo.getDerecho(), nivelNodo+1);
    }

    //Apartado l

    public void invertir(){
        invertirRec(this.raiz);
    }

    private void invertirRec(NodoArbol nodo) {

        if(nodo == null){
        }else {

            //Intercambiar los hijos
            NodoArbol aux = nodo.getDerecho();
            nodo.setDerecho(nodo.getIzquierdo());
            nodo.setIzquierdo(aux);

            //Cambiar árboles de forma recursiva (El dibujo)
            invertirRec(nodo.getIzquierdo());
            invertirRec(nodo.getDerecho());
        }
    }

    //Ejercicio 1 apartado m
    public boolean esUnivalor(){
        return esUnivalorRec(raiz, raiz.getDato());
    }

    private boolean esUnivalorRec(NodoArbol nodo, int dato) {

        if(nodo == null)
            return true;
        else if(nodo.getDato() == dato)
            return esUnivalorRec(nodo.getDerecho(),dato) && esUnivalorRec(nodo.getIzquierdo(),dato);
        else
            return false;
    }


}
