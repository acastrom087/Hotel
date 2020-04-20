/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;


import hotel.entities.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class hotelDAO {

    public Hotel verificar(){
        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id,fila,columna from h.hotel ";
            PreparedStatement stm = con.prepareStatement(sql);
            

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return cargar(rs);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Favor intente nuevamente");
        }
        return null;
    }
    
    private Hotel cargar(ResultSet rs) throws SQLException {
        Hotel h = new Hotel();
        h.setId(rs.getInt(1));
        h.setFilas(rs.getInt(2));
        h.setColumna(rs.getInt(3));
        

        return h;
    }        
    
}
