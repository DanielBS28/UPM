package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.util.TreeMap;

public class GestorParque {

	private static GestorParque instancia;

	private LocalDate fechaActual;
	private double precioActual;

	private TreeMap<String, Grupo> grupos;
	private TreeMap<String, Entrada> entradas;

	private GestorParque() {
		this.fechaActual = LocalDate.now();
		this.precioActual = 40.00;
		this.grupos = new TreeMap<>();
		this.entradas = new TreeMap<>();
	}

	public static GestorParque getInstancia() {
		if (instancia == null) {
			instancia = new GestorParque();
		}
		return instancia;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public double getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(double precioActual) {
		if (precioActual > 0) {
			this.precioActual = precioActual;
		}
	}

	// --- Gestión centralizada de Grupos ---

	public TreeMap<String, Grupo> getGrupos() {
		return grupos;
	}

	public Grupo buscarGrupo(String identificador) {
		return grupos.get(identificador);
	}

	public void registrarGrupo(Grupo grupo) {
		grupos.put(grupo.getIdentificador(), grupo);
	}

	public void eliminarGrupo(String identificador) {
		grupos.remove(identificador);
	}

	public void retirarUsuarioDeGrupos(Usuario usuario) {
		for (Grupo grupo : grupos.values()) {
			grupo.eliminarMiembro(usuario.getEmail());
		}
	}

	public boolean grupoTieneEntradasActivas(Grupo grupo) {
		for (Entrada entrada : entradas.values()) {
			if (entrada.esActiva(fechaActual) && entrada.perteneceAGrupo(grupo)) {
				return true;
			}
		}
		return false;
	}

	public void desvincularGrupoDeEntradas(Grupo grupo) {
		for (Entrada entrada : entradas.values()) {
			entrada.desvincularGrupo(grupo);
		}
	}

	public boolean usuarioPerteneceAGrupoBloqueado(Usuario usuario) {
		for (Grupo grupo : grupos.values()) {
			if (grupo.contieneMiembro(usuario) && grupoTieneEntradasActivas(grupo)) {
				return true;
			}
		}
		return false;
	}

	// --- Gestión centralizada de Entradas ---

	public TreeMap<String, Entrada> getEntradas() {
		return entradas;
	}

	public Entrada buscarEntrada(String identificador) {
		return entradas.get(identificador);
	}

	public boolean existeEntrada(String identificador) {
		return entradas.containsKey(identificador);
	}

	public void registrarEntrada(Entrada entrada) {
		for (Entrada e : entrada.getEntradasGestionadas()) {
			entradas.put(e.getIdentificador(), e);
		}
	}

	public void eliminarEntrada(String identificador) {
		Entrada entrada = entradas.get(identificador);
		if (entrada != null) {
			for (Entrada e : entrada.getEntradasGestionadas()) {
				entradas.remove(e.getIdentificador());
			}
		}
	}

	public boolean usuarioTieneEntradasActivas(Usuario usuario) {
		for (Entrada entrada : entradas.values()) {
			if (entrada.esActiva(fechaActual) && entrada.contieneUsuario(usuario)) {
				return true;
			}
		}
		return false;
	}
}