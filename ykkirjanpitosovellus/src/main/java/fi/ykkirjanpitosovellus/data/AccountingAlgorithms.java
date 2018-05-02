package fi.ykkirjanpitosovellus.data;
import java.io.BufferedReader;
import fi.ykkirjanpitosovellus.logic.*;
/**
 *In this calss, some of the algorithms which are needed in the processing of data, are implemented.
 *
 */
public class AccountingAlgorithms {
    
    public AccountingAlgorithms() {
        
    }
 /**
 *This method will convert the data of accounting year to a form suitable for writing to CSV-file
 *
 *@param year AccountingYear as parameter.
 * 
 *@return Method returns all the data of an accouting year as one long string with delimter ";". Rows are marked with "\n".
 */
    
    public static String csvToString(AccountingYear year) {
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
    	return sb.toString();
    }
    
    /**
    *This method/algorithm will convert user input into a string array where day, month and year is seperated.
    *
    *@param dateString Input from the user as DD.MM.YYYY. Also form D.M.YYYY works also and different different delimters.
    * 
    *@return Method return a string array where date, month and year is seperated.
    */
    
    public static String[] parseDate(String dateString) {
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
        String[] date = {day, month, year};
        return date;
    }
}
