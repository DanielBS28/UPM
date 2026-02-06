import java.util.Scanner;

public class numeroCifras {

    public static int numCifras(int numero) {

        int contador = 0;
        while (numero != 0) {
            numero = numero / 10;
            contador++;
        }

        return contador;
    }

    public static void main() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime el número y te digo cuantas cifras tiene");
        int numero = teclado.nextInt();
        if (numero > 0) {
            int cifras = numCifras(numero);
            System.out.println("El numero " + numero + " tiene " + cifras + (cifras == 1 ? " cifra" : " cifras"));
        } else
            System.out.println("Número no válido");
    }

}
