/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.*;
import static Database.Db.customerDb;

/**
 *
 * @author heaty
 */
public class Customer extends Person {

    String shippingAddress;
    int[] cartIds = new int[100];

    public Customer(String name, String username, String password, String phone, String shippingAdress) {
        super(name, username, password, phone);
        this.shippingAddress = shippingAdress;
    }

    @Override
    public void register() {
        customerDb.insertOne(this);
        System.out.println("Register success");
    }

    @Override
    public Customer login(String username, String password) throws Exception {

        if (this.username.equals(username) && this.getPassword().equals(password)) {
            return this;
        }

        throw new Exception("Invlid user");
    }

    public void update(String name, String phone, String shippingAddress) {
        this.phone = phone;
        this.name = name;
        this.shippingAddress = shippingAddress;
    }

    public void deposit(double money) throws Exception {
        this.setMoney(money);
        System.out.println("Deposit success");
    }

    public void withDraw(double money) throws Exception {
        if (this.money < money) {
            throw new Exception("Overload amount. Please try again");
        }

        this.setMoney(this.money - money);
        System.out.println("Withdraw success");
    }

    public void buyOne(Product pro) throws Exception {
        if (this.money < pro.price) {
            throw new Exception("Overload amount. Please try again");
        }

        this.setMoney(this.money - pro.price);
        System.out.println("Thank you");
    }

    @Override
    public void print() {
        System.out.println("-----Information-----");
        System.out.println("Name: " + this.name);
        System.out.println("Username: " + this.username);
        System.out.println("Money: " + this.money);
        System.out.println("Phone: " + this.phone);
        System.out.println("Address: " + this.shippingAddress);
    }

}
