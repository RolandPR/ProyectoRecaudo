
package datos;

import static datos.Conexion.*;
import java.sql.*;
import java.util.*;
import modelos.Proveedores;


public class ProveedoresDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM proveedores";
    private static final String SQL_INSERT = "INSERT INTO proveedores(nombre) VALUES (?)";
    private static final String SQL_SELECT_ID = "SELECT nombre FROM proveedores WHERE idproveedores=?";
    private static final String SQL_DELETE = "DELETE FROM proveedores WHERE idproveedores=?";
    private static final String SQL_UPDATE = "UPDATE proveedores set nombre=? WHERE idproveedores=?";

    public ProveedoresDAO() {
    }
    
    
    public Proveedores selectById(int idProveedores){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedores proveedor = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, idProveedores);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                proveedor = new Proveedores(nombre);
                proveedor.setIdProveedores(idProveedores);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return proveedor;
    }
    
    public List<Proveedores> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedores proveedor = null;
        List<Proveedores> proveedores = new ArrayList<Proveedores>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProveedores = rs.getInt("idProveedores");
                String nombre = rs.getString("nombre");

                proveedor = new Proveedores(nombre);
                proveedor.setIdProveedores(idProveedores);
                proveedores.add(proveedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return proveedores;
    }
    
    public int insertar(Proveedores proveedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedores.getNombre());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int actualizar(Proveedores proveedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedores.getNombre());
            stmt.setInt(2, proveedores.getIdProveedores());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int eliminar(Proveedores proveedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proveedores.getIdProveedores());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
}
