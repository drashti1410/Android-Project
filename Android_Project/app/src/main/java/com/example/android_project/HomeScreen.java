package com.example.android_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    GujaratTourismDB db = null;

    AttractionDAO attractionDAO = null;

    SharedPreferences preferences;

    TextView favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView textView = findViewById(R.id.tvAppName);
        textView.setText("Gujarat Tourism");
        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);
        favourite=findViewById(R.id.favouriteDestinationList);



        String defaultFav=preferences.getString("favourite","");

        favourite.setText(defaultFav);
    }

    public void viewAttractionButtonPressed(View view) {

        this.db = GujaratTourismDB.getDatabase(getApplicationContext());

        this.attractionDAO = this.db.attractionDAO();

        this.attractionDAO.insert(new AttractionClass(1,"Thol Lake", "Thol village near Kalol, Gujarat","+91 79 23977200","$200","https://www.gujarattourism.com/central-zone/ahmedabad/thol-lake-sanctuary.html","One of the most popular birding hotspots of Gujarat, the 7 sq. km big Thol Lake Sanctuary offers easy access from the capital city (27km). The wetland is an open water habitat surrounded by cropland, fallow land and scrubland, which helps other mammals to co-exist. Apart from 150 species of birds, one can also spot black bucks, jackals and blue bulls in the vicinity."));
        this.attractionDAO.insert(new AttractionClass(2,"Sarkhej Roza","Sarkhej Makarba Rd, Makarba, Ahmedabad, Gujarat","+91 79 23967120","$350","https://www.gujarattourism.com/central-zone/ahmedabad/sarkhej-roza.html","Located 8 km southwest of the old centre in Makarba, Sarkhej Roza is a mosque, tomb and palace complex dedicated to the memory of Ahmed Shah I’s spiritual advisor, Ahmed Khattu Ganj Baksh. The elegant, though dilapidated, buildings cluster around a great tank, constructed by Sultan Mahmud Begada (Shah’s grandson) in the mid-15th century."));
        this.attractionDAO.insert(new AttractionClass(3,"BAPS Akshardham Temple","J Road, Sector 20, Gandhinagar, Gujarat","+91-79-2562-5151","$766","https://akshardham.com/gujarat/","Akshardham literally means the divine abode of God. It is an eternal place for one to offer devotion and experience everlasting peace. Swaminarayan Akshardham at Gandhinagar is a mandir – a Hindu house of worship, a dwelling place for God, and a spiritual and cultural campus dedicated to devotion, education and unification. Timeless devotional messages and vibrant Hindu traditions are echoed in its art and architecture."));
        this.attractionDAO.insert(new AttractionClass(4,"Sabarmati Ashram","Gandhi Smarak Sangrahalaya, Ashram Rd, Ahmedabad, Gujarat","+91 79 2755 7277","$180","https://www.gujarattourism.com/central-zone/ahmedabad/sabarmati-ashram.html","Inaugurated by his contemporary Jawaharlal Nehru, Mahatma Gandhi’s erstwhile home has been converted to a simple but engaging museum. The Sabarmati Ashram, at the banks of the namesake river is fragmented into two sections – where Gandhi actually lived, and the modern section conceived by architect Charles Correa."));



        Intent i = new Intent(this, AttractionList.class);
        startActivity(i);


    }

    public void OnClickLogout(View view) {
//        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}