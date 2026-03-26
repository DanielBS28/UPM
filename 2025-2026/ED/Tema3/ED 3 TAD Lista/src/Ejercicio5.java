import java.util.Random;

public class Ejercicio5 {

    static void main() {

        Lista lista = new Lista();

        for(int i =0; i< 10; i++)
            lista.insertar(i);

        System.out.println(lista.toString());
        lista.aniadirSumaMayoresDe(7);
        System.out.println(lista);

    }
}
