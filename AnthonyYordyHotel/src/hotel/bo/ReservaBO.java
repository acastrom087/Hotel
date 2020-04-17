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

/**
 *
 * @author HP
 */
public class ReservaBO {
    public boolean insertar(Reserva r, Cliente c, int id, Empleado e){
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
        return new ReservaDAO().insertar(r, c, id, e);
    }
}
