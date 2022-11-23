package application.datos;

import static application.datos.Conexion.*;
import application.modelos.Rol;
import application.modelos.Usuario;

import java.sql.*;
import java.util.*;

public class RolDao {

    private static final String SQL_SELECT = "SELECT *  FROM Rol";
    private static final String SQL_SELECT_ID = "SELECT * FROM Rol WHERE idrol=?";
    private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE Rol SET nombre = ? WHERE idrol = ?";
    private static final String SQL_DELETE = "DELETE FROM Rol WHERE idrol = ?";
    
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
             
                int idRol = rs.getInt("idrol");
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
     
     public Rol selectById(int idRol){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Rol rol = null;
         
         try {
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_ID);
             stmt.setInt(1, idRol);
             rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int idRol_1 = rs.getInt("idrol");
                 String nombre = rs.getString("nombre");
                         
                 rol = new Rol(idRol_1,nombre );
                 //recaudo.setIdRecaudo(idRecaudo);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             close(rs);
             close(stmt);
             close(conn);
         }
         return rol;
     }
}
