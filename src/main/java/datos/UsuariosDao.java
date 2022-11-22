package datos;

import static datos.Conexion.*;
import modelos.Usuario;
import java.sql.*;
import java.util.*;

public class UsuariosDao {

    private static final String SQL_SELECT = "SELECT id_usuarios, id_rol, nombre FROM Usuarios";
    private static final String SQL_INSERT = "INSERT INTO Usuarios(id_rol, nombre) VALUES(?, ?::character varying[])";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET id_rol = ?, nombre = ?::character varying[]  WHERE id_usuarios = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuarios WHERE id_usuarios = ?";
    
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
                int idUsuario = rs.getInt("id_usuarios");
                int idRol = rs.getInt("id_rol");
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
}
