package upm.etsisi.poo.citim21_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        if (args.length == 0) {
            // REQUISITO 1: Modo interactivo (Entrada estándar)
            System.out.println("Iniciando modo interactivo. Esperando comandos...");
            Scanner scanner = new Scanner(System.in);
            procesarComandos(scanner);
            
        } else if (args.length == 1) {
            // REQUISITO 2: Modo fichero (Argumento por terminal)
            String nombreFichero = args[0];
            System.out.println("Iniciando modo lectura de fichero: " + nombreFichero);
            
            try {
                File archivo = new File(nombreFichero);
                Scanner scanner = new Scanner(archivo);
                procesarComandos(scanner);
            } catch (FileNotFoundException e) {
                System.err.println("Error: No se ha encontrado el archivo " + nombreFichero);
            }
            
        } else {
            System.err.println("Uso incorrecto. Argumentos excedidos.");
        }
    }

    // Método centralizado para procesar la lógica, independientemente del origen de los datos
    private static void procesarComandos(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String comando = scanner.nextLine();
            // Lógica de procesamiento de comandos de la práctica
            System.out.println("Ejecutando: " + comando);
        }
        scanner.close();
    }
}
