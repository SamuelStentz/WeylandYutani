package com.example.owner.spacetraders.Model;

public class Trader {
    private SolarSystem solarSystem;
    private Inventory inventory;
    private int credits;

    public Trader (SolarSystem ss) {
        this.solarSystem = ss;
        this.inventory = new TraderInventory(this);
        this.credits = (int) (solarSystem.getTechLevel() * Math.random() * 100);
    }

    public SolarSystem getSolarSystem () {
        return solarSystem;
    }

    public int getCredits () {
        return credits;
    }

    public Inventory getInventory () {
        return inventory;
    }

    public String toString () {
        return String.format("Trader of %s, \n%s",solarSystem.getName(), inventory.toString());
    }
}
