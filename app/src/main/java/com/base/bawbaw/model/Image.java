package com.base.bawbaw.model;

public class Image {

    //declare private attributes
    private int id;
    private byte[] image;

    //create default constructor
    public Image() {
    }

    //overloaded constructor for all private attributes
    public Image(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    //overloaded constructor without id
    public Image(byte[] image) {
        this.image = image;
    }

    //get method to get private attribute id
    public int getId() {
        return id;
    }

    //set method to set value for private attribute id
    public void setId(int id) {
        this.id = id;
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
