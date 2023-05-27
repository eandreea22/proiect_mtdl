package com.example.proiect_mtdl;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();
    Connection conn;
    Statement statement;

    private Teacher teacher;
    private Student student;

    private DatabaseConnection() {

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filsscheduler", "root", "nutebaga");
            this.statement = this.conn.createStatement();

        } catch (Exception e){
            System.out.println("error");
        }
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void ConnectUser(String email, String password) throws Exception{

        ResultSet resultSet = statement.executeQuery("select * from users " +
                "where email='" + email + "' " +
                "and password='" + password + "';");

        while (resultSet.next()){

            if (resultSet.getString("userType").equals("student")){

                int id = Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String university = resultSet.getString("university");
                int year = Integer.parseInt(resultSet.getString("uni_year"));
                String group = resultSet.getString("uni_group");
                String specialisation = resultSet.getString("specialisation");

                this.student = new Student(id, last_name, first_name, email, password, university, year, specialisation, group, "student");

            }else if (resultSet.getString("userType").equals("teacher")){

                int id = Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String university = resultSet.getString("university");
                String degree = resultSet.getString("degree");

                this.teacher = new Teacher(id, last_name, first_name, email, password, university,"teacher", degree);

            }
        }
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public Student getStudent() {return student; }
    public ResultSet getUserDetails(String email) throws Exception{

        return statement.executeQuery("select * from users " +
                "where email='" + email + "';");
    }



    public ResultSet LoadUsers() throws Exception{

        return statement.executeQuery("select * from users ");
    }


    public void AddTeacher(String last_name, String first_name, String email, String password, String userType, String university, String degree) throws Exception{

        statement.executeUpdate("insert into users " +
                "(last_name,first_name,email,password,userType,university,degree)" +
                " values ('" +
                last_name + "','" +
                first_name + "','" +
                email + "','" +
                password + "','" +
                userType + "','" +
                university + "','" +
                degree + "');"
        );
    }

    public void AddStudent(String last_name, String first_name, String email, String password, String userType, String university, int year, String specialisation, String uni_group) throws Exception{

        statement.executeUpdate("insert into users " +
                " (last_name,first_name,email,password,userType,university,uni_year,specialisation,uni_group)" +
                " values ('" +
                last_name + "','" +
                first_name + "','" +
                email + "','" +
                password + "','" +
                userType + "','" +
                university +  "'," +
                year + ",'" +
                specialisation + "','" +
                uni_group +"');"
        );
    }

    public void DeleteAccount(int userId) throws Exception{
        statement.executeUpdate("delete from users " +
                "where id=" + userId + ";");

    }

    public void ModifyPassword(String password, int userId) throws Exception{
        statement.executeUpdate("update users " +
                "set password='" + password + "' where id=" +
                userId + ";" );

    }

    public void ModifyUserType(String userType, int userId) throws Exception{

        statement.executeUpdate("update users " +
                "set userType='" + userType + "' where id=" +
                userId + ";" );

    }

    public void ModifyUniversity(String university, int userId) throws Exception{

        statement.executeUpdate("update users " +
                "set university='" + university+ "' where id=" +
                userId + ";" );

    }

    public void ModifyYear(int year, int userId) throws Exception{

        statement.executeUpdate("update users " +
                "set uni_year=" + year + " where id=" +
                userId + ";" );

    }

    public void ModifySpecilisation(int userId, String specialisation) throws Exception{

        statement.executeUpdate("update users " +
                "set specialisation='" + specialisation + "' where id=" +
                userId+ ";" );


    }

    public void ModifyGroup(String group, int userId) throws Exception{
        statement.executeUpdate("update users " +
                "set uni_group='" + group + "' where id=" +
                userId+ ";" );

    }

    public void ModifyDegree(String degree, int userId) throws Exception{

        statement.executeUpdate("update users " +
                "set degree='" + degree + "' where id=" +
                userId + ";" );

    }

    public ResultSet LoadCourses() throws Exception{

        return statement.executeQuery("select * from cours ");

    }

    public void AddCours(String name, String photo) throws Exception{
        statement.executeUpdate("insert into cours" +
                " (name, photo) values ('" +
                name + "','" + photo+ "');");

    }

    public void DeleteCours(int id) throws Exception{

        statement.executeUpdate("delete from cours " +
                "where id=" + id + ";");

    }

    public void ModifyNameCours(String name, int coursId) throws Exception{

        statement.executeUpdate("update cours " +
                "set name='" + name + "' where id=" +
                coursId + ";" );

    }

    public void ModifyPhotoCours(String photo, int coursId) throws Exception{
        statement.executeUpdate("update cours " +
                "set photo='" + photo + "' where id=" +
                coursId + ";" );

    }

    public void ModifyQrCodeCours(String qrcode, int coursId) throws Exception{
        statement.executeUpdate("update cours " +
                "set qrcode='" + qrcode + "' where id=" +
                coursId + ";" );

    }

    public String GetQrCodeModifyCours(int coursId) throws Exception{

        ResultSet resultSet = statement.executeQuery("select * from cours " +
                "where id=" + coursId + ";");

        while(resultSet.next()){
            return resultSet.getString("qrcode");
        }

        return null;
    }

    public void ModifyPhoto(int id, String photo) throws Exception {

        statement.executeUpdate("update users " +
                "set photo='" + photo + "' where id=" +
                id + ";" );
    }

    public ResultSet Teacher_Courses(int id) throws Exception {

        return statement.executeQuery("select * from teachercours " +
                "where idteacher=" + id + ";");
    }

    public ArrayList<Cours> getTeacherCourses(int idteacher) throws Exception{

        ArrayList<String> names_cours = new ArrayList<String>();
        ArrayList<Integer> idcours = new ArrayList<Integer>();
        ArrayList<Cours> cours = new ArrayList<Cours>();

        ResultSet resultSet = statement.executeQuery("select * from teachercours " +
                "where idteacher=" + idteacher + ";");

        while (resultSet.next()){

            idcours.add(resultSet.getInt("idcours"));
        }

        for (int i =0; i<idcours.size(); i++){

            ResultSet resultSet1 = statement.executeQuery("select * from cours " +
                    "where id=" + idcours.get(i) + ";");

            while (resultSet1.next()){


                names_cours.add(resultSet1.getString("name"));
            }
        }

        for (int i=0; i<idcours.size();i++){
            cours.add(new Cours(idcours.get(i), names_cours.get(i)));
        }
        return cours;
    }

    public ArrayList<Student> getTeacherStudents(int idteacher) throws Exception{

        ArrayList<String> firstname_student = new ArrayList<String>();
        ArrayList<String> lastname_student = new ArrayList<String>();
        ArrayList<Integer> idstudent = new ArrayList<Integer>();
        ArrayList<Student> students = new ArrayList<Student>();

        ResultSet resultSet = statement.executeQuery("select * from teacherstudent " +
                "where idteacher=" + idteacher + ";");

        while (resultSet.next()){

            idstudent.add(resultSet.getInt("idstudent"));
        }

        for (int i =0; i<idstudent.size(); i++){

            ResultSet resultSet1 = statement.executeQuery("select * from users " +
                    "where id=" + idstudent.get(i) + ";");

            while (resultSet1.next()){

                lastname_student.add(resultSet1.getString("last_name") );
                firstname_student.add(resultSet1.getString("first_name"));
            }
        }

        for (int i=0; i<idstudent.size();i++){
            students.add(new Student(idstudent.get(i), lastname_student.get(i), firstname_student.get(i)));
        }
        return students;
    }

    public ArrayList<Notes> getNotes(int idUser) throws Exception{

        ArrayList<String> nameNotes1 = new ArrayList<String>();
        ArrayList<String> contentNotes1 = new ArrayList<String>();
        ArrayList<String> nameNotes2 = new ArrayList<String>();
        ArrayList<String> contentNotes2 = new ArrayList<String>();
        ArrayList<String> nameNotes3 = new ArrayList<String>();
        ArrayList<String> contentNotes3 = new ArrayList<String>();
        ArrayList<Notes> notes = new ArrayList<Notes>();

        ResultSet resultSet = statement.executeQuery("select * from usernotes " +
                "where iduser=" + idUser + ";");


        while (resultSet.next()){
            notes.add(new Notes(resultSet.getString("notename"), resultSet.getString("note")));
        }

        return notes;
    }

    public ResultSet getCours(int idcours) throws Exception{

        return statement.executeQuery("select * from cours " +
                "where id=" + idcours + ";");
    }

    public void setNote(int idUser,String content, String name) throws Exception{

        statement.executeUpdate("update usernotes " +
                "set note='" + content +"'" +
                " where iduser=" + idUser + " and notename='" + name +"';");
    }

    public void addNote(int idUser, String name) throws Exception{

        if (DatabaseConnection.getInstance().getNotes(idUser).size() < 3){
            System.out.println("ok");
            statement.executeUpdate("insert into usernotes " +
                    "(iduser, notename) " +
                    "values (" + idUser + ",'" + name + "');");

        }
    }

    public void deleteNote(int idUser, String name) throws Exception{

        statement.executeUpdate("delete from usernotes " +
                "where iduser=" + idUser + " and notename='" +name +"';");
    }

    public Student returnStudent(int id) throws Exception{
        ResultSet resultSet = statement.executeQuery("select * from users " +
                "where id=" +id +";");
        String first_name= "";
        String last_name = "";
        String email ="";
        String university="";
        String specialisation="";
        String group="";
        int year=0;

        while (resultSet.next()){
            first_name = resultSet.getString("first_name");
            last_name =  resultSet.getString("last_name");
            email = resultSet.getString("email");
            university = resultSet.getString("university");
            specialisation = resultSet.getString("specialisation");
            year = resultSet.getInt("uni_year");
            group = resultSet.getString("uni_group");
        }

        return new Student(last_name, first_name, email, university, year, specialisation, group);
    }

    public void RemoveStudent(String email) throws Exception{

        ResultSet resultSet = statement.executeQuery("select * from users " +
                "where email='" + email + "';");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            statement.executeUpdate("delete from teacherstudent" +
                    " where id='" + id +"';");
        }

    }

}
