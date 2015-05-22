/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

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
 * @author lalo
 */
public class AgregarProveedorController implements Initializable {
    @FXML
    private TextField txtNombreProv;
    @FXML
    private TextField txtCiudadProv;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void txtNombreProvClick(ActionEvent event) {
    }

    @FXML
    private void txtCiudadProvClick(ActionEvent event) {
    }

    @FXML
    private void txtTelefonoProvClick(ActionEvent event) {
    }

    @FXML
    private void txtEmailProvClick(ActionEvent event) {
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) {
    }
    
}
