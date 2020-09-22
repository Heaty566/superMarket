/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import Database.ObjectDb;

/**
 *
 * @author heaty
 */
public abstract class Person extends ObjectDb {

    String name;
    protected String phone;
    String username;
    protected String password;
    protected double money;

    protected Person(String name, String username, String password, String phone) {
        super();
        this.username = username;
        this.money = 0;
        this.phone = phone;
        this.setPassword(password);
    }

    
    public abstract void register();
   public abstract Person login(String username, String password) throws Exception;

    protected String getPassword() {
        return this.password.replace(this.secretKey, "");
    }

    private void setPassword(String password) {
        this.password = password + this.secretKey;
    }

    protected void setMoney(double money) throws Exception {
        if (money < 0) {
            throw new Exception("Money can't be negative");
        }
        
        this.money = money;
    }




    public void update(String name, String phone) {
        this.phone = phone;
        this.name = name;
    }

    public void print() {
        System.out.println("-----Information-----");
        System.out.println("Name: " + this.name);
        System.out.println("Username: " + this.username);
        System.out.println("Money: " + this.money);
        System.out.println("Phone: " + this.phone);

    }

   

}
