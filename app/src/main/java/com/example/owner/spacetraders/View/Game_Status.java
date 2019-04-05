package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Planet;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.Model.SolarSystem;
import com.example.owner.spacetraders.Model.Spaceship;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game_Status extends AppCompatActivity {

    private TextView credits;
    private TextView location;
    private TextView fuel;

    private GameState game;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_game__status);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        game = Model.getInst().getGame();

        credits = findViewById(R.id.credits_text);
        location = findViewById(R.id.planet_location_text);
        fuel = findViewById(R.id.fuel_text);

        Button inventoryButton = findViewById(R.id.inventory_button);
        Button tradeButton = findViewById(R.id.trade_info);
        Button travelButton = findViewById(R.id.travel_button);


        Button saveExitButton = findViewById(R.id.save_exit_button);

        saveExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSavePressed(v);
            }
        });

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInventoryPressed(v);
            }
        });

        tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTradePressed(v);
            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTravelPressed(v);
            }
        });

        credits.setText(String.format("%d", game.getPlayer().getCredits()));
        fuel.setText(String.format("%.2f", game.getPlayer().getShip().getCurrentFuel()));
        location.setText(String.format("%s", game.getPosition().getName()));

}

    public void onSavePressed(View view) {
        mDatabase.child("Player").child("Name").setValue(game.getPlayer().getName());
        mDatabase.child("Player").child("Credits").setValue(game.getPlayer().getCredits());
        mDatabase.child("Player").child("PilotSkill").setValue(game.getPlayer().getPilotSkill());
        mDatabase.child("Player").child("FighterSkill").setValue(game.getPlayer().getFighterSkill());
        mDatabase.child("Player").child("TraderSkill").setValue(game.getPlayer().getTraderSkill());
        mDatabase.child("Player").child("EngineerSkill").setValue(game.getPlayer().getEngineerSkill());
        mDatabase.child("SpaceShip").child("Capacity").setValue(game.getPlayer().getShip().getCapacity());
        mDatabase.child("SpaceShip").child("Fuel").setValue(game.getPlayer().getShip().getCurrentFuel());
//
//
//
//        List<SolarSystem> ss = game.getPosition().getSolarSystem();
//        for (int i = 0; i < ss.size(); i++) {
//            mDatabase.child("Solar System").child("Name").setValue(ss.get(i).getName());
//            mDatabase.child("Solar System").child("Tech Level").setValue(ss.get(i).getTechLevel());
//            mDatabase.child("Solar System").child("Resource Level").setValue(ss.get(i).getResourceLevel());
//        }
        startActivity(new Intent(Game_Status.this, MainActivity.class));

    }

    public void onInventoryPressed(View view) {


        startActivity(new Intent(Game_Status.this, Inventory.class));

        finish();
    }

    public void onTradePressed(View view) {

        startActivity(new Intent(Game_Status.this, Market.class));

        finish();
    }

    public void onTravelPressed(View view) {

        startActivity(new Intent(Game_Status.this, Travel.class));



        finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
