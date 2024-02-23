package Objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente {
    private String nomyape;
    private long tel;
    private Date fecNac;
    private int edad;
    private int sexo;
    private int dni;
    private List<Orden> ordenes;
    
    public Paciente(String nomyape, long tel, Date fecNac, int edad, int sexo, int dni) {
        this.nomyape = nomyape;
        this.tel = tel;
        this.fecNac = fecNac;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
        ordenes = new ArrayList<>();
    }
    
    public Paciente(int dni)    {   ////////
        this.nomyape = null;
        this.tel = -1;
        this.fecNac = null;
        this.edad = -1;
        this.sexo = -1;
        this.dni = dni;
        ordenes = new ArrayList<>();
    }
    
    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
        orden.setPaciente(this);
    }
    
    public void eliminarOrden(Orden orden) {
        ordenes.remove(orden);
        orden.setPaciente(null);
    }
    
    // Otros métodos de la clase Paciente
    
    // Getters y setters
    
    public String getNomyape() {
        return nomyape;
    }
    
    public void setNomyape(String nomyape) {
        this.nomyape = nomyape;
    }
    
    public long getTel() {
        return tel;
    }
    
    public void setTel(long tel) {
        this.tel = tel;
    }
    
    public Date getFecNac() {
        return fecNac;
    }
    
    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getSexo() {
        return sexo;
    }
    
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
    public int getDni() {
        return dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public List<Orden> getOrdenes() {
        return ordenes;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nomyape=" + nomyape + ", tel=" + tel + ", fecNac=" + fecNac + ", edad=" + edad + ", sexo=" + sexo + ", dni=" + dni + ", ordenes=" + ordenes + '}';
    }
    
    public void mostrar()   {
        System.out.println(this.toString());
    }
}