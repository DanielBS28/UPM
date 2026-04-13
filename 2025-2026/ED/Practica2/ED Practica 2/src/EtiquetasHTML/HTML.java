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
        return palabra.length() >= 3 && palabra.charAt(0) == '<' && palabra.charAt(palabra.length() - 1) == '>' && palabra.charAt(1) != '/';
    }

    public static boolean esCierre(String palabra) {
        return palabra.length() >= 4 && palabra.charAt(0) == '<' && palabra.charAt(1) == '/' && palabra.charAt(palabra.length() - 1) == '>';
    }

    public static boolean emparejadas(String apertura, String cierre) {
        String palabraApertura = "</" + apertura.substring(1);

        return palabraApertura.equals(cierre);
    }

    public static boolean comprobarHTML(Fichero fichero) {
        Pila pila = new Pila();
        String []linea = null;
        int contadorLinea = 1;

        while((linea = fichero.leerLinea()) != null){

            for (int i = 0; i< linea.length; i++){
                if (esApertura(linea[i]))
                    pila.apilar(linea[i]);
                else if (esCierre(linea[i])) {
                    if(pila.vacia() || !emparejadas(pila.desapilar(), linea[i])){
                        System.out.println("Error en la línea: " + contadorLinea + " al leer " + linea[i]);
                        return false;
                    }
                }
                contadorLinea++;
            }
        }
        // Si al terminar de leer el fichero la pila no está vacía, faltan cierres
        if (!pila.vacia()) {
            System.out.println("Final de fuente inesperado");
            return false;
        }

        return true; // El fichero HTML está perfectamente anidado
    }

    public static boolean comprobarHTMLStack(Fichero fichero) {
        // TODO
        return false;  // Eliminar esta línea
    }


}
