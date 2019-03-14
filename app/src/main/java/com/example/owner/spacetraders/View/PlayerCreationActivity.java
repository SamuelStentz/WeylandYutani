package com.example.owner.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;

public class PlayerCreationActivity extends AppCompatActivity {

    private PlayerViewModel viewModel;

    private EditText playerName;
    private EditText pilot;
    private EditText fighter;
    private EditText trader;
    private EditText engineer;

    //private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_assignment);

        playerName = findViewById(R.id.student_name_input);
        pilot = findViewById(R.id.pilotPoint);
        fighter = findViewById(R.id.fighterPoint);
        trader = findViewById(R.id.traderPoint);
        engineer = findViewById(R.id.engineerPoint);
        Button createPlayer = findViewById(R.id.createPlayer);
        Button cancelCreation = findViewById(R.id.cancelCreation);

        createPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreatePressed(v);
            }
        });

        cancelCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onCreatePressed(View view) {
        if (playerName.getText().toString().equals("")) {
            Toast.makeText(PlayerCreationActivity.this, "Must enter a name for your character.", Toast.LENGTH_LONG).show();
            return;
        } else if (pilot.getText().toString().equals("") || fighter.getText().toString().equals("")
                || trader.getText().toString().equals("") || engineer.getText().toString().equals("")) {
            Toast.makeText(PlayerCreationActivity.this, "All skill sections must be filled.", Toast.LENGTH_LONG).show();
            return;
        }
        String name = playerName.getText().toString();
        int pilotPoints = Integer.parseInt(pilot.getText().toString());
        int fighterPoints = Integer.parseInt(fighter.getText().toString());
        int traderPoints = Integer.parseInt(trader.getText().toString());
        int engineerPoints = Integer.parseInt(engineer.getText().toString());

        if(pilotPoints + fighterPoints + traderPoints + engineerPoints != 16
            || pilotPoints < 0 || fighterPoints < 0 || traderPoints < 0 || engineerPoints < 0) {
            Toast.makeText(PlayerCreationActivity.this, "You need to slot exactly 16 skill points. Negative skill points are not allowed.", Toast.LENGTH_LONG).show();
            return;
        }
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        viewModel.init(name, pilotPoints, fighterPoints, traderPoints, engineerPoints);

        startActivity(new Intent(PlayerCreationActivity.this, Game_Status.class));
//        Log.d("Name", viewModel.getPlayer().getName());
//        Log.d("pilot", Integer.toString(viewModel.getPlayer().getPilotSkill()));
//        Log.d("fighter", Integer.toString(viewModel.getPlayer().getFighterSkill()));
//        Log.d("trader", Integer.toString(viewModel.getPlayer().getTraderSkill()));
//        Log.d("engineer", Integer.toString(viewModel.getPlayer().getEngineerSkill()));
//        Log.d("Credits", Integer.toString(viewModel.getPlayer().getCredits()));


        finish();
    }
}
