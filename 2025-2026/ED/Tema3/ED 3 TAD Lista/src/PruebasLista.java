public class PruebasLista {

    public static void main(String[] args) {
        Lista lista = new Lista();
        for (int i = -3; i < 3; i++) {
            lista.insertar(i);
            lista.insertar(i * i);
        }
        System.out.println(lista.toString());

        int positivos = 0;
        for (int i = 0; i < lista.getNumElementos(); i++) {
            if (lista.getElemento(i) > 0) {
                positivos += 1;
            }
        }
        System.out.println("El número de positivos es: " + positivos);

        Iterador iterador = lista.getIterador();
        positivos = 0;

        while (iterador.hasNext()) {
            int dato = iterador.next();
            if (dato > 0) {
                positivos++;
            }
        }
        System.out.println("Con iterador. El número de positivos es: " + positivos);
    }


}

