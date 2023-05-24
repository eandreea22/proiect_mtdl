package com.example.proiect_mtdl;

import java.util.GregorianCalendar;

public class Teacher extends User{

    private String degree;


    public Teacher(int id,String last_name, String first_name, String email, String password, String university, String userType, String degree) {
        super(id, last_name, first_name, email, password, university, userType);
        this.degree = degree;
    }

    public Teacher(int id, String email, String first_name, String last_name, String userType) {
        super(id, email, first_name, last_name, userType);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void addEtudiant(int idcours, Student student){
        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).addEtudiant(student);
            }
        }
    }

    public void removeEtudiant(int idcours, Student student){
        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).removeEtudiant(student);
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

    public void addTache(int idcours, Assignment assignment){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                getCourses().get(i).addTache(assignment);
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
