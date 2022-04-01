package com.example.test1;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class GameAdapter extends ArrayAdapter<Game> {

    public GameAdapter(Context context, ArrayList<Game> listOfGames)
    {
        super(context, 0, listOfGames);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // the current game we are looking at
        Game game = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_row_layout, parent, false);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}