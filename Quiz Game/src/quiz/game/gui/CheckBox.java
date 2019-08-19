/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author SAMNOON
 */
public class CheckBox {
    
    
    /*
    display : this method will ask the user to close the program
    */
    public static void display(String title, String message, Stage mainWindow)
    {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the program");
        closeButton.setOnAction(e -> {
            window.close();
            mainWindow.close();
                });
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene GoodBye = new Scene(layout);
        window.setScene(GoodBye);
        window.showAndWait();
        
    }
}
