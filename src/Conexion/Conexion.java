package Conexion;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/LaboratorioDeAnalisisClinicos";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "usuario";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}


