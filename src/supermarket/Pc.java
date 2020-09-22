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
public class Pc extends Product {

    public String cpu;
    public int ram;
    public int rom;

    public Pc(String name, double price, String madeBy, int amount, String description, String cpu, int ram, int rom) throws Exception {
        super(name, price, madeBy, amount, description);
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
    }

    
    @Override
    public void print() { 
        System.out.println("---------Product information--------------");
        System.out.println("Name:" + this.name);
        System.out.println("Price:" + this.price);
        System.out.println("Made By:" + this.madeBy);
        System.out.println("Description:" + this.description);
        System.out.println("Amount:" + this.amount);
        System.out.println("---------Pc information--------------");
        System.out.println("Cpu:" + this.cpu);
        System.out.println("Ram:" + this.ram + " GBs");
        System.out.println("Rom:" + this.rom + " GBs");
    }
}
