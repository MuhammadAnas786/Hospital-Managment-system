/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Anas
 */
public class patients {

  

   
      public int pat_id=0;
 public String Fname=null;
 public String Lname=null;
 public String address=null;
 public LocalDate DOB=null;
 public String Gender=null;
 public int doctor=0;
 public String doctorName=null;
 public String assign_type=null;
 public int Floor=0;
 public int Room=0;
 public LocalDate dat=null;
 public LocalTime tim=null;
 public int Receptionist_id=0;
public  LocalDateTime lastUpdated=null;

    public patients(String f,String l,String ad,LocalDate dob,String g,String doc,int floor,int Room, LocalDate datum,LocalTime timum,String ty) {
        Fname=f;Lname=l;address=ad;DOB=dob;Gender=g;doctorName=doc;
        Receptionist_id=Store.User;lastUpdated=LocalDateTime.now();
        Floor=floor;Room=Room;assign_type=ty;
        dat=datum;tim=timum;
    }
    
    public patients(int id,String f,String l,String ad,LocalDate dob,String g,String doc,int floor,int Room, LocalDate datum,LocalTime timum,String ty) {
        Fname=f;Lname=l;address=ad;DOB=dob;Gender=g;
        Receptionist_id=Store.User;lastUpdated=LocalDateTime.now();pat_id=id;Floor=floor;Room=Room;doctorName=doc;
         dat=datum;tim=timum;assign_type=ty;
    }
    
    public static patients getPatById(int id){
    patients sample=new patients(id,"anas","ikram","house895",LocalDate.now(),"male","ali",4,4,LocalDate.now(),LocalTime.now(),"appointment");
    return sample;
    }
     static patients getPatByAppointment(int id) {
        patients sample=new patients(id,"anas","ikram","house895",LocalDate.now(),"male","ali",4,4,LocalDate.now(),LocalTime.now(),"appointment");
    return sample;
     
     }
       static boolean Addpatient(patients newDoc) {
        return true; 
       
       
       }

    static boolean UpdatePatient(patients newDoc) {
        return true;   }

}
