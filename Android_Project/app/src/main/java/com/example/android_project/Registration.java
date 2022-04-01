package com.example.android_project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="registration_table")
public class Registration {

    @PrimaryKey
    int id;
    String userName;
    String password;

    public Registration(int id,String userName,String password){
        this.id=id;
        this.userName=userName;
        this.password=password;
    }
}
