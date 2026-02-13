import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {
    private BufferedReader entrada;

    public Fichero(String nombre) {
        try {
            entrada = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado " + nombre);
        }
    }

    public String[] leerDatos() {
        String[] resultado = null;
        if (entrada != null) {
            try {
                String linea = entrada.readLine();
                if (linea != null) {
                    resultado = linea.split(", ");
                }
            } catch (IOException es) {
                System.out.println("Error en fichero ");
            }
        }
        return resultado;
    }

    public double[] leerNotas() {
        double[] resultado = null;
        if (entrada != null) {
            try {
                String linea = entrada.readLine();
                if (linea != null) {
                    String[] notasCadenas = linea.split(", ");
                    resultado = new double[notasCadenas.length];
                    for (int i = 0; i < notasCadenas.length; i++) {
                        resultado[i] = Double.parseDouble(notasCadenas[i]);
                    }
                }
            } catch (IOException es) {
                System.out.println("Error en fichero ");
            }
        }
        return resultado;
    }

    public void cerrarFichero() {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("Error en fichero ");
            }
        }
    }
}
