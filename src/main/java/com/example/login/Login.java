package com.example.login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import javafx.application.Platform;
import javafx.concurrent.Task;
@Aspect
class LoggingAspect {

    @Before("execution(* com.example.login.Login.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " called with parameters " + Arrays.toString(joinPoint.getArgs()));
    }
}
/**

 This class represents a login functionality for a JavaFX application.

 It implements the Using interface.
 */
public class Login implements Using{

    /**

     This is the default constructor for the Login class.
     */
    public static viewer Me;
    public  Login() {

}
    @FXML
    private Button button;
    @FXML
    private Label wrong;
    @FXML
    private TextField yourlogin;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView DIO;

    /**
     * This method is called when the user clicks the login button.
     * It validates the user's login credentials and logs them in if the information is correct.
     * @throws IOException when there is an error with reading from the file.
     * @throws ClassNotFoundException when the class is not found during deserialization.
     */
    public void userlogin(ActionEvent event) throws IOException, ClassNotFoundException {
        checkLogin();

    }
    /**
     * This method validates the user's login credentials.
     * If the information is correct, it logs the user in and takes them to the afterLogin.fxml page.
     * If the information is incorrect, it displays an error message.
     * @throws IOException when there is an error with reading from the file.
     */
    private void checkLogin() throws IOException {
        String log = yourlogin.getText().toString();
        String pass = password.getText().toString();
        if(log.equals("viewer")){
            Me = new viewer(log,pass,0);
            HelloApplication m = new HelloApplication();
            m.changeScene("afterLogin.fxml");
        }else if (log.length() > 0 && pass.length() > 0) {
            Task<viewer> task = new Task<viewer>() {
                @Override
                protected viewer call() throws Exception {
                    viewer user;
                    if (log.equals("ADMIN")) {
                        user = sign_in_as_admin(log, pass);
                    } else {
                        user = sign_in(log, pass);
                    }
                    return user;
                }
            };
/**

 This method validates the user's login credentials.

 If the information is correct, it logs the user in and takes them to the afterLogin.fxml page.

 If the information is incorrect, it displays an error message.

 @throws IOException when there is an error with reading from the file.
 */


            task.setOnSucceeded(event -> {
                Me = task.getValue();
                if (Me != null) {
                    try {
                        HelloApplication m = new HelloApplication();
                        m.changeScene("afterLogin.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    wrong.setText("wrong login or password");
                }
            });

            task.setOnFailed(event -> {
                wrong.setText("error during authorization");
                task.getException().printStackTrace();
            });

            new Thread(task).start();
        } else {
            wrong.setText("fill the login and password");
        }
    }


    public void createlogin() throws IOException, ClassNotFoundException {
        String log = yourlogin.getText().toString();
        String pass = password.getText().toString();
        if(log.length()>0){
            if(!sign_up(log,pass)){
                wrong.setText("wrong info");
            }else{
                checkLogin();
            }
        }
/**

 This method is called when the user clicks the create login button.
 It creates a new login if the information provided is valid.
 If the information is invalid, it displays an error message.
 @throws IOException when there is an error with reading from the file.
 @throws ClassNotFoundException when the class is not
 */
    }
}
