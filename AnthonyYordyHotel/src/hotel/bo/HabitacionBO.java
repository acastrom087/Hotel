/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.HabitacionDAO;
import hotel.entities.Habitacion;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class HabitacionBO {

    public LinkedList<Habitacion> buscar(String filtro) {
        return new HabitacionDAO().buscar(filtro); 
    }
    
    public boolean insertar(Habitacion h){
        if (h == null) {
            throw new RuntimeException("Ingrese una habitacion");
        }
        if (h.getCapacidadMax() <= 0) {
            throw new RuntimeException("Capacidad maxima invalida");
        }
        if (h.getCapacidadMin() <= 0) {
            throw new RuntimeException("Capacidad minima invalida");
        }
        if (h.getPrecioNoche() <= 0) {
            throw new RuntimeException("Precio por noche invalida");
        }
        if (h.getId()>0) {
            return new HabitacionDAO().editar(h);
        }
        else{
        return new HabitacionDAO().insertar(h);
        }
    }
    
    public boolean activar(Habitacion h){
        if (h == null) {
            throw new RuntimeException("Debe de seleccionar una habitacion");
        }if (h.isActivo()) {
            return true;
        }
        h.setActivo(true);
        return new HabitacionDAO().editar(h); 
    }
    
        public boolean desactivar(Habitacion h){
        if (h == null) {
            throw new RuntimeException("Debe de seleccionar una habitacion");
        }if (!h.isActivo()) {
            
            return true;
        }
        h.setActivo(false);
        return new HabitacionDAO().editar(h); 
    }
    
    
}
