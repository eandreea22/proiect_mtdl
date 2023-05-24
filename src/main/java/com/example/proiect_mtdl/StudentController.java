package com.example.proiect_mtdl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentController extends TeacherController{

    Stage stage;
    Scene scene;

    @FXML
    public void onClickBackLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    public void onClickManageAccount(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("manageAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Manage Account");
        stage.show();
        //emailManageAccount.setText(data.getTeacher().getEmail());
    }
}
