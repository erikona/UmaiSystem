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
import javafx.scene.control.TextArea;
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
    private TextField txtContraseñaUsu;
    @FXML
    private TextField txtCalleUsu;
    @FXML
    private TextField txtColoniaUsu;
    @FXML
    private TextField txtCiudadUsu;
    @FXML
    private TextField txtCpUsu;
    @FXML
    private TextField txtTelefonoUsu;
    @FXML
    private TextField txtSueldoUsu;
    @FXML
    private TextField txtPuntosUsu;
    @FXML
    private TextField txtPermisoUsu;
    @FXML
    private TextField txtContratoUsu;
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select idUsu,nombreUsu from usuarios");
        
        txtNomUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("/^[a-z0-9_-]{3,15}$/")){
                txtNomUsu.setText(newValue);
            }
            else
            {
                txtNomUsu.setText(oldValue);
            }
            }
        });
        txtContraseñaUsu.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
           if(newValue.matches("/(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d){4,10}.+$)/")){
                txtContraseñaUsu.setText(newValue);
            }
            else
            {
                txtContraseñaUsu.setText(oldValue);
            }
            }
        });
        
        txtCalleUsu.textProperty().addListener(new ChangeListener<String>(){

             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                    txtCalleUsu.setText(newValue);
                }else{
                    txtCalleUsu.setText(oldValue);
                }
             }
            
        });
        txtColoniaUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                    txtColoniaUsu.setText(newValue);
                }else{
                    txtColoniaUsu.setText(oldValue);
                }
             }
        });
        txtCiudadUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                    txtCiudadUsu.setText(newValue);
                }else{
                    txtCiudadUsu.setText(oldValue);
                }
             }
        });
        txtCpUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$")){
                    txtCpUsu.setText(newValue);
                }else{
                    txtCpUsu.setText(oldValue);
                }
             }
        });
        txtTelefonoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("^[0-9]{2,3}-? ?[0-9]{10}$")){
                    txtTelefonoUsu.setText(newValue);
                }else{
                    txtTelefonoUsu.setText(oldValue);
                }
             }
        });
        txtSueldoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")){
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
        txtPermisoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                    txtPermisoUsu.setText(newValue);
                }else{
                    txtPermisoUsu.setText(oldValue);
                }
             }
        });
        txtContratoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                    txtContratoUsu.setText(newValue);
                }else{
                    txtContratoUsu.setText(oldValue);
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
        String mensageE="Campos: ";
          if(txtNomUsu.getText().equals("")){
              mensageE+="Nombre";
          }
          if(txtContraseñaUsu.getText().equals("")){
              mensageE+=", Contraseña";
          }
          if(txtCalleUsu.getText().equals("")){
              mensageE+=", Calle";
          }
          if(txtColoniaUsu.getText().equals("")){
              mensageE+=", Colonia";
          }
         if(txtCiudadUsu.getText().equals("")){
              mensageE+=", Ciudad";
          }
         if(txtCpUsu.getText().equals("")){
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
         if(txtPermisoUsu.getText().equals("")){
              mensageE+=", Permiso";
          }
         if(txtContratoUsu.getText().equals("")){
              mensageE+=", Contrato";
          }
          mensageE+=" vacios";
          lblError.setText(mensageE);
           if(   !txtNomUsu.getText().equals("")
           && !txtContraseñaUsu.getText().equals("")
           && !txtCalleUsu.getText().equals("")
           && !txtColoniaUsu.getText().equals("")
           && !txtCiudadUsu.getText().equals("")
           && !txtCpUsu.getText().equals("")
           && !txtTelefonoUsu.getText().equals("")
           && !txtSueldoUsu.getText().equals("")
           && !txtPuntosUsu.getText().equals("") 
           && !txtPermisoUsu.getText().equals("")
           && !txtContratoUsu.getText().equals("")
          )
        {
        usuarios.setNombreUsu(txtNomUsu.getText());
        usuarios.setContraseñaUsu(txtContraseñaUsu.getText());
        usuarios.setCalleUsu(txtCalleUsu.getText());
        usuarios.setColoUsu(txtColoniaUsu.getText());
        usuarios.setCiudUsu(txtCiudadUsu.getText());
        usuarios.setCodigoPostal(txtCpUsu.getText());
        usuarios.setTelefonoUsu(Integer.parseInt(txtTelefonoUsu.getText()));
        usuarios.setSueldoUsu(Integer.parseInt(txtSueldoUsu.getText()));
        usuarios.setPuntosUsu(Integer.parseInt(txtPuntosUsu.getText()));
        usuarios.setTipoPermiso(txtPermisoUsu.getText());
        int idProv=1;
         Models.CRUD cr=new Models.CRUD();
            ResultSet rs=null;
            
            
            
       
       usuarios.agregarUsuarios();
    }
    }
    
}
