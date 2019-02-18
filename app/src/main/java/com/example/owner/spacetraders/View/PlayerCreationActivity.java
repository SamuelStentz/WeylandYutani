package com.example.owner.spacetraders.View;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;

public class PlayerCreationActivity extends AppCompatActivity {

    private PlayerViewModel viewModel;

    private EditText studentName;
    private EditText pilot;
    private EditText fighter;
    private EditText trader;
    private EditText engineer;

    private Player player;

    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_assignment);

        studentName = findViewById(R.id.student_name_input);
        pilot = findViewById(R.id.pilotPoint);
        fighter = findViewById(R.id.fighterPoint);
        trader = findViewById(R.id.traderPoint);
        engineer = findViewById(R.id.engineerPoint);



        studentName.setText(player.getName());
        pilot.setText(player.getPilotSkill());
        fighter.setText(player.getFighterSkill());
        trader.setText(player.getTraderSkill());
        engineer.setText(player.getEngineerSkill());

        viewModel = ViewModelProvider.of(this).get(PlayerViewModel.class);
    }

    public void onCreatePressed(View view) {

        player.setName(studentName.getText().toString());
        player.setPilotSkill(Integer.parseInt(pilot.getText().toString()));
        player.setFighterSkill(Integer.parseInt(fighter.getText().toString()));
        player.setTraderSkill(Integer.parseInt(trader.getText().toString()));
        player.setEngineerSkill(Integer.parseInt(engineer.getText().toString()));

        viewModel.createPlayer(player);

        finish();
    }
}
