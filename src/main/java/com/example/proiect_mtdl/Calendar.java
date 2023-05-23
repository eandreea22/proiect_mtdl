package com.example.proiect_mtdl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendar {


    private ArrayList<GregorianCalendar> exams = new ArrayList<GregorianCalendar>();

    public Calendar() {
    }


    public void addExamen(GregorianCalendar exam){
        exams.add(exam);
    }

    public void removeExamen(GregorianCalendar exam){
        exams.remove(exam);
    }
}
