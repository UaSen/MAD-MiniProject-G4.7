package com.base.bawbaw.model;

public class addvetmodel {


    private int id;
    private String name, email,address,workhours,contactumber,notes;
    private long started, finished;

    public addvetmodel(){

    }

    public addvetmodel(int id, String name, String email, String address, String workhours, String contactumber, String notes, long started, long finished) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.workhours = workhours;
        this.contactumber = contactumber;
        this.notes = notes;
        this.started = started;
        this.finished = finished;
    }

    public addvetmodel(String name, String email, String address, String workhours, String contactumber, String notes, long started, long finished) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.workhours = workhours;
        this.contactumber = contactumber;
        this.notes = notes;
        this.started = started;
        this.finished = finished;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkhours() {
        return workhours;
    }

    public void setWorkhours(String workhours) {
        this.workhours = workhours;
    }

    public String getContactumber() {
        return contactumber;
    }

    public void setContactumber(String contactumber) {
        this.contactumber = contactumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
