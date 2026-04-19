public class Ejercicio2 {

    //Comprobar si una lista está ordenada (puede tener repetidos)

    public static boolean ordenada(Lista lista){

        boolean error = false;
        Iterador iterador = lista.getIterador();

        if(lista.getNumElementos() <= 1)
            return true;

        int anterior = iterador.next();

        while (iterador.hasNext() && !error){

            int actual = iterador.next();
            if(anterior > actual)
                error = true;
            anterior = actual;
        }

        return !error;

    }

    static void main() {

        Lista lista = new Lista();
        lista.insertar(1);
        lista.insertar(4);
        lista.insertar(4);
        lista.insertar(7);
        //No estaría ordenado si no comento la línea de abajo
        lista.insertar(3);
        lista.insertar(14);
        lista.insertar(28);

        System.out.println("Esta ordenada: " + lista.toString() + " " + ordenada(lista));



    }
}
