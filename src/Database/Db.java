/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import supermarket.*;


/**
 *
 * @author heaty
 */
public class Db {

//  public static Database<int> = new Database<int>();
    static public Database<Customer> customerDb = new Database<>();
    static public Database<Employee> employeeDb = new Database<>();
    static public Database<Product> productDb = new Database<>();

}
