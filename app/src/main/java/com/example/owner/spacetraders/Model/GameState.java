package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameState {
    @Nullable
    private Player player;
    private Difficulty diff;
    private Universe univ;
    private SolarSystem position;

    public GameState() {
        player = null;
        diff = Difficulty.EASY;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUniverse(Universe universe) {this.univ = universe; }

    public Universe getUni() {return this.univ; }

    public void setPosition(SolarSystem position) {this.position = position; }

    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    public Map<SolarSystem, int[]> getUniverse(){
        return univ.getStar();
    }

    @NonNull
    public String toString() {
        return String.format("Game with %s", player.toString());
    }

    public Player getPlayer() {
        return player;
    }

    public SolarSystem getPosition() {
        return position;
    }

    //Use this method to for the travel screen to show which planets can actually be traveled to.
    public List<SolarSystem> inRange() {
        double fuel = player.getShip().getCurrentFuel();
        List<SolarSystem> solarSystems = univ.getList();
        List<SolarSystem> ret = new LinkedList<>();
        for (int i = 0; i < solarSystems.size(); i++) {
            if (univ.distanceBetween(position, solarSystems.get(i)) <= fuel) {
                ret.add(solarSystems.get(i));
            }
        }
        return ret;
    }

    //Actual traverse. Can be edited depending on how you want to implement the travel view.
    public void traverse(int a) {
        SolarSystem target = univ.getList().get(a);
        List<SolarSystem> inRange = inRange();

        if (target.getName().equals(position.getName())){
            throw new IllegalArgumentException("Already on that solarsystem.");
        } else if (!inRange.contains(target)) {
            throw new IllegalArgumentException("Solarsystem not in range.");
        } else {
            player.getShip().loseFuel(univ.distanceBetween(target, position));
            position = target;
        }
    }

    public int getPositionIndex(SolarSystem sys) {
        List<SolarSystem> solarSystems = univ.getList();
        int i = 0;
        for (SolarSystem s : solarSystems){
            if (s.equals(sys)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public void setPositionIndex(int i) {
        this.position = univ.getList().get(i);
    }


}
