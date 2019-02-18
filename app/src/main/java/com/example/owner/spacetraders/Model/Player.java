package com.example.owner.spacetraders.Model;

public class Player {
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int credits;
    private String name;
    private Difficulty diff;

    public Player () {
        pilotSkill = 0;
        fighterSkill = 0;
        traderSkill = 0;
        engineerSkill = 0;
        name = null;
        credits = 1000;
    }

    public Player (String name, int pilot,
                   int fighter, int trader, int engineer, Difficulty diff) {
        this.pilotSkill = pilot;
        this.fighterSkill = fighter;
        this.traderSkill = trader;
        this.engineerSkill = engineer;
        this.name = name;
        this.credits = 1000;
        this.diff = diff;
    }

    public Player (String name, int pilot,
                  int fighter, int trader, int engineer) {
        this (name, pilot, fighter, trader, engineer, Difficulty.NORMAL);
    }

    public enum Difficulty {
        EASY("E"),
        NORMAL("N"),
        HARD("H");

        String code;
        Difficulty(String code) { this.code = code;}
    }

    public int getPilotSkill () {
        return pilotSkill;
    }

    public int getFighterSkill () {
        return fighterSkill;
    }

    public int getTraderSkill () {
        return traderSkill;
    }

    public int getEngineerSkill () {
        return engineerSkill;
    }

    public int getCredits () {
        return credits;
    }

    public String getName () {
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

}
