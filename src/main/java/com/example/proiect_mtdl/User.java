package com.example.proiect_mtdl;

import java.util.ArrayList;

public abstract class User {

    private int id = 0;
    private String last_name;
    private String first_name;
    private String email;
    private String password;
    private String photo;
    private String university;
    private ArrayList<Cours> cours = new ArrayList<Cours>();
    private ArrayList<Notes> notes = new ArrayList<Notes>();
    private String userType;


    public User(int id, String last_name, String first_name, String email, String password, String university, String userType) {

        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.password = password;
        this.university = university;
        this.userType = userType;
    }

    public User(int id, String email, String first_name,  String last_name,  String userType) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<Cours> getCourses() {
        return cours;
    }

    public void addCourses(Cours cours) {
        this.cours.add(cours);
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void addNotes(Notes note) {
        notes.add(note);
    }

    
}
