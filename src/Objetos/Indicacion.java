package Objetos;

import java.util.ArrayList;
import java.util.List;

public class Indicacion {
    private String nombre;
    private String descripcion;
    private List<Analisis> analisisList;
    
    public Indicacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        analisisList = new ArrayList<>();
    }

    public void agregarAnalisis(Analisis analisis) {
        analisisList.add(analisis);
        analisis.agregarIndicacion(this);
    }
    
    public void eliminarAnalisis(Analisis analisis) {
        analisisList.remove(analisis);
        analisis.eliminarIndicacion(this);
    }
    
    // Otros métodos de la clase Indicacion
    
    // Getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    @Override
    public String toString() {
        return "Indicacion{" + "descripcion=" + descripcion + ", analisisList=" + analisisList + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}