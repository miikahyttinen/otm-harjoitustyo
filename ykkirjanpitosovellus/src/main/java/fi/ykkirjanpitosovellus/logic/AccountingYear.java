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
    
    public AccountingYear(String name) {
        this.name = name;
        
    }
    

    public void addEntry(Entry entry) {
        int idAutomatic = this.entries.size() + 1;
        entry.setId(idAutomatic);
        entries.add(entry);      
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
    
    public Entry getEntry(int id) {
        return this.entries.get(id - 1);
    }
    
    public int getLastId() {
        return this.entries.size();
    }
    
    
    

    
    public String[] yearInfoToString() {
        String[] yearInfo = new String[7];
        yearInfo[0] = this.name;
        yearInfo[1] = Integer.toString(this.getStartDate()[0]);
        yearInfo[2] = Integer.toString(this.getStartDate()[1]);
        yearInfo[3] = Integer.toString(this.getStartDate()[2]);
        yearInfo[4] = Integer.toString(this.getEndDate()[0]);
        yearInfo[5] = Integer.toString(this.getEndDate()[1]);
        yearInfo[6] = Integer.toString(this.getEndDate()[2]);
        return yearInfo;
    }
    
    public String[] allEntriesToString() {
        String[] allEntries = new String[this.entries.size()];
        for (Entry e : this.entries) {
            int idInt = e.getId();
            String date = Integer.toString(e.getDate()[0]) + "." + Integer.toString(e.getDate()[1]) + "." + Integer.toString(e.getDate()[2]);
            String idString = Integer.toString(e.getId());
            String amount = Integer.toString(e.getAmount());            
            allEntries[idInt - 1] = " ID: "  + idString + " Nimi: " + e.getName() +  " Pvm: " + date + " Summa: " + amount + " Tyyppi: " + e.getType();
        }
        return allEntries;
    }
    
    public int countSumOfTheYear() {
        int sum = 0;
        for (Entry e : this.entries) {
            sum = sum + e.getAmount();
    	}
        return sum;
    }
            
}
