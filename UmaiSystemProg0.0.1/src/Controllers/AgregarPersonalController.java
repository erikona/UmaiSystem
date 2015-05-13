/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class AgregarPersonalController implements Initializable {
    @FXML
    private TextField txtIdUser;
    @FXML
    private TextField txtNomUser;
    @FXML
    private TextField txtDomUer;
    @FXML
    private TextField txtTelUser;
    @FXML
    private TextField txtPermUser;
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
    private TextField txtContrUser;
    @FXML
    private Label lblTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
