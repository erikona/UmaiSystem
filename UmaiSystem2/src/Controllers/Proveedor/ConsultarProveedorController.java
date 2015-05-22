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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ConsultarProveedorController implements Initializable {
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
    private void txtBuscarProdClick(ActionEvent event) {
    }

    @FXML
    private void txtIdProdClick(ActionEvent event) {
    }

    @FXML
    private void txtNombreProdClick(ActionEvent event) {
    }

    @FXML
    private void txtDescProdClick(MouseEvent event) {
    }

    @FXML
    private void txtCantProdClick(ActionEvent event) {
    }

    @FXML
    private void txtPrecioProdClick(ActionEvent event) {
    }
    
}
