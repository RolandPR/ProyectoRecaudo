package datos;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ProyectoRecaudo";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "Esca1323#pr";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
