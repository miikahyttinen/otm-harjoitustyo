package fi.ykkirjanpitosovellus.gui;
import fi.ykkirjanpitosovellus.logic.*;
import fi.ykkirjanpitosovellus.data.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.stage.FileChooser;
import java.io.File;




public class AccountingInterface extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Yksikertainen kirjanpito-ohjelma");
        Button newAccountingYearButton = new Button("Uusi tilikausi");
        FlowPane componentgroup = new FlowPane();
        Button openAccountYearButton = new Button("Avaa tilikausi");
        openAccountYearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser(window);
            }
        });
        componentgroup.getChildren().add(newAccountingYearButton);
        componentgroup.getChildren().add(openAccountYearButton);   
        Scene startscene = new Scene(componentgroup);
        
        window.setScene(startscene);
        window.show();       


        //Stage openAccountingYearStage = new Stage();
        //showAccountingYear(openAccountingYearStage, "test.csv");
    }
    
    public void fileChooser(Stage window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(window);
        String fileName = selectedFile.toString();
        showAccountingYear(window, fileName);
        
    }
    
    
    public void showAccountingYear(Stage window, String file) {
        
        AccountingYear year = new AccountingYear(file);
    	try {
        	year = AccountingData.readCsvFile(file);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        
        
        window.setTitle(year.getName());
        FlowPane componentsEntry = new FlowPane();
        Button newEntryButton = new Button("Uusi kirjaus");
        componentsEntry.getChildren().add(newEntryButton);
        String[] allEntries = year.allEntriesToString();
        for (String s : allEntries) {
            Label label = new Label(s);
            componentsEntry.getChildren().add(label);
        }
        String sum = "*** " + "Tulos: " + Integer.toString(year.countSumOfTheYear()) + " ***";
        Label labelSum = new Label(sum);
        componentsEntry.getChildren().add(labelSum);
        Scene entryScene = new Scene(componentsEntry);
        window.setScene(entryScene);
        window.show();
    }       
}

        
