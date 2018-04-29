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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;



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
        newEntryButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                newEntry(window, file);
            }
        });   
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
    
    public void newEntry(Stage window, String file) {
        window.setTitle("Uusi kirjaus tilikaudelle: " + file);
        
        GridPane newEntryComponents = new GridPane();
        newEntryComponents.setAlignment(Pos.BASELINE_LEFT);
        newEntryComponents.setHgap(10);
        newEntryComponents.setVgap(10);
        newEntryComponents.setPadding(new Insets(25, 25, 25, 25));
        
        Label labelName = new Label("Kirjauksen kuvaus");
        Label labelDate = new Label("Anna päivämäärä muodossa DD.MM.YYYY");
        Label labelAmount = new Label("Summa");
        Label labelType = new Label("Kirjauksen tyyppi");
        
        
        TextField nameField = new TextField();
        TextField dateField = new TextField();
        TextField amountField = new TextField();
        TextField typeField = new TextField();
           
        newEntryComponents.add(labelName, 0, 1);
        newEntryComponents.add(nameField, 0, 2);
        
        newEntryComponents.add(labelDate, 1, 1);
        newEntryComponents.add(dateField, 1, 2);
        
        newEntryComponents.add(labelAmount, 2, 1);
        newEntryComponents.add(amountField, 2, 2);
        
        newEntryComponents.add(labelType, 3, 1);
        newEntryComponents.add(typeField, 3, 2);

        Button addEntryButton = new Button("Lisää kirjaus");
        newEntryComponents.add(addEntryButton, 4, 2);
        addEntryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccountingYear year = new AccountingYear(file);
                try {
        	year = AccountingData.readCsvFile(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Tiedostoa ei löydy");
                } catch (IOException e) {
                    System.out.println("IO Exception");
                }
                String entryName = nameField.getText();
                int[] entryDate = AccountingData.dateToIntArray(dateField.getText());
                int entryAmount = Integer.parseInt(amountField.getText());
                String entryType = typeField.getText();
                Entry newEntry = new Entry(entryName, entryDate, entryAmount, entryType);
                year.addEntry(newEntry);
                try {
        	AccountingData.writeExsistingCsvFile(year);
                } catch (FileNotFoundException e) {
                    System.out.println("Tiedostoa ei löydy");
                } catch (IOException e) {
                    System.out.println("IO Exception");
                }
                showAccountingYear(window, file);
            }
        });               
        
        
        Scene newEntryScene = new Scene(newEntryComponents);
        window.setScene(newEntryScene);
        
        window.show();
    }
}

        
