package com.example.proiect_mtdl;

public class Notes {

    private int id = 0;
    private String nom;
    private String content;

    public Notes(String nom, String content) {
        this.id ++;
        this.nom = nom;
        this.content = content;
    }

    public Notes() {

    }

    public int getNotesId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}