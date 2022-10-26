package com.nantesmatthew.a1902softwaretechexam.common.user.data.entites;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserLocalEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "full_name")
    private String fullName;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "designation")
    private String designation;
    @ColumnInfo(name = "information")
    private String information;

    public UserLocalEntity(String fullName, String userName, String email, String designation, String information) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.designation = designation;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getDesignation() {
        return designation;
    }
    public String getEmail() {
        return email;
    }

    public String getInformation() {
        return information;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
