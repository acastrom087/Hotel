/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Cliente;
import hotel.entities.Empleado;
import hotel.entities.Habitacion;
import hotel.entities.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class ReservaDAO {

    public boolean insertar(Reserva r, Cliente c, int id, Empleado e) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.reserva(fecha_entrada, fecha_salida, id_cliente, id_habitacion, id_empleado) "
                    + " VALUES (?, ?, ?, ?, ?) ";
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

    public LinkedList<Reserva> cargar() {
        LinkedList<Reserva> reserva = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id, fecha_entrada, fecha_salida, id_cliente, id_habitacion, id_empleado "
                    +      "from h.reserva ";
                    
            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, filtro + '%');
//            stm.setString(2, filtro + '%');

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                reserva.add(cargar(rs));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Favor intente nuevamente");
        }
        return reserva;
    }

    private Reserva cargar(ResultSet rs) throws SQLException {
        Reserva r = new Reserva();
        r.setId(rs.getInt(1));
        r.setFecha_entrada(rs.getDate(2).toLocalDate());
        r.setFecha_salida(rs.getDate(3).toLocalDate());
        r.setCliente(new ClienteDAO().cargarID(rs.getInt(4)));
        r.setHabitacion(new HabitacionDAO().cargarID(rs.getInt(5)));
        r.setEmpleado(new EmpleadoDAO().cargarID(rs.getInt(6)));


        return r;
    }
    
    public LinkedList<Reserva> ocupados() {
        LinkedList<Reserva> reserva = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id, fecha_entrada, fecha_salida, id_cliente, id_habitacion, id_empleado "
                    +      "from h.reserva "
                    +       " where ? between fecha_entrada and fecha_salida ";
                    
            PreparedStatement stm = con.prepareStatement(sql);
           stm.setDate(1, Date.valueOf(LocalDate.now()));
//            stm.setString(2, filtro + '%');

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                reserva.add(cargar(rs));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Favor intente nuevamente");
        }
        return reserva;
    }
    
    
}
