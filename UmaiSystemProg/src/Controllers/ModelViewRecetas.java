/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.Serializable;

public class ModelViewRecetas implements Serializable {

    private int id;
    private String name;
    private String tipo;
    private String tamano;
    private String numero;
    private String tiempo;
    private String dificultad;
    private String margen;
    private String porciento;

    public ModelViewRecetas() {
    }

    public ModelViewRecetas(int id,String name, String tipo,String tamano,String numero,String tiempo,String dificultad,String margen,String porciento) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.tamano = tamano;
        this.numero = numero;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
        this.margen = margen;
        this.porciento = porciento;
        
       
         
        
    }

    /*
    public StudentPojo(int id, String name, String surname,String age, String email) {
        this.id = id;
        this.name = name;
        this.tipo = surname;
        this.tamano = age;
        this.numero =surname;
    }
    */
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    /**
     * @return the tamano
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the dificultad
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * @return the margen
     */
    public String getMargen() {
        return margen;
    }

    /**
     * @param margen the margen to set
     */
    public void setMargen(String margen) {
        this.margen = margen;
    }

    /**
     * @return the porciento
     */
    public String getPorciento() {
        return porciento;
    }

    /**
     * @param porciento the porciento to set
     */
    public void setPorciento(String porciento) {
        this.porciento = porciento;
    }

    

   

   
}






