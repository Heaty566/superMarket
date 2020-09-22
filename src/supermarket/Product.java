/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import static Database.Db.productDb;
import Database.ObjectDb;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void takeOne() throws Exception {
        if (this.amount <= 0) {
            throw new Exception("Out of stock");
        }

        setAmount(--this.amount);
    }

    public void print() {
        System.out.println("---------Product information--------------");
        System.out.println("Name:" + this.name);
        System.out.println("Price:" + this.price);
        System.out.println("Made By:" + this.madeBy);
        System.out.println("Description:" + this.description);
        System.out.println("Amount:" + this.amount);
    }

    public void restock(int amount) throws Exception {
        this.setAmount(this.amount + amount);
    }

    ;

    public void update() {
    
        String name;
        double price;
        String madeBy;
        String description;

        System.out.println("----Update Product");
        System.out.print("Name:");
        name = new Scanner(System.in).nextLine();
        System.out.print("Price:");
        price = new Scanner(System.in).nextDouble();
        System.out.print("MadeBy:");
        madeBy = new Scanner(System.in).nextLine();
        System.out.print("Description:");
        description = new Scanner(System.in).nextLine();
        this.name = name;
        this.price = price;
        this.madeBy = madeBy;
        this.description = description;
        
            System.out.println("");
               System.out.println("**** update success ******");
    }

    protected void delete() {
        ArrayList<Product> products = productDb.getAll();
        int length = productDb.count;

        for (int i = 0; i < length; i++) {
            if (products.get(i).name.equals(this.name)) {
                products.remove(i);
                break;
            }
        }
        productDb.count--;
        System.out.println("");
        System.out.println("**** Delete success ******");
        

    }

}
