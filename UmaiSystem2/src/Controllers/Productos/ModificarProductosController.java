
package Controllers.Productos;


import Models.ModelProductos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 
 */
public class ModificarProductosController implements Initializable {
    @FXML
    private RadioButton rbIdProd;
    @FXML
    private TextField txtBuscarProd;
   
    @FXML
    private TextArea txtDescProd;
    
    
    @FXML
    private ComboBox<String> cbUnidadProd;

    public static final ObservableList names = 
         FXCollections.observableArrayList();
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    @FXML
    private ListView<?> lstContenedorConsulta;
    @FXML
    private TextField txtIdProd;
    @FXML
    private RadioButton rbNombProd;
    @FXML
    private ToggleGroup grupoConsultarProd;
    @FXML
    private GridPane gridContenedorDatos;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnModificarProd;
    @FXML
    private TextField txtPrueba;
  private boolean banCon=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cbUnidadProd.getItems().addAll("Kg","Gramos","Caja","Lata","Litro","mililitro","pieza");
        /*
         txtPrueba.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("^[A-Za-z]*(\\s?[A-Za-z]*)*") && txtPrueba.getText().length()<30){
                txtPrueba.setText(newValue);
            }
            else
            {
                txtPrueba.setText(oldValue);
            }
            }
        });
        */
        txtDescProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches(".*") && txtDescProd.getText().length()<150){
                txtDescProd.setText(newValue);
            }
            else
            {
                txtDescProd.setText(oldValue);
            }
            }
        });
        
        
        
        
        txtBuscarProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[^'\"]*")){
                txtBuscarProd.setText(newValue);
            }
            else
            {
                txtBuscarProd.setText(oldValue);
            }
            }
        });
    }    

    private void eventModifcarProd(KeyEvent event) {
        
         
    }
    

    public ListView<?> getLstContenedorConsulta() {
        
        return lstContenedorConsulta;
        
    }
    public void setList(ObservableList listt){
        list=listt;
    }
    public static ObservableList getData() {
        return data;
    }
    
    private void vaciarDatosTxt(ModelProductos prod) {
           
                   txtDescProd.setText(prod.getDescripcionProd());
                   txtIdProd.setText(String.valueOf(prod.getIdProd()));
                  
                   cbUnidadProd.setValue(prod.getUnidadMedida());
            txtPrueba.setText(prod.getNombreProd());
                   
    }               

    @FXML
    private void rbNombProdClick(ActionEvent event) {
        Limpiar();
       
    }

    @FXML
    private void rbIdProdClick(ActionEvent event) {
          Limpiar();
        
    }

    @FXML
    private void eventBuscarProd(KeyEvent event) {
          Models.ModelProductos prod=new Models.ModelProductos();
      //   lblMensaje.setText("");
        if(rbNombProd.isSelected())
         {
            if(!txtBuscarProd.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prod.ConsultarNombre(1,lstContenedorConsulta,data,txtBuscarProd.getText())){
                   
                lstContenedorConsulta.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                    //     lblMensaje.setText(""); 
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProductos nodo=(ModelProductos) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                    gridContenedorDatos.setVisible(true);
                                    
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                    gridContenedorDatos.setVisible(false);
                   
                } 
                }
               
            }
        }
         else if(rbIdProd.isSelected()){
             if(!txtBuscarProd.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prod.ConsultarID(1,lstContenedorConsulta,data,Integer.parseInt(txtBuscarProd.getText()) )){
                   
                lstContenedorConsulta.setVisible(true);  
                //gridContenedorDatos.setVisible(true);
                       //   lblMensaje.setText("");
                lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>() {
                             @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                    Number newValue) {
                               
                                int valor=(int) newValue;
                                    if(valor>=0){
                                   ModelProductos nodo=(ModelProductos) list.get(valor);
                                    
                                    vaciarDatosTxt(nodo);
                                 gridContenedorDatos.setVisible(true);
                                    
                                    
                                    lstContenedorConsulta.setVisible(false);
                                
                                }
                            }
                        });
                
                }
                else{
                    lstContenedorConsulta.setVisible(false);
                  gridContenedorDatos.setVisible(false);
                   
                }
               
            }
         }
        
    }
    }
    
 private void Limpiar() {
            
        txtIdProd.setText("");
        txtPrueba.setText("");
        txtBuscarProd.setText("");
        txtIdProd.setText("");
        txtDescProd.setText("");
        cbUnidadProd.setValue(null);
    }

    @FXML
    private void btnModificarProdClick(ActionEvent event) {
        
        if(txtPrueba.getText()!=null && txtDescProd.getText()!=null && cbUnidadProd.getValue()!=null){
                 Models.ModelProductos prod=new Models.ModelProductos();
                 prod.setNombreProd(txtPrueba.getText());
                 prod.setDescripcionProd(txtDescProd.getText());
                 prod.setUnidadMedida(cbUnidadProd.getValue());
                 prod.ModificarProducto(Integer.parseInt(txtIdProd.getText()));
                 lblMensaje.setText("modificado Correctamente!");
                 Limpiar();
        }
        else{
            String mensaje="Campos";
            if(txtPrueba.getText()==null){
              mensaje+="nombre ";
            }
            if(txtDescProd.getText()==null){
                mensaje+=" descripcion ";
            }
            if(cbUnidadProd.getValue()==null){
                mensaje+=" unidad ";
            }
            mensaje+="vacios";
            lblMensaje.setText(mensaje);
            lblMensaje.setVisible(true);
        }
        
        
        
        
        
        
        
        
        
        
         
    }

    @FXML
    private void eventValidarBusqueda(KeyEvent event) {
        
          String c=event.getCharacter();
             
         if(rbIdProd.isSelected()){
            if(!Character.isDigit(c.charAt(0))) 
            { 
            //  getToolkit().beep(); 
               
              event.consume(); 
               
              lblMensaje.setText("Ingresa Solo numeros"); 
               lblMensaje.setVisible(true);
                setBanCon(true);
            }else{lblMensaje.setVisible(false); lblMensaje.setText(""); setBanCon(false);} 
         }
         else if(rbNombProd.isSelected()){
               
                if(!Character.isLetter(c.charAt(0))) 
                { 
              //getToolkit().beep(); 
               
              event.consume(); 
                    setBanCon(true);
              lblMensaje.setText("Ingresa Solo letras"); 
              lblMensaje.setVisible(true);
              } else {lblMensaje.setVisible(false); 
                 lblMensaje.setText(""); 
                    setBanCon(false);}
          }
    }

    /**
     * @return the banCon
     */
    public boolean isBanCon() {
        return banCon;
    }

    /**
     * @param banCon the banCon to set
     */
    public void setBanCon(boolean banCon) {
        this.banCon = banCon;
    }

}
