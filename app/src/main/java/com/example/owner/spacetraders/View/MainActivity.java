package com.example.owner.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.Model.SolarSystem;
import com.example.owner.spacetraders.Model.Spaceship;
import com.example.owner.spacetraders.Model.Universe;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;
import com.example.owner.spacetraders.Model.Difficulty;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Button load_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FirebaseApp.initializeApp(MainActivity.this);
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_main);

        Spinner difficultySpinner = findViewById(R.id.difficultySpinner);
        Button beginGame = findViewById(R.id.beginGameButton);

        PlayerViewModel mViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        difficultySpinner.setAdapter(new ArrayAdapter(this, android.R.
                layout.simple_spinner_item, Difficulty.values()));

        beginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayerCreationActivity.class));
            }
        });
        load_button = findViewById(R.id.LoadGameButton);
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoadPressed(v);
            }
        });

    }

    public void onLoadPressed(View view) {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() == 0) {
                    Toast.makeText(getApplicationContext(), "There is no saved game", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, PlayerCreationActivity.class));
                } else {
                    String name = (String) dataSnapshot.child("Player").child("Name").getValue();
                    int pilot = Integer.valueOf(dataSnapshot.child("Player").child("PilotSkill").getValue().toString());
                    int fighter = Integer.valueOf(dataSnapshot.child("Player").child("FighterSkill").getValue().toString());
                    int trader = Integer.valueOf(dataSnapshot.child("Player").child("TraderSkill").getValue().toString());
                    int engineer = Integer.valueOf(dataSnapshot.child("Player").child("EngineerSkill").getValue().toString());
                    GameState game = Model.getInst().getGame();
                    Player player = new Player(name, pilot, engineer, trader, fighter);
                    game.setPlayer(player);
                    game.getPlayer().setCredits((int) Integer.valueOf(dataSnapshot.child("Player").child("Credits").getValue().toString()));
                    Spaceship s = new Spaceship();
                    s.setCurrentFuel((double) Double.valueOf(dataSnapshot.child("SpaceShip").child("Fuel").getValue().toString()));
                    game.getPlayer().setShip(s);
                    Universe univ = new Universe();
                    game.setUniverse(univ);
                    List<SolarSystem> solarSystems = new ArrayList<>(univ.getStar().keySet());
                    game.setPositionIndex(Integer.valueOf(dataSnapshot.child("Position").getValue().toString()));

                    startActivity(new Intent(MainActivity.this, Game_Status.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
