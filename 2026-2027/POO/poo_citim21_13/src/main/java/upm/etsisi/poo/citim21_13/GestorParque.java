package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;

public class GestorParque {

	private static GestorParque instancia;

	private LocalDate fechaActual;
	private double precioActual;

	private GestorParque() {
		// Valores por defecto al iniciar nuestro parque de atracciones
		this.fechaActual = LocalDate.now();
		this.precioActual = 40.00;
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
}