package upm.etsisi.poo.citim21_13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.TreeMap;

public class Persistencia {

	public static TreeMap<String, Usuario> USUARIOS = new TreeMap<>();
	final static String rutaFicheroPersistencia = "persistencia.txt";
	final static Path ficheroPersistencia = Paths.get(rutaFicheroPersistencia);

	public static void inicializar() {
		File fichero = new File(rutaFicheroPersistencia);

		if (fichero.exists()) {
			System.out.println("El fichero de persistencia ya existe: " + fichero.getName());
		} else {
			try {
				if (fichero.createNewFile()) {
					System.out.println("Fichero de persistencia creado con éxito: " + fichero.getName());
				}
			} catch (IOException e) {
				System.err.println("Error al crear el fichero de persistencia: " + e.getMessage());
			}
		}

		lecturaPersistencia();
	}

	private static void lecturaPersistencia() {

		String linea = "";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(rutaFicheroPersistencia));

			while ((linea = bf.readLine()) != null) {

				String[] campos = linea.split(";");

				USUARIOS.put(campos[2], new Usuario(campos[0], // Nombre
						campos[1], // Apellidos
						campos[2], // DNI (Es la clave, en el put se lo pasamos primero)
						campos[3], // Email
						campos[4], // Contraseña
						campos[5], // Teléfono
						campos[6] // Tarjeta
				));
			}

			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escribirPersistencia() {
		Path fichero = ficheroPersistencia;

		try {

			Files.writeString(fichero, "");

			for (String dni : USUARIOS.keySet()) {
				Usuario u = USUARIOS.get(dni);
				String linea = u.getNombre() + ";" + u.getApellidos() + ";" + u.getDni() + ";" + u.getEmail() + ";"
						+ u.getContrasena() + ";" + u.getTelefono() + ";" + u.getNumeroTarjeta() + "\n";

				Files.writeString(fichero, linea, StandardOpenOption.APPEND);
			}

		} catch (IOException e) {
			System.err.println("Se produjo un error al sobrescribir el archivo de persistencia.");
			e.printStackTrace();
		}
	}
	
	//Este método es para mostrar por la consola los usuarios del TreeMap, es para pruebas.

	public static void listarUsuariosTreeMap() {
		if (USUARIOS.isEmpty()) {
			System.out.println("No hay usuarios.");
			return;
		}

		System.out.println("Usuarios registrados: (Esto es el TreeMap)");
		for (Usuario u : USUARIOS.values()) {

			String linea = u.getNombre() + ";" + u.getApellidos() + ";" + u.getDni() + ";" + u.getEmail() + ";"
					+ u.getContrasena() + ";" + u.getTelefono() + ";" + u.getNumeroTarjeta();
			System.out.println(linea);
		}
		System.out.println("-------------------------------------------------");
	}
	
	//Este método es para mostrar por la consola los usuarios del fichero, es para pruebas.


	public static void listarUsuariosFichero() {
		System.out.println("Usuarios registrados: (Esto es el FICHERO físico)");

		try (BufferedReader bf = new BufferedReader(new FileReader(rutaFicheroPersistencia));) {
			String linea;
			boolean hayContenido = false;

			while ((linea = bf.readLine()) != null) {
				if (!linea.trim().isEmpty()) {
					System.out.println(linea);
					hayContenido = true;
				}
			}

			if (!hayContenido) {
				System.out.println("El fichero de persistencia está vacío.");
			}
			System.out.println("-------------------------------------------------");

		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el fichero de persistencia en disco.");
		} catch (IOException e) {
			System.err.println("Error al leer el fichero: " + e.getMessage());
		}
	}

}