/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
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
    private static Connection con=null;
    public  void insertar(String query){
        Statement statement = null;
        
        try {
            
           ConexionBD db=new  ConexionBD();
           con=db.getConnection();
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
            ConexionBD db=new  ConexionBD();
            con=db.getConnection();
            statement = (Statement) con.createStatement();
            registro =statement.executeQuery(query);
            //con.close();
            
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
             ConexionBD db=new  ConexionBD();
            con=db.getConnection();
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
}
