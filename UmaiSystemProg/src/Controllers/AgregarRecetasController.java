
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 
 */
public class AgregarRecetasController implements Initializable {
    @FXML
    private TextField txtIdReceta;
    @FXML
    private TextField txtPorcentajeReceta;
    @FXML
    private TextField txtNombreReceta;
    @FXML
    private TextField txtMargenReceta;
    @FXML
    private TextField txtTipoReceta;
    @FXML
    private TextField txtDificultadReceta;
    @FXML
    private TextField txtTamanoReceta;
    @FXML
    private TextField txtTiempoReceta;
    @FXML
    private Button btnAceptarReceta;
    @FXML
    private TextField txtPorcionReceta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private  void btnAceptarRecetaClick(ActionEvent event) 
    {
        
        if( !txtNombreReceta.getText().equals("") &&  !txtTamanoReceta.getText().equals("") &&  !txtDificultadReceta.getText().equals("")
           &&  !txtMargenReceta.getText().equals("") &&  !txtPorcentajeReceta.getText().equals("") &&  !txtPorcionReceta.getText().equals("") &&  !txtTiempoReceta.getText().equals("")
           &&  !txtTipoReceta.getText().equals(""))
        {
          
            BaseDatos.Validaciones vl=new BaseDatos.Validaciones();
            
            
                if(vl.EsNombre(txtNombreReceta.getText()))
                {              
                    BaseDatos.CRUD cr=new BaseDatos.CRUD();
                    cr.insertar("insert into receta(nombreRec,tipoRec,tamañoPorcion,numeroPorcion,tiempoPreparacion,difucultad,margenError,porcientoPerdida)"
                            +"values('"+txtNombreReceta.getText()+"','"+ txtTipoReceta.getText() +"','"+txtTamanoReceta.getText() +"','"
                            +txtPorcionReceta.getText()+ "','"+txtTiempoReceta.getText()+"','"+txtDificultadReceta.getText()+"','"+txtMargenReceta.getText()+"','"
                            +txtPorcentajeReceta.getText()+"')");
                    txtNombreReceta.setText("");
                    txtTamanoReceta.setText(""); txtDificultadReceta.setText("");
                    txtMargenReceta.setText("");txtPorcentajeReceta.setText("");txtPorcionReceta.setText("");
                    txtTiempoReceta.setText("");
                    txtTipoReceta.setText("");
                }
            
        }
    }
    
    
}
