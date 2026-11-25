package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.util.List;

public class EntradaIndividual extends Entrada {

	private final Usuario usuario;
	private final double descuento;
	private final boolean parteDeGrupo;

	public EntradaIndividual(String identificador, LocalDate fecha, double precioBase, Usuario usuario) {
		this(identificador, fecha, precioBase, usuario, 0.0, false);
	}

	public EntradaIndividual(String identificador, LocalDate fecha, double precioBase, Usuario usuario,
							 double descuento, boolean parteDeGrupo) {
		super(identificador, fecha, precioBase);
		this.usuario = usuario;
		this.descuento = descuento;
		this.parteDeGrupo = parteDeGrupo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public boolean esEntradaIndividual() {
		return true;
	}

	@Override
	public boolean esParteDeGrupo() {
		return parteDeGrupo;
	}

	@Override
	public double getPrecio() {
		return calcularPrecioConDescuento(descuento);
	}

	@Override
	public List<Usuario> getUsuarios() {
		if (usuario == null) {
			return List.of();
		}
		return List.of(usuario);
	}

	@Override
	public boolean contieneUsuario(Usuario usuarioBuscado) {
		if (this.usuario == null || usuarioBuscado == null) {
			return false;
		}
		return this.usuario.getDni().equalsIgnoreCase(usuarioBuscado.getDni());
	}
}