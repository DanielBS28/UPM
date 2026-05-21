import java.util.Iterator;
import java.util.TreeSet;

public class Pruebas {
    public static void main(String[] args) {
        final int VERTICES = 6;
        // Grafo de 6 vértices dirigido
        GrafoMA grafo = new GrafoMA(VERTICES, true);
        //GrafoDinamica grafo = new GrafoDinamica(VERTICES, true);

        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 3);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(1, 4);
        grafo.insertarArista(2, 0);
        grafo.insertarArista(3, 2);
        grafo.insertarArista(4, 3);
        grafo.insertarArista(5, 4);
        grafo.mostrar();
        System.out.println("Grado de entrada del vértice 3: " + grafo.gradoEntrada(3));
        System.out.println("Grado de salida del vértice 3: " + grafo.gradoSalida(3));
        System.out.println("Grado del vértice 3: " + grafo.grado(3));
        System.out.println("----------------------- ");

        // Pruebas de recorrido
        TreeSet<Integer> alcanzados;
        System.out.println("Recorrido en profundidad desde 0:  ");
        alcanzados = grafo.recorridoProfundidad(0);
        Iterator<Integer> iterador = alcanzados.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
        System.out.println("\n----------------------------");

        System.out.println("Recorrido en profundidad desde 5:  ");
        alcanzados = grafo.recorridoProfundidad(5);
        iterador = alcanzados.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
        System.out.println("\n----------------------------");

        System.out.println("Recorrido en Amplitud desde 0:  ");
        alcanzados = grafo.recorridoAmplitud(0);
        iterador = alcanzados.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
        System.out.println("\n----------------------------");

        System.out.println("Recorrido en Amplitud desde 5:  ");
        alcanzados = grafo.recorridoAmplitud(5);
        iterador = alcanzados.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
        System.out.println("\n----------------------------");

        //Es el grado de las transparencias.
        grafo.existeCaminoCorto(1,3);
        grafo.existeCaminoCorto(4,0);
        grafo.existeCaminoCorto(1,5);

    }
}
