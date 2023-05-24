package com.example.proiect_mtdl;

public class DataSingleton {

    private static final DataSingleton instance = new DataSingleton();

    private Teacher teacher;


    public DataSingleton() {}

    public static DataSingleton getInstance() {
        return instance;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
