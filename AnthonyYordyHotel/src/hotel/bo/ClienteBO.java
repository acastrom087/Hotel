/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ClienteDAO;
import hotel.entities.Cliente;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class ClienteBO {

    public LinkedList<Cliente> buscar(String filtro) {
        return new ClienteDAO().buscar(filtro);
        
    }
    
    public boolean insertar(Cliente c){
        if (c == null) {
            throw (new RuntimeException("Debe de ingresar el clientes"));
        }
        if (c.getNombre().isBlank()) {
            throw (new RuntimeException("Debe de ingresar un nombre"));
        }
        if (c.getCorreo().isBlank()) {
            throw (new RuntimeException("Debe de ingresar un correo"));
            
        }
        if (c.getId()>0) {
            return new ClienteDAO().editar(c);
        }
         return new ClienteDAO().insertar(c);
            
        }
    
    }
    

