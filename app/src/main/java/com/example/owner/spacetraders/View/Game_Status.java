package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.spacetraders.R;

public class Game_Status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_game__status);

        Button inventoryButton = findViewById(R.id.inventory_button);

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInventoryPressed(v);
            }
        });
    }

    public void onInventoryPressed(View view) {

        startActivity(new Intent(Game_Status.this, Inventory.class));

        finish();
    }
}
