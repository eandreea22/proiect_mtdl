package com.example.proiect_mtdl;

public class Notes {

    private int id = 0;
    private String name;
    private String content;

    public Notes(String name, String content) {
        this.id ++;
        this.name = name;
        this.content = content;
    }

    public Notes() {

    }

    public int getNotesId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}