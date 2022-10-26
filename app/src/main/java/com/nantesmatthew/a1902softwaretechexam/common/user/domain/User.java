package com.nantesmatthew.a1902softwaretechexam.common.user.domain;

public class User {
    private String fullName;
    private String email;
    private String userName;
    private String designation;
    private String information;


    public User(String fullName, String email, String userName) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
    }

    public User(String fullName, String email, String userName, String designation, String information) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.designation = designation;
        this.information = information;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getInformation() {
        return information;
    }
}
