/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Proveedor;

import Models.ModelProveedores;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author :D
 */
public class ConsultarProveedorController implements Initializable {
    /**
     * @return the data
     */
    public static ObservableList getData() {
        return data;
    }
    @FXML
    private RadioButton rbNombreProv;
    @FXML
    private RadioButton rbIdProv;
    @FXML
    private TextField txtBuscarProv;
    @FXML
    private TextField txtIdProv;
    @FXML
    private TextField txtNombreProv;
    @FXML
    private TextField txtEmailProv;
    @FXML
    private TextField txtTelefonoProv;
    @FXML
    private TextField txtCodigoProv;
    @FXML
    private TextField txtCiudadProv;
    @FXML
    private TextField txtCalleProv;

    public static final ObservableList names =
            FXCollections.observableArrayList();
    private static final ObservableList data = 
            FXCollections.observableArrayList(); 
    
    public static ObservableList<?> list;
    
    public ListView<String> lstBuscarProv;
    
    @FXML
    private ToggleGroup grupoConsultarProv;
    @FXML
    private GridPane gridContenedor;
    @FXML
    private TextField txtColoniaProv;
    @FXML
    private TextField txtEstadoProv;
        private boolean banCon=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtBuscarProv.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue){
                if(newValue.matches("[^'\"]*")){
                    txtBuscarProv.setText(newValue);
                }
                else{
                    txtBuscarProv.setText(oldValue);
                }
            }
        });
    } 
    
    @FXML
    private void rbNombreClick(ActionEvent event) {
        Limpiar();
        
    }

    @FXML
    private void rbIdClick(ActionEvent event) {
        Limpiar();
        
    }

    @FXML
    private void eventBuscarConsultar(KeyEvent event){
        Models.ModelProveedores prov = new Models.ModelProveedores();
        gridContenedor.setVisible(false);
        if(rbNombreProv.isSelected())
        {
            if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prov.ConsultarNombre(0, lstBuscarProv, data, txtBuscarProv.getText())){
                 lstBuscarProv.setVisible(true);
                 lstBuscarProv.getSelectionModel().selectedIndexProperty().addListener(
                         new ChangeListener<Number>(){
                             @Override
                             public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                                 int valor = (int) newValue;
                                 if(valor>=0){
                                     ModelProveedores nodo = (ModelProveedores) list.get(valor);
                                     vaciarDatosTxt(nodo);
                                     gridContenedor.setVisible(true);
                                     lstBuscarProv.setVisible(false);
                                 }
                             }
                         });
                }
                else{
                    lstBuscarProv.setVisible(false);
                    gridContenedor.setVisible(false);
                }
            }
            }
        }
        else if(rbIdProv.isSelected()){
            if(!txtBuscarProv.getText().equals("")){
                getData().clear();
                if(!isBanCon()){
                if(prov.ConsultarID(0, lstBuscarProv, data, Integer.parseInt(txtBuscarProv.getText()))){
                    lstBuscarProv.setVisible(true);
                    lstBuscarProv.getSelectionModel().selectedIndexProperty().addListener(
                          new ChangeListener<Number>(){
                              @Override
                              public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                                  int valor = (int) newValue;
                                  if(valor>=0){
                                      ModelProveedores nodo = (ModelProveedores) list.get(valor);
                                      vaciarDatosTxt(nodo);
                                      gridContenedor.setVisible(true);
                                      lstBuscarProv.setVisible(false);
                                  }
                              }
                          });
                }
                else{
                    lstBuscarProv.setVisible(false);
                    gridContenedor.setVisible(false);
                }
            }
            }
        }
    }
    
    private void vaciarDatosTxt(ModelProveedores prov){
        txtNombreProv.setText(prov.getNombreProv());
        txtTelefonoProv.setText(prov.getTelefonoProv());
        txtEmailProv.setText(prov.getEmailProv());
        txtCodigoProv.setText(prov.getCodigoProv());
        txtCiudadProv.setText(prov.getCiudadProv());
        txtColoniaProv.setText(prov.getColoniaProv());
        txtCalleProv.setText(prov.getCalleProv());
        txtEstadoProv.setText(prov.getContrato());
        txtIdProv.setText(String.valueOf(prov.getIdProv()));
    }
    
    public ListView<?> getLstBuscarProv(){
        return lstBuscarProv;
    }

    public void setList(ObservableList li) {
        list = li;
    }
    
    private void Limpiar(){
        txtNombreProv.setText("");
        txtTelefonoProv.setText("");
        txtEmailProv.setText("");
        txtCodigoProv.setText("");
        txtCiudadProv.setText("");
        txtColoniaProv.setText("");
        txtCalleProv.setText("");
        txtEstadoProv.setText("");
        txtIdProv.setText("");
        txtBuscarProv.setText("");
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

    @FXML
    private void eventValidarBusqueda(KeyEvent event) {
             String c=event.getCharacter();
             
         if(rbIdProv.isSelected()){
            if(!Character.isDigit(c.charAt(0))) 
            { 
            //  getToolkit().beep(); 
               
              event.consume(); 
                setBanCon(true);
              
               
            }else{
                setBanCon(false);
            } 
         }
         else if(rbNombreProv.isSelected()){
               
                if(!Character.isLetter(c.charAt(0))) 
                { 
              //getToolkit().beep(); 
               
              event.consume(); 
                    setBanCon(true);
             
              } else{
                    setBanCon(false);
                }
         }
    }
}
