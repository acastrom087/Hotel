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
public class Empleado extends Persona{
    private char tipo;
    private String contrasena;
    private boolean activo;
    private String usuario;

    public Empleado() {
    }

    public Empleado(char tipo, String contrasena, boolean activo, int id, int cedula, String nombre, String correo, String usuario) {
        super(id, cedula, nombre, correo);
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.activo = activo;
        this.usuario = usuario;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
