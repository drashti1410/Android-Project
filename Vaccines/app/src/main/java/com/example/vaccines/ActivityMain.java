package com.example.vaccines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {
    String name;
    boolean isEligible;
    int age;
    String phoneNumber;
    int priorityNumber;
    MyDatabase myDatabase = null;
    PatientDAO patientDAO = null;
    EditText etName;
    EditText etAge;
    EditText etPhoneNumber;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myDatabase = MyDatabase.getDatabase(getApplicationContext());
        this.patientDAO = this.myDatabase.patientDAO();

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        tvResult = findViewById(R.id.tvResults);

    }

    public void signupPressed(View view) {

        name = etName.getText().toString();
        age = Integer.parseInt(etAge.getText().toString());
        phoneNumber = etPhoneNumber.getText().toString();

        String upTo3Characters = "237";

        isEligible = isEligible(age);
        if (isEligible) {
            if ((age >= 40 && age < 65) || upTo3Characters.equals(phoneNumber.substring(0, Math.min(phoneNumber.length(), 3)))) {
                priorityNumber = 3;
            } else if (age >= 65 && age < 80) {
                priorityNumber = 2;
            } else if (age >= 80) {
                priorityNumber = 1;
            }
        } else {
            priorityNumber = -1;
        }

        tvResult = findViewById(R.id.tvResults);
        if (isEligible) {
            tvResult.setText("You are eligible for the vaccine!" + "\n" + "You are priority #" + priorityNumber);
        } else {
            tvResult.setText("Sorry, you are not eligible to receive the vaccine at this time" + "\n" + "You are not over 40 and you don’t have an eligible phone number");
        }

        this.patientDAO.insert(new Patient(name, age, phoneNumber, isEligible, priorityNumber));
        etName.getText().clear();
        etAge.getText().clear();
        etPhoneNumber.getText().clear();
    }

    public void checkCurrentListPressed(View view) {
        tvResult.setText("");
        Intent i = new Intent(this, ActivityScreen2.class);
        startActivity(i);
    }

    public boolean isEligible(int age) {
        if (age >= 40) {
            return true;
        } else {
            return false;
        }
    }
}