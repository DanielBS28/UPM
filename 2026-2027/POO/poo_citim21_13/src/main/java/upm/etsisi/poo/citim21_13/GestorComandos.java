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

		// Identificar el comando
		switch (partes[0].toUpperCase()) {

			case "USER CREATE":

				// Aqui esta contado 8 por el comando USER CREATE + argumentos
				if (partes.length != 8) {

					System.out.println("Error: USER CREATE requiere 7 argumentos.");
					return;
				}
				crearUsuario(partes);
				break;

			case "USER DELETE":

				// Aqui esta contado 3 por el comando USER DELETE + argumentos
				if (partes.length != 3) {
					System.out.println("Error: USER DELETE requiere 2 argumentos");
					return;
				}
				eliminarUsuario(partes);
				break;

			case "USER UPDATE":

				// Aqui esta contado 5 por el comando USER UPDATE + argumentos
				if (partes.length != 5) {
					System.out.println("Error: USER UPDATE requiere 2 argumentos");
					return;
				}
				modificarUsuario(partes);
				break;

			case "HELP":
				System.out.println("HELP todavía no implementado.");
				break;

			default:
				System.out.println("Error: comando no reconocido: " + partes[0]);
		}
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

		// Formato de comando: USER CREATE;Nombre;Apellidos;DNI;Correo;Contrasena;Telefono;Tarjeta

		boolean error = false;

		if (!Validador.validarDNI(campos[3])) {
			System.out.println("Error: el DNI no es válido.");
			error = true;
		}

		if (!Validador.validarCorreo(campos[4])) {
			System.out.println("Error: el correo no es válido.");

			error = true;
		}

		if (!Validador.validarTarjeta(campos[7])) {
			System.out.println("Error: el número de tarjeta no es válido.");

			error = true;
		}

		if (!Validador.validarContraseña(campos[5])) {
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
			El metodo guarda la informacion en un usuario que posteriormente se mete en
			el treemap con .AltaUsuarios(u) que tiene .escribirPersistencia()
			 */

			Persistencia.altaUsuarios(new Usuario(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]));
			System.out.println("El usuario se ha creado correctamente");
		}

	}

	private static void eliminarUsuario(String[] campos){

		// Formato de comando: USER DELETE;Correo;Contrasena

		boolean error = false; //D

		/*
		Comprobaciones básicas de formato (correo y contraseña)

		CUIDADO: Aqui la disposción de los campos es diferente que en crear usuario
		*/

		if (!Validador.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");

			error = true;
		}

		if (!Validador.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");

			error = true;
		}

		//D con posiciones

		//-------------------------------------------------------------

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

		//-------------------------------------------------------------

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

		//-------------------------------------------------------------
		// Comprobaciones básicas de formato (Correo y contraseña)


		if (!Validador.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");
			errorContraseñaCorreo = true;
		}

		if (!Validador.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");
			errorContraseñaCorreo = true;
		}

		if(!errorContraseñaCorreo) {
		//D con posiciones

		//-------------------------------------------------------------

		// Buscar usuario y validacion de contraseña

		//D con correo y contraseña

		
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

		//-------------------------------------------------------------
		if(!emailContraseñaExistentes) {
		// Convertir el campo recibido al enum CampoUsuario (GESTION CON EL ENUM)

		CampoUsuario campoModificar;

		try {

			campoModificar = CampoUsuario.valueOf(
					campos[3].toUpperCase()
			);

		} catch (IllegalArgumentException e) {

			System.out.println("Error: el campo " + campos[3] + ", no es valido");
			return;
		}

		//-------------------------------------------------------------
		// Modificar el campo correspondiente

		//B propia private

		switch (campoModificar) {

			case NAME:

				usuarioEncontrado.setNombre(campos[4]);
				break;


			case SURNAME:

				usuarioEncontrado.setApellidos(campos[4]);
				break;


			case EMAIL:

				// Comprobar formato del nuevo correo
				if (!Validador.validarCorreo(campos[4])) {
					System.out.println("Error: el nuevo correo no es válido.");
					errorCampo = true;
					break;
				}

				// Comprobar que el correo nuevo no pertenece a otro usuario
				Usuario usuarioMismoCorreo = buscarUsuarioPorCorreo(campos[4]);

				if (usuarioMismoCorreo != null
						&& usuarioMismoCorreo != usuarioEncontrado) {

					System.out.println("Error: el correo ya está registrado");

					errorCampo = true;
					break;
				}
				usuarioEncontrado.setEmail(campos[4]);
				break;

			case PASSWORD:

				if (!Validador.validarContraseña(campos[4])) {
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

				if (!Validador.validarTarjeta(campos[4])) {
					System.out.println("Error: el nuevo número de tarjeta no es válido.");

					errorCampo = true;
					break;
				}

				usuarioEncontrado.setNumeroTarjeta(campos[4]);
				break;

		}

		//-------------------------------------------------------------
		// Si la modificación ha sido correcta, actualizar persistencia
		if (!errorCampo) {

			Persistencia.modificarUsuario();
			System.out.println("El usuario se ha modificado correctamente");
		}
	} //Segundo nivel de comprobaciones
		} //Primer nivel nivel de comprobaciones
		
	}

}
