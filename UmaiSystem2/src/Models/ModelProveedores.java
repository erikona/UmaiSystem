/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author 
 */
public class ModelProveedores {
    
    private SimpleIntegerProperty idProv = new SimpleIntegerProperty();
    private SimpleStringProperty nombreProv = new SimpleStringProperty();
    private SimpleStringProperty telefonoProv = new SimpleStringProperty();
    private SimpleStringProperty emailProv = new SimpleStringProperty();
    private SimpleStringProperty codigoProv = new SimpleStringProperty();
    private SimpleStringProperty ciudadProv = new SimpleStringProperty();
    private SimpleStringProperty calleProv = new SimpleStringProperty();
    private SimpleStringProperty coloniaProv = new SimpleStringProperty();
    private SimpleStringProperty contratoProv = new SimpleStringProperty();
    CRUD cr = new CRUD();
    
    ListView<String> lista = new ListView<>();
        ObservableList data = 
                FXCollections.observableArrayList();
    
    public ModelProveedores() {
        
    }
    
    public ModelProveedores(SimpleIntegerProperty idProv, SimpleStringProperty nombreProv,
                            SimpleStringProperty telefonoProv, SimpleStringProperty emailProv,
                            SimpleStringProperty codigoProv, SimpleStringProperty ciudadProv,
                            SimpleStringProperty calleProv,SimpleStringProperty contrato) {
        this.idProv = idProv;
        this.nombreProv = nombreProv;
        this.telefonoProv = telefonoProv;
        this.emailProv = emailProv;
        this.codigoProv = codigoProv;
        this.ciudadProv = ciudadProv;        
        this.calleProv = calleProv;
        this.contratoProv=contrato;
    }
    
    public void agregarProveedor(){
       // System.out.println("Que tiene código postal "+getCodigoProv());
        cr.insertar("call ProcInsertarProv("
                    + "'" +getNombreProv()+ "',"
                    + "'" +getTelefonoProv()+ "',"
                    + "'" +getEmailProv()+ "',"
                    + "'" +getCodigoProv()+ "',"
                    + "'" +getCiudadProv()+ "',"
                    + "'"+getColoniaProv()+"',"
                    + "'" +getCalleProv()+ "')");                
    }
    
    public boolean ConsultarID(int llamada,ListView list,ObservableList dat,int param){
        lista = list;
        data = dat;
        ResultSet resul;
        //resul = cr.Consulta("select * from proveedor where idProv ="+param);
        resul=cr.setCall("call consultaProveedorID("+param+")");
        ObservableList li;
        li=listProveedor(resul,0);
        if(llamada==0)
        {
            Controllers.Proveedor.ConsultarProveedorController prov=new Controllers.Proveedor.ConsultarProveedorController();
          //  user.setList(li);
            prov.setList(li);
        }
        else if(llamada==1)
        {
            Controllers.Proveedor.ModificarProveedorController prov=new Controllers.Proveedor.ModificarProveedorController();
            prov.setList(li);
        }
        return !li.isEmpty();
    }
    
    public boolean ConsultarNombre(int llamada, ListView list,ObservableList dat,String param){
        lista = list;
        data = dat;
        ResultSet resul;
      //  resul = cr.Consulta("select * from proveedor where nombreProv like '"+param+"%'");
        resul=cr.setCall("call consultaProveedorNombre('"+  param  +"')");
        ObservableList li;
        li=listProveedor(resul,1);
        if(llamada==0)
        {
            Controllers.Proveedor.ConsultarProveedorController prov=new Controllers.Proveedor.ConsultarProveedorController();
          //  user.setList(li);
            prov.setList(li);
            
        }
        else if(llamada==1)
        {
          
            Controllers.Proveedor.ModificarProveedorController prov=new Controllers.Proveedor.ModificarProveedorController();
            prov.setList(li);
//   user.setList(li);
        }
        return !li.isEmpty();
    }
    
    public boolean ConsultarNombreEliminar(ListView list,ObservableList dat,String param){
     lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
    // resul=cr.Consulta("select * from proveedor where nombreProv like '"+param+"%' and estadoContrato='Activo'");
     resul=cr.setCall("call consultaProveedorNombreEliminar('" +param+ "')");
     ObservableList li;
     li=listProveedor(resul,1);
     Controllers.Proveedor.EliminarProveedorController prov=new Controllers.Proveedor.EliminarProveedorController();
     prov.setList(li);
     //Controllers.Proveedor.EliminarProveedorController  prov2=new Controllers.Proveedor.EliminarProveedorController():
     //user.setList(li);
     
    return !li.isEmpty();   
    }
    public boolean consultarIDEliminar(ListView list,ObservableList dat,int param){
      lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
      //  System.out.println("parametro= "+param);
    // resul=cr.Consulta("select * from proveedor where idProv like "+param +" and estadoContrato='Activo'");
     resul=cr.setCall("call consultaProveedorIDEliminar(" + param +")");
     ObservableList li;
     li=listProveedor(resul,0);
     //Controllers.Usuarios.EliminarUsuariosController user=new Controllers.Usuarios.EliminarUsuariosController();
     //user.setList(li);
     Controllers.Proveedor.EliminarProveedorController prov=new Controllers.Proveedor.EliminarProveedorController();
     prov.setList(li);
    return !li.isEmpty();
    }
    
    /*
    public boolean VaciarDatos (ResultSet rs)
    {
        try
        {
            CRUD cr=new CRUD();
            System.out.println("Entro a vaciar datos del resulset");
            if(rs.next())
            {
                setIdProv(Integer.parseInt(rs.getString(1)));
                setNombreProv(rs.getString(2));
                System.out.println("nombre:"+rs.getString(2));
                
                    setTelefonoProv(rs.getString(3));
                    setEmailProv(rs.getString(4));
                    setCodigoProv(rs.getString(5));
                    setCiudadProv(rs.getString(6));
                    setCalleProv(rs.getString(7));
            }
            else{return false;}
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(ModelProveedores.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;
    }
    */
    private ObservableList<ModelProveedores> listProveedor(ResultSet rs, int pos) 
    {
        try 
        {
            ObservableList<ModelProveedores> list = FXCollections.observableArrayList();
            list.clear();
            data.clear();
            while(rs.next())
            {
                ModelProveedores nodo = new ModelProveedores();
                nodo.setIdProv(rs.getInt(1));
                System.out.println("Id:" +rs.getInt(1));
                nodo.setNombreProv(rs.getString(2));
                if(pos==0)
                {
                    data.add(rs.getString(1));
                    System.out.println("guardo el id");
                }
                else
                {
                    data.add(rs.getString(2));
                    System.out.println("guardo el nombre");
                }
                nodo.setIdProv(rs.getInt(1));
                nodo.setNombreProv(rs.getString(2));
                nodo.setCodigoProv(rs.getString(3));
                nodo.setCiudadProv(rs.getString(4));
                nodo.setColoniaProv(rs.getString(5));
                nodo.setCalleProv(rs.getString(6));
                nodo.setTelefonoProv(rs.getString(7));
                nodo.setEmailProv(rs.getString(8));
                nodo.setContrato(rs.getString(9));
                list.add(nodo);
            }
                lista.setItems(data);
                return list;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }finally{}
    }
    
    public void eliminarProveedor(int id){
     //   cr.Actualizar("update proveedor set estadoContrato='Terminado' where idProv="+id+"");
        cr.setCall("call EliminarProveedor(" +id + ")");
    }
    
    public void modificarProveedor(){
        cr.insertar("call ProcActualizarProveedor("
                    +""+getIdProv()+","
                    +"'"+getNombreProv()+"',"
                    +"'"+getCodigoProv()+"',"
                    +"'"+getCiudadProv()+"',"
                    +"'"+getColoniaProv()+"',"
                    +"'"+getCalleProv()+"',"
                    +"'"+getTelefonoProv()+"',"
                    +"'"+getEmailProv()+"',"
                    +"'"+getContrato()+"')");
                    
                   
                  
 
    
    
    
    
    
    
    }
    
    /**
     * @return the idProv
     */
    public Integer getIdProv() {
        return idProv.get();
    }

    /**
     * @param idProv the idProv to set
     */
    public void setIdProv(Integer idProv) {
        this.idProv.set(idProv);
    }

    /**
     * @return the nombreProv
     */
    public String getNombreProv() {
        return nombreProv.get();
    }

    /**
     * @param nombreProv the nombreProv to set
     */
    public void setNombreProv(String nombreProv) {
        this.nombreProv.set(nombreProv);
    }

    /**
     * @return the telefonoProv
     */
    public String getTelefonoProv() {
        return telefonoProv.get();
    }

    /**
     * @param telefonoProv the telefonoProv to set
     */
    public void setTelefonoProv(String telefonoProv) {
        this.telefonoProv.set(telefonoProv);
    }

    /**
     * @return the emailProv
     */
    public String getEmailProv() {
        return emailProv.get();
    }

    /**
     * @param emailProv the emailProv to set
     */
    public void setEmailProv(String emailProv) {
        this.emailProv.set(emailProv);
    }

    /**
     * @return the calleProv
     */
    public String getCalleProv() {
        return calleProv.get();
    }

    /**
     * @param calleProv the calleProv to set
     */
    public void setCalleProv(String calleProv) {
        this.calleProv.set(calleProv);
    }

    /**
     * @return the codigoProv
     */
    public String getCodigoProv() {
        return codigoProv.get();
    }
    
    /**
     * @param codigoProv the codigoProv to set
     */
    public void setCodigoProv(String codigoProv) {
        this.codigoProv.set(codigoProv);
    }

    /**
     * @return the ciudadProv
     */
    public String getCiudadProv() {
        return ciudadProv.get();
    }

    /**
     * @param ciudadProv the ciudadProv to set
     */
    public void setCiudadProv(String ciudadProv) {
        this.ciudadProv.set(ciudadProv);
    }

    /**
     * @return the colonia
     */
   

    /**
     * @return the contrato
     */
    public String getContrato() {
        return contratoProv.get();
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(String contrato) {
        this.contratoProv.set(contrato);
    }

    /**
     * @return the coloniaProv
     */
    public String getColoniaProv() {
        return coloniaProv.get();
    }

    /**
     * @param coloniaProv the coloniaProv to set
     */
    public void setColoniaProv(String coloniaProv) {
        this.coloniaProv.set(coloniaProv);
    }

    /**
     * @param coloniaProv the coloniaProv to set
     */
    public void setColoniaProv(SimpleStringProperty coloniaProv) {
        this.coloniaProv = coloniaProv;
    }
}
