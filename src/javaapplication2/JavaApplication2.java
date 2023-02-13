/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.sql.*;
import java.sql.DriverAction;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ekans
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connect();
    }
    
    public static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = null;
        try{
            String url = "jdbc:sqlite:temp.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection done");
        } 
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
