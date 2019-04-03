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

public class Sell_Interface extends AppCompatActivity {

    private GameState game;

    private TextView currentCapacity;
    private TextView maximumCapacity;
    private TextView credits;

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

    private int[] iStocks;
    private int[] prices;
    private int startCredits;
    private PlayerInventory pI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__interface);

        game = Model.getInst().getGame();

        Button sellReturn = findViewById(R.id.sell_return_button);
        Button sell = findViewById(R.id.sell_button);

        sellReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSellReturnPressed();
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSellPressed();
            }
        });

        currentCapacity = findViewById(R.id.current_capacity_sell_text);
        maximumCapacity = findViewById(R.id.maximum_capacity_sell_text);
        credits = findViewById(R.id.credits_sell_text);

        pI= game.getPlayer().getInventory();
        currentCapacity.setText(String.format("%d", pI.getCapacity()));
        maximumCapacity.setText(String.format("%d", game.getPlayer().getShip().getCapacity()));

        startCredits = game.getPlayer().getCredits();
        credits.setText(String.format("%d", startCredits));

        water = findViewById(R.id.sell_water_price);
        furs = findViewById(R.id.sell_furs_price);
        food = findViewById(R.id.sell_food_price);
        ore = findViewById(R.id.sell_ore_price);
        games = findViewById(R.id.sell_games_price);
        firearms = findViewById(R.id.sell_firearms_price);
        medicine = findViewById(R.id.sell_medicine_price);
        machines = findViewById(R.id.sell_machines_price);
        narcotics = findViewById(R.id.sell_narcotics_price);
        robots = findViewById(R.id.sell_robots_price);

        prices = new int[10];
        for(int i = 0; i < prices.length; i++) {
            prices[i] =  game.getPlayer().getInventory().getPrice(Item.ITEM_LIST.get(i + 1));
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

        waterS = findViewById(R.id.sell_water_quantity);
        foodS = findViewById(R.id.sell_food_quantity);
        fursS = findViewById(R.id.sell_furs_quantity);
        oreS = findViewById(R.id.sell_ore_quantity);
        gamesS = findViewById(R.id.sell_games_quantity);
        firearmsS = findViewById(R.id.sell_firearms_quantity);
        medicineS = findViewById(R.id.sell_medicine_quantity);
        machinesS = findViewById(R.id.sell_machines_quantity);
        narcoticsS = findViewById(R.id.sell_narcotics_quantity);
        robotsS = findViewById(R.id.sell_robots_quantity);

        iStocks = new int[10];
        for(int i = 0; i < iStocks.length; i++) {
            iStocks[i] =  pI.getQuantity(Item.ITEM_LIST.get(i + 1));
        }

        waterS.setText(String.format("%d", iStocks[0]));
        foodS.setText(String.format("%d", iStocks[1]));
        fursS.setText(String.format("%d", iStocks[2]));
        oreS.setText(String.format("%d", iStocks[3]));
        gamesS.setText(String.format("%d", iStocks[4]));
        firearmsS.setText(String.format("%d", iStocks[5]));
        medicineS.setText(String.format("%d", iStocks[6]));
        machinesS.setText(String.format("%d", iStocks[7]));
        narcoticsS.setText(String.format("%d", iStocks[8]));
        robotsS.setText(String.format("%d", iStocks[9]));

        waterQ = findViewById(R.id.water_sell_amount);
        foodQ = findViewById(R.id.food_sell_amount);
        fursQ = findViewById(R.id.furs_sell_amount);
        oreQ = findViewById(R.id.ore_sell_amount);
        gamesQ = findViewById(R.id.games_sell_amount);
        firearmsQ = findViewById(R.id.firearms_sell_amount);
        medicineQ = findViewById(R.id.medicine_sell_amount);
        machinesQ = findViewById(R.id.machines_sell_amount);
        narcoticsQ = findViewById(R.id.narcotics_sell_amount);
        robotsQ = findViewById(R.id.robots_sell_amount);
    }

    private void onSellPressed() {

        if ("".equals(waterQ.getText().toString())
                || "".equals(foodQ.getText().toString())
                || "".equals(fursQ.getText().toString())
                || "".equals(oreQ.getText().toString())
                || "".equals(gamesQ.getText().toString())
                || "".equals(firearmsQ.getText().toString())
                || "".equals(medicineQ.getText().toString())
                || "".equals(machinesQ.getText().toString())
                || "".equals(narcoticsQ.getText().toString())
                || "".equals(robotsQ.getText().toString())) {
            Toast.makeText(Sell_Interface.this, "MUST enter"
                    + " integers for each box under amount (enter 0 if not selling that item).",
                    Toast.LENGTH_LONG).show();
            return;
        }

        int[] iSA = new int[] {Integer.parseInt(waterQ.getText().toString()),
                Integer.parseInt(foodQ.getText().toString()),
                Integer.parseInt(fursQ.getText().toString()),
                Integer.parseInt(oreQ.getText().toString()),
                Integer.parseInt(gamesQ.getText().toString()),
                Integer.parseInt(firearmsQ.getText().toString()),
                Integer.parseInt(medicineQ.getText().toString()),
                Integer.parseInt(machinesQ.getText().toString()),
                Integer.parseInt(narcoticsQ.getText().toString()),
                Integer.parseInt(robotsQ.getText().toString())};

        for (int i = 0; i < iSA.length; i++) {
            if (!pI.validRemove(Item.ITEM_LIST.get(i + 1), iSA[i])) {
                Toast.makeText(Sell_Interface.this, "Cannot sell more items "
                        + "than what you own.", Toast.LENGTH_LONG).show();
                return;
            }
        }

        for(int j = 0; j < iSA.length; j++) {
            pI.removeItem(Item.ITEM_LIST.get(j + 1), iSA[j]);
            startCredits += iSA[j] * prices[j];
            iStocks[j] -= iSA[j];
        }

        game.getPlayer().setCredits(startCredits);

        waterS.setText(String.format("%d", iStocks[0]));
        foodS.setText(String.format("%d", iStocks[1]));
        fursS.setText(String.format("%d", iStocks[2]));
        oreS.setText(String.format("%d", iStocks[3]));
        gamesS.setText(String.format("%d", iStocks[4]));
        firearmsS.setText(String.format("%d", iStocks[5]));
        medicineS.setText(String.format("%d", iStocks[6]));
        machinesS.setText(String.format("%d", iStocks[7]));
        narcoticsS.setText(String.format("%d", iStocks[8]));
        robotsS.setText(String.format("%d", iStocks[9]));

        credits.setText(String.format("%d", startCredits));
        currentCapacity.setText(String.format("%d", pI.getCapacity()));

        waterQ.setText("0");
        foodQ.setText("0");
        fursQ.setText("0");
        oreQ.setText("0");
        gamesQ.setText("0");
        firearmsQ.setText("0");
        medicineQ.setText("0");
        machinesQ.setText("0");
        narcoticsQ.setText("0");
        robotsQ.setText("0");

    }

    private void onSellReturnPressed() {

        startActivity(new Intent(Sell_Interface.this, Game_Status.class));

        finish();

    }
}
