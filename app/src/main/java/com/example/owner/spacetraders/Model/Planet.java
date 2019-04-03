package com.example.owner.spacetraders.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Planet {
    private String name;
    private final LinkedList<Planet> list = new LinkedList<>();
    private int techLevel;
    private int resourceLevel;
    private Trader trader;

    private Planet(String name) {
        this.name = name;
        Random rand = new Random();
        techLevel = rand.nextInt(7);
        resourceLevel = rand.nextInt(13);
        trader = new Trader(this);
    }

    public Planet () {
        generate();
    }

    private void generate() {
        list.add(new Planet("Adahn"));
        list.add(new Planet("Baratas"));
        list.add(new Planet("Brax"));
        list.add(new Planet("Carzon"));
        list.add(new Planet("Deneva"));
        list.add(new Planet("Exo"));
        list.add(new Planet("Mordan"));
        list.add(new Planet("Omega"));
        list.add(new Planet("Sefalla"));
        list.add(new Planet("Utopia"));
    }

    public List<Planet> getPlanet() {
        return Collections.unmodifiableList(list);
    }
    public String getName() {
        return this.name;
    }

    public int getTechLevel() {
        return this.techLevel;
    }

    public int getResourceLevel() {
        return this.resourceLevel;
    }

    public Trader getTrader() {
        return trader;
    }

}
