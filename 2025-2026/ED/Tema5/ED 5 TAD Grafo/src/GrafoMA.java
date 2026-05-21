import java.util.ArrayDeque;
import java.util.TreeSet;

public class GrafoMA {
    private int numVertices;          // Número de vértices.
    private boolean dirigido;
    private boolean[][] matrizAdy;    // Matriz de adyacencias del grafo.

    public GrafoMA(int numVertices, boolean dirigido) { // Grafo sin aristas
        this.dirigido = dirigido;
        this.numVertices = numVertices;
        matrizAdy = new boolean[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                matrizAdy[i][j]=false;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public boolean esDirgido() {
        return dirigido;
    }

    public void insertarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            matrizAdy[u][v] = true;
            if (!dirigido) {
                matrizAdy[v][u] = true;
            }
        }
    }

    private boolean verticeEnRango(int v) {
        return v < numVertices && v >= 0;
    }


    public void eliminarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            matrizAdy[u][v] = false;
            if (!dirigido) {
                matrizAdy[v][u] = false;
            }
        }
    }

    public boolean existeArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            return matrizAdy[u][v];
        } else {
            return false;
        }
    }

    public int gradoEntrada(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            for (int i = 0; i < numVertices; i++) {     //Recorrer columna v
                if (matrizAdy[i][v]) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    public int gradoSalida(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            for (int j = 0; j < numVertices; j++) {     //Recorrer fila v
                if (matrizAdy[v][j]) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

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
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public TreeSet<Integer> recorridoProfundidad(int origen) {
        TreeSet<Integer> visitados = new TreeSet<Integer>();
        if (this.verticeEnRango(origen)) {
            recorridoProfundidadR(origen, visitados);
        }
        return visitados;
    }


    private void recorridoProfundidadR(int v, TreeSet<Integer> visitados) {
        visitados.add(v);   // Nodo v visitado
        // Recorrido desde adyacentes a v y no visitados aún.
        for (int i = 0; i < this.getNumVertices(); i++) {
            if (this.existeArista(v, i) && !visitados.contains(i)) {
                recorridoProfundidadR(i, visitados);
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
            // Encolar adyacentes a vertice y no visitados aún
            for (int j = 0; j < this.getNumVertices(); j++) {
                if (this.existeArista(vertice, j) && !visitados.contains(j)) {
                    cola.add(j);  // Encolar y marcar como visitado
                    visitados.add(j);
                }
            }
        }
        return visitados;
    }

    //Ejercicio 2 apartado b

    public boolean existeCaminoCorto(int u, int v){

        boolean existe = false;

        if(u >= 0 && u < numVertices && v>=0 && v < numVertices){

            //Camino de longitud 1
            if(matrizAdy[u][v]){
                existe = true;
            }else {
                int i = 0;
                while(i < numVertices && !existe){
                    //i es una arista puente entre u y v, si existe entre ambas es que existe un camino de longitud 2
                    if(matrizAdy[u][i]&&matrizAdy[i][v])
                        existe = true;
                    i++;
                }
            }
        }


        return existe;

    }

}
