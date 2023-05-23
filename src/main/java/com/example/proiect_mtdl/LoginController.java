package com.example.proiect_mtdl;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

import java.sql.*;

public class LoginController {


    @FXML
    private TextField email;

    @FXML
    private TextField password;


    @FXML
    protected void onLoginClick() throws SQLException, IOException {


        if (email.getText().equals("admin") && password.getText().equals("admin")){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminMainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 463);
            stage.setTitle("Admin MainPage");
            stage.setScene(scene);
            stage.show();

        }else{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

            Statement statement = conn.createStatement();

            ResultSet resultSet2 = statement.executeQuery("select * from users " +
                    "where email='"  + email.getText() + "' " +
                    "and password='" + password.getText() + "';");

            while (resultSet2.next()){
                System.out.println("ok");
            }
        }





    }


}
