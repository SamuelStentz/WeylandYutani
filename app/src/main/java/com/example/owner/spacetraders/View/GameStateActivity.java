package com.example.owner.spacetraders.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;
import com.example.owner.spacetraders.Model.Difficulty;

public class GameStateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestate_main);
    }
}
