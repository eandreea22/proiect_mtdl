package com.example.proiect_mtdl;

import java.util.GregorianCalendar;

public class Professeur extends User{

    private String niveau;

    public Professeur(String nom, String prenom, String email, String mot_passe, String faculte, String user_type) {
        super(nom, prenom, email, mot_passe, faculte, user_type);
        this.niveau = niveau;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void addEtudiant(int idcours, Etudiant etudiant){
        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).addEtudiant(etudiant);
            }
        }
    }

    public void removeEtudiant(int idcours, Etudiant etudiant){
        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).removeEtudiant(etudiant);
            }
        }
    }

    public void addExamen(int idcours, GregorianCalendar examen){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).getCalendaire().addExamen(examen);
            }
        }
    }

    public void removeExamen(int idcours, GregorianCalendar examen){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).getCalendaire().removeExamen(examen);
            }
        }
    }

    public void addTache(int idcours, Tache tache){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).addTache(tache);
            }
        }
    }

    public void removeTache(int idcours, int idtache){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).removeTache(idtache);
            }
        }
    }

}
