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
public class ConsultaCodigosPostales {
    
    
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
    
}
