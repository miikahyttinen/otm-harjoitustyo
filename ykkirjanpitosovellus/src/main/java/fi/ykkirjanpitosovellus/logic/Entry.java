package fi.ykkirjanpitosovellus.logic;
import java.util.*;

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
    private int[] date;

    public Entry(String name_user, int[] date_user, int amount_user, String type_user) {
        this.name = name_user; 
        this.date = date_user;
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
    
    public void setDate(int[] date_user) {
        this.date = date_user;
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
    
    public int[] getDate(){
        return this.date;
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


