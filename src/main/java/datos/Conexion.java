package datos;

import java.sql.*;

public class Conexion {
	//jdbc:postgresql://localhost:5432/ProyectoRecaudo
	//Esca1323#pr
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/DataBaseTest";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "admin";

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
