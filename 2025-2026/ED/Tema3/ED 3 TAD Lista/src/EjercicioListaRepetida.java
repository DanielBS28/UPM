public class EjercicioListaRepetida {

    public static boolean mismoContenido(Lista lista1, Lista lista2) {

        // 1. Filtro rápido: Si no tienen la misma cantidad de elementos,
        // es imposible que tengan el mismo contenido.
        if (lista1.getNumElementos() != lista2.getNumElementos()) {
            return false;
        }

        // 2. Creamos una lista auxiliar para no modificar las listas originales.
        Lista copia = new Lista();
        Iterador iterador = lista1.getIterador();

        // 3. Volcamos todo el contenido de lista1 en nuestra lista 'copia'.
        // Así podremos destruir/borrar elementos de la copia sin alterar lista1.
        while (iterador.hasNext()) {
            int elemento = iterador.next();
            copia.insertar(elemento);
        }

        // 4. Preparamos el iterador para recorrer la segunda lista.
        iterador = lista2.getIterador();
        boolean resultado = true;

        // 5. Recorremos lista2. El bucle se detendrá si llegamos al final
        // o si 'resultado' pasa a ser false (optimización de salida temprana).
        while (iterador.hasNext() && resultado) {

            int elemento = iterador.next();

            // Intentamos borrar el elemento actual de lista2 dentro de nuestra 'copia'.
            // Si borrar() devuelve 'false', significa que ese elemento NO estaba en la copia
            // (o que ya hemos agotado todas sus apariciones si estaba repetido).
            if (!copia.borrar(elemento)) {
                resultado = false; // Marcamos que no son iguales y esto romperá el bucle
            }
        }

        // 6. Si logramos vaciar la copia emparejando todos los elementos, devolverá true.
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
