package com.example.vaccines;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatientDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Patient patient);

    @Query("SELECT * FROM patients")
    public List<Patient> getAllPatients();

    @Query("SELECT * FROM patients WHERE isEligible = 1 ORDER BY id ASC")
    public List<Patient> getAllEligiblePatients();

    @Query("SELECT * FROM patients WHERE isEligible = 1 ORDER BY priorityNumber ASC, id ASC")
    public List<Patient> getAllEligiblePatientsSorted();

    @Query("DELETE FROM patients")
    public void delete();
}
