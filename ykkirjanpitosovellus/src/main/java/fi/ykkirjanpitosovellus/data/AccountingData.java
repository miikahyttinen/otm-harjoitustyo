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
    
    public static void  writeNewCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName() + ".csv"));
        StringBuilder sb = new StringBuilder();
        for (int id = 1; id <= year.getLastId(); id++) {
            sb.append(year.getEntry(id).getId());
            sb.append(';');
            sb.append(year.getEntry(id).getName());
            sb.append(';');
            sb.append(year.getEntry(id).dateToString());
            sb.append(';');
            sb.append(year.getEntry(id).getAmount());
            sb.append(';');
            sb.append(year.getEntry(id).getType());
            sb.append('\n');          
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
        
    }
    
        public static void  writeExsistingCsvFile(AccountingYear year) throws FileNotFoundException {       
        PrintWriter pw = new PrintWriter(new File(year.getName()));
        StringBuilder sb = new StringBuilder();
        for (int id = 1; id <= year.getLastId(); id++) {
            sb.append(year.getEntry(id).getId());
            sb.append(';');
            sb.append(year.getEntry(id).getName());
            sb.append(';');
            sb.append(year.getEntry(id).dateToString());
            sb.append(';');
            sb.append(year.getEntry(id).getAmount());
            sb.append(';');
            sb.append(year.getEntry(id).getType());
            sb.append('\n');          
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
        
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
                    System.out.println("invalid data::" + data);
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
        String day = new String();
        String month = new String();
        String year = new String();
        int i = 0;
        int dotCounter = 0;
        while (i < dateString.length()) {
            Character c = dateString.charAt(i);
            if (Character.isDigit(c) && dotCounter == 0) {
                day = day + c;
                i++;
            }
            if (Character.isDigit(c) && dotCounter == 1) {
                month = month + c;
                i++;
            } 
            if (Character.isDigit(c) && dotCounter == 2) {
                year = year + c;
                i++;
            }
            if (!Character.isDigit(c)) {
                dotCounter++;
                i++;
            }
        }
        dateArray[0] = Integer.parseInt(day);
        dateArray[1] = Integer.parseInt(month);
        dateArray[2] = Integer.parseInt(year);
        return dateArray;
    }                  
}    

