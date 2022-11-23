package modelos;

public class Rol {
	
	//Atributos de la tabla rol
	
	private int idRol;
	private String NombreRol;
	
	// Sobre carga de metodos
	// Permite generar el objeto sin atributos, incompletos, o todos segun sea la necesidad
	
	public Rol() {}
	
	public Rol(int idRol) {
		this.idRol = idRol;
	}
	
	public Rol(String NombreRol) {
		this.NombreRol = NombreRol;
	}
	
	public Rol(int idRol, String NombreRol) {
		this.idRol = idRol;
		this.NombreRol = NombreRol;
	}

	// Get y set de cada atributo 
	
	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}

	// Convertir a string cada atributo para ser visualizado
	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", NombreRol=" + NombreRol + "]";
	}
}

