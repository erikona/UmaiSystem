/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lalo
 */
public class CRUD {
    private  Connection con=null;
    
    
    public  void insertar(String query){
        Statement statement = null;
        
        try {
            
            ConexionBD db=new ConexionBD();
            con=db.setConnection();
          statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            System.out.println("que tiene query?? " +query);  
          statement.execute(query);
          con.close();
          db.closed();
            
         
        
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  ResultSet Consulta(String query)
    {
       Statement statement = null;
        ResultSet registro = null;
      
        try 
        {
            ConexionBD db=new ConexionBD();
            con=db.setConnection();
           
            PreparedStatement st = con.prepareStatement(query);
            registro = st.executeQuery(query);
            //st.close();
         //   con.close();
          //  db.closed();
            
          
        } catch (SQLException ex) 
        {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
             ConexionBD db=new ConexionBD();
            con=db.setConnection();
          statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            statement.executeUpdate(query);
            System.out.println("Actualización correcta");
            con.close();
            db.closed();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void Borrar(String query){
        Statement statement=null;
        try 
        {
            ConexionBD db=new ConexionBD();
            con=db.setConnection();
            statement = (Statement) con.createStatement();
        //"insert into usuarios (nombre,puesto) values('pedro','mesero')"
            statement.execute(query);
            System.out.println("Eliminacion correcta");
            con.close();
            db.closed();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public ResultSet setCall(String llamada)
    {
        CallableStatement cs = null;
        ConexionBD db=new  ConexionBD();
        con = db.setConnection();
        ResultSet rs;
        try {
             String preparo="{"+llamada+"}";
             System.out.println("la llamada es "+preparo);
             cs = con.prepareCall(preparo);
           
            cs.execute();
            rs = cs.getResultSet();
                System.out.println("lo mando llamar :D");
                
            
            
        } catch (Exception e) {
            System.out.println("Error Excepcion");
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }  
       return rs;
    }

}
