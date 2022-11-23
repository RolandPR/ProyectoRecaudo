package application.datos;

import static application.datos.Conexion.*;
import java.sql.*;
import java.util.*;
import application.modelos.TiposDocumentos;

public class TiposDocumentosDAO {

    private static final String SQL_SELECT = "SELECT * FROM tiposdocumentos";
    private static final String SQL_INSERT = "INSERT INTO tiposdocumentos(nombre) VALUES (?)";
    private static final String SQL_SELECT_ID = "SELECT nombre FROM tiposdocumentos WHERE idtiposdocumentos=?";
    private static final String SQL_DELETE = "DELETE FROM tiposdocumentos WHERE idtiposdocumentos=?";
    private static final String SQL_UPDATE = "UPDATE tiposdocumentos SET nombre=? WHERE idtiposdocumentos=?";

    public TiposDocumentosDAO() {
    }
    
    public TiposDocumentos selectById(int idTiposDocumentos){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposDocumentos tiposDocumentos = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, idTiposDocumentos);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                tiposDocumentos = new TiposDocumentos(nombre);
                tiposDocumentos.setIdTiposDocumentos(idTiposDocumentos);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return tiposDocumentos;
    }

    public List<TiposDocumentos> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposDocumentos tipoDocumento = null;
        List<TiposDocumentos> tiposDocumentos = new ArrayList<TiposDocumentos>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTiposDocumentos = rs.getInt("idTiposDocumentos");
                String nombre = rs.getString("nombre");

                tipoDocumento = new TiposDocumentos(nombre);
                tipoDocumento.setIdTiposDocumentos(idTiposDocumentos);
                tiposDocumentos.add(tipoDocumento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return tiposDocumentos;
    }

    public int insertar(TiposDocumentos tiposDocumentos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tiposDocumentos.getNombre());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(TiposDocumentos tiposDocumentos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tiposDocumentos.getNombre());
            stmt.setInt(2, tiposDocumentos.getIdTiposDocumentos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int eliminar(TiposDocumentos tiposDocumentos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tiposDocumentos.getIdTiposDocumentos());
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
