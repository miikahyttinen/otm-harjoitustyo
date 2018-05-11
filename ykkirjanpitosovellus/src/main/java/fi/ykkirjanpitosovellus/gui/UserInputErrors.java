package fi.ykkirjanpitosovellus.gui;
import java.lang.IllegalArgumentException;
import fi.ykkirjanpitosovellus.logic.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *This class handles excpetion thrown because of the wrong user inputs.
 *
 */
public class UserInputErrors {
    
    public UserInputErrors() {
        
    }
    
    /**
    *Method opens a new window when user gives a false input. 
    *
    *@param e IllegalArgumentException
    */   
    
    public static void userInputError(IllegalArgumentException e) {
        Stage errorWindow = new Stage();
        GridPane errorComponents = new GridPane();
        errorComponents.setAlignment(Pos.BASELINE_LEFT);
        errorComponents.setHgap(10);
        errorComponents.setVgap(10);
        errorComponents.setPadding(new Insets(25, 25, 25, 25));
        Label labelError = new Label(e.getMessage());
        labelError.setTextFill(Color.web("#f44242"));
        errorComponents.add(labelError, 1, 0);
        Scene newEntryScene = new Scene(errorComponents);
        errorWindow.setScene(newEntryScene);        
        errorWindow.show();
    }
}
