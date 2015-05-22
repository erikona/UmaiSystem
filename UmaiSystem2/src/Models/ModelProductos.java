
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lalo
 */
public class ModelProductos {
    
   private  SimpleIntegerProperty idProd = new SimpleIntegerProperty();
   private SimpleStringProperty nombreProd = new SimpleStringProperty();
   private  SimpleStringProperty descripcionProd = new SimpleStringProperty();
   private  SimpleIntegerProperty cantidadProd = new SimpleIntegerProperty();
   private  SimpleIntegerProperty precioUnitario = new SimpleIntegerProperty();
   private  SimpleStringProperty unidadMedida = new SimpleStringProperty();
   private  SimpleIntegerProperty idProv = new SimpleIntegerProperty();
   
   CRUD cr=new CRUD();
   
   public ModelProductos() 
   {
   }
    public ModelProductos(SimpleIntegerProperty idProd, SimpleStringProperty nombreProd, 
            SimpleStringProperty descripcionProd, SimpleIntegerProperty cantidadProd, 
            SimpleIntegerProperty precioUnitario, SimpleStringProperty unidadMedida,
            SimpleIntegerProperty idProv) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.descripcionProd = descripcionProd;
        this.cantidadProd = cantidadProd;
        this.precioUnitario = precioUnitario;
        this.unidadMedida = unidadMedida;
        this.idProv = idProv;
    }

    
    public void agregarProducto()
    {
       
    cr.insertar("call ProcInsertarProducto("
                    + "'"+getNombreProd()+"',"
                    + "'" +getDescripcionProd()+"',"
                    +getCantidadProd()+","
                    +getPrecioUnitario()+","
                    +"'"+getUnidadMedida()+"',"
                    +getIdProv()+")");
      
    }
    
    public void consultarProductoNombre(String parametro)
    {
     CRUD cr=new CRUD();
     ResultSet resul=null;
     resul=cr.Consulta("select * from Productos where nombreProd='"+parametro +"'");
       try {
           if(resul.next()){
                VaciarDatos(resul);
           } } catch (SQLException ex) {
           Logger.getLogger(ModelProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void consultarProductoID(int parametro)
    {
     CRUD cr=new CRUD();
      ResultSet resul = null;
     cr.Consulta("select * from Productos where idProd="+parametro +"");
              try {
           if(resul.next()){
                VaciarDatos(resul);
           } } catch (SQLException ex) {
           Logger.getLogger(ModelProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void VaciarDatos(ResultSet rs){
       try {
           while(rs.next()){
               setIdProd(rs.getInt(1));
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(ModelProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public void modificarProducto()
    {
        
    }
    public void eliminarProducto()
    {
        
    }
    public ObservableList<ModelProductos> listProduc(ResultSet rs)
    {
        try 
        {
            ObservableList<ModelProductos> list = FXCollections.observableArrayList();
           
            
         
            while(rs.next())
            {
                
            }
           
            return list;
        } catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }       
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd.get();
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd.set(idProd);
    }

    /**
     * @return the nombreProd
     */
    public String getNombreProd() {
        return nombreProd.get();
    }

    /**
     * @param nombreProd the nombreProd to set
     */
    public void setNombreProd(String nombreProd) {
      
       this.nombreProd.set(nombreProd);
    }

    /**
     * @return the descripcionProd
     */
    public String getDescripcionProd() {
        return descripcionProd.get();
    }

    /**
     * @param descripcionProd the descripcionProd to set
     */
    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd.set(descripcionProd);
    }

    /**
     * @return the cantidadProd
     */
    public int getCantidadProd() {
        return cantidadProd.get();
    }

    /**
     * @param cantidadProd the cantidadProd to set
     */
    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd.set(cantidadProd);
    }

    /**
     * @return the precioUnitario
     */
    public int getPrecioUnitario() {
        return precioUnitario.get();
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(int precioUnitario) {
        
        this.precioUnitario.set(precioUnitario);
        
    }

    /**
     * @return the unidadMedida
     */
    public String getUnidadMedida() {
        return unidadMedida.get();
    }

    /**
     * @param unidadMedida the unidadMedida to set
     */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida.set(unidadMedida);
    }

    /**
     * @return the idProv
     */
    public int getIdProv() {
        return idProv.get();
    }

    /**
     * @param idProv the idProv to set
     */
    public void setIdProv(int idProv) {
        this.idProv.set(idProv);
    }
    
    
}
