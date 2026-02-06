import java.util.Scanner;
public class Ejercicio {

    public static void visualizarDivisores(int numero){

        String divisores = "";

        for(int i = 1 ; i < numero; i++){
            if(numero % i == 1){
                divisores += i + " ,";
            }
        }
        if(divisores != "")
            divisores = divisores.substring(0, divisores.length()-2);

        System.out.println("El número " + numero +" tiene los siguientes divisores: " + divisores);
    }

    public static void main(String[] agrs) {
        int numero;
        Scanner lectura = new Scanner(System.in);
        do {
            System.out.print(
                    "Introduzca un valor entero positivo (0 para terminar): ");
            numero = lectura.nextInt();
            if (numero < 0) {
                System.out.println("Número no válido");
            } else {
                if (numero > 0) {
                    visualizarDivisores(numero);
                }
            }
        } while (numero != 0);
    }
}

