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

	  public abstract List<Usuario> getUsuarios();

	  public abstract boolean contieneUsuario(Usuario usuario);
	
}
