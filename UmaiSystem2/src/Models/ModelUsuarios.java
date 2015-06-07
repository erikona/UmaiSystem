/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ModelUsuarios {
    
    private   SimpleIntegerProperty idUsu = new SimpleIntegerProperty();
    private   SimpleStringProperty nombreUsu = new SimpleStringProperty();
    private   SimpleStringProperty contraseñaUsu = new SimpleStringProperty();
    private  SimpleStringProperty calleUsu = new SimpleStringProperty();
    private  SimpleStringProperty coloUsu = new SimpleStringProperty();
    private  SimpleStringProperty ciudUsu = new SimpleStringProperty();
    private  SimpleStringProperty codigoPostal = new SimpleStringProperty();
    private SimpleStringProperty telefonoUsu = new SimpleStringProperty();
    private  SimpleIntegerProperty sueldoUsu = new SimpleIntegerProperty();
    private  SimpleIntegerProperty puntosUsu = new SimpleIntegerProperty();
    private  SimpleIntegerProperty tipoPermiso = new SimpleIntegerProperty();
    private  SimpleStringProperty estadoContrato = new SimpleStringProperty();
    
    CRUD cr=new CRUD();
    
    ListView<String> lista=new ListView<>();
     ObservableList data = 
         FXCollections.observableArrayList();
    public ModelUsuarios() 
    {
       
    }
    
    public ModelUsuarios(SimpleIntegerProperty idUsu, SimpleStringProperty nombreUsu, 
            SimpleStringProperty contraseñaUsu, SimpleStringProperty calleUsu, 
            SimpleStringProperty coloUsu, SimpleStringProperty ciudUsu,
            SimpleStringProperty codigoPostal, SimpleStringProperty telefonoUsu,
            SimpleIntegerProperty sueldoUsu, SimpleIntegerProperty puntosUsu,
            SimpleIntegerProperty tipoPermiso, SimpleStringProperty estadoContrato
            ) {
        this.idUsu = idUsu;
        this.nombreUsu = nombreUsu;
        this.contraseñaUsu = contraseñaUsu;
        this.calleUsu = calleUsu;
        this.coloUsu = coloUsu;
        this.ciudUsu= ciudUsu;
        this.codigoPostal = codigoPostal;
        this.telefonoUsu = telefonoUsu;
        this.sueldoUsu = sueldoUsu;
        this.puntosUsu = puntosUsu;
        this.tipoPermiso = tipoPermiso;
        this.estadoContrato = estadoContrato;
    }
    
    public void agregarUsuarios()
    {
      //  System.out.println("al tiempo de agregar que tiene codigo postal "+getCodigoPostal());
    cr.insertar("call ProcInsertarUsuario("
                    + "'"+getNombreUsu()+"',"
                    + "'" +getContraseñaUsu()+"',"
                    +"'"+getCalleUsu()+"',"
                    +"'"+getColoUsu()+"',"
                    +"'"+getCiudUsu()+"',"
                    +"'"+getCodigoPostal()+"',"
                    +"'"+getTelefonoUsu()+"',"
                    +getSueldoUsu()+","
                    +getPuntosUsu()+","
                    +getTipoPermiso()+""
                    +")");
      
    }
    
    public ArrayList getcodigosPostales()
    {
        CRUD cr=new CRUD();
        
        ArrayList<String> datos= new ArrayList<String>();
        try {
             ResultSet rs=cr.setCall("call consultaCodigoPostal()");
                     
                   
                while(rs.next())
                {
                   // System.out.println("ultima id"+ rs.getString("idRec"));
                    datos.add(rs.getString("CodigoPostal"));
                 
                  //  return Integer.parseInt(rs.getString("idRec"));
                }
            
            
        } catch (Exception e) {
            System.out.println("Error Excepcion");
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }  
       return datos;
    }

     public ArrayList getMunicipios(String codigos)
    {
        CRUD cr=new CRUD();
        
        ArrayList<String> datos= new ArrayList<String>();
        try {
             ResultSet rs=cr.setCall("call consultaMunicipios('"+codigos+"')");
             
                     
                   
                while(rs.next())
                {
                   // System.out.println("ultima id"+ rs.getString("idRec"));
                    datos.add(rs.getString(1));
                 
                  //  return Integer.parseInt(rs.getString("idRec"));
                }
            
            
        } catch (Exception e) {
            System.out.println("Error Excepcion");
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }  
       return datos;
    }
     public ArrayList getColonias(String municipio)
    {
        CRUD cr=new CRUD();
        
        ArrayList<String> datos= new ArrayList<String>();
        try {
             ResultSet rs=cr.setCall("call consultaColonias('"+municipio+"')");
             
                     
                   
                while(rs.next())
                {
                   // System.out.println("ultima id"+ rs.getString("idRec"));
                    datos.add(rs.getString("Colonia"));
                 
                  //  return Integer.parseInt(rs.getString("idRec"));
                }
            
            
        } catch (Exception e) {
            System.out.println("Error Excepcion");
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }  
       return datos;
    }
    
    
    
    
    public boolean ConsultarID(int llamada,ListView list,ObservableList dat,int param){
         lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
    // resul=cr.Consulta("select * from usuarios where idUsu ="+param);
     resul=cr.setCall("call consultaUsuariosID("+   param +")");
     ObservableList li;
     li=listUser(resul,0);
     if(llamada==0){
     Controllers.Usuarios.ConsultarUsuariosController user=new Controllers.Usuarios.ConsultarUsuariosController();
     user.setList(li);
     }else if(llamada==1){
         Controllers.Usuarios.ModificarUsuarios2 user=new Controllers.Usuarios.ModificarUsuarios2();
         user.setList(li);
     }
     
    return !li.isEmpty();
    }
    
     public boolean consultarIDEliminar(ListView list,ObservableList dat,int param){
      lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
     //resul=cr.Consulta("select * from usuarios where idUsu like "+param +" and estadoContrato='Activo'");
     resul=cr.setCall("call consultaUsuariosIDEliminar("+ param +")");
     ObservableList li;
     li=listUser(resul,0);
     Controllers.Usuarios.EliminarUsuariosController user=new Controllers.Usuarios.EliminarUsuariosController();
     user.setList(li);
     
    return !li.isEmpty();
    }
    
    
     
     public boolean ConsultarNombre(int llamada,ListView list,ObservableList dat,String param){
         lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
    /// resul=cr.Consulta("select * from usuarios where nombreUsu like '"+param+"%'");
     resul=cr.setCall("call consultaUsuariosNombre('"+param+"')");
     ObservableList li;
     li=listUser(resul,1);
     if(llamada==0){
     Controllers.Usuarios.ConsultarUsuariosController user=new Controllers.Usuarios.ConsultarUsuariosController();
     user.setList(li);
     }else if(llamada==1){
         Controllers.Usuarios.ModificarUsuarios2 user=new Controllers.Usuarios.ModificarUsuarios2();
         user.setList(li);
     }
     
    return !li.isEmpty();
    }
    
    public boolean ConsultarNombreEliminar(ListView list,ObservableList dat,String param){
     lista=list;
         data=dat;
   //     CRUD cr=new CRUD();
     ResultSet resul;
     
    // resul=cr.Consulta("select * from usuarios where nombreUsu like '"+param+"%' and estadoContrato='Activo'");
     resul=cr.setCall("call consultaUsuariosNombreEliminar('"+ param +"')");
     ObservableList li;
     li=listUser(resul,1);
     Controllers.Usuarios.EliminarUsuariosController user=new Controllers.Usuarios.EliminarUsuariosController();
     user.setList(li);
     
    return !li.isEmpty();   
    }
    
    public boolean VaciarDatos(ResultSet rs){
       try {
           CRUD cr=new CRUD();
        //      System.out.println("entro a vaciar datos del resulset");
              if(rs.next()){
                 // System.out.println("entro a copiar los valores");
                 
               setIdUsu(Integer.parseInt(rs.getString(1)));
               setNombreUsu(rs.getString(2));
               System.out.println("nombre: "+rs.getString(2));
               
                   //System.out.println("posicion 3" +rs.getString(3));
                    setContraseñaUsu(rs.getString(3));
                   setCalleUsu(rs.getString(4));
                   setColoUsu(rs.getString(5));
                   setCiudUsu(rs.getString(6));
                   setCodigoPostal(rs.getString(7));
                   setTelefonoUsu(rs.getString(8));
                   setSueldoUsu(Integer.parseInt(rs.getString(10)));
                   setPuntosUsu(Integer.parseInt(rs.getString(11)));
                   setTipoPermiso(rs.getInt(12));
                   setEstadoContrato(rs.getString(13));
                   
               //setIdProv(rs.getInt(7));
               
              }
              
              else{return false;}
       } catch (SQLException ex) {
           Logger.getLogger(ModelUsuarios.class.getName()).log(Level.SEVERE, null, ex);
       }
     return true;   
    }
    
    
    public ObservableList<ModelUsuarios> listUser(ResultSet rs,int pos){
        try {
           // connected();
          
           ObservableList<ModelUsuarios> list = FXCollections.observableArrayList();
       
             list.clear();
             data.clear();
         //ListView<String> lstContenedorConsulta = null;
         //lstContenedorConsulta=(ListView<String>) user.getLstContenedorConsulta();
            while(rs.next()){
                
                 ModelUsuarios nodo = new ModelUsuarios();
              //   System.out.println("que pedo "+rs.getString(1));
                 nodo.setIdUsu(rs.getInt(1));
//                 System.out.println("id: "+rs.getInt(1));
                nodo.setNombreUsu(rs.getString(2));
                if(pos==0){
                data.add(rs.getString(1));}
                else{
                      data.add(rs.getString(2));
                }
                System.out.println("nombre "+rs.getString(2));
                nodo.setContraseñaUsu(rs.getString(3));
                nodo.setCalleUsu(rs.getString(4));
                nodo.setColoUsu(rs.getString(5));
                nodo.setCiudUsu(rs.getString(6));
                nodo.setCodigoPostal(rs.getString(7));
                nodo.setTelefonoUsu(rs.getString(8));
                
                nodo.setSueldoUsu(rs.getInt(10));
                nodo.setPuntosUsu(rs.getInt(11));
                nodo.setTipoPermiso(rs.getInt(12));
                nodo.setEstadoContrato(rs.getString(13));
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

    
    
    public void eliminarUsuario(int id)
    {
        
     //   cr.Actualizar("update usuarios set estadoContrato='Terminado' where idUsu="+id+"");
        cr.setCall("call EliminarUsuario("+ id +")");
    }
    
    public void modificarUsuario()
    {
        cr.insertar("call   ProcActualizarUsuario("
                    +""+getIdUsu()+","
                    + "'"+getNombreUsu()+"',"
                    +"'"+getContraseñaUsu()+"',"
                    + "'" +getCalleUsu()+"',"
                    + "'"+getColoUsu()+"',"
                    + "'"+getCiudUsu()+"',"
                    + "'"+getCodigoPostal()+"',"
                    + "'"+getTelefonoUsu()+"',"
                    + getSueldoUsu()+","
                    + getPuntosUsu()+","
                    + getTipoPermiso()+","
                    + "'"+getEstadoContrato()+"'"
                    +")");
    }
    
    /**
     * @return the idUsu
     */
    public int getIdUsu() {
        return idUsu.get();
    }
    
    /**
     * @param idUsu the idUsu to set
     */
    public void setIdUsu(int idUsu) {
        this.idUsu.set(idUsu);
    }
    
    /**
     * @return the nombreUsu
     */
    public String getNombreUsu() {
        return nombreUsu.get();
    }

    /**
     * @param nombreUsu the nombreUsu to set
     */
    public void setNombreUsu(String nombreUsu) {
      
       this.nombreUsu.set(nombreUsu);
    }
    
    /**
     * @return the contraseñaUsu
     */
    public String getContraseñaUsu() {
        return contraseñaUsu.get();
    }

    /**
     * @param contraseñaUsu the contraseñaUsu to set
     */
    public void setContraseñaUsu(String contraseñaUsu) {
      
       this.contraseñaUsu.set(contraseñaUsu);
    }
    
    /**
     * @return the calleUsu
     */
    public String getCalleUsu() {
        return calleUsu.get();
    }

    /**
     * @param calleUsu the calleUsu to set
     */
    public void setCalleUsu(String calleUsu) {
      
       this.calleUsu.set(calleUsu);
    }
    
    /**
     * @return the coloUsu
     */
    public String getColoUsu() {
        return coloUsu.get();
    }

    /**
     * @param coloUsu the coloUsu to set
     */
    public void setColoUsu(String coloUsu) {
      
       this.coloUsu.set(coloUsu);
    }
    
    /**
     * @return the ciudUsu
     */
    public String getCiudUsu() {
        return ciudUsu.get();
    }

    /**
     * @param ciudUsu the ciudUsu to set
     */
    public void setCiudUsu(String ciudUsu) {
      
       this.ciudUsu.set(ciudUsu);
    }
    
    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal.get();
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
      
       this.codigoPostal.set(codigoPostal);
    }
    
    /**
     * @return the telefonoUSu
     */
    public String getTelefonoUsu() {
        return telefonoUsu.get();
    }

    /**
     * @param telefonoUsu the telefonoUsu to set
     */
    public void setTelefonoUsu(String telefonoUsu) {
      
       this.telefonoUsu.set(telefonoUsu);
    }
    
    /**
     * @return the sueldoUsu
     */
    public int getSueldoUsu() {
        return sueldoUsu.get();
    }

    /**
     * @param sueldoUsu the sueldoUsu to set
     */
    public void setSueldoUsu(int sueldoUsu) {
      
       this.sueldoUsu.set(sueldoUsu);
    }
    
    /**
     * @return the puntosUsu
     */
    public int getPuntosUsu() {
        return puntosUsu.get();
    }

    /**
     * @param puntosUsu the puntosUsu to set
     */
    public void setPuntosUsu(int puntosUsu) {
      
       this.puntosUsu.set(puntosUsu);
    }
    
    /**
     * @return the tipoPermiso
     */
    public int getTipoPermiso() {
        return tipoPermiso.get();
    }

    /**
     * @param tipoPermiso
     */
    public void setTipoPermiso(int tipoPermiso) {
      
       this.tipoPermiso.set(tipoPermiso);
    }
    
    /**
     * @return the estadoContrato
     */
    public String getEstadoContrato() {
        return estadoContrato.get();
    }

    /**
     * @param estadoContrato the estadoContrato to set
     */
    public void setEstadoContrato(String estadoContrato) {
      
       this.estadoContrato.set(estadoContrato);
    }

   
    
}
