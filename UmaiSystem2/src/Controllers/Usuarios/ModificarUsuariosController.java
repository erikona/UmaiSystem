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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ModificarUsuariosController implements Initializable {
    @FXML
    private RadioButton rbNombUsu;
    @FXML
    private RadioButton rbIdUsu;
    @FXML
    private TextField txtBuscarUsu;
    @FXML
    private TextField txtNomUsu;
    @FXML
    private TextField txtContraseñaUsu;
    @FXML
    private TextField txtTelefonoUsu;
    @FXML
    private TextField txtSueldoUsu;
    @FXML
    private TextField txtPuntosUsu;
    @FXML
    private TextField txtIdUsu;
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnModificar;
    @FXML
    private ToggleGroup GrupoModificar;
    @FXML
    private ComboBox<String> cboxCpUsu;
    @FXML
    private ComboBox<String> cboxCiudadUsu;
    @FXML
    private ComboBox<String> cboxColUsu;
    @FXML
    private ComboBox<Integer> cboxPermisoUsu;
    @FXML
    private ComboBox<String> cboxEstadoUsu;
    @FXML
    private TextField txtCalleUsu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select CodigoPostal from CodigosPostales where Estado='Jalisco'");
            
            try {
                  
                while(resul.next()){
                        cboxCpUsu.getItems().add(resul.getString(1));
                }   
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            cboxPermisoUsu.getItems().addAll(1,2,3);
        txtNomUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[a-z0-9_-]*")){
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
           if(newValue.matches("\\d*")){
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
                if(newValue.matches("[A-Aa-z0-9]*\\s*#?[A-Za-z0-9]*")){
                    txtCalleUsu.setText(newValue);
                }else{
                    txtCalleUsu.setText(oldValue);
                }
             }
            
        });
        
        
        
        txtTelefonoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")){
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
    }    

    @FXML
    private void rbNombUsuClick(ActionEvent event) {
    }

    @FXML
    private void rbIdUsuClick(ActionEvent event) {
    }


    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnModificarClick(ActionEvent event) {
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
          if(cboxColUsu.getValue()==null){
              mensageE+=", Colonia";
          }
         if(cboxCiudadUsu.getValue()==null){
              mensageE+=", Ciudad";
          }
         if(cboxCpUsu.getValue()==null){
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
         if(cboxPermisoUsu.getValue()==null){
              mensageE+=", Permiso";
          }
         
          mensageE+=" vacios";
          lblError.setText(mensageE);
           if(   !txtNomUsu.getText().equals("")
           && !txtContraseñaUsu.getText().equals("")
           && !txtCalleUsu.getText().equals("")
           && cboxColUsu.getValue()!=null
           && cboxCiudadUsu.getValue()!=null
           && cboxCpUsu.getValue()!=null
           && !txtTelefonoUsu.getText().equals("")
           && !txtSueldoUsu.getText().equals("")
           && !txtPuntosUsu.getText().equals("") 
           && cboxPermisoUsu.getValue()!=null
           
          )
        {
        usuarios.setNombreUsu(txtNomUsu.getText());
        usuarios.setContraseñaUsu(txtContraseñaUsu.getText());
        usuarios.setCalleUsu(txtCalleUsu.getText());
        usuarios.setColoUsu( cboxColUsu.getValue());
        usuarios.setCiudUsu(cboxCiudadUsu.getValue());
        usuarios.setCodigoPostal(cboxCpUsu.getValue());
        usuarios.setTelefonoUsu(txtTelefonoUsu.getText());
        usuarios.setSueldoUsu(Integer.parseInt(txtSueldoUsu.getText()));
        usuarios.setPuntosUsu(Integer.parseInt(txtPuntosUsu.getText()));
        usuarios.setTipoPermiso(cboxPermisoUsu.getValue());
        
           // System.out.println("que tiene codigo postal  "+cbCodigoPostal.getValue());
            
           /// usuarios.agregarUsuarios();
                usuarios.modificarUsuario();
            lblError.setText("Agregado Correcto");
            txtNomUsu.setText("");
            txtContraseñaUsu.setText("");
            txtCalleUsu.setText("");
            cboxColUsu.setValue("");
            cboxCiudadUsu.setValue("");
            cboxCpUsu.setValue("");
            txtTelefonoUsu.setText("");
            txtSueldoUsu.setText("");
            txtPuntosUsu.setText("");
            cboxPermisoUsu.setValue(0);
    }
    }

    @FXML
    private void eventBuscarModificar(KeyEvent event) {
        /*
        Models.ModelProductos mProd=new Models.ModelProductos();
        if(rbIdUsu.isSelected()){
            if(!txtBuscarUsu.getText().equals("")){
             if( mProd.consultarProductoID( Integer.parseInt( txtBuscarProd.getText() ) )  )
             {
                 vaciarDatosTxt();
                 
             }
             else{
                 
        
        /////////////////////////////////////////////////////////////
         
        /////////////////////////////////////////////////////////////////
             }
        }
        }
        else if(rbNombUsu.isSelected()){
            if(!txtBuscarUsu.getText().equals("")){
              if( mProd.consultarProductoNombre(txtBuscarProd.getText()) )
              {
                  vaciarDatosTxt();
                  txtCantProd.setEditable(true);
       txtDescProd.setEditable(true);
      txtNombreProd.setEditable(true);
      txtPrecioProd.setEditable(true);
      cboxNombreProv.setDisable(false);
      cboxUnidadProd.setDisable(false);
              }
              else{
                    txtCantProd.setText("");
                    txtDescProd.setText("");
                    txtIdProd.setText("");
                    txtNombreProd.setText("");
                    //txtNombreProv.setText("");
                      cboxNombreProv.setValue("");
                    txtPrecioProd.setText("");
                    //txtUnidadMed.setText("");
                    cboxUnidadProd.setValue("");
                     /////////////////////////////////////////////////////////////
         txtCantProd.setEditable(false);
       txtDescProd.setEditable(false);
      txtNombreProd.setEditable(false);
      txtPrecioProd.setEditable(false);
      cboxNombreProv.setDisable(true);
      cboxUnidadProd.setDisable(true);
        /////////////////////////////////////////////////////////////////
              }
        }
        } 
                */
    }
    
}
