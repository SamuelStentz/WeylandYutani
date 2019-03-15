package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;
import com.example.owner.spacetraders.ViewModel.PlayerViewModel;

public class Game_Status extends AppCompatActivity {

    private TextView credits;
    private TextView location;

    private GameState game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_game__status);

        game = Model.getInst().getGame();

        credits = findViewById(R.id.credits_text);
        location = findViewById(R.id.planet_location_text);

        Button inventoryButton = findViewById(R.id.inventory_button);
        Button tradeButton = findViewById(R.id.trade_info);

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

        credits.setText(String.format("%d", game.getPlayer().getCredits()));
        location.setText(game.getPosition().getName());
    }

    public void onInventoryPressed(View view) {

        startActivity(new Intent(Game_Status.this, Inventory.class));

        finish();
    }

    public void onTradePressed(View view) {

        startActivity(new Intent(Game_Status.this, Market.class));

        finish();
    }
}
