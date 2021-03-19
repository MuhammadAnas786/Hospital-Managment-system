/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class BillsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private ImageView Back;

    @FXML
    private JFXTextField Patient;

    @FXML
    private Label Hospital;

    @FXML
    private JFXTextField address;

    @FXML
    private Button Update;

    @FXML
    private Button AddP;

    @FXML
    private JFXTextField Doc;

    @FXML
    private JFXTimePicker tim;

    @FXML
    private JFXDatePicker dat;

    @FXML
    private JFXTextField Room;

    @FXML
    private JFXTextField Floor;

    @FXML
    private JFXTextField Age;

    @FXML
    private JFXTextField DocFee;

    @FXML
    private JFXTextField HospitalFee;

    @FXML
    private JFXTextField RoomCharges;

    @FXML
    private JFXTextField OtherCharges;

    @FXML
    private Label TotalLabel;

    @FXML
    private Label Total;

    @FXML
    private JFXDatePicker CurrentDate;
 @FXML
    private JFXTextField tax;

     @FXML
    private Button makeTotal;

     @FXML
    void MakeIt(ActionEvent event) {
          Window owner = AddP.getScene().getWindow();
        if(DocFee.getText().isEmpty()||HospitalFee.getText().isEmpty()||OtherCharges.getText().isEmpty())
        {
              AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;
        }
        else{
      double d=Double.parseDouble(DocFee.getText());
      double h=Double.parseDouble(HospitalFee.getText());
      double o=Double.parseDouble(OtherCharges.getText());
      double r=Double.parseDouble(Room.getText());
      double tot=d+h+o+r;
      double tx=(d+h+o+r)*0.17;
       double tota=tot+tx;
      System.out.println(tot);
      System.out.println(tx);
      tax.setText(String.format("%f", tx));
      Total.setText(String.format("%f", tota));
      
              
        }
    }
    @FXML
    void AddEmp(ActionEvent event) {
     Window owner = AddP.getScene().getWindow();
     if(event.getSource()==AddP)
        if(DocFee.getText().isEmpty()||HospitalFee.getText().isEmpty()||OtherCharges.getText().isEmpty())
        {
              AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;
        }
        else{
      InsertRecord();
        }
     else if(event.getSource()==Update){
     if(DocFee.getText().isEmpty()||HospitalFee.getText().isEmpty()||OtherCharges.getText().isEmpty())
        {
              AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;
        }
        else{
      InsertRecord();
        }
     }
        }

   

    @FXML
   private void backWindow(MouseEvent event) {
try {
                Store.ActiveEmployee=Store.Employee.none;
    Store.Current=Store.Selection.none;
     System.out.println("ffdsf");
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

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CurrentDate.setValue(LocalDate.now());
        setForm();
    }    

    private void InsertRecord() {
        Window owner = AddP.getScene().getWindow();
                if(Store.Current==Store.Selection.Add)
{
     double d=Double.parseDouble(DocFee.getText());
      double h=Double.parseDouble(HospitalFee.getText());
      double o=Double.parseDouble(OtherCharges.getText());
      double r=Double.parseDouble(Room.getText());
      double tot=d+h+o+r;
      double tx=(d+h+o+r)*0.17;
       double tota=tot+tx;
  
Bill newDoc=new Bill(tx,h,d,r,o,tota);
if(Bill.AddBil(newDoc))
{
     
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
}
    }

    private void setForm() {
        if(Store.Current==Store.Selection.Add)
        { patients let=patients.getPatByAppointment(Store.getAppointment());
      Doctor let2=Doctor.getDocByAppointment(Store.getAppointment());
      Store.setPatient(let.pat_id);
      Store.setDoc(let2.doc_id);
        if(let.assign_type=="appointment")
            DocFee.setText(String.format("%f", let2.AppointmentFee));
        else if(let.assign_type=="operation")
            DocFee.setText(String.format("%f", let2.operataionFee));
        else 
        DocFee.setText(String.format("%f", let2.otherCharges));
      Update.setVisible(false);
     // patients let=patients.getPatByAppointment(Store.getAppointment());
     // Doctor let2=Doctor.getDocByAppointment(Store.getAppointment());
      
      Patient.setText(let.Fname+" "+let.Lname);
      address.setText(let.address);
      Doc.setText(let2.Fname+" "+let2.Lname);
      dat.setValue(let.dat);
      tim.setValue(let.tim);
      Room.setText(String.format("%d",let.Room));
      Floor.setText(String.format("%d",let.Floor));
      //DocFee.setText(String.format("%d", let2.));
        }else if(Store.Current==Store.Selection.View)
        {
      makeTotal.setVisible(false);
            AddP.setVisible(false);Update.setVisible(false);
         Bill nDoc=Bill.getBillById(Store.getBill());
       
           patients let=patients.getPatByAppointment(nDoc.appointment_id);
      Doctor let2=Doctor.getDocByAppointment(nDoc.appointment_id);
      Store.setPatient(let.pat_id);
      Store.setDoc(let2.doc_id);
    
      Update.setVisible(false);
     // patients let=patients.getPatByAppointment(Store.getAppointment());
     // Doctor let2=Doctor.getDocByAppointment(Store.getAppointment());
      
      Patient.setText(let.Fname+" "+let.Lname);
      address.setText(let.address);
      Doc.setText(let2.Fname+" "+let2.Lname);
      dat.setValue(let.dat);
      tim.setValue(let.tim);
      Room.setText(String.format("%d",let.Room));
      Floor.setText(String.format("%d",let.Floor));
      
      tax.setText(String.format("%f", nDoc.tax));
       if(let.assign_type=="appointment")
            DocFee.setText(String.format("%f", let2.AppointmentFee));
        else if(let.assign_type=="operation")
            DocFee.setText(String.format("%f", let2.operataionFee));
        else 
        DocFee.setText(String.format("%f", let2.otherCharges));
      HospitalFee.setText(String.format("%f", nDoc.HospitalFee));
      RoomCharges.setText(String.format("%f", nDoc.RoomCharges));
      OtherCharges.setText(String.format("%f", nDoc.otherCharges));
      Total.setText(String.format("%f", nDoc.total));
        }
        
     }
     
}
