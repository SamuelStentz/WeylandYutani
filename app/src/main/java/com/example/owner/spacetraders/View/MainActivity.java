package com.example.owner.spacetraders.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.R;

public class MainActivity extends AppCompatActivity {

    private Spinner difficultySpinner;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultySpinner = findViewById(R.id.difficultySpinner);
        Button beginGame = findViewById(R.id.beginGameButton);

        difficultySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Player.Difficulty.values()));


    }
}
