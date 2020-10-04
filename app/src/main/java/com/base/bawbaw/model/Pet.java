package com.base.bawbaw.model;

public class Pet {

    //declare private attributes
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
    private byte[] image;

    //create default constructor
    public Pet() {
    }

    //overloaded constructor for all private attributes
    public Pet(int petId, String name, String birthday, float wight, float height, String breed, String gender, String colour, String spots, String signs,byte[] image) {
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
        this.image = image;
    }

    //overloaded constructor for private attributes without image
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

    //overloaded constructor for private attributes without ID
    public Pet(String name, String birthday, float wight, float height, String breed, String gender, String colour, String spots, String signs,byte[] image) {
        this.name = name;
        this.birthday = birthday;
        this.wight = wight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
        this.colour = colour;
        this.spots = spots;
        this.signs = signs;
        this.image = image;
    }

    //get method to get private attribute petId
    public int getPetId() {
        return petId;
    }

    //set method to set value for private attribute petId
    public void setPetId(int petId) {
        this.petId = petId;
    }

    //get method to get private attribute name
    public String getName() {
        return name;
    }

    //set method to set value for private attribute name
    public void setName(String name) {
        this.name = name;
    }

    //get method to get private attribute birthday
    public String getBirthday() {
        return birthday;
    }

    //set method to set value for private attribute birthday
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //get method to get private attribute wight
    public float getWight() {
        return wight;
    }

    //set method to set value for private attribute wight
    public void setWight(float wight) {
        this.wight = wight;
    }

    //get method to get private attribute height
    public float getHeight() {
        return height;
    }

    //set method to set value for private attribute height
    public void setHeight(float height) {
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

    //get method to get private attribute colour
    public String getColour() {
        return colour;
    }

    //set method to set value for private attribute colour
    public void setColour(String colour) {
        this.colour = colour;
    }

    //get method to get private attribute spots
    public String getSpots() {
        return spots;
    }

    //set method to set value for private attribute spots
    public void setSpots(String spots) {
        this.spots = spots;
    }

    //get method to get private attribute signs
    public String getSigns() {
        return signs;
    }

    //set method to set value for private attribute signs
    public void setSigns(String signs) {
        this.signs = signs;
    }

    //get method to get private attribute image
    public byte[] getImage() {
        return image;
    }

    //set method to set value for private attribute image
    public void setImage(byte[] image) {
        this.image = image;
    }
}
