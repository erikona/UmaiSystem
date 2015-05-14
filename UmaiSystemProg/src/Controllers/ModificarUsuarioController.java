/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ModificarUsuarioController implements Initializable {
    @FXML
    private Label lblModificarUsu;
    @FXML
    private TextField txtBuscar;
    @FXML
    private GridPane gridContenedor;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContra;
    private TextField txtTelefono;
    @FXML
    private TextField txtSueldo;
    @FXML
    private Label lblBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtPuntu;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtCalle;
    @FXML
    private ComboBox<String> comboCodPostal;
    @FXML
    private ComboBox<String> comboColonia;
    @FXML
    private ComboBox<String> comboCiudad;
    @FXML
    private TextField txtEstadoCont;
    @FXML
    private ComboBox<String> comboPermiso;
    @FXML
    private Label lblMensajeUsuario;
    @FXML
    private TextField txtTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BuscarUsuarioMod(KeyEvent event) {
        BaseDatos.CRUD cr=new BaseDatos.CRUD();
       ResultSet rs=cr.Consulta("select * from usuarios where nombreUsu='"+txtBuscar.getText()  +"'");
        try 
        {
            if(rs.next()){
               
                txtId.setText(rs.getString(1));
                txtNombre.setText(rs.getString(2));
                txtContra.setText(rs.getString(3));
                txtCalle.setText(rs.getString(4));
               
                //comboColonia.getItems().add(rs.getString(5));
                comboColonia.setValue(rs.getString(5));
                //comboCiudad.getItems().add(rs.getString(6));
                comboCiudad.setValue(rs.getString(6));
                //comboCodPostal.getItems().add(rs.getString(7));
                comboCodPostal.setValue(rs.getString(7));
                
                txtTelefono.setText(rs.getString(8));
                txtSueldo.setText(rs.getString(10));
                txtPuntu.setText(rs.getString(11));
                //comboPermiso.getItems().add(rs.getString(12));
                comboPermiso.setValue(rs.getString(12));
                txtEstadoCont.setText(rs.getString(13));
                
                gridContenedor.setVisible(true);
                
            }
            else{
               
                gridContenedor.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) {
       if(!txtNombre.getText().equals("")  
           &&     !txtCalle.getText().equals("") 
            
           &&    !txtSueldo.getText().equals("") &&  !txtPuntu.getText().equals("")
           &&  !txtContra.getText().equals("") && comboCiudad.getValue()!=null && comboCodPostal.getValue()!=null
            && comboColonia.getValue()!=null && txtEstadoCont.getText()!=null && comboPermiso.getValue()!=null)
        {
          
            BaseDatos.Validaciones vl=new BaseDatos.Validaciones();
            
            
                if(vl.EsNombre(txtNombre.getText()))
                {
                   
                    if(vl.EsTelefono(txtTelefono.getText()))
                    {
                    
                        if(vl.Esdigito(txtSueldo.getText()))
                        {
                            if(vl.Esdigito(txtPuntu.getText()))
                            {
                                if(comboPermiso.getValue()!=null)
                                {
                                    
                                    lblMensajeUsuario.setText("");
                                    BaseDatos.CRUD cr=new BaseDatos.CRUD();
                    
                                    cr.Actualizar("update usuarios set nombreUsu= '"+ txtNombre.getText() +"',"
                                            + "contraseñaUsu= '"+txtContra.getText()    +"',"
                                            + "calleUsu= '"+txtCalle.getText()+ "',"
                                            + "coloUsu= '" +comboColonia.getValue() +  "',"
                                            + "ciudUsu= '"+comboCiudad.getValue()+ "',"
                                            + "codigoPostal='"+ comboCodPostal.getValue()  + "',"
                                            + "telefonoUsu= '"+  txtTelefono.getText()+ "',"
                                            + "sueldoUsu= "+Integer.parseInt(txtSueldo.getText())+    ","
                                            + "puntosUsu= "+ Integer.parseInt(txtPuntu.getText())+  ","
                                            + "tipoPermiso = "+ Integer.parseInt(comboPermiso.getValue())+ ","
                                            + "estadoContrato= '" +txtEstadoCont.getText()+ "'"
                                            + "where nombreUsu= '"+ txtBuscar.getText()+ "'");
                                    /*
                                    cr.insertar("update  into usuarios(nombreUsu,contraseñaUsu,calleUsu,coloUsu,ciudUsu,"
                                            + "codigoPostal,telefonoUsu,"
                                            + "sueldoUsu,puntosUsu,tipoPermiso,estadoContrato)"
                                    +"values('"
                                    +txtNombre.getText()+ "','" 
                                    +txtContra.getText()+"','"
                                    +txtCalle.getText()+"','"
                                    +comboColonia.getValue()+"','"
                                    +comboCiudad.getValue()+"','"
                                    +comboCodPostal.getValue()+"','"
                                  //  +txtDomUser.getText()+"','"
                                    +txtTel.getText()
                                    +"',"+Integer.parseInt(txtSueldo.getText())+","
                                    +Integer.parseInt(txtPuntu.getText())+","
                                    +Integer.parseInt(comboPermiso.getValue())
                                    +",'Activo'"
                                  //  +Integer.parseInt(txtPermUser.getText())
                                    +");");
                                        */
                            
                                    //+txtPorcentajeReceta.getText()+"')");
                                    txtNombre.setText("");txtCalle.setText("");comboCodPostal.setValue(null);
                                    comboColonia.setValue(null);comboCiudad.setValue(null); txtTelefono.setText("");
                                    comboPermiso.setValue(null);txtSueldo.setText("");txtPuntu.setText("");
                                    txtContra.setText("");
                                }else{System.out.println("El valor del tipo de permiso no es valido");}
                            }else{ lblMensajeUsuario.setText("el valor en puntuacion no es valido");}
                        }else{lblMensajeUsuario.setText("el valor  en sueldo no es valido");}
                    }else {lblMensajeUsuario.setText("el valor  en el campo telefono no es valido");}
                }
            
        }
        else
        {
           
            lblMensajeUsuario.setText("campos vacios");
            
        }
        
    }
    
}
