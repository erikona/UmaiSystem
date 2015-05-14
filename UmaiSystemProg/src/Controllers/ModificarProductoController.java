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
 * @author erika
 */

public class ModificarProductoController implements Initializable {
    @FXML
    private Label lblModificarProd;
    @FXML
    private TextField txtBuscar;
    @FXML
    private GridPane gridContenedor;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDesc;
    @FXML
    private TextField txtIdProv;
    @FXML
    private TextField txtUniMed;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtCant;
    @FXML
    private TextField txtPrecioUni;
    @FXML
    private Label lblMensajeProd;

    /**
     * Initializes the controller class.
     */
    private void BuscarProducto(KeyEvent event) {
        BaseDatos.CRUD cr=new BaseDatos.CRUD();
       ResultSet rs=cr.Consulta("select * from Productos where nombreProd='"+txtBuscar.getText()  +"'");
        try 
        {
            if(rs.next()){
               
                txtId.setText(rs.getString(1));
                txtNombre.setText(rs.getString(2));
                txtDesc.setText(rs.getString(3));
                txtPrecioUni.setText(rs.getString(4)); 
                txtCant.setText(rs.getString(5));
                txtUniMed.setText(rs.getString(6));
                txtIdProv.setText(rs.getString(7));
                
                gridContenedor.setVisible(true);
                
            }
            else{
               
                gridContenedor.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAceptarClick(ActionEvent event) {
        if(!txtNombre.getText().equals("")  
           &&     !txtDesc.getText().equals("") 
           &&    !txtPrecioUni.getText().equals("") &&  !txtCant.getText().equals("")
           &&  !txtUniMed.getText().equals("") && txtIdProv.getText()!=null)
        {
          
            BaseDatos.Validaciones vl=new BaseDatos.Validaciones();
                if(vl.EsNombre(txtNombre.getText()))
                {
                   
                    if(vl.EsTexto(txtDesc.getText()))
                    {
                    
                        if(vl.Esdigito(txtPrecioUni.getText()))
                        {
                            if(vl.EsNombre(txtCant.getText()))
                            {
                                if(vl.EsNombre(txtUniMed.getText()))
                                {
                                    if(vl.EsNombre(txtIdProv.getText()))
                                    {
                                        lblMensajeProd.setText("");
                                        BaseDatos.CRUD cr=new BaseDatos.CRUD();

                                        cr.Actualizar("update Productos set nombreProd= '"+ txtNombre.getText() +"',"
                                                + "descripcionProd= '"+txtDesc.getText()    +"',"
                                                + "precioUnitario= '"+txtPrecioUni.getText()+ "',"
                                                + "cantidadProd= '" +txtCant.getText() +  "',"
                                                + "unidadMedida= '"+txtUniMed.getText()+ "',"
                                                + "idProv='"+ txtIdProv.getText()+ "'");

                                        txtNombre.setText("");txtDesc.setText("");txtPrecioUni.setText("");
                                        txtCant.setText("");txtUniMed.setText(null); txtIdProv.setText("");
                                    }
                                }else{System.out.println("La unidad de medida no es valida");}
                            }else{ lblMensajeProd.setText("La cantidad ingresada no es valida");}
                        }else{lblMensajeProd.setText("El precio unitario no es valido");}
                    }else {lblMensajeProd.setText("La descripcion no es valida");}
                }else {lblMensajeProd.setText("El nombre del producto no es valido");}
            
        }
        else
        {
           
            lblMensajeProd.setText("Hay campos vacios");
            
        }
    }
    
}
