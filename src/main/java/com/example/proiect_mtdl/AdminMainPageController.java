package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainPageController{


    @FXML
    public void onClickViewAccounts() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminAllAccounts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("All Accounts");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickViewCourses() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminAllCourses.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 503);
        stage.setTitle("All Cours");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickLogout() throws IOException {
        Platform.exit();
        System.exit(0);
    }

}
