package test;

import java.util.List;

import datos.RolDao;
import datos.UsuariosDao;
import modelos.Rol;
import modelos.Usuario;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  	UsuariosDao usuarioDao = new UsuariosDao();
		  	RolDao rolDao = new RolDao();
		  	
		  	//System.out.println(usuarioDao.selectById(1));
	        //Insertando un nuevo objeto de tipo Persona
	        //Usuario usuarioNuevo = new Usuario(2,"Carlos");
	        //usuarioDao.insertar(usuarioNuevo);

	        //Modificar un objeto de persona existente
	        //Usuario usuarioModificar = new Usuario(1,2,"Camila");
	        //usuarioDao.actualizar(usuarioModificar);

	        //Eliminar un registro
	        //Usuario  usuarioEliminar = new Usuario(4);
	        //usuarioDao.eliminar(usuarioEliminar);
	        
	        //Listado Persona
	        //List<Rol> personas = rolDao.seleccionar();

	        //personas.forEach(persona -> {
	        //    System.out.println("persona = " + persona);
	        //});
		  	
		  	
		  //Insertando un nuevo objeto de tipo Persona
	       //Rol RolNuevo = new Rol("Trabajador");
	       //System.out.println(RolNuevo);
	       //rolDao.insertar(RolNuevo);
		  	
		  //Modificar un objeto de persona existente
	        //Rol RolModificar = new Rol(2,"esclavo premiun");
	        //rolDao.actualizar(RolModificar);
		  	
		  	//Eliminar un registro
	        //Rol rolEliminar = new Rol(4);
	        //System.out.println(rolEliminar);
	        //rolDao.eliminar(rolEliminar);

		  	System.out.println(rolDao.selectById(2));
	}

}
