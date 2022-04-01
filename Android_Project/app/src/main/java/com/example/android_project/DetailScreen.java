package com.example.android_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class DetailScreen extends AppCompatActivity {

    GujaratTourismDB db = null;
    AttractionDAO attractionDAO = null;
    List<AttractionClass> attraction;

    TextView tvName,tvAddress,tvWebsite,tvPhone,tvPrice;
    RatingBar ratingBar;
//    CheckBox addToFavChk;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        TextView textView = findViewById(R.id.tvAppName);
        textView.setText("Gujarat Tourism");

        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);

        Intent i=getIntent();
        AttractionClass attractionClass = (AttractionClass) i.getSerializableExtra("attraction");

        this.db = GujaratTourismDB.getDatabase(getApplicationContext());
        this.attractionDAO = this.db.attractionDAO();

        attraction=this.attractionDAO.getAttraction(attractionClass.id);

        tvName=findViewById(R.id.tvName);
        tvAddress=findViewById(R.id.tvAddress);
        tvWebsite=findViewById(R.id.tvWebsite);
        tvPrice=findViewById(R.id.tvPricing);
        tvPhone=findViewById(R.id.tvPhone);
        String tempImgName=attraction.get(0).name;

        tvName.setText(attraction.get(0).name);
        tvAddress.setText(attraction.get(0).address);
        tvWebsite.setText(attraction.get(0).website);
        tvPrice.setText(attraction.get(0).price);
        tvPhone.setText(attraction.get(0).phoneNumber);
        ImageView imgView=(ImageView) findViewById(R.id.ivImage);

        String nameWithoutExtension = attractionClass.name.replaceAll("\\s+","").toLowerCase();

        String uri = "@drawable/"+nameWithoutExtension;
        int imageresource=getResources().getIdentifier(uri,null,getPackageName());
        Drawable res=getResources().getDrawable(imageresource);
        imgView.setImageDrawable(res);

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+attraction.get(0).phoneNumber));
                startActivity(intent);
            }
        });

        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(attraction.get(0).website));
                startActivity(intent);
            }
        });





//        addToFavChk=findViewById(R.id.addToFavCheckBox);
//        if(addToFavChk.isChecked()){
//
//            SharedPreferences.Editor editor = preferences.edit();
//
//            String defaultFav=preferences.getString("favourite","");
//
//            editor.putString("favourite",defaultFav+"\n"+attraction.get(0).name);
//
//            editor.apply();
//        }
    }

    public void OnClickLogout(View view) {
        this.preferences=getSharedPreferences("tourismSharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}