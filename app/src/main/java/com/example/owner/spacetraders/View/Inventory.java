package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.spacetraders.R;

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_inventory);

        Button inventoryReturn = findViewById(R.id.inventory_return_button);

        inventoryReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInventoryReturnPressed(v);
            }
        });
    }

    public void onInventoryReturnPressed(View view) {

        startActivity(new Intent(Inventory.this, Game_Status.class));

        finish();
    }

}
