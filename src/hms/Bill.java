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
public class Bill {

   

    static boolean AddBil(Bill newDoc) {
       return true; }

    static Bill getBillById(int id) {
        Bill sample=new Bill(id,45.3,65.2,8.9,1.0,23,65);
    return sample;
    }
    public int Bill_id=0;

 public double tax=0;
 public int appointment_id=0;
 public double HospitalFee=0;
 public double RoomCharges=0;
 public double otherCharges=0.00;
 public double total=0.00;
 public double DocFee=0.00;
 public int Receptionist_id=0;
public  LocalDateTime lastUpdated=null;
    
public Bill(double t,double h,double d,double r,double o,double to){
tax=t;
HospitalFee=h;
RoomCharges=r;DocFee=d;
otherCharges=o;
total=to;
Receptionist_id=Store.User;
lastUpdated=LocalDateTime.now();
appointment_id=Store.getAppointment();
}
public Bill(int id,double t,double h,double d,double r,double o,double to){
tax=t;Bill_id=id;
HospitalFee=h;
appointment_id=Store.getAppointment();
RoomCharges=r;
otherCharges=o;DocFee=d;
total=to;
Receptionist_id=Store.User;
lastUpdated=LocalDateTime.now();
}


}
