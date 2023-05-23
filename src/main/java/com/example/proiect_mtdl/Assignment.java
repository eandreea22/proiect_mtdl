package com.example.proiect_mtdl;


import java.util.GregorianCalendar;

public class Assignment {

    private int id = 0;
    private String name;
    private String demand;
    private GregorianCalendar deadline;
    private String submit;

    public Assignment(String name) {
        this.id++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public GregorianCalendar getDeadline() {
        return deadline;
    }

    public void setDeadline(GregorianCalendar deadline) {
        this.deadline = deadline;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
}
