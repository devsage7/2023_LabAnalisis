
package Conexion;

import Objetos.*;
import java.sql.*;
import java.util.*;

public class OrdenDAO {
    private static final String SQL_SELECT = "SELECT * FROM orden";
    private static final String SQL_INSERT = "INSERT INTO orden(nroorden,ofec,obras,pdni) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE orden SET ofec = ?, obras = ?, pdni = ? WHERE nroorden = ?";
    private static final String SQL_DELETE = "DELETE FROM orden WHERE nroorden = ?";
    
    public List<Orden> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Orden orden = null;
        List<Orden> listaOrdenes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int nro = rs.getInt("nroorden");
                java.sql.Date fecha = rs.getDate("ofec");
                String obraSocial = rs.getString("obras");
                Paciente paciente = new Paciente(rs.getInt("pdni"));
                orden = new Orden(nro,fecha,obraSocial,paciente);
                listaOrdenes.add(orden);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return listaOrdenes;
    }
    
    public int insertar(Orden orden){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, orden.getNroOrden());
            java.util.Date utilD = orden.getFecha();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(2, sqlD);  ////////
            stmt.setString(3, orden.getObraSocial());
            stmt.setInt(4, orden.getPaciente().getDni());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int modificar(Orden orden){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            java.util.Date utilD = orden.getFecha();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(1, sqlD);  ////////
            stmt.setString(2, orden.getObraSocial());
            stmt.setInt(3, orden.getPaciente().getDni());
            stmt.setInt(4, orden.getNroOrden());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(int nro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, nro);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}

