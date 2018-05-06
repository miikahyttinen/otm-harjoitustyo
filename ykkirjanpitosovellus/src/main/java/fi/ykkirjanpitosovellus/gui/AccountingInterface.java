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
        newAccountingYearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newAccountingYear();
            }
        });
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
        showAccountingYear(fileName);
        
    }
    
    
    public void showAccountingYear(String file) {
        Stage showYearWindow = new Stage();
        AccountingYear year = new AccountingYear(file);
    	try {
        	year = AccountingData.readCsvFile(file);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
		showYearWindow.setTitle(year.getName());
        FlowPane componentsEntry = new FlowPane();
        Button newEntryButton = new Button("Uusi kirjaus");
        newEntryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newEntry(file, showYearWindow);               
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
        showYearWindow.setScene(entryScene);
        showYearWindow.show();
    }
    
    public void newAccountingYear() {       
        Stage newYearWindow = new Stage();
        newYearWindow.setTitle("Luo uusi tilikasui");        
        GridPane newYearComponents = new GridPane();
        
        newYearComponents.setAlignment(Pos.BASELINE_LEFT);
        newYearComponents.setHgap(10);
        newYearComponents.setVgap(10);
        newYearComponents.setPadding(new Insets(25, 25, 25, 25));
        
        Label labelName = new Label("Tilikauden nimi");
        Label labelDateStart = new Label("Tilikauden alkamispäivämäärä (muodossa DD.MM.YYYY)");
        Label labelDateEnd = new Label("Tilikauden päättymispäivä (muodossa DD.MM.YYYY)");
        
        TextField nameField = new TextField();
        TextField dateStartField = new TextField();
        TextField dateEndField = new TextField();
        
        newYearComponents.add(labelName, 0, 1);
        newYearComponents.add(nameField, 0, 2);
        
        newYearComponents.add(labelDateStart, 1, 1);
        newYearComponents.add(dateStartField, 1, 2);
        
        newYearComponents.add(labelDateEnd, 2, 1);
        newYearComponents.add(dateEndField, 2, 2);
        
        Button newYearButton = new Button("Luo uusi tilikausi");
        newYearComponents.add(newYearButton, 0, 3);
        newYearButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String fileName = nameField.getText();
                try {
                    AccountingValidators.validateStringName(fileName);  
                } catch (IllegalArgumentException e) {
                    UserInputErrors.userInputError(e);
                }
                AccountingYear year = new AccountingYear(fileName);
                
                String dateStart = dateStartField.getText();
                String dateEnd = dateEndField.getText();
                try {
                    AccountingValidators.validateStringDate(dateStart);
                    AccountingValidators.validateStringDate(dateStart);
                } catch (IllegalArgumentException e) {
                    UserInputErrors.userInputError(e);
                }
                
                int[] startDate = AccountingData.dateToIntArray(dateStart);
                int[] endDate = AccountingData.dateToIntArray(dateEnd);
                year.setStartDate(startDate);
                year.setEndDate(endDate);
            	try {
                	fileName = AccountingData.writeNewCsvFile(year); // Returns name of the new file as a string              
                } catch (FileNotFoundException e) {
                    System.out.println("Tiedostoa ei löydy");
                } catch (IOException e) {
                    System.out.println("IO Exception");
                }
                showAccountingYear(fileName);
                newYearWindow.close();
            }
        }); 
        
        Scene newYearScene = new Scene(newYearComponents);
        newYearWindow.setScene(newYearScene);
        
        newYearWindow.show();
        
        
    }
    
    public void newEntry(String file, Stage showYearWindow) {
        Stage newEntryWindow = new Stage();
        newEntryWindow.setTitle("Uusi kirjaus tilikaudelle: " + file);
        
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
                
                String entryStringDate = dateField.getText();                
                
                try {
                AccountingValidators.validateStringDate(entryStringDate);
                } catch (IllegalArgumentException e) {
                    UserInputErrors.userInputError(e);
                }
                        
                int[] entryDate = AccountingData.dateToIntArray(entryStringDate);
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
                showAccountingYear(file);
                newEntryWindow.close();
                showYearWindow.close();
            }
        });               
        
        
        Scene newEntryScene = new Scene(newEntryComponents);
        newEntryWindow.setScene(newEntryScene);
        
        newEntryWindow.show();
    }
}

        
