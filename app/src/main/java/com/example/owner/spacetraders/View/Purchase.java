package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Item;
import com.example.owner.spacetraders.Model.PlayerInventory;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;

public class Purchase extends AppCompatActivity {

    private GameState game;

    private TextView currentCapacity;
    private TextView maximumCapacity;
    private TextView credits;

    private TextView water;
    private TextView furs;
    private TextView food;
    private TextView ore;
    private TextView games;
    private TextView firearms;
    private TextView medicine;
    private TextView machines;
    private TextView narcotics;
    private TextView robots;

    private TextView waterS;
    private TextView fursS;
    private TextView foodS;
    private TextView oreS;
    private TextView gamesS;
    private TextView firearmsS;
    private TextView medicineS;
    private TextView machinesS;
    private TextView narcoticsS;
    private TextView robotsS;

    private EditText waterQ;
    private EditText fursQ;
    private EditText foodQ;
    private EditText oreQ;
    private EditText gamesQ;
    private EditText firearmsQ;
    private EditText medicineQ;
    private EditText machinesQ;
    private EditText narcoticsQ;
    private EditText robotsQ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        game = Model.getInst().getGame();

        currentCapacity = findViewById(R.id.current_capacity_buy_text);
        maximumCapacity = findViewById(R.id.maximum_capacity_buy_text);
        credits = findViewById(R.id.credits_buy_text);

        PlayerInventory pinv = (PlayerInventory) game.getPlayer().getInventory();
        currentCapacity.setText(String.format("%d", pinv.getCapacity()));
        maximumCapacity.setText(String.format("%d", game.getPlayer().getShip().getCapacity()));

        int startCredits = game.getPlayer().getCredits();
        credits.setText(String.format("%d", startCredits));

        water = findViewById(R.id.buy_water_price);
        furs = findViewById(R.id.buy_furs_price);
        food = findViewById(R.id.buy_food_price);
        ore = findViewById(R.id.buy_ore_price);
        games = findViewById(R.id.buy_games_price);
        firearms = findViewById(R.id.buy_firearms_price);
        medicine = findViewById(R.id.buy_medicine_price);
        machines = findViewById(R.id.buy_machines_price);
        narcotics = findViewById(R.id.buy_narcotics_price);
        robots = findViewById(R.id.buy_robots_price);

        waterQ = findViewById(R.id.buy_water_quantity);
        foodQ = findViewById(R.id.food_buy_amount);
        fursQ = findViewById(R.id.furs_buy_amount);
        oreQ = findViewById(R.id.ore_buy_amount);
        gamesQ = findViewById(R.id.games_buy_amount);
        firearmsQ = findViewById(R.id.firearms_buy_amount);
        medicineQ = findViewById(R.id.medicine_buy_amount);
        machinesQ = findViewById(R.id.machines_buy_amount);
        narcoticsQ = findViewById(R.id.narcotics_buy_amount);
        robotsQ = findViewById(R.id.robots_buy_amount);

        waterQ = findViewById(R.id.water_buy_amount);
        foodQ = findViewById(R.id.food_buy_amount);
        fursQ = findViewById(R.id.furs_buy_amount);
        oreQ = findViewById(R.id.ore_buy_amount);
        gamesQ = findViewById(R.id.games_buy_amount);
        firearmsQ = findViewById(R.id.firearms_buy_amount);
        medicineQ = findViewById(R.id.medicine_buy_amount);
        machinesQ = findViewById(R.id.machines_buy_amount);
        narcoticsQ = findViewById(R.id.narcotics_buy_amount);
        robotsQ = findViewById(R.id.robots_buy_amount);

        int[] prices = new int[10];
        for(int i = 0; i < prices.length; i++) {
            prices[i] =  game.getPosition().getTrader().getInventory().getPrice(Item.ITEM_LIST.get(i + 1)) + 10;
        }

        water.setText(String.format("%d", prices[0]));
        food.setText(String.format("%d", prices[1]));
        furs.setText(String.format("%d", prices[2]));
        ore.setText(String.format("%d", prices[3]));
        games.setText(String.format("%d", prices[4]));
        firearms.setText(String.format("%d", prices[5]));
        medicine.setText(String.format("%d", prices[6]));
        machines.setText(String.format("%d", prices[7]));
        narcotics.setText(String.format("%d", prices[8]));
        robots.setText(String.format("%d", prices[9]));

        Button purchaseReturn = findViewById(R.id.buy_return_button);
        Button purchase = findViewById(R.id.purchase_button);

        purchaseReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPurchaseReturnPressed(v);
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPurchasePressed(v);
            }
        });

    }

    public void onPurchaseReturnPressed(View view) {

        startActivity(new Intent(Purchase.this, Game_Status.class));

        finish();

    }

    public void onPurchasePressed(View view) {

        PlayerInventory pI = game.getPlayer().getInventory();

        int[] iPA = new int[] {Integer.parseInt(waterQ.getText().toString()),
                Integer.parseInt(foodQ.getText().toString()),
                Integer.parseInt(fursQ.getText().toString()),
                Integer.parseInt(oreQ.getText().toString()),
                Integer.parseInt(gamesQ.getText().toString()),
                Integer.parseInt(firearmsQ.getText().toString()),
                Integer.parseInt(medicineQ.getText().toString()),
                Integer.parseInt(machinesQ.getText().toString()),
                Integer.parseInt(narcoticsQ.getText().toString()),
                Integer.parseInt(robotsQ.getText().toString())};

        int totalA = 0;
        for (int i: iPA) {
            if (i < 0) {
                Toast.makeText(Purchase.this, "Cannot buy negative items.", Toast.LENGTH_LONG).show();
                return;
            }
            totalA += i;
        }
        if (totalA == 0 || !pI.validAdd(Item.ITEM_LIST.get(0), totalA)) {
            Toast.makeText(Purchase.this, "Cannot purchase 0 items or purchase over capacity.", Toast.LENGTH_LONG).show();
            return;
        }
        int totalP = 0;


    }
}
