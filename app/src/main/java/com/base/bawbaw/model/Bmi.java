package com.base.bawbaw.model;

public class Bmi {

    private long weight;
    private long height;
    private String breed;
    private String gender;

    public Bmi() {
    }

    public Bmi(long weight, long height, String breed, String gender) {
        this.weight = weight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
