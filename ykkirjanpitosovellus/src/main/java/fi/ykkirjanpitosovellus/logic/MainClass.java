package fi.ykkirjanpitosovellus.logic;
import fi.ykkirjanpitosovellus.data.AccountingData;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //System.out.println("Accounting year: " + yearinfo[0]);
        //System.out.println("Begninnning of the year: " + yearinfo[1] + "." + yearinfo[2] + "." + yearinfo[3]);
        //System.out.println("End of the year: " + yearinfo[4] + "." + yearinfo[5] + "." + yearinfo[6]);
        //for (String entry : allentries) {
        //    System.out.println(entry);
        /*AccountingYear accountingYearTest = new AccountingYear("Rotsin tilikausi");
        int[] start = {01, 01, 2018};
        int[] end = {01, 12, 2018};
        accountingYearTest.setStartDate(start);
        accountingYearTest.setEndDate(end);
        int[] date1 = {1, 2, 2018};
        Entry entry1 = new Entry("Testikirjaus1", date1 , 300, "Tulo");
        accountingYearTest.addEntry(entry1);
        int[] date2 = {3, 2, 2018};
        Entry entry2 = new Entry("Testikirjaus2", date2 , -200, "Kulu");
        accountingYearTest.addEntry(entry2);
        int[] date3 = {14, 2, 2018};
        Entry entry3 = new Entry("Testikirjaus3", date3 , 350, "Vuokratulo");
        accountingYearTest.addEntry(entry3);
        
        /*AccountingData test = new AccountingData();
        try {        
            test.writeCsvFile(accountingYearTest);
        } catch (FileNotFoundException e) {
            System.out.println("Virhe!");
        }*/
        
        //launch(AccountingInterface.class);
        
        int[] date = AccountingService.dateToIntArray("13.12.2019");
        System.out.print(date[2]);
        

    }
    
    
        
}
    

    

