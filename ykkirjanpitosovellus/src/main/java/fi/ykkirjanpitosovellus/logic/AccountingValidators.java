package fi.ykkirjanpitosovellus.logic;
import java.lang.NumberFormatException;

/**
 *In this class, user input validators are implemented. 
 *
 */
public class AccountingValidators {
    
    public AccountingValidators() {
        
    }
    
/**
 *Method checks that date input from user is correct. 
 * 
 *@param date User input like DD.MM.YYYY.  
 * 
 *@return Returns true if date is in form DD.MM.YYYY, throws exception otherwise.
 */
    
    public static boolean validateStringDate(String date) throws IllegalArgumentException {
        if (date.length() != 10) {
            throw new IllegalArgumentException("Anna päivämäärä muodossa DD.MM.YYYY");
            }
        for(int i = 0; i<date.length(); i++) 
            if(i == 2 || i == 4) {
                if (date.charAt(i) != '.') {
                    throw new IllegalArgumentException("Anna päivämäärä muodossa DD.MM.YYYY");
                }
            } else {
               if (!Character.isDigit(date.charAt(i))) {
                    throw new IllegalArgumentException("Anna päivämäärä muodossa DD.MM.YYYY"); 
               }
            }
        for (char c : date.toCharArray())   {
            if (!Character.isDigit(c) && c != '.') {
                throw new IllegalArgumentException("Anna päivämäärä muodossa DD.MM.YYYY");           
            }
        }
        return true;  
    }
    
/**
 *Method checks that string is under 50 char. 
 * 
 *@param name User input as a string.
 * 
 *@return Returns true if string is under 50 char long, throws exception otherwise.
 */

    
    public static boolean validateStringName(String name) throws IllegalArgumentException {
        if(name.length() > 50) {
            throw new IllegalArgumentException("Tilikauden nimen pituus on max. 50 merkkiä");
        }
        return true;
    }
    
/**
 *Method checks that user input id of a entry is valid. 
 * 
 *@param id Id as an integer.
 * 
 *@return Returns true if corresponding id 
 */
    
    public static boolean validateYearId(AccountingYear year, int id) throws IllegalArgumentException {
        if (year.getEntries().isEmpty()) {
            throw new IllegalArgumentException("Tilikaudella ei ole yhtään kirjausta");
            }
        if (year.getEntries().size() < id || id < 1) {
            throw new IllegalArgumentException("ID:tä vastaava kirjausta ei löydy");
            }
        return true;     
    }
   

    public static int validateStringId(String id) throws NumberFormatException {
        int idParsed = Integer.parseInt(id);
        return idParsed;
    }
 }

        


