package com.example.android_project;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RegistrationDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Registration registration);

    @Query("SELECT * FROM registration_table")
    public List<Registration> getAllUsers();

    @Query("SELECT * FROM registration_table where userName=:userName")
    public List<Registration> getUser(String userName);

    // Get the total number of employees from the employee table
    // what is the database going to send back?
    @Query("SELECT COUNT(*) from registration_table")
    public int getTotalEmployees();

    @Query("SELECT COUNT(*) from registration_table where userName =:userName")
    public int getUserNameCount(String userName);


    // Let's make a function that lets the user delete everything from the employees table
    @Query("DELETE FROM registration_table")
    public int deleteAllEmployees();
}
