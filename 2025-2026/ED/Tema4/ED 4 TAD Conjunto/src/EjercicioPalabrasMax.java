import java.util.Iterator;
import java.util.TreeMap;

public class EjercicioPalabrasMax {

    public static String palabraMayor(String [] palabras){

        TreeMap<String, Integer> diccionario = new TreeMap<>();

        //Relleno todo el diccionario
        for (String p : palabras) {
            if (diccionario.containsKey(p))
                diccionario.put(p, diccionario.get(p)+1);
            else
                diccionario.put(p,1);
        }

        int maxRepeticiones = 0;
        String maxPalabra = "";

        Iterator<String> it = diccionario.keySet().iterator();

        while(it.hasNext()){

            String palabra = it.next();
            int repeticiones = diccionario.get(palabra);

            if(repeticiones > maxRepeticiones){
                maxRepeticiones = repeticiones;
                maxPalabra = palabra;
            }
        }

        System.out.println("La palabra mas repetida es: " + maxPalabra +  " apariciones: " +  maxRepeticiones );

        return maxPalabra;

    }

    static void main() {

        String [] palabras = new String[] {"En", "un", "lugar", "de", "la","Mancha", "de", "cuyo"};

        System.out.println("Mas repetida " + palabraMayor(palabras));
    }
}
