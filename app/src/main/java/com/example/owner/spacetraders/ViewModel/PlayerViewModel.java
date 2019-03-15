package com.example.owner.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.owner.spacetraders.Model.Difficulty;
import com.example.owner.spacetraders.Model.GameState;
import com.example.owner.spacetraders.Model.Planet;
import com.example.owner.spacetraders.Model.Player;
import com.example.owner.spacetraders.Model.SolarSystem;
import com.example.owner.spacetraders.Model.Universe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerViewModel extends AndroidViewModel {

    private Model model;

    public PlayerViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInst();

    }

    public void init(String name, int pilot, int fighter, int trader, int engineer) {
        GameState game = model.getGame();
        //game.setDiff(diff);
        Player player = new Player(name, pilot, engineer, trader, fighter);
        Universe univ = new Universe();
        game.setPlayer(player);
        game.setUniverse(univ);
        List<SolarSystem> solarSystems = new ArrayList<>(univ.getStar().keySet());
        Random r = new Random();
        SolarSystem sol = solarSystems.get(r.nextInt(solarSystems.size()));
        game.setPosition(sol.getPlanet());
        Log.d("Print", player.toString());
        Log.d("Print", game.toString());
        Log.d("Print", univ.toString());
    }


}
