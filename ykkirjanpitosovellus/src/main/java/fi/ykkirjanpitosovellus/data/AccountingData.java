package fi.ykkirjanpitosovellus.data;
import fi.ykkirjanpitosovellus.logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class AccountingData {
    
    public AccountingData() {
        
    }
    
    public void  writeCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName()+".csv"));
        StringBuilder sb = new StringBuilder();
        for (int id = 1; id <= year.getLastId(); id++) {
            sb.append(year.getEntry(id).getId());
            sb.append(',');
            sb.append(year.getEntry(id).getName());
            sb.append(',');
            sb.append(year.getEntry(id).dateToString());
            sb.append(',');
            sb.append(year.getEntry(id).getAmount());
            sb.append(',');
            sb.append(year.getEntry(id).getType());
            sb.append('\n');          
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
        
    }

    
    
    public void readCsvFile () {
        
    }
    
    public int[] parseDate(String row) {
        int[] date = new int[3];
        return date;
    }    
    
}
