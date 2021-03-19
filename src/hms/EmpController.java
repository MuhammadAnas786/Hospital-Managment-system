/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EmpController implements Initializable {


    private static Doctor ActiveDoc;
    private static Doctor ActiveReceptionist= null;
    private static Doctor ActiveNurse= null;
   @FXML
    private ImageView Back;
@FXML
    private AnchorPane EmpPane;
    @FXML
    private JFXTextField Fname;

    @FXML
    private JFXTextField Lname;

    @FXML
    private JFXTextField email;

    @FXML
    private Label Hospital;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField contactInfo;

    @FXML
    private JFXTextField Qualification;

    @FXML
    private JFXTextField salary;

    @FXML
    private ComboBox<String> EmployeeType;

    @FXML
    private Button AddEmployee;

    @FXML
    private Button Update;
  Label UserLabel;
    JFXTextField Specialization;
  JFXTextField Username;
   JFXPasswordField Password;
  JFXTextField salary2;
     JFXTextField AppointmentFee;
    JFXTextField OtherChages;
    JFXTextField OperationFee;
    Button Save;
   Button Cancel;
    @FXML
    void AddEmp(ActionEvent event) {
        
        if(event.getSource()==AddEmployee){
            Window owner = AddEmployee.getScene().getWindow();
        if(Fname.getText().isEmpty()||Lname.getText().isEmpty()||address.getText().isEmpty()||Qualification.getText().isEmpty()||salary.getText().isEmpty()||contactInfo.getText().isEmpty())
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
    void backWindow(ActionEvent event) {
 try {
    Store.ActiveEmployee=Store.Employee.none;
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
    } 
    }

    @FXML
    void click(ActionEvent event) {

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
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("employee.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    } 
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String> ss=FXCollections.observableArrayList();;
        ss.add("Doctor");
        ss.add("Receptionist");
        ss.add("Nurse");
        //ComboBox comboBox = new ComboBox();
        
        EmployeeType.setItems(ss);
      // GetData();
        setForm();
      
    }    
    

    private void setForm() {
        
     
       if(Store.Current==Store.Selection.Add){
      Update.setVisible(false);
        }else if(Store.Current==Store.Selection.Update||Store.Current==Store.Selection.View)
        {
        AddEmployee.setVisible(false);
        
        if(Store.ActiveEmployee==Store.Employee.Doctor){
            EmployeeType.setVisible(false);
        Doctor nDoc=Doctor.getDocById(Store.getDoc());
        ActiveDoc=nDoc;
        EmployeeType.setValue("Doctor");
        setEmployee(nDoc.getEmployee());
        ShowDoc(nDoc);
        
        }
        else if(Store.ActiveEmployee==Store.Employee.Reception){
      Receptionist nDoc=Receptionist.getRecById(Store.getRec());
        EmployeeType.setValue("Receptionist");
        setEmployee(nDoc.getEmployee());
        ShowReceptionist(nDoc);
        
        }
       if(Store.Current==Store.Selection.View){
          int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--){
          JFXTextField l= (JFXTextField)EmpPane.getChildren();
       l.setEditable(false);
       }
       Update.setVisible(false);
       Cancel.setVisible(false);
       Save.setVisible(false);
        }
        }
    
    }

    private void InsertRecord() {
       EmployeeType.setEditable(false);
       showOther(); 
    }

    private void showOther() {
       if(EmployeeType.getValue()=="Doctor")
       {
        ShowDoc();
       }else if(EmployeeType.getValue()=="Receptionist"){
       ShowReceptionist();
       }
       else if(EmployeeType.getValue()=="Nurse")
       {
       ShowNurse();
       }
    }

    private void ShowDoc() {
         int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--)
           EmpPane.getChildren().remove(j);
   
   Pane pane=new Pane();
   
          UserLabel = new Label();
        Specialization = new JFXTextField();
        Username = new JFXTextField();
        Password = new JFXPasswordField();
        salary2 = new JFXTextField();
        AppointmentFee = new JFXTextField();
        OtherChages = new JFXTextField();
        OperationFee = new JFXTextField();
        Save = new Button();
        Cancel = new Button();

       
Specialization.setPromptText("Specialization");
Username.setPromptText("Username");
Password.setPromptText("Password");
salary2.setPromptText("salary");
AppointmentFee.setPromptText("AppointmentFee");
OtherChages.setPromptText("Other charges");
OperationFee.setPromptText("Operation fee");

        UserLabel.setAlignment(javafx.geometry.Pos.CENTER);
        UserLabel.setLayoutX(353.0);
        UserLabel.setLayoutY(95.0);
        UserLabel.setPrefHeight(46.0);
        UserLabel.setPrefWidth(292.0);
        UserLabel.setText("Doctor");
        UserLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        UserLabel.setFont(new Font("Ebrima Bold", 24.0));

        Specialization.setLayoutX(39.0);
        Specialization.setLayoutY(155.0);
        Specialization.setStyle("-fx-text-fill: black;");

        Username.setLayoutX(270.0);
        Username.setLayoutY(155.0);
        Username.setStyle("-fx-text-fill: black;");

        Password.setLayoutX(525.0);
        Password.setLayoutY(155.0);

        salary2.setLayoutX(731.0);
        salary2.setLayoutY(155.0);
        salary2.setStyle("-fx-text-fill: black;");

        AppointmentFee.setLayoutX(39.0);
        AppointmentFee.setLayoutY(250.0);
        AppointmentFee.setStyle("-fx-text-fill: black;");

        OtherChages.setLayoutX(566.0);
        OtherChages.setLayoutY(250.0);
        OtherChages.setStyle("-fx-text-fill: black;");

        OperationFee.setLayoutX(295.0);
        OperationFee.setLayoutY(250.0);
        OperationFee.setStyle("-fx-text-fill: black;");

        Save.setLayoutX(889.0);
        Save.setLayoutY(342.0);
        Save.setMnemonicParsing(false);
        Save.setOnAction(this::SaveInfo);
        Save.setPrefHeight(53.0);
        Save.setPrefWidth(154.0);
        Save.setText("Save");

        Cancel.setLayoutX(645.0);
        Cancel.setLayoutY(342.0);
        Cancel.setMnemonicParsing(false);
        Cancel.setOnAction(this::backWindow);
        Cancel.setPrefHeight(53.0);
        Cancel.setPrefWidth(154.0);
        Cancel.setText("Cancel");

        pane.getChildren().add(UserLabel);
        pane.getChildren().add(Specialization);
        pane.getChildren().add(Username);
        pane.getChildren().add(Password);
        pane.getChildren().add(salary2);
        pane.getChildren().add(AppointmentFee);
        pane.getChildren().add(OtherChages);
        pane.getChildren().add(OperationFee);
        pane.getChildren().add(Save);
        pane.getChildren().add(Cancel);
        
        EmpPane.getChildren().add(pane);}
    
  
private void SaveInfo(ActionEvent event){
     Window owner = EmpPane.getScene().getWindow();
  Pane data=  (Pane) EmpPane.getChildren().get(0);
   for(Node x :data.getChildren()){
       if(EmployeeType.getValue()=="Doctor"||EmployeeType.getValue()=="Receptionist"){
if(x instanceof JFXTextField){
    JFXTextField field1=(JFXTextField) x;
if(field1.getPromptText()=="Username"&& field1.getText().isEmpty()){
    System.out.println("Inside");
     AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;}

}
if(x instanceof JFXPasswordField){
    JFXPasswordField field2=(JFXPasswordField) x;

if(field2.getPromptText()=="Password"&& field2.getText().isEmpty()){
   
     AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty Fields");
               return;
  }
}

   }
     
 }

   if(Store.Current==Store.Selection.Add&&EmployeeType.getValue()=="Doctor")
{
   Double A= Double.parseDouble(AppointmentFee.getText());
   Double o= Double.parseDouble(OperationFee.getText());
   Double ot= Double.parseDouble(OtherChages.getText());
Doctor newDoc=new Doctor(Fname.getText(),Lname.getText(),email.getText(),address.getText(),contactInfo.getText(),Double.parseDouble(salary.getText()),Qualification.getText(),Specialization.getText(),Username.getText(),Password.getText(),Double.parseDouble(salary2.getText()),A,o,ot);
if(Doctor.AddDoctor(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
}else if(Store.Current==Store.Selection.Update&&EmployeeType.getValue()=="Doctor"){
    Double A= Double.parseDouble(AppointmentFee.getText());
   Double o= Double.parseDouble(OperationFee.getText());
   Double ot= Double.parseDouble(OtherChages.getText());
      Doctor newDoc=new Doctor(Store.getDoc(),ActiveDoc.emp_id,Fname.getText(),Lname.getText(),email.getText(),address.getText(),contactInfo.getText(),Double.parseDouble(salary.getText()),Qualification.getText(),Specialization.getText(),Username.getText(),Password.getText(),Double.parseDouble(salary2.getText()),A,o,ot);

  if(Doctor.UpdateDoc(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}
  else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
 
}else  if(Store.Current==Store.Selection.Add&&EmployeeType.getValue()=="Receptionist")
{
   
Receptionist newDoc=new Receptionist(Fname.getText(),Lname.getText(),email.getText(),address.getText(),contactInfo.getText(),Double.parseDouble(salary.getText()),Qualification.getText(),Username.getText(),Password.getText(),Double.parseDouble(salary2.getText()));
if(Receptionist.AddReceptionist(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
}
   else if(Store.Current==Store.Selection.Update&&EmployeeType.getValue()=="Receptionist"){

      Receptionist newDoc=new Receptionist(12,ActiveReceptionist.emp_id,Fname.getText(),Lname.getText(),email.getText(),address.getText(),contactInfo.getText(),Double.parseDouble(salary.getText()),Qualification.getText(),Username.getText(),Password.getText(),Double.parseDouble(salary2.getText()));

  if(Receptionist.UpdateReceptionist(newDoc))
{
AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Form Success!","Successfull");
               return;
}
  else 
{
AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","unableto save info");
               return;
}
 
}
   
}

    private void ShowReceptionist() {
          int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--)
           EmpPane.getChildren().remove(j);
   
   Pane pane=new Pane();
   
          UserLabel = new Label();
       // Specialization = new JFXTextField();
        Username = new JFXTextField();
        Password = new JFXPasswordField();
        salary2 = new JFXTextField();
        /*AppointmentFee = new JFXTextField();
        OtherChages = new JFXTextField();
        OperationFee = new JFXTextField();*/
        Save = new Button();
        Cancel = new Button();

       
//Specialization.setPromptText("Specialization");
Username.setPromptText("Username");
Password.setPromptText("Password");
salary2.setPromptText("salary");
//

        UserLabel.setAlignment(javafx.geometry.Pos.CENTER);
        UserLabel.setLayoutX(353.0);
        UserLabel.setLayoutY(95.0);
        UserLabel.setPrefHeight(46.0);
        UserLabel.setPrefWidth(292.0);
        UserLabel.setText("Receptionist");
        UserLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        UserLabel.setFont(new Font("Ebrima Bold", 24.0));

       /* Specialization.setLayoutX(39.0);
        Specialization.setLayoutY(155.0);
        Specialization.setStyle("-fx-text-fill: black;");*/

        Username.setLayoutX(270.0);
        Username.setLayoutY(155.0);
        Username.setStyle("-fx-text-fill: black;");

        Password.setLayoutX(525.0);
        Password.setLayoutY(155.0);

    //

        Save.setLayoutX(889.0);
        Save.setLayoutY(342.0);
        Save.setMnemonicParsing(false);
        Save.setOnAction(this::SaveInfo);
        Save.setPrefHeight(53.0);
        Save.setPrefWidth(154.0);
        Save.setText("Save");
 salary2.setLayoutX(731.0);
        salary2.setLayoutY(155.0);
        salary2.setStyle("-fx-text-fill: black;");
        Cancel.setLayoutX(645.0);
        Cancel.setLayoutY(342.0);
        Cancel.setMnemonicParsing(false);
        Cancel.setOnAction(this::backWindow);
        Cancel.setPrefHeight(53.0);
        Cancel.setPrefWidth(154.0);
        Cancel.setText("Cancel");

        pane.getChildren().add(UserLabel);
       // pane.getChildren().add(Specialization);
        pane.getChildren().add(Username);
        pane.getChildren().add(Password);
        pane.getChildren().add(salary2);
      //
       //
        pane.getChildren().add(Save);
        pane.getChildren().add(Cancel);
        
        EmpPane.getChildren().add(pane);
    }


private void ShowNurse() {
          int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--)
           EmpPane.getChildren().remove(j);
   
   Pane pane=new Pane();
   
          UserLabel = new Label();
      
        salary2 = new JFXTextField();
        /*AppointmentFee = new JFXTextField();
        OtherChages = new JFXTextField();
        OperationFee = new JFXTextField();*/
        Save = new Button();
        Cancel = new Button();

   
salary2.setPromptText("salary");
//

        UserLabel.setAlignment(javafx.geometry.Pos.CENTER);
        UserLabel.setLayoutX(353.0);
        UserLabel.setLayoutY(95.0);
        UserLabel.setPrefHeight(46.0);
        UserLabel.setPrefWidth(292.0);
        UserLabel.setText("Receptionist");
        UserLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        UserLabel.setFont(new Font("Ebrima Bold", 24.0));

       /* Specialization.setLayoutX(39.0);
        Specialization.setLayoutY(155.0);
        Specialization.setStyle("-fx-text-fill: black;");*/

    //

        Save.setLayoutX(889.0);
        Save.setLayoutY(342.0);
        Save.setMnemonicParsing(false);
        Save.setOnAction(this::SaveInfo);
        Save.setPrefHeight(53.0);
        Save.setPrefWidth(154.0);
        Save.setText("Save");
 salary2.setLayoutX(731.0);
        salary2.setLayoutY(155.0);
        salary2.setStyle("-fx-text-fill: black;");
        Cancel.setLayoutX(645.0);
        Cancel.setLayoutY(342.0);
        Cancel.setMnemonicParsing(false);
        Cancel.setOnAction(this::backWindow);
        Cancel.setPrefHeight(53.0);
        Cancel.setPrefWidth(154.0);
        Cancel.setText("Cancel");

        pane.getChildren().add(UserLabel);
       // pane.getChildren().add(Specialization);
        pane.getChildren().add(Username);
        pane.getChildren().add(Password);
        pane.getChildren().add(salary2);
      //
       //
        pane.getChildren().add(Save);
        pane.getChildren().add(Cancel);
        
        EmpPane.getChildren().add(pane);
    }

    private void ShowDoc(Doctor nDoc) {
        
        
          int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--)
           EmpPane.getChildren().remove(j);
   
   Pane pane=new Pane();
   
          UserLabel = new Label();
        Specialization = new JFXTextField();
        Username = new JFXTextField();
        Password = new JFXPasswordField();
        salary2 = new JFXTextField();
        AppointmentFee = new JFXTextField();
        OtherChages = new JFXTextField();
        OperationFee = new JFXTextField();
        Save = new Button();
        Cancel = new Button();

       
Specialization.setPromptText("Specialization");
Username.setPromptText("Username");
Password.setPromptText("Password");
salary2.setPromptText("salary");
AppointmentFee.setPromptText("AppointmentFee");
OtherChages.setPromptText("Other charges");
OperationFee.setPromptText("Operation fee");



        UserLabel.setAlignment(javafx.geometry.Pos.CENTER);
        UserLabel.setLayoutX(353.0);
        UserLabel.setLayoutY(95.0);
        UserLabel.setPrefHeight(46.0);
        UserLabel.setPrefWidth(292.0);
        UserLabel.setText("Doctor");
        UserLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        UserLabel.setFont(new Font("Ebrima Bold", 24.0));

        Specialization.setLayoutX(39.0);
        Specialization.setLayoutY(155.0);
        Specialization.setStyle("-fx-text-fill: black;");

        Username.setLayoutX(270.0);
        Username.setLayoutY(155.0);
        Username.setStyle("-fx-text-fill: black;");

        Password.setLayoutX(525.0);
        Password.setLayoutY(155.0);

        salary2.setLayoutX(731.0);
        salary2.setLayoutY(155.0);
        salary2.setStyle("-fx-text-fill: black;");

        AppointmentFee.setLayoutX(39.0);
        AppointmentFee.setLayoutY(250.0);
        AppointmentFee.setStyle("-fx-text-fill: black;");

        OtherChages.setLayoutX(566.0);
        OtherChages.setLayoutY(250.0);
        OtherChages.setStyle("-fx-text-fill: black;");

        OperationFee.setLayoutX(295.0);
        OperationFee.setLayoutY(250.0);
        OperationFee.setStyle("-fx-text-fill: black;");

        Save.setLayoutX(889.0);
        Save.setLayoutY(342.0);
        Save.setMnemonicParsing(false);
        Save.setOnAction(this::SaveInfo);
        Save.setPrefHeight(53.0);
        Save.setPrefWidth(154.0);
        Save.setText("Save");

        Cancel.setLayoutX(645.0);
        Cancel.setLayoutY(342.0);
        Cancel.setMnemonicParsing(false);
        Cancel.setOnAction(this::backWindow);
        Cancel.setPrefHeight(53.0);
        Cancel.setPrefWidth(154.0);
        Cancel.setText("Cancel");

        pane.getChildren().add(UserLabel);
        pane.getChildren().add(Specialization);
        pane.getChildren().add(Username);
        pane.getChildren().add(Password);
        pane.getChildren().add(salary2);
        pane.getChildren().add(AppointmentFee);
        pane.getChildren().add(OtherChages);
        pane.getChildren().add(OperationFee);
        pane.getChildren().add(Save);
        pane.getChildren().add(Cancel);
        
        EmpPane.getChildren().add(pane);
        
        Specialization.setText(nDoc.Specialization);
Username.setText(nDoc.Username);
Password.setText(nDoc.password);
salary2.setText(String.format("%.2f",nDoc.salary));
AppointmentFee.setText(String.format("%.2f",nDoc.AppointmentFee));
OtherChages.setText(String.format("%.2f",nDoc.otherCharges));
OperationFee.setText(String.format("%.2f",nDoc.operataionFee));
    }

    private void setEmployee(Employee nDoc) {
       
    Fname.setText(nDoc.Fname);
    Lname.setText(nDoc.Lname);
    salary.setText(String.format("%.2f",nDoc.salary));
      email.setText(nDoc.email);
      address.setText(nDoc.address);
        contactInfo.setText(nDoc.contactInfo);
          Qualification.setText(nDoc.Qualification);
    }

    

private void ShowReceptionist(Receptionist nDoc) {
          int j=EmpPane.getChildren().size()-1;
       for(;j>0;j--)
           EmpPane.getChildren().remove(j);
   
   Pane pane=new Pane();
   
          UserLabel = new Label();
       // Specialization = new JFXTextField();
        Username = new JFXTextField();
        Password = new JFXPasswordField();
        salary2 = new JFXTextField();
        /*AppointmentFee = new JFXTextField();
        OtherChages = new JFXTextField();
        OperationFee = new JFXTextField();*/
        Save = new Button();
        Cancel = new Button();

       
//Specialization.setPromptText("Specialization");
Username.setPromptText("Username");
Password.setPromptText("Password");
salary2.setPromptText("salary");
//


        UserLabel.setAlignment(javafx.geometry.Pos.CENTER);
        UserLabel.setLayoutX(353.0);
        UserLabel.setLayoutY(95.0);
        UserLabel.setPrefHeight(46.0);
        UserLabel.setPrefWidth(292.0);
        UserLabel.setText("Receptionist");
        UserLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        UserLabel.setFont(new Font("Ebrima Bold", 24.0));

       /* Specialization.setLayoutX(39.0);
        Specialization.setLayoutY(155.0);
        Specialization.setStyle("-fx-text-fill: black;");*/

        Username.setLayoutX(270.0);
        Username.setLayoutY(155.0);
        Username.setStyle("-fx-text-fill: black;");

        Password.setLayoutX(525.0);
        Password.setLayoutY(155.0);

    //

        Save.setLayoutX(889.0);
        Save.setLayoutY(342.0);
        Save.setMnemonicParsing(false);
        Save.setOnAction(this::SaveInfo);
        Save.setPrefHeight(53.0);
        Save.setPrefWidth(154.0);
        Save.setText("Save");
 salary2.setLayoutX(731.0);
        salary2.setLayoutY(155.0);
        salary2.setStyle("-fx-text-fill: black;");
        Cancel.setLayoutX(645.0);
        Cancel.setLayoutY(342.0);
        Cancel.setMnemonicParsing(false);
        Cancel.setOnAction(this::backWindow);
        Cancel.setPrefHeight(53.0);
        Cancel.setPrefWidth(154.0);
        Cancel.setText("Cancel");

        
        
        
        
        pane.getChildren().add(UserLabel);
       // pane.getChildren().add(Specialization);
        pane.getChildren().add(Username);
        pane.getChildren().add(Password);
        pane.getChildren().add(salary2);
      //
       //
        pane.getChildren().add(Save);
        pane.getChildren().add(Cancel);
        
        EmpPane.getChildren().add(pane);
        
        salary2.setText(String.format("%.2f",nDoc.salary2));
Username.setText(nDoc.Username);
Password.setText(nDoc.password);
    }

  


}

