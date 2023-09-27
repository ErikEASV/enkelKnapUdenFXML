module com.example.enkelknapudenfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.enkelknapudenfxml to javafx.fxml;
    exports com.example.enkelknapudenfxml;
}