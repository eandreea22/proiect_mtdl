package com.example.proiect_mtdl;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();
    Connection conn;
    Statement statement;

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

}
