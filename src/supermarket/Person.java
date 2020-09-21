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
public class Person extends ObjectDb {
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

    private String getPassword() {
        return this.password.replace(this.secretKey, "");
    }

    private void setPassword(String password) {
        this.password = password + this.secretKey;
    }
    
    protected void setMoney(double money) throws Exception{
        if (money < 0) throw new Exception("Money can't be negative");
        this.password = password + this.secretKey;
    }

    public boolean isCorrectPassword(String password) {
        return this.getPassword().equals(password);
    }

    public int getToken() {
        return this._id;
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
