package com.example.a1starter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveButtonPressed(View view) {
        Toast t = Toast.makeText(this, "Rating saved!", Toast.LENGTH_SHORT);
        t.show();
    }

}