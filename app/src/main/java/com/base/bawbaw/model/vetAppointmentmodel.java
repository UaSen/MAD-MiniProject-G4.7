package com.base.bawbaw.model;

public class vetAppointmentmodel {

    private int aid;
    private String title, vname,date,time,anotes;
    private long started, finished;


    public vetAppointmentmodel(){

    }

    public vetAppointmentmodel(int aid, String title, String vname, String date, String time, String anotes, long started, long finished) {
        this.aid = aid;
        this.title = title;
        this.vname = vname;
        this.date = date;
        this.time = time;
        this.anotes = anotes;
        this.started = started;
        this.finished = finished;
    }

    public vetAppointmentmodel(String title, String vname, String date, String time, String anotes, long started, long finished) {
        this.title = title;
        this.vname = vname;
        this.date = date;
        this.time = time;
        this.anotes = anotes;
        this.started = started;
        this.finished = finished;
    }


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAnotes() {
        return anotes;
    }

    public void setAnotes(String anotes) {
        this.anotes = anotes;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}


