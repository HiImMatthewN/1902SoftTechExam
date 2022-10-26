package com.nantesmatthew.a1902softwaretechexam.common.credentials.data.entites;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "credentials_table")
public class CredentialsLocalEntity {
    @PrimaryKey()
    @ColumnInfo(name = "user_name")
    @NonNull
    private String userName;
    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    public CredentialsLocalEntity(@NonNull String userName, @NonNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
