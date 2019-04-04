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

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_inventory);

        GameState game = Model.getInst().getGame();

        TextView cC = findViewById(R.id.current_capacity_text);
        TextView mC = findViewById(R.id.maximum_capacity_text);

        TextView water = findViewById(R.id.inventory_water_quantity);
        TextView furs = findViewById(R.id.inventory_furs_quantity);
        TextView food = findViewById(R.id.inventory_food_quantity);
        TextView ore = findViewById(R.id.inventory_ore_quantity);
        TextView games = findViewById(R.id.inventory_games_quantity);
        TextView firearms = findViewById(R.id.inventory_firearms_quantity);
        TextView medicine = findViewById(R.id.inventory_medicine_quantity);
        TextView machines = findViewById(R.id.inventory_machines_quantity);
        TextView narcotics = findViewById(R.id.inventory_narcotics_quantity);
        TextView robots = findViewById(R.id.inventory_robots_quantity);

        cC.setText(String.format("%d", game.getPlayer()
                .getInventory().getCapacity()));
        mC.setText(String.format("%d", game.getPlayer()
                .getShip().getCapacity()));

        water.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(1))));
        furs.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(3))));
        food.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(2))));
        ore.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(4))));
        games.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(5))));
        firearms.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(6))));
        medicine.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(7))));
        machines.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(8))));
        narcotics.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(9))));
        robots.setText(String.format("%d", game.getPlayer()
                .getInventory().getQuantity(Item.ITEM_LIST.get(10))));

        Button inventoryReturn = findViewById(R.id.inventory_return_button);

        inventoryReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInventoryReturnPressed();
            }
        });
    }

    private void onInventoryReturnPressed() {

        startActivity(new Intent(Inventory.this, Game_Status.class));

        finish();
    }

}
