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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author erika
 */
public class AgregarProductoController implements Initializable {
    
    @FXML
    private TextField txtNombreProd;
    @FXML
    private TextField txtIdProv;
    @FXML
    private TextField txtDescProd;
    @FXML
    private TextField txtPrecioUni;
    @FXML
    private TextField txtCantProd;
    @FXML
    private TextField txtUnidadMed;
    @FXML
    private Button btnAceptarProducto;
    @FXML
     private Label lblMensajeAgregarProducto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAceptarProductoClick(ActionEvent event) {
        if( !txtUnidadMed.getText().equals("") &&  !txtNombreProd.getText().equals("") &&  !txtIdProv.getText().equals("")
           &&    !txtDescProd.getText().equals("") &&  !txtPrecioUni.getText().equals("")
           &&  !txtCantProd.getText().equals(""))
        {
          
            BaseDatos.Validaciones vl=new BaseDatos.Validaciones();
            
            
                if(vl.EsNombre(txtNombreProd.getText()))
                {
                    if(vl.EsTexto(txtDescProd.getText()))
                    {
                    
                        if(vl.Esdigito(txtPrecioUni.getText()))
                        {
                            if(vl.Esdigito(txtCantProd.getText()))
                            {
                                if(vl.EsNombre(txtUnidadMed.getText()))
                                {
                                    BaseDatos.CRUD cr=new BaseDatos.CRUD();
                    
                                    cr.insertar("insert into Productos(nombreProd,descripcionProd,precioUnitario,cantidadProd,unidadMedida,"
                                    +"values('"
                                    +txtNombreProd.getText()+ "','" 
                                    +txtDescProd.getText()+"','"
                                    +txtPrecioUni.getText()+"','"
                                    +txtCantProd.getText()+"','"
                                    +txtUnidadMed.getText()+"','"
                                    +");");
                                        
                            
                                    //+txtPorcentajeReceta.getText()+"')");
                                    txtNombreProd.setText("");txtDescProd.setText(""); txtPrecioUni.setText("");
                                    txtCantProd.setText("");txtUnidadMed.setText("");
                                }else{System.out.println("El valor en la unidad de medida no es valido");}
                            }else{ lblMensajeAgregarProducto.setText("el valor en la cantidad del producto no es valido");}
                        }else{lblMensajeAgregarProducto.setText("el valor  el precio unitario no es valido");}
                    }else {lblMensajeAgregarProducto.setText("el valor  en el campo de la descripción no es valido");}
                }else {lblMensajeAgregarProducto.setText("el valor  en el campo del nombre del producto no es valido");}
            
        }
        else
        {
           
            lblMensajeAgregarProducto.setText("Hay campos vacios");
            
        }
    }
    
}
