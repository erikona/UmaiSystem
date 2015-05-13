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
 * @author 
 */
public class EliminarUsuariosController implements Initializable {
    @FXML
    private TextField txtBuscarEliminarUsuario;
    @FXML
    private Button btnEliminarUsuario;
    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private TextField txtIdUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEliminarUsuario.setDisable(true);
    }    

    @FXML
    private void BuscarEliminar(KeyEvent event) {
       BaseDatos.CRUD cr=new BaseDatos.CRUD();
       ResultSet rs=cr.Consulta("select idUsu,nombreUsu from usuarios where nombreUsu='"+txtBuscarEliminarUsuario.getText()  +"'");
        try 
        {
            if(rs.next()){
               
                txtIdUsuario.setText(rs.getString(1));
                txtNombreUsuario.setText(rs.getString(2));
                 btnEliminarUsuario.setDisable(false);
            }
            else{
                txtIdUsuario.setText("");
                txtNombreUsuario.setText("");
                btnEliminarUsuario.setDisable(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnEliminarUsuarioClick(ActionEvent event) {
         BaseDatos.CRUD cr=new BaseDatos.CRUD();
        
         try {
            
             if ( JOptionPane.showConfirmDialog(null,"Realmente desea Eliminar al usuario","Eliminar Usuario",0,2) ==0 ){
                 cr.Actualizar("UPDATE usuarios SET estadoContrato ='terminado' WHERE nombreUsu ='"+txtNombreUsuario.getText()  +"'");
             }
              
         
           // cr.Borrar("delete from usuarios where nombreUsu='"+ txtNombreUsuario.getText()+"'");
            txtBuscarEliminarUsuario.setText("");
            txtIdUsuario.setText("");
           txtNombreUsuario.setText("");
           btnEliminarUsuario.setDisable(true);
        } catch (Exception e) {
        }
        
    }
    
}
