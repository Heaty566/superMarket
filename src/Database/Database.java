/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.*;

/**
 *
 * @author heaty
 */
public class Database<T extends ObjectDb> {

    private ArrayList<T> repository = new ArrayList<T>(1000);
   public int count = 0;

    public void insertOne(T obj) {
        this.repository.add(obj);
        count++;
  
    }

    private int findIndex(int _id) throws IndexOutOfBoundsException {
        for (int i = 0; i < count; i++) {
            if (this.repository.get(i)._id == _id) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException("Obj with the given id was not found");
    }

    public void updateOneById(int _id, T obj) {
        int index = this.findIndex(_id);
        this.repository.set(index, obj);
    }

    public void deleteOneById(int _id) {
        int index = this.findIndex(_id);
        this.repository.remove(index);
        count--;
    }

    public ArrayList<T> getAll() {
        return this.repository;
    }

    public T findOneById(int _id) {
        int index = this.findIndex(_id);
        return this.repository.get(index);
    }

}
