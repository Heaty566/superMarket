/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author heaty
 */
public class ObjectDb {

    public final String secretKey = "mySecret";
    public int _id = this.idGenerator();

    private int lastId = 0;

    private int idGenerator() {
        this.lastId++;
        return this.lastId++;
    }
}
