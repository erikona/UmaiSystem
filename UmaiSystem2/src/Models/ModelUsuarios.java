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

/**
 *
 * @author lalo
 */
public class ModelUsuarios {
    
    private  SimpleIntegerProperty idUsu = new SimpleIntegerProperty();
    private SimpleStringProperty nombreUsu = new SimpleStringProperty();
    private  SimpleStringProperty contraseñaUsu = new SimpleStringProperty();
    private  SimpleStringProperty calleUsu = new SimpleStringProperty();
    private  SimpleStringProperty coloUsu = new SimpleStringProperty();
    private  SimpleStringProperty ciudUsu = new SimpleStringProperty();
    private  SimpleIntegerProperty codigoPostal = new SimpleIntegerProperty();
    private  SimpleIntegerProperty telefonoUsu = new SimpleIntegerProperty();
    private  SimpleIntegerProperty sueldoUsu = new SimpleIntegerProperty();
    private  SimpleIntegerProperty puntosUsu = new SimpleIntegerProperty();
    private  SimpleStringProperty tipoPermiso = new SimpleStringProperty();
    private  SimpleStringProperty estadoContrato = new SimpleStringProperty();
    
    CRUD cr=new CRUD();
    
    public ModelUsuarios() 
    {
    }
    
    public ModelUsuarios(SimpleIntegerProperty idUsu, SimpleStringProperty nombreUsu, 
            SimpleStringProperty contraseñaUsu, SimpleStringProperty calleUsu, 
            SimpleStringProperty coloUsu, SimpleStringProperty ciudUsu,
            SimpleIntegerProperty codigoPostal, SimpleIntegerProperty telefonoUsu,
            SimpleIntegerProperty sueldoUsu, SimpleIntegerProperty puntosUsu,
            SimpleStringProperty tipoPermiso, SimpleStringProperty estadoContrato
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
       
    cr.insertar("call ProcInsertarUsuario("
                    + "'"+getNombreUsu()+"',"
                    + "'" +getContraseñaUsu()+"',"
                    +getCalleUsu()+","
                    +getColoUsu()+","
                    +"'"+getCiudUsu()+"',"
                    +getCodigoPostal()+"',"
                    +getTelefonoUsu()+"',"
                    +getSueldoUsu()+"',"
                    +getPuntosUsu()+"',"
                    +getTipoPermiso()+"',"
                    +getEstadoContrato()+")");
      
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
    public int getCodigoPostal() {
        return codigoPostal.get();
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
      
       this.ciudUsu.set(codigoPostal);
    }
    
    /**
     * @return the telefonoUSu
     */
    public int getTelefonoUsu() {
        return telefonoUsu.get();
    }

    /**
     * @param telefonoUsu the telefonoUsu to set
     */
    public void setTelefonoUsu(int telefonoUsu) {
      
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
    public String getTipoPermiso() {
        return tipoPermiso.get();
    }

    /**
     * @param puntosUsu the puntosUsu to set
     */
    public void setTipoPermiso(String tipoPermiso) {
      
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
