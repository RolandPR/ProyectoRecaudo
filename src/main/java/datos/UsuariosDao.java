package datos;

import static datos.Conexion.*;

import modelos.Recaudo;
import modelos.Usuario;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class UsuariosDao {

    private static final String SQL_SELECT = "SELECT * FROM Usuarios";
    private static final String SQL_SELECT_ID = "SELECT * FROM Usuarios WHERE idusuarios=?";
    private static final String SQL_INSERT = "INSERT INTO Usuarios(idrol, nombre) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET idrol = ?, nombre = ?  WHERE idusuarios = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuarios WHERE idusuarios = ?";
    
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
  
                usuario = new Usuario(idUsuario, idRol, nombre);

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
            stmt.setInt(3, usuario.getIdUsuario());
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
     
     public Usuario selectById(int idUsuario){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Usuario usuario = null;
         
         try {
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_ID);
             stmt.setInt(1, idUsuario);
             rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int idUsuario1 = rs.getInt("idusuarios");
                 int idRol = rs.getInt("idrol");
                 String nombre = rs.getString("nombre");
                         
                 usuario = new Usuario(idUsuario1,idRol, nombre );
                 //recaudo.setIdRecaudo(idRecaudo);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             close(rs);
             close(stmt);
             close(conn);
         }
         return usuario;
     }
}
