package com.example.owner.spacetraders.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Universe {
    private Map<SolarSystem, int[]> map = new HashMap<>();
    private Set<int[]> set = new HashSet<>();
    private List<SolarSystem> list = SolarSystem.generateSolarySystem();

    public Universe() {
        generateUniverse();
    }

    private void generateUniverse() {
        for (int i = 0; i < list.size(); i++) {
            Random rand = new Random();
            int[] coordinate = new int[]{rand.nextInt(151), rand.nextInt(101)};
            SolarSystem sys = list.get(i);
            while(set.contains(coordinate)) {
                coordinate = new int[]{rand.nextInt(151), rand.nextInt(101)};
            }
            set.add(coordinate);
            map.put(sys, coordinate);
        }
    }

    public Map<SolarSystem, int[]> getStar() {
        return map;
    }

    public String toString() {
        String half = "";
        Set<SolarSystem> keySet = map.keySet();
        Iterator<SolarSystem> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            SolarSystem s = iterator.next();
            int[] coordinate = map.get(s);
            half = half + s.toString() + " | location: (" + coordinate[0] + ", " + coordinate[1] + ").\n";
        }
        return String.format("Universe: \n" + half);
    }


}
