/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuarios;

import Models.ModelUsuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ConsultarUsuariosController implements Initializable {

    /**
     * @return the data
     */
    public static ObservableList getData() {
        return data;
    }
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
    private TextField txtIdUsu;
    @FXML
    private ToggleGroup GrupoConsultar;
    

    public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    
    
     @FXML
    public   ListView<String> lstContenedorConsulta;
    @FXML
    private GridPane gridContenedorDatos;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtBuscarUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[^'\"]*")){
                txtBuscarUsu.setText(newValue);
            }
            else
            {
                txtBuscarUsu.setText(oldValue);
            }
            }
        });
    }    

    @FXML
    private void rbNombUsuClick(ActionEvent event) {
        Limpiar();
        txtBuscarUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("([A-Za-z]*\\s*)*")){
                txtBuscarUsu.setText(newValue);
            }
            else
            {
                txtBuscarUsu.setText(oldValue);
            }
            }
        });
        
    }

    @FXML
    private void rbIdUsuClick(ActionEvent event) {
        
           Limpiar();
        txtBuscarUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[0-9]*")){
                txtBuscarUsu.setText(newValue);
            }
            else
            {
                txtBuscarUsu.setText(oldValue);
            }
            }
        });
    }


    @FXML
    private void eventBuscarConsultar(KeyEvent event) {
         Models.ModelUsuarios usu=new Models.ModelUsuarios();
         gridContenedorDatos.setVisible(false);
         if(rbNombUsu.isSelected())
         {
            if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                
                if(usu.ConsultarNombre(0,lstContenedorConsulta,data,txtBuscarUsu.getText())){
                   
                lstContenedorConsulta.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelUsuarios nodo=(ModelUsuarios) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorDatos.setVisible(true);
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    gridContenedorDatos.setVisible(false);
                } 
                
               
            }
        }
         else if(rbIdUsu.isSelected()){
             if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                
                if(usu.ConsultarID(0,lstContenedorConsulta,data,Integer.parseInt(txtBuscarUsu.getText()) )){
                   
                lstContenedorConsulta.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelUsuarios nodo=(ModelUsuarios) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorDatos.setVisible(true);
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    gridContenedorDatos.setVisible(false);
                } 
                
               
            }
         }
        
    }
    
    
    
    
    private void vaciarDatosTxt(ModelUsuarios usu) {
       
                    txtCalleUsu.setText(usu.getCalleUsu());
                    txtCiudadUsu.setText(usu.getCiudUsu());
                    txtColoniaUsu.setText(usu.getColoUsu());
                    txtContraseñaUsu.setText(usu.getContraseñaUsu());
                    txtContratoUsu.setText(usu.getEstadoContrato());
                    txtCpUsu.setText(usu.getCodigoPostal());
                    txtIdUsu.setText(String.valueOf(usu.getIdUsu()));
                    txtNomUsu.setText(usu.getNombreUsu());
                    txtPermisoUsu.setText(String.valueOf(usu.getTipoPermiso()));
                    txtPuntosUsu.setText(String.valueOf(usu.getPuntosUsu()));
                    txtSueldoUsu.setText(String.valueOf(usu.getSueldoUsu()));
                    txtTelefonoUsu.setText(usu.getTelefonoUsu());
    }

    /**
     * @return the lstContenedorConsulta
     */
    public ListView<?> getLstContenedorConsulta() {
        
        return lstContenedorConsulta;
        
    }
    public void setList(ObservableList listt){
        list=listt;
    }
    
    private void limpiar(){
        txtCalleUsu.setText("");
        txtCiudadUsu.setText("");
        txtColoniaUsu.setText("");
        txtContraseñaUsu.setText("");
        txtContratoUsu.setText("");
        txtCpUsu.setText("");
        txtIdUsu.setText("");
        txtNomUsu.setText("");
        txtPermisoUsu.setText("");
        txtPuntosUsu.setText("");
        txtSueldoUsu.setText("");
        txtTelefonoUsu.setText("");
    }
    private void Limpiar() {
            
        txtIdUsu.setText("");
        txtBuscarUsu.setText("");
        txtCalleUsu.setText("");
        txtCiudadUsu.setText("");
        txtColoniaUsu.setText("");
        txtContraseñaUsu.setText("");
        txtContratoUsu.setText("");
        txtCpUsu.setText("");
        txtIdUsu.setText("");
        txtNomUsu.setText("");
        txtPermisoUsu.setText("");
        txtPuntosUsu.setText("");
        txtSueldoUsu.setText("");
        txtTelefonoUsu.setText("");
        
    }

}
