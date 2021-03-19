/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Anas
 */
public class HMS extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        System.out.println("in start");
        stage.show();
    Window owner=stage.getScene().getWindow();
    Connection con=server.connect(owner);
    
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("in main");
        launch(args);
       Connection con=server.GetConnection();
       con.close();
         
    }
    
}
/*
 try{
Connection con=server.GetConnection();
ResultSet res=con.createStatement().executeQuery("Select*from admins");
if(res!=null){
  while ( res.next() ) {
                String id = res.getString("admin_id");
                String fn=res.getString("Fname");
                String ln=res.getString("Lname");
                String user =res.getString("Username");
                String email=res.getString("email");//address
                String ad=res.getString("address");
                String Info=res.getString("contactInfo");
                String pass=res.getString("password");
                String create=res.getString("Created_at");
                System.out.println(id+" "+fn+" "+ ln+" "+user+" "+email+" "+ad+" "+Info+" "+pass+" "+create);
            }
}

}
    catch(SQLException se) {
        se.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    } 
         

*/