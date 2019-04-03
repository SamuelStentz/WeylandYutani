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
import com.example.owner.spacetraders.Model.TraderInventory;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;

import java.util.Random;

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

    private int[] stocks;
    private int[] prices;
    private int startCredits;
    private PlayerInventory pI;
    private TraderInventory tI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        game = Model.getInst().getGame();

        currentCapacity = findViewById(R.id.current_capacity_buy_text);
        maximumCapacity = findViewById(R.id.maximum_capacity_buy_text);
        credits = findViewById(R.id.credits_buy_text);

        pI = game.getPlayer().getInventory();
        tI = (TraderInventory) game.getPosition().getTrader().getInventory();
        currentCapacity.setText(String.format("%d", pI.getCapacity()));
        maximumCapacity.setText(String.format("%d", game.getPlayer().getShip().getCapacity()));

        startCredits = game.getPlayer().getCredits();
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

        waterS = findViewById(R.id.buy_water_quantity);
        foodS = findViewById(R.id.buy_food_quantity);
        fursS = findViewById(R.id.buy_furs_quantity);
        oreS = findViewById(R.id.buy_ore_quantity);
        gamesS = findViewById(R.id.buy_games_quantity);
        firearmsS = findViewById(R.id.buy_firearms_quantity);
        medicineS = findViewById(R.id.buy_medicine_quantity);
        machinesS = findViewById(R.id.buy_machines_quantity);
        narcoticsS = findViewById(R.id.buy_narcotics_quantity);
        robotsS = findViewById(R.id.buy_robots_quantity);

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

        stocks = new int[10];
        for(int i = 0; i < stocks.length; i++) {
            stocks[i] =  tI.getQuantity(Item.ITEM_LIST.get(i + 1));
        }

        waterS.setText(String.format("%d", stocks[0]));
        foodS.setText(String.format("%d", stocks[1]));
        fursS.setText(String.format("%d", stocks[2]));
        oreS.setText(String.format("%d", stocks[3]));
        gamesS.setText(String.format("%d", stocks[4]));
        firearmsS.setText(String.format("%d", stocks[5]));
        medicineS.setText(String.format("%d", stocks[6]));
        machinesS.setText(String.format("%d", stocks[7]));
        narcoticsS.setText(String.format("%d", stocks[8]));
        robotsS.setText(String.format("%d", stocks[9]));

        prices = new int[10];
        for(int i = 0; i < prices.length; i++) {
            prices[i] =  tI.getPrice(Item.ITEM_LIST.get(i + 1)) + 50;
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
                onPurchaseReturnPressed();
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPurchasePressed();
            }
        });

    }

    private void onPurchaseReturnPressed() {

        startActivity(new Intent(Purchase.this, Market.class));

        finish();

    }

    private void onPurchasePressed() {

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
            Toast.makeText(Purchase.this, "MUST enter integers"
                    + " for each box under amount (enter 0 if not buying that item).",
                    Toast.LENGTH_LONG).show();
            return;
        }

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
        int totalP = 0;
        for (int i = 0; i < iPA.length; i++) {
            if (iPA[i] < 0) {
                Toast.makeText(Purchase.this, "Cannot buy negative items.",
                        Toast.LENGTH_LONG).show();
                return;
            } else if (iPA[i] > stocks[i]) {
                Toast.makeText(Purchase.this, "Cannot buy more items than "
                        + "what the marketplace provides.", Toast.LENGTH_LONG).show();
                return;
            }
            totalA += iPA[i];
            totalP += iPA[i] * prices[i];
        }
        if ((totalA == 0) || !pI.validAdd(Item.ITEM_LIST.get(0), totalA)) {
            Toast.makeText(Purchase.this, "Cannot purchase 0 items or "
                    + "purchase over capacity.", Toast.LENGTH_LONG).show();
            return;
        } else if (totalP > startCredits) {
            Toast.makeText(Purchase.this, "You do not have enough credits"
                    + " to purchase these items.", Toast.LENGTH_LONG).show();
            return;
        }
        for(int j = 0; j < iPA.length; j++) {
            pI.addItem(Item.ITEM_LIST.get(j + 1), iPA[j]);
            startCredits -= iPA[j] * prices[j];
            stocks[j] = stocks[j] - iPA[j];
            tI.removeItem(Item.ITEM_LIST.get(j + 1), iPA[j]);
        }

        Random rand = new Random();
        int rand1 = rand.nextInt(100);
        int rand2 = rand.nextInt(9);
        if (rand1 >= 50) {
            pI.addItem(Item.ITEM_LIST.get(rand2), 1);
            Toast.makeText(Purchase.this, "Wow, how lucky! "
                   + "You receive (an) extra " + Item.ITEM_LIST.get(rand2) + " from the trader.", Toast.LENGTH_LONG).show();
        }

        game.getPlayer().setCredits(startCredits);

        waterS.setText(String.format("%d", stocks[0]));
        foodS.setText(String.format("%d", stocks[1]));
        fursS.setText(String.format("%d", stocks[2]));
        oreS.setText(String.format("%d", stocks[3]));
        gamesS.setText(String.format("%d", stocks[4]));
        firearmsS.setText(String.format("%d", stocks[5]));
        medicineS.setText(String.format("%d", stocks[6]));
        machinesS.setText(String.format("%d", stocks[7]));
        narcoticsS.setText(String.format("%d", stocks[8]));
        robotsS.setText(String.format("%d", stocks[9]));

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
}
