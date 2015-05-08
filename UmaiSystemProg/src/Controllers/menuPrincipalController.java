package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author antoniocg
 */
public class menuPrincipalController implements Initializable  {
  @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblUmai"
    private Label lblUmai; // Value injected by FXMLLoader

    @FXML // fx:id="btnAtras"
    private Button btnAtras; // Value injected by FXMLLoader

    @FXML // fx:id="imgUmai"
    private ImageView imgUmai; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmFinanzas"
    private Button btnAdmFinanzas; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmVentas"
    private Button btnAdmVentas; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmInventarios"
    private Button btnAdmInventarios; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmPersonal"
    private Button btnAdmPersonal; // Value injected by FXMLLoader

    @FXML // fx:id="btnGame"
    private Button btnGame; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmRecetas"
    private Button btnAdmRecetas; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmProveedores"
    private Button btnAdmProveedores; // Value injected by FXMLLoader

    @FXML
    void btnAdmVentasCLick(ActionEvent event) {
        System.out.println("wiii");
    }

    @FXML
    void btnAdmFinanzasClick(ActionEvent event) {
        //MAndamos llamar a la vista
       
        
    }

    @FXML
    void btnAdmRecetasClick(ActionEvent event) {

    }

    @FXML
    void btnAdmPersonalClick(ActionEvent event) {

    }

    @FXML
    void btnGameClick(ActionEvent event) {

    }

    @FXML
    void btnAdmProveedoresClick(ActionEvent event) {

    }

    @FXML
    void btnAdmInventariosClick(ActionEvent event) {

    }

    @FXML
    void btnAtrasClick(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblUmai != null : "fx:id=\"lblUmai\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert imgUmai != null : "fx:id=\"imgUmai\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmFinanzas != null : "fx:id=\"btnAdmFinanzas\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmVentas != null : "fx:id=\"btnAdmVentas\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmInventarios != null : "fx:id=\"btnAdmInventarios\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmPersonal != null : "fx:id=\"btnAdmPersonal\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnGame != null : "fx:id=\"btnGame\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmRecetas != null : "fx:id=\"btnAdmRecetas\" was not injected: check your FXML file 'menuPrincipal.fxml'.";
        assert btnAdmProveedores != null : "fx:id=\"btnAdmProveedores\" was not injected: check your FXML file 'menuPrincipal.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       }

}