package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.Label;
public class AdminI implements Initializable, Using {

    @FXML
    private Label AllUs;
    @FXML
    private ChoiceBox<String> UserChoice;
    private ArrayList<String> users;
    /**
     * Retrieves a list of all users except for the admin user from the "USERS" directory.
     * Uses lambda expression to filter out directories and extract the usernames from the filenames.
     * Populates the users ArrayList and sets the text of the AllUs label to display the usernames.
     * @return the ArrayList of usernames
     */
    private ArrayList<String> getUs(){
        File folder = new File("USERS");
        File[] files = folder.listFiles();
        StringBuilder info = new StringBuilder();
        users = new ArrayList<>();
//lambda expression
        Arrays.stream(files)
                .filter(File::isFile)
                .map(file -> {
                    String input = file.getName();
                    int dotIndex = input.lastIndexOf('.');
                    String result = input.substring(0, dotIndex);
                    info.append(result).append("\n");
                    return result;
                })
                .filter(result -> !result.equals("ADMIN"))
                .forEach(users::add);
        AllUs.setText(info.toString());
        return users;
    }
    /**
     * Changes the current scene to the main menu.
     * @param event the ActionEvent that triggers the method
     * @throws IOException if the FXML file cannot be loaded
     */
    public void returnmenu(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        m.changeScene(new Scene(root, 700, 400));
    }
    /**
     * Deletes the selected user from the application.
     * Uses run-time type identification (RTTI) to ensure that the current user is an admin and not a regular user.
     * Clears the items in the UserChoice ChoiceBox and repopulates it with the updated list of usernames.
     * @param event the ActionEvent that triggers the method
     * @throws IOException if the FXML file cannot be loaded
     */

    public void delete(ActionEvent event) throws IOException {

//rtti для визначення класу admin як admin а не як user
        if (Login.Me instanceof ADMIN) {
            ((ADMIN) Login.Me).delete(UserChoice.getValue());
        }
        UserChoice.getItems().clear();
        UserChoice.getItems().addAll(getUs());
    }
    /**
     * Empty method that is triggered when a user is selected in the UserChoice ChoiceBox.
     * Required for the setOnAction() method in the initialize() method.
     * @param actionEvent the ActionEvent that triggers the method
     */

    private void GetUser(ActionEvent actionEvent) {

    }
/**
 * Initializes the controller after its root element has been completely processed.
 * Populates the UserChoice ChoiceBox with the list of usernames
 */

    @Override
    public void initialize(URL url, ResourceBundle rb) {

     UserChoice.getItems().addAll(getUs());
     UserChoice.setOnAction(this::GetUser);
    }
}