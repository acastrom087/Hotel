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
            String msj = ex.getMessage().contains("unq_usuarios_usuario")
                    ? "Usuario previamente registrado"
                    : ex.getMessage().contains("usuarios_correo_key")
                    ? "Correo previamente registrado"
                    : "Problemas al registrar el Usuario";
            ex.printStackTrace();
            throw new RuntimeException(msj);
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
            throw new RuntimeException("Favor intente nuevamente");
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
}
