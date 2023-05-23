package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AdminAllCoursesController {

    @FXML
    private TableView table;
    @FXML
    private TableColumn idcours;
    @FXML
    private TableColumn namecours;

    @FXML
    public void onClickLoadCourses() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from cours ");

        ObservableList<Cours> courses = FXCollections.observableArrayList();

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            courses.add(new Cours(Integer.parseInt(id), name));
        }

        idcours.setCellValueFactory(
                new PropertyValueFactory<Cours, Integer>("id")
        );

        namecours.setCellValueFactory(
                new PropertyValueFactory<Cours, String>("name")
        );

        table.setItems(courses);
        table.refresh();

    }
    @FXML
    public void onClickAddCours() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("addCours.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 443);
        stage.setTitle("Add Cours");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickDeleteCours() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstOne.class.getResource("deleteCours.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 632);
        stage.setTitle("Delete Cours");
        stage.setScene(scene);
        stage.show();
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
