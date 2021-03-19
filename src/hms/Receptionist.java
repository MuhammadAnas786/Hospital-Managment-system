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

/**
 *
 * @author Anas
 */
public class Receptionist extends Employee {
    public int doc_id=0;
    public String Specialization=null;
  public String  Username=null;
  public String  password=null;
  public double salary2=0.00;
  public int added_by=0;
  public int emp_id=0;
  public LocalDateTime lastUpdated=null;
  public Receptionist( String f, String l, String email, String ad, String contact, double salary, String Q,String  U,String P,double s) {
        super(f, l, email, ad, contact, salary, Q);
        
        Username=U;
        password=P;
        salary2=s;
        added_by=Store.User;
       
        lastUpdated=LocalDateTime.now();
       
      
    }
    
    public Receptionist( int id,int emp,String f, String l, String email, String ad, String contact, double salary, String Q,String  U,String P,double s) {
        super(f, l, email, ad, contact, salary, Q);
        doc_id=id;
        
        Username=U;
        password=P;
        salary2=s;
        added_by=Store.User;
     emp_id=emp;
        lastUpdated=LocalDateTime.now();
    }
     
    public static boolean AddReceptionist(Receptionist doc){
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
           String query2="insert into Receptionist(Username,[password],salary,added_by,employee)"+
        " Values('"+doc.Username+"','"+doc.password+"','"+doc.salary2+"','"+doc.added_by+"','"+le+"')";
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
public static void AddReceptionist( String f, String l, String email, String ad, String contact, double salary, String Q,String  U,String P,double s)
{}


public static Receptionist getRecById(int id){
Receptionist sample=new Receptionist(id,id,"ahmad","ali","ahmad@","54 clover lane st","23",343.3,"managment","ad","wdq",44.5);
       try{
    
Connection con=server.GetConnection();
ResultSet res=con.createStatement().executeQuery("Select * from Doctor where rec_id='"+id+"'");
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
 
              String use=res.getString("Username");
              String pass=res.getString("password");
              Double sla=Double.parseDouble(res.getString("salary"));

             
        sample=new Receptionist(id,in,res2.getString("Fname"),res2.getString("Lname"),res2.getString("email"),res2.getString("address"),cInfo,s,Q,use,pass,sla);   
           
           
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
        return "Receptionist{" + "doc_id=" + doc_id + ", Specialization=" + Specialization + ", Username=" + Username + ", password=" + password + ", salary=" + salary + ", added_by=" + added_by + ", lastUpdated=" + lastUpdated + '}';
    }
   

    Employee getEmployee() {
       return super.getMe();
       
    }
   public static boolean UpdateReceptionist(Receptionist doc) {
       try{
    
Connection con=server.GetConnection();
String query="update Receptionist "
        + ",Username='"+doc.Username+"'"
        + ",[password]='"+doc.password+"'"
        + ",salary="+doc.salary2
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
   
    
}
