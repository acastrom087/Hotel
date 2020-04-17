/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

/**
 *
 * @author HP
 */
public class Cliente extends Persona{
    private int celular;

    public Cliente() {
    }

    public Cliente(int celular, int id, int cedula, String nombre, String correo) {
        super(id, cedula, nombre, correo);
        this.celular = celular;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return super.getCedula() + "-" + super.getNombre();
    }
    
    
    
    
}
