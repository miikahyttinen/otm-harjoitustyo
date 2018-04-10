/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ykkirjanpitosovellus;
import java.util.*;
/**
 *
 * @author yllapitaja
 */
public class AccountingYear {
    
    private String name;
    private int[] startdate = new int[3];
    private int[] enddate = new int[3];
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    
    public AccountingYear(String name_user) {
        this.name = name_user;
        
    }
    

    public void addEntry(Entry entry_user) {
        int id_automatic = this.entries.size()+1;
        entry_user.setId(id_automatic);
        entries.add(entry_user);
        
    }
    
    public void setStartDate(int date []) {
       this.startdate[0] = date[0]; //Setting DD 
       this.startdate[1] = date[1]; //Setting MM
       this.startdate[2] = date[2]; //Setting MM 
    }
    
    public void setEndDate(int date []) {
       this.enddate[0] = date[0]; //Setting DD 
       this.enddate[1] = date[1]; //Setting MM
       this.enddate[2] = date[2]; //Setting MM 
    }
    
    public int[] getStartDate() {
       return this.startdate;
    }
    
    public Entry getEntry(int i) {
        return this.entries.get(i-1);
    }
    
    public int[] getEndDate() {
       return this.enddate;
    }

    public String[] allEntriesToString() {
        String[] all_entries = new String[this.entries.size()+1];
        for (Entry e : this.entries) {
            int id_int = e.getId();
            String id_string = Integer.toString(e.getId());
            String amount = Integer.toString(e.getAmount());            
            all_entries[id_int-1] = "ID: " + id_string + " Name: " + e.getName() + " Amount: " + amount + " Type: " + e.getType();
            }
        return all_entries;
    }
    
        
}
