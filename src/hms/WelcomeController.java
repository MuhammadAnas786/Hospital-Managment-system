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
 * FXML Controller class
 *
 * @author Anas
 */
public class WelcomeController implements Initializable {

    @FXML
    private Label user_name;

    @FXML
    private Label Hospital;

    @FXML
    private Label usertype;

    @FXML
    private Button employee;

    @FXML
    private Button Patients;

    @FXML
    private Button Bills;

    @FXML
    private Button Rooms;

    @FXML
    private Button Records;

    @FXML
    private Button Medicines;

    @FXML
    private Button Logout;

      @FXML
    private Button Appointments;
      
    @FXML
    void click(ActionEvent event) {
if(event.getSource()==Logout){
GetSignInWindow(event);
}else if(event.getSource()==employee){
GetEmployeeWindow(event);
}
else if(event.getSource()==Patients){
GetPatientWindow(event);
}
else if(event.getSource()==Bills){
GetBills(event);
}
else if(event.getSource()==Rooms){
GetRooms(event);
}
else if(event.getSource()==Records){
GetRecords(event);
}else if(event.getSource()==Medicines){
GetMeds(event);
}
else if(event.getSource()==Appointments){
GetAppointments(event);
}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Store.Current=Store.Selection.none;
        Store.SetAllToBegin();
        setFields();
            
    }    

    private void setFields() {
        user_name.setText(Store.username);
        usertype.setText(Store.UserType);
        if(Store.UserType=="Receptionist"){
            employee.setVisible(false);
    
            
        }
        else if(Store.UserType=="Doctor"){
             employee.setVisible(false);
         
            Patients.setVisible(false);
            Bills.setVisible(false);
        /*   Records.setVisible(false);
            Medicines.setVisible(false);
          Rooms.setVisible(false);*/
        }
    }
    
     private void GetSignInWindow(ActionEvent event) {
             try {
                 Store.Logout();
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
  }

    private void GetEmployeeWindow(ActionEvent event) {
           try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("employee.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    private void GetPatientWindow(ActionEvent event) {
          try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Patients.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    private void GetBills(ActionEvent event) {
       try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Bill.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }  }

    private void GetRooms(ActionEvent event) {
        try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Rooms.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }}

    private void GetRecords(ActionEvent event) {
        try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Records.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }  }

    private void GetMeds(ActionEvent event) {
        try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Meds.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }   }

    private void GetAppointments(ActionEvent event) {
         try {
                
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Appointments.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }  }

}
