package com.example.proiect_mtdl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class TeacherController {

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Label welcomeLabel;

    User teacher;

    public void createTeacher(String email, String password) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        ResultSet resultSet2 = statement.executeQuery("select * from users " +
                "where email='"  + email + "' " +
                "and password='" + password + "';");

        while (resultSet2.next()){
            int id = Integer.parseInt(resultSet2.getString("id"));
            String first_name = resultSet2.getString("first_name");
            String last_name = resultSet2.getString("last_name");
            String university = resultSet2.getString("university");
            String degree = resultSet2.getString("degree");

            this.teacher = new Teacher(id, last_name, first_name, email, password, university,"teacher", degree);

        }

        welcomeLabel.setText("Welcome back, "  + teacher.getFirst_name() + "!" );


    }

    @FXML
    public void onClickBackLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}
