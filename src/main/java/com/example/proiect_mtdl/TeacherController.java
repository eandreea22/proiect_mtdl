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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TeacherController{

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    Label labelNameWelcome;

    public String email;

    public void setNameWelcome(String s) throws Exception{
        labelNameWelcome.setText(s);

    }

    @FXML
    private TableView nameCourses;
    @FXML
    private TableColumn nameTable;
    @FXML
    private TableColumn idCoursTable;

    public void setCourses(int idteacher) throws Exception{

        ArrayList<Cours> cours = DatabaseConnection.getInstance().getTeacherCourses(idteacher);
        ObservableList<Cours> cours1 = FXCollections.observableArrayList(cours);


        nameTable.setCellValueFactory(
                new PropertyValueFactory<Cours, String>("name")
        );
        idCoursTable.setCellValueFactory(
                new PropertyValueFactory<Cours, Integer>("id")
        );

        nameCourses.setItems(cours1);
        nameCourses.refresh();
    }


    @FXML
    private TableView namesStudents;
    @FXML
    private TableColumn last_nameStudents;
    @FXML
    private TableColumn first_nameStudents;
    @FXML
    private TableColumn idStudents;

    public void setStudent(int idteacher) throws Exception{

        ArrayList<Student> students = DatabaseConnection.getInstance().getTeacherStudents(idteacher);
        ObservableList<Student> students1 = FXCollections.observableArrayList(students);


        first_nameStudents.setCellValueFactory(
                new PropertyValueFactory<Student, String>("first_name")
        );
        last_nameStudents.setCellValueFactory(
                new PropertyValueFactory<Student, String>("last_name")
        );
        idStudents.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("id")
        );

        namesStudents.setItems(students1);
        namesStudents.refresh();
    }


    @FXML
    Label nameShowStudent;
    @FXML
    Label emailShowStudent;
    @FXML
    private Label universityShowStudent;
    @FXML
    private Label specialisationShowStudent;
    @FXML
    private Label yearShowStudent;
    @FXML
    private Label groupShowStudent;
    @FXML
    TextField idStudentShowStudent;

    public void setDataStudent(int idStudent) throws Exception{

        Student student = DatabaseConnection.getInstance().returnStudent(idStudent);

        nameShowStudent.setText("   " + student.getFirst_name() + " " + student.getLast_name());
        emailShowStudent.setText("   " + student.getEmail());
        yearShowStudent.setText("   " + Integer.toString(student.getUni_year()));
        groupShowStudent.setText("   " + student.getGroup());
        universityShowStudent.setText("   " + student.getUniversity());
        specialisationShowStudent.setText("   " + student.getSpecialisation());
    }
    @FXML
    public void onClickViewStudent(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherShowStudent.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        TeacherController teacherController = loader.getController();

        teacherController.setDataStudent(Integer.parseInt(idStudentShowStudent.getText()));


        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.show();
    }

    @FXML
    private Label nameViewCours;
    @FXML
    private TableView studentsViewCours;
    @FXML
    private TableColumn idStudentViewCours;
    @FXML
    private TableColumn first_nameStudentViewCours;
    @FXML
    private TableColumn last_nameStudentViewCours;

    @FXML
    private TableView tableAssignment;
    @FXML
    private TableColumn tableNameAssignment;
    @FXML
    private TableColumn tableDeadlineAssignment;

    public void setDataViewCours() throws Exception{
        nameViewCours.setText(DatabaseConnection.getInstance().getCours().getName());

        ArrayList<Student> students = DatabaseConnection.getInstance().getCoursStudents(DatabaseConnection.getInstance().getCours().getId());
        ObservableList<Student> students1 = FXCollections.observableArrayList(students);


        first_nameStudentViewCours.setCellValueFactory(
                new PropertyValueFactory<Student, String>("first_name")
        );
        last_nameStudentViewCours.setCellValueFactory(
                new PropertyValueFactory<Student, String>("last_name")
        );
        idStudentViewCours.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("id")
        );

        studentsViewCours.setItems(students1);
        studentsViewCours.refresh();


        ArrayList<Assignment> assignments = DatabaseConnection.getInstance().getCoursAssignments(DatabaseConnection.getInstance().getCours().getId());
        ObservableList<Assignment> assignments1 = FXCollections.observableArrayList(assignments);

        tableNameAssignment.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name")
        );
        tableDeadlineAssignment.setCellValueFactory(
                new PropertyValueFactory<Assignment, Date>("deadline")
        );
        tableAssignment.setItems(assignments1);
        tableAssignment.refresh();
    }

    @FXML
    private TextField idCoursShowCours;
    public void onClickViewCours(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherViewCours.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        DatabaseConnection.getInstance().setCours(Integer.parseInt(idCoursShowCours.getText()));
        TeacherController teacherController = loader.getController();
        teacherController.setDataViewCours();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cours Page " + DatabaseConnection.getInstance().getCours().getName());
        stage.show();
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

    public void onClickRemoveStudent(ActionEvent event) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherMainPage.fxml"));
        root = loader.load();

        DatabaseConnection.getInstance().RemoveStudent(emailShowStudent.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);


        stage.setTitle("Main Page");
        stage.show();
    }

    @FXML
    private Label nameManageAccount;
    @FXML
    private Label emailManageAccount;
    @FXML
    private Label universityManageAccount;
    @FXML
    private Label degreeManageAccount;

    public void setData(Teacher teacher) throws Exception{

        emailManageAccount.setText("   " + teacher.getEmail());
        nameManageAccount.setText("   " + teacher.getFirst_name() + " " + teacher.getLast_name());
        universityManageAccount.setText("   " + teacher.getUniversity());
        degreeManageAccount.setText("   " + teacher.getDegree());

    }


    public void onClickManageAccount(ActionEvent event) throws IOException, Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("manageAccount.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Teacher user;
        user = DatabaseConnection.getInstance().getTeacher();
        TeacherController teacherController = loader.getController();
        teacherController.setData(user);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Manage Account");
        stage.show();

    }

    @FXML
    private Label nameNotes1;
    @FXML
    private Label nameNotes2;
    @FXML
    private Label nameNotes3;
    @FXML
    private TextArea notes1;
    @FXML
    private TextArea notes2;
    @FXML
    private TextArea notes3;

    public void SetNotes(int idUser) throws Exception{

        ArrayList<Notes> notes = DatabaseConnection.getInstance().getNotes(idUser);


        for (int i=0; i<notes.size();i++){

            if (i==0){
                if (notes.get(i).getName() != null){
                    nameNotes1.setText(notes.get(i).getName());
                    nameNotes1.setVisible(true);
                }

                if (notes.get(i).getContent() != null){
                    notes1.setText(notes.get(i).getContent());

                }
                notes1.setVisible(true);

            }
            if (i==1){
                if (notes.get(i).getName() != null){
                    nameNotes2.setText(notes.get(i).getName());
                    nameNotes2.setVisible(true);
                }

                if (notes.get(i).getContent() != null){
                    notes2.setText(notes.get(i).getContent());
                }
                notes2.setVisible(true);
            }
            if (i==2){
                if (notes.get(i).getName() != null){
                    nameNotes3.setText(notes.get(i).getName());
                    nameNotes3.setVisible(true);
                }

                if (notes.get(i).getContent() != null){
                    notes3.setText(notes.get(i).getContent());
                }
                notes3.setVisible(true);
            }
        }
    }

    @FXML
    public void onClickNotes(ActionEvent event) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        TeacherController teacherController = loader.getController();
        teacherController.SetNotes(DatabaseConnection.getInstance().getTeacher().getId());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notes");
        stage.show();
    }

    @FXML
    public void onClickModifyNote() throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
        root = loader.load();

        TeacherController teacherController = loader.getController();
        teacherController.SetNotes(DatabaseConnection.getInstance().getTeacher().getId());
        DatabaseConnection.getInstance().setNote(DatabaseConnection.getInstance().getTeacher().getId(), notes1.getText(), nameNotes1.getText());
        DatabaseConnection.getInstance().setNote(DatabaseConnection.getInstance().getTeacher().getId(), notes2.getText(), nameNotes2.getText());
        DatabaseConnection.getInstance().setNote(DatabaseConnection.getInstance().getTeacher().getId(), notes3.getText(), nameNotes3.getText());


    }
    @FXML
    private TextField newNote;

    @FXML
    public void onClickAddNote(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        DatabaseConnection.getInstance().addNote(DatabaseConnection.getInstance().getTeacher().getId(), newNote.getText());
        TeacherController teacherController = loader.getController();
        teacherController.SetNotes(DatabaseConnection.getInstance().getTeacher().getId());

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notes");
        stage.show();
    }



    @FXML
    public void onClickDeleteNote(ActionEvent event) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        DatabaseConnection.getInstance().deleteNote(DatabaseConnection.getInstance().getTeacher().getId(), newNote.getText());
        TeacherController teacherController = loader.getController();
        teacherController.SetNotes(DatabaseConnection.getInstance().getTeacher().getId());

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notes");
        stage.show();

    }


    // manage account

    @FXML
    public void onClickBackMainPage(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherMainPage.fxml"));
        root = loader.load();

        TeacherController teacherController = loader.getController();
        teacherController.setNameWelcome(DatabaseConnection.getInstance().getTeacher().getFirst_name());
        teacherController.setStudent(DatabaseConnection.getInstance().getTeacher().getId());
        teacherController.setCourses(DatabaseConnection.getInstance().getTeacher().getId());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);


        stage.setTitle("Main Page");
        stage.show();
    }

    @FXML
    TextField newPasswordManageAccount;
    @FXML
    TextField oldPasswordManageAccount;
    @FXML
    private TextField photoManageAccount;
    @FXML
    private ImageView profilePicture;
    @FXML
    public void onClickModifyPassword() throws Exception{


        if (oldPasswordManageAccount.getText().equals(DatabaseConnection.getInstance().getTeacher().getPassword())){

            DatabaseConnection.getInstance().ModifyPassword(newPasswordManageAccount.getText(), DatabaseConnection.getInstance().getTeacher().getId());
            newPasswordManageAccount.clear();
            oldPasswordManageAccount.clear();
        }

    }

    @FXML
    private ImageView profilePhoto;
    @FXML
    public void onClickModifyPhoto() throws Exception {

        DatabaseConnection.getInstance().ModifyPhoto(DatabaseConnection.getInstance().getTeacher().getId(), photoManageAccount.getText());
        photoManageAccount.clear();
    }

    @FXML
    public void onClickLogout(){
        Platform.exit();
        System.exit(0);
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    String nameWelcome;
    public String getNameWelcome() {
        return nameWelcome;
    }

    @FXML
    public void onClickEditCoursPage(ActionEvent event) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherEditCoursPage.fxml"));
        root = loader.load();

//        TeacherController teacherController = loader.getController();
//        teacherController.setNameWelcome(DatabaseConnection.getInstance().getTeacher().getFirst_name());
//        teacherController.setStudent(DatabaseConnection.getInstance().getTeacher().getId());
//        teacherController.setCourses(DatabaseConnection.getInstance().getTeacher().getId());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);


        stage.setTitle("Edit Cours " + DatabaseConnection.getInstance().getCours().getName());
        stage.show();
    }


    @FXML
    private TextField newCoursName;

    @FXML
    public void onClickModifyCoursName() throws Exception{
        DatabaseConnection.getInstance().getCours().setName(newCoursName.getText());
        DatabaseConnection.getInstance().ModifyNameCours(newCoursName.getText(), DatabaseConnection.getInstance().getCours().getId());
    }

    @FXML
    private TextField newCoursPhoto;

    @FXML
    public void onClickModifyCoursPhoto() throws Exception{
        DatabaseConnection.getInstance().getCours().setPhoto(newCoursPhoto.getText());
        DatabaseConnection.getInstance().ModifyPhotoCours(newCoursPhoto.getText(), DatabaseConnection.getInstance().getCours().getId());
    }

    @FXML
    private TextField newQrCode;

    @FXML
    public void onClickModifyQrCode() throws Exception{
        DatabaseConnection.getInstance().ModifyQrCodeCours(newQrCode.getText(), DatabaseConnection.getInstance().getCours().getId());
    }

    @FXML
    private TextField nameAssignment;
    @FXML
    private TextArea demandAssignment;
    @FXML
    private TextField deadlineAssignment;
    @FXML
    public void onClickAddAssignment() throws Exception{
        String[] date = deadlineAssignment.getText().split("/");
        GregorianCalendar g = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

        DatabaseConnection.getInstance().getCours().addTache
                (new Assignment(nameAssignment.getText(),g, demandAssignment.getText()));
        DatabaseConnection.getInstance().addAssignment(DatabaseConnection.getInstance().getCours().getId(), nameAssignment.getText(), deadlineAssignment.getText(), demandAssignment.getText());
        nameAssignment.clear();
        demandAssignment.clear();
        deadlineAssignment.clear();
    }




}

