/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

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
    
}
