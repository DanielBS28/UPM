import java.util.TreeSet;

public class PruebasEjercicio3 {

    static void main() {

        GrafoDinamica grafo = new GrafoDinamica(5,true);

        grafo.insertarArista(0,1);
        grafo.insertarArista(0,1);

        grafo.insertarArista(1,2);
        grafo.insertarArista(1,4);

        grafo.insertarArista(2,3);

        grafo.insertarArista(3,4);

        TreeSet<Integer> conjunto = grafo.verticesConAdyacentesPares();

        for(int i : conjunto)
            System.out.print(i+",");


    }
}
