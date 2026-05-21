import java.util.Iterator;
import java.util.TreeSet;

public class Ejercicio5 {


    public static int numRepetidos(int[] numeros){

        TreeSet<Integer> conjunto = new TreeSet<>();

        for (int i = 0; i < numeros.length; i++)
            conjunto.add(numeros[i]);

        Iterator<Integer> it = conjunto.iterator();


        while (it.hasNext())
            System.out.println(it.next());

        return numeros.length - conjunto.size();

    }

    static void main() {

        int [] numeros = new int[]{1,2,3,1,2,3,1,2,3};
        System.out.println("La lista tiene " +  numRepetidos(numeros)+" elementos repetidos");
    }
}
