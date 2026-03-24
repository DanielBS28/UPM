public class Ejercicio4 {

    public static boolean esPalindromo(String cadena){
        int i = 0;
        boolean palindromo = true;

        while (i<cadena.length()/2 && palindromo){

            if(cadena.charAt(i) != cadena.charAt(cadena.length()-i-1)){
                palindromo = false;
            }
            i++;
        }

            return palindromo;
    }

    public static boolean esPalindromo2(String cadena){

        Pila pila = new Pila();
        boolean palindromo = true;

        for (int i = 0; i < cadena.length(); i++) {
            pila.apilar(cadena.charAt(i));
        }

        int i =0;
        while (i < cadena.length()&& palindromo){

            if(cadena.charAt(i) != pila.desapilar())
                palindromo = false;

            i++;

        }

        return palindromo;
    }

    static void main() {

        String texto = "allivessevilla";
        System.out.println("Es palindromo: " + texto +" "+ esPalindromo(texto));
        System.out.println("Es palindromo: " + texto +" "+ esPalindromo2(texto));

    }
}
