/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class ViewUsuariosController implements Initializable {
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnBuscarTodosUsuarios;
    @FXML
    private Button btnBusquedaPerUsuario;
    @FXML
    private TextField txtBsquedaPersonalizada;
    @FXML
    private TableView<ModelViewUsuario> tableUsuarios;
    @FXML
    private TableColumn<ModelViewUsuario,Integer>id;
    @FXML
    private TableColumn<ModelViewUsuario,String> name;
    @FXML
    private TableColumn<ModelViewUsuario,String> contra;
    @FXML
    private TableColumn<ModelViewUsuario,String> calle;
    @FXML
    private TableColumn<ModelViewUsuario,String> colonia;
    @FXML
    private TableColumn<ModelViewUsuario,String> ciudad;
    @FXML
    private TableColumn<ModelViewUsuario,String> codigoPos;
    @FXML
    private TableColumn<ModelViewUsuario,String> telefono;
    @FXML
    private TableColumn<ModelViewUsuario,String> avatar;
    @FXML
    private TableColumn<ModelViewUsuario,Integer> sueldo;
    @FXML
    private TableColumn<ModelViewUsuario,Integer> puntos;
    @FXML
    private TableColumn<ModelViewUsuario,Integer> permiso;
    private ObservableList<ModelViewUsuario> list = FXCollections.observableArrayList();
    //StudentSQL ssql = new StudentSQL();
   // BaseDatos.ConexionBD ssql=new BaseDatos.ConexionBD();
    BaseDatos.ConexionBD bd=new BaseDatos.ConexionBD();
    Connection con=null;
     ResultSet rs=null;
     Statement statement;
    @FXML
    private ScrollPane ScrollPane1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        id.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("name"));
        contra.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("contra"));
        calle.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("calle"));
        colonia.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("colonia"));
        ciudad.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("ciudad"));
        codigoPos.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("codigoP"));
        telefono.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("telefono"));
        avatar.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("avatar"));
        
        sueldo.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("sueldo"));
        puntos.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("puntos"));
        permiso.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("permiso"));
        tableUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
     ScrollPane1.setVisible(false);
      //  tableUsuarios.setItems(list);
        
    }    

    @FXML
    private void refresh(ActionEvent event) {
         
    }

    @FXML
    private void btnBuscarTodosUsuariosClick(ActionEvent event) {
        
        con=bd.getConnection(); 
        try {
            statement = (Statement) con.createStatement();
          rs = statement.executeQuery("Select * from usuarios");
          ScrollPane1.setVisible(true);
          list =listUser(rs);
        tableUsuarios.setItems(list);
        txtBsquedaPersonalizada.setVisible(false);
        } catch (Exception e) {
           
        }
        /*
        id.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("name"));
        contra.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("contra"));
        calle.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("calle"));
        colonia.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("colonia"));
        ciudad.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("ciudad"));
        codigoPos.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("codigoP"));
        telefono.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("telefono"));
        avatar.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,String>("avatar"));
        
        sueldo.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("sueldo"));
        puntos.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("puntos"));
        permiso.setCellValueFactory(new PropertyValueFactory<ModelViewUsuario,Integer>("permiso"));
        tableUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        */
        
    }

    @FXML
    private void btnBusquedaPerUsuarioClick(ActionEvent event) {
        txtBsquedaPersonalizada.setVisible(true);
        
    }
    
    public ObservableList<ModelViewUsuario> listUser(ResultSet rs){
        try {
           // connected();
          
           ObservableList<ModelViewUsuario> list = FXCollections.observableArrayList();
           
            
         
            while(rs.next()){
                
                 ModelViewUsuario nodo = new ModelViewUsuario();
                nodo.setId(rs.getInt(1));
                nodo.setName(rs.getString(2));
                nodo.setContra(rs.getString(3));
                nodo.setCalle(rs.getString(4));
                nodo.setColonia(rs.getString(5));
                nodo.setCiudad(rs.getString(6));
                nodo.setCodigoP(rs.getString(7));
                nodo.setTelefono(rs.getString(8));
                nodo.setAvatar(rs.getString(9));
                nodo.setSueldo(rs.getString(10));
                nodo.setPuntos(rs.getString(11));
                nodo.setPermiso(rs.getString(12));
             list.add(nodo);
            }
           
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        //closed();
        }       
    }

    @FXML
    private void BusquedaDB(KeyEvent event) {
      
        con=bd.getConnection(); 
        rs=null;
        try {
            statement = (Statement) con.createStatement();
          rs = statement.executeQuery("Select * from usuarios where nombreUsu='"+ txtBsquedaPersonalizada.getText() +"'");
          list =listUser(rs);
                tableUsuarios.setItems(list);
            if (rs.first()) {
               
               
                ScrollPane1.setVisible(true);
            }
            else{
                 ScrollPane1.setVisible(false);
            }
          
          
        
        
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
