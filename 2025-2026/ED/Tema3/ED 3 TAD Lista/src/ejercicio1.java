public class ejercicio1 {

    public static boolean sonDistintos(Lista lista){

        Lista distintos = new Lista();
        Iterador iterador = lista.getIterador();
        boolean repetido = false;

        while (iterador.hasNext() && !repetido){
            int elemento = iterador.next();
                if(distintos.contiene(elemento)) //Comparo con la lista de elementos distintos(Si está ahí entonces es un elemento repetido.
                    repetido = true;
                else
                    distintos.insertar(elemento); //Los que sean distinto me los guardo en una lista Auxiliar
        }
        return repetido;
    }

    public static boolean SonDistintos2(Lista lista){

        //Comparo con una función que me devuelve una lista de no repetidos, si el tamaño es igual al de la lista que le paso a la función SonDistintos2 entonces no hay repetidos.
       return  AlgoritmoSinRepetir.sinRepetir(lista).getNumElementos() == lista.getNumElementos();
    }

    static void main() {

        Lista lista = new Lista();

        for(int i =0; i< 10; i++)
            lista.insertar(i);

        System.out.println("Lista 1 método 1 Son todos distintos: " + lista.toString() + !sonDistintos(lista));
        System.out.println("Lista 1 método 2 Son todos distintos: " + lista.toString() + !sonDistintos(lista));
        lista.insertar(5);
        System.out.println("Lista 2  método 2 Son todos distintos: " + lista.toString() + !sonDistintos(lista));
        System.out.println("Lista 2  método 2 Son todos distintos: " + lista.toString() + !sonDistintos(lista));






    }
}
