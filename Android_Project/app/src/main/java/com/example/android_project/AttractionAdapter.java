package com.example.android_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AttractionAdapter extends ArrayAdapter<AttractionClass> {
    Context ctx;
    public AttractionAdapter(Context context, List<AttractionClass> attractions) {

        super(context, 0, attractions);
        ctx=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AttractionClass attraction = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lv_row_layout, parent, false);
        }

        TextView tvPlaceName = (TextView) convertView.findViewById(R.id.tvPlaceName);
        TextView tvPlaceAddress = (TextView) convertView.findViewById(R.id.tvPlaceAddress);
        TextView tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvPhoneNumber);
        ImageView ivAttraction = (ImageView) convertView.findViewById(R.id.ivAttraction);

           String nameWithoutExtension = attraction.name.replaceAll("\\s+","").toLowerCase();
           int imageID = convertView.getResources().getIdentifier(nameWithoutExtension, "drawable", convertView.getContext().getPackageName());
           ivAttraction.setImageDrawable(convertView.getResources().getDrawable(imageID));

        tvPlaceName.setText(attraction.name);
        tvPlaceAddress.setText(attraction.address);
        tvPhoneNumber.setText(attraction.phoneNumber);

        return convertView;
    }

}
