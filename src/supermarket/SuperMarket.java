/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author heaty
 */
public class SuperMarket {

     static  Database<Customer> test = new Database<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        int token;
        Database<Customer> customerDb = new Database<>();

        Customer newCus = new Customer("pham vinh nhan", "heaty566", "123456", "013213213", "fpt uni");
        customerDb.insertOne(newCus);

        do {

            System.out.println("--------------------- Supermaket App ---------------------");
            System.out.println("Menu -----------");
            System.out.println("Login for customer - 1");
            System.out.println("Login for employee - 2");
            System.out.println("register for customer - 3");
            System.out.println("register for employee - 4");
            System.out.println("Print all product - 5");
            System.out.println("Print product by name - 6");
            System.out.println("To exit - 0");

            System.out.print("Please enter your choice: ");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    try {
                        token = commandOne(customerDb);
                        System.out.println("Login sucess");
                    } catch (Exception err) {
                        System.out.println(err);
                    }

                    break;

                case 3:
                    Customer newCustomer = commandThree();
                    customerDb.insertOne(newCustomer);
                    break;
            }

            if (command < 0 || command > 4) {
                System.err.println("Please enter correct command");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException err) {
                    System.err.println("Some thing wrong. App carsh");
                }

            }

        } while (command != 0);

    }

    public static int commandOne(Database db) throws Exception {
        ArrayList<Customer> customers = db.getAll();
        int length = db.count;
        Scanner scan = new Scanner(System.in);
        String username;
        String password;

        System.out.print("Username :");
        username = scan.nextLine();

        System.out.print("Password :");
        password = scan.nextLine();

        Customer currentCus = null;

        for (int i = 0; i < length; i++) {

            if (customers.get(i).username.equals(username)) {
                currentCus = customers.get(i);
                break;
            }
        }

        if (currentCus != null && currentCus.isCorrectPassword(password)) {
            return currentCus.getToken();
        }
        throw new Exception("Invalid user");
    }

    public static Customer commandThree() {
        Scanner scan = new Scanner(System.in);
        String name;
        String username;
        String password;
        String phone;
        String shippingAdress;

        System.out.println("Please enter your information");
        System.out.print("Name :");
        name = scan.nextLine();

        System.out.print("Username :");
        username = scan.nextLine();

        System.out.print("Password :");
        password = scan.nextLine();

        System.out.print("phone :");
        phone = scan.nextLine();

        System.out.print("Shipping Adress:");
        shippingAdress = scan.nextLine();

        Customer newCus = new Customer(name, username, password, phone, shippingAdress);

        System.out.println("Register Success.");
        return newCus;
    }
}
