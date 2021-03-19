/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class RoomsController implements Initializable {
         private String DisplayNames[]={
          "Ahmad","nmfsg"
      };
    private int userNames[]={
        1,2
    };
   
    private int count;
    /**
     * Initializes the controller class.
     */    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane KnowPain;

    @FXML
    private Label Hospital;

    @FXML
    private JFXButton Add;

    @FXML
    private Label user_name;

    @FXML
    private ImageView Back;

    @FXML
    private JFXTextField search;

    @FXML
    private JFXButton SearchBut;

    @FXML
    private JFXButton refresh;
 @FXML
    void backWindow(MouseEvent event) {
        PrevWindow(event);
    }
    @FXML
    void click(ActionEvent event) {
        Window owner = SearchBut.getScene().getWindow();
if(event.getSource()==Add){
AddWindow(event);
}else if(event.getSource()==refresh){
 GetPatientWindow(event);
}else if(event.getSource()==SearchBut){
  if(search.getText().isEmpty()){
                   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Empty field ");
  return ;}
  
   int val=-1;
for(int i=0;i<DisplayNames.length;i++){
if(DisplayNames[i].equals(search.getText())){
    val=i;break;
}

}
  if(val==-1){
                   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!","No such friend ");
  return ;}
int u[]=new int[1];
String d[]=new String[1];
u[0]=userNames[val];
d[0]=DisplayNames[val];
setFriends(u,d);
}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setFriends(userNames,DisplayNames);
 //ShowPeopleOnList( SemesterProject.GetSuggestionsFriends().length,DisplayNames,userNames);
        
    }    

    
      private void setFriends(int[] use,String[] display){

          count=use.length;
        DisplayNames=new String[count];
       userNames =new int[count];
     for(int i=0;i<count;i++){
        System.out.println(count);
     System.out.println(use[i]);
       System.out.println( display[i]);
         DisplayNames[i]=display[i];
         userNames[i]=use[i];
        }
      ShowPeopleOnList(count,DisplayNames,userNames);
    }
    
    
    private void ShowPeopleOnList(int size,String[] displayNames,int [] Users){
        System.out.println("ShowPeopleOnList");
   int j=KnowPain.getChildren().size()-1;
       for(;j>0;j--)
           KnowPain.getChildren().remove(j);
       
      final Pane pane[];
     final ImageView imageView[];
     final Label label[];
     final Label label0[];
     final JFXButton jFXButton[];
     final JFXButton jFXButton0[]; 
     
    pane=new Pane[size];
    imageView=new ImageView[size];
    label=new Label[size];
  label0=new Label[size];
  jFXButton=new JFXButton[size];
    jFXButton0=new JFXButton[size];
    
    for(int i=0;i<size;i++){
        
     pane[i] = new Pane();
        imageView[i] = new ImageView();
        label[i] = new Label();
        label0[i] = new Label();
        jFXButton[i] = new JFXButton();
        jFXButton0[i] = new JFXButton();

        
/*      [i].getStyleClass().add();
        [i].getStylesheets().add("/Driver/stylesheets.css");*/
        
        
        pane[i].setLayoutX(0);
        pane[i].setLayoutY( (i*90)+150 );
        pane[i].setPrefHeight(87.0);
        pane[i].setPrefWidth(785.0);
        pane[i].getStyleClass().add("FriendsPian");
        pane[i].getStylesheets().add("/hms/stylesheets.css");
     

        imageView[i].setFitHeight(61.0);
        imageView[i].setFitWidth(53.0);
        imageView[i].setLayoutX(14.0);
        imageView[i].setLayoutY(13.0);
        imageView[i].setPickOnBounds(true);
        imageView[i].setPreserveRatio(true);
        imageView[i].setImage(new Image(getClass().getResource("user-128.png").toExternalForm()));

    label[i].setLayoutX(82.0);
        label[i].setLayoutY(14.0);
        label[i].setPrefHeight(23.0);
        label[i].setPrefWidth(124.0);
        label[i].setText(displayNames[i]);
        label[i].setFont(new Font("Ebrima Bold", 14.0));

        label0[i].setLayoutX(78.0);
        label0[i].setLayoutY(35.0);
        label0[i].setPrefHeight(17.0);
        label0[i].setPrefWidth(132.0);
        label0[i].setText(String.valueOf(Users[i]));
        label0[i].setFont(new Font(10.0));

        jFXButton[i].setLayoutX(687.0);
        jFXButton[i].setLayoutY(20.0);
        jFXButton[i].setText("Edit");
        jFXButton[i].setStyle(" -fx-text-fill: black; -fx-border-color: #1A4F86;");
        jFXButton[i].getStyleClass().add("btnAdd");
        jFXButton[i].getStylesheets().add("/hms/stylesheets.css");
        jFXButton[i].addEventFilter(ActionEvent.ACTION, eventHandler);
        jFXButton[i].setCursor(Cursor.HAND);

        jFXButton0[i].setLayoutX(594.0);
        jFXButton0[i].setLayoutY(20.0);
        jFXButton0[i].setText("View");
        jFXButton0[i].setStyle(" -fx-text-fill: black; -fx-border-color: #1A4F86;");
        jFXButton0[i].getStyleClass().add("btnAdd");
        jFXButton0[i].getStylesheets().add("/hms/stylesheets.css");
        jFXButton0[i].addEventFilter(ActionEvent.ACTION, eventHandler);
        jFXButton0[i].setCursor(Cursor.HAND);

        pane[i].getChildren().add(imageView[i]);
        pane[i].getChildren().add(label[i]);
        pane[i].getChildren().add(label0[i]);
        pane[i].getChildren().add(jFXButton[i]);
        pane[i].getChildren().add(jFXButton0[i]);
        
        KnowPain.getChildren().add(pane[i]);
    }
       System.out.println("Done iterating");
    }

    
 EventHandler<ActionEvent> eventHandler=new EventHandler<ActionEvent>(){
           @Override
          public void handle(ActionEvent event) {
            
             if (event.getSource() instanceof JFXButton){
              
             JFXButton buta=(JFXButton)event.getSource();
            
              
                   Pane p=(Pane)buta.getParent();
                    Label lab=(Label)p.getChildren().get(2);
                 Store.setRoom(Integer.parseInt(lab.getText()));
                 System.out.println(Store.getPatient());
                  if(buta.getText()=="View"){
                 ViewWindow(event);
               }
                 else if(buta.getText().equals("Edit"))
                 { EditWindow(event);
                 }
               
               
             }    
          }

          
            };
  private void EditWindow(ActionEvent event) {
             try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Edit.fxml")));
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
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AddP.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }}
    
     private void ViewWindow(ActionEvent event) {
         try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ViewP.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    }}

    private void PrevWindow(MouseEvent event) {
       
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
    
  

    private void GetPatientWindow(ActionEvent event) {
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
    } 
    }

}
