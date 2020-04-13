/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;
import hotel.dao.AdministadorDAO;
import hotel.entities.Administrador;
/**
 *
 * @author HP
 */
public class AdministadorBO {
    
    public boolean insertar(Administrador a, String reContra){
        
        if (a == null) {
            throw new RuntimeException("Ingrese un administrador");  
        }
        
        if (Integer.toString(a.getCedula()).isBlank()) {
            throw new RuntimeException("Debe de ingresar una cedula");
        }
        
        if (a.getNombre().isBlank()) {
            throw new RuntimeException("Debe de ingresar un nombre");
        }
        
        if (a.getCorreo().isBlank()) {
            throw new RuntimeException("Debe de ingresar un correo");
        }
        
        if (a.getUsuario().isBlank()) {
            throw new RuntimeException("Debe de ingresar un usuario");
        }
        if (!a.getContrasena().equals(reContra)) {
            throw new RuntimeException("Las contrasenas no coninciden");
        }
        
        else
            return new AdministadorDAO().insertar(a);
        
    }
}
