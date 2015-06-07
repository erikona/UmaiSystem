/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private TextField txtCalleProv;
    @FXML
    private ComboBox<String> cboxColoniaProv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ArrayList<String> datosCod = new ArrayList<String>();
       // Models.ModelUsuarios msu=new ModelUsuarios();
      Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
        datosCod=mc.getcodigosPostales();
        for (int i = 0; i <datosCod.size(); i++) {
              cboxCodigoProveedor.getItems().add(datosCod.get(i));
        }
        /*
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
         */
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
        if(cboxColoniaProv.getValue()==null){
            mensageE+=", Colonia";
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
           && cboxColoniaProv.getValue()!=null
           && !txtCalleProv.getText().equals("")){
            
            proveedores.setNombreProv(txtNombreProv.getText());
            proveedores.setTelefonoProv(txtTelefonoProv.getText());
            proveedores.setEmailProv(txtEmailProv.getText());
            proveedores.setCodigoProv(cboxCodigoProveedor.getValue());
            proveedores.setCiudadProv(cboxCiudadProv.getValue());
            proveedores.setColoniaProv(cboxColoniaProv.getValue());
            proveedores.setCalleProv(txtCalleProv.getText());
            
            proveedores.agregarProveedor();
            lblError.setText("Agregado bien chido");
            txtNombreProv.setText("");
            txtTelefonoProv.setText("");
            txtEmailProv.setText("");
            cboxCodigoProveedor.setValue("");
            cboxCiudadProv.setValue("");
            cboxColoniaProv.setValue("");
            txtCalleProv.setText("");
            
        }
    }
    
    @FXML
    private void eventCodigoProveedor(ActionEvent event) {
         if(cboxCodigoProveedor.getValue()!=null){
           Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos=mc.getMunicipios(cboxCodigoProveedor.getValue());
             cboxCiudadProv.getItems().clear();
             cboxCiudadProv.setValue(datos.get(0));
            for (int i = 0; i <datos.size(); i++) {
                  cboxCiudadProv.getItems().add(datos.get(i));
                        
            }
             AñadirColonias();
         }
    }
    
    @FXML
    private void eventCiudadProv(ActionEvent event){
        
    }

    @FXML
    private void eventColoniaProveedor(ActionEvent event) {
        
    }
    
    public void AñadirColonias(){
        if(cboxCiudadProv.getValue()!=null){
            Models.ConsultaCodigosPostales mc=new Models.ConsultaCodigosPostales();
            ArrayList<String> datos=new ArrayList<>();
            datos.clear();
            datos=mc.getColonias(cboxCiudadProv.getValue());
             cboxColoniaProv.getItems().clear();
                //cbColonia.setValue(datos.get(0));
                  String [] Colon=null;
                  Colon=separarColonias(datos.get(0));
                  cboxColoniaProv.setValue(Colon[0]);
            for (int i = 0; i <datos.size(); i++) {
                 String temp=datos.get(i);
                    Colon=separarColonias(temp);
                     for (int j = 0; j <Colon.length; j++) {
                    cboxColoniaProv.getItems().add(Colon[j]);
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
}
