package com.example.proiect_mtdl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    TextField email_login;
    @FXML
    TextField password_login;


    @FXML
    public void onLoginClick(ActionEvent event) throws Exception, IOException {
        String email = getEmailValue();
        String password = getPasswordValue();

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

                DatabaseConnection.getInstance().ConnectUser(email_login.getText(), password_login.getText());

                if (resultSet2.getString("userType").equals("student")){


                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("studentMainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 300, 463);
                    stage.setTitle("Student Main Page");
                    stage.setScene(scene);
                    stage.show();

                } else if (resultSet2.getString("userType").equals("teacher")) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherMainPage.fxml"));
                    root = loader.load();
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();

                    TeacherController teacherController = loader.getController();
                    teacherController.setNameWelcome(DatabaseConnection.getInstance().getTeacher().getFirst_name());
                    teacherController.setCourses(DatabaseConnection.getInstance().getTeacher().getId());
                    teacherController.setStudent(DatabaseConnection.getInstance().getTeacher().getId());
                    scene = new Scene(root);
                    stage.setTitle("Teacher Main Page");
                    stage.setScene(scene);
                }
            }
        }

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    protected String getEmailValue() {
        return email_login.getText();
    }

    protected String getPasswordValue() {
        return password_login.getText();
    }
}
