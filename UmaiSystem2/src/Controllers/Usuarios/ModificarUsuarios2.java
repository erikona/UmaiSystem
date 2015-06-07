/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuarios;

import static Controllers.Usuarios.AgregarUsuariosController.separarColonias;
import Models.ModelUsuarios;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private boolean banCon=false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        txtBuscarUsu.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[^'\"]*")){
                    txtBuscarUsu.setText(newValue);
                }
                else{
                    txtBuscarUsu.setText(oldValue);
                }
            }
        });
        
        ArrayList<String> datosCod = new ArrayList<String>();
        Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
        datosCod=mc.getcodigosPostales();
        for(int i = 0; i <datosCod.size(); i++){
            cbCodigoPostalUsu.getItems().add(datosCod.get(i));
        }
        cbPermisoUsu.getItems().addAll(1,2,3);
        cbContratoUsu.getItems().addAll("Activo","Terminado");
        
        txtNomUsu.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches("[A-Za-z]*(\\s?[A-Za-z]*)*")){
                    txtNomUsu.setText(newValue);
                }
                else{
                    txtNomUsu.setText(oldValue);
                }
            }
        });
        
        txtContraseñaUsu.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches(".*")){
                    txtContraseñaUsu.setText(newValue);
                }
                else{
                    txtContraseñaUsu.setText(oldValue);
                }
            }
        });
        
        txtCalleUsu.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches("([A-Aa-z0-9]*\\s?)*#?[A-Za-z0-9]*-?[A-Za-z]*")){
                    txtCalleUsu.setText(newValue);
                }
                else{
                    txtCalleUsu.setText(oldValue);
                }
            } 
        });
        
        txtTelefonoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches("[0-9]*")){
                    txtTelefonoUsu.setText(newValue);
                }
                else{
                    txtTelefonoUsu.setText(oldValue);
                }
             }
        });
        
        txtSueldoUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches("[0-9]*")){
                    txtSueldoUsu.setText(newValue);
                }
                else{
                    txtSueldoUsu.setText(oldValue);
                }
            }
        });
        
        txtPuntosUsu.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(newValue.matches("[0-9]*")){
                    txtPuntosUsu.setText(newValue);
                }
                else{
                    txtPuntosUsu.setText(oldValue);
                }
            }
        });
    }    

    @FXML
    private void rbNombUsuClick(ActionEvent event){
        Limpiar();
    }

    @FXML
    private void rbIdUsuClick(ActionEvent event){
        Limpiar();
    }
    
    @FXML
    private void eventBuscarConsultar(KeyEvent event){
        Models.ModelUsuarios usu=new Models.ModelUsuarios();
        gridContenedorDatos.setVisible(false);
        if(rbNombUsu.isSelected()){
            if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                    if(usu.ConsultarNombre(1,lstContenedorConsulta,data,txtBuscarUsu.getText())){
                        lstContenedorConsulta.setVisible(true); 
                        lblError.setText("");
                        lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
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
        else if(rbIdUsu.isSelected()){
            if(!txtBuscarUsu.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                    if(usu.ConsultarID(1,lstContenedorConsulta,data,Integer.parseInt(txtBuscarUsu.getText()))){
                        lstContenedorConsulta.setVisible(true);  
                        lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
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
    }

    @FXML
    private void btnCancelarModificar(ActionEvent event){
        
    }

    @FXML
    private void btnModificarUsuario(ActionEvent event){
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
        if(!txtNomUsu.getText().equals("")
           && !txtContraseñaUsu.getText().equals("")
           && !txtCalleUsu.getText().equals("")
           && cbColoniaUsu.getValue()!=null
           && cbCiudadUsu.getValue()!=null
           && cbCodigoPostalUsu.getValue()!=null
           && !txtTelefonoUsu.getText().equals("")
           && !txtSueldoUsu.getText().equals("")
           && !txtPuntosUsu.getText().equals("") 
           && cbPermisoUsu.getValue()!=null
           && cbContratoUsu.getValue()!=null){
        
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
            usuarios.modificarUsuario();
        
            lblError.setText("Agregado correcto");
            txtNomUsu.setText("");
            txtContraseñaUsu.setText("");
            txtCalleUsu.setText("");
            cbColoniaUsu.setValue("");
            cbCiudadUsu.setValue(null);
            cbCodigoPostalUsu.setValue(null);
            txtTelefonoUsu.setText("");
            txtSueldoUsu.setText("");
            txtPuntosUsu.setText("");
            cbPermisoUsu.setValue(0);
        }
    }
    
    public ListView<?> getLstContenedorConsulta(){
        return lstContenedorConsulta;
    }
    
    public void setList(ObservableList listt){
        list=listt;
    }
    
    public static ObservableList getData(){
        return data;
    }
    
    private void vaciarDatosTxt(ModelUsuarios usu){
        cbCiudadUsu.setValue(usu.getCiudUsu());
        cbColoniaUsu.setValue(usu.getColoUsu());
        cbContratoUsu.setValue(usu.getEstadoContrato());
        cbCodigoPostalUsu.setValue(usu.getCodigoPostal());
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
            Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos.clear();
            datos=mc.getColonias(cbCiudadUsu.getValue());
            cbColoniaUsu.getItems().clear();
            String [] Colon=null;
            Colon=separarColonias(datos.get(0));
            cbColoniaUsu.setValue(Colon[0]);
            for (int i = 0; i <datos.size(); i++){
                String temp=datos.get(i);
                Colon=separarColonias(temp);
                for (int j = 0; j <Colon.length; j++){
                    cbColoniaUsu.getItems().add(Colon[j]);
                }
            }
        }
    }

    @FXML
    private void eventCodigoPostal(ActionEvent event){
        if(cbCodigoPostalUsu.getValue()!=null){
            Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos=mc.getMunicipios(cbCodigoPostalUsu.getValue());
            cbCiudadUsu.getItems().clear();
            cbCiudadUsu.setValue(datos.get(0));
            for (int i = 0; i <datos.size(); i++) {
                cbCiudadUsu.getItems().add(datos.get(i));
            }
            AñadirColonias();
        }
    }
    
    private void Limpiar(){
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

    @FXML
    private void eventValidarBusqueda(KeyEvent event){
        String c=event.getCharacter();
        if(rbIdUsu.isSelected()){
            if(!Character.isDigit(c.charAt(0))){ 
                event.consume(); 
                lblError.setText("Ingresa solo números"); 
                lblError.setVisible(true);
                setBanCon(true);
            }
            else{
                lblError.setVisible(false); lblError.setText("");setBanCon(false); 
            } 
        }
        else if(rbNombUsu.isSelected()){
            if(!Character.isLetter(c.charAt(0))){ 
                event.consume(); 
                lblError.setText("Ingresa Solo letras"); 
                lblError.setVisible(true);
                setBanCon(true);
            }
            else{
                lblError.setVisible(false); 
                 lblError.setText(""); setBanCon(false);
            }
        }
    }

    /**
     * @return the banCon
     */
    public boolean isBanCon(){
        return banCon;
    }

    /**
     * @param banCon the banCon to set
     */
    public void setBanCon(boolean banCon){
        this.banCon = banCon;
    }
}