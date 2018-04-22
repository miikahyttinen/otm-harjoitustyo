package fi.ykkirjanpitosovellus.data;
import fi.ykkirjanpitosovellus.logic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;




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
    
        
    
    public AccountingYear ReadCSVWithScanner(String fileName) throws FileNotFoundException {

		// open file input stream
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
		// read file line by line
	String line = null;
	Scanner scanner = null;
	int index = 0;
	AccountingYear yearCsv = new AccountingYear(fileName);

	while ((line = reader.readLine()) != null) {
		Entry entryCsv = new Entry();
                scanner = new Scanner(line);
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String data = scanner.next();
			if (index == 0)
			emp.setId(Integer.parseInt(data));
				else if (index == 1)
                                    emp.setName(data);
				else if (index == 2)
                                    emp.setRole(data);
				else if (index == 3)
                                    emp.setSalary(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			empList.add(emp);
		}
		
		//close reader
		reader.close();
		
		System.out.println(empList);

    public int[] dateToIntArray(String dateString) {
        int[] dateArray = new int[3];
        String day = new String();
        String month = new String();
        String year = new String();
        int i = 0;
        int dotCounter = 0;
        while (i<dateString.length()) {
            Character c = dateString.charAt(i);
            if(Character.isDigit(c) && dotCounter == 0) {
                day = day + c;
                i++;
            }
            if (Character.isDigit(c) && dotCounter == 1) {
                month = month + c;
                i++;
            } 
            if(Character.isDigit(c) && dotCounter == 2) {
                year = year + c;
                i++;
            }
            if(!Character.isDigit(c)) {
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

