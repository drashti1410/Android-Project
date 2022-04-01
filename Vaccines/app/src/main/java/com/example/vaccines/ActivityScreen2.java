package com.example.vaccines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityScreen2 extends AppCompatActivity {
    MyDatabase myDatabase = null;
    PatientDAO patientDAO = null;
    ListView lvPatients;
    ArrayList<Patient> patientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2_vaccines_list);

        this.myDatabase = MyDatabase.getDatabase(getApplicationContext());
        this.patientDAO = this.myDatabase.patientDAO();

        patientList = (ArrayList<Patient>) patientDAO.getAllEligiblePatients();

        PatientsAdapter patientsAdapter = new PatientsAdapter(this, patientList);

        lvPatients = findViewById(R.id.lvPatients);
        lvPatients.setAdapter(patientsAdapter);
        lvPatients.setOnItemClickListener(patientSelected);

    }

    AdapterView.OnItemClickListener patientSelected = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + patientList.get(position).phoneNumber));

            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            }
        }
    };

    public void goBackPressed(View view) {
        // goes back to the previous screen
        finish();
    }

    public void sortPressed(View view) {
        patientList.clear();
        patientList = (ArrayList<Patient>) patientDAO.getAllEligiblePatientsSorted();
        PatientsAdapter patientsAdapter = new PatientsAdapter(this, patientList);
        lvPatients.setAdapter(patientsAdapter);
        lvPatients.setOnItemClickListener(patientSelected);
    }

    public void clearListPressed(View view) {
        this.patientDAO.delete();
        lvPatients.setAdapter(null);
    }
}