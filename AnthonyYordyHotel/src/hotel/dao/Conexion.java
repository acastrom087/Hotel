/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author amurilloa
 */
public class Conexion {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String TIPO = "jdbc:postgresql://";
    private static final String SERVER = "localhost";
    private static final String PUERTO = "5432";
    private static final String DB = "hotel";
    private static final String USER = "postgres";
    private static final String PASS = "facebook13";

    public static Connection getConexion() throws Exception {
        Connection con = null;
        try {
            Class.forName(DRIVER); //valida que el driver este en las librerias del proyecto 
            String strCon = String.format("%s%s:%s/%s", TIPO, SERVER, PUERTO, DB);
            con = DriverManager.getConnection(strCon, USER, PASS);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Recuerde agregar la librería al proyecto");
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
//
//    public static void main(String[] args) {
//        try {
//            getConexion();
//            System.out.println("Terminó");
//        } catch (Exception ex) {
//            System.out.println("Explotó: " + ex.getMessage());
//        }
//    }
}
