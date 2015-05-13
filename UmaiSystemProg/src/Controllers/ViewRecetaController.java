/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRecetaController implements Initializable {
  
    @FXML
    private TableView<ModelViewRecetas> table;
    @FXML
    private TableColumn<ModelViewRecetas,String>name,tipe,tama,numer,tiempo,dificultad,margen,porciento;
    @FXML
    private TableColumn<ModelViewRecetas,Integer>id;
    @FXML
    private ObservableList<ModelViewRecetas> list = FXCollections.observableArrayList();
    //StudentSQL ssql = new StudentSQL();
    BaseDatos.ConexionBD ssql=new BaseDatos.ConexionBD();
    @FXML
    //private Button btnInsert,btnDelete,btnRefresh;
    private Button btnRefresh;
    /*
    @FXML
    private void insert(ActionEvent event) throws IOException{
        new DialogStudent().start(new Stage());
        list = ssql.listStudent();
        table.setItems(list);
    }
    */
    /*
    @FXML
    
    private void update(ActionEvent event){
        new StudentUppdateModel().start(new Stage());
    } 
    */
    @FXML
    private void refresh(ActionEvent event){
        list = ssql.listStudent();
        table.setItems(list);
    }
    /*
    @FXML
    private void delete(){
        StudentPojo pojo = table.getSelectionModel().getSelectedItem();
        ssql.deleteStudent(pojo.getId());
        System.out.println(pojo.getId());
        list = ssql.listStudent();
        table.setItems(list);
    }
    */
    /*
    @FXML
    private void selectRow(MouseEvent event){
        if(event.getClickCount()==2){         
           StudentPojo pojo = table.getSelectionModel().getSelectedItem();
            StudenUpdateViewController.id = pojo.getId();
            System.out.println(StudenUpdateViewController.id);
            new StudentUppdateModel().start(new Stage());
        }                                             
    }                                         
     */                                         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        id.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("name"));
        tipe.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("tipo"));
        tama.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("tamano"));
        numer.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("numero"));
        tiempo.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("tiempo"));
        dificultad.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("dificultad"));
        margen.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("margen"));
        porciento.setCellValueFactory(new PropertyValueFactory<ModelViewRecetas,String>("porciento"));
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        list = ssql.listStudent();
        table.setItems(list);
      
    }
}
