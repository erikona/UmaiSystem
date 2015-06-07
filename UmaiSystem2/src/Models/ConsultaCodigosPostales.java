/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class ConsultaCodigosPostales{ 
    public ArrayList getcodigosPostales()
    {
        CRUD cr=new CRUD();
        ArrayList<String> datos= new ArrayList<String>();
        try {
            ResultSet rs=cr.setCall("call consultaCodigoPostal()");
            while(rs.next()){
                datos.add(rs.getString("CodigoPostal"));
            }
        } 
        catch (Exception e){
            System.out.println("Error de excepción");
            e.printStackTrace();
            return null;
        }
        finally{
            
        }  
        return datos;
    }

    public ArrayList getMunicipios(String codigos){
        CRUD cr=new CRUD();
        ArrayList<String> datos= new ArrayList<String>();
        try{
            ResultSet rs=cr.setCall("call consultaMunicipios('"+codigos+"')");
            while(rs.next()){
                datos.add(rs.getString(1));
            }
        } 
        catch (Exception e){
            System.out.println("Error de excepción");
            e.printStackTrace();
            return null;
        }
        finally{
            
        }  
        return datos;
    }
    
    public ArrayList getColonias(String municipio)
    {
        CRUD cr=new CRUD();
        ArrayList<String> datos= new ArrayList<String>();
        try {
            ResultSet rs=cr.setCall("call consultaColonias('"+municipio+"')");
            while(rs.next()){
                datos.add(rs.getString("Colonia"));
            } 
        } 
        catch (Exception e){
            System.out.println("Error de excepción");
            e.printStackTrace();
            return null;
        }
        finally{
            
        }  
       return datos;
    }
}
