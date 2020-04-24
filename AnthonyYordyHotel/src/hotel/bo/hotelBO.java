/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.hotelDAO;
import hotel.entities.Hotel;

/**
 *
 * @author HP
 */
public class hotelBO {
    public Hotel verHotel(){
        return new hotelDAO().verificar();
    }
    public boolean insertar(Hotel h){
            if(h == null){
        throw new RuntimeException("Debe de crear un hotel");
            }
            if (h.getFilas() == 0) {
            throw new RuntimeException("Los edificios deben de ser mayor a 0 ");
            }
            if (h.getColumna() ==0 ) {
            throw new RuntimeException("Las habitaciones deben de ser mayor a 0 ");
            
        }
            return new hotelDAO().insertar(h);
    }
}
