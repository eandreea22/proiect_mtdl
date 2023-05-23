package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AdminAllAccountsController {

    @FXML
    private TableView table;
    @FXML
    private TableColumn UserId;
    @FXML
    private TableColumn Email;
    @FXML
    private TableColumn FirstName;
    @FXML
    private TableColumn LastName;
    @FXML
    private TableColumn userType;

    @FXML
    public void onClickLoadUsers() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users ");

        ObservableList<User> users = FXCollections.observableArrayList();

        while (resultSet.next()){

            String id = resultSet.getString("id");
            String email = resultSet.getString("email");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String userType = resultSet.getString("userType");


            if (userType.equals("student")){
                users.add(new Student(Integer.parseInt(id), email, first_name, last_name, userType));

            }else if(userType.equals("teacher")){
                users.add(new Teacher(Integer.parseInt(id), email, first_name, last_name, userType));
            }

        }

        UserId.setCellValueFactory(
                new PropertyValueFactory<User, Integer>("id")
        );

        Email.setCellValueFactory(
                new PropertyValueFactory<User, String>("email")
        );

        FirstName.setCellValueFactory(
                new PropertyValueFactory<User, String>("first_name")
        );

        LastName.setCellValueFactory(
                new PropertyValueFactory<User, String>("last_name")
        );

        userType.setCellValueFactory(
                new PropertyValueFactory<User, String>("userType")
        );

        table.setItems(users);
        table.refresh();
    }

    @FXML
    public void onClickBack() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminMainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 463);
        stage.setTitle("Admin MainPage");
        stage.setScene(scene);
        stage.show();
    }

        @FXML
        public void onClickLogout(){
            Platform.exit();
            System.exit(0);
        }

    @FXML
    public void onClickAddAccount() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminAddAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 632);
        stage.setTitle("Add Account");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickDeleteAccount() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("adminDeleteAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 450);
        stage.setTitle("Delete Account");
        stage.setScene(scene);
        stage.show();
    }
}
