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
        Button createNewAccountingYearButton = new Button("Uusi tilikausi");
        FlowPane componentgroup = new FlowPane();
        Button openExsistingAccountYearButton = new Button("Avaa tilikausi");
        componentgroup.getChildren().add(createNewAccountingYearButton);
        componentgroup.getChildren().add(openExsistingAccountYearButton);   
        Scene startscene = new Scene(componentgroup);
        
        window.setScene(startscene);
        window.show();
        
        //Testidata
        AccountingYear accountingYearTest = new AccountingYear("Rotsin tilikausi");
        int[] start = {01, 01, 2018};
        int[] end = {01, 12, 2018};
        accountingYearTest.setStartDate(start);
        accountingYearTest.setEndDate(end);
        int[] date1 = {1, 2, 2018};
        Entry entry1 = new Entry("Testikirjaus1", date1 , 300, "Tulo");
        accountingYearTest.addEntry(entry1);
        int[] date2 = {3, 2, 2018};
        Entry entry2 = new Entry("Testikirjaus2", date2 , -200, "Kulu");
        accountingYearTest.addEntry(entry2);
        int[] date3 = {14, 2, 2018};
        Entry entry3 = new Entry("Testikirjaus3", date3 , 350, "Vuokratulo");
        accountingYearTest.addEntry(entry3);
        String[] yearInfo = accountingYearTest.yearInfoToString();
        String[] allEntries = accountingYearTest.allEntriesToString();
        //Testidata
        
        Stage openAccountingYearStage = new Stage();
        showAccountingYear(openAccountingYearStage, accountingYearTest);
    }
    
    
    public void showAccountingYear(Stage window, AccountingYear year) {

        window.setTitle(year.getName());
        FlowPane componentgroup = new FlowPane();
        Button newEntryButton = new Button("Uusi kirjaus");
        componentgroup.getChildren().add(newEntryButton);
        String[] allEntries = year.allEntriesToString();
        for (String s : allEntries) {
            Label label = new Label(s);
            componentgroup.getChildren().add(label);
        }
        Scene startScene = new Scene(componentgroup);
        window.setScene(startScene);
        window.show();
    }       
}

        
