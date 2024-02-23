
package Conexion;

import Objetos.*;
import java.sql.*;
import java.util.*;

public class IndicacionDAO {
    private static final String SQL_SELECT = "SELECT * FROM indicaciones";
    private static final String SQL_INSERT = "INSERT INTO indicaciones(nombreind,idescripcion) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE indicaciones SET idescripcion = ? WHERE nombreind = ?";
    private static final String SQL_DELETE = "DELETE FROM indicaciones WHERE nombreind = ?";
    
    public List<Indicacion> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Indicacion indicacion = null;
        List<Indicacion> listaIndicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombreind");
                String descripcion = rs.getString("idescripcion");
                indicacion = new Indicacion(nombre,descripcion);
                listaIndicaciones.add(indicacion);
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
        return listaIndicaciones;
    }
    
    public int insertar(Indicacion indicacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, indicacion.getNombre());
            stmt.setString(2, indicacion.getDescripcion());
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
    
    public int modificar(Indicacion indicacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, indicacion.getDescripcion());
            stmt.setString(2, indicacion.getNombre());
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
    
    public int eliminar(String nombre){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, nombre);
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
