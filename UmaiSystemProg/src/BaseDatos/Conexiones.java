
package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexiones {

    /**
     * @param args the command line arguments
     */
    private static Connection con=null;
    public static void main10(String[] args) {
        ConexionBD db=new ConexionBD();
       // con=ConexionBD.setConnection();
       new Conexiones().insertar("insert into usuarios(nombreUsu,contraseñaUsu,SueldoUsu,tipoPermiso)values('jose','facilito',550,1)");
       ResultSet resultado=new Conexiones().Consulta("Select * from usuarios");
       
        try {
            if (resultado.next()==true) {
                System.out.println(resultado.getString("nombreUsu"));
                System.out.println(resultado.getString("SueldoUsu"));
            } else {
                System.out.println("No existe un artículo con dicho código");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Conexiones().Actualizar("update usuarios set SueldoUsu=3000 where idUsu=2");
        new Conexiones().Borrar("delete from usuarios where idUsu=2");
        
            
        
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

}



