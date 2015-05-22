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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ConsultarProductoController implements Initializable {
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
    private TextField txtPrecioProd;
    @FXML
    private ToggleGroup grupo1;
    @FXML
    private TextField txtUnidadMed;
    @FXML
    private TextField txtNombreProv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void rbNombProdClick(ActionEvent event) {
        //System.out.println("me clickeo en nombre :D");
        new Models.ModelProductos().consultarProductoNombre(txtBuscarProd.getText());
    }

    @FXML
    private void rbIdProdClick(ActionEvent event) {
        //System.out.println("me clickeo en id :D");
        new Models.ModelProductos().consultarProductoID(Integer.parseInt(txtBuscarProd.getText()));
    }


    @FXML
    private void txtDescProdClick(MouseEvent event) {
    }

    @FXML
    private void EventBuscar(KeyEvent event) {
        if(rbIdProd.isSelected()){
             new Models.ModelProductos().consultarProductoID(Integer.parseInt(txtBuscarProd.getText()));
        }
        else if(rbNombProd.isSelected()){
              new Models.ModelProductos().consultarProductoNombre(txtBuscarProd.getText());
        }
    }

    
}
