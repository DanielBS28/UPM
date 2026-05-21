public class EjercicioTraspuesto {

    public static GrafoMA grafoTraspuesto(GrafoMA grafo){

        GrafoMA grafoTraspuesto = new GrafoMA(grafo.getNumVertices(), grafo.esDirgido());

        for (int i =0; i<grafo.getNumVertices();i++){
            for (int j = 0; j < grafo.getNumVertices(); j++) {
                if(grafo.existeArista(i,j)){
                    //El que me dan no lo toco, hago uno nuevo.
                    grafoTraspuesto.insertarArista(j,i);
                }
            }
        }

        return grafoTraspuesto;

    }
    static void main(String[] args) {

        GrafoMA grafo = new GrafoMA(5, true);
        grafo.insertarArista(0,1);
        grafo.insertarArista(4,1);
        grafo.insertarArista(3,1);
        grafo.insertarArista(4,3);
        grafo.insertarArista(3,0);
        grafo.insertarArista(2,3);
        grafo.insertarArista(2,0);

        grafo.mostrar();
        GrafoMA grafo2 = grafoTraspuesto(grafo);
        System.out.println("Grafo traspusto: ");
        grafo2.mostrar();


    }
}
