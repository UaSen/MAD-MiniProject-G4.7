/**
 * Baw Baw 2020
 *
 * @author Senarathna A.M.U.A.
 * IT19214030
 * Y2S2 4.
 * MAD
 *
 */
package com.base.bawbaw.model;

public class Owner {

    //declare private attributes
    private int id;
    private String name;
    private String address;
    private int age;
    private String mobile;

    //create default constructor
    public Owner() {
    }

    //overloaded constructor for all private attributes
    public Owner(int id, String name, String address, int age, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.mobile = mobile;
    }

    //overloaded constructor for private attributes without ID
    public Owner(String name, String address, int age, String mobile) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.mobile = mobile;
    }

    //get method to get private attribute id
    public int getId() {
        return id;
    }

    //set method to set value for private attribute id
    public void setId(int id) {
        this.id = id;
    }

    //get method to get private attribute name
    public String getName() {
        return name;
    }

    //set method to set value for private attribute name
    public void setName(String name) {
        this.name = name;
    }

    //get method to get private attribute address
    public String getAddress() {
        return address;
    }

    //set method to set value for private attribute address
    public void setAddress(String address) {
        this.address = address;
    }

    //get method to get private attribute age
    public int getAge() {
        return age;
    }

    //set method to set value for private attribute age
    public void setAge(int age) {
        this.age = age;
    }

    //get method to get private attribute mobile
    public String getMobile() {
        return mobile;
    }

    //set method to set value for private attribute mobile
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
