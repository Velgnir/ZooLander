package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;
    /**
     * The userlogOut method is called when the user clicks on the logout button.
     * It changes the scene to the "hello-view.fxml" file, which is the login page.
     *
     * @param event The action event that triggers this method when the user clicks on the logout button.
     * @throws IOException if the hello-view.fxml file is not found.
     */

    public void userlogOut(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("hello-view.fxml");

    }
    @FXML
    private Button newinfo;

    /**
     * The BratInfo method is called when the user clicks on the "New Info" button.
     * It changes the scene to the "ZoosPanel.fxml" file, which displays new information.
     *
     * @param event The action event that triggers this method when the user clicks on the "New Info" button.
     * @throws IOException if the ZoosPanel.fxml file is not found.
     */
    public void BratInfo(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("ZoosPanel.fxml"));
        m.changeScene(new Scene(root, 600, 400));


    }
    private Button timeforroad;
    /**
     * The newtime method is called when the user clicks on the "Time for Road" button.
     * It changes the scene to the "Time.fxml" file, which displays the time for the road.
     *
     * @param event The action event that triggers this method when the user clicks on the "Time for Road" button.
     * @throws IOException if the Time.fxml file is not found.
     */
    public void newtime(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("Time.fxml"));
        m.changeScene(new Scene(root, 600, 400));


    }


    private Button ROAD;
    /**
     * The OPROADS method is called when the user clicks on the "Road" button.
     * It changes the scene to the "Road.fxml" file, which displays the road.
     *
     * @param event The action event that triggers this method when the user clicks on the "Road" button.
     * @throws IOException if the Road.fxml file is not found.
     */

    public void OPROADS(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("Road.fxml"));
        m.changeScene(new Scene(root, 580, 400));

    }
    private Button TimeTable;
    /**
     * The OPTAB method is called when the user clicks on the "Time Table" button.
     * It changes the scene to the "TimeTable.fxml" file, which displays the time table.
     *
     * @param event The action event that triggers this method when the user clicks on the "Time Table" button.
     * @throws IOException if the TimeTable.fxml file is not found.
     */

    public void OPTAB(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        if(Login.Me.IsPowerFull()>0){
            Parent root = FXMLLoader.load(getClass().getResource("TimeTable.fxml"));
            m.changeScene(new Scene(root, 500, 400));
        }
        /**
         * This method displays the admin menu, but only if the user is a  admin.
         * @param event The action event that triggers this method
         * @throws IOException if an error occurs while loading the FXML file for the admin menu
         */

    }
    public void Edit(ActionEvent event) throws IOException {
        System.out.println(Login.Me.IsPowerFull());
        if(Login.Me.IsPowerFull()>1) {
            HelloApplication m = new HelloApplication();
            Parent root = FXMLLoader.load(getClass().getResource("ADMIN_MENU.fxml"));
            m.changeScene(new Scene(root, 600, 400));
        }
    }
}