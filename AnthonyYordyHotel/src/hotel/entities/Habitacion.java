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
    private char tipo;
    private double precioNoche;
    private boolean disponible;
    private boolean activo;

    public Habitacion() {
    }

    public Habitacion(int id, int capacidadMax, int capacidadMin, char tipo, double precioNoche, boolean disponible, boolean activo) {
        this.id = id;
        this.capacidadMax = capacidadMax;
        this.capacidadMin = capacidadMin;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.disponible = disponible;
        this.activo = activo;
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
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
