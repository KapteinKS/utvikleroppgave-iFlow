package com.example.utvikleroppgave_iflow_v2;

import java.util.Date;

public class Hour {
    private int id;
    private String project;
    private String date;
    private int hours;
    private String comment;

    public Hour() {
    }

    public Hour(int id, String project, int hours, String comment) {
        this.id = id;
        this.project = project;
        this.hours = hours;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
