package fi.ykkirjanpitosovellus.gui;
import fi.ykkirjanpitosovellus.logic.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class AccountingInterface extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Yksikertainen kirjanpito-ohjelma");
        Button create_newaccountingyear_button = new Button("Uusi tilikausi");
        FlowPane componentgroup = new FlowPane();
        Button open_exsistingaccountyear_button = new Button("Avaa tilikausi");
        componentgroup.getChildren().add(create_newaccountingyear_button);
        componentgroup.getChildren().add(open_exsistingaccountyear_button);   
        Scene startscene = new Scene(componentgroup);
        
        window.setScene(startscene);
        window.show();
        
        //Testidata
        AccountingYear accountingyeartest = new AccountingYear("Rotsin tilikausi");
        int[] start = {01, 01, 2018};
        int[] end = {01, 12, 2018};
        accountingyeartest.setStartDate(start);
        accountingyeartest.setEndDate(end);
        int[] date1 = {1, 2, 2018};
        Entry entry1 = new Entry("Testikirjaus1", date1 , 300, "Income");
        accountingyeartest.addEntry(entry1);
        int[] date2 = {3, 2, 2018};
        Entry entry2 = new Entry("Testikirjaus2", date2 , -200, "Expense");
        accountingyeartest.addEntry(entry2);
        int[] date3 = {14, 2, 2018};
        Entry entry3 = new Entry("Testikirjaus3", date3 , 350, "Rental income");
        accountingyeartest.addEntry(entry3);
        String[] yearinfo = accountingyeartest.yearInfoToString();
        String[] allentries = accountingyeartest.allEntriesToString();
        //Testidata
        
        Stage open_accountingyear_satge = new Stage();
        showAccountingYear(open_accountingyear_satge, accountingyeartest);
    }
    
    
    public void showAccountingYear (Stage window, AccountingYear user_year) {

        window.setTitle(user_year.getName());
        FlowPane componentgroup = new FlowPane();
        Button newentry_button = new Button("Uusi kirjaus");
        componentgroup.getChildren().add(newentry_button);
        String[] all_entries = user_year.allEntriesToString();
        for (String s : all_entries) {
            Label label = new Label(s);
            componentgroup.getChildren().add(label);
        }
        Scene startscene = new Scene(componentgroup);
        window.setScene(startscene);
        window.show();
    }
        
}

        
