/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.Serializable;

public class ModelViewUsuario implements Serializable {

    private int id;
    private String name;
    private String contra;
    private String calle;
    private String colonia;
    private String ciudad;
    private String codigoP;
    private String telefono;
    private String avatar;
    private String sueldo;
    private String puntos;
    private String permiso;

    public ModelViewUsuario() {
    }

    public ModelViewUsuario(int id,String name, String contra,String calle,String colonia,String ciudad,String codigoP,String telefono,String avatar,String sueldo,String puntos,String permiso) {
        this.id = id;
        this.name = name;
        this.contra = contra;
        this.calle=calle;
        this.colonia=colonia;
        this.ciudad=ciudad;
        this.codigoP=codigoP;
        this.telefono =telefono;
       this.avatar =avatar;
        this.sueldo = sueldo;
        this.permiso=permiso;
        this.puntos=puntos;
       
         
        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param contra the contra to set
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the sueldo
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the puntos
     */
    public String getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the permiso
     */
    public String getPermiso() {
        return permiso;
    }

    /**
     * @param permiso the permiso to set
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the codigoP
     */
    public String getCodigoP() {
        return codigoP;
    }

    /**
     * @param codigoP the codigoP to set
     */
    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }


    
   
}






