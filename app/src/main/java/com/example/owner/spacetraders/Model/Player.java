package com.example.owner.spacetraders.Model;

public class Player {

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int credits;
    private String name;
    private Spaceship ship;
    private Inventory inventory;
    public Player () {
        pilotSkill = 0;
        fighterSkill = 0;
        traderSkill = 0;
        engineerSkill = 0;
        name = null;
        credits = 1000;
    }

    public Player (String name, int pilot,
                   int fighter, int trader, int engineer) {
        this.pilotSkill = pilot;
        this.fighterSkill = fighter;
        this.traderSkill = trader;
        this.engineerSkill = engineer;
        this.name = name;
        this.credits = 1000;
        this.ship = new Spaceship();
        this.inventory = new PlayerInventory(this);
    }

    private int getPilotSkill() {
        return pilotSkill;
    }

    private int getFighterSkill() {
        return fighterSkill;
    }

    public int getTraderSkill () {
        return traderSkill;
    }

    private int getEngineerSkill() {
        return engineerSkill;
    }

    public int getCredits () {
        return credits;
    }

    private String getName() {
        return name;
    }

    public void setFighterSkill (int skill) {
        fighterSkill = skill;
    }

    public void setTraderSkill (int skill) {
        traderSkill = skill;
    }

    public void setPilotSkill (int skill) {
        pilotSkill = skill;
    }

    public void setEngineerSkill (int skill) {
        engineerSkill = skill;
    }

    public void setCredits (int skill) {
        credits = skill;
    }

    public void setName (String nm) {
        name = nm;
    }

    public void removeCredits (int remove) {
        credits = credits - remove;
    }

    public void addCredits (int add) {
        credits = credits + add;
    }

    public Spaceship getShip () { return ship; }

    public void setShip (Spaceship s) { ship = s; }

    public PlayerInventory getInventory() {
        return (PlayerInventory) inventory;
    }


    public String toString() {
        return String.format("Player: %s, pilot points: %s, fighter points: %s, trader points: %s, engineer points: %s, credits: %s\n%s",
                getName(), getPilotSkill(), getFighterSkill(), getTraderSkill(), getEngineerSkill(), this.getCredits(),this.inventory.toString());
    }

}
