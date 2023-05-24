package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class AdminController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    // main page

    //
    @FXML
    public void onClickViewAccounts(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminAllAccounts.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("All Courses");
        stage.show();

    }

    //
    @FXML
    public void onClickViewCourses(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("adminAllCourses.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("All Courses");
        stage.show();
    }

    @FXML
    public void onClickLogout(){
        Platform.exit();
        System.exit(0);
    }


    //view all accounts
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
    public void onClickBackMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("admin main page");
        stage.show();
    }


//
    @FXML
    public void onClickAddAccount(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("adminAddAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Account");
        stage.show();
    }

//
    @FXML
    public void onClickDeleteAccount(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("adminDeleteAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Delete Account");
        stage.show();
    }

    //
    @FXML
    public void onClickChange(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("adminModifyAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Modify Account");
        stage.show();
    }


    //add account

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
    private TextField userTypeAddAccount;
    @FXML
    private TextField uni_group;
    @FXML
    private TextField specialisation;
    @FXML
    private TextField degree;


    @FXML
    public void onClickAddAccount2() throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        System.out.println("ok");
        System.out.println(userTypeAddAccount.getText());
        if (userTypeAddAccount.getText().equals("student")){


            statement.executeUpdate("insert into users " +
                    " (last_name,first_name,email,password,userType,university,uni_year,specialisation,uni_group)" +
                    " values ('" +
                    last_name.getText() + "','" +
                    first_name.getText() + "','" +
                    email.getText() + "','" +
                    password.getText() + "','" +
                    userTypeAddAccount.getText() + "','" +
                    university.getText() +  "'," +
                    Integer.parseInt(uni_year.getText()) + ",'" +
                    specialisation.getText()+ "','" +
                    uni_group.getText() +"');"
            );

        } else if (userTypeAddAccount.getText().equals("teacher")) {
            System.out.println("ok");

            statement.executeUpdate("insert into users " +
                    "(last_name,first_name,email,password,userType,university,degree)" +
                    " values ('" +
                    last_name.getText() + "','" +
                    first_name.getText() + "','" +
                    email.getText() + "','" +
                    password.getText() + "','" +
                    userTypeAddAccount.getText() + "','" +
                    university.getText() + "','" +
                    degree.getText()+ "');"
            );
        }

    }

    @FXML
    public void onClickBackAllAccounts(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("adminAllAccounts.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("All Accounts");
        stage.show();
    }

    //delete account
    @FXML
    private TextField userId_deleteAccount;

    @FXML
    public void onClickDelete() throws SQLException{

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        statement.executeUpdate("delete from users " +
                "where id=" + Integer.parseInt(userId_deleteAccount.getText()) + ";");
    }

   //modify account
   @FXML
   private TextField userId_modifyAccount;
    @FXML
    private TextField password_modifyAccount;
    @FXML
    private TextField userType_modifyAccount;
    @FXML
    private TextField university_modifyAccount;
    @FXML
    private TextField uni_year_modifyAccount;
    @FXML
    private TextField specialisation_modifyAccount;
    @FXML
    private TextField uni_group_modifyAccount;
    @FXML
    private TextField degree_modifyAccount;

    @FXML
    private void onClickModifyPassword() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(password_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set password='" + password_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyUserType() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(userType_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set userType='" + userType_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyUniversity() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(university_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set university='" + university_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyYear() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(uni_year_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set uni_year=" + Integer.parseInt(uni_year_modifyAccount.getText()) + " where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifySpecialisation() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(specialisation_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set specialisation='" + specialisation_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyGroup() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(uni_group_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set uni_group='" + uni_group_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyDegree() throws SQLException{

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(degree_modifyAccount.getText().isEmpty() == false){
            statement.executeUpdate("update users " +
                    "set degree='" + degree_modifyAccount.getText() + "' where id=" +
                    Integer.parseInt(userId_modifyAccount.getText()) + ";" );
        }

    }


    // all courses
    @FXML
    private TableView tableAllCourses;
    @FXML
    private TableColumn idcoursAllCourses;
    @FXML
    private TableColumn namecoursAllCourses;

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

        idcoursAllCourses.setCellValueFactory(
                new PropertyValueFactory<Cours, Integer>("id")
        );

        namecoursAllCourses.setCellValueFactory(
                new PropertyValueFactory<Cours, String>("name")
        );

        tableAllCourses.setItems(courses);
        tableAllCourses.refresh();

    }

    //
    @FXML
    public void onClickAddCours2(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("adminAddCours.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Cours");
        stage.show();
    }

    //
    @FXML
    public void onClickDeleteCours(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("adminDeleteCours.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Delete Cours");
        stage.show();
    }


    //
    @FXML
    public void onClickModifyCours(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("adminModifyCours.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Modify Cours");
        stage.show();
    }

    @FXML
    public void onClickBackAllCourses(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("adminAllCourses.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("All Courses");
        stage.show();
    }

    // add Cours
    @FXML
    private TextField coursNameAddCours;
    @FXML
    private TextField photoAddCours;
    @FXML
    public void onClickAddCours() throws SQLException{

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into cours" +
                " (name, photo) values ('" +
                coursNameAddCours.getText() + "','" + photoAddCours.getText() + "');");
    }

    // delete cours
    @FXML
    private TextField coursIdDeleteCours;

    @FXML
    public void onClickDeleteCours() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        statement.executeUpdate("delete from cours " +
                "where id=" + Integer.parseInt(coursIdDeleteCours.getText()) + ";");
    }

    // modify cours

    @FXML
    private TextField coursIdModifyCours;
    @FXML
    private TextField nameModifyCours;
    @FXML
    private TextField photoModifyCours;
    @FXML
    private TextField qrcodeModifyCours;
    @FXML
    private ImageView qrcodeImageModifyCours;


    @FXML
    public void onClickShowQrCode() {



    }

    @FXML
    private void onClickModifyNameModifyCours() throws SQLException {

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(nameModifyCours.getText().isEmpty() == false){
            statement.executeUpdate("update cours " +
                    "set photo='" + nameModifyCours.getText() + "' where id=" +
                    Integer.parseInt(coursIdModifyCours.getText()) + ";" );
        }


    }

    @FXML
    private void onClickModifyPhotoModifyCours() throws SQLException {

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(photoModifyCours.getText().isEmpty() == false){
            statement.executeUpdate("update cours " +
                    "set photo='" + photoModifyCours.getText() + "' where id=" +
                    Integer.parseInt(coursIdModifyCours.getText()) + ";" );
        }

    }

    @FXML
    private void onClickModifyQrCodeModifyCours() throws SQLException {

        Connection conn = getConnection("jdbc:mysql://localhost:3306/filsscheduler","root","nutebaga");

        Statement statement = conn.createStatement();

        if(qrcodeModifyCours.getText().isEmpty() == false){
            statement.executeUpdate("update cours " +
                    "set qrcode='" + qrcodeModifyCours.getText() + "' where id=" +
                    Integer.parseInt(coursIdModifyCours.getText()) + ";" );
        }

    }


}
