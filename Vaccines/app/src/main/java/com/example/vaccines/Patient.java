package com.example.vaccines;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "patients")
public class Patient implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;

    String name;
    int age;
    String phoneNumber;
    boolean isEligible;
    int priorityNumber;

    public Patient(String name, int age, String phoneNumber, boolean isEligible, int priorityNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.isEligible = isEligible;
        this.priorityNumber = priorityNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isEligible=" + isEligible +
                ", priorityNumber=" + priorityNumber +
                '}';
    }
}
