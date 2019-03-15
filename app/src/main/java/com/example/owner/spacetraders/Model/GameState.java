package com.example.owner.spacetraders.Model;

import java.util.Map;

public class GameState {
    private Player player;
    private Difficulty diff;
    private Universe univ;
    private Planet position;

    public GameState() {
        player = null;
        diff = Difficulty.EASY;
        univ = null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUniverse(Universe universe) {this.univ = universe; }

    public void setPosition(Planet position) {this.position = position; }

    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    public Map<SolarSystem, int[]> getUniverse(){
        return univ.getStar();
    }

    public String toString() {
        return String.format("Game with %s", player.toString());
    }

    public Player getPlayer() {
        return player;
    }

    public Planet getPosition() {
        return position;
    }

}
