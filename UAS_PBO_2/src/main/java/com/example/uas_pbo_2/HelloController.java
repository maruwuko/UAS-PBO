package com.example.uas_pbo_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username_TextField;
    @FXML
    private String username = "marcocheloandre";
    @FXML
    private PasswordField password_PasswordField;
    private String password = "1sampai10";
    @FXML
    private Text loginMessage;
    @FXML
    private Button loginbutton;
    @FXML
    private void loginbuttononaction(){
         String masukkanUsername = username_TextField.getText();
         String masukkanPassword = password_PasswordField.getText();
        if (masukkanUsername.equals(username) && masukkanPassword.equals(password)){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

                Stage window = (Stage) loginbutton.getScene().getWindow();
                window.setScene(new Scene(root));
            } catch (Exception e){
                e.printStackTrace();
            }
             }

         else {
             loginMessage.setText("Username/Password Salah!");
            }

        }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}