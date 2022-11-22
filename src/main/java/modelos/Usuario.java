package modelos;

public class Usuario {
	
	// Atributos relacionados a la tabla Usuarios
	
	private int idUsuario;
	private	int idRol;
	private String nombre;
	
	// Sobre carga de metodos
	// Permite generar el objeto sin atributos, incompletos, o todos segun sea la necesidad
	
	public Usuario(){}
	
	public Usuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	
	public Usuario(int idRol, String nombre) {
		this.nombre = nombre;
		this.idRol = idRol;
	}
	
	public Usuario(int idUsuario, int idRol, String nombre) {
		this.idUsuario = idUsuario;
		this.idRol = idRol;
		this.nombre = nombre;
	}

	// Get y set de cada atributo 
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Convertir a string cada atributo para ser visualizado
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", idRol=" + idRol + ", nombre=" + nombre + "]";
	}
	
}
