/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class EmpleadoDAO {

    public boolean insertar(Empleado a) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.empleado(cedula, nombre, correo, usuario, contrasena, tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, a.getCedula());
            stm.setString(2, a.getNombre());
            stm.setString(3, a.getCorreo());
            stm.setString(4, a.getUsuario());
            stm.setString(5, a.getContrasena());
            stm.setString(6, String.valueOf(a.getTipo()));

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            
            throw new RuntimeException("Intente nuevamente");
        }

    
}

    public Empleado auntenticar(Empleado e) {
        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id, cedula, nombre, correo, usuario, contrasena, tipo, activo from h.empleado "
                    + " where activo = true and contrasena = ? "
                    + " and (usuario = ? or correo = ?) ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, e.getContrasena());
            stm.setString(2, e.getUsuario());
            stm.setString(3, e.getUsuario());

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return cargar(rs);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Problemas con la base de datos");
        }
        return null;
    }

    private Empleado cargar(ResultSet rs) throws SQLException {
        Empleado e = new Empleado();
        e.setId(rs.getInt(1));
        e.setCedula(rs.getInt(2));
        e.setNombre(rs.getString(3));
        e.setCorreo(rs.getString(4));
        e.setUsuario(rs.getString(5));
        e.setContrasena(rs.getString(6));
        e.setTipo(rs.getString(7).charAt(0));
        e.setActivo(rs.getBoolean(8));
      
        return e;
    }
    
    public Empleado cargarID(int id) {
        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id, cedula, nombre, correo, usuario, contrasena, tipo, activo from h.empleado "
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
    public LinkedList<Empleado> buscar(String filtro) {
        LinkedList<Empleado> clientes = new LinkedList<>();

        try ( Connection con = Conexion.getConexion()) {
            String sql = " select id, cedula, nombre, correo, usuario, contrasena, tipo, activo from h.empleado"
                    + " where lower(nombre) like lower(?) ";
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
    
    public boolean editar(Empleado a, boolean estado) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " update h.empleado set cedula = ?, nombre = ?, correo=?, usuario =?, contrasena = ?, "
                    + "  tipo = ?, activo = ? "
                    + " where id = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, a.getCedula());
                stm.setString(2, a.getNombre());
                stm.setString(3, a.getCorreo());
                stm.setString(4, a.getUsuario());
                stm.setString(5, a.getContrasena());
                stm.setString(6, String.valueOf(a.getTipo()));
                stm.setBoolean(7, estado);
                stm.setInt(8, a.getId());
            

            return stm.executeUpdate() == 1;

        } catch (Exception ex) {
            String msj = "Problemas al editar";
            
            throw new RuntimeException(msj);
        }

    
}


}
