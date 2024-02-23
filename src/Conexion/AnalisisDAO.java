
package Conexion;

import Objetos.*;
import java.sql.*;
import java.util.*;

public class AnalisisDAO {
    private static final String SQL_SELECT = "SELECT * FROM analisis";
    private static final String SQL_INSERT = "INSERT INTO analisis(anombre,acod,adescripcion) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE analisis SET anombre = ?, adescripcion = ? WHERE acod = ?";
    private static final String SQL_DELETE = "DELETE FROM analisis WHERE acod = ?";
    
    public List<Analisis> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Analisis analisis = null;
        List<Analisis> listaAnalisis = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("acod");
                String nombre = rs.getString("anombre");
                String descripcion = rs.getString("adescripcion");
                analisis = new Analisis(nombre,codigo,descripcion);
                listaAnalisis.add(analisis);
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
        return listaAnalisis;
    }
    
    public int insertar(Analisis analisis){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, analisis.getNombre());
            stmt.setInt(2, analisis.getCodigo());
            stmt.setString(3, analisis.getDescripcion());
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
    
    public int modificar(Analisis analisis){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, analisis.getNombre());
            stmt.setString(2, analisis.getDescripcion());
            stmt.setInt(3, analisis.getCodigo());
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
    
    public int eliminar(int codigo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, codigo);
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
