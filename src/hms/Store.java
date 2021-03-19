/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Label;

/**
 *
 * @author Anas
 */
class Store {
    public static String UserType=null;
public static int User=0;
public static String username=null;
    private static int Patient=0;
private static int Bill=0;
private static int Room=0;
private static int Meds=0;
private static int Appointment=0;
private static int Doc=0;
private static int Rec=0;
private static int Nurse=0;

    static void SetAllToBegin() {
 Patient=0;
Bill=0;
 Room=0;
 Meds=0;
Appointment=0;
 Doc=0;
Rec=0;
 Nurse=0;
    }
public static enum Selection {Add,View,Update,none};
 public static Selection Current=Selection.none;
public static enum Employee {Doctor,Reception,Nurse,none};
public static Employee ActiveEmployee=Employee.none;

    public static Selection getCurrent() {
        return Current;
    }

    public static void setCurrent(Selection Current) {
        Store.Current = Current;
    }

    public static Employee getActiveEmployee() {
        return ActiveEmployee;
    }

    public static void setActiveEmployee(Employee ActiveEmployee) {
        Store.ActiveEmployee = ActiveEmployee;
    }



public static int getRec() {
        return Rec;
    }

    public static int getNurse() {
        return Nurse;
    }

    public static void setNurse(int Nurse) {
        Store.Nurse = Nurse;
    }

    public static void setRec(int Rec) {
        Store.Rec = Rec;
    }
    public static int getPatient() {
        return Patient;
    }

    public static void setPatient(int Patient) {
        Store.Patient = Patient;
    }
public static boolean Login(String user,String pass){
if(user.isEmpty()|pass.isEmpty())
    return false;
 try{
    
Connection con=server.GetConnection();
ResultSet res=con.createStatement().executeQuery("Select * from "+UserType+" where Username='"+user+"'");
if(res!=null){
  if( res.next() ) {
      if(pass.equals(res.getString("password"))){
          LocalDateTime l=LocalDateTime.now();
          System.out.println(l.format(DateTimeFormatter.ISO_DATE)+" "+l.format(DateTimeFormatter.ISO_TIME));
          
           
               username=user;
          if(UserType=="admins"){
              User=Integer.parseInt(res.getString("admin_id"));
        con.createStatement().executeUpdate("update admins set LastLogin=convert(datetime,'"+l.format(DateTimeFormatter.ISO_DATE)+" "+l.format(DateTimeFormatter.ISO_TIME)+"') where admin_id='"+User+"'");
       
          }else if(UserType=="Receptionist"){
           User=Integer.parseInt(res.getString("rec_id"));
          }else if(UserType=="Doctor"){
          User=Integer.parseInt(res.getString("doc_id"));
           System.out.println("Success");
          }
             
               return true;
      }
      else return false;     
               
      //System.out.println(res.getString("password"));
               //return true;
            }
}

}
    catch(SQLException se) {
        se.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    } 

    
    return false;
}

public static void Logout(){

    User=0;
    username=null;
   
}

    static void setBill(int parseInt) {
        Bill=parseInt;
    }

    public static int getBill() {
        return Bill;
    }

    public static int getRoom() {
        return Room;
    }

    public static void setRoom(int Room) {
        Store.Room = Room;
    }

    public static int getMeds() {
        return Meds;
    }

    public static int getDoc() {
        return Doc;
    }

    public static void setDoc(int Doc) {
        Store.Doc = Doc;
    }

    public static void setMeds(int Meds) {
        Store.Meds = Meds;
    }

    public static int getAppointment() {
        return Appointment;
    }

    public static void setAppointment(int Appointment) {
        Store.Appointment = Appointment;
    }

    

    
}
