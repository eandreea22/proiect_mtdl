package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.sql.DriverManager.getConnection;

public class TeacherController{

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Label labelNameWelcome;


    public String email;


//    DataSingleton data = new DataSingleton();
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        email.setText(data.getEmail());
//        welcomeLabel.setText("Welcome back, " + data.getEmail() + "!");
//    }

    public void setNameWelcome(String s){
        labelNameWelcome.setText(s);
    }

    public String setEmail(String s){
        email = s;
        return email;
    }


    @FXML
    public void onClickBackLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

//        stage = (Stage) email.getScene().getWindow();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    public void onClickManageAccount(ActionEvent event) throws IOException{

        root = FXMLLoader.load(getClass().getResource("manageAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        DataSingleton data = DataSingleton.getInstance();
       // Teacher teacher = data.getTeacher();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Manage Account");
        stage.show();
        emailManageAccount.setText(labelNameWelcome.getText());

    }

    @FXML
    public void onClickNotes(ActionEvent event) throws IOException{

        root = FXMLLoader.load(getClass().getResource("notes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notes");
        stage.show();
    }

    // manage account

    @FXML
    private Label emailManageAccount;
    @FXML
    private Label nameManageAccount;
    @FXML
    private Label universityManageAccount;
    @FXML
    private Label degreeManageAccount;
    @FXML
    public void onClickBackMainPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("teacherMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }

    @FXML
    private TextField newPasswordManageAccount;
    @FXML
    private TextField oldPasswordManageAccount;
    @FXML
    private TextField photoManageAccount;
    @FXML
    private ImageView profilePicture;
    @FXML
    public void onClickModifyPassword() throws SQLException{

//        if (teacher.getPassword().equals(oldPasswordManageAccount.getText())){
//
//            teacher.setPassword(newPasswordManageAccount.getText());
//
//            Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");
//
//            Statement statement = conn.createStatement();
//
//            if(newPasswordManageAccount.getText().isEmpty() == false){
//                statement.executeUpdate("update users " +
//                        "set password='" + newPasswordManageAccount.getText() + "' where id=" +
//                        Integer.toString(teacher.getId()) + ";" );
//            }
//            oldPasswordManageAccount.clear();
//            newPasswordManageAccount.clear();
//        }

    }

    @FXML
    private ImageView profilePhoto;
    @FXML
    public void onClickModifyPhoto(){

//        teacher.setPhoto(photoManageAccount.getText());
//        profilePicture.setImage(new Image(photoManageAccount.getText()));
//
//        photoManageAccount.clear();
//        profilePhoto.setImage(new Image(teacher.getPhoto()));
    }

    @FXML
    public void onClickLogout(){
        Platform.exit();
        System.exit(0);
    }

    // notes

    // view cours

    // show student
    @FXML
    public void onClickBackViewCours(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("teacherViewCours.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cours Page");
        stage.show();

    }

}
