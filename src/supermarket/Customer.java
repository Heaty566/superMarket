/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

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

    public void update(String name, String phone, String shippingAddress) {
        this.phone = phone;
        this.name = name;
        this.shippingAddress = shippingAddress;
    }

    public void deposit(double money) throws Exception {
        this.setMoney(money);
    }
    
    public void withDraw(double money) throws Exception{
        if (this.money < money) throw new Exception("Overload amount. Please try again");
        
        this.setMoney(money);
    
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
