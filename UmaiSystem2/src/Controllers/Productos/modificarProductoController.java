/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Productos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class modificarProductoController implements Initializable {
    @FXML
    private RadioButton rbNombProd;
    @FXML
    private RadioButton rbIdProd;
    @FXML
    private TextField txtBuscarProd;
    @FXML
    private TextField txtIdProd;
    @FXML
    private TextField txtNombreProd;
    @FXML
    private TextArea txtDescProd;
    @FXML
    private TextField txtCantProd;
    @FXML
    private ComboBox<?> cboxUnidadProd;
    @FXML
    private TextField txtPrecioProd;
    @FXML
    private ComboBox<?> cboxNombreProv;
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rbNombProdClick(ActionEvent event) {
    }

    @FXML
    private void rbIdProdClick(ActionEvent event) {
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) {
    }
    
}
