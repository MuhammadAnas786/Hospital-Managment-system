/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   
  
    @FXML
    private JFXButton Login;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private Label confirmation;
@FXML
private ImageView Back;

    @FXML
    void backWindow(MouseEvent event) {
 try {
                 
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Main.fxml")));
                    stage.setScene(scene);
                    stage.show();
        
    } catch(Exception e) {
        e.printStackTrace();
    } 
    }

    @FXML
   public  void click(ActionEvent event) {
       if(event.getSource()==Login && !((username.getText()).isEmpty()) &&!((pass.getText()).isEmpty()))
{
   System.out.println( username.getText());
    if(Store.Login(username.getText(),pass.getText())){
      System.out.println("Hello");
    GetMainWindow(event); 
    
    
    }
    
    else
        confirmation.setText("Invalid Credentials");
}
       else
        confirmation.setText("Empty fields");
       
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void GetMainWindow(ActionEvent event) {
             try {
                 if(Store.User!=0){
             Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("welcome.fxml")));
                    stage.setScene(scene);
                    stage.show();}
        
    } catch(Exception e) {
        e.printStackTrace();
    }
  }

}
