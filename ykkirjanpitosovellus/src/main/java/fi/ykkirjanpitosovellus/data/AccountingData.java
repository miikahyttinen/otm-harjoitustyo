package fi.ykkirjanpitosovellus.data;
import fi.ykkirjanpitosovellus.logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.lang.IllegalArgumentException;

/**
 *Class writes and reads accounting data from and to CSV-files.
 *
 */

public class AccountingData {
    
    public AccountingData() {
        
    }
    /**
    *Method creates and writes a new CSV-file.
    *
    *@param year AccountingYear named with user's input when creating a new accounting year. 
    * 
    *@return Returns name of the file.
    * 
    *@throws FileNotFoundException if file is not in the direcotry where program was run.
    */
    
    public static String writeNewCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName() + ".csv"));
        StringBuilder sb = new StringBuilder();
        pw.write(AccountingAlgorithms.csvToString(year));
        pw.close();
        return year.getName() + ".csv";
    }
    
    /**
    *Method writes to an exsisitng CSV-file.
    *
    *@param year AccountingYear which is under processing f.ex. when adding a new entry. 
    * 
    *@throws FileNotFoundException if fiel is not in the direcotry where program was run.
    */
    
    public static void  writeExsistingCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName()));
        pw.write(AccountingAlgorithms.csvToString(year));
        pw.close();
    }
    
    /**
    *Method deletes an entry from CSV file and rewrites it.
    *
    *@param fileName Name of the CSV-file.
    *
    *@param id Integer, id of the entry wished to be removed.
    * 
    *@throws FileNotFoundException if file is not in the direcotry where program was run.
    *@throws IOException if I/O fails
    *@throws IllegalArgumentException if user input is not valid. 
    */

    
    public static void removeEntryCsvFile(int id, String fileName) throws FileNotFoundException, IOException, IllegalArgumentException {
        AccountingYear year = readCsvFile(fileName);     
        if (AccountingValidators.validateYearId(year, id)) {
            year.removeEntry(id);
            writeExsistingCsvFile(year);
        }
    }
    
    /**
    *Method reads data from an exsisitng CSV-file.
    *
    *@param fileName Name of the CSV-file which user chooses with a file chooser(GUI).
    * 
    *@return AccountingYear readed from CSV-file.  
    * 
    *@throws FileNotFoundException if file is not in the direcotry where program was run.
    *@throws IOException if I/O fails
    */
            
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
    
    /**
    *Method converts a string to an int array where [0] = date, [1] = month, [2] = year.
    *
    *@param dateString users input in form DD.MM.YYYY.
    * 
    *@return dateArray int array where [0] = date, [1] = month, [2] = year.
    */

    public static int[] dateToIntArray(String dateString) {
        int[] dateArray = new int[3];
        dateArray[0] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[0]);
        dateArray[1] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[1]);
        dateArray[2] = Integer.parseInt(AccountingAlgorithms.parseDate(dateString)[2]);
        return dateArray;
    }                  
}    

