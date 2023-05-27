package com.example.proiect_mtdl;

import java.util.ArrayList;

public class Cours {

    private int id;
    private String name;
    private ArrayList<String> materials = new ArrayList<String>();
    private String photo;
    private ArrayList<Student> list_student = new ArrayList<Student>();
    private Calendar calendar;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    public Cours(){
    }

    public Cours(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public void addMateriaux(String m) {
        materials.add(m);
    }

    public ArrayList<Student> getList_etudiant() {
        return list_student;
    }

    public void addEtudiant(Student student) {
        list_student.add(student);
    }

    public void removeEtudiant(Student student){
        list_student.remove(student);
    }

    public Calendar getCalendaire() {
        return calendar;
    }

    public void setCalendaire(Calendar calendar) {
        this.calendar = calendar;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void addTache(Assignment assignment) {
        assignments.add(assignment);
    }

    public void removeTache(int idtache){

        assignments.remove(idtache);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}