/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Productos;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class AgregarComprasController implements Initializable {
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txttIdCompra;
    @FXML
    private TextField txtNombreProveedor;
    @FXML
    private ListView<?> lstNombreProveedor;
    @FXML
    private TextField txtCant;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private ListView<?> lstBuscarNombre;
    @FXML
    private TextField txtPrecioUnitario;
    @FXML
    private TextField txtTotal;
    @FXML
    private Button btnAgregarCompra;
    @FXML
    private TableView<?> tableCompras;

    private ListView<String> lstContenedorConsulta;
     
     private static final ObservableList data = 
         FXCollections.observableArrayList();
     
    public static  ObservableList<?> list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      txtNombreProveedor.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[^'\"]*")){
                txtNombreProveedor.setText(newValue);
            }
            else
            {
                txtNombreProveedor.setText(oldValue);
            }
            }
        });
      txtNombreProveedor.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[A-Za-zÑñ]*(\\s?[A-Za-z]*)*") && txtNombreProveedor.getText().length()<30){
                txtNombreProveedor.setText(newValue);
            }
            else
            {
                txtNombreProveedor.setText(oldValue);
            }
            }
        });
      txtCant.textProperty().addListener(new ChangeListener<String>() {

          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if(newValue.matches("[0-9]*") && txtCant.getText().length()<10){
                txtCant.setText(newValue);
            }
            else
            {
                txtCant.setText(oldValue);
            }
          }
      });
      txtNombreProducto.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[A-Za-zÑñ]*(\\s?[A-Za-z]*)*") && txtNombreProducto.getText().length()<30){
                txtNombreProducto.setText(newValue);
            }
            else
            {
                txtNombreProducto.setText(oldValue);
            }
            }
        });
      txtPrecioUnitario.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[0-9]*") && txtPrecioUnitario.getText().length()<10){
                txtPrecioUnitario.setText(newValue);
            }
            else
            {
                txtPrecioUnitario.setText(oldValue);
            }
            }
        });
      
      Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fechaActual=dia+"/"+(mes+1) +"/"+año;
        txtFecha.setText(fechaActual);
      
      
    }    

    @FXML
    private void eventNombreProveedor(KeyEvent event) {
        
        
    }

    @FXML
    private void eventNombreProducto(KeyEvent event) {
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
    
}
