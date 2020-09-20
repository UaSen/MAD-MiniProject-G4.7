package com.base.bawbaw.model;

public class Pet {

    private int petId;
    private String name;
    private String birthday;
    private float wight;
    private float height;
    private String breed;
    private String gender;
    private String colour;
    private String spots;
    private String signs;

    public Pet() {
    }

    public Pet(int petId, String name, String birthday, float wight, float height, String breed, String gender, String colour, String spots, String signs) {
        this.petId = petId;
        this.name = name;
        this.birthday = birthday;
        this.wight = wight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
        this.colour = colour;
        this.spots = spots;
        this.signs = signs;
    }

    public Pet(String name, String birthday, float wight, float height, String breed, String gender, String colour, String spots, String signs) {
        this.name = name;
        this.birthday = birthday;
        this.wight = wight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
        this.colour = colour;
        this.spots = spots;
        this.signs = signs;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getWight() {
        return wight;
    }

    public void setWight(float wight) {
        this.wight = wight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

    public String getSigns() {
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }
}
