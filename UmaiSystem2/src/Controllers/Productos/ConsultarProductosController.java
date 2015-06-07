/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author 
 */
public class ConsultarProductosController implements Initializable{
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
    private ToggleGroup grupoConsultarProd;
    @FXML
    private TextField txtUnidadMedida;
    @FXML
    private ListView<String> lstContenedorConsulta;
     
     private static final ObservableList data = 
         FXCollections.observableArrayList();
    public static  ObservableList<?> list;
    private boolean banCon=false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
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

    @FXML
    private void rbNombProdClick(ActionEvent event){
        Limpiar(); 
    }

    @FXML
    private void rbIdProdClick(ActionEvent event){
        Limpiar();
    }

    private void txtBuscarProdClick(ActionEvent event){
         
    }
    
    public ListView<?> getLstContenedorConsulta(){
        return lstContenedorConsulta;
    }
    
    public void setList(ObservableList listt){
        list=listt;
    }
    
    public static ObservableList getData(){
        return data;
    }
    
    private void vaciarDatosTxt(ModelProductos prod){
        txtDescProd.setText(prod.getDescripcionProd());
        txtIdProd.setText(String.valueOf(prod.getIdProd()));
        txtNombreProd.setText(prod.getNombreProd());
        txtUnidadMedida.setText(prod.getUnidadMedida());
    }               

    @FXML
    private void txtBuscarProdClick(KeyEvent event){
        Models.ModelProductos prod=new Models.ModelProductos();
        if(rbNombProd.isSelected()){
            if(!txtBuscarProd.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                    if(prod.ConsultarNombre(0,lstContenedorConsulta,data,txtBuscarProd.getText())){  
                        lstContenedorConsulta.setVisible(true);  
                        lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
                                @Override
                                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                                    int valor=(int) newValue;
                                    if(valor>=0){
                                        ModelProductos nodo=(ModelProductos) list.get(valor);
                                        vaciarDatosTxt(nodo);
                                        txtDescProd.setVisible(true);
                                        txtIdProd.setVisible(true);
                                        txtNombreProd.setVisible(true);
                                        txtUnidadMedida.setVisible(true);
                                        lstContenedorConsulta.setVisible(false);
                                    }
                                }
                            });
                    }
                    else{
                        lstContenedorConsulta.setVisible(false);
                        txtDescProd.setVisible(false);
                        txtIdProd.setVisible(false);
                        txtNombreProd.setVisible(false);
                        txtUnidadMedida.setVisible(false);
                    } 
                }
            }
        }
        else if(rbIdProd.isSelected()){
            if(!txtBuscarProd.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                    if(prod.ConsultarID(0,lstContenedorConsulta,data,Integer.parseInt(txtBuscarProd.getText()))){
                        lstContenedorConsulta.setVisible(true);
                        lstContenedorConsulta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                                int valor=(int) newValue;
                                if(valor>=0){
                                    ModelProductos nodo=(ModelProductos) list.get(valor);
                                    vaciarDatosTxt(nodo);
                                    txtDescProd.setVisible(true);
                                    txtIdProd.setVisible(true);
                                    txtNombreProd.setVisible(true);
                                    txtUnidadMedida.setVisible(true);
                                    lstContenedorConsulta.setVisible(false);
                                }
                            }
                        });
                    }
                    else{
                        lstContenedorConsulta.setVisible(false);
                        txtDescProd.setVisible(false);
                        txtIdProd.setVisible(false);
                        txtNombreProd.setVisible(false);
                        txtUnidadMedida.setVisible(false);
                    } 
                }
            }
         }
    }
    private void Limpiar(){
        txtIdProd.setText("");
        txtNombreProd.setText("");
        txtBuscarProd.setText("");
        txtIdProd.setText("");
        txtDescProd.setText("");
        txtUnidadMedida.setText("");
    }

    @FXML
    private void eventValidarBusqueda(KeyEvent event){
        String c=event.getCharacter();
        if(rbIdProd.isSelected()){
            if(!Character.isDigit(c.charAt(0))){
                event.consume(); 
                setBanCon(true);
            }
            else{
                setBanCon(false);
            }
        }
        else if(rbNombProd.isSelected()){
            if(!Character.isLetter(c.charAt(0))){
                event.consume(); 
                setBanCon(true);
            } 
            else{
                setBanCon(false);
            }
        }
    }

    /**
     * @return the banCon
     */
    public boolean isBanCon(){
        return banCon;
    }

    /**
     * @param banCon the banCon to set
     */
    public void setBanCon(boolean banCon){
        this.banCon = banCon;
    }

}

    

