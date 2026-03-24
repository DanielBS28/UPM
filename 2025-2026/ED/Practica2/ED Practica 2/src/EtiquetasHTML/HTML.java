package EtiquetasHTML;

import java.util.Scanner;
import java.util.Stack;

public class HTML {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el nombre del fichero: ");
        String nombreFichero = teclado.nextLine();
        Fichero fichero = new Fichero(nombreFichero);
        if (fichero.valido()) {
            System.out.println("Prueba con Pila:");
            if (comprobarHTML(fichero)) {
                System.out.println("Correcto");
            }
        }
        fichero.cerrar();
        fichero = new Fichero(nombreFichero);
        if (fichero.valido()) {
            System.out.println("Prueba con Stack:");
            if (comprobarHTMLStack(fichero)) {
                System.out.println("Correcto");
            }
        }
        fichero.cerrar();
    }

    public static boolean esApertura(String palabra) {
        // TODO
        return false;  // Eliminar esta línea
    }

    public static boolean esCierre(String palabra) {
        // TODO
        return false;  // Eliminar esta línea
    }

    public static boolean emparejadas(String apertura, String cierre) {
        // TODO
        return false;  // Eliminar esta línea
    }

    public static boolean comprobarHTML(Fichero fichero) {
        // TODO
        return false;  // Eliminar esta línea
    }

    public static boolean comprobarHTMLStack(Fichero fichero) {
        // TODO
        return false;  // Eliminar esta línea
    }


}
