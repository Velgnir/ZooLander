package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class  HelloApplication extends Application {
    /**
     * The static Stage variable used to hold the current stage of the application.
     */
    private static Stage stg;
    /**
     * Initializes the primary stage of the application.
     *
     * @param primaryStage The primary stage for this application.
     * @throws Exception if an error occurs while initializing the primary stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Zoo");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    /**
     * This method changes the current scene of the application to the FXML file specified by the parameter.
     * @param fxml The name of the FXML file to load.
     * @throws IOException Thrown if there is an error loading the FXML file.
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    /**
     * Changes the displayed scene to the one specified by the Scene object.
     *
     * @param scene1 The new Scene object to be displayed.
     */
    public void changeScene(Scene scene1){
            stg.setScene(scene1);
    }
    /**
     * The main method for launching the application.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}