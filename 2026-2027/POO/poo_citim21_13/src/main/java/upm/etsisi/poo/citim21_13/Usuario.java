package upm.etsisi.poo.citim21_13;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private final String dni;
	private String email;
	private String contrasena;
	private String telefono;
	private String numeroTarjeta;
	
	
	public Usuario(String nombre, String apellidos, String dni, String email, String contrasena, String telefono,
			String numeroTarjeta) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.numeroTarjeta = numeroTarjeta;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


}
