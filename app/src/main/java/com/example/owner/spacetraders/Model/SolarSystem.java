package com.example.owner.spacetraders.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SolarSystem {
    private final String name;
    private static final LinkedList<SolarSystem> map = new LinkedList<>();
    private final int techLevel;
    private final int resourceLevel;
    private final Planet planet;

    private SolarSystem(Planet planet) {
        this.name = planet.getName();
        this.techLevel = planet.getTechLevel();
        this.resourceLevel = planet.getResourceLevel();
        this.planet = planet;
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

    public static List<SolarSystem> generateSolarySystem() {
        Planet pl = new Planet();
        List<Planet> planetList = pl.getPlanet();
        for (int i = 0; i < planetList.size(); i++) {
            map.add(new SolarSystem(planetList.get(i)));
        }
        return Collections.unmodifiableList(map);
    }

    public String toString() {
        return String.format("Solar System: %s | tech level: %s\n",
                this.name, TechLevel.values()[techLevel], ResourceLevel.values()[resourceLevel]);
    }

    public Trader getTrader() {
        return planet.getTrader();
    }
}
