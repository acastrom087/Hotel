/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class ClienteDAO {
    
    
    public LinkedList<Cliente> buscar(String filtro) {
        LinkedList<Cliente> clientes = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id,cedula,nombre,celular,correo from h.cliente "+
                            " where lower(nombre) like lower(?)  ";
                    
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, filtro + '%');
           // stm.setString(2, filtro + '%');

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                clientes.add(cargar(rs));
            }

        } catch (Exception ex) {
            
            throw new RuntimeException("Favor intente nuevamente");
        }
        return clientes;
    }

    private Cliente cargar(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt(1));
        c.setCedula(rs.getInt(2));
        c.setNombre(rs.getString(3));
        c.setCelular(rs.getInt(4));
        c.setCorreo(rs.getString(5));

        return c;
    }
    
    
    public boolean insertar(Cliente c) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.cliente(cedula, nombre, celular, correo) "
                    + "VALUES (?, ?, ?, ?) ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, c.getCedula());
            stm.setString(2, c.getNombre());
            stm.setInt(3, c.getCelular());
            stm.setString(4, c.getCorreo());
            
            
            

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            
            throw new RuntimeException("Intente de nuevo");
        }
    
}       
        public Cliente cargarID(int id) {
        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id,cedula,nombre,celular,correo from h.cliente "+
                            " where id =? ";
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
        
        public boolean editar(Cliente c) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " update h.cliente set cedula = ?, nombre = ?, celular=?, correo =? "
                    + " where id = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, c.getCedula());
                stm.setString(2, c.getNombre());
                stm.setInt(3, c.getCelular());
                stm.setString(4, c.getCorreo());
                stm.setInt(5, c.getId());
            

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            String msj = "Problemas al editar";
            
            throw new RuntimeException(msj);
        }
    
        }
    
}
