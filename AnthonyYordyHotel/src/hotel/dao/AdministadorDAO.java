/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class AdministadorDAO {

    public boolean insertar(Administrador a) {
        try ( java.sql.Connection con = Conexion.getConexion()) {
            String sql = " INSERT INTO  h.administrador(cedula, nombre, correo, usuario, contrasena, tipo) "
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
}
