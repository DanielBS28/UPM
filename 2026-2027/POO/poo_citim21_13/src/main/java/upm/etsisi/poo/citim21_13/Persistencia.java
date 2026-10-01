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
	
	//Ruta al fichero persistencia
	final static String rutaFicheroPersistencia = "persistencia.txt";
	
	/* Ruta final del archivo de persistencia, convertida a objeto del tipo Path 
	 * para su uso en métodos estáticos de entrada/salida.
	 */
	final static Path ficheroPersistencia = Paths.get(rutaFicheroPersistencia);

	
	/*Método que crea un fichero de persistencia al principio de un 
	 * programa en caso de que no exista el fichero, en caso de que exista, 
	 * se mantiene el fichero tal cual estaba.
	 */
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

	
	/*Al principio del programa, leemos el fichero persistencia para cargar 
	 * los usuarios a nuestro treeMap y así poder usarlos durante la ejecución 
	 * del programa.
	 */
	private static void lecturaPersistencia() {

		String linea = "";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(rutaFicheroPersistencia));

			
			//Leemos línea a línea hasta el final del archivo, un usuario por cada línea se agrega al treeMap.
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

	
	/*Método que sobreescribe el fichero persistencia en caso de que haya algún 
	 * cambio durante la ejecución del programa en algún usuario, 
	 * dejando la persistencia lista para posteriores ejecuciones del programa. 
	 */
	public static void escribirPersistencia() {
		Path fichero = ficheroPersistencia;

		try {

			//Esta sentencia sobreescribe el fichero persistencia dejándolo vacío.
			Files.writeString(fichero, "");

			//En el for, por cada usuario lo añadimos al archivo de persistencia en una línea nueva cada usuario.
			for (String dni : USUARIOS.keySet()) {
				Usuario u = USUARIOS.get(dni);
				String linea = u.getNombre() + ";" + u.getApellidos() + ";" + u.getDni() + ";" + u.getEmail() + ";"
						+ u.getContrasena() + ";" + u.getTelefono() + ";" + u.getNumeroTarjeta() + "\n";

				//Escribe la línea con un APPEND, es decir no sobreescribe el fichero.
				Files.writeString(fichero, linea, StandardOpenOption.APPEND);
			}

		} catch (IOException e) {
			System.err.println("Se produjo un error al sobrescribir el archivo de persistencia.");
			e.printStackTrace();
		}
	}

	/* Este método es para mostrar por la consola los usuarios del TreeMap, 
	 * es para pruebas. */

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

	/* Este método es para mostrar por la consola los usuarios del fichero, 
	 * es para pruebas.*/

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

	//-----------------------------------------------------------

	// Gestión CRUD de usuarios

	public static void altaUsuarios(Usuario u) {
		USUARIOS.put(u.getDni(), u);
		escribirPersistencia();
	}

	public static void bajaUsuarios(Usuario u) {
		USUARIOS.remove(u.getDni());
		escribirPersistencia();
	}

	public static void modificarUsuario() {
		escribirPersistencia();
	}


}