package com.example.proiect_mtdl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.*;

public class AdminAddAccountController {

    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField email;
    @FXML
    private TextField university;
    @FXML
    private TextField uni_year;
    @FXML
    private TextField password;
    @FXML
    private TextField userType;
    @FXML
    private TextField uni_group;
    @FXML
    private TextField specialisation;
    @FXML
    private TextField degree;


    @FXML
    public void onClickAddAccount() throws SQLException {



        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();
        Statement statement1 = conn.createStatement();
        System.out.println(userType.getText());

        if (userType.getText().equals("student")){

            System.out.println("ok");

            statement.executeUpdate("insert into users " +
                    " (last_name,first_name,email,password,userType,university,uni_year,specialisation,uni_group)" +
                    " values ('" +
                    last_name.getText() + "','" +
                    first_name.getText() + "','" +
                    email.getText() + "','" +
                    password.getText() + "','" +
                    userType.getText() + "','" +
                    university.getText() +  "'," +
                    Integer.parseInt(uni_year.getText()) + ",'" +
                    specialisation.getText()+ "','" +
                    uni_group.getText() +"');"
                    );

        } else if (userType.getText().equals("teacher")) {

            System.out.println("ok");

            statement1.executeUpdate("insert into users " +
                    "(last_name,first_name,email,password,userType,university,degree)" +
                    " values ('" +
                    last_name.getText() + "','" +
                    first_name.getText() + "','" +
                    email.getText() + "','" +
                    password.getText() + "','" +
                    userType.getText() + "','" +
                    university.getText() + "','" +
                    degree.getText()+ "');"
                    );
        }

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
