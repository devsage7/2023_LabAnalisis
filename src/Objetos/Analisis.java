package Objetos;

import java.util.ArrayList;
import java.util.List;

public class Analisis {
    private String nombre;
    private int codigo;
    private String descripcion;
    private List<Orden> ordenes;
    private List<Resultado> resultados;
    private List<Indicacion> indicaciones;
    private List<Insumo> insumos;
    
    public Analisis(String nombre, int codigo, String descripcion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        ordenes = new ArrayList<>();
        resultados = new ArrayList<>();
        indicaciones = new ArrayList<>();
        insumos = new ArrayList<>();
    }
    
    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
        orden.agregarAnalisis(this);
    }
    
    public void eliminarOrden(Orden orden) {
        ordenes.remove(orden);
        orden.eliminarAnalisis(this);
    }
    
    public void agregarResultado(Resultado resultado) {
        resultados.add(resultado);
        resultado.setAnalisis(this);
    }
    
    public void eliminarResultado(Resultado resultado) {
        resultados.remove(resultado);
        resultado.setAnalisis(null);
    }
    
    public void agregarIndicacion(Indicacion indicacion) {
        indicaciones.add(indicacion);
        indicacion.agregarAnalisis(this);
    }
    
    public void eliminarIndicacion(Indicacion indicacion) {
        indicaciones.remove(indicacion);
        indicacion.eliminarAnalisis(this);
    }
    
    public void agregarInsumo(Insumo insumo) {
        insumos.add(insumo);
        insumo.agregarAnalisis(this);
    }
    
    public void eliminarInsumo(Insumo insumo) {
        insumos.remove(insumo);
        insumo.eliminarAnalisis(this);
    }
    
    // Otros métodos de la clase Analisis
    
    // Getters y setters
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Orden> getOrdenes() {
        return ordenes;
    }
    
    public List<Resultado> getResultados() {
        return resultados;
    }
    
    public List<Indicacion> getIndicaciones() {
        return indicaciones;
    }
    
    public List<Insumo> getInsumos() {
        return insumos;
    }

    @Override
    public String toString() {
        return "Analisis{" + "nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", ordenes=" + ordenes + ", resultados=" + resultados + ", indicaciones=" + indicaciones + ", insumos=" + insumos + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}