/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuarios;


import static Controllers.Usuarios.AgregarUsuariosController.separarColonias;
import Models.ModelUsuarios;
import com.mysql.jdbc.ResultSet;
import java.net.URL;
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
 * @author lalo
 */
public class ModificarUsuarios2 implements Initializable {
    @FXML
    private RadioButton rbNombUsu;
    @FXML
    private ToggleGroup GrupoConsultar;
    @FXML
    private RadioButton rbIdUsu;
    @FXML
    private TextField txtBuscarUsu;
    @FXML
    private ListView<String> lstContenedorConsulta;
    @FXML
    private GridPane gridContenedorDatos;
    @FXML
    private TextField txtNomUsu;
    @FXML
    private TextField txtContraseñaUsu;
    @FXML
    private TextField txtCalleUsu;
   
    @FXML
    private TextField txtTelefonoUsu;
    @FXML
    private TextField txtSueldoUsu;
    @FXML
    private TextField txtPuntosUsu;
    
    @FXML
    private TextField txtIdUsu;
    @FXML
    private Button btnCancelarModificar;
    @FXML
    private Button btnModificarUsuario;

    
    public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    @FXML
    private ComboBox<String> cbCodigoPostalUsu;
    @FXML
    private ComboBox<String> cbCiudadUsu;
    @FXML
    private ComboBox<String> cbColoniaUsu;
    @FXML
    private ComboBox<Integer> cbPermisoUsu;
    @FXML
    private Label lblError;
    @FXML
    private ComboBox<String> cbContratoUsu;
    
    
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
        Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select CodigoPostal from CodigosPostales where Estado='Jalisco'");
            
            try {
                  
                while(resul.next()){
                        cbCodigoPostalUsu.getItems().add(resul.getString(1));
                        
                }   
                resul.close();
                 AñadirColonias();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            cbPermisoUsu.getItems().addAll(1,2,3);
            cbContratoUsu.getItems().addAll("Activo","Terminado");
        txtNomUsu.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[A-Za-z]*(\\s?[A-Za-z]*)*")){
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
           if(newValue.matches(".*")){
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
                if(newValue.matches("([A-Aa-z0-9]*\\s?)*#?[A-Za-z0-9]*-?[A-Za-z]*")){
                    
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
                
                if(usu.ConsultarNombre(1,lstContenedorConsulta,data,txtBuscarUsu.getText())){
                   
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
                
                if(usu.ConsultarID(1,lstContenedorConsulta,data,Integer.parseInt(txtBuscarUsu.getText()) )){
                   
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

    @FXML
    private void btnCancelarModificar(ActionEvent event) {
    }

    @FXML
    private void btnModificarUsuario(ActionEvent event) {
         Models.ModelUsuarios usuarios=new Models.ModelUsuarios();
        String mensageE="Campos: ";
          if(txtNomUsu.getText().equals("")){
              mensageE+=" Nombre";
          }
          if(txtContraseñaUsu.getText().equals("")){
              mensageE+=" Contraseña";
          }
          if(txtCalleUsu.getText().equals("")){
              mensageE+=" Calle";
          }
          if(cbColoniaUsu.getValue()==null){
              mensageE+=" Colonia";
          }
         if(cbCiudadUsu.getValue()==null){
              mensageE+=", Ciudad";
          }
         if(cbCodigoPostalUsu.getValue()==null){
              mensageE+=" C.P.";
          }
         if(txtTelefonoUsu.getText().equals("")){
              mensageE+=" Telefono";
          }
         if(txtSueldoUsu.getText().equals("")){
              mensageE+=" Sueldo";
          }
         if(txtPuntosUsu.getText().equals("")){
              mensageE+=" Puntuación";
          }
         if(cbPermisoUsu.getValue()==null){
              mensageE+=" Permiso";
          }
         
          mensageE+=" vacios";
          lblError.setText(mensageE);
           if(   !txtNomUsu.getText().equals("")
           && !txtContraseñaUsu.getText().equals("")
           && !txtCalleUsu.getText().equals("")
           && cbColoniaUsu.getValue()!=null
           && cbCiudadUsu.getValue()!=null
           && cbCodigoPostalUsu.getValue()!=null
           && !txtTelefonoUsu.getText().equals("")
           && !txtSueldoUsu.getText().equals("")
           && !txtPuntosUsu.getText().equals("") 
           && cbPermisoUsu.getValue()!=null
           && cbContratoUsu.getValue()!=null
          )
        {
        usuarios.setIdUsu(Integer.parseInt(txtIdUsu.getText()));
        usuarios.setNombreUsu(txtNomUsu.getText());
        usuarios.setContraseñaUsu(txtContraseñaUsu.getText());
        usuarios.setCalleUsu(txtCalleUsu.getText());
        usuarios.setColoUsu( cbColoniaUsu.getValue());
        usuarios.setCiudUsu(cbCiudadUsu.getValue());
        usuarios.setCodigoPostal(cbCodigoPostalUsu.getValue());
        usuarios.setTelefonoUsu(txtTelefonoUsu.getText());
        usuarios.setSueldoUsu(Integer.parseInt(txtSueldoUsu.getText()));
        usuarios.setPuntosUsu(Integer.parseInt(txtPuntosUsu.getText()));
        usuarios.setTipoPermiso(cbPermisoUsu.getValue());
        usuarios.setEstadoContrato(cbContratoUsu.getValue());
           // System.out.println("que tiene codigo postal  "+cbCodigoPostal.getValue());
            
           /// usuarios.agregarUsuarios();
                usuarios.modificarUsuario();
            lblError.setText("Agregado Correcto");
            txtNomUsu.setText("");
            txtContraseñaUsu.setText("");
            txtCalleUsu.setText("");
            cbColoniaUsu.setValue("");
            cbCiudadUsu.setValue("");
            cbCodigoPostalUsu.setValue("");
            txtTelefonoUsu.setText("");
            txtSueldoUsu.setText("");
            txtPuntosUsu.setText("");
            cbPermisoUsu.setValue(0);
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
     private void vaciarDatosTxt(ModelUsuarios usu) {
       
               
                  //  txtCiudadUsu.setText(usu.getCiudUsu());
                    cbCiudadUsu.setValue(usu.getCiudUsu());
                    //txtColoniaUsu.setText(usu.getColoUsu());
                    cbColoniaUsu.setValue(usu.getColoUsu());
                    //txtContratoUsu.setText(usu.getEstadoContrato());
                    cbContratoUsu.setValue(usu.getEstadoContrato());
                    //txtCpUsu.setText(usu.getCodigoPostal());
                    cbCodigoPostalUsu.setValue(usu.getCodigoPostal());
                    //txtPermisoUsu.setText(String.valueOf(usu.getTipoPermiso()));
                    cbPermisoUsu.setValue(usu.getTipoPermiso());
                    
                    txtCalleUsu.setText(usu.getCalleUsu());
                    txtContraseñaUsu.setText(usu.getContraseñaUsu());
                    txtIdUsu.setText(String.valueOf(usu.getIdUsu()));
                    txtNomUsu.setText(usu.getNombreUsu());
                    txtPuntosUsu.setText(String.valueOf(usu.getPuntosUsu()));
                    txtSueldoUsu.setText(String.valueOf(usu.getSueldoUsu()));
                    txtTelefonoUsu.setText(usu.getTelefonoUsu());
    }
     
     public void AñadirColonias(){
        if(cbCiudadUsu.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Colonia from CodigosPostales where Municipio='"+cbCiudadUsu.getValue() +"'");
            String [] Colon=null;
            try {
                   cbColoniaUsu.getItems().clear();
                while(resul.next()){
                    String temp=resul.getString(1);
                    Colon=separarColonias(temp);
                   
                    //cbColonia.getItems().add(resul.getString(1));
                    
                for (int i = 0; i <Colon.length; i++) {
                    cbColoniaUsu.getItems().add(Colon[i]);
                }
                }
                
                resul.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
    }

    @FXML
    private void eventCodigoPostal(ActionEvent event) {
        
         if(cbCodigoPostalUsu.getValue()!=null){
            Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select Municipio from CodigosPostales where CodigoPostal='"+cbCodigoPostalUsu.getValue() +"'");
            cbCiudadUsu.getItems().clear();
            try {
                  
                while(resul.next()){
                      cbCiudadUsu.getItems().add(resul.getString(1));
                        cbCiudadUsu.setValue(resul.getString(1));
                }
                resul.close();
               AñadirColonias();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
    }
    
    private void Limpiar() {
            
        txtIdUsu.setText("");
        txtBuscarUsu.setText("");
        txtCalleUsu.setText("");
        cbCiudadUsu.setValue(null);
        cbColoniaUsu.setValue(null);
        txtContraseñaUsu.setText("");
        cbContratoUsu.setValue(null);
        cbCodigoPostalUsu.setValue(null);
        txtIdUsu.setText("");
        txtNomUsu.setText("");
        cbPermisoUsu.setValue(null);
        txtPuntosUsu.setText("");
        txtSueldoUsu.setText("");
        txtTelefonoUsu.setText("");
}
}
