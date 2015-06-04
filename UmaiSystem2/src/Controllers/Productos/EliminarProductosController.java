/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Productos;

import Models.ModelProductos;
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
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author
 */
public class EliminarProductosController implements Initializable {
    @FXML
    private RadioButton rbNombProd;
    @FXML
    private ToggleGroup grupoEliminarProducto;
    @FXML
    private RadioButton rbIdProd;
    @FXML
    private TextField txtNombreProd;
    @FXML
    private TextField txtIdProd;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtBuscarProd;
    @FXML
    private ListView<String> lstContenedorConsulta;

    
     public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    @FXML
    private GridPane gridContenedor;
    @FXML
    private Label lblMensaje;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtBuscarProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[^'\"]*")){
                txtBuscarProd.setText(newValue);
            }
            else
            {
                txtBuscarProd.setText(oldValue);
            }
            }
        });
    }    

    @FXML
    private void rbNombProdClick(ActionEvent event) {
        Limpiar();
        txtBuscarProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("([A-Za-z]*\\s*)*")){
                txtBuscarProd.setText(newValue);
            }
            else
            {
                txtBuscarProd.setText(oldValue);
            }
            }
        });
    }

    @FXML
    private void rbIdProdClick(ActionEvent event) {
        Limpiar();
        txtBuscarProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[0-9]*")){
                txtBuscarProd.setText(newValue);
            }
            else
            {
                txtBuscarProd.setText(oldValue);
            }
            }
        });
        
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnEliminarClick(ActionEvent event) {
        try {
            Models.ModelProductos prod=new Models.ModelProductos();
    prod.eliminarProductos(Integer.parseInt(txtIdProd.getText()));
            lblMensaje.setText("Eliminación correcta!");
            lblMensaje.setVisible(true);
            Limpiar();
            gridContenedor.setVisible(false);
            
        } catch (Exception e) {
        }
        
    
    }
    

    @FXML
    private void eventBuscarProd(KeyEvent event) {
        Models.ModelProductos prod=new Models.ModelProductos();
         
        if(rbNombProd.isSelected())
         {
            if(!txtBuscarProd.getText().equals("")){
                getData().clear();
                
                lblMensaje.setVisible(false);
                if(prod.ConsultarNombre(2,lstContenedorConsulta,data,txtBuscarProd.getText())){
                   
                lstContenedorConsulta.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                gridContenedor.setVisible(true);
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProductos nodo=(ModelProductos) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedor.setVisible(true);
                                   
                                    txtIdProd.setVisible(true);
                                    txtNombreProd.setVisible(true);
                                    
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    gridContenedor.setVisible(false);
                     
                                    txtIdProd.setVisible(false);
                                    txtNombreProd.setVisible(false);
                     
                } 
                
               
            }
        }
         else if(rbIdProd.isSelected()){
             if(!txtBuscarProd.getText().equals("")){
                 
                 if(Esdigito(txtBuscarProd.getText())){
                getData().clear();
                lblMensaje.setVisible(false);
                gridContenedor.setVisible(false);
                if(prod.ConsultarID(2,lstContenedorConsulta,data,Integer.parseInt(txtBuscarProd.getText()) )){
                   
                lstContenedorConsulta.setVisible(true);  
                
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProductos nodo=(ModelProductos) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    
                                  gridContenedor.setVisible(true);
                                  
                                    txtIdProd.setVisible(true);
                                    txtNombreProd.setVisible(true);
                                   
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                   gridContenedor.setVisible(false);
                     lblMensaje.setText("Sin Resultados ");
                     lblMensaje.setVisible(true);
                     txtIdProd.setVisible(false);
                     txtNombreProd.setVisible(false);
                     
                } 
                
               
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
    public static ObservableList getData() {
        return data;
    }
    
    private void vaciarDatosTxt(ModelProductos prod) {
       
                   
                   txtIdProd.setText(String.valueOf(prod.getIdProd()));
                   txtNombreProd.setText(prod.getNombreProd());
                 
                   
    }

    private void Limpiar() {
            
        txtIdProd.setText("");
        txtNombreProd.setText("");
        txtBuscarProd.setText("");
    }

    private boolean Esdigito(String text) {
        return text.matches("[0-9]+");
                
                }
}

