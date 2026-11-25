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

	// Usar el DNI como clave evita desincronizaciones al cambiar el email
	public boolean agregarMiembro(Usuario usuario) {
		if (miembros.containsKey(usuario.getDni())) {
			return false;
		}
		miembros.put(usuario.getDni(), usuario);
		return true;
	}

	public boolean eliminarMiembro(String correo) {
		for (Usuario u : miembros.values()) {
			if (u.getEmail().equalsIgnoreCase(correo)) {
				miembros.remove(u.getDni());
				return true;
			}
		}
		return false;
	}

	/* SOBRECARGA DEL MÉTODO ELIMINARMIEMBRO QUE PODRÍA ESTAR BIEN EN EL FUTURO
    public boolean eliminarMiembro(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        return miembros.remove(usuario.getDni()) != null;
    }
    */
	public boolean puedeModificarse() {
		// En el Hito F2-C04 se comprobará aquí si existe alguna entrada futura asociada al grupo.
		return true;
	}

	public boolean contieneMiembro(Usuario usuario) {
		if (usuario == null) {
			return false;
		}
		return miembros.containsKey(usuario.getDni());
	}


}
