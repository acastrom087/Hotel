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
    public Hotel verificar(){
        return new hotelDAO().verificar();
    }
    
}
