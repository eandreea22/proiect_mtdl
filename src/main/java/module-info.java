module com.example.proiect_mtdl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;
    requires java.desktop;


    opens com.example.proiect_mtdl to javafx.fxml;
    exports com.example.proiect_mtdl;
}