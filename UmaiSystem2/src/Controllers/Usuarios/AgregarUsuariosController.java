/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuarios;

import com.mysql.jdbc.ResultSet;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author erika
 */
public class AgregarUsuariosController implements Initializable {
    @FXML
    private TextField txtNomUsu;
    
    @FXML
    private TextField txtTelefonoUsu;
    @FXML
    private TextField txtSueldoUsu;
    @FXML
    private TextField txtPuntosUsu;
    
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    @FXML
    private PasswordField txtContra;
    @FXML
    private ComboBox<String> cbCodigoPostal;
    @FXML
    private ComboBox<String> cbCiudad;
    @FXML
    private ComboBox<String> cbColonia;
    @FXML
    private TextField txtCalle;
    @FXML
    private ComboBox<Integer> cbPermiso;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select CodigoPostal from CodigosPostales where Estado='Jalisco'");
            
            try {
                  
                while(resul.next()){
                        cbCodigoPostal.getItems().add(resul.getString(1));
                }   
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            cbPermiso.getItems().addAll(1,2,3);
        txtNomUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("^[A-Za-z]*(\\s?[A-Za-z]*)*") && newValue.length()<30){
                txtNomUsu.setText(newValue);
            }
            else
            {
                txtNomUsu.setText(oldValue);
            }
            }
        });
        txtContra.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
           if(newValue.matches(".*") && newValue.length()<30){
                txtContra.setText(newValue);
            }
            else
            {
                txtContra.setText(oldValue);
            }
            }
        });
        
        txtCalle.textProperty().addListener(new ChangeListener<String>(){

             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("([A-Za-z0-9]*\\s?)*#?[A-Za-z0-9]*") && newValue.length()<50){
                    
                    txtCalle.setText(newValue);
                }else{
                    txtCalle.setText(oldValue);
                }
             }
            
        });
        
        
        
        txtTelefonoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")&& newValue.length()<20){
                    txtTelefonoUsu.setText(newValue);
                }else{
                    txtTelefonoUsu.setText(oldValue);
                }
             }
        });
        txtSueldoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*") ){
                    txtSueldoUsu.setText(newValue);
                }else{
                    txtSueldoUsu.setText(oldValue);
                }
             }
        });
        txtPuntosUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")){
                    txtPuntosUsu.setText(newValue);
                }else{
                    txtPuntosUsu.setText(oldValue);
                }
             }
        });
     
    }   
    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) 
    {
        Models.ModelUsuarios usuarios=new Models.ModelUsuarios();
        String mensageE="Campo: ";
          if(txtNomUsu.getText().equals("")){
              mensageE+="Nombre";
          }
          if(txtContra.getText().equals("")){
              mensageE+=", Contraseña";
          }
          if(txtCalle.getText().equals("")){
              mensageE+=", Calle";
          }
          if(cbColonia.getValue()==null){
              mensageE+=", Colonia";
          }
         if(cbCiudad.getValue()==null){
              mensageE+=", Ciudad";
          }
         if(cbCodigoPostal.getValue()==null){
              mensageE+=", C.P.";
          }
         if(txtTelefonoUsu.getText().equals("")){
              mensageE+=", Telefono";
          }
         if(txtSueldoUsu.getText().equals("")){
              mensageE+=", Sueldo";
          }
         if(txtPuntosUsu.getText().equals("")){
              mensageE+=", Puntuación";
          }
         if(cbPermiso.getValue()==null){
              mensageE+=", Permiso";
          }
         
          mensageE+=" vacio";
          lblError.setText(mensageE);
          lblError.setVisible(true);
           if(   !txtNomUsu.getText().equals("")
           && !txtContra.getText().equals("")
           && !txtCalle.getText().equals("")
           && cbColonia.getValue()!=null
           && cbCiudad.getValue()!=null
           && cbCodigoPostal.getValue()!=null
           && !txtTelefonoUsu.getText().equals("")
           && !txtSueldoUsu.getText().equals("")
           && !txtPuntosUsu.getText().equals("") 
           && cbPermiso.getValue()!=null
           
          )
        {
        usuarios.setNombreUsu(txtNomUsu.getText());
        usuarios.setContraseñaUsu(txtContra.getText());
        usuarios.setCalleUsu(txtCalle.getText());
        usuarios.setColoUsu( cbColonia.getValue());
        usuarios.setCiudUsu(cbCiudad.getValue());
        usuarios.setCodigoPostal(cbCodigoPostal.getValue());
        usuarios.setTelefonoUsu(txtTelefonoUsu.getText());
        usuarios.setSueldoUsu(Integer.parseInt(txtSueldoUsu.getText()));
        usuarios.setPuntosUsu(Integer.parseInt(txtPuntosUsu.getText()));
        usuarios.setTipoPermiso(cbPermiso.getValue());
        
           // System.out.println("que tiene codigo postal  "+cbCodigoPostal.getValue());
            
            usuarios.agregarUsuarios();
            lblError.setText("Agregado Correcto");
            txtNomUsu.setText("");
            txtContra.setText("");
            txtCalle.setText("");
            cbColonia.setValue("");
            cbCiudad.setValue("");
            cbCodigoPostal.setValue("");
            txtTelefonoUsu.setText("");
            txtSueldoUsu.setText("");
            txtPuntosUsu.setText("");
            cbPermiso.setValue(0);
    }
    }

    @FXML
    private void txtNomUsuarioClick(ActionEvent event) {
    }


    @FXML
    private void txtTelefonoUsuClick(ActionEvent event) {
    }

    @FXML
    private void txtSueldoUsuClick(ActionEvent event) {
    }

    @FXML
    private void txtPuntosUsuClick(ActionEvent event) {
    
    
    }

    @FXML
    private void eventCodigoPostal(ActionEvent event) {
        
        if(cbCodigoPostal.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Municipio from CodigosPostales where CodigoPostal='"+cbCodigoPostal.getValue() +"'");
            cbCiudad.getItems().clear();
            try {
                  
                while(resul.next()){
                      cbCiudad.getItems().add(resul.getString(1));
                        cbCiudad.setValue(resul.getString(1));
                }
                resul.close();
               AñadirColonias();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
    }
    
    
    public void AñadirColonias(){
        if(cbCiudad.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Colonia from CodigosPostales where Municipio='"+cbCiudad.getValue() +"'");
            String [] Colon=null;
            try {
                   cbColonia.getItems().clear();
                while(resul.next()){
                    String temp=resul.getString(1);
                    Colon=separarColonias(temp);
                   
                    //cbColonia.getItems().add(resul.getString(1));
                    cbColonia.setValue(Colon[0]);
                for (int i = 0; i <Colon.length; i++) {
                    cbColonia.getItems().add(Colon[i]);
                }
                }
                
                resul.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
    }

    @FXML
    private void eventCiudad(ActionEvent event) {
        /*
        if(cbCiudad.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Colonia from CodigosPostales where Municipio='"+cbCiudad.getValue() +"'");
            
            try {
                  
                while(resul.next()){
                    String temp=resul.getString(1);
                    
                        cbColonia.getItems().add(resul.getString(1));
                }   
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
                */
    }

    @FXML
    private void eventColonia(ActionEvent event) {
        
        
    }

    @FXML
    private void eventPermiso(ActionEvent event) {
    }

     public static String[] separarColonias(String texto)
    {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto,";",false);
        String separados[]=new String[tokens.countTokens()];
        int i=0;
        while (tokens.hasMoreTokens()) 
        {
            separados[i]=tokens.nextToken();
            i++;
        }
        return separados;
    }
}
