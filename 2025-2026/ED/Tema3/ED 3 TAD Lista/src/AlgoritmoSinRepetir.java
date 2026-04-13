import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AlgoritmoSinRepetir {
    public static Lista sinRepetir(Lista lista) {
        Lista resultado = new Lista();
        Iterador iterador = lista.getIterador();
        while (iterador.hasNext()) {
            int elemento = iterador.next();
            if (!resultado.contiene(elemento)) {
                resultado.insertar(elemento);
            }
        }
        return resultado;
    }

    public static ArrayList<Integer> sinRepetirBib(ArrayList<Integer> lista) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        Iterator<Integer> iterador = lista.iterator();
        while (iterador.hasNext()) {
            int elemento = iterador.next();
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public static ArrayList<Integer> sinRepetirBib2(ArrayList<Integer> lista) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for (int elemento : lista) {
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }
    public static LinkedList<Integer> sinRepetir(LinkedList<Integer> lista) {
       LinkedList <Integer> resultado = new LinkedList<Integer>();
       Iterator<Integer> iterador = lista.iterator();
        while (iterador.hasNext()) {
            int elemento = iterador.next();
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }



    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(4);
        lista.insertar(3);
        lista.insertar(7);
        lista.insertar(4);
        lista.insertar(7);
        System.out.println("Lista original: " + lista.toString());
        Lista listaNoRepetidos = sinRepetir(lista);
        System.out.println("Lista de elementos sin repetir: " + listaNoRepetidos.toString());

        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(4);
        lista2.add(3);
        lista2.add(7);
        lista2.add(4);
        lista2.add(7);
        System.out.println("Lista original: " + lista2.toString());
        ArrayList<Integer> listaNoRepetidos2 = sinRepetirBib(lista2);
        System.out.println("Lista de elementos sin repetir: " + listaNoRepetidos2.toString());

        LinkedList <Integer> lista3= new LinkedList<Integer>();

        lista3.add(4);
        lista3.add(3);
        lista3.add(7);
        lista3.add(4);
        lista3.add(7);

        System.out.println(lista3.toString());
        System.out.println(sinRepetir(lista3).toString());

        int datos[] = new int[]{1,4,6,3,2,5};

        int suma = 0;
        for(int i : datos)
            suma += i;

        System.out.println(suma);
    }

}
