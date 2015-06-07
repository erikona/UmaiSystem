/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class modelAgregarCompras {
    
    

/**
 *
 * @author
 */

    
   private   SimpleIntegerProperty idCompra = new SimpleIntegerProperty();
   private   SimpleIntegerProperty idProv = new SimpleIntegerProperty();
   private  SimpleStringProperty nombreProv=new SimpleStringProperty();
   private   SimpleIntegerProperty idProd = new SimpleIntegerProperty();
   private   SimpleDateFormat fecha=new SimpleDateFormat();
   private   SimpleIntegerProperty cantidad = new SimpleIntegerProperty();
   private   SimpleIntegerProperty precioUnit = new SimpleIntegerProperty();
   private   SimpleIntegerProperty total = new SimpleIntegerProperty();
 
   
   CRUD cr=new CRUD();
   ListView<String> lista=new ListView<>();
     ObservableList data = 
         FXCollections.observableArrayList();
     
   public modelAgregarCompras() 
   {
   }
    public modelAgregarCompras(SimpleIntegerProperty idCompra,
            SimpleIntegerProperty idProd,SimpleIntegerProperty idProv,
            SimpleIntegerProperty cantidad,SimpleDateFormat fecha,SimpleIntegerProperty precioUnit,
            SimpleIntegerProperty total) {
        this.idCompra=idCompra;
        this.idProv=idProv;
        this.idProd=idProd;
        this.precioUnit=precioUnit;
        this.total=total;
        this.fecha=fecha;
        
        
       
       
    }

    
    public void agregarProducto()
    {
       /*
    cr.insertar("call ProcInsertarProducto("
                    + "'"+getNombreProd()+"',"
                    + "'" +getDescripcionProd()+"',"
                    +"'"+getUnidadMedida()+"'"
                    +")");
      */
    }
    
    public void ModificarProducto(int id){
        /*
        System.out.println("que tiene id"+id);
        cr.insertar("call ProcActualizarProducto("
                    + ""+id+","
                    + "'"+getNombreProd()+"',"
                    + "'" +getDescripcionProd()+"',"
                    +"'"+getUnidadMedida()+"'"
                    +")");
        */
    }
    
    public boolean ConsultarIdProveedor(int llamada,ListView list,ObservableList dat,int param){
       lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
     resul=cr.Consulta("select idProv  from proveedor");
     ObservableList li;
     li=listProv(resul,0);
     if(llamada==0){
     Controllers.Productos.AgregarComprasController prod=new Controllers.Productos.AgregarComprasController();
    prod.setList(li);
     }else if(llamada==1){
         //Controllers.Productos.ModificarProductosControlle prod=new Controllers.Productos.ModificarProductosController();
         //prod.setList(li);
//user.setList(li);
     }
     
    return !li.isEmpty();
    }
    

    public boolean ConsultarID(int llamada,ListView list,ObservableList dat,int param){
         lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
     resul=cr.Consulta("select * from Productos where idProd ="+param);
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
         System.out.println("entro a consultar nombre");
     resul=cr.Consulta("select * from Productos where nombreProd like '"+param+"%'");
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
                 
               //setIdProd(Integer.parseInt(rs.getString(1)));
               //setNombreProd(rs.getString(2));
               
               
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
        
        cr.Borrar("delete from Productos where idProd="+id);
    }
    /*
    public void modificarUsuario()
    {
        cr.insertar("call   ProcActualizarUsuario("
                    +""+getIdProd()+","
                    + "'"+getNombreProd()+"',"
                    +"'"+getDescripcionProd()+"',"
                    +"'"+getUnidadMedida()+"'"
                    +")");
    }
    */
    
    public ObservableList<modelAgregarCompras> listProv(ResultSet rs,int pos){
        try {
           // connected();
          
           ObservableList<modelAgregarCompras> list = FXCollections.observableArrayList();
           
             list.clear();
             data.clear();
         //ListView<String> lstContenedorConsulta = null;
         //lstContenedorConsulta=(ListView<String>) user.getLstContenedorConsulta();
            while(rs.next()){
                
                modelAgregarCompras nodo = new modelAgregarCompras();
                 nodo.setIdProv(rs.getInt(1));
                 data.add(rs.getInt(2));
                 nodo.setNombreProv(rs.getString(2));
                 
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
     * @return the idCompra
     */
    public SimpleIntegerProperty getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(SimpleIntegerProperty idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the idProv
     */
    public SimpleIntegerProperty getIdProv() {
        return idProv;
    }

    /**
     * @param idProv the idProv to set
     */
    public void setIdProv(int idProv) {
        this.idProd.set(idProv);
    }

    /**
     * @return the idProd
     */
    public SimpleIntegerProperty getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(SimpleIntegerProperty idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the fecha
     */
    public SimpleDateFormat getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(SimpleDateFormat fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantidad
     */
    public SimpleIntegerProperty getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(SimpleIntegerProperty cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioUnit
     */
    public SimpleIntegerProperty getPrecioUnit() {
        return precioUnit;
    }

    /**
     * @param precioUnit the precioUnit to set
     */
    public void setPrecioUnit(SimpleIntegerProperty precioUnit) {
        this.precioUnit = precioUnit;
    }

    /**
     * @return the total
     */
    public SimpleIntegerProperty getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(SimpleIntegerProperty total) {
        this.total = total;
    }

    /**
     * @return the nombreProv
     */
    public SimpleStringProperty getNombreProv() {
        return nombreProv;
    }

    /**
     * @param nombreProv the nombreProv to set
     */
    public void setNombreProv(String nombreProv) {
        this.nombreProv.set(nombreProv);
    }
    
    
    
    
    
    
    
    
}


