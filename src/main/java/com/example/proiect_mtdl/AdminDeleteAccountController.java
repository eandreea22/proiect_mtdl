package com.example.proiect_mtdl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDeleteAccountController {

    @FXML
    private TextField userId;

    @FXML
    public void onClickDelete() throws SQLException{

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        statement.executeUpdate("delete from users " +
                "where id=" + Integer.parseInt(userId.getText()) + ";");
    }

    @FXML
    public void onClickBack() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminAllAccounts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("All Accounts");
        stage.setScene(scene);
        stage.show();
    }
}
