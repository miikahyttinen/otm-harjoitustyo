/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ykkirjanpitosovellus.logic;

/**
 *In this class, user input validators are implemented. 
 *
 */
public class AccountingValidators {
    
    public AccountingValidators() {
        
    }
    
/**
 *Method checks that date input from user is correct, there some flex in input. 
 * 
 *@param date User input like DD.MM.YYYY.  
 * 
 *@return Returns true if date is in form DD.MM.YYYY, false otherwise. 
 */
    
    public static boolean validateStringDate(String date) throws IllegalArgumentException {
        if (date.length() > 10 || date.length() < 8) {
            throw new IllegalArgumentException("Anna päivämäärä muodossa DD.YY.MMMM");
        }
        for (char  c : date.toCharArray()) {            
            if (!(Character.isDigit(c) || c == '/' || c == '.' || c == ',')) {
            throw new IllegalArgumentException("Anna päivämäärä muodossa DD.YY.MMMM");
            }
        }
        return true;
    }
    
    public static boolean validateStringName(String name) throws IllegalArgumentException {
        if(name.length() > 50) {
            throw new IllegalArgumentException("Tilikauden nimen pituus on max. 50 merkkiä");
        }
        return true;
    }
}


        


