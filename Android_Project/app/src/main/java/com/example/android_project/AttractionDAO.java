package com.example.android_project;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface AttractionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(AttractionClass attractionClass);


    @Query("SELECT * FROM attraction_table")
    public List<AttractionClass> getAllAttractions();

    @Query("SELECT * FROM attraction_table where id=:id")
    public List<AttractionClass> getAttraction(int id);

    @Query("SELECT * FROM attraction_table where name=:userName")
    public List<AttractionClass> getUser(String userName);

    // Get the total number of employees from the employee table
    // what is the database going to send back?
    @Query("SELECT COUNT(*) from attraction_table")
    public int getTotalEmployees();

    @Query("SELECT COUNT(*) from attraction_table where name =:name")
    public int getUserNameCount(String name);


    // Let's make a function that lets the user delete everything from the employees table
    @Query("DELETE FROM attraction_table")
    public int deleteAllEmployees();
}
