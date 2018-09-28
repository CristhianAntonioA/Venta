/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristhian
 */
public class Conexion {
    private Connection cn;
    
    public void conexion(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Venta","123456");         
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:"+ e);
        }
    }
    
    public void cerrar() throws SQLException{
        if (cn!=null) {
            if (cn.isClosed()==false) {
                cn.close();
            }
        }
    }
    
    public static void main(String[] args) {
        Conexion dao = new Conexion();
        dao.conexion();
        if (dao.getCn()!=null) {
            System.out.println("Conectado");    
        }    
        
    }
    
    
    /*GETTER AND SETTER*/

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
