package fi.ykkirjanpitosovellus.data;
import fi.ykkirjanpitosovellus.logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;


public class AccountingData {
    
    public AccountingData() {
        
    }
    
    public static String writeNewCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName() + ".csv"));
        StringBuilder sb = new StringBuilder();
        pw.write(AccountingAlgorithms.csvToString(year));
        pw.close();
        return year.getName() + ".csv";
    }
    
    public static void  writeExsistingCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName()));
        pw.write(AccountingAlgorithms.csvToString(year));
        pw.close();
    }
    
        
    
    public static AccountingYear readCsvFile(String fileName) throws FileNotFoundException, IOException {
        
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        Scanner scanner = null;
	int index = 0;
	AccountingYear yearCsv = new AccountingYear(fileName);
        int[] nullDate = {0, 0, 0};
        while ((line = reader.readLine()) != null) {
            Entry entryCsv = new Entry("test", nullDate, 0, "0");
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {
                    entryCsv.setId(Integer.parseInt(data));
                } else if (index == 1)  {
                    entryCsv.setName(data);
                } else if (index == 2) {
                    entryCsv.setDate(dateToIntArray(data));
                } else if (index == 3) {
                    entryCsv.setAmount(Integer.parseInt(data));
                } else if (index == 4) {
                    entryCsv.setType(data);
                } else {
                    System.out.println("invalid data:" + data);
                }
                index++;
            }
            index = 0;
            yearCsv.addEntry(entryCsv);
        }
        reader.close();
        return yearCsv;        
    }

    public static int[] dateToIntArray(String dateString) {
        int[] dateArray = new int[3];
        dateArray[0] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[0]);
        dateArray[1] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[1]);
        dateArray[2] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[2]);
        return dateArray;
    }                  
}    

