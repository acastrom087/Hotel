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
public class Hotel {
private int id;
private int filas;
private int columna;

    public Hotel() {
    }

    public Hotel(int id, int filas, int columna) {
        this.id = id;
        this.filas = filas;
        this.columna = columna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }



    
}
