package com.example.owner.spacetraders.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.R;

public class Market extends AppCompatActivity {

    private GameState game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
}
