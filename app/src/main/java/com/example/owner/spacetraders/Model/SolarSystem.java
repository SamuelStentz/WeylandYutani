package com.example.owner.spacetraders.Model;

import java.util.LinkedList;

public class SolarSystem {
    private String name;
    private static LinkedList<SolarSystem> map = new LinkedList<>();
    private int techLevel;
    private int resourceLevel;
    private Planet planet;
    private Trader trader;

    public SolarSystem(Planet planet) {
        this.name = planet.getName();
        this.techLevel = planet.getTechLevel();
        this.resourceLevel = planet.getResourceLevel();
        this.planet = planet;
        this.trader = new Trader(this);
    }

    public int getTechLevel() {
        return techLevel;
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() {
        return planet;
    }

    public static LinkedList<SolarSystem> generateSolarySystem() {
        Planet pl = new Planet();
        LinkedList<Planet> planetList = pl.getPlanet();
        for (int i = 0; i < planetList.size(); i++) {
            map.add(new SolarSystem(planetList.get(i)));
        }
        return map;
    }

    public String toString() {
        return String.format("Solar System %s | technology level: %s | resource level: %s\n %s",
                this.name, TechLevel.values()[techLevel], ResourceLevel.values()[resourceLevel],trader);
    }
}
