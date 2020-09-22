/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import static Database.Db.*;
import java.util.*;

/**
 *
 * @author heaty
 */
public class SuperMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int command;

        //initialized database
        Customer cus1 = new Customer("pham vinh nhan", "heaty566", "123456", "013213213", "fpt uni");
        Customer cus2 = new Customer("pham vinh tai", "tai123", "123456", "013213213", "fpt uni");
        customerDb.insertOne(cus1);
        customerDb.insertOne(cus2);
        Employee cus3 = new Employee("nguyen thi ngoc thinh", "thinh123", "123456", "013213213", 2);
        Employee cus4 = new Employee("nguyen thi ngoc", "ngoc123", "123456", "013213213", 2);
        employeeDb.insertOne(cus3);
        employeeDb.insertOne(cus4);
        try {
            Product pro1 = new Product("dau an", 10.5, "netune", 50, "???");
            Product pro2 = new Product("dau goi", 16.5, "I dont know", 50, "???");
            Product pro3 = new Product("com", 7.5, "nha lam", 50, "???");
           
            productDb.insertOne(pro1);
            productDb.insertOne(pro2);
            productDb.insertOne(pro3);
           
        } catch (Exception err) {

            System.err.println(err);
        }
        //-----------------------------------------------------------------------

        do {
            System.out.println("");
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
                        commandOne();
                    } catch (Exception err) {
                        System.err.println(err);
                    }

                    break;
                case 2:
                    try {
                        commandTwo();
                    } catch (Exception err) {
                        System.err.println(err);
                    }

                    break;
                case 3:
                    commandThree();
                    break;
                case 4:
                    commandFour();
                    break;
                case 5:
                    commandFive();
                    break;
                case 6:
                    commandSix();
                    break;

            }

            if (command < 0 || command > 6) {
                System.err.println("Please enter correct command");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException err) {
                    System.err.println("Some thing wrong. App carsh");
                }

            }

        } while (command != 0);

    }

    public static void commandOne() throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Customer> customers = customerDb.getAll();
        int length = customerDb.count;
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

        if (currentCus != null) {
            customerMenu(currentCus.login(username, password));
        }

        throw new Exception("Invalid user");
    }

    public static boolean commandTwo() throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> employees = employeeDb.getAll();
        int length = employeeDb.count;
        String username;
        String password;

        System.out.print("Username :");
        username = scan.nextLine();

        System.out.print("Password :");
        password = scan.nextLine();

        Employee currentEmployee = null;

        for (int i = 0; i < length; i++) {
            if (employees.get(i).username.equals(username)) {
                currentEmployee = employees.get(i);
                break;
            }
        }

        if (currentEmployee != null) {
            employMenu(currentEmployee.login(username, password));
        }
        throw new Exception("Invalid user");
    }

    public static void commandThree() {
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
        newCus.register();

    }

    public static void commandFour() {
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

        Employee newEpl = new Employee(name, username, password, phone, 2.1);
        newEpl.register();

    }

    public static void commandFive() {
        ArrayList<Product> products = productDb.getAll();
        int length = productDb.count;

        if (length == 0) {
            System.out.println("Product is empty");
        }

        for (int i = 0; i < length; i++) {
            products.get(i).print();
        }
    }

    public static void commandSix() {
        ArrayList<Product> products = productDb.getAll();
        int length = productDb.count;

        if (length == 0) {
            System.out.println("Product is empty");
        }

        Scanner scan = new Scanner(System.in);
        String name;

        System.out.print("Name :");
        name = scan.nextLine();

        for (int i = 0; i < length; i++) {
            if (products.get(i).name.equals(name)) {
                products.get(i).print();
                break;
            }
        }
    }

    public static void customerMenu(Customer currentCustomer) {
        Scanner scanner = new Scanner(System.in);

        int commandCus = 0;

        do {
            System.out.println("");
            System.out.println("--------------------- Customer Menu ---------------------");
            System.out.println("Add money to your account - 1");
            System.out.println("Withdraw money from your account - 2");
            System.out.println("buy an item - 3");
            System.out.println("print acount information - 4");
            System.out.println("To exit - 0");
            System.out.print("Please enter your choice: ");
            commandCus = scanner.nextInt();

            switch (commandCus) {
                case 1:
                    commandCusOne(currentCustomer);
                    break;
                case 2:
                    commandCusTwo(currentCustomer);
                    break;
                case 3:
                    commandCusThree(currentCustomer);
                    break;
                case 4:
                    currentCustomer.print();
                    break;

            }

            if (commandCus < 0 || commandCus > 4) {
                System.err.println("Please enter correct command");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException err) {
                    System.err.println("Some thing wrong. App carsh");
                }

            }

        } while (commandCus != 0);
    }

    public static void commandCusOne(Customer cus) {
        Scanner scan = new Scanner(System.in);
        double money;

        System.out.print("Enter money to deposit:");
        money = scan.nextDouble();

        try {
            cus.deposit(money);
        } catch (Exception err) {
            System.err.println(err);
        }
    }

    public static void commandCusTwo(Customer cus) {
        Scanner scan = new Scanner(System.in);
        double money;

        System.out.print("Enter money to withdraw:");
        money = scan.nextDouble();

        try {
            cus.withDraw(money);
        } catch (Exception err) {
            System.err.println(err);
        }

    }

    public static void commandCusThree(Customer cus) {
        ArrayList<Product> products = productDb.getAll();
        int length = productDb.count;

        Scanner scan = new Scanner(System.in);
        String name;
        Product pro = null;

        System.out.print("Name :");
        name = scan.nextLine();
        System.out.println(name);

        for (int i = 0; i < length; i++) {
            if (products.get(i).name.equals(name)) {
                pro = products.get(i);
                break;
            }
        }

        try {

            pro.takeOne();
            cus.buyOne(pro);
        } catch (Exception err) {
            System.err.println(err);
        }

    }

    public static void employMenu(Employee currentEmployee)  {
        Scanner scanner = new Scanner(System.in);

        int commandEpl = 0;

        do {
            System.out.println("");
            System.out.println("--------------------- Employee Menu ---------------------");
            System.out.println("print salary - 1");
            System.out.println("Add one product - 2");
            System.out.println("Update one product - 3");
            System.out.println("Delete one product - 4");
            System.out.println("To exit - 0");
            System.out.print("Please enter your choice: ");
            commandEpl = scanner.nextInt();
            try {
            switch (commandEpl) {
                case 1:
                    System.out.println("Your salary: " + currentEmployee.calculateSalary());
                    break;
                case 2:
                   
                    currentEmployee.addOneProduct();
                    break;
                case 3:
                    currentEmployee.updateOneProduct();
                    break;
                case 4:
                    currentEmployee.deleteProduct();
                    break;

            }} catch (Exception err) {
                System.err.println(err);
            }

            if (commandEpl < 0 || commandEpl > 4) {
                System.err.println("Please enter correct command");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException err) {
                    System.err.println("Some thing wrong. App carsh");
                }

            }

        } while (commandEpl != 0);
    }
}
