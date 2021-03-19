/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;

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
import javafx.stage.Stage;

/**
 *
 * @author Anas
 */
public class MainController implements Initializable {
    
     @FXML
    private Button doctor;

    @FXML
    private Button reception;

    @FXML
    private Button admin;

    @FXML
    private Label Hospital;

    @FXML
    void handleButtonAction(ActionEvent event) {
if(event.getSource()==admin){
        Store.UserType="admins";
        GetLoginWindow(event);
        }
        else if(event.getSource()==reception){
        Store.UserType="Receptionist";
        GetLoginWindow(event);
        }
        else if(event.getSource()==doctor){
        Store.UserType="Doctor";
        GetLoginWindow(event);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
 
    
     private void GetLoginWindow(ActionEvent event) {
             try {
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    System.out.println(Store.UserType);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}
