package com.example.proiect_mtdl;

import java.util.ArrayList;

public class Courses {

    private int id= 0;
    private String nom;
    private ArrayList<String> materiaux = new ArrayList<String>();
    private String photo;
    private ArrayList<Etudiant> list_etudiant = new ArrayList<Etudiant>();
    private Calendaire calendaire;
    private ArrayList<Tache> taches = new ArrayList<Tache>();

    public Courses(){
    }

    public Courses(String nom){
        this.id++;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<String> getMateriaux() {
        return materiaux;
    }

    public void addMateriaux(String m) {
        materiaux.add(m);
    }

    public ArrayList<Etudiant> getList_etudiant() {
        return list_etudiant;
    }

    public void addEtudiant(Etudiant etudiant) {
        list_etudiant.add(etudiant);
    }

    public void removeEtudiant(Etudiant etudiant){
        list_etudiant.remove(etudiant);
    }

    public Calendaire getCalendaire() {
        return calendaire;
    }

    public void setCalendaire(Calendaire calendaire) {
        this.calendaire = calendaire;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void addTache(Tache tache) {
        taches.add(tache);
    }

    public void removeTache(int idtache){

        taches.remove(idtache);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}