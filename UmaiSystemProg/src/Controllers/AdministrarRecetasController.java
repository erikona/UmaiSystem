/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author lalo
 */
public class AdministrarRecetasController implements Initializable {
    @FXML
    private Button btnAgregarReceta;
    @FXML
    private Button btnEliminarReceta;
    @FXML
    private Button btnAtrasReceta;
    @FXML
    private Button btnModificarReceta;
    @FXML
    private Button btnVisualizarReceta;
    
      private ObservableList<ObservableList> data;
    private TableView tableview;

    
    @FXML
    void btnAgregarRecetaClick(){
        try {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/agregarRecetas.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
    
        
        
       
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
   
    @FXML
    void btnVisualizarRecetaClick()
    {
        try 
        {
          Parent root = FXMLLoader.load(getClass().getResource("/Views/ConsultaRecetas.fxml"));
         Scene scene = new Scene(root);
         Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
            e.printStackTrace();
        }  
        
        /*
        
        tableview = new TableView();
        buildData();
        Stage stage=new Stage();
        Scene scene = new Scene(tableview);
        stage.setScene(scene);
        stage.show();
        */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
   
   
   //Tableview and data  
     
   //Connection database  
 

   

    //CONNECTION DATABASE
    public void buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
              BaseDatos.ConexionBD db=new BaseDatos.ConexionBD();
            c = db.getConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from receta ";
            SQL="select nombreRec,tipoRec,tamañoPorcion,numeroPorcion,tiempoPreparacion,difucultad,margenError,porcientoPerdida from receta  ;";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
             
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;      
                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                       SimpleStringProperty p=new SimpleStringProperty(param.getValue().get(j).toString());
                          
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
 }   
    


