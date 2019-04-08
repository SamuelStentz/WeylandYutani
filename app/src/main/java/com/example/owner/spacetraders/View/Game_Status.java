package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Item;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Game_Status extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private GameState game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_game__status);

        game = Model.getInst().getGame();

        TextView credits = findViewById(R.id.credits_text);
        TextView location = findViewById(R.id.planet_location_text);
        TextView fuel = findViewById(R.id.fuel_text);

        mDatabase = FirebaseDatabase.getInstance().getReference();;

        Button inventoryButton = findViewById(R.id.inventory_button);
        Button tradeButton = findViewById(R.id.trade_info);
        Button travelButton = findViewById(R.id.travel_button);

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInventoryPressed();
            }
        });

        tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTradePressed();
            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTravelPressed();
            }
        });

        Button save = findViewById(R.id.save_exit_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSavePressed();
            }
        });

        credits.setText(String.format("%d", game.getPlayer().getCredits()));
        location.setText(String.format("%s", game.getPosition().getName()));
        fuel.setText(String.format("%.2f", game.getPlayer().getShip().getCurrentFuel()));
    }


    public void onSavePressed() {
        mDatabase.child("Player").child("Name").setValue(game.getPlayer().getName());
        mDatabase.child("Player").child("Credits").setValue(game.getPlayer().getCredits());
        mDatabase.child("Player").child("PilotSkill").setValue(game.getPlayer().getPilotSkill());
        mDatabase.child("Player").child("FighterSkill").setValue(game.getPlayer().getFighterSkill());
        mDatabase.child("Player").child("TraderSkill").setValue(game.getPlayer().getTraderSkill());
        mDatabase.child("Player").child("EngineerSkill").setValue(game.getPlayer().getEngineerSkill());
        //mDatabase.child("Player").child("Inventory").setValue(game.getPlayer().getInventory());
        mDatabase.child("SpaceShip").child("Capacity").setValue(game.getPlayer().getShip().getCapacity());
        mDatabase.child("SpaceShip").child("Fuel").setValue(game.getPlayer().getShip().getCurrentFuel());
        mDatabase.child("Items").setValue(Item.ITEM_LIST);
        mDatabase.child("Position").setValue(game.getPositionIndex(game.getPosition()));


        startActivity(new Intent(Game_Status.this, MainActivity.class));
        finish();
    }
    private void onInventoryPressed() {

        startActivity(new Intent(Game_Status.this, Inventory.class));

        finish();
    }

    private void onTradePressed() {

        startActivity(new Intent(Game_Status.this, Market.class));

        finish();
    }

    private void onTravelPressed() {

        startActivity(new Intent(Game_Status.this, Travel.class));



        finish();
    }
}
