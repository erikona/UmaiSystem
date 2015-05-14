/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class AdministrarPersonalController implements Initializable {
    @FXML
    private Button btnAgregarPersonal;
    @FXML
    private Button btnEliminarPersonal;
    @FXML
    private Button btnAtrasPersonal;
    @FXML
    private Button btnModificarPersonal;
    @FXML
    private Button btnVisualizarPersonal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    void btnAgregarPersonalClick(){
        try {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/agregarUsuario.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    private void btnVisualizarPersonalClick(ActionEvent event) {
         try {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/ConsultaUsuarios.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }  
        
    }

    private void btnEliminarPersonalClick(ActionEvent event) {
     
    try {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/eliminarUser.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        } 
    
    }
    
    public void getStage(){
        
    }
            

    private void btnModificarPersonalClick(ActionEvent event) {
    try {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/ModiUsuario.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        } 
    
    }
    
}
