import java.util.TreeMap;

public class ejercicioAnagramas {

    public static boolean sonAnagramas(String cadena1, String cadena2) {

        TreeMap<Character, Integer> diccionario = new TreeMap<Character, Integer>();

        for (char c = 'a'; c <= 'z'; c++)
            diccionario.put(c, 0);

        for (int i = 0; i < cadena1.length(); i++) {

            char c = cadena1.charAt(i);
            int valor = diccionario.get(c);
            diccionario.put(c, valor + 1);
        }

        for (int i = 0; i < cadena2.length(); i++) {

            char c = cadena2.charAt(i);
            int valor = diccionario.get(c);
            diccionario.put(c, valor - 1);
        }

        char car = 'a';

        for (char c = 'a'; c <= 'z'; c++) {
            if (diccionario.get(c) != 0)
                return false;
        }
        return true;
    }


    //Ejercicio 2
    static void main() {

        System.out.println(sonAnagramas("amor", "roma"));
        System.out.println(sonAnagramas("hola", "adios"));


    }
}

