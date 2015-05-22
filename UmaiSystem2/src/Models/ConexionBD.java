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
 * @author lalo
 */
public class ConexionBD {
    
  private static final String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
  private static final String url="jdbc:mysql://localhost/umaidb?autoReconnect=true";
  private static String pwd="";
  private static String usr=""; 
    private static Connection con=null;
     
    public ConexionBD(){
        
        usr="root";
        pwd="root";
       
    }
    
    
   public Connection setConnection(){
      try{
         
            
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pwd);
            System.out.println("conexion con exito!!!");
         
     }
     catch(ClassNotFoundException | SQLException ex){
         
         System.out.println("Fallo en la conexion" +ex.getCause());
     }
     return con;
   }
    
    public void closed(){
    
          try {
              
                con.close();
              System.out.println("Se ha cerrado la conexion correctamente");
            //statement.close();
        } catch (Exception e) {
            e.printStackTrace();           
        }
    }
 
    
}
