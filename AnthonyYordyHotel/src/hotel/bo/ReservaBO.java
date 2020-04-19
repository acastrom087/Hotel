/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ReservaDAO;
import hotel.entities.Cliente;
import hotel.entities.Empleado;
import hotel.entities.Reserva;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class ReservaBO {
    
    public boolean insertar(Reserva r, Cliente c, int id, Empleado e){
        LinkedList<Reserva> list = new ReservaDAO().cargar();
        if (c == null) {
            throw new RuntimeException("Necesita un usuario ");
        }
        if (r.getFecha_entrada().isAfter(r.getFecha_salida())) {
            throw new RuntimeException("La fecha de salida debe ser despues que la de entrada");
        }
        if (r.getFecha_salida().isBefore(r.getFecha_entrada())) {
            throw new RuntimeException("La fecha de entrada debe de antes que la de salida");
        }
        if (r.getFecha_entrada().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha debe ser actual o a futuro");
        }
        if (list != null) {
            
        
        for (Reserva rh : list) {
            
            if (rh.getHabitacion().getId() == id) {
                if (r.getFecha_entrada().isAfter(rh.getFecha_entrada()) && r.getFecha_entrada().isBefore(rh.getFecha_salida())) {
                    throw new RuntimeException("Las fechas ingresadas no estan disponibles");
                }
                if (r.getFecha_entrada().isEqual(rh.getFecha_entrada())) {
                    throw new RuntimeException("Las fechas ingresadas no estan disponibles");
                }
                if (r.getFecha_salida().isAfter(rh.getFecha_entrada())&& r.getFecha_salida().isBefore(rh.getFecha_salida())) {
                    throw new RuntimeException("Las fechas ingresadas no estan disponibles");
                }
                if (r.getFecha_entrada().isBefore(rh.getFecha_entrada())&& r.getFecha_salida().isAfter(rh.getFecha_salida())) {
                    throw new RuntimeException("Las fecha ingresadas no estan disponibles");
                }
            }
        }
        }
        return new ReservaDAO().insertar(r, c, id, e);
    }

    public LinkedList<Reserva> cargar() {
            return new ReservaDAO().cargar();
    }

    public LinkedList<Reserva> ocupados() {
        
            return new ReservaDAO().ocupados();
    }
    
}
