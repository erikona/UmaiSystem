/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import Models.ModelProveedores;

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
public class EliminarProveedorController implements Initializable {
    @FXML
    private RadioButton rbNombre;
    @FXML
    private RadioButton rbId;
    @FXML
    private TextField txtBuscarProv;
    @FXML
    private TextField txtIdProv;
    @FXML
    private TextField txtNombreProv;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button txtEliminar;
    @FXML
    private ToggleGroup grupoEliminarProv;
    @FXML
    private ListView<String> lstContenedorBuscarProv;
public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    @FXML
    private GridPane gridContenedorCampos;
    @FXML
    private Label lblMensaje;
    private boolean banCon=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtBuscarProv.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[^'\"]*")){
                txtBuscarProv.setText(newValue);
            }
            else
            {
                txtBuscarProv.setText(oldValue);
            }
            }
        });
        /*
         if(rbNombre.isSelected()){
        txtBuscarProv.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("([A-Za-z]*\\s*)*")){
                txtBuscarProv.setText(newValue);
            }
            else
            {
                txtBuscarProv.setText(oldValue);
            }
            }
        });
    }
                */
    }    

    @FXML
    private void rbNombreClick(ActionEvent event) {
         Limpiar();
        
    }

    @FXML
    private void rbIdClick(ActionEvent event) {
         Limpiar();
      
    }
   
    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnDesactivarClick(ActionEvent event) {
         if(!txtBuscarProv.getText().equals("") && !txtIdProv.getText().equals("")){
           Models.ModelProveedores mProv=new Models.ModelProveedores();
             //Models.ModelUsuarios mProd=new Models.ModelUsuarios();
            mProv.eliminarProveedor(Integer.parseInt(txtIdProv.getText()));
            lblMensaje.setText("Modificacion Correcta");
            lblMensaje.setVisible(true);
            txtBuscarProv.setText("");
            txtIdProv.setText("");
            txtNombreProv.setText("");
        }
    }

    @FXML
    private void eventBuscarEliminarProveedor(KeyEvent event) {
        
       //  Models.ModelUsuarios prov=new Models.ModelUsuarios();
        Models.ModelProveedores prov=new Models.ModelProveedores();
        
         gridContenedorCampos.setVisible(false);
       //  lblMensaje.setText("");
         if(rbNombre.isSelected())
         {
          
            if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prov.ConsultarNombreEliminar(lstContenedorBuscarProv,data,txtBuscarProv.getText())){
                   
                lstContenedorBuscarProv.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                   //  lblMensaje.setText("");
                lstContenedorBuscarProv.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProveedores nodo=(ModelProveedores) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorCampos.setVisible(true);
                                    lstContenedorBuscarProv.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorBuscarProv.setVisible(false);
                   gridContenedorCampos.setVisible(false);
                } 
                
                }
            }
        }
         else if(rbId.isSelected()){
            
             if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                 //System.out.println("entro ");
                if(!isBanCon()){
                 if(prov.consultarIDEliminar(lstContenedorBuscarProv,data,Integer.parseInt(txtBuscarProv.getText()) )){
                   
                lstContenedorBuscarProv.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                  //   lblMensaje.setText("");
                lstContenedorBuscarProv.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProveedores nodo=(ModelProveedores) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorCampos.setVisible(true);
                                    lstContenedorBuscarProv.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorBuscarProv.setVisible(false);
                    gridContenedorCampos.setVisible(false);
                } 
                }
               
            }
         }
    }
    
    public static ObservableList getData() {
        return data;
    }
     public ListView<?> getLstContenedorConsulta() {
        
        return lstContenedorBuscarProv;
        
    }
    public void setList(ObservableList listt){
        list=listt;
    }
    private void Limpiar() {
            
        txtIdProv.setText("");
        txtBuscarProv.setText("");
        //.setText("");
       txtNombreProv.setText("");
        
}

   private void vaciarDatosTxt(ModelProveedores prov) {
       
       
        txtIdProv.setText(String.valueOf(prov.getIdProv()));
        txtNombreProv.setText(prov.getNombreProv());
      
    }

    @FXML
    private void eventvalidarBusqueda(KeyEvent event) {
        
            String c=event.getCharacter();
             
         if(rbId.isSelected()){
            if(!Character.isDigit(c.charAt(0))) 
            { 
            //  getToolkit().beep(); 
               
              event.consume(); 
               
              lblMensaje.setText("Ingresa Solo numeros"); 
               lblMensaje.setVisible(true);
                setBanCon(true);
            }else{lblMensaje.setVisible(false);setBanCon(false);} 
         }
         else if(rbNombre.isSelected()){
               
                if(!Character.isLetter(c.charAt(0))) 
                { 
              //getToolkit().beep(); 
               
              event.consume(); 
               setBanCon(true);
              lblMensaje.setText("Ingresa Solo letras"); 
              lblMensaje.setVisible(true);
              } else {lblMensaje.setVisible(false);setBanCon(false);}
    }
    }

    /**
     * @return the banCon
     */
    public boolean isBanCon() {
        return banCon;
    }

    /**
     * @param banCon the banCon to set
     */
    public void setBanCon(boolean banCon) {
        this.banCon = banCon;
    }
}
