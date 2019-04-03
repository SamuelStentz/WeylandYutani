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

public class Market extends AppCompatActivity {

    private GameState game;

    private TextView techLevel;
    private TextView tradeSkill;
    private TextView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        game = Model.getInst().getGame();

        techLevel = findViewById(R.id.market_tech_text);
        tradeSkill = findViewById(R.id.market_trade_skill_text);
        credits = findViewById(R.id.market_credit_text2);

        techLevel.setText(String.format("%d", game.getPosition().getTechLevel()));
        tradeSkill.setText(String.format("%d", game.getPlayer().getTraderSkill()));
        credits.setText(String.format("%d", game.getPlayer().getCredits()));

        Button buyButton = findViewById(R.id.button);
        Button sellButton = findViewById(R.id.button2);
        Button returnButton = findViewById(R.id.button3);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBuyPressed();
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSellPressed();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReturnPressed();
            }
        });
    }

    private void onBuyPressed() {

        startActivity(new Intent(Market.this, Purchase.class));

        finish();
    }

    private void onSellPressed() {

        startActivity(new Intent(Market.this, Sell_Interface.class));

        finish();
    }

    private void onReturnPressed() {

        startActivity(new Intent(Market.this, Game_Status.class));

        finish();
    }
}
