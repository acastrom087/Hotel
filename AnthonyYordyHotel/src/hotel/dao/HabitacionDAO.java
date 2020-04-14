/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Castro Mesen
 */
public class HabitacionDAO {
    
    public LinkedList<Habitacion> seleccionar(String filtro) {
        LinkedList<Habitacion> habitaciones = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = "select id,cedula, nombre, apellido_uno, apellido_dos, telefono, genero, estado_civil, direccion, activo from h.habitaciones "
                    + " order by id";
            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, filtro + '%');
//            stm.setString(2, filtro + '%');

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                habitaciones.add(cargar(rs));
            }

        } catch (Exception ex) {
            throw new RuntimeException("Favor intente nuevamente");
        }
        return habitaciones;
    }

    private Habitacion cargar(ResultSet rs) throws SQLException {
        Habitacion h = new Habitacion();
        h.setId(rs.getInt(1));
        h.setCedula(rs.getString(2));
        h.setNombre(rs.getString(3));
        h.setApellidoUno(rs.getString(4));
        h.setApellidoDos(rs.getString(5));
        h.setTelefono(rs.getString(6));
        h.setGenero(rs.getString(7).charAt(0));

        return e;
    }
    
}
