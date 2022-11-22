package datos;

import static datos.Conexion.*;
import modelos.Rol;
import java.sql.*;
import java.util.*;

public class RolDao {

    private static final String SQL_SELECT = "SELECT id_rol, nombre FROM Rol";
    private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?::character varying[])";
    private static final String SQL_UPDATE = "UPDATE Rol SET nombre = ?::character varying[] WHERE id_rol = ?";
    private static final String SQL_DELETE = "DELETE FROM Rol WHERE id_rol = ?";
    
    public List<Rol> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Rol rol = null;
        List<Rol> roles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
             
                int idRol = rs.getInt("id_rol");
                String nombre = rs.getString("nombre");
  
                rol = new Rol(idRol, nombre);

                roles.add(rol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
			close(stmt);
			close(conn);
        }

        return roles;
    }
    
    public int insertar(Rol rol){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
        	
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, rol.getNombreRol());
  
            
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
    
    public int actualizar(Rol rol){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
        	
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, rol.getNombreRol());
            stmt.setInt(2, rol.getIdRol());
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
    
    
     public int eliminar(Rol rol){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, rol.getIdRol());
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
