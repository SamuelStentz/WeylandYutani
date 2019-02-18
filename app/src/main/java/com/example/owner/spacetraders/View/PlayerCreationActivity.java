package com.example.owner.spacetraders.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_assignment);

        playerName = findViewById(R.id.student_name_input);
        pilot = findViewById(R.id.pilotPoint);
        fighter = findViewById(R.id.fighterPoint);
        trader = findViewById(R.id.traderPoint);
        engineer = findViewById(R.id.engineerPoint);

    }

    public void onCreatePressed(View view) {
        String name = playerName.getText().toString();
        int pilotPoints = Integer.parseInt(pilot.getText().toString());
        int fighterPoints = Integer.parseInt(trader.getText().toString());
        int traderPoints = Integer.parseInt(trader.getText().toString());
        int engineerPoints = Integer.parseInt(engineer.getText().toString());

        if(pilotPoints + fighterPoints + traderPoints + engineerPoints != 16) {
            Toast.makeText(PlayerCreationActivity.this, "You need to slot exactly 16 skill points", Toast.LENGTH_LONG).show();
            return;
        }

        viewModel.createPlayer(name, pilotPoints, fighterPoints, traderPoints, engineerPoints);

        finish();
    }
}
