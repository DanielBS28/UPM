package upm.etsisi.poo.citim21_13;

import java.util.TreeMap;

public class Grupo {
	
	private final String identificador;
	private String nombre;
	
	// El treeMap lo utilizaremos para identificar a los usuarios por correo y mediante su grupo
	private TreeMap<String, Usuario> miembros;
	
	public Grupo(String identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.miembros = new TreeMap<>();
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeMap<String, Usuario> getMiembros() {
		return miembros;
	}
	
	// Añadir usuarios al grupo
	public boolean agregarMiembro(Usuario usuario) {
		if (miembros.containsKey(usuario.getEmail())) {
			return false;
		}
		miembros.put(usuario.getEmail(), usuario);
		return true;
	}
	
	
	public boolean eliminarUsuario(String correo) {
		if (miembros.containsKey(correo)) {
			miembros.remove(correo);
			return true;
		}
		return false;
	}
	
	public boolean puedeModificarse() {
		// En el Hito F2-C04 se comprobará aquí si existe alguna entrada futura asociada al grupo.
		return true;
	}
	
	
}
	


















