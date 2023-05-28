package com.example.proiect_mtdl;


import java.util.GregorianCalendar;

public class Assignment {

    private int id;
    private String name;
    private String demand;
    private GregorianCalendar deadline;
    private String submit;

    public Assignment(String name, GregorianCalendar deadline, String demand) {
        this.name = name;
        this.deadline = deadline;
        this.demand = demand;
    }

    public Assignment(int id, String name, String demand, GregorianCalendar deadline) {
        this.id = id;
        this.name = name;
        this.demand = demand;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
