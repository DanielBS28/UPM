public class Alumno {

	private String nombre, direccion;

	public Alumno(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String apellidos) {
		this.direccion = direccion;
	}

	public String toString() {
		return nombre + ". Direccion: " + direccion;
	}
}
