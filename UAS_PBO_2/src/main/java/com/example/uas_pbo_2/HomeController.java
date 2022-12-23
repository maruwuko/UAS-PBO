package com.example.uas_pbo_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button logoutButton;
    @FXML
    private TextField inputNomorParkir;
    @FXML
    private TextField inputNomorPlat;
    @FXML
    private Button checkButton;
    @FXML
    private Text inputError;
    public void logoutButtononaction()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Stage window = (Stage) logoutButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void checkButtononaction()throws IOException {
        if (inputNomorParkir.getText().isBlank() ||  inputNomorPlat.getText().isBlank()) {
            inputError.setText("Error - Semua field harus terisi!");
        } else {
            DataParkir.kartuParkir = inputNomorParkir.getText();
            DataParkir.nomorPolisi = inputNomorPlat.getText();
            Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml"));

            Stage window = (Stage) logoutButton.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }
}
