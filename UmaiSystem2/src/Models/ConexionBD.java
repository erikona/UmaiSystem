/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class ConexionBD{
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost/umaidb?autoReconnect=true";
    private static String pwd="";
    private static String usr=""; 
    private static Connection con=null;
     
    public ConexionBD(){
        usr="root";
        pwd="1234";
    }
    
    public Connection setConnection(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pwd);
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Fallo en la conexión" +ex.getCause());
        }
        return con;
   }
    
    public void closed(){
        try{
            con.close();
        } 
        catch (Exception e){
            e.printStackTrace();           
        }
    }
}