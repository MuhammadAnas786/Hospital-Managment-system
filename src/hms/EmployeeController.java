/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmployeeController implements Initializable {

    @FXML
    private Label user_name;

    @FXML
    private Label Hospital;

    @FXML
    private JFXButton Add;

    @FXML
    private Label usertype;

    @FXML
    private Button Doc;

    @FXML
    private Button Reception;

    @FXML
    private Button Nurse;

    @FXML
    private Button Logout;
@FXML
private ImageView Back;

    @FXML
    void backWindow(MouseEvent event) {
 try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("welcome.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    } 
    }
    @FXML
    void click(ActionEvent event) {
             System.out.println(event.getSource());
if(event.getSource()==Doc){
     Store.setActiveEmployee(Store.Employee.Doctor);
GetDocs(event);
}
else if(event.getSource()==Reception){
    Store.setActiveEmployee(Store.Employee.Reception);
GetReceptionists(event);
}
else if(event.getSource()==Nurse){
    Store.setActiveEmployee(Store.Employee.Nurse);
GetNurses(event);
}else if(event.getSource()==Add){
  Store.setCurrent(Store.Selection.Add);
AddWindow(event);
}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Store.setActiveEmployee(Store.Employee.none);
        Store.setCurrent(Store.Selection.none);
    }    

    private void GetDocs(ActionEvent event) {
          try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Docs.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }   }

    private void GetReceptionists(ActionEvent event) {
          try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Rec.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    private void GetNurses(ActionEvent event) {
          try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Nurses.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    private void AddWindow(ActionEvent event) {
        try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("emp.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    
}
