package Objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orden {
    private int nroOrden;
    private Date fecha;
    private String obraSocial;
    private Paciente paciente;
    private List<Analisis> analisisList;
    
    public Orden(int nroOrden, Date fecha, String obraSocial, Paciente paciente) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.obraSocial = obraSocial;
        this.paciente = paciente;
        analisisList = new ArrayList<>();
    }
    
    public void agregarAnalisis(Analisis analisis) {
        analisisList.add(analisis);
        analisis.agregarOrden(this);
    }
    
    public void eliminarAnalisis(Analisis analisis) {
        analisisList.remove(analisis);
        analisis.eliminarOrden(this);
    }
    
    // Otros métodos de la clase Orden
    
    // Getters y setters
    
    public int getNroOrden() {
        return nroOrden;
    }
    
    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getObraSocial() {
        return obraSocial;
    }
    
    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    @Override
    public String toString() {
        return "Orden{" + "nroOrden=" + nroOrden + ", fecha=" + fecha + ", obraSocial=" + obraSocial + ", paciente=" + paciente + ", analisisList=" + analisisList + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}
