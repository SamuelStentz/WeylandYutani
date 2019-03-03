package com.example.owner.spacetraders.Model;

import java.util.LinkedList;

public class SolarSystem {
    private String name;
    private static LinkedList<SolarSystem> map = new LinkedList<>();
    private int techLevel;
    private int resourceLevel;


    public SolarSystem(Planet planet) {
        this.name = planet.getName();
        this.techLevel = planet.getTechLevel();
        this.resourceLevel = planet.getResourceLevel();
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
        return String.format("Solar System %s, technology level: %s, resource level: %s", this.name, TechLevel.values()[techLevel], ResourceLevel.values()[resourceLevel]);
    }
}
