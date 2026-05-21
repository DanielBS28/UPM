import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.TreeSet;

public class GrafoDinamica {

    private int numVertices;
    private boolean dirigido;
    private TreeSet<Integer>[] adyacencias;

    public GrafoDinamica(int numVertices, boolean dirigido) {
        this.dirigido = dirigido;
        this.numVertices = numVertices;
        this.adyacencias = new TreeSet[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adyacencias[i] = new TreeSet<Integer>();  // Conjuntos vacíos.
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public boolean esDirigido() {
        return dirigido;
    }


    public void insertarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            adyacencias[u].add(v);
            if (!dirigido && u != v) {
                adyacencias[v].add(u);
            }
        }
    }

    private boolean verticeEnRango(int v) {
        return (v < numVertices) && (v >= 0);
    }

    public void eliminarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            adyacencias[u].remove(v);
            if (!dirigido) {
                adyacencias[v].remove(u);
            }
        }
    }

    public boolean existeArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            return adyacencias[u].contains(v);
        } else {
            return false;
        }
    }

    public int gradoEntrada(int v) {
        int resul = 0;
        if (this.verticeEnRango(v)) {
            for (int i = 0; i < numVertices; i++) {
                if (adyacencias[i].contains(v)) {  // Buscar v en todas las listas
                    resul++;
                }
            }
        }
        return resul;

    }

    public int gradoSalida(int v) {
        if (this.verticeEnRango(v)) {
            return adyacencias[v].size();
        } else {
            return 0;
        }
    }


    // Aristas que salen o entran de v
    public int grado(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            if (!dirigido) {
                resultado = this.gradoEntrada(v);
            } else {
                resultado = this.gradoEntrada(v) + this.gradoSalida(v);
                if (this.existeArista(v, v)) {
                    resultado--;
                }
            }
        }
        return resultado;
    }


    public void mostrar() {
        System.out.println("El grafo contiene " + numVertices + " vertices");
        if (dirigido) {
            System.out.println("Es dirigido");
        } else {
            System.out.println("No es dirigido");
        }
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Aristas desde " + v + ": ");
            Iterator<Integer> iterador = adyacencias[v].iterator();
            while (iterador.hasNext()) {
                int destino = iterador.next();
                System.out.print(destino + ", ");
            }
            System.out.println();
        }
    }

    public TreeSet<Integer> recorridoProfundidad(int origen) {
        TreeSet<Integer> visitados = new TreeSet<Integer>();
        if (this.verticeEnRango(origen)) {
            // Realizar recorrido desde origen.
            recorridoProfundidadR(origen, visitados);
        }
        return visitados;
    }


    private void recorridoProfundidadR(int v, TreeSet<Integer> visitados) {
        visitados.add(v);   // Nodo v visitado
        // Recorrido desde adyacentes a v y no visitados aún.
        Iterator<Integer> it = adyacencias[v].iterator();
        while (it.hasNext()) {
            int adyacente = it.next();
            if (!visitados.contains(adyacente)) {
                this.recorridoProfundidadR(adyacente, visitados);
            }
        }
    }

    public TreeSet<Integer> recorridoAmplitud(int origen) {
        TreeSet<Integer> visitados = new TreeSet<Integer>();
        ArrayDeque<Integer> cola = new ArrayDeque<Integer>();
        cola.add(origen);    //Encolar y marcar como visitado
        visitados.add(origen);
        while (!cola.isEmpty()) {
            int vertice = cola.remove();  // Desencolar
            // Encolar adyacentes a vertice no visitados aún
            Iterator<Integer> it = adyacencias[vertice].iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (!visitados.contains(v)) {
                    cola.add(v);
                    visitados.add(v);
                }
            }

        }
        return visitados;
    }

    //Ejercicio 3.b

    public TreeSet<Integer> verticesConAdyacentesPares(){

        TreeSet<Integer> resultado = new TreeSet<>();

        for(int i = 0; i< numVertices;i++){

            if(!adyacencias[i].isEmpty()){
                Iterator<Integer> it = adyacencias[i].iterator();

                boolean valido = true;

                while(it.hasNext() && valido){
                    int destino = it.next();
                    if(destino % 2 !=0)
                        valido = false;
                }

                if(valido)
                    resultado.add(i);
            }
        }

        return resultado;
    }

}
