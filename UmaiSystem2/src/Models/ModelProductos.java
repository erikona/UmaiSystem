
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author
 */
public class ModelProductos {
    
   private   SimpleIntegerProperty idProd = new SimpleIntegerProperty();
   private  SimpleStringProperty nombreProd = new SimpleStringProperty();
   private   SimpleStringProperty descripcionProd = new SimpleStringProperty();
  private  SimpleStringProperty unidadMedida = new SimpleStringProperty();
   
   CRUD cr=new CRUD();
   ListView<String> lista=new ListView<>();
     ObservableList data = 
         FXCollections.observableArrayList();
     
   public ModelProductos() 
   {
   }
    public ModelProductos(SimpleIntegerProperty idProd, SimpleStringProperty nombreProd, 
            SimpleStringProperty descripcionProd,SimpleStringProperty unidadMed) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.descripcionProd = descripcionProd;
        this.unidadMedida = unidadMed;
       
    }

    
    public void agregarProducto()
    {
       
    cr.insertar("call ProcInsertarProducto("
                    + "'"+getNombreProd()+"',"
                    + "'" +getDescripcionProd()+"',"
                    +"'"+getUnidadMedida()+"'"
                    +")");
      
    }
    
    public void ModificarProducto(int id){
     //   System.out.println("que tiene id"+id);
        cr.insertar("call ProcActualizarProducto("
                    + ""+id+","
                    + "'"+getNombreProd()+"',"
                    + "'" +getDescripcionProd()+"',"
                    +"'"+getUnidadMedida()+"'"
                    +")");
    }

    public boolean ConsultarID(int llamada,ListView list,ObservableList dat,int param){
         lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
     //resul=cr.Consulta("select * from Productos where idProd ="+param);
     resul=cr.setCall("call consultaProductoID("+ param +")");
     ObservableList li;
     li=listProd(resul,0);
     if(llamada==0){
     Controllers.Productos.ConsultarProductosController prod=new Controllers.Productos.ConsultarProductosController();
    prod.setList(li);
     }else if(llamada==1){
         Controllers.Productos.ModificarProductosController prod=new Controllers.Productos.ModificarProductosController();
         prod.setList(li);
//user.setList(li);
     }else if(llamada==2){
         Controllers.Productos.EliminarProductosController prod=new Controllers.Productos.EliminarProductosController();
         prod.setList(li);
     }
     
    return !li.isEmpty();
    }
    
    
    
    
     
     public boolean ConsultarNombre(int llamada,ListView list,ObservableList dat,String param){
         lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     //    System.out.println("entro a consultar nombre");
     //resul=cr.Consulta("select * from Productos where nombreProd like '"+param+"%'");
     resul=cr.setCall("call consultaProductoNombre('"+ param +"')");
     ObservableList li;
     li=listProd(resul,1);
     if(llamada==0){
     //Controllers.Usuarios.ConsultarUsuariosController user=new Controllers.Usuarios.ConsultarUsuariosController();
     Controllers.Productos.ConsultarProductosController prod=new Controllers.Productos.ConsultarProductosController();
     prod.setList(li);
     }else if(llamada==1){
        Controllers.Productos.ModificarProductosController prod=new Controllers.Productos.ModificarProductosController();
         prod.setList(li);
     }else if(llamada==2){
         Controllers.Productos.EliminarProductosController prod=new Controllers.Productos.EliminarProductosController();
     prod.setList(li);
     }
     
    return !li.isEmpty();
    }
    
    
    
    public boolean VaciarDatos(ResultSet rs){
       try {
           CRUD cr=new CRUD();
            //  System.out.println("entro a vaciar datos del resulset");
              if(rs.next()){
                 // System.out.println("entro a copiar los valores");
                 
               setIdProd(Integer.parseInt(rs.getString(1)));
               setNombreProd(rs.getString(2));
               
               
                   //System.out.println("posicion 3" +rs.getString(3));
                   
               //setIdProv(rs.getInt(7));
               
              }
              
              else{return false;}
       } catch (SQLException ex) {
           Logger.getLogger(ModelProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
     return true;   
    }
    
    
    
    
    
    public void eliminarProductos(int id)
    {
        
       // cr.Borrar("delete from Productos where idProd="+id);
        cr.setCall("call  EliminarProducto("+ id +")");
    }
   
    
    public ObservableList<ModelProductos> listProd(ResultSet rs,int pos){
        try {
           // connected();
          
           ObservableList<ModelProductos> list = FXCollections.observableArrayList();
           
             list.clear();
             data.clear();
         //ListView<String> lstContenedorConsulta = null;
         //lstContenedorConsulta=(ListView<String>) user.getLstContenedorConsulta();
            while(rs.next()){
                
                ModelProductos nodo = new ModelProductos();
                 nodo.setIdProd(rs.getInt(1));
                 System.out.println("id: "+rs.getInt(1));
                nodo.setNombreProd(rs.getString(2));
                System.out.println("nombre: "+rs.getString(2));
                if(pos==0){
                data.add(rs.getString(1));}
                else{
                      data.add(rs.getString(2));
                }
                
                nodo.setDescripcionProd(rs.getString(3));
                nodo.setUnidadMedida(rs.getString(4));
             //   System.out.println("nombre: "+rs.getString(2));
              //  System.out.println("nodo: "+nodo);
                list.add(nodo);
                 
            
            }
            //lstContenedorConsulta.setItems(data);
            lista.setItems(data);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }       
    }
    
    
    
    
    
    
    /**
     * @return the idProd
     */
    public Integer getIdProd() {
        return idProd.get();
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(Integer idProd) {
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
        this.nombreProd.set( nombreProd);
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
    
    
    
    
}
