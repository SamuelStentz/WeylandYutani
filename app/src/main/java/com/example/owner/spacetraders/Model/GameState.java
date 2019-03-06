package com.example.owner.spacetraders.Model;

import java.util.Map;

public class GameState {
    private Player player;
    private Difficulty diff;
    private Universe univ;

    public GameState() {
        player = null;
        diff = Difficulty.EASY;
        univ = null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    public Map<SolarSystem, int[]> getUniverse(){
        return univ.getStar();
    }

    public String toString() {
        return String.format("Game with %s", player.toString());
    }

}
