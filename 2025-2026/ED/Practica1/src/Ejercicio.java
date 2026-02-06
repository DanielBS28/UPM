import java.util.Scanner;
public class Ejercicio {

    public static void visualizarDivisores(int numero){

        String divisores = "";

        //También podría haber llegado hasta la raiz cuadrada y tener el divisor y el cociente
        for(int i = 2 ; i <= numero/2; i++){
            if(numero % i == 0){
                divisores += i + ", ";
            }
        }
        if(divisores != "") {
            divisores = divisores.substring(0, divisores.length() - 2);
            System.out.println("El número " + numero +" tiene los siguientes divisores: " + divisores);
        }
        else
            System.out.println("El número " + numero + " no tiene divisores");

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

