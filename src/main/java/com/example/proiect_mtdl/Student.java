package com.example.proiect_mtdl;

public class Student extends User{

    private int uni_year;
    private String specialisation;
    private String group;

    public Student(int id, String last_name, String first_name, String email, String password, String university, int uni_year, String specialisation, String group, String userType) {
        super(id, last_name, first_name, email, password, university, userType);
        this.uni_year = uni_year;
        this.specialisation = specialisation;
        this.group = group;
    }

    public Student(int id, String email, String first_name, String last_name, String userType) {
        super(id, email, first_name, last_name, userType);
    }

    public int getUni_year() {
        return uni_year;
    }

    public void setUni_year(int uni_year) {
        this.uni_year = uni_year;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void removeSubmit(int idcours, int idtache){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                for (int j = 0; j<getCourses().get(i).getAssignments().size()-1; i++ ){
                    if (getCourses().get(i).getAssignments().get(j).getId() == idtache ){
                        getCourses().get(i).getAssignments().get(j).setSubmit("");
                        break;
                    }
                }
            }
        }
    }

    public void addSubmit(int idcours, int idtache, String submit){

        for (int i=0; i<getCourses().size()-1;i++){
            if (getCourses().get(i).getId() == idcours){
                for (int j = 0; j<getCourses().get(i).getAssignments().size()-1; i++ ){
                    if (getCourses().get(i).getAssignments().get(j).getId() == idtache ){
                        getCourses().get(i).getAssignments().get(j).setSubmit(submit);
                        break;
                    }
                }
            }
        }
    }
}
