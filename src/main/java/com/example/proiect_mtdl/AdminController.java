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
import java.sql.ResultSet;


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
    public void onClickLoadUsers() throws Exception {



        ObservableList<User> users = FXCollections.observableArrayList();

        ResultSet resultSet = DatabaseConnection.getInstance().LoadUsers();

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
    public void onClickAddAccount2() throws Exception {

        if (userTypeAddAccount.getText().equals("student")){

            DatabaseConnection.getInstance().AddStudent(last_name.getText(), first_name.getText(),
                    email.getText(), password.getText(), userTypeAddAccount.getText(),  university.getText(),
                    Integer.parseInt(uni_year.getText()), specialisation.getText(),
                    uni_group.getText());


        } else if (userTypeAddAccount.getText().equals("teacher")) {

            DatabaseConnection.getInstance().AddTeacher(last_name.getText(), first_name.getText(),
                    email.getText(), password.getText(), userTypeAddAccount.getText(),  university.getText(),
                    degree.getText());
        }


        degree.clear();
        last_name.clear();
        first_name.clear();
        email.clear();
        password.clear();
        userTypeAddAccount.clear();
        university.clear();
        uni_year.clear();
        specialisation.clear();
        uni_group.clear();
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
    public void onClickDelete() throws Exception{

        DatabaseConnection.getInstance().DeleteAccount(Integer.parseInt(userId_deleteAccount.getText()));
        userId_deleteAccount.clear();

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
    private void onClickModifyPassword() throws Exception{


        if(password_modifyAccount.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyPassword(password_modifyAccount.getText(), Integer.parseInt(userId_modifyAccount.getText()));
            password_modifyAccount.clear();
        }

    }

    @FXML
    private void onClickModifyUserType() throws Exception{

        if(userType_modifyAccount.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyUserType(userType_modifyAccount.getText(), Integer.parseInt(userId_modifyAccount.getText()));
            userType_modifyAccount.clear();
        }

    }

    @FXML
    private void onClickModifyUniversity() throws Exception{


        if(university_modifyAccount.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyUniversity(university_modifyAccount.getText(), Integer.parseInt(userId_modifyAccount.getText()));
            university_modifyAccount.clear();
        }

    }

    @FXML
    private void onClickModifyYear() throws Exception{


        if(uni_year_modifyAccount.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyYear(Integer.parseInt(uni_year_modifyAccount.getText()), Integer.parseInt(userId_modifyAccount.getText()));
            uni_year_modifyAccount.clear();
        }

    }

    @FXML
    private void onClickModifySpecialisation() throws Exception{

        if(specialisation_modifyAccount.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifySpecilisation(Integer.parseInt(userId_modifyAccount.getText()), specialisation_modifyAccount.getText());
            specialisation_modifyAccount.clear();
        }

    }

    @FXML
    private void onClickModifyGroup() throws Exception{

        if(uni_group_modifyAccount.getText().isEmpty() == false){

            DatabaseConnection.getInstance().ModifyGroup(uni_group_modifyAccount.getText(), Integer.parseInt(userId_modifyAccount.getText()));
            uni_group.clear();
        }

    }

    @FXML
    private void onClickModifyDegree() throws Exception{


        if(degree_modifyAccount.getText().isEmpty() == false){

            DatabaseConnection.getInstance().ModifyDegree(degree_modifyAccount.getText(), Integer.parseInt(userId_modifyAccount.getText()));
            degree_modifyAccount.clear();
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
    public void onClickLoadCourses() throws Exception {

        ObservableList<Cours> courses = FXCollections.observableArrayList();

        ResultSet resultSet = DatabaseConnection.getInstance().LoadCourses();
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
    public void onClickAddCours() throws Exception{

        DatabaseConnection.getInstance().AddCours(coursNameAddCours.getText(), photoAddCours.getText());
        coursIdDeleteCours.clear();
        coursNameAddCours.clear();
    }

    // delete cours
    @FXML
    private TextField coursIdDeleteCours;

    @FXML
    public void onClickDeleteCours() throws Exception{

        DatabaseConnection.getInstance().DeleteCours(Integer.parseInt(coursIdDeleteCours.getText()));
        coursIdDeleteCours.clear();

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
    private void onClickModifyNameModifyCours() throws Exception {

        if(nameModifyCours.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyNameCours(nameModifyCours.getText(), Integer.parseInt(coursIdModifyCours.getText()));
            nameModifyCours.clear();

        }


    }

    @FXML
    private void onClickModifyPhotoModifyCours() throws Exception {


        if(photoModifyCours.getText().isEmpty() == false){
            DatabaseConnection.getInstance().ModifyPhotoCours(photoModifyCours.getText(), Integer.parseInt(coursIdModifyCours.getText()));
            photoModifyCours.clear();

        }

    }

    @FXML
    private void onClickModifyQrCodeModifyCours() throws Exception {


        if(qrcodeModifyCours.getText().isEmpty() == false){

            DatabaseConnection.getInstance().ModifyQrCodeCours(qrcodeModifyCours.getText(), Integer.parseInt(coursIdModifyCours.getText()));
            qrcodeModifyCours.clear();
        }

    }

    @FXML
    public void onClickShowQrCode() throws Exception{

//        String stringForQrCode = DatabaseConnection.getInstance().GetQrCodeModifyCours(Integer.parseInt(coursIdModifyCours.getText()));
//        ByteArrayOutputStream out = QRCode.from(stringForQrCode).to(ImageType.JPG).stream();
//
//        File f = new File("@../../../images/logo.jpeg");
//        FileOutputStream fos = new FileOutputStream(f);
//        fos.write(out.toByteArray());
//        fos.flush();
//
//        qrcodeImageModifyCours.setImage(new Image(f.getAbsolutePath()));

    }


}
