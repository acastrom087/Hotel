/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Cliente;
import hotel.entities.Empleado;
import hotel.entities.Reserva;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class ReservaDAO {

    public boolean insertar(Reserva r, Cliente c, int id, Empleado e) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.reserva(fecha_entrada, fecha_salida, id_cliente, id_habitacion, id_empleado) "
                    + "VALUES (?, ?, ?, ?, ?) ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1,Date.valueOf(r.getFecha_entrada()));
            stm.setDate(2,Date.valueOf(r.getFecha_salida()));
            stm.setInt(3, c.getId());
            stm.setInt(4, id);
            stm.setInt(5, e.getId());
            
            
            

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            
            throw new RuntimeException("Problemas al hacer la reserva");
        }
    }
    
}
