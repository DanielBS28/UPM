public class identicas {

    public static boolean identicas(Lista lista1, Lista lista2) {

        // 1. Filtro rápido (Edge case): Si no miden lo mismo, es imposible que sean idénticas.
        // Esto nos ahorra recorrer las listas si una tiene 1000 elementos y la otra 5.
        if (lista1.getNumElementos() != lista2.getNumElementos()) {
            return false;
        }

        // 2. Instanciamos DOS iteradores, uno para cada lista
        Iterador it1 = lista1.getIterador();
        Iterador it2 = lista2.getIterador();

        // 3. Recorremos ambas a la par. Como ya sabemos que miden lo mismo,
        // basta con preguntar si it1 tiene siguiente.
        while (it1.hasNext()) {

            int elem1 = it1.next();
            int elem2 = it2.next();

            // En el instante en que dos elementos en la misma posición no coincidan,
            // abortamos y devolvemos false.
            if (elem1 != elem2) {
                return false;
            }
        }

        // 4. Si el bucle termina sin problemas, son idénticas
        return true;
    }
}
