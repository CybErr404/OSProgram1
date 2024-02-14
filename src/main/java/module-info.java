module com.example.operatingsystems {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.operatingsystems to javafx.fxml;
    exports com.example.operatingsystems;
}