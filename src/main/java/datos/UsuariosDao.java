package datos;

import static datos.Conexion.*;

import modelos.Recaudo;
import modelos.Usuario;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class UsuariosDao {

    private static final String SQL_SELECT = "SELECT * FROM Usuarios";
    //private static final String SQL_SELECT_ID = "SELECT * FROM Usuarios WHERE idusuarios=?";
    private static final String SQL_SELECT_USERNAME = "SELECT * FROM Usuarios WHERE nombreusuario=?";
    private static final String SQL_SELECT_CEDULA = "SELECT * FROM Usuarios WHERE cedula=?";
    private static final String SQL_INSERT = "INSERT INTO Usuarios(idrol, nombre, apellido, cedula, nombreusuario, clave) VALUES(?, ?, ?, ?, ?,crypt(?, gen_salt('bf')))";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET idrol = ?, nombre = ?, apellido = ?, cedula = ?, nombreusuario = ?  WHERE idusuarios = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuarios WHERE idusuarios = ?";
    private static final String SQL_SELECT_CLAVE = "SELECT *  FROM Usuarios WHERE nombreusuario = ? AND clave = crypt(?, clave)";
    
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idusuarios");
                int idRol = rs.getInt("idrol");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double cedula = rs.getDouble("cedula");
                String nombreUsuario = rs.getString("nombreusuario");
                String clave = rs.getString("clave");
                
  
                usuario = new Usuario(idUsuario, idRol, nombre, apellido, cedula, nombreUsuario, clave);

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
			close(stmt);
			close(conn);
        }

        return usuarios;
    }
    
    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
        	
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, usuario.getIdRol());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setDouble(4,usuario.getCedula());
            stmt.setString(5, usuario.getNombreUsuario());
            stmt.setString(6, usuario.getClave());
             
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
			close(conn);
        }
        return registros;
    }
    
    public int actualizar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
        	
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, usuario.getIdRol());
            stmt.setString(2, usuario.getNombre());
            stmt.setInt(7, usuario.getIdUsuario());
            stmt.setString(3,usuario.getApellido());
            stmt.setDouble(4, usuario.getCedula());
            stmt.setString(5, usuario.getNombreUsuario());
            //stmt.setString(6, usuario.getClave());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
			close(conn);
        }
        return registros;
    }
    
    
     public int eliminar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
			close(conn);
        }
        return registros;
    }
     
     public Usuario selectByNombreUsuario(Usuario usuario){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Usuario usuarioBusqueda = null;
         
         try {
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_USERNAME);
             stmt.setString(1, usuario.getNombreUsuario());
             rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int idUsuario = rs.getInt("idusuarios");
                 int idRol = rs.getInt("idrol");
                 String nombre = rs.getString("nombre");
                 String apellido = rs.getString("apellido");
                 double cedula = rs.getDouble("cedula");
                 String nombreUsuario = rs.getString("nombreusuario");
                 String clave = rs.getString("clave");
                 usuarioBusqueda = new Usuario(idUsuario,idRol, nombre,apellido,cedula,nombreUsuario,clave );
                 //recaudo.setIdRecaudo(idRecaudo);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             close(rs);
             close(stmt);
             close(conn);
         }
         return usuarioBusqueda;
     }
     
     public Usuario selectByCedula(Usuario usuario){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Usuario usuarioBusqueda = null;
         
         try {
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_CEDULA);
             stmt.setDouble(1, usuario.getCedula());
             rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int idUsuario = rs.getInt("idusuarios");
                 int idRol = rs.getInt("idrol");
                 String nombre = rs.getString("nombre");
                 String apellido = rs.getString("apellido");
                 double cedula = rs.getDouble("cedula");
                 String nombreUsuario = rs.getString("nombreusuario");
                 String clave = rs.getString("clave");
                 usuarioBusqueda = new Usuario(idUsuario,idRol, nombre,apellido,cedula,nombreUsuario,clave );
                 //recaudo.setIdRecaudo(idRecaudo);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             close(rs);
             close(stmt);
             close(conn);
         }
         return usuarioBusqueda;
     }
     
     public Usuario selectByClave(Usuario usuario){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Usuario usuarioBusqueda = null;
         
         try {
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_CLAVE);
             stmt.setString(1, usuario.getNombreUsuario());
             stmt.setString(2, usuario.getClave());
             rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int idUsuario = rs.getInt("idusuarios");
                 int idRol = rs.getInt("idrol");
                 String nombre = rs.getString("nombre");
                 String apellido = rs.getString("apellido");
                 double cedula = rs.getDouble("cedula");
                 String nombreUsuario = rs.getString("nombreusuario");
                 String clave = rs.getString("clave");
                 usuarioBusqueda = new Usuario(idUsuario,idRol, nombre,apellido,cedula,nombreUsuario,clave );
                 //recaudo.setIdRecaudo(idRecaudo);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             close(rs);
             close(stmt);
             close(conn);
         }
         return usuarioBusqueda;
     }
}

