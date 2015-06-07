/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import Models.ModelProveedores;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
       ArrayList<String> datosCod = new ArrayList<String>();
       // Models.ModelUsuarios msu=new ModelUsuarios();
      Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
       
      datosCod=mc.getcodigosPostales();
      for (int i = 0; i <datosCod.size(); i++) {
          cbCodigoPostal.getItems().add(datosCod.get(i));
      }
      AñadirColonias();
      
            cbEstado.getItems().addAll("Activo","Terminado");
            
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
    private void txtIdProvClick(ActionEvent event) {
    }

    @FXML
    private void txtNombreProvClick(ActionEvent event) {
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }


   public void AñadirColonias(){
        if(cbCiudadProveedor.getValue()!=null){
            Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos.clear();
            datos=mc.getColonias(cbCiudadProveedor.getValue());
             cbColonia.getItems().clear();
                //cbColonia.setValue(datos.get(0));
                  String [] Colon=null;
                  Colon=separarColonias(datos.get(0));
                  cbColonia.setValue(Colon[0]);
            for (int i = 0; i <datos.size(); i++) {
                 String temp=datos.get(i);
                    Colon=separarColonias(temp);
                     for (int j = 0; j <Colon.length; j++) {
                    cbColonia.getItems().add(Colon[j]);
                }
                // cbColonia.getItems().add(datos.get(i));
                // System.out.println("colonia: "+datos.get(i));
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
        // lblError.setText("");
         if(rbNombreProv.isSelected())
         {
            if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prov.ConsultarNombre(1,lstContenedorDatos,data,txtBuscarProv.getText())){
                   
                lstContenedorDatos.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
               // lblError.setText("");
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
        }
         else if(rbIdProv.isSelected()){
             if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prov.ConsultarID(1,lstContenedorDatos,data,Integer.parseInt(txtBuscarProv.getText()) )){
                   
                lstContenedorDatos.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    //  lblError.setText("");
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
        
    }
    private void vaciarDatosTxt(ModelProveedores prov) {
       
                     txtIdProv.setText(String.valueOf(prov.getIdProv()));
                     txtNombreProv.setText(prov.getNombreProv());
                  //  txtCiudadUsu.setText(prov.getCiudUsu());
                    cbCiudadProveedor.setValue(prov.getCiudadProv());
                    //txtColoniaUsu.setText(prov.getColoUsu());
                    cbColonia.setValue(prov.getColoniaProv());
                    txtCalle.setText(prov.getCalleProv());
                    //txtContratoUsu.setText(prov.getEstadoContrato());
                    cbEstado.setValue(String.valueOf(prov.getContrato()));
                    //txtCpUsu.setText(prov.getCodigoPostal());
                    cbCodigoPostal.setValue(prov.getCodigoProv());
                    //txtPermisoUsu.setText(String.valueOf(prov.getTipoPermiso()));
                   
                    
                   
                   
                    txtTelefonoProv.setText(prov.getTelefonoProv());
                    txtEmailProv.setText(prov.getEmailProv());
    }

    @FXML
    private void eventcodigoPostal(ActionEvent event) {
        
         if(cbCodigoPostal.getValue()!=null){
           Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos=mc.getMunicipios(cbCodigoPostal.getValue());
             cbCiudadProveedor.getItems().clear();
             cbCiudadProveedor.setValue(datos.get(0));
            for (int i = 0; i <datos.size(); i++) {
                  cbCiudadProveedor.getItems().add(datos.get(i));
                        
            }
             AñadirColonias();
         }
    }

    @FXML
    private void eventCiudad(ActionEvent event) {
        
        
    }

    @FXML
    private void btnGuardarClick(ActionEvent event) {
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
        if(cbCodigoPostal.getValue()==null){
            mensageE+=", C.P.";
        }
        if(cbCiudadProveedor.getValue()==null){
            mensageE+=", Ciudad";
        }
        if(cbColonia.getValue()==null){
            mensageE+=", Colonia";
        }
        if(txtCalle.getText().equals("")){
            mensageE+=", Calle";
        }
        mensageE+=" vacío ";
        lblError.setText(mensageE);
        lblError.setVisible(true);
        if(!txtNombreProv.getText().equals("")
           && !txtTelefonoProv.getText().equals("")
           && !txtEmailProv.getText().equals("")
           && cbCodigoPostal.getValue()!=null
           && cbCiudadProveedor.getValue()!=null
           && cbColonia.getValue()!=null
           && !txtCalle.getText().equals("")){
            
            proveedores.setIdProv(Integer.parseInt(txtIdProv.getText()));
            proveedores.setNombreProv(txtNombreProv.getText());
            proveedores.setTelefonoProv(txtTelefonoProv.getText());
            proveedores.setEmailProv(txtEmailProv.getText());
            proveedores.setCodigoProv(cbCodigoPostal.getValue());
            proveedores.setCiudadProv(cbCiudadProveedor.getValue());
            proveedores.setColoniaProv(cbColonia.getValue());
            proveedores.setCalleProv(txtCalle.getText());
            proveedores.setContrato(cbEstado.getValue());
            //proveedores.agregarProveedor();
            proveedores.modificarProveedor();
            lblError.setText("Agregado bien chido");
            txtIdProv.setText("");
            txtNombreProv.setText("");
            txtTelefonoProv.setText("");
            txtEmailProv.setText("");
            cbCodigoPostal.setValue("");
            cbCiudadProveedor.setValue("");
            cbColonia.setValue("");
            txtCalle.setText("");
            cbEstado.setValue(null);
            txtBuscarProv.setText("");
        }
    }

    @FXML
    private void eventValidarBusqueda(KeyEvent event) {
         String c=event.getCharacter();
             
         if(rbIdProv.isSelected()){
            if(!Character.isDigit(c.charAt(0))) 
            { 
            //  getToolkit().beep(); 
               
              event.consume(); 
               
              lblError.setText("Ingresa Solo numeros"); 
               lblError.setVisible(true);
                setBanCon(true);
            }else{lblError.setVisible(false); lblError.setText(""); setBanCon(false); } 
         }
         else if(rbNombreProv.isSelected()){
               
                if(!Character.isLetter(c.charAt(0))) 
                { 
              //getToolkit().beep(); 
               
              event.consume(); 
               setBanCon(true);
              lblError.setText("Ingresa Solo letras"); 
              lblError.setVisible(true);
              } else {lblError.setVisible(false); 
                 lblError.setText(""); setBanCon(false); }
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
