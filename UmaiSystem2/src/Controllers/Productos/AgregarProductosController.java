package Controllers.Productos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author 
 */
public class AgregarProductosController implements Initializable{
    @FXML
    private TextField txtNombreProd;
    @FXML
    private TextArea txtDescProd;
    @FXML
    private ComboBox<String> cboxUnidadProd;
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
    public void initialize(URL url, ResourceBundle rb){
        cboxUnidadProd.getItems().addAll("Kg","Gramos","Caja","Lata","Litro","mililitro","pieza");
        txtNombreProd.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("^[A-Za-z]*(\\s?[A-Za-z]*)*") && txtNombreProd.getText().length()<30){
                    txtNombreProd.setText(newValue);
                }
                else{
                    txtNombreProd.setText(oldValue);
                }
            }
        });
        
        txtDescProd.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches(".*") && txtDescProd.getText().length()<150){
                    txtDescProd.setText(newValue);
                }
                else{
                    txtDescProd.setText(oldValue);
                }
            }
        });
    }    

    @FXML
    private void btnCancelarClick(ActionEvent event){
        
    }
    
    private void Limpiar(){
        txtNombreProd.setText("");
        txtDescProd.setText("");
        cboxUnidadProd.setValue(null);
    }

    @FXML
    private void btnAceptarClick(ActionEvent event){
        if(txtNombreProd.getText()!=null && txtDescProd.getText()!=null && cboxUnidadProd.getValue()!=null){
            Models.ModelProductos prod=new Models.ModelProductos();
            prod.setNombreProd(txtNombreProd.getText());
            prod.setDescripcionProd(txtDescProd.getText());
            prod.setUnidadMedida(cboxUnidadProd.getValue());
            prod.agregarProducto();
            lblError.setText("Agregado correctamente");
            Limpiar();
        }
        else{
            String mensaje="Campos";
            if(txtNombreProd.getText()==null){
                mensaje+="nombre ";
            }
            if(txtDescProd.getText()==null){
                mensaje+=" descripción ";
            }
            if(cboxUnidadProd.getValue()==null){
                mensaje+=" unidad ";
            }
            mensaje+="vacios";
            lblError.setText(mensaje);
            lblError.setVisible(true);
        }
    }

    @FXML
    private void eventValidarNombre(KeyEvent event){
       
    }

    @FXML
    private void eventValidarDescr(KeyEvent event){
    
    }
}
