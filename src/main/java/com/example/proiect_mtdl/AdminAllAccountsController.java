package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AdminAllAccountsController {

    @FXML
    private TableView table;

    @FXML
    public void onClickLoadUsers() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users ");

        int i=0;
        while (resultSet.next()){

            String id = resultSet.getString("id");
            String email = resultSet.getString("email");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String user_type = resultSet.getString("userType");


            System.out.println(user_type);
            ObservableList<String> user =  FXCollections.observableArrayList();
            user.addAll(id, email, first_name, last_name, user_type);

            table.setItems(user);

            System.out.println("ok");
        }
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
}
