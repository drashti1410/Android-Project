package com.example.android_project;
import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="attraction_table")
public class AttractionClass implements Serializable {

    @PrimaryKey
    int id;

    String name;
    String address;
    String phoneNumber;
    String price;
    String website;
    String locationDetails;



    public AttractionClass(int id,String name,String address,String phoneNumber,String price,String website,String locationDetails){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.price =price;
        this.website=website;
        this.locationDetails=locationDetails;
    }
}
