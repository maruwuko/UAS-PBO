package com.example.uas_pbo_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckoutController {
    @FXML
    private Text nomorKartuParkir;
    @FXML
    private Text nomorPolisi;
    @FXML
    private Button backButton;
    private ToggleGroup pilihanKendaraan;
    @FXML
    private RadioButton rbmobil;
    @FXML
    private RadioButton rbmotor;
    @FXML
    private TextField wktMasuk;
    @FXML
    private TextField wktKeluar;
    @FXML
    private Text pesanError;
    @FXML
    private Text biayaParkir;
    @FXML
    private Button hitungBiayaParkirButton;
    private static int totalWaktu;
    private static int totalBiaya;
    public void hitungBiaya() {
        String jenisKendaraan = ((RadioButton) pilihanKendaraan.getSelectedToggle()).getText();
        int totalWaktu;
        int jamMasuk, jamKeluar;
        try {
             jamMasuk = Integer.valueOf(wktMasuk.getText().substring(0, 2));
             jamKeluar = Integer.valueOf(wktKeluar.getText().substring(0, 2));
        } catch (Exception e) {
            pesanError.setText("Input tidak valid");
            return;
        }

        totalWaktu = jamKeluar - jamMasuk;
        if (totalWaktu < 0 || totalWaktu > 24) {
            pesanError.setText("Input tidak valid");
            biayaParkir.setText("");
            return;
        }

        if (jenisKendaraan.equals("Mobil")) {
            if (totalWaktu == 0 || totalWaktu == 1) {
                totalBiaya = 4000;
            } else {
                totalBiaya = (totalWaktu-1) * 3000 + 4000;
            }
        } else {
            if (totalWaktu == 0 || totalWaktu == 1) {
                totalBiaya = 2000;
            } else {
                totalBiaya = (totalWaktu-1) * 1000 + 2000;
            }
        }
        biayaParkir.setText(String.valueOf(totalBiaya));
        totalBiaya = 0;
    }

    public void backButtononaction()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root)); }
    @FXML
    public void initialize(){
        pilihanKendaraan = new ToggleGroup();
        nomorKartuParkir.setText(DataParkir.kartuParkir);
        nomorPolisi.setText(DataParkir.nomorPolisi);
        rbmobil.setToggleGroup(pilihanKendaraan);
        rbmotor.setToggleGroup(pilihanKendaraan);
    }
}
