package com.example.android_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GujaratTourismDB db = null;

    RegistrationDAO regDao = null;
    EditText etUserName,etPassword;
    CheckBox rememberMe;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvAppName);
        textView.setText("Gujarat Tourism");


        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);

        if(preferences.getBoolean("loginChkBox",false)){
            Intent intent=new Intent(this,HomeScreen.class);
            startActivity(intent);
        }

        this.db = GujaratTourismDB.getDatabase(getApplicationContext());
        this.regDao = this.db.regDAO();

        this.regDao.insert(new Registration(1,"thanos", "5555"));
        this.regDao.insert(new Registration(2,"wonderwoman", "abcd"));

        List<Registration> regList = this.regDao.getAllUsers();



        etUserName = findViewById(R.id.emailEdit);
        etPassword = findViewById(R.id.passwordEdit);
        rememberMe=findViewById(R.id.saveLoginCheckBox);


    }

    public void loginButtonPressed(View view) {

        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if(rememberMe.isChecked()){

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("loginChkBox",true);
            editor.putString("username",username);
            editor.putString("password",password);
            editor.apply();

        }


        int count=this.regDao.getUserNameCount(username);

        if(count==0){
            Toast.makeText(getApplicationContext(),"Username not found please enter a valid Username:---"+username,Toast. LENGTH_SHORT).show();
        }
        else {
            List<Registration> userData = this.regDao.getUser(username);

            if(userData.get(0).userName.equals(username) && userData.get(0).password.equals(password)){
                Intent intent = new Intent(this, HomeScreen.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(getApplicationContext(),"Incorrect Username/Password..",Toast. LENGTH_SHORT).show();
            }

        }
    }
}