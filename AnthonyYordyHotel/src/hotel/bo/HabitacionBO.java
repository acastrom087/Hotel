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

    public LinkedList<Habitacion> buscar() {
        return new HabitacionDAO().buscar(); 
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
        
        return new HabitacionDAO().insertar(h);
    }
    
    
}
