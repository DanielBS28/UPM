public class EjemploRecursividad {

    public static long factorial(int numero){

        long resultado = 0;
        if(numero == 1)
            return 1;
        else
            resultado = numero * factorial(numero -1);

        return resultado;
    }

    public static int factorial2(int numero){

        return numero <= 1 ? 1 : numero * factorial2(numero -1);
    }

    public static void verCifras(int numero){

        if(numero < 10)
            System.out.println(numero);
        else {
            verCifras(numero / 10);
            System.out.println(numero % 10);
        }
    }
    static void main() {

        System.out.println("El factorial de 7 es: " + factorial(7));
        System.out.println("El factorial de 7 es: " + factorial2(7));
        verCifras(15278);
    }
}
