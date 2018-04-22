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

    public Entry(String name, int[] date, int amount, String type) {
        this.name = name; 
        this.date = date;
        this.amount = amount;
        this.type = type;
    }
    
    //Setters
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDate(int[] date) {
        this.date = date;
    }
    
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setType(String type) {
        this.type = type;
    }
  
    
    public int getId() {
        return this.id;
    }
    
    public int[] getDate() {
        return this.date;
    }
    
    public String dateToString()  {
        String dd = Integer.toString(this.date[0]);
        String mm = Integer.toString(this.date[1]);
        String yy = Integer.toString(this.date[2]);
        return dd + "." + mm + "." + yy;
    }   
    
    
    public String getName() {
        return this.name;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public String getType() {
        return this.type;
    }
           
}


