/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Productos;

import com.mysql.jdbc.ResultSet;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author 
 */
public class AgregarProductosController implements Initializable {
    @FXML
    private TextField txtNombreProd;
    @FXML
    private TextArea txtDescProd;
    @FXML
    private TextField txtCantProd;

    @FXML
    private TextField txtPrecioProd;
    
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    @FXML
    private ComboBox<String> cboxUnidadProd;
    @FXML
    private ComboBox<String> cboxNombreProv;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Models.CRUD cr= new Models.CRUD();
          ResultSet resul=null;  
            resul=(ResultSet) cr.Consulta("Select idProv,nombreProv from proveedor");
            
            try {
                  
                while(resul.next()){
                        cboxNombreProv.getItems().add(resul.getString(2));
                }   
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarProductosController.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
            cboxUnidadProd.getItems().addAll("KG","LITRO","LATA","CARTON","GRAMO","PIEZAS");
        
        txtNombreProd.textProperty().addListener(new ChangeListener<String>(){
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.matches("[A-Aa-z]*\\s*[A-Za-z]*")){
                txtNombreProd.setText(newValue);
            }
            else
            {
                txtNombreProd.setText(oldValue);
            }
            }
        });
         
         
        txtPrecioProd.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
           if(newValue.matches("[0-9]*")){
                txtPrecioProd.setText(newValue);
            }
            else
            {
                txtPrecioProd.setText(oldValue);
            }
            }
        });
        
        txtCantProd.textProperty().addListener(new ChangeListener<String>(){

             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches("[0-9]*")){
                    txtCantProd.setText(newValue);
                }else{
                    txtCantProd.setText(oldValue);
                }
             }
            
        });
    }    


    @FXML
    private void btnCancelarClick(ActionEvent event) {
        
    }

    @FXML
    private void btnAceptarClick(ActionEvent event) {
   
        Models.ModelProductos productos=new Models.ModelProductos();
        String mensageE="Campos: ";
          if(txtNombreProd.getText().equals("")){
              mensageE+="Nombre";
              
          }
          if(txtCantProd.getText().equals("")){
              mensageE+=", Cantidad";
          }
          if(txtDescProd.getText().equals("")){
              mensageE+=", Descripcion";
          }
          if(txtPrecioProd.getText().equals("")){
              mensageE+=", Precios";
          }
         
          if(cboxNombreProv.getValue()==null){
              mensageE+=", proveedor";
          }
          if(cboxUnidadProd.getValue()==null){
              mensageE+=", Unidad";
          }
          mensageE+=" vacios";
          lblError.setText(mensageE);
           if(   !txtNombreProd.getText().equals("")
           && !txtCantProd.getText().equals("")
           && !txtDescProd.getText().equals("")
           
           && !txtPrecioProd.getText().equals("")
           && cboxUnidadProd.getValue()!=null
          )
        {
        productos.setNombreProd(txtNombreProd.getText());
          //  System.out.println(txtCantProd.getText());
        productos.setDescripcionProd(txtDescProd.getText());
        productos.setPrecioUnitario(Integer.parseInt(txtPrecioProd.getText()));
        productos.setUnidadMedida(cboxUnidadProd.getValue());
        productos.setCantidadProd(Integer.parseInt(txtCantProd.getText()));
        int idProv=1;
         Models.CRUD cr=new Models.CRUD();
            ResultSet rs=null;
            
            String query="Select * from proveedor where nombreProv='"+cboxNombreProv.getValue()+"'";
            
            rs=(ResultSet) cr.Consulta(query);
            try {
               
                
                 if(rs.next()){
                        idProv=Integer.parseInt(rs.getString(1));
                        productos.setIdProv(idProv);
                }
                
                
            } catch (SQLException ex) {
             
                Logger.getLogger(AgregarProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
       productos.agregarProducto();
    }
    }

    
}
