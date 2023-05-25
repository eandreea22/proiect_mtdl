package com.example.proiect_mtdl;

public class DataSingleton {

    private static final DataSingleton instance = new DataSingleton();

    private String email;


    public DataSingleton() {}

    public static DataSingleton getInstance() {
        return instance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
