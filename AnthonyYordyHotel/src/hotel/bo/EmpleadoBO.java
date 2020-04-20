/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;
import hotel.dao.EmpleadoDAO;
import hotel.entities.Empleado;
import java.util.LinkedList;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author HP
 */
public class EmpleadoBO {
 
    
    public boolean insertar(Empleado a, String reContra){
        
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
            a.setContrasena(DigestUtils.md5Hex(a.getContrasena()));
            return new EmpleadoDAO().insertar(a);
        
    }

    public Empleado autenticar(Empleado e){
        if (e == null) {
            throw new RuntimeException("Debe ingresar datos");
        }
        if (e.getUsuario().trim().isBlank()) {
            throw  new RuntimeException("Debe de ingresar un usuario");
        }
        if (e.getContrasena().isBlank()) {
            throw new RuntimeException("Debe de ingresar una contraseña");
            
        }
        e.setContrasena(DigestUtils.md5Hex(e.getContrasena()));
        return new EmpleadoDAO().auntenticar(e);
    }
    
    public LinkedList<Empleado> buscar(String filtro) {
        return new EmpleadoDAO().buscar(filtro);
        
    }
}
