/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ykkirjanpitosovellus;

/**
 *
 * @author yllapitaja
 */
public class Entry {

    private int id; //Unique id for every entry
    private String name; //Name of the accounting entry 
    //private String info; // Extra information TODO
    private int amount; //Amount of entry
    private String type; //Type of entry: accounting and taxing terms

    public Entry(String name_user, int amount_user, String type_user) {
        this.name = name_user; 
        this.amount = amount_user;
        this.type = type_user;
    }
    
    //Setters
    
    public void setId(int id_user) {
        this.id = id_user;
    }
    
    public void setName(String name_user) {
        this.name = name_user;
    }
    
    public void setAmount(int amount_user) {
        this.amount = amount_user;
    }
    
    public void setType(String type_user) {
        this.type = type_user;
    }
  
    
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public String getType() {
        return this.type;
    }
           
}


