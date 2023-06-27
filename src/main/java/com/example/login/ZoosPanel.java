package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class ZoosPanel{

    @FXML
    private Button Bratislavazoo;

    /**
     * Displays information for Bratislava zoo when Bratislavazoo button is clicked.
     * Loads BratislavaZoo.fxml file and changes the scene to display it.
     *
     * @param event An ActionEvent object representing the button click event.
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */

    public void InfoForBrat (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("BratislavaZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));

/**
 * Displays information for Kontakt zoo when KontaktZoo button is clicked.
 * Loads KontaktZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
    }
    @FXML
    private Button KontaktZoo;


    public void InfoForKon (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("KontaktZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));

/**
 * Displays information for Kontakt zoo when KontaktZoo button is clicked.
 * Loads KontaktZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
    }

    @FXML
    private Button StropkovZoo;


    public void InfoForStrop (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("StropkovZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));

/**
 * Displays information for Stropkov zoo when StropkovZoo button is clicked.
 * Loads StropkovZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
    }


    @FXML
    private Button NovaVesZoo;


    public void InfoForVes (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("NoveVesZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));

/**
 * Displays information for NovaVes zoo when NovaVesZoo button is clicked.
 * Loads NoveVesZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
    }
    @FXML
    private Button KosiceZoo;


    public void InfoForKos (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("KosiceZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));
/**
 * Displays information for Kosice zoo when KosiceZoo button is clicked.
 * Loads KosiceZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
    }


    @FXML
    private Button BojniceZoo;


    public void InfoForBoj (ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("BojniceZoo.fxml"));
        m.changeScene(new Scene(root, 630, 610));
/**
 * Displays information for Bratislava zoo when Bratislavazoo button is clicked.
 * Loads BratislavaZoo.fxml file and changes the scene to display it.
 *
 * @param event An ActionEvent object representing the button click event.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */

    }

    @FXML
    private Button BackToMenu;


    public void returnmenu(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        m.changeScene(new Scene(root, 700, 400));

        /**
         * This method is called when the "Return to Menu" button is clicked.
         * It returns to the main menu of the application.
         * @param event the ActionEvent triggered by clicking the button
         * @throws IOException if the FXML file for the main menu cannot be loaded
         */
    }

}