public class ejerciciolistasrepetidas {

    public static Lista listaInterseccion(Lista lista1, Lista lista2){

        Lista inteserccion = new Lista();
        Iterador iterador = lista1.getIterador();

        while(iterador.hasNext()) {
            int elemento = iterador.next();
                if(lista2.contiene(elemento) && !inteserccion.contiene(elemento))
                    inteserccion.insertar(elemento);
        }

        return inteserccion;
    }

    static void main() {

        Lista lista = new Lista();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);

        System.out.println(lista.toString());

        Lista lista2 = new Lista();
        lista2.insertar(4);
        lista2.insertar(1);
        lista2.insertar(3);
        lista2.insertar(4);
        lista2.insertar(0);
        System.out.println(lista2.toString());


        System.out.println(listaInterseccion(lista, lista2).toString());


    }
}
