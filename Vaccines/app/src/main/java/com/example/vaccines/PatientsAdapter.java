package com.example.vaccines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientsAdapter extends ArrayAdapter<Patient> {
    public PatientsAdapter(Context context, ArrayList<Patient> patients) {
        super(context, 0, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Patient patient = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }

        TextView tvPriority = (TextView) convertView.findViewById(R.id.tvPrority);
        tvPriority.setText(String.valueOf(patient.priorityNumber));

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(patient.name);

        TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);
        tvAge.setText(String.valueOf(patient.age));

        TextView tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvPhoneNumber);
        tvPhoneNumber.setText(patient.phoneNumber);

        return convertView;
    }
}