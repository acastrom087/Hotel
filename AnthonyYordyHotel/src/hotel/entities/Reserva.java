/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import java.time.LocalDate;


/**
 *
 * @author HP
 */
public class Reserva {
    
    private int id;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Cliente cliente;
    private Habitacion habitacion;
    private Empleado empleado;

    public Reserva() {
    }

    public Reserva(int id, LocalDate fecha_entrada, LocalDate fecha_salida, Cliente cliente, Habitacion habitacion, Empleado empleado) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    
}
