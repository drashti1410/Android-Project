package com.example.android_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AttractionList extends AppCompatActivity {

    GujaratTourismDB db = null;

    AttractionDAO attractionDAO = null;
    SharedPreferences preferences;
    ArrayList<AttractionClass> arraylist;
    List<AttractionClass> attractionClassList;
//    ArrayList<Attraction> attractionArrayList = new ArrayList<Attraction>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);
        TextView textView = findViewById(R.id.tvAppName);
        textView.setText("Gujarat Tourism");

        this.db = GujaratTourismDB.getDatabase(getApplicationContext());

        this.attractionDAO = this.db.attractionDAO();
//        attractionClassList=this.attractionDAO.getAllAttractions();
        arraylist=(ArrayList<AttractionClass>) this.attractionDAO.getAllAttractions();



        AttractionAdapter attractionAdapter = new AttractionAdapter(this, arraylist);

        ListView lvAttractionList = findViewById(R.id.lvAttractions);
        lvAttractionList.setAdapter(attractionAdapter);



        lvAttractionList.setOnItemClickListener(countryRowClicked);

    }

    AdapterView.OnItemClickListener countryRowClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            AttractionClass attractionClass = arraylist.get(i);


            Intent intent = new Intent(getApplicationContext(), DetailScreen.class);
            intent.putExtra("attraction",attractionClass);
            startActivity(intent);
        }
    };

    public void OnClickLogout(View view) {
        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}