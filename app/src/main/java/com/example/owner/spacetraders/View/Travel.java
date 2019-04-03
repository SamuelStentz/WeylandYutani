package com.example.owner.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Item;
import com.example.owner.spacetraders.Model.SolarSystem;
import com.example.owner.spacetraders.R;
import com.example.owner.spacetraders.ViewModel.Model;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class Travel extends AppCompatActivity {

    private GameState game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.owner.spacetraders.R.layout.activity_trade);

        game = Model.getInst().getGame();

        SolarSystem[] ss = new SolarSystem[game.inRange().size()];
        ss = game.inRange().toArray(ss);

        Button travelReturn = findViewById(R.id.travel_return_button);

        ArrayAdapter adapter = new ArrayAdapter<SolarSystem>(this, R.layout.list_view, ss);

        final ListView listView = (ListView) findViewById(R.id.solar_system_list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        final SolarSystem[] finalSs = ss;

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                try {
                    Toast toast=Toast.makeText(getApplicationContext(),finalSs[position].toString(),Toast.LENGTH_LONG);
                    toast.setMargin(50,50);
                    toast.show();
                    game.traverse(position);

                    Random rand = new Random();
                    int rand1 = rand.nextInt(100);
                    if (rand1 <= 50 && game.getPlayer().getCredits() >= 100) {
                        game.getPlayer().setCredits(game.getPlayer().getCredits() - 100);
                        Toast toast1 = Toast.makeText(Travel.this,
                                "An asteroid has crashed into your ship, causing damage to your loading dock. "
                                       + "100 credits are needed to repair your ship.", Toast.LENGTH_LONG);
                        toast1.show();
                    }
                } catch (IllegalArgumentException a) {
                    Toast toast=Toast.makeText(getApplicationContext(),a.toString(),Toast.LENGTH_LONG);
                    toast.setMargin(50,50);
                    toast.show();
                }
                onTravelReturnPressed(view);
            } });

        travelReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTravelReturnPressed(v);
            }
        });
    }

    public void onTravelReturnPressed(View view) {

        startActivity(new Intent(Travel.this, Game_Status.class));

        finish();
    }

}