package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumberForTigers = new Random().nextInt(101);
    int randomNumberForWerewolves = new Random().nextInt(101);
    TextView tvForResult = findViewById(R.id.resultsLabel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fightButtonPressed(View view) {
        // By default, the VIEW HISTORY button is disabled.
        // This code will enable it after the person presses the FIGHT button.
        Button viewHistoryButton = findViewById(R.id.btnViewHistory);
        viewHistoryButton.setEnabled(true);

        TextView tvForTiger = findViewById(R.id.tvTigersScore);
        tvForTiger.setText(String.valueOf(randomNumberForTigers));

        TextView tvForWerewolves = findViewById(R.id.tvWerewolvesScore);
        tvForWerewolves.setText(String.valueOf(randomNumberForWerewolves));

        if (randomNumberForTigers >= randomNumberForWerewolves) {
            tvForResult.setText("The winner is: Tigers");
        } else {
            tvForResult.setText("The winner is: Werewolves");
        }

    }
    public void viewHistoryPressed(View view) {
        Game gameObject = new Game(randomNumberForTigers,randomNumberForWerewolves, tvForResult.getText().toString());
        Intent intent = new Intent(this, GameAdapter.class);
        intent.putExtra("GameResult", gameObject);

        startActivity(intent);
    }
}