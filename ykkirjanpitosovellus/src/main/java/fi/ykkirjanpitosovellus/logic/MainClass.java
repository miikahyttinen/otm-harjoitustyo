package fi.ykkirjanpitosovellus.logic;
import fi.ykkirjanpitosovellus.gui.AccountingInterface;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

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
        
        launch(AccountingInterface.class);

    }
    
    
        
}
    

    

