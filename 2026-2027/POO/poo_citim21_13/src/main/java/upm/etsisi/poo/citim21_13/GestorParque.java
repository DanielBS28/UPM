package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.util.TreeMap;

public class GestorParque {

	private static GestorParque instancia;

	private LocalDate fechaActual;
	private double precioActual;
	
	// Guardamos los grupos aquí
	private TreeMap<String, Grupo> grupos;

	private GestorParque() {
		// Valores por defecto al iniciar nuestro parque de atracciones
		this.fechaActual = LocalDate.now();
		this.precioActual = 40.00;
		this.grupos = new TreeMap<>();
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
	}
