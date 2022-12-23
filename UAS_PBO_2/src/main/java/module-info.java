module com.example.uas_pbo_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uas_pbo_2 to javafx.fxml;
    exports com.example.uas_pbo_2;
}