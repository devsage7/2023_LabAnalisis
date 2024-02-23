package Objetos;

import java.util.Date;

public class Resultado {
    private String resultadoAnalisis;
    private Date fecha;
    private Analisis analisis;
    
    public Resultado(String resultadoAnalisis, Date fecha) {
        this.resultadoAnalisis = resultadoAnalisis;
        this.fecha = fecha;
        this.analisis = null;
    }
    
    public String getResultadoAnalisis() {
        return resultadoAnalisis;
    }
    
    public void setResultadoAnalisis(String resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Analisis getAnalisis() {
        return analisis;
    }
    
    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    @Override
    public String toString() {
        return "Resultado{" + "resultadoAnalisis=" + resultadoAnalisis + ", fecha=" + fecha + ", analisis=" + analisis + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}
