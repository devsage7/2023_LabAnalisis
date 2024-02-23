package Objetos;

import java.util.ArrayList;
import java.util.List;

public class Insumo {
    private int codigo;
    private String tipo;
    private String nombre;
    private int stock;
    private int stock_min;
    private List<Analisis> analisisList;
    
    public Insumo(int codigo, String tipo, String nombre, int stock, int stock_min) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.stock = stock;
        this.stock_min = stock_min;
        analisisList = new ArrayList<>();
    }
    
    public void agregarAnalisis(Analisis analisis) {
        analisisList.add(analisis);
        analisis.agregarInsumo(this);
    }
    
    public void eliminarAnalisis(Analisis analisis) {
        analisisList.remove(analisis);
        analisis.eliminarInsumo(this);
    }
    
    // Otros métodos de la clase Insumo
    
    // Getters y setters
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getStockMin() {
        return stock_min;
    }
    
    public void setStockMin(int stock_min) {
        this.stock_min = stock_min;
    }
    
    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    @Override
    public String toString() {
        return "Insumo{" + "codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", stock=" + stock + ", stock_min=" + stock_min + ", analisisList=" + analisisList + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}
