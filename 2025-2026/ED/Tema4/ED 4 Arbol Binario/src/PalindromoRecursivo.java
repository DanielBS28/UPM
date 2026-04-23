public class PalindromoRecursivo {

    static boolean capicua(String palabra){

        if (palabra.length() < 2){
            return true;
        }else
            return palabra.charAt(0) == palabra.charAt(palabra.length() -1) &&
                    capicua(palabra.substring(1,palabra.length()-1));

    }

    private static boolean capicua2(String palabra){

        return capicuaRec(palabra, 0 , palabra.length() -1);
    }

   private static boolean capicuaRec(String palabra, int inicio, int fin) {
        int longitud = fin - inicio +1;
        //También podria haber puesto inicio >= fin
        if (longitud < 2)
            return true;
        else
            return palabra.charAt(inicio) == palabra.charAt(fin) &&
                    capicuaRec(palabra, inicio + 1, fin - 1);

    }


        static void main() {

        System.out.println("La palabra allilla es ¿capicua? " + capicua("allilla"));
        System.out.println("La palabra oso es ¿capicua? " + capicua("oso"));
        System.out.println("La palabra sevilla es ¿capicua? " + capicua("sevilla"));

    }
}
