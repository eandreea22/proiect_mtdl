package com.example.proiect_mtdl;

import java.util.ArrayList;

public abstract class User {

    private int id = 0;
    private String nom;
    private String prenom;
    private String email;
    private String mot_passe;
    private String photo;
    private String faculte;
    private ArrayList<Courses> courses = new ArrayList<Courses>();
    private ArrayList<Notes> notes = new ArrayList<Notes>();
    private String user_type;


    public User(String nom, String prenom, String email, String mot_passe, String faculte, String user_type) {
        id++;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_passe = mot_passe;
        this.faculte = faculte;
        this.user_type = user_type;
    }

    public int getId() {
        return id;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public void addCourses(Courses cours) {
        courses.add(cours);
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void addNotes(Notes note) {
        notes.add(note);
    }

    
}
