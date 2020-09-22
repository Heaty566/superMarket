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
public class Food extends Product {

    public int expiredDays;
    public String quality;

    public Food(String name, double price, String madeBy, int amount, String description, int expiredDays, String quality) throws Exception {
        super(name, price, madeBy, amount, description);
        this.expiredDays = expiredDays;
        this.quality = quality;
    }

    @Override
    public void print() {
        System.out.println("---------Product information--------------");
        System.out.println("Name:" + this.name);
        System.out.println("Price:" + this.price);
        System.out.println("Made By:" + this.madeBy);
        System.out.println("Description:" + this.description);
        System.out.println("Amount:" + this.amount);
        System.out.println("---------Food information--------------");
        System.out.println("Expired in:" + this.expiredDays);
        System.out.println("Quality:" + this.quality);
    }

}
