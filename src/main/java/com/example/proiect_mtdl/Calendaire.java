package com.example.proiect_mtdl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendaire {


    private ArrayList<GregorianCalendar> examens = new ArrayList<GregorianCalendar>();

    public Calendaire() {
    }


    public void addExamen(GregorianCalendar examen){
        examens.add(examen);
    }

    public void removeExamen(GregorianCalendar examen){
        examens.remove(examen);
    }
}
