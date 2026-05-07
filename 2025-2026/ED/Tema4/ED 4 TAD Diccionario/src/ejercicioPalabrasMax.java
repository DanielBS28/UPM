import java.util.TreeMap;

public class ejercicioPalabrasMax {

    //Ejercicio 3

    public static String palabraMayor(String [] palabras){

        TreeMap <String, Integer> diccionario = new TreeMap<>();

        int maxRepeticiones = 0;
        String maxRepetida = "";

        for (String p : palabras) {

            int veces = 0;
            if (diccionario.containsKey(p)) {
                veces = diccionario.get(p) + 1;
            } else
                veces = 1;

            if (veces > maxRepeticiones) {
                maxRepeticiones = veces;
                maxRepetida = p;
            }
            diccionario.put(p,veces);
        }
            System.out.println("La palabra mas repetida " +  maxRepetida + " ha salido " +  maxRepeticiones +" veces");
            return maxRepetida;

    }

    static void main() {

        String [] palabras = new String[] {"En", "un", "lugar", "de", "la","Mancha", "de", "cuyo"};

        System.out.println("Mas repetida " + palabraMayor(palabras));
    }
}
