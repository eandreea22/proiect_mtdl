package com.example.proiect_mtdl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

import java.sql.*;

public class LoginController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField email_login;
    @FXML
    private TextField password_login;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    protected void onLoginClick(ActionEvent event) throws SQLException, IOException {


        if (email_login.getText().equals("admin") && password_login.getText().equals("admin")){
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
                    "where email='"  + email_login.getText() + "' " +
                    "and password='" + password_login.getText() + "';");

            while (resultSet2.next()){

                if (resultSet2.getString("userType").equals("student")){


                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("studentMainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 300, 463);
                    stage.setTitle("Student Main Page");
                    stage.setScene(scene);
                    stage.show();

                } else if (resultSet2.getString("userType").equals("teacher")) {


//                    int id = Integer.parseInt(resultSet2.getString("id"));
//                    String first_name = resultSet2.getString("first_name");
//                    String last_name = resultSet2.getString("last_name");
//                    String university = resultSet2.getString("university");
//                    String degree = resultSet2.getString("degree");
//
//                    Teacher teacher = new Teacher(id, last_name, first_name, email_login.getText(), password_login.getText(), university,"teacher", degree);
//
//                    DataSingleton data = DataSingleton.getInstance();
//                    data.setTeacher(teacher);


//                    data.setEmail(email_login.getText());
//                    stage = (Stage) email_login.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherMainPage.fxml"));
                    root = loader.load();
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    TeacherController teacherController = loader.getController();
                    teacherController.setNameWelcome(email_login.getText());
                    scene = new Scene(root);
                    stage.setTitle("Teacher Main Page");
                    stage.setScene(scene);
                }
            }
        }

    }

}
