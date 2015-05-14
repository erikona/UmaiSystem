/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author erika
 */
public class AgregarUsuariosController implements Initializable {
    @FXML
    private TextField txtNomUser;
    
    @FXML
    private TextField txtTelUser;
   
    @FXML
    private TextField txtSueldoUser;
    @FXML
    private TextField txtPuntUser;
    @FXML
    private ImageView imgAvatar;
    @FXML
    private Button btnBuscarUser;
    @FXML
    private Label lblBuscar;
    @FXML
    private Button btnAceptarU;
    @FXML
    private Button btnCancelarU;
    
    @FXML
    private Label lblTitulo;
    @FXML
     private Label lblMensajeAgregarUsuario;
    @FXML
    private ComboBox<String> cmbCodigoPostal;
    @FXML
    private ComboBox<String> cmbCiudad;
    @FXML
    private ComboBox<String> cmbColonia;
    @FXML
    private TextField txtCalle;
     @FXML
    private ComboBox<String> cmbPermiso;
     @FXML
     private PasswordField txtContraUser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbPermiso.getItems().addAll(
    "1",
    "2",
    "3"
    );
   
    cmbCodigoPostal.getItems().addAll
        ("49000");
    cmbColonia.getItems().addAll
        ("Centro","lomas");
   cmbCiudad.getItems().addAll
        ("guzmán","guadalajara");
    }  
    @FXML
     void btnAceptarUClick(ActionEvent event)
    {
        
        if( !txtNomUser.getText().equals("") &&  !txtCalle.getText().equals("") &&  !txtTelUser.getText().equals("")
           &&    !txtSueldoUser.getText().equals("") &&  !txtPuntUser.getText().equals("")
           &&  !txtContraUser.getText().equals("") && cmbCiudad.getValue()!=null && cmbCodigoPostal.getValue()!=null
            && cmbColonia.getValue()!=null)
        {
          
            BaseDatos.Validaciones vl=new BaseDatos.Validaciones();
            
            
                if(vl.EsNombre(txtNomUser.getText()))
                {
                    if(vl.EsTelefono(txtTelUser.getText()))
                    {
                    
                        if(vl.Esdigito(txtSueldoUser.getText()))
                        {
                            if(vl.Esdigito(txtPuntUser.getText()))
                            {
                                if(cmbPermiso.getValue()!=null)
                                {
                                    lblMensajeAgregarUsuario.setText("");
                                    BaseDatos.CRUD cr=new BaseDatos.CRUD();
                    
                                    cr.insertar("insert into usuarios(nombreUsu,contraseñaUsu,calleUsu,coloUsu,ciudUsu,"
                                            + "codigoPostal,telefonoUsu,"
                                            + "sueldoUsu,puntosUsu,tipoPermiso)"
                                    +"values('"
                                    +txtNomUser.getText()+ "','" 
                                    +txtContraUser.getText()+"','"
                                    +txtCalle.getText()+"','"
                                    +cmbColonia.getValue()+"','"
                                    +cmbCiudad.getValue()+"','"
                                    +cmbCodigoPostal.getValue()+"','"
                                  //  +txtDomUser.getText()+"','"
                                    +txtTelUser.getText()
                                    +"',"+Integer.parseInt(txtSueldoUser.getText())+","
                                    +Integer.parseInt(txtPuntUser.getText())+","
                                    +Integer.parseInt(cmbPermiso.getValue())
                                  //  +Integer.parseInt(txtPermUser.getText())
                                    +");");
                                        
                            
                                    //+txtPorcentajeReceta.getText()+"')");
                                    txtNomUser.setText("");txtCalle.setText("");cmbCodigoPostal.setValue(null);
                                    cmbColonia.setValue(null);cmbCiudad.setValue(null); txtTelUser.setText("");
                                    cmbPermiso.setValue(null);txtSueldoUser.setText("");txtPuntUser.setText("");
                                    txtContraUser.setText("");
                                }else{System.out.println("El valor del tipo de permiso no es valido");}
                            }else{ lblMensajeAgregarUsuario.setText("el valor en puntuacion no es valido");}
                        }else{lblMensajeAgregarUsuario.setText("el valor  en sueldo no es valido");}
                    }else {lblMensajeAgregarUsuario.setText("el valor  en el campo telefono no es valido");}
                }
            
        }
        else
        {
           
            lblMensajeAgregarUsuario.setText("campos vacios");
            
        }
       
    }

    
    
        
    
}
