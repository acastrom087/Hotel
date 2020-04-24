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
    
    public LinkedList<Habitacion> buscar(String filtro) {
        LinkedList<Habitacion> habitaciones = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = "select id, capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo from h.habitacion"
                    +    " where lower(tipo) like lower(?) ";
                    
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, filtro + '%');
            

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
        h.setCapacidadMax(rs.getInt(2));
        h.setCapacidadMin(rs.getInt(3));
        h.setTipo(rs.getString(4));
        h.setPrecioNoche(rs.getInt(5));
        h.setDisponible(rs.getBoolean(6));
        h.setActivo(rs.getBoolean(7));

        return h;
    }
    
    public boolean insertar(Habitacion h) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.habitacion(capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo) "
                    + "VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, h.getCapacidadMax());
            stm.setInt(2, h.getCapacidadMin());
            stm.setString(3, h.getTipo());
            stm.setInt(4, h.getPrecioNoche());
            stm.setBoolean(5, h.isDisponible());
            stm.setBoolean(6, h.isActivo());
            

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            
            
            throw new RuntimeException("Favor intente de nuevo");
        }

    
}
    
    public Habitacion cargarID(int id) {
        try ( Connection con = Conexion.getConexion()) {
            String sql = "select id, capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo from h.habitacion"
                    + " where id = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return cargar(rs);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Favor intente nuevamente");
        }
        return null;
    }
    
    public boolean editar(Habitacion h ) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " update h.habitacion set capacidad_max = ?, capacidad_min= ?, tipo=?, precio_noche=?, disponible= ?, "
                    + "  activo = ? "
                    + " where id = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, h.getCapacidadMax());
                stm.setInt(2, h.getCapacidadMin());
                stm.setString(3, h.getTipo());
                stm.setInt(4, h.getPrecioNoche());
                stm.setBoolean(5, h.isDisponible());
                stm.setBoolean(6, h.isActivo());
                stm.setInt(7, h.getId());

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            
            
            throw new RuntimeException("Intente nuevamente");
        }

    
}
    
}
