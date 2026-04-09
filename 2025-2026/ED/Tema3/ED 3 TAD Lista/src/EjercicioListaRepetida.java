public class EjercicioListaRepetida {

    public static boolean mismoContenido(Lista lista1, Lista lista2){

        if(lista1.getNumElementos() != lista2.getNumElementos())
            return false;

        boolean iguales = false;
        Lista copia = new Lista();
        Iterador iterador = lista1.getIterador();

        while(iterador.hasNext()){
            int elemento = iterador.next();
            copia.insertar(elemento);

        }
        iterador = lista2.getIterador();
        boolean resultado = true;
        while(iterador.hasNext() && resultado){
            int elemento = iterador.next();
            if(!copia.borrar(elemento))
                resultado = false;
        }
        return resultado;

    }

    static void main() {

        Lista lista1 = new Lista();
        lista1.insertar(3);
        lista1.insertar(4);
        lista1.insertar(1);

        Lista lista2 = new Lista();

        lista2.insertar(3);
        lista2.insertar(1);
        lista2.insertar(4);

        System.out.println(lista1.toString());
        System.out.println(lista2.toString());

        System.out.println("Lista repetida: " + mismoContenido(lista1,lista2));


    }
}
