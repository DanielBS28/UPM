import java.util.Iterator;
import java.util.TreeMap;

public class PruebasRecorrido {
    public static void main(String[] args) {
        TreeMap<Character, String> tiposVocales = new TreeMap<Character, String>();
        tiposVocales.put('a', "abierta");
        tiposVocales.put('e', "abierta");
        tiposVocales.put('i', "cerrada");
        tiposVocales.put('o', "abierta");
        tiposVocales.put('u', "cerrada");
        System.out.println("Vocales y sus tipos:");
        Iterator<Character> iterador = tiposVocales.keySet().iterator();
        while (iterador.hasNext()) {
            char vocal = iterador.next();
            String tipo = tiposVocales.get(vocal);
            System.out.println(vocal + ": " + tipo);
        }
    }

}
