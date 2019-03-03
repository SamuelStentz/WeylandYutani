package com.example.owner.spacetraders.Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Universe {
    private HashMap<SolarSystem, int[]> map = new HashMap<>();
    private LinkedList<SolarSystem> list = SolarSystem.generateSolarySystem();

    public Universe() {
        generateUniverse();
    }

    private void generateUniverse() {
        for (int i = 0; i < list.size(); i++) {
            Random rand = new Random();
            int[] coordinate = new int[]{rand.nextInt(151), rand.nextInt(101)};
            SolarSystem sys = list.get(i);
            map.put(sys, coordinate);
        }
    }

    public HashMap<SolarSystem, int[]> getStar() {
        return map;
    }

    public String toString() {
        String half = "";
        Set<SolarSystem> keySet = map.keySet();
        Iterator<SolarSystem> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            SolarSystem s = iterator.next();
            int[] coordinate = map.get(s);
            half = half + s.toString() + "location: (" + coordinate[0] + ", " + coordinate[1] + ").\n";
        }
        return String.format("Universe: \n" + half);
    }


}