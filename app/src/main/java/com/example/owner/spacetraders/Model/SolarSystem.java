package com.example.owner.spacetraders.Model;

import java.util.LinkedList;

public class SolarSystem {
    private String name;
    private static LinkedList<SolarSystem> map = new LinkedList<>();
    private int techLevel;
    private int resourceLevel;
    private Planet planet;

    public SolarSystem(Planet planet) {
        this.name = planet.getName();
        this.techLevel = planet.getTechLevel();
        this.resourceLevel = planet.getResourceLevel();
        this.planet = planet;
    }

    public int getTechLevel() {
        return techLevel;
    }
    public int getResourceLevel() {
        return planet.getResourceLevel();
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() {
        return planet;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static LinkedList<SolarSystem> generateSolarySystem() {
        Planet pl = new Planet();
        LinkedList<Planet> planetList = pl.getPlanet();
        for (int i = 0; i < planetList.size(); i++) {
            map.add(new SolarSystem(planetList.get(i)));
        }
        return map;
    }

    public LinkedList<SolarSystem> getSolarSystem() {
        return map;
    }

    public String toString() {
        return String.format("Solar System: %s | tech level: %s\n",
                this.name, TechLevel.values()[techLevel], ResourceLevel.values()[resourceLevel]);
    }

    public Trader getTrader() {
        return planet.getTrader();
    }
}
