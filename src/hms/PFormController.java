/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Anas
 */

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
public class PFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private ImageView Back;

    @FXML
    private JFXTextField Fname;

    @FXML
    private JFXTextField Lname;

    @FXML
    private Label Hospital;

    @FXML
    private JFXTextField address;

    @FXML
    private Button Update;

    @FXML
    private ComboBox<String> Gender;

    @FXML
    private Button AddP;

    @FXML
    private JFXTextField Doc;

     @FXML
    private ComboBox<String> ApType;
     
    @FXML
    private JFXTimePicker tim;

    @FXML
    private JFXDatePicker dat;

    @FXML
    private JFXTextField Room;

    @FXML
    private JFXTextField Floor;

    @FXML
    private JFXDatePicker DOB;

    @FXML
    void AddEmp(ActionEvent event) {
        
        if(event.getSource()==AddP){
            Window owner = AddP.getScene().getWindow();
        if(Fname.getText().isEmpty()||Lname.getText().isEmpty()||address.getText().isEmpty()||Gender.getValue().isEmpty()||Doc.getText().isEmpty()||Room.getText().isEmpty()||Floor.getText().isEmpty() )
        {
              AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;
        }
        else{
      InsertRecord(event);
        }
        }
    }

    @FXML
    void backWindow(MouseEvent event) {
try {
   
     Store.Current=Store.Selection.none;
                 System.out.println("hello");
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

    @FXML
    void click(ActionEvent event) {

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ObservableList<String> ss=FXCollections.observableArrayList();;
        ss.add("Male");
        ss.add("Female");
        ss.add("Others");
        //ComboBox comboBox = new ComboBox();
        ObservableList<String> ss2=FXCollections.observableArrayList();;
        ss2.add("appointment");
        ss2.add("operation");
        ss2.add("emergency");
        ss2.add("others");
        
        ApType.setItems(ss2);
        Gender.setItems(ss);
       
        setForm();
    }    

    private void InsertRecord(ActionEvent event) {
        
          saveInfo();
          
          
          /*
       try {
         
   
     Store.Current=Store.Selection.none;
                 System.out.println("hello");
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("employee.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    } */
    }    

    private void setForm() {
         if(Store.Current==Store.Selection.Add){
      Update.setVisible(false);
        }else if(Store.Current==Store.Selection.Update||Store.Current==Store.Selection.View)
        {
        AddP.setVisible(false);
        
       
           
       patients nDoc=patients.getPatById(Store.getPatient());
      /*  ActiveDoc=nDoc;
        EmployeeType.setValue("Doctor");
        setEmployee(nDoc.getEmployee());
        ShowDoc(nDoc);*/
        
        Fname.setText(nDoc.Fname);
       Lname.setText(nDoc.Lname);
       address.setText(nDoc.address);
       DOB.setValue(nDoc.DOB);
       Gender.setValue(nDoc.Gender);
       Doc.setText(nDoc.doctorName);
       System.out.println(nDoc.dat);
       System.out.println(nDoc.tim);
       dat.setValue(nDoc.dat);
       tim.setValue(nDoc.tim);
       Floor.setText(String.format("%d",nDoc.Floor));
       Room.setText(String.format("%d", nDoc.Room));
       ApType.setValue(nDoc.assign_type);
       if(Store.Current==Store.Selection.View){
          
       Update.setVisible(false);
      
        }
        }
     }

    private void saveInfo() {
        Window owner = AddP.getScene().getWindow();
           if(Store.Current==Store.Selection.Add)
{
   int A= Integer.parseInt(Floor.getText());
   int o= Integer.parseInt(Room.getText());
patients newDoc=new patients(Fname.getText(),Lname.getText(),address.getText(),DOB.getValue(),Gender.getValue(),Doc.getText(),A,o,dat.getValue(),tim.getValue(),ApType.getValue());
if(patients.Addpatient(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
} else if(Store.Current==Store.Selection.Update){
   int A= Integer.parseInt(Floor.getText());
   int o= Integer.parseInt(Room.getText());
patients newDoc=new patients(Store.getPatient(),Fname.getText(),Lname.getText(),address.getText(),DOB.getValue(),Gender.getValue(),Doc.getText(),A,o,dat.getValue(),tim.getValue(),ApType.getValue());

  if(patients.UpdatePatient(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}
  else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unable to save info");
               return;
}
 
}
    
    
    
    }
    
}
