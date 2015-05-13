/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Controllers.ModelViewRecetas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ConexionBD {
    
  private static final String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
  private static final String url="jdbc:mysql://localhost/umaidb?autoReconnect=true";
  private static String pwd="";
  private static String usr=""; 
    private static Connection con=null;
    private Statement statement = null;
    public ConexionBD(){
        
        usr="root";
        pwd="root";
       setConnection();
    }
    
    
    private  static Connection setConnection(){
      try{
         if( con == null ){
            
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pwd);
            System.out.println("conexion con exito!!!");
         }
     }
     catch(ClassNotFoundException | SQLException ex){
         
         System.out.println("Fallo en la conexion" +ex.getCause());
     }
     return con;
   }
   
   public  Connection getConnection(){
       return con;
   }
   
   public  void insertar(String query){
        Statement statement = null;
        try {
            
        
          statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            statement.execute(query);
          
            
         
        
        } catch (SQLException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  ResultSet Consulta(String query)
    {
       Statement statement = null;
        ResultSet registro = null;
        try 
        {
            statement = (Statement) con.createStatement();
            registro =statement.executeQuery(query);
             
       
        } catch (SQLException ex) 
        {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        //"select * from usuarios where id=1"
        //"select * from usuarios where id=1"
        
        return registro;
        
    }
    
     public void Actualizar(String query)
    {
        Statement statement=null;
        try 
        {
            
        
          statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            statement.executeUpdate(query);
            System.out.println("Actualización correcta");
        } catch (SQLException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void Borrar(String query){
        Statement statement=null;
        try 
        {
            statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            statement.execute(query);
            System.out.println("Eliminacion correcta");
        } catch (SQLException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
      public ObservableList<ModelViewRecetas> listStudent(){
        try {
           // connected();
           new ConexionBD();
           statement = (Statement) con.createStatement();
           ObservableList<ModelViewRecetas> list = FXCollections.observableArrayList();
           ResultSet rs = statement.executeQuery("Select * from receta");
            
         
            while(rs.next()){
                
                 ModelViewRecetas nodo = new ModelViewRecetas();
                nodo.setId(rs.getInt(1));
                nodo.setName(rs.getString(2));
                nodo.setTipo(rs.getString(3));
                nodo.setTamano(rs.getString(4));
                nodo.setNumero(rs.getString(5));
                nodo.setTiempo(rs.getString(6));
                nodo.setDificultad(rs.getString(7));
                nodo.setMargen(rs.getString(8));
                nodo.setPorciento(rs.getString(9));
             list.add(nodo);
            }
           
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }       
    }
      
      private void closed(){
        try {
            con.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();           
        }
    }
    
   
 
    
}
