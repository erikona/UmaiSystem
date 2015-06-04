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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class EliminarUsuariosController implements Initializable {
    @FXML
    private RadioButton rbNombUsu;
    @FXML
    private RadioButton rbIdUsu;
    @FXML
    private TextField txtBuscarUsu;
    @FXML
    private TextField txtNombreUsu;
    @FXML
    private TextField txtIdUsu;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnDesactivar;
   
    @FXML
    private ToggleGroup GrupoEliminar;
    @FXML
    private ListView<String> lstContenedorConsulta;
    @FXML
    private Label lblMensaje;
    @FXML
    private HBox ContenedorDatos;
public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
    if(rbNombUsu.isSelected()){
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
    }    
public static ObservableList getData() {
        return data;
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
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnDesactivarClick(ActionEvent event) {
    if(!txtBuscarUsu.getText().equals("") && !txtIdUsu.getText().equals("")){
            Models.ModelUsuarios mProd=new Models.ModelUsuarios();
            mProd.eliminarUsuario(Integer.parseInt(txtIdUsu.getText()));
            lblMensaje.setText("Modificacion Correcta");
            lblMensaje.setVisible(true);
            txtBuscarUsu.setText("");
            txtIdUsu.setText("");
            txtNombreUsu.setText("");
        }
    }

    @FXML
    private void eventBuscarEliminar(KeyEvent event) {
        Models.ModelUsuarios usu=new Models.ModelUsuarios();
         ContenedorDatos.setVisible(false);
         if(rbNombUsu.isSelected())
         {
            if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                
                if(usu.ConsultarNombreEliminar(lstContenedorConsulta,data,txtBuscarUsu.getText())){
                   
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
                                    ContenedorDatos.setVisible(true);
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    ContenedorDatos.setVisible(false);
                } 
                
               
            }
        }
         else if(rbIdUsu.isSelected()){
             if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                
                if(usu.consultarIDEliminar(lstContenedorConsulta,data,Integer.parseInt(txtBuscarUsu.getText()) )){
                   
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
                                    ContenedorDatos.setVisible(true);
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    ContenedorDatos.setVisible(false);
                } 
                
               
            }
         }
        
        
    }
    public ListView<?> getLstContenedorConsulta() {
        
        return lstContenedorConsulta;
        
    }
    public void setList(ObservableList listt){
        list=listt;
    }
    
     private void vaciarDatosTxt(ModelUsuarios usu) {
       
       
        txtIdUsu.setText(String.valueOf(usu.getIdUsu()));
        txtNombreUsu.setText(usu.getNombreUsu());
       
    }
     
     private void Limpiar() {
            
        txtIdUsu.setText("");
        txtBuscarUsu.setText("");
        //.setText("");
       txtNombreUsu.setText("");
        
}

}