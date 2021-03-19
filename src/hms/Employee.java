/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.LocalDateTime;

/**
 *
 * @author Anas
 */
public class Employee {
 public int employee_id=0;
 public String Fname=null;
 public String Lname=null;
 public String email=null;
 public String address=null;
 public String contactInfo=null;
 public double salary=0.00;
 public String Qualification=null;
 //public LocalDateTime Created_at=null;

    public Employee(String f,String l,String emai,String ad,String contact,double salary,String Q) {
       Fname=f;Lname=l;email=emai;address=ad;contactInfo=contact;
       salary=salary;Qualification=Q;
       /*Created_at=LocalDateTime.now();
       System.out.println(Created_at);*/
        
    }
    public Employee(Employee e){
        
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_id=" + employee_id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", address=" + address + ", contactInfo=" + contactInfo + ", salary=" + salary + ", Qualification=" + Qualification + '}';
    }

    Employee getMe() {
       return this;
    }
 
 
 
}
