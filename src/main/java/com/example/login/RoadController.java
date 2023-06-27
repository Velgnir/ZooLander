package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RoadController implements Initializable{

        @FXML
        private Label TINFO;
        @FXML
        private ChoiceBox<String> RoadPlace;
        private String[] stats = {"Bus Station Vrutky","Bus Station Bratislava","Bus Station Šurany","Košice Bus Station Square"};
    /*
            private String[] time = {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"
            };

            public void getZoo(ActionEvent event) {

                String myZoo = ZooChoice.getValue();
                myLabel.setText(myZoo);

            }


        */

    /**
     * This method is called when the "Return to Menu" button is clicked.
     * It returns to the main menu of the application.
     * '@'param event the ActionEvent triggered by clicking the button
     * '@'throws IOException if the FXML file for the main menu cannot be loaded
     */
    public void getRoad(ActionEvent event) {
/**
 * Called when the "Get Road" button is clicked. It gets the selected bus station from
 * the ChoiceBox and displays the information about traveling to different zoos
 * from the selected bus station.
 *
 * '@'param event ActionEvent created when the button is clicked.
 */
        String myStat = RoadPlace.getValue();
        switch (myStat){
            case "Bus Station Vrutky":
                TINFO.setText("\"Bratislava Zoo - 2 hours 20 min / 230km\" +\n" +
                              "\"Zoo Kontakt- 1 hours 2 min / 71,5km\" \n" +
                              "\"Zoo Kosice - 2 hours 35 min / 229km\" \n" +
                              "\"Zoo Bojnice - 1 hours 1 min / 59,7km\" \n"+
                              "\"Zoo Nova Ves - 1 hours 48 min / 150km\" \n"+
                              "\"Zoo Stropkov - 2 hours 58 min / 247km\""


                );
                break;
            case "Bus Station Bratislava":

                TINFO.setText("\"Bratislava Zoo -  12 min / 6,7km\" \n" +
                              "\"Zoo Kontakt- 3 hours 6 min / 286km\" \n" +
                              "\"Zoo Kosice - 4 hours 40 min / 451km\" \n" +
                              "\"Zoo Bojnice - 2 hours 9 min / 165km\"\n" +
                              "\"Zoo Nova Ves - 3 hours 57 min / 366km\"\n" +
                              "\"Zoo Stropkov - 5 hours 7 min / 464km\""
                );
                break;
            case "Bus Station Šurany":
                TINFO.setText("\"Bratislava Zoo -  1 hour 41min / 116km\" \n" +
                              "\"Zoo Kontakt- 3 hours / 227km\" \n" +
                              "\"Zoo Kosice - 4 hours 14 min / 365km\" \n" +
                              "\"Zoo Bojnice - 1 hour 54 min / 134km\"\n" +
                              "\"Zoo Nova Ves - 19 min / 16,1km\"\n" +
                              "\"Zoo Stropkov - 5 hours 2 min / 402km\""
                );
                break;
            case "Košice Bus Station Square":
                TINFO.setText("\"Bratislava Zoo - 4 hours 38 min / 443km\" \n" +
                              "\"Zoo Kontakt- 2 hours 38 min / 181km\" \n" +
                              "\"Zoo Kosice - 19 min / 12,2km\" \n" +
                              "\"Zoo Bojnice - 3 hours 43 min / 309km\"\n" +
                              "\"Zoo Nova Ves - 1 hours 16 min / 76,1km\"\n" +
                              "\"Zoo Stropkov - 1 hours 30 min / 100km\""
                );
                break;
        }
        //TINFO.setText(myStat);
    }
    @FXML
    private Button BackToMenu;

    public void returnmenu(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        m.changeScene(new Scene(root, 700, 400));
/**
 * This method is called when a new bus station is selected from the ChoiceBox.
 * It displays travel information for different zoos based on the selected bus station.
 *
 * '@'param event the ActionEvent triggered by selecting a new bus station
 */

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        RoadPlace.getItems().addAll(stats);
        RoadPlace.setOnAction(this::getRoad);

    }
}
