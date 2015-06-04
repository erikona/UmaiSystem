/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author lalo
 */
public class ModelProveedores {
    
    private SimpleIntegerProperty idProv = new SimpleIntegerProperty();
    private SimpleStringProperty nombreProv = new SimpleStringProperty();
    private SimpleStringProperty telefonoProv = new SimpleStringProperty();
    private SimpleStringProperty emailProv = new SimpleStringProperty();
    private SimpleStringProperty codigoProv = new SimpleStringProperty();
    private SimpleStringProperty ciudadProv = new SimpleStringProperty();
    private SimpleStringProperty calleProv = new SimpleStringProperty();
    private SimpleStringProperty colonia = new SimpleStringProperty();
    private SimpleIntegerProperty contrato = new SimpleIntegerProperty();
    CRUD cr = new CRUD();
    
    ListView<String> lista = new ListView<>();
        ObservableList data = 
                FXCollections.observableArrayList();
    
    public ModelProveedores() {
        
    }
    
    public ModelProveedores(SimpleIntegerProperty idProv, SimpleStringProperty nombreProv,
                            SimpleStringProperty telefonoProv, SimpleStringProperty emailProv,
                            SimpleStringProperty codigoProv, SimpleStringProperty ciudadProv,
                            SimpleStringProperty calleProv) {
        this.idProv = idProv;
        this.nombreProv = nombreProv;
        this.telefonoProv = telefonoProv;
        this.emailProv = emailProv;
        this.codigoProv = codigoProv;
        this.ciudadProv = ciudadProv;        
        this.calleProv = calleProv;
    }
    
    public void agregarProveedor(){
        System.out.println("Que tiene código postal "+getCodigoProv());
        cr.insertar("call ProcInsertarProv("
                    + "'" +getNombreProv()+ "',"
                    + "'" +getTelefonoProv()+ "',"
                    + "'" +getEmailProv()+ "',"
                    + "'" +getCodigoProv()+ "',"
                    + "'" +getCiudadProv()+ "',"
                    + "'" +getCalleProv()+ "')");                
    }
    
    public boolean ConsultarID(int llamada,ListView list,ObservableList dat,int param){
        lista = list;
        data = dat;
        ResultSet resul;
        resul = cr.Consulta("select * from proveedor where idProv ="+param);
        ObservableList li;
        li=listProveedor(resul,0);
        if(llamada==0)
        {
            Controllers.Proveedor.ConsultarProveedorController user=new Controllers.Proveedor.ConsultarProveedorController();
          //  user.setList(li);
        }
        else if(llamada==1)
        {
            Controllers.Proveedor.ModificarProveedorController user=new Controllers.Proveedor.ModificarProveedorController();
            //user.setList(li);
        }
        return !li.isEmpty();
    }
    
    public boolean ConsultarNombre(int llamada, ListView list,ObservableList dat,String param){
        lista = list;
        data = dat;
        ResultSet resul;
        resul = cr.Consulta("select * from proveedor where nombreProv like ="+param+"%");
        ObservableList li;
        li=listProveedor(resul,0);
        if(llamada==0)
        {
            Controllers.Proveedor.ConsultarProveedorController user=new Controllers.Proveedor.ConsultarProveedorController();
          //  user.setList(li);
        }
        else if(llamada==1)
        {
            Controllers.Proveedor.ModificarProveedorController user=new Controllers.Proveedor.ModificarProveedorController();
            user.setList(li);
//   user.setList(li);
        }
        return !li.isEmpty();
    }
    
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
                }
                else
                {
                    data.add(rs.getString(2));
                }
                nodo.setTelefonoProv(rs.getString(3));
                nodo.setEmailProv(rs.getString(4));
                nodo.setCodigoProv(rs.getString(5));
                nodo.setCiudadProv(rs.getString(6));
                nodo.setCalleProv(rs.getString(7));
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
        cr.Actualizar("update usuarios set estadoContrato='Terminado' where idProv="+id+"");
    }
    
    public void modificarProveedor(){
        cr.insertar("call ProcActualizarProveedor("
                    +""+getIdProv()+","
                    +""+getNombreProv()+","
                    +""+getTelefonoProv()+","
                    +""+getEmailProv()+","
                    +""+getCodigoProv()+","
                    +""+getCiudadProv()+","
                    +""+getCalleProv()+")");
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
    public String getColonia() {
        return colonia.get();
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia.set(colonia);
    }

    /**
     * @return the contrato
     */
    public int getContrato() {
        return contrato.get();
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(int contrato) {
        this.contrato.set(contrato);
    }
}
