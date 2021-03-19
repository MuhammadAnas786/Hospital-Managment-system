/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;


/**
 *
 * @author Anas
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class server {
    private static Connection con=null;
  public static Connection connect(Window owner) throws ClassNotFoundException{ 

   

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=HMS;user=admin;password=Anas2792"; 

    try{

    con=DriverManager.getConnection(connectionURL);
    System.out.println("Connection is successfull");

    }

    catch(SQLException e){

     AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Database Error!","Try restarting");
               return con;

    }
        return con;
    }
  
  public static Connection GetConnection(){
  if(con!=null)
  return con;
  

  return con;
  }
}
