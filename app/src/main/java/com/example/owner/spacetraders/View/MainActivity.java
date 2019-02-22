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

import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;

public class MainActivity extends AppCompatActivity {

    private Spinner difficultySpinner;

    private PlayerViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultySpinner = findViewById(R.id.difficultySpinner);
        Button beginGame = findViewById(R.id.beginGameButton);

        mViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        difficultySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Player.Difficulty.values()));

        beginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayerCreationActivity.class));
            }
        });

    }
}
