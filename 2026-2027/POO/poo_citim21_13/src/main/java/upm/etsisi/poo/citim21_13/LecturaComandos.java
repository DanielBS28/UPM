package upm.etsisi.poo.citim21_13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LecturaComandos {

    static boolean ejecutandoPorFichero = true;
    static Scanner teclado = new Scanner(System.in);
    static File ficheroTerminal = null;
    static BufferedReader lectorBuffer = null;

    public static void iniciar(String[] args) {

        if (args.length == 0) {
            ejecutandoPorFichero = false;
        } else {
            ficheroTerminal = new File(args[0]);
            try {
                lectorBuffer = new BufferedReader(new FileReader(ficheroTerminal));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("""
     ╔══════════════════════════════════════════════════════╗
					║         Parque de atracciones - CITIM21_13           ║
					╚══════════════════════════════════════════════════════╝
        		""");
        String comandoActual = "";

        try {
            while ((comandoActual = obtenerSiguienteComando()) != null && !comandoActual.equalsIgnoreCase("exit")) {
            	//Analizamos el comando actual
                GestorComandos.analizarComando(comandoActual);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
            comandoActual = "exit";

        }

      finalizarPrograma();
        
    }

   public  static void finalizarPrograma() {

    	try {
            System.out.println("Saliendo de la aplicación...");
			Thread.sleep(2000);
			 System.out.println("Se cerró la aplicación con exito");
		} catch (InterruptedException e) {
			System.out.println("Hubo un error en la pausa");
		}
	}

	private static String obtenerSiguienteComando() throws IOException {
        if (ejecutandoPorFichero) {
            return lectorBuffer.readLine();
        } else {
            return teclado.nextLine();
        }
    }
}