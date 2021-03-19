/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import static hms.Store.UserType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Anas
 */
public class Doctor extends Employee {

    

   
    public int doc_id=0;
    public int emp_id=0;
    public String Specialization=null;
  public String  Username=null;
  public String  password=null;
  public double salary2=0.00;
  public int added_by=0;
  public double AppointmentFee=0.00;
  public double operataionFee=0.00;
  public double otherCharges=0.00;
  public LocalDateTime lastUpdated=null;

    public Doctor( String f, String l, String email, String ad, String contact, double salary, String Q,String S,String  U,String P,double s,double A,double o,double ot) {
        super(f, l, email, ad, contact, salary, Q);
        Specialization=S;
        Username=U;
        password=P;
        salary2=s;
        added_by=Store.User;
        AppointmentFee=A;
        operataionFee=o;
        otherCharges=ot;
        lastUpdated=LocalDateTime.now();
       
      
    }
    
    public Doctor( int id,int e_id,String f, String l, String email, String ad, String contact, double salary, String Q,String S,String  U,String P,double s,double A,double o,double ot) {
        super(f, l, email, ad, contact, salary, Q);
        doc_id=id;
        Specialization=S;
        Username=U;
        password=P;
        salary2=s;
        added_by=Store.User;
        AppointmentFee=A;
        operataionFee=o;
        otherCharges=ot;
        lastUpdated=LocalDateTime.now();
       emp_id=e_id;
      
    }
   
public static boolean AddDoctor(Doctor doc){
    try{
    
Connection con=server.GetConnection();
String query="insert into employee(Fname,Lname,email,[address],contactInfo,salary,Qualification)"+
        " Values('"+doc.Fname+"','"+doc.Lname+"','"+doc.email+"','"+doc.address+"','"+doc.contactInfo+"','"+doc.salary+"','"+doc.Qualification+"')";
con.createStatement().executeUpdate(query);
ResultSet res=con.createStatement().executeQuery("Select * from employee where email='"+doc.email+"'");
if(res!=null){
  if( res.next() ) {
       if(!res.getString("employee_id").isEmpty())
       {
           int le=Integer.parseInt(res.getString("employee_id"));
           LocalDateTime l=LocalDateTime.now();
         //  String str="convert(DATETIME,'"+l.format(DateTimeFormatter.ISO_DATE)+" "+l.format(DateTimeFormatter.ISO_TIME)+"')";
           String query2="insert into Doctor(Specialization,Username,[password],salary,added_by,employee,AppointmentFee,OperationFee,OtherCharges)"+
        " Values('"+doc.Specialization+"','"+doc.Username+"','"+doc.password+"','"+doc.salary2+"','"+doc.added_by+"','"+le+"','"+doc.AppointmentFee+"','"+doc.operataionFee+"','"+doc.otherCharges+"')";
    con.createStatement().executeUpdate(query2);
    return true;
       }
      //System.out.println(res.getString("password"));
               //return true;
            }
  return false;
}

}
    catch(SQLException se) {
        se.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    }
    
return false;

}

public static Doctor getDocById(int id){
     Doctor sample=new Doctor(id,id,"f","l","g","gh","450",56.3,"Gh","psychologist","anas","an2",45.3,65.2,8.9,1.0);
     try{
    
Connection con=server.GetConnection();
ResultSet res=con.createStatement().executeQuery("Select * from Doctor where doc_id='"+id+"'");
if(res!=null){
  if( res.next() ) {
       if(!res.getString("employee").isEmpty())
       { int in=Integer.parseInt(res.getString("employee"));
           String query2="Select * from employee where employee_id='"+in+"'";
           ResultSet res2= con.createStatement().executeQuery(query2);
           if(res2.next())
           { 
              String cInfo= res2.getString("contactInfo");
              Double s=Double.parseDouble(res2.getString("salary"));
              String Q= res2.getString("Qualification");
              String spe=res.getString("Specialization");
              String use=res.getString("Username");
              String pass=res.getString("password");
              Double sla=Double.parseDouble(res.getString("salary"));
              Double ap=Double.parseDouble(res.getString("AppointmentFee"));
              Double Ot=Double.parseDouble(res.getString("OtherCharges"));
              Double op=Double.parseDouble(res.getString("OperationFee"));
             
        sample=new Doctor(id,in,res2.getString("Fname"),res2.getString("Lname"),res2.getString("email"),res2.getString("address"),cInfo,s,Q,spe,use,pass,sla,ap,op,Ot);   
           
           
           }
       }
      //System.out.println(res.getString("password"));
               //return true;
            }
 // return false;
}

}
    catch(SQLException se) {
        se.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    }
   
    return sample;
}
    @Override
    public String toString() {
        return "Doctor{" + "doc_id=" + doc_id + ", Specialization=" + Specialization + ", Username=" + Username + ", password=" + password + ", salary=" + salary2 + ", added_by=" + added_by + ", AppointmentFee=" + AppointmentFee + ", operataionFee=" + operataionFee + ", otherCharges=" + otherCharges + ", lastUpdated=" + lastUpdated + '}';
    }

    Employee getEmployee() {
       return super.getMe();
       
    }
   public static boolean UpdateDoc(Doctor doc) {
       try{
    
Connection con=server.GetConnection();
String query="update Doctor "
        + "Specialization='"+doc.Specialization+"'"
        + ",Username='"+doc.Username+"'"
        + ",[password]='"+doc.password+"'"
        + ",salary="+doc.salary2
        + ",AppointmentFee="+doc.AppointmentFee
        + ",OperationFee="+doc.operataionFee
        + ",OtherCharges="+doc.otherCharges
        + " where where doc_id="+doc.doc_id
;
        con.createStatement().executeUpdate(query);

String query2="update employee Set "
        + "Fname'"+doc.Fname+"'"
        + ",Lname'"+doc.Lname+"'"
        + ",email'"+doc.email+"'"
        + ",[address]'"+doc.address+"'"
        + ",contactInfo"+doc.contactInfo
        + ",salary"+doc.salary
        + ",Qualification'"+doc.Qualification+"'"
        + " where where employee_id="+doc.emp_id
;
        con.createStatement().executeUpdate(query2);

        return true;
        
}
    catch(SQLException se) {
        se.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    }
    
       return false;
          }
   
   static Doctor getDocByAppointment(int id) {
       Doctor sample=new Doctor(id,id,"f","l","g","gh","450",56.3,"Gh","psychologist","anas","an2",45.3,65.2,8.9,1.0);
    return sample;
   }
    
}
