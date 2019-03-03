package com.example.owner.spacetraders.Model;

import java.util.HashMap;

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

    public HashMap<SolarSystem, int[]> getUniverse(){
        return univ.getStar();
    }

    public String toString() {
        return String.format("Game with player: %s, pilot points: %s, fighter points: %s, trader points: %s, engineer points: %s",
                player.getName(), player.getPilotSkill(), player.getFighterSkill(), player.getTraderSkill(), player.getEngineerSkill());
    }

}
