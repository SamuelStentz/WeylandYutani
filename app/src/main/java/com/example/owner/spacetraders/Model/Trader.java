package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

public class Trader {
    private final Planet planet;
    private final Inventory inventory;
    private final int credits;

    public Trader (Planet planet) {
        this.planet = planet;
        this.inventory = new TraderInventory(this);
        this.credits = (int) (planet.getTechLevel() * Math.random() * 100);
    }

    public Planet getPlanet() {
        return planet;
    }

    public int getCredits () {
        return credits;
    }

    public Inventory getInventory () {
        return inventory;
    }

    @NonNull
    public String toString () {
        return String.format("Trader of %s, \n%s",planet.getName(), inventory.toString());
    }
}
