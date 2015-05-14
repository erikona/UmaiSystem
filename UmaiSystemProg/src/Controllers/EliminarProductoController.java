/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author erika
 */
public class EliminarProductoController implements Initializable {
    @FXML
    private TextField txtBuscarProd;
    @FXML
    private TextField txtNomProd;
    @FXML
    private TextField txtIdProd;
    @FXML
    private Button btnEliminarProd;
    @FXML
    private Button btnCancelarProd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnEliminarProd.setDisable(true);
    }    
    @FXML
    private void BuscarEliminar(KeyEvent event) {
       BaseDatos.CRUD cr=new BaseDatos.CRUD();
       ResultSet rs=cr.Consulta("select idProd,nombreProd from Productos where nombreProd='"+txtBuscarProd.getText()  +"'");
        try 
        {
            if(rs.next()){
               
                txtIdProd.setText(rs.getString(1));
                txtNomProd.setText(rs.getString(2));
                 btnEliminarProd.setDisable(false);
            }
            else{
                txtIdProd.setText("");
                txtNomProd.setText("");
                btnEliminarProd.setDisable(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
