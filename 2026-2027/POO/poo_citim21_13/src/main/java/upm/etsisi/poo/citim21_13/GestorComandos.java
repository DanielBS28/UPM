package upm.etsisi.poo.citim21_13;

public class GestorComandos {

	public static void analizarComando(String linea) {

		// Ignorar líneas nulas o vacías
		if (linea == null || linea.trim().isEmpty()) {
			return;
		}

		// Eliminar espacios al principio y al final
		linea = linea.trim();

		// Separar los campos mediante ;
		String[] partes = linea.split(";");

		// Eliminar espacios sobrantes de cada campo
		for (int i = 0; i < partes.length; i++) {
			partes[i] = partes[i].trim();
		}

		//Identificación del comando actual al enumerado
		ComandoApp comandoValidado = ComandoApp.obtenerComando(partes[0]);

		if (comandoValidado == null) {
			System.out.println("Error: comando no reconocido: " + partes[0]);
			return;
		}

		switch (comandoValidado) {

		case USER_CREATE:
			if (partes.length != 8) {
				System.out.println("Error: USER CREATE requiere 7 argumentos.");
				return;
			}
			crearUsuario(partes);
			break;

		case USER_DELETE:
			if (partes.length != 3) {
				System.out.println("Error: USER DELETE requiere 2 argumentos");
				return;
			}
			eliminarUsuario(partes);
			break;

		case USER_UPDATE:
			if (partes.length != 5) {
				System.out.println("Error: USER UPDATE requiere 4 argumentos");
				return;
			}
			modificarUsuario(partes);
			break;

		case SYSTEM_DATE:
			if (partes.length != 2) {
				System.out.println("Error: SYSTEM DATE requiere 1 argumento.");
				return;
			}
			modificarFechaSistema(partes);
			break;

		case SYSTEM_PRICE:
			if (partes.length != 2) {
				System.out.println("Error: SYSTEM PRICE requiere 1 argumento.");
				return;
			}
			modificarPrecioSistema(partes);
			break;

		case HELP:
			if (partes.length != 1) {
				System.out.println("Error: HELP no requiere argumentos");
				return;
			}
			mostrarHelp();
			break;


		default:	
			System.out.println("Error: comando no reconocido: " + comandoValidado.name().replace("_", " "));
		}
	}

	private static void mostrarHelp() {
		System.out.println("--- AYUDA DEL COMANDO HELP ---\n");
		System.out.println("USER CREATE;<nombre>;<apellidos>;<dni>;<correo>;<contraseña>;<telefono>;<tarjeta>\n" +
				"USER DELETE;<correo>;<contraseña>\n" +
				"USER UPDATE;<correo>;<contraseña>;<campo>;<valor>\n" +
				"SYSTEM DATE;<yyyy-MM-dd>\n" +
				"SYSTEM PRICE;<Precio>\n" +
				"HELP\n" +
				"EXIT");
	}

	// Metodo auxiliar para buscar directamente devolviendo un objeto
	private static Usuario buscarUsuarioPorCorreo(String correo) {

		for (Usuario u : Persistencia.USUARIOS.values()) {

			if (u.getEmail().equalsIgnoreCase(correo)) {
				return u;
			}
		}

		return null;
	}

	private static void crearUsuario(String[] campos) {

		// Formato de comando: USER
		// CREATE;Nombre;Apellidos;DNI;Correo;Contrasena;Telefono;Tarjeta

		boolean error = false;

		if (!Usuario.validarDNI(campos[3])) {
			System.out.println("Error: el DNI no es válido.");
			error = true;
		}

		if (!Usuario.validarCorreo(campos[4])) {
			System.out.println("Error: el correo no es válido.");

			error = true;
		}

		if (!Usuario.validarTarjeta(campos[7])) {
			System.out.println("Error: el número de tarjeta no es válido.");

			error = true;
		}

		if (!Usuario.validarContraseña(campos[5])) {
			System.out.println("Error: la contraseña no es válida.");

			error = true;
		}

		if (Persistencia.USUARIOS.containsKey(campos[3])) {
			System.out.println("Error: el dni ya existe");

			error = true;
		}

		// Modificacion de comprobación por boolean -> por objeto
		if (buscarUsuarioPorCorreo(campos[4]) != null) {
			System.out.println("Error: el correo ya está registrado");
			error = true;
		}

		if (!error) {
			/*
			 * El metodo guarda la informacion en un usuario que posteriormente se mete en
			 * el treemap con .AltaUsuarios(u) que tiene .escribirPersistencia()
			 */

			Persistencia.altaUsuarios(
					new Usuario(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]));
			System.out.println("El usuario se ha creado correctamente");
		}

	}
	
	private static void modificarFechaSistema(String[] partes) {
		try {
			java.time.LocalDate nuevaFecha = java.time.LocalDate.parse(partes[1]);
			GestorParque.getInstancia().setFechaActual(nuevaFecha);
		} catch (java.time.format.DateTimeParseException e) {
			System.out.println("Error: el formato de fecha no es válido. Debe ser yyyy-MM-dd.");
		}
	}

	private static void modificarPrecioSistema(String[] partes) {
		try {
			double nuevoPrecio = Double.parseDouble(partes[1]);
			if (nuevoPrecio > 0) {
				GestorParque.getInstancia().setPrecioActual(nuevoPrecio);
			} else {
				System.out.println("Error: el precio debe ser una cantidad válida y positiva.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: formato de precio incorrecto.");
		}
	}

	private static void eliminarUsuario(String[] campos) {

		// Formato de comando: USER DELETE;Correo;Contrasena

		boolean error = false; // D

		/*
		 * Comprobaciones básicas de formato (correo y contraseña)
		 * 
		 * CUIDADO: Aqui la disposción de los campos es diferente que en crear usuario
		 */

		if (!Usuario.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");

			error = true;
		}

		if (!Usuario.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");

			error = true;
		}

		// D con posiciones

		// -------------------------------------------------------------

		// Comprobaciones de existencia (Usuario existe y contraseña valida de usuario)

		// Detectar usuario mediante correo
		Usuario usuarioEncontrado = buscarUsuarioPorCorreo(campos[1]);

		if (usuarioEncontrado == null) {
			System.out.println("Error: el usuario no existe");
			error = true;
		}

		// Comprobar contraseña solamente si hemos encontrado al usuario
		if (!error && !usuarioEncontrado.getContrasena().equals(campos[2])) {
			System.out.println("Error: contraseña incorrecta");
			error = true;
		}

		// -------------------------------------------------------------

		// Si todas las comprobaciones son correctas, delegamos en Persistencia
		if (!error) {
			Persistencia.bajaUsuarios(usuarioEncontrado);
			System.out.println("El usuario se ha eliminado correctamente");
		}
	}

	private static void modificarUsuario(String[] campos) {

		// Formato de comando: USER UPDATE;Correo;Contrasena;Campo;NuevoValor

		boolean errorContraseñaCorreo = false;
		boolean emailContraseñaExistentes = false;
		boolean errorCampo = false;

		// -------------------------------------------------------------
		// Comprobaciones básicas de formato (Correo y contraseña)

		if (!Usuario.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");
			errorContraseñaCorreo = true;
		}

		if (!Usuario.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");
			errorContraseñaCorreo = true;
		}

		if (!errorContraseñaCorreo) {
			// D con posiciones

			// -------------------------------------------------------------

			// Buscar usuario y validacion de contraseña

			// D con correo y contraseña

			Usuario usuarioEncontrado = buscarUsuarioPorCorreo(campos[1]);

			if (usuarioEncontrado == null) {
				System.out.println("Error: el usuario no existe");
				emailContraseñaExistentes = true;
			}

			// Comprobar contraseña guardada del usuario

			if (!emailContraseñaExistentes && !usuarioEncontrado.getContrasena().equals(campos[2])) {
				System.out.println("Error: contraseña incorrecta");
				emailContraseñaExistentes = true;
			}

			// -------------------------------------------------------------
			if (!emailContraseñaExistentes) {
				// Convertir el campo recibido al enum CampoUsuario (GESTION CON EL ENUM)

				CampoUsuario campoModificar;

				try {

					campoModificar = CampoUsuario.valueOf(campos[3].toUpperCase());

				} catch (IllegalArgumentException e) {

					System.out.println("Error: el campo " + campos[3] + ", no es valido");
					return;
				}

				// -------------------------------------------------------------
				// Modificar el campo correspondiente

				// B propia private

				switch (campoModificar) {

				case NAME:

					usuarioEncontrado.setNombre(campos[4]);
					break;

				case SURNAME:

					usuarioEncontrado.setApellidos(campos[4]);
					break;

				case EMAIL:

					// Comprobar formato del nuevo correo
					if (!Usuario.validarCorreo(campos[4])) {
						System.out.println("Error: el nuevo correo no es válido.");
						errorCampo = true;
						break;
					}

					// Comprobar que el correo nuevo no pertenece a otro usuario
					Usuario usuarioMismoCorreo = buscarUsuarioPorCorreo(campos[4]);

					if (usuarioMismoCorreo != null && usuarioMismoCorreo != usuarioEncontrado) {

						System.out.println("Error: el correo ya está registrado");

						errorCampo = true;
						break;
					}
					usuarioEncontrado.setEmail(campos[4]);
					break;

				case PASSWORD:

					if (!Usuario.validarContraseña(campos[4])) {
						System.out.println("Error: la nueva contraseña no es válida.");

						errorCampo = true;
						break;
					}

					usuarioEncontrado.setContrasena(campos[4]);
					break;

				case PHONE:

					usuarioEncontrado.setTelefono(campos[4]);
					break;

				case CARD:

					if (!Usuario.validarTarjeta(campos[4])) {
						System.out.println("Error: el nuevo número de tarjeta no es válido.");

						errorCampo = true;
						break;
					}

					usuarioEncontrado.setNumeroTarjeta(campos[4]);
					break;

				}

				// -------------------------------------------------------------
				// Si la modificación ha sido correcta, actualizar persistencia
				if (!errorCampo) {

					Persistencia.modificarUsuario();
					System.out.println("El usuario se ha modificado correctamente");
				}
			} // Segundo nivel de comprobaciones
		} // Primer nivel nivel de comprobaciones

	}

}
