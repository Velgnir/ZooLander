package com.example.login;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class TimeController implements Initializable{

    @FXML
    private Label myLabel;

    @FXML
    private ChoiceBox<String> ZooChoice;

    private String[] zoo = {"Bratislavazoo","KontaktZoo","StropkovZoo","KosiceZoo","NovaVesZoo","BojniceZoo"};

    @FXML
    private ImageView IM;

    @FXML
    private Label MyLabel2;
    @FXML
    private Label STATUS;
    @FXML
    private ChoiceBox<String> TimeChoice;

    private String[] time = {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"
    };
    /**
     * This method is called when the user selects a zoo from the choice box.
     * It gets the name of the selected zoo, sets it to the label 'myLabel', and sets the corresponding image to 'IM'.
     * It also checks if a time has been selected, and sets the 'STATUS' label to "CLOSED" if no time is selected or the selected time is outside the zoo's opening hours.
     * @param event the event of selecting a zoo from the choice box
     */

    public void getZoo(ActionEvent event) {

        String myZoo = ZooChoice.getValue();
        myLabel.setText(myZoo);
        Image image= new Image("https://www.zoobratislava.sk/assets/Nova-mapa__Resampled.jpg");
        int number=0;
        STATUS.setText(" ");

        if(TimeChoice.getValue()!=null) {
            number = Integer.parseInt(TimeChoice.getValue().split(":")[0]);
            STATUS.setText("CLOSED");
        }
       // System.out.println(number);

        switch (myZoo){
            case "Bratislavazoo":
                image = new Image("https://www.zoobratislava.sk/assets/Nova-mapa__Resampled.jpg");
                if(number>8 && number<19){
                    STATUS.setText("OPEN");
                }
                break;
            case "KontaktZoo":
                image = new Image("https://static-images.zoznam.sk/image/fetch/q_92,w_1200,h_630,c_fill/h_108,g_north_east,x_0,y_30,l_plnielanu_watermark/https://plnielanu.zoznam.sk/wp-content/uploads/2022/07/zookontakt-ilustracna-tatralandiaubytovanie.sk_.jpg");
                if(number>8 && number<20){
                    STATUS.setText("OPEN");
                }
                break;
            case "StropkovZoo":
                image = new Image("https://kamsdetmi.sk/wp-content/uploads/2012/07/zoo1.jpg");
                if(number>9 && number<19){
                    STATUS.setText("OPEN");
                }
                break;
            case "KosiceZoo":
                image = new Image("https://zookosice.sk/wp-content/uploads/2022/07/mapa-zoo-kosice.jpg");
                if(number>9 && number<20){
                    STATUS.setText("OPEN");
                }
                break;
            case "NovaVesZoo":
                image = new Image("https://zoosnv.sk/wp-content/uploads/2022/04/mapa-zoo.jpg");
                if(number>7 && number<21){
                    STATUS.setText("OPEN");
                }
                break;
            case "BojniceZoo":
                image = new Image("https://zoobojnice.sk/wp-content/uploads/2021/04/mapa-2021-A3-scaled.jpg");
                if(number>8 && number<18){
                    STATUS.setText("OPEN");
                }
                break;
        }


        IM.setImage(image);
    }
    /** Get the selected zoo from the choice box
     * Set the selected zoo to the label 'myLabel
     *Get the corresponding image for the selected zoo
     *Initialize the 'number' variable to 0
     */

    public void getTime(ActionEvent event) {

        String myTime = TimeChoice.getValue();
        MyLabel2.setText(myTime);
        int number = Integer.parseInt(TimeChoice.getValue().split(":")[0]);
        STATUS.setText("CLOSED");
        String myZoo = ZooChoice.getValue();
        if(myZoo==null){
            myZoo = " ";
            STATUS.setText(" ");
        }
        switch (myZoo){
            case "Bratislavazoo":

                if(number>8 && number<19){
                    STATUS.setText("OPEN");
                }
                break;
            case "KontaktZoo":

                if(number>8 && number<20){
                    STATUS.setText("OPEN");
                }
                break;
            case "StropkovZoo":

                if(number>9 && number<19){
                    STATUS.setText("OPEN");
                }
                break;
            case "KosiceZoo":

                if(number>9 && number<20){
                    STATUS.setText("OPEN");
                }
                break;
            case "NovaVesZoo":

                if(number>7 && number<21){
                    STATUS.setText("OPEN");
                }
                break;
            case "BojniceZoo":

                if(number>8 && number<18){
                    STATUS.setText("OPEN");
                }
                break;
        }
    }
 /** Set the 'STATUS' label to an empty string
     * Check if a time has been selected
     * Set the 'STATUS' label to "CLOSED" if the selected time is outside the zoo's opening hours
            */

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
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ZooChoice.getItems().addAll(zoo);
        ZooChoice.setOnAction(this::getZoo);

        TimeChoice.getItems().addAll(time);
        TimeChoice.setOnAction(this::getTime);
/**
 * Gets the selected zoo and displays it in the myLabel Label component.
 *
 * This method is called when the user selects a zoo from the ZooChoice ChoiceBox.
 * It sets the text of the myLabel Label component to the selected zoo.
 *
 * It also sets the image of the IM ImageView component to the corresponding map image of the selected zoo.
 *
 * Finally, it calls the checkStatus method to display whether the selected zoo is open or closed at the selected time.
 */
    }



}
