package com.example.proiect_mtdl;

public class Etudiant extends User{

    private int annee;
    private String specialisation;
    private String groupe;

    public Etudiant(String nom, String prenom, String email, String mot_passe, String faculte, int annee, String specialisation, String groupe, String user_type) {
        super(nom, prenom, email, mot_passe, faculte, user_type);
        this.annee = annee;
        this.specialisation = specialisation;
        this.groupe = groupe;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void removeSubmit(int idcours, int idtache){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                for (int j=0; j<getCourses().get(i).getTaches().size()-1;i++ ){
                    if (getCourses().get(i).getTaches().get(j).getId() == idtache ){
                        getCourses().get(i).getTaches().get(j).setSubmit("");
                        break;
                    }
                }
            }
        }
    }

    public void addSubmit(int idcours, int idtache, String submit){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                for (int j=0; j<getCourses().get(i).getTaches().size()-1;i++ ){
                    if (getCourses().get(i).getTaches().get(j).getId() == idtache ){
                        getCourses().get(i).getTaches().get(j).setSubmit(submit);
                        break;
                    }
                }
            }
        }
    }
}
