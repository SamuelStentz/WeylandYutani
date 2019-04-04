package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;

public class Game_Status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_game__status);

        GameState game = Model.getInst().getGame();

        TextView credits = findViewById(R.id.credits_text);
        TextView location = findViewById(R.id.planet_location_text);
        TextView fuel = findViewById(R.id.fuel_text);

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

        credits.setText(String.format("%d", game.getPlayer().getCredits()));
        location.setText(String.format("%s", game.getPosition().getName()));
        fuel.setText(String.format("%.2f", game.getPlayer().getShip().getCurrentFuel()));
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
