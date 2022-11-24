package modelos;

public class Usuario {
	
	// Atributos relacionados a la tabla Usuarios
	
	private int idUsuario;
	private	int idRol;
	private String nombre;
	private String apellido;
	private String cedula;
	private String nombreUsuario;
	private String clave;
	
	// Sobre carga de metodos
	// Permite generar el objeto sin atributos, incompletos, o todos segun sea la necesidad
	
	public Usuario(){}
	
	public Usuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	
	public Usuario(String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}
	
	public Usuario(int idRol, String nombre, String apellido, String cedula, String nombreUsuario, String clave) {
		this.nombre = nombre;
		this.idRol = idRol;
		this.apellido = apellido;
		this.cedula = cedula;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	public Usuario(int idUsuario, int idRol, String nombre, String apellido, String cedula, String nombreUsuario, String clave) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.idRol = idRol;
		this.apellido = apellido;
		this.cedula = cedula;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;

	}

	// Get y set de cada atributo 
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
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
		return "Usuario [idUsuario=" + idUsuario + ", idRol=" + idRol + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", cedula=" + cedula + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + "]";
	}

	
	
	
}
