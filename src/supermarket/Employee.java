/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import static Database.Db.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author heaty
 */
public class Employee extends Person {

    final double baseSalary = 1000000;
    private double salary;

    public Employee(String name, String username, String password, String phone, double salary) {
        super(name, username, password, phone);
        this.salary = salary;
    }

    @Override
    public void register() {
        employeeDb.insertOne(this);
        System.out.println("Register success");
    }

    @Override
    public Employee login(String username, String password) throws Exception {
        ArrayList<Employee> db = employeeDb.getAll();
        int length = employeeDb.count;

        for (int i = 0; i < length; i++) {
            if (db.get(i).username.equals(username) && db.get(i).getPassword().equals(password)) {
                return this;
            }

        }

        throw new Exception("Invlid user");
    }

    public void addOneProduct() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int commandEpl = 0;

        do {
            System.out.println("");
            System.out.println("--------------------- Add Product Menu ---------------------");
            System.out.println("Add Pc - 1");
            System.out.println("Add Food - 2");
            System.out.println("To exit - 0");
            System.out.print("Please enter your choice: ");
            commandEpl = scanner.nextInt();

            switch (commandEpl) {
                case 1:
                    Pc newPc = createNewPc();
                    productDb.insertOne(newPc);
                    System.out.println("Pc added");
                    break;
                case 2:
                    Food newFood = createNewFood();
                    productDb.insertOne(newFood);
                    System.out.println("Food added");
                    break;

            }
            if (commandEpl < 0 || commandEpl > 2) {
                System.err.println("Please enter correct command");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException err) {
                    System.err.println("Some thing wrong. App carsh");
                }

            }

        } while (commandEpl != 0);
    }

    private Product findOneProductByName() {
        ArrayList<Product> products = productDb.getAll();
        int length = productDb.count;

        System.out.print("Name :");
        String name = new Scanner(System.in).nextLine();

        for (int i = 0; i < length; i++) {
            if (products.get(i).name.equals(name)) {
                return products.get(i);

            }
        }

        return null;
    }

    public void restockOne() throws Exception {
        System.out.print("Amount :");
        int amount = new Scanner(System.in).nextInt();

        this.findOneProductByName().restock(amount);
    }

    public void updateOneProduct() {
        this.findOneProductByName().update();
    }

    public void deleteProduct() {
       this.findOneProductByName().delete();

    }

    private Pc createNewPc() throws Exception {

        String name;
        double price;
        String madeBy;
        String description;
        int amount;
        String cpu;
        int ram;
        int rom;

        System.out.print("Enter product's name: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Enter product's price: ");
        price = new Scanner(System.in).nextDouble();
        System.out.print("Enter product's madeBy: ");
        madeBy = new Scanner(System.in).nextLine();
        System.out.print("Enter product's description: ");
        description = new Scanner(System.in).nextLine();
        System.out.print("Enter product's amount: ");
        amount = new Scanner(System.in).nextInt();
        System.out.print("Enter product's Cpu: ");
        cpu = new Scanner(System.in).nextLine();
        System.out.print("Enter product's Ram: ");
        ram = new Scanner(System.in).nextInt();
        System.out.print("Enter product's Rom: ");
        rom = new Scanner(System.in).nextInt();

        return new Pc(name, price, madeBy, amount, description, cpu, ram, rom);
    }

    private Food createNewFood() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name;
        double price;
        String madeBy;
        String description;
        int amount;

        int expired;
        String quality;

        System.out.print("Enter product's name: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Enter product's price: ");
        price = new Scanner(System.in).nextDouble();
        System.out.print("Enter product's madeBy: ");
        madeBy = new Scanner(System.in).nextLine();
        System.out.print("Enter product's description: ");
        description = new Scanner(System.in).nextLine();
        System.out.print("Enter product's amount: ");
        amount = new Scanner(System.in).nextInt();
        System.out.print("Enter product's Expired days: ");
        expired = new Scanner(System.in).nextInt();
        System.out.print("Enter product's quality: ");
        quality = new Scanner(System.in).nextLine();

        return new Food(name, price, madeBy, amount, description, expired, quality);
    }

    public double calculateSalary() {
        return this.salary * this.baseSalary;
    }

}
