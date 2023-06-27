package com.example.login;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
public class TimeTabCon  implements Initializable, Using {

    @FXML
    private Label TINFO;
    @FXML
    private ChoiceBox<String> BRz;
    @FXML
    private ChoiceBox<String> KONz;
    @FXML
    private ChoiceBox<String> STRz;
    @FXML
    private ChoiceBox<String> KOSz;
    @FXML
    private ChoiceBox<String> NOVz;
    @FXML
    private ChoiceBox<String> BOJz;

    private String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

    private String PLAN = "";
    private String ZoosD[] = new String[6];
    /**
     * Initializes the controller class.
     * This method sets the ChoiceBoxes with days of the week and adds event listeners for each ChoiceBox.
     * It also loads the user's plan if they are logged in.
     *
     * @param arg0 The URL used to resolve relative paths for the root object, or null if the location is not known.
     * @param arg1 The ResourceBundle that contains localizable objects.
     */
    private String[] zoo = {"Bratislava zoo","Kontakt Zoo","Stropkov Zoo","Kosice Zoo","NovaVes Zoo","Bojnice Zoo"};
    private void getBRz(ActionEvent event) {
       ZoosD[0] =BRz.getValue();
    }
    /**
     * Sets the selected value for certain Zoo ChoiceBox to ZoosD array.
     *
     * @param event An event that indicates that a selection changed.
     */
    private void getKONz(ActionEvent event) {
        ZoosD[1] = KONz.getValue();

    }

    private void getSTRz(ActionEvent event) {
        ZoosD[2] = STRz.getValue();

    }
    private void getKOSz(ActionEvent event) {

        ZoosD[3] = KOSz.getValue();
    }
    private void getNOVz(ActionEvent event) {
        ZoosD[4] = NOVz.getValue();

    }
    private void getBOJz(ActionEvent event) {

        ZoosD[5] = BOJz.getValue();
    }
/**
 * This method saves the user's selected plan as a string and displays it in the
 * TINFO Label. If the user is logged in, the plan is also saved to the user's account.
 * @param event The action event
 */


    public void SaveContent(ActionEvent event) throws IOException, ClassNotFoundException {
        PLAN = "";
        String temp;
        for(String el: days){
            temp = "";
            for(int i=0; i< 6; ++i){
                if(ZoosD[i] == el){
                    temp += zoo[i]+","+ "\n";
                }
            }
            if(temp!=""){
                temp += "  -"+el + "\n"+ "\n";
            }
            PLAN+=temp;
        }
/**

 /**

 This method is called when the user clicks the "SaveContent" button in the GUI.

 It retrieves the selected activities for each day of the week from the ZoosD array and formats them into a string that is then set as the PLAN variable.

 The PLAN variable is also saved to the current user's plan field if the user is logged in as a User.

 @param event the ActionEvent object that triggered the method call

 @throws IOException if there is an error writing the plan to file

 @throws ClassNotFoundException if there is an error loading the current user's plan
 */

        TINFO.setText(PLAN);
        if (Login.Me instanceof User) {
            ((User)Login.Me).setPlan(PLAN);
        }


    }
    public void LoadContent(ActionEvent event) throws IOException, ClassNotFoundException {
        if (Login.Me instanceof User) {
            PLAN = ((User)Login.Me).getPlan();
        }

        TINFO.setText(PLAN);

    }
    /**

     This method is called when the user clicks the "LoadContent" button in the GUI.

     If the user is logged in as a User, it retrieves the user's saved plan and sets it as the PLAN variable.

     The PLAN variable is then displayed in the text area in the GUI.

     @param event the ActionEvent object that triggered the method call

     @throws IOException if there is an error reading the plan file

     @throws ClassNotFoundException if there is an error loading the current user's plan
     */
    @FXML
    private Button BackToMenu;

    public void returnmenu(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        m.changeScene(new Scene(root, 700, 400));


    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
/**

 This method is called when the user selects a day of the week from one of the drop-down menus in the GUI.
 It updates the corresponding element in the ZoosD array to reflect the user's selection.
 @param event the ActionEvent object that triggered the method call
 */

       BRz.getItems().addAll(days);
       BRz.setOnAction(this::getBRz);

        KONz.getItems().addAll(days);
        KONz.setOnAction(this::getKONz);

        STRz.getItems().addAll(days);
        STRz.setOnAction(this::getSTRz);

        KOSz.getItems().addAll(days);
        KOSz.setOnAction(this::getKOSz);

        NOVz.getItems().addAll(days);
        NOVz.setOnAction(this::getNOVz);

        BOJz.getItems().addAll(days);
        BOJz.setOnAction(this::getBOJz);

    }

}
