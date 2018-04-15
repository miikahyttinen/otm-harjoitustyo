package fi.ykkirjanpitosovellus.logic;
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
    
    public void setName(String name) {
        this.name = name;
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
    
    public String getName() {
        return this.name;
    }
    
    public int[] getStartDate() {
        return this.startdate;
    }
    
    public int[] getEndDate() {
        return this.enddate;
    }
    
    public Entry getEntry(int i) {
        return this.entries.get(i-1);
    }
    
    
    

    
    public String[] yearInfoToString() {
        String[] year_info = new String[7];
        year_info[0] = this.name;
        year_info[1] = Integer.toString(this.getStartDate()[0]);
        year_info[2] = Integer.toString(this.getStartDate()[1]);
        year_info[3] = Integer.toString(this.getStartDate()[2]);
        year_info[4] = Integer.toString(this.getEndDate()[0]);
        year_info[5] = Integer.toString(this.getEndDate()[1]);
        year_info[6] = Integer.toString(this.getEndDate()[2]);
        return year_info;
    }
    
    public String[] allEntriesToString() {
        String[] all_entries = new String[this.entries.size()];
        for (Entry e : this.entries) {
            int id_int = e.getId();
            String date = Integer.toString(e.getDate()[0])+ "." + Integer.toString(e.getDate()[1]) + "." + Integer.toString(e.getDate()[2]);
            String id_string = Integer.toString(e.getId());
            String amount = Integer.toString(e.getAmount());            
            all_entries[id_int-1] = "ID: " + id_string + "Date: " + date + " Name: " + e.getName() + " Amount: " + amount + " Type: " + e.getType();
            }
        return all_entries;
    }
    
        
}
