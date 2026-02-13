import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {
    private BufferedReader entrada;
    private String nombre;

    public Fichero(String nombre) {
        this.nombre = nombre;
        try {
            entrada = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado " + nombre);
        }
    }

    public Intervalo leerIntervalo() {
        Intervalo intervalo = null;
        if (entrada != null) {
            String linea = null;
            try {
                linea = entrada.readLine();
                if (linea != null) {
                    int posComa = linea.indexOf(',');
                    double minima = Double.parseDouble(linea.substring(0, posComa));
                    double maxima = Double.parseDouble(linea.substring(posComa + 1).trim());
                    intervalo = new Intervalo(minima, maxima);
                }
            } catch (IOException es) {
                System.out.println("Error en fichero " + nombre);
            }
        }
        return intervalo;
    }

    public String leerLinea() {
        String linea = null;
        if (entrada != null) {
            try {
                linea = entrada.readLine();
            } catch (IOException es) {
                System.out.println("Error en fichero " + nombre);
            }
        }
        return linea;
    }

    public void cerrarFichero() {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("Error en fichero " + nombre);
            }
        }
    }
}
