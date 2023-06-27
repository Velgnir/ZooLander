package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class BratislavaZoo{

    @FXML
    private Button BackToMenu;

    /**
     * The returnmenu method is called when the "Return to Menu" button is clicked in the BratislavaZoo.fxml view.
     * It creates a new instance of the HelloApplication class, loads the BratislavaZoo.fxml view, and changes
     * the scene to the ZoosPanel.fxml view.
     *
     * @param event The ActionEvent that was fired when the "Return to Menu" button was clicked.
     * @throws IOException if there is an error loading the ZoosPanel.fxml view.
     */
    public void returnmenu(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("BratislavaZoo.fxml"));
        m.changeScene(new Scene(root, 600, 400));
        m.changeScene("ZoosPanel.fxml");

    }

}