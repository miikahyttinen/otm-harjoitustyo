/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ykkirjanpitosovellus.logic;

/**
 *
 * @author yllapitaja
 */
public class AccountingService {
    
    public static int[] dateToIntArray(String dateString) {
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

