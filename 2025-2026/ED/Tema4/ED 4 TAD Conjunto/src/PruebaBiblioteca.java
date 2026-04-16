import java.util.Iterator;
import java.util.TreeSet;

public class PruebaBiblioteca {
    public static void main(String[] args) {
        TreeSet<Character> vocales = new TreeSet<Character>();
        vocales.add('a');
        vocales.add('e');
        vocales.add('i');
        vocales.add('o');
        vocales.add('u');
        if (vocales.contains('a')) {
            System.out.println("Contiene la a");
        }
        System.out.println("Número de vocales: " + vocales.size());
        vocales.remove('i');
        System.out.print("Después de borrar la i quedan: ");
        Iterator<Character> iterador = vocales.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
    }
}
