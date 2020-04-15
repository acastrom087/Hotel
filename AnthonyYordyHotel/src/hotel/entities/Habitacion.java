/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Habitacion {
    
    private int id;
    private int capacidadMax;
    private int capacidadMin;
    private String tipo;
    private int precioNoche;
    private boolean disponible;
    private boolean activo;
    private Empleado empleado;

    public Habitacion() {
    }

    public Habitacion(int id, int capacidadMax, int capacidadMin, String tipo, int precioNoche, boolean disponible, boolean activo, Empleado empleado) {
        this.id = id;
        this.capacidadMax = capacidadMax;
        this.capacidadMin = capacidadMin;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.disponible = disponible;
        this.activo = activo;
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getId() {
        return id;
    }


    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public int getCapacidadMin() {
        return capacidadMin;
    }

    public void setCapacidadMin(int capacidadMin) {
        this.capacidadMin = capacidadMin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", capacidadMax=" + capacidadMax + ", capacidadMin=" + capacidadMin + ", tipo=" + tipo + ", precioNoche=" + precioNoche + ", disponible=" + disponible + ", activo=" + activo + '}';
    }
    
    
    
    
}
