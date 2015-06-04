/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class AgregarProveedorController implements Initializable {
    @FXML
    private TextField txtNombreProv;
    @FXML
    private TextField txtTelefonoProv;
    @FXML
    private TextField txtEmailProv;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    @FXML
    private Label lblError;
    @FXML
    private ComboBox<String> cboxCodigoProveedor;
    @FXML
    private ComboBox<String> cboxCiudadProv;
    @FXML
    private Label txtCalleProv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Models.CRUD cr = new Models.CRUD();
            ResultSet resul = null;
                resul = (ResultSet) cr.Consulta("Select CodigoPostal from CodigosPostales where Estado='Jalisco'");
                try{
                    while(resul.next()){
                        cboxCodigoProveedor.getItems().add(resul.getString(1));
                    }
                    resul.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(AgregarProveedorController.class.getName()).log(Level.SEVERE,null,ex);
                }
        txtNombreProv.textProperty().addListener(new ChangeListener<String>(){
           public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
               if(newValue.matches("^[A-Za-z]*(\\s?[A-Za-z]*)*")&& newValue.length()<30){
                   txtNombreProv.setText(newValue);
               }
                else{
                   txtNombreProv.setText(oldValue);
               }
           } 
        });
        txtTelefonoProv.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")&& newValue.length()<20){
                    txtTelefonoProv.setText(newValue);
                }
                else{
                    txtTelefonoProv.setText(oldValue);
                }
            }
        });
        txtEmailProv.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[A-Za-z0-9._-]*@?[A-Za-z0-9]*")&& newValue.length()<50){
                    txtEmailProv.setText(newValue);
                }
                else{
                    txtEmailProv.setText(oldValue);
                }
            }        
        });
        txtCalleProv.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("([A-Za-z0-9]*\\s?)*#?[0-9]*")&& newValue.length()<50){
                    txtCalleProv.setText(newValue);
                }
                else{
                    txtCalleProv.setText(oldValue);
                }
            }        
        });
        
    }    
    
    @FXML
    private void btnCancelarClick(ActionEvent event) {
        
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) {
        Models.ModelProveedores proveedores = new Models.ModelProveedores();
        String mensageE ="Campo: ";
        if(txtNombreProv.getText().equals("")){
            mensageE+=", Nombre";
        }
        if(txtTelefonoProv.getText().equals("")){
            mensageE+=", Telefono";
        }
        if(txtEmailProv.getText().equals("")){
            mensageE+=", Email";
        }
        if(cboxCodigoProveedor.getValue()==null){
            mensageE+=", C.P.";
        }
        if(cboxCiudadProv.getValue()==null){
            mensageE+=", Ciudad";
        }
        if(txtCalleProv.getText().equals("")){
            mensageE+=", Calle";
        }
        mensageE+=" vacío ";
        lblError.setText(mensageE);
        lblError.setVisible(true);
        if(!txtNombreProv.getText().equals("")
           && !txtTelefonoProv.getText().equals("")
           && !txtEmailProv.getText().equals("")
           && cboxCodigoProveedor.getValue()!=null
           && cboxCiudadProv.getValue()!=null
           && !txtCalleProv.getText().equals("")){
            
            proveedores.setNombreProv(txtNombreProv.getText());
            proveedores.setTelefonoProv(txtTelefonoProv.getText());
            proveedores.setEmailProv(txtEmailProv.getText());
            proveedores.setCodigoProv(cboxCodigoProveedor.getValue());
            proveedores.setCiudadProv(cboxCiudadProv.getValue());
            proveedores.setCalleProv(txtCalleProv.getText());
            
            proveedores.agregarProveedor();
            lblError.setText("Agregado bien chido");
            txtNombreProv.setText("");
            txtTelefonoProv.setText("");
            txtEmailProv.setText("");
            cboxCodigoProveedor.setValue("");
            cboxCiudadProv.setValue("");
            txtCalleProv.setText("");
        }
    }
    
    @FXML
    private void eventCodigoProveedor(ActionEvent event) {
        if(cboxCodigoProveedor.getValue()!=null){
            Models.CRUD cr = new Models.CRUD();
            ResultSet resul = null;  
            resul=(ResultSet) cr.Consulta("Select Municipio from CodigosPostales where CodigoPostal='"+cboxCodigoProveedor.getValue()+"'");
            cboxCiudadProv.getItems().clear();
            try {
                  
                while(resul.next()){
                      cboxCiudadProv.getItems().add(resul.getString(1));
                      cboxCiudadProv.setValue(resul.getString(1));
                }
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarProveedorController.class.getName()).log(Level.SEVERE,null,ex);
           }
        }
    }
    
    @FXML
    private void eventCiudadProv(ActionEvent event){
        
    }
}
