
package Conexion;

import Objetos.*;
import java.sql.*;
import java.util.*;

public class PacienteDAO {
    private static final String SQL_SELECT = "SELECT * FROM pacientes";
    private static final String SQL_INSERT = "INSERT INTO pacientes(pdni,pnombreyape,ptel,pfecnac,pedad,psexo) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE pacientes SET pnombreyape = ?, ptel = ?, pfecnac = ?, pedad = ?, psexo = ? WHERE pdni = ?";
    private static final String SQL_DELETE = "DELETE FROM pacientes WHERE pdni = ?";
    
    public List<Paciente> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int dni = rs.getInt("pdni");
                String nom = rs.getString("pnombreyape");
                long tel = rs.getLong("ptel");
                java.sql.Date fecNac = rs.getDate("pfecnac");
                int edad = rs.getInt("pedad");
                int sexo = rs.getInt("psexo");
                        
                paciente = new Paciente(nom,tel,fecNac,edad,sexo,dni);
                listaPacientes.add(paciente);
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
        return listaPacientes;
    }
    
    public int insertar(Paciente paciente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setInt(1, paciente.getDni());
            stmt.setString(2, paciente.getNomyape());
            stmt.setLong(3, paciente.getTel());
            
            java.util.Date utilD = paciente.getFecNac();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            
            stmt.setDate(4, sqlD);  ////////
            stmt.setInt(5, paciente.getEdad());
            stmt.setInt(6, paciente.getSexo());
            
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
    
    public int modificar(Paciente paciente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, paciente.getNomyape());
            stmt.setLong(2, paciente.getTel());
            
            java.util.Date utilD = paciente.getFecNac();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            
            stmt.setDate(3, sqlD);  ////////
            stmt.setInt(4, paciente.getEdad());
            stmt.setInt(5, paciente.getSexo());
            stmt.setInt(6, paciente.getDni());
            
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
    
    public int eliminar(int dni){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dni);
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
