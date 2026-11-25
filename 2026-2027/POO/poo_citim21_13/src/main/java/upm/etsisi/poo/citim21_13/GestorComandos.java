package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

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

		// Identificación del comando actual mediante el enumerado
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
					System.out.println("Error: USER DELETE requiere 2 argumentos.");
					return;
				}
				eliminarUsuario(partes);
				break;

			case USER_UPDATE:
				if (partes.length != 5) {
					System.out.println("Error: USER UPDATE requiere 4 argumentos.");
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

			case GROUP_CREATE:
				if (partes.length != 3) {
					System.out.println("Error: GROUP CREATE requiere 2 argumentos.");
					return;
				}
				crearGrupo(partes);
				break;

			case GROUP_ADD:
				if (partes.length != 3) {
					System.out.println("Error: GROUP ADD requiere 2 argumentos.");
					return;
				}
				agregarUsuarioGrupo(partes);
				break;

			case GROUP_REMOVE:
				if (partes.length != 3) {
					System.out.println("Error: GROUP REMOVE requiere 2 argumentos.");
					return;
				}
				eliminarUsuarioGrupo(partes);
				break;

			case GROUP_DELETE:
				if (partes.length != 2) {
					System.out.println("Error: GROUP DELETE requiere 1 argumento.");
					return;
				}
				eliminarGrupo(partes);
				break;

			case TICKET_CREATE:
				if (partes.length != 4) {
					System.out.println("Error: TICKET CREATE requiere 3 argumentos.");
					return;
				}
				crearEntradaIndividual(partes);
				break;

			case TICKET_DELETE:
				if (partes.length != 2) {
					System.out.println("Error: TICKET DELETE requiere 1 argumento.");
					return;
				}
				eliminarEntradaIndividual(partes);
				break;

			case GROUPTICKET_CREATE:
				if (partes.length != 4) {
					System.out.println("Error: GROUPTICKET CREATE requiere 3 argumentos.");
					return;
				}
				crearEntradaGrupo(partes);
				break;

			case GROUPTICKET_DELETE:
				if (partes.length != 2) {
					System.out.println("Error: GROUPTICKET DELETE requiere 1 argumento.");
					return;
				}
				eliminarEntradaGrupo(partes);
				break;

			case HELP:
				if (partes.length != 1) {
					System.out.println("Error: HELP no requiere argumentos.");
					return;
				}
				mostrarHelp();
				break;

			default:
				System.out.println("Error: comando reconocido pero aún no implementado: "
						+ comandoValidado.name().replace("_", " "));
		}
	}

	private static void mostrarHelp() {

		System.out.println("--- AYUDA DEL COMANDO HELP ---\n");

		System.out.println("USER CREATE;<nombre>;<apellidos>;<dni>;<correo>;<contraseña>;<telefono>;<tarjeta>\n"
				+ "USER DELETE;<correo>;<contraseña>\n"
				+ "USER UPDATE;<correo>;<contraseña>;<campo>;<valor>\n"
				+ "SYSTEM DATE;<yyyy-MM-dd>\n"
				+ "SYSTEM PRICE;<Precio>\n"
				+ "GROUP CREATE;<Identificador>;<Nombre>\n"
				+ "GROUP ADD;<Identificador>;<Correo>\n"
				+ "GROUP REMOVE;<Identificador>;<Correo>\n"
				+ "GROUP DELETE;<Identificador>\n"
				+ "TICKET CREATE;<identificador>;<correo>;<fecha>\n"
				+ "TICKET DELETE;<identificador>\n"
				+ "GROUPTICKET CREATE;<identificador>;<grupo>;<fecha>\n"
				+ "GROUPTICKET DELETE;<identificador>\n"
				+ "HELP\n"
				+ "EXIT");
	}

	// Método auxiliar para buscar un usuario por correo
	private static Usuario buscarUsuarioPorCorreo(String correo) {

		for (Usuario u : Persistencia.USUARIOS.values()) {
			if (u.getEmail().equalsIgnoreCase(correo)) {
				return u;
			}
		}

		return null;
	}



	private static void crearUsuario(String[] campos) {

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
			System.out.println("Error: el dni ya existe.");
			error = true;
		}

		if (buscarUsuarioPorCorreo(campos[4]) != null) {
			System.out.println("Error: el correo ya está registrado.");
			error = true;
		}

		if (!error) {
			Persistencia.altaUsuarios(
					new Usuario(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]));
			System.out.println("El usuario se ha creado correctamente.");
		}
	}

	private static void eliminarUsuario(String[] campos) {

		boolean error = false;

		if (!Usuario.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");
			error = true;
		}

		if (!Usuario.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");
			error = true;
		}

		Usuario usuarioEncontrado = buscarUsuarioPorCorreo(campos[1]);

		if (usuarioEncontrado == null) {
			System.out.println("Error: el usuario no existe.");
			error = true;
		}

		if (!error && !usuarioEncontrado.getContrasena().equals(campos[2])) {
			System.out.println("Error: contraseña incorrecta.");
			error = true;
		}

		GestorParque gestor = GestorParque.getInstancia();

		// Comprobar si el usuario tiene entradas activas (individuales o parte de un grupo)
		if (!error && gestor.usuarioTieneEntradasActivas(usuarioEncontrado)) {
			System.out.println("Error: no se puede eliminar el usuario porque tiene entradas activas asociadas.");
			error = true;
		}

		// Comprobar si pertenece a algún grupo bloqueado por tener una entrada de grupo activa
		if (!error && gestor.usuarioPerteneceAGrupoBloqueado(usuarioEncontrado)) {
			System.out.println("Error: no se puede eliminar el usuario porque pertenece a un grupo con entradas activas.");
			error = true;
		}

		if (!error) {
			gestor.retirarUsuarioDeGrupos(usuarioEncontrado);
			Persistencia.bajaUsuarios(usuarioEncontrado);
			System.out.println("El usuario se ha eliminado correctamente.");
		}
	}

	private static void modificarUsuario(String[] campos) {

		boolean errorContraseñaCorreo = false;
		boolean emailContraseñaExistentes = false;
		boolean errorCampo = false;

		if (!Usuario.validarCorreo(campos[1])) {
			System.out.println("Error: el correo no es válido.");
			errorContraseñaCorreo = true;
		}

		if (!Usuario.validarContraseña(campos[2])) {
			System.out.println("Error: la contraseña no es válida.");
			errorContraseñaCorreo = true;
		}

		if (!errorContraseñaCorreo) {

			Usuario usuarioEncontrado = buscarUsuarioPorCorreo(campos[1]);

			if (usuarioEncontrado == null) {
				System.out.println("Error: el usuario no existe.");
				emailContraseñaExistentes = true;
			}

			if (!emailContraseñaExistentes && !usuarioEncontrado.getContrasena().equals(campos[2])) {
				System.out.println("Error: contraseña incorrecta.");
				emailContraseñaExistentes = true;
			}

			if (!emailContraseñaExistentes) {

				CampoUsuario campoModificar;

				try {
					campoModificar = CampoUsuario.valueOf(campos[3].toUpperCase());
				} catch (IllegalArgumentException e) {
					System.out.println("Error: el campo " + campos[3] + " no es válido.");
					return;
				}

				switch (campoModificar) {

					case NAME:
						usuarioEncontrado.setNombre(campos[4]);
						break;

					case SURNAME:
						usuarioEncontrado.setApellidos(campos[4]);
						break;

					case EMAIL:
						if (!Usuario.validarCorreo(campos[4])) {
							System.out.println("Error: el nuevo correo no es válido.");
							errorCampo = true;
							break;
						}

						Usuario usuarioMismoCorreo = buscarUsuarioPorCorreo(campos[4]);
						if (usuarioMismoCorreo != null && usuarioMismoCorreo != usuarioEncontrado) {
							System.out.println("Error: el correo ya está registrado.");
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

				if (!errorCampo) {
					Persistencia.modificarUsuario();
					System.out.println("El usuario se ha modificado correctamente.");
				}
			}
		}
	}


	private static void modificarFechaSistema(String[] partes) {
		try {
			LocalDate nuevaFecha = LocalDate.parse(partes[1]);
			GestorParque.getInstancia().setFechaActual(nuevaFecha);
			System.out.println("Fecha del sistema actualizada a: " + nuevaFecha);
		} catch (DateTimeParseException e) {
			System.out.println("Error: el formato de fecha no es válido. Debe ser yyyy-MM-dd.");
		}
	}

	private static void modificarPrecioSistema(String[] partes) {
		try {
			double nuevoPrecio = Double.parseDouble(partes[1]);
			if (Double.isFinite(nuevoPrecio) && nuevoPrecio > 0) {
				GestorParque.getInstancia().setPrecioActual(nuevoPrecio);
				System.out.printf(Locale.US, "Precio base actualizado a: %.2f euros.%n", nuevoPrecio);
			} else {
				System.out.println("Error: el precio debe ser una cantidad válida y positiva.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: formato de precio incorrecto.");
		}
	}


	private static void crearGrupo(String[] partes) {
		String identificador = partes[1];
		String nombre = partes[2];

		if (identificador.isEmpty() || nombre.isEmpty()) {
			System.out.println("Error: el identificador y el nombre del grupo no pueden estar vacíos.");
			return;
		}

		GestorParque gestor = GestorParque.getInstancia();

		if (gestor.buscarGrupo(identificador) != null) {
			System.out.println("Error: ya existe un grupo con ese identificador.");
			return;
		}

		Grupo nuevoGrupo = new Grupo(identificador, nombre);
		gestor.registrarGrupo(nuevoGrupo);
		System.out.println("El grupo se ha creado correctamente.");
	}

	private static void agregarUsuarioGrupo(String[] partes) {
		String identificador = partes[1];
		String correo = partes[2];

		GestorParque gestor = GestorParque.getInstancia();
		Grupo grupo = gestor.buscarGrupo(identificador);

		if (grupo == null) {
			System.out.println("Error: el grupo no existe.");
			return;
		}

		if (gestor.grupoTieneEntradasActivas(grupo)) {
			System.out.println("Error: el grupo no puede modificarse porque tiene entradas de grupo activas.");
			return;
		}

		Usuario usuario = buscarUsuarioPorCorreo(correo);
		if (usuario == null) {
			System.out.println("Error: el usuario no existe en el sistema.");
			return;
		}

		if (grupo.agregarMiembro(usuario)) {
			System.out.println("El usuario se ha incorporado al grupo correctamente.");
		} else {
			System.out.println("Error: el usuario ya pertenece a este grupo.");
		}
	}

	private static void eliminarUsuarioGrupo(String[] partes) {
		String identificador = partes[1];
		String correo = partes[2];

		GestorParque gestor = GestorParque.getInstancia();
		Grupo grupo = gestor.buscarGrupo(identificador);

		if (grupo == null) {
			System.out.println("Error: el grupo no existe.");
			return;
		}

		if (gestor.grupoTieneEntradasActivas(grupo)) {
			System.out.println("Error: el grupo no puede modificarse porque tiene entradas de grupo activas.");
			return;
		}

		if (grupo.eliminarMiembro(correo)) {
			System.out.println("El usuario se ha eliminado del grupo correctamente.");
		} else {
			System.out.println("Error: el usuario no pertenece a este grupo.");
		}
	}

	private static void eliminarGrupo(String[] partes) {
		String identificador = partes[1];

		GestorParque gestor = GestorParque.getInstancia();
		Grupo grupo = gestor.buscarGrupo(identificador);

		if (grupo == null) {
			System.out.println("Error: el grupo no existe.");
			return;
		}

		if (gestor.grupoTieneEntradasActivas(grupo)) {
			System.out.println("Error: el grupo no puede eliminarse porque tiene entradas de grupo activas.");
			return;
		}

		gestor.desvincularGrupoDeEntradas(grupo);
		gestor.eliminarGrupo(identificador);
		System.out.println("El grupo se ha eliminado correctamente.");
	}


	private static void crearEntradaIndividual(String[] partes) {
		String identificador = partes[1];
		String correo = partes[2];
		String textoFecha = partes[3];

		GestorParque gestor = GestorParque.getInstancia();

		if (identificador.isEmpty()) {
			System.out.println("Error: el identificador de la entrada no puede estar vacío.");
			return;
		}

		if (gestor.existeEntrada(identificador)) {
			System.out.println("Error: ya existe una entrada con el identificador " + identificador + ".");
			return;
		}

		Usuario usuario = buscarUsuarioPorCorreo(correo);
		if (usuario == null) {
			System.out.println("Error: el usuario no existe en el sistema.");
			return;
		}

		LocalDate fechaEntrada;
		try {
			fechaEntrada = LocalDate.parse(textoFecha);
		} catch (DateTimeParseException e) {
			System.out.println("Error: el formato de fecha no es válido. Debe ser yyyy-MM-dd.");
			return;
		}

		if (fechaEntrada.isBefore(gestor.getFechaActual())) {
			System.out.println("Error: no se pueden crear entradas para fechas anteriores a la fecha actual del sistema.");
			return;
		}

		EntradaIndividual nuevaEntrada = new EntradaIndividual(
				identificador,
				fechaEntrada,
				gestor.getPrecioActual(),
				usuario
		);

		gestor.registrarEntrada(nuevaEntrada);
		System.out.printf(Locale.US,
				"Entrada creada correctamente. Precio a cobrar: %.2f euros.%n",
				nuevaEntrada.getPrecio());
	}

	private static void eliminarEntradaIndividual(String[] partes) {
		String identificador = partes[1];

		GestorParque gestor = GestorParque.getInstancia();
		Entrada entrada = gestor.buscarEntrada(identificador);

		if (entrada == null) {
			System.out.println("Error: no existe ninguna entrada con el identificador " + identificador + ".");
			return;
		}

		if (!entrada.esEntradaIndividual()) {
			System.out.println("Error: el identificador corresponde a una entrada de grupo, utilice GROUPTICKET DELETE.");
			return;
		}

		if (entrada.esParteDeGrupo()) {
			System.out.println("Error: no se puede eliminar independientemente una entrada que forma parte de una entrada de grupo.");
			return;
		}

		if (!entrada.puedeEliminarse(gestor.getFechaActual())) {
			System.out.println("Error: solo se pueden eliminar entradas con fecha estrictamente posterior a la fecha actual.");
			return;
		}

		gestor.eliminarEntrada(identificador);
		System.out.println("La entrada se ha eliminado correctamente.");
	}

	private static void crearEntradaGrupo(String[] partes) {
		String identificador = partes[1];
		String idGrupo = partes[2];
		String textoFecha = partes[3];

		GestorParque gestor = GestorParque.getInstancia();

		if (identificador.isEmpty()) {
			System.out.println("Error: el identificador de la entrada de grupo no puede estar vacío.");
			return;
		}

		if (gestor.existeEntrada(identificador)) {
			System.out.println("Error: ya existe una entrada con el identificador " + identificador + ".");
			return;
		}

		Grupo grupo = gestor.buscarGrupo(idGrupo);
		if (grupo == null) {
			System.out.println("Error: el grupo no existe.");
			return;
		}

		if (grupo.getMiembros().isEmpty()) {
			System.out.println("Error: no se puede adquirir una entrada de grupo para un grupo vacío.");
			return;
		}

		LocalDate fechaEntrada;
		try {
			fechaEntrada = LocalDate.parse(textoFecha);
		} catch (DateTimeParseException e) {
			System.out.println("Error: el formato de fecha no es válido. Debe ser yyyy-MM-dd.");
			return;
		}

		if (fechaEntrada.isBefore(gestor.getFechaActual())) {
			System.out.println("Error: no se pueden crear entradas de grupo para fechas anteriores a la fecha actual del sistema.");
			return;
		}

		// Comprobación previa de conflictos con todos los identificadores derivados
		for (Usuario usuario : grupo.getMiembros().values()) {
			String idDerivado = identificador + ":" + usuario.getDni();
			if (gestor.existeEntrada(idDerivado)) {
				System.out.println("Error: conflicto con el identificador derivado " + idDerivado + ".");
				return;
			}
		}

		EntradaGrupo nuevaEntradaGrupo = new EntradaGrupo(
				identificador,
				fechaEntrada,
				gestor.getPrecioActual(),
				grupo
		);

		gestor.registrarEntrada(nuevaEntradaGrupo);
		System.out.printf(Locale.US,
				"Entrada de grupo creada correctamente. Precio total a cobrar: %.2f euros.%n",
				nuevaEntradaGrupo.getPrecio());
	}

	private static void eliminarEntradaGrupo(String[] partes) {
		String identificador = partes[1];

		GestorParque gestor = GestorParque.getInstancia();
		Entrada entrada = gestor.buscarEntrada(identificador);

		if (entrada == null) {
			System.out.println("Error: no existe ninguna entrada con el identificador " + identificador + ".");
			return;
		}

		if (!entrada.esEntradaGrupo()) {
			System.out.println("Error: el identificador corresponde a una entrada individual, utilice TICKET DELETE.");
			return;
		}

		if (!entrada.puedeEliminarse(gestor.getFechaActual())) {
			System.out.println("Error: solo se pueden eliminar entradas de grupo con fecha estrictamente posterior a la fecha actual.");
			return;
		}

		gestor.eliminarEntrada(identificador);
		System.out.println("La entrada de grupo se ha eliminado correctamente.");
	}
}