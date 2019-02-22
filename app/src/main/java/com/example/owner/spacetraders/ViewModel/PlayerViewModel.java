package com.example.owner.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.owner.spacetraders.Model.Player;

public class PlayerViewModel extends AndroidViewModel {

    private Player player = new Player();

    public PlayerViewModel(@NonNull Application app) {
        super(app);

    }

    public void createPlayer(String name, int pilot, int fighter, int trader, int engineer) {
        player.setName(name);
        player.setPilotSkill(pilot);
        player.setFighterSkill(fighter);
        player.setTraderSkill(trader);
        player.setEngineerSkill(engineer);
        player.setCredits(1000);
    }

    public Player getPlayer() {
        return player;
    }
}
