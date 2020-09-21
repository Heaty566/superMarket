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
public class Product extends ObjectDb {

    String name;
    double price;
    String madeBy;
    int amount;
    String description;

    public Product(String name, double price, String madeBy, int amount, String description) throws Exception {
        this.name = name;
        this.price = price;
        this.madeBy = madeBy;
        this.description = description;
        setAmount(amount);
    }

    public void setAmount(int amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount can't be negative");
        }
        this.amount = amount;
    }

    public void print() {
        System.out.println("---------Product information--------------");
        System.out.println("Name:" + this.name);
        System.out.println("Price:" + this.price);
        System.out.println("Made By:" + this.madeBy);
        System.out.println("Description:" + this.description);
        System.out.println("Amount:" + this.amount);
    }

    public void update(String name, double price, String madeBy, String description) {
        this.name = name;
        this.price = price;
        this.madeBy = madeBy;
        this.description = description;
    }

}
