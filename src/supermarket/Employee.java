/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;
import static Database.Db.b;
/**
 *
 * @author heaty
 */
public class Employee extends Person{
    
    
    final double baseSalary = 1000000;
    private double salary;

    public Employee(String name, String username, String password, String phone, String shippingAdress, double salary) {
        super(name, username, password, phone);
        this.salary = salary;
    }
    
    public double calculateSalary () {
        return b;
//           return this.salary * this.baseSalary; 
           
 
    }
    
}
