package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.util.List;

public abstract class Entrada {

	private final String identificador;
	private final LocalDate fecha;
	private final double precioBase;

	public Entrada(String identificador, LocalDate fecha, double precioBase) {
		this.identificador = identificador;
		this.fecha = fecha;
		this.precioBase = precioBase;
	}

	public String getIdentificador() {
		return identificador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	protected double calcularPrecioConDescuento(double porcentajeDescuento) {
		return precioBase * (1.0 - porcentajeDescuento);
	}

	public double getPrecio() {
		return precioBase;
	}

	public boolean esActiva(LocalDate fechaSistema) {
		return !fecha.isBefore(fechaSistema);
	}

	public boolean puedeEliminarse(LocalDate fechaSistema) {
		return fecha.isAfter(fechaSistema);
	}

	public boolean esValidaParaFecha(LocalDate fechaSistema) {
		return fecha.isEqual(fechaSistema);
	}

	public boolean esEntradaIndividual() {
		return false;
	}

	public boolean esEntradaGrupo() {
		return false;
	}

	public boolean esParteDeGrupo() {
		return false;
	}

	public boolean perteneceAGrupo(Grupo grupo) {
		return false;
	}

	public void desvincularGrupo(Grupo grupo) {
		// Por defecto no hace nada; EntradaGrupo sobrescribe este comportamiento
	}

	/**
	 * Devuelve todas las entradas que se registran o eliminan juntas en el gestor.
	 * En una entrada individual es ella misma; en una de grupo incluye sus entradas hijas.
	 */
	public List<Entrada> getEntradasGestionadas() {
		return List.of(this);
	}

	public abstract List<Usuario> getUsuarios();

	public abstract boolean contieneUsuario(Usuario usuario);
}
