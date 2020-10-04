package com.base.bawbaw.model;

public class Bmi {

    //declare private attributes
    private long weight;
    private long height;
    private String breed;
    private String gender;

    //create default constructor
    public Bmi() {
    }

    //overloaded constructor for all private attributes
    public Bmi(long weight, long height, String breed, String gender) {
        this.weight = weight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
    }

    //get method to get private attribute weight
    public long getWeight() {
        return weight;
    }

    //set method to set value for private attribute weight
    public void setWeight(long weight) {
        this.weight = weight;
    }

    //get method to get private attribute height
    public long getHeight() {
        return height;
    }

    //set method to set value for private attribute height
    public void setHeight(long height) {
        this.height = height;
    }

    //get method to get private attribute breed
    public String getBreed() {
        return breed;
    }

    //set method to set value for private attribute breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    //get method to get private attribute gender
    public String getGender() {
        return gender;
    }

    //set method to set value for private attribute gender
    public void setGender(String gender) {
        this.gender = gender;
    }
}
