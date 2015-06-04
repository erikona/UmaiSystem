/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import Models.ModelProveedores;
import Models.ModelUsuarios;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class ModificarProveedorController implements Initializable {
    @FXML
    private RadioButton rbNombreProv;
    @FXML
    private RadioButton rbIdProv;
    @FXML
    private TextField txtBuscarProv;
    @FXML
    private TextField txtIdProv;
    @FXML
    private TextField txtNombreProv;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button txtGuardar;
    @FXML
    private TextField txtEmailProv;
    @FXML
    private Label lblError;
    @FXML
    private TextField txtTelefonoProv;
    @FXML
    private ToggleGroup grupoModificarProveedor;
    @FXML
    private ListView<String> lstContenedorDatos;
    @FXML
    private ComboBox<String> cbCodigoPostal;
    @FXML
    private ComboBox<String> cbCiudadProveedor;
    @FXML
    private ComboBox<String> cbColonia;
    @FXML
    private TextField txtCalle;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private GridPane gridContenedorCampos;
 public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
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
        Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select CodigoPostal from CodigosPostales where Estado='Jalisco'");
            
            try {
                  
                while(resul.next()){
                        cbCodigoPostal.getItems().add(resul.getString(1));
                        
                }   
                resul.close();
                AñadirColonias();
            } catch (SQLException ex) {
                Logger.getLogger(ModificarProveedorController.class.getName()).log(Level.SEVERE, null, ex);
           }
            cbEstado.getItems().addAll("Activo","Terminado");
            
    }    

    @FXML
    private void rbNombreClick(ActionEvent event) {
        Limpiar();
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

    @FXML
    private void rbIdClick(ActionEvent event) {
       
         Limpiar();
        txtBuscarProv.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[0-9]*")){
                txtBuscarProv.setText(newValue);
            }
            else
            {
                txtBuscarProv.setText(oldValue);
            }
            }
        });
    }


    @FXML
    private void txtIdProvClick(ActionEvent event) {
    }

    @FXML
    private void txtNombreProvClick(ActionEvent event) {
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void txtGuardarClick(ActionEvent event) {
    }

   public void AñadirColonias(){
        if(cbCiudadProveedor.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Colonia from CodigosPostales where Municipio='"+cbCiudadProveedor.getValue() +"'");
            String [] Colon=null;
            try {
                   cbColonia.getItems().clear();
                while(resul.next()){
                    String temp=resul.getString(1);
                    Colon=separarColonias(temp);
                   
                    //cbColonia.getItems().add(resul.getString(1));
                    
                for (int i = 0; i <Colon.length; i++) {
                    cbColonia.getItems().add(Colon[i]);
                }
                }
                
                resul.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ModificarProveedorController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
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
   
   
   public ListView<?> getLstContenedorConsulta() {
        
        return lstContenedorDatos;
        
    }
    public void setList(ObservableList listt){
        list=listt;
    }
    public static ObservableList getData() {
        return data;
    }
private void Limpiar() {
            
        txtIdProv.setText("");
        txtBuscarProv.setText("");
        txtCalle.setText("");
        cbCiudadProveedor.setValue(null);
        cbColonia.setValue(null);
        
        cbEstado.setValue(null);
        cbCodigoPostal.setValue(null);
        txtTelefonoProv.setText("");
}

    @FXML
    private void eventBuscarProveedor(KeyEvent event) {
         ModelProveedores prov=new ModelProveedores();
         gridContenedorCampos.setVisible(false);
         if(rbNombreProv.isSelected())
         {
            if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                
                if(prov.ConsultarNombre(1,lstContenedorDatos,data,txtBuscarProv.getText())){
                   
                lstContenedorDatos.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    
                lstContenedorDatos.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                //   ModelUsuarios nodo=(ModelUsuarios) list.get(valor);
                                  ModelProveedores nodo=(ModelProveedores)  list.get(valor);
                                    vaciarDatosTxt(nodo);
                                    gridContenedorCampos.setVisible(true);
                                    lstContenedorDatos.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorDatos.setVisible(false);
                    gridContenedorCampos.setVisible(false);
                } 
                
               
            }
        }
         else if(rbIdProv.isSelected()){
             if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                
                if(prov.ConsultarID(1,lstContenedorDatos,data,Integer.parseInt(txtBuscarProv.getText()) )){
                   
                lstContenedorDatos.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    
                lstContenedorDatos.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProveedores nodo=(ModelProveedores) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorCampos.setVisible(true);
                                    lstContenedorDatos.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorDatos.setVisible(false);
                    gridContenedorCampos.setVisible(false);
                } 
                
               
            }
         }
        
    }
 private void vaciarDatosTxt(ModelProveedores usu) {
       
               
                  //  txtCiudadUsu.setText(usu.getCiudUsu());
                    cbCiudadProveedor.setValue(usu.getCiudadProv());
                    //txtColoniaUsu.setText(usu.getColoUsu());
                    cbColonia.setValue(usu.getColonia());
                    //txtContratoUsu.setText(usu.getEstadoContrato());
                    cbEstado.setValue(String.valueOf(usu.getContrato()));
                    //txtCpUsu.setText(usu.getCodigoPostal());
                    cbCodigoPostal.setValue(usu.getCodigoProv());
                    //txtPermisoUsu.setText(String.valueOf(usu.getTipoPermiso()));
                   
                    
                    txtCalle.setText(usu.getCalleProv());
                   
                    txtTelefonoProv.setText(usu.getTelefonoProv());
                    txtEmailProv.setText(usu.getEmailProv());
    }
}
