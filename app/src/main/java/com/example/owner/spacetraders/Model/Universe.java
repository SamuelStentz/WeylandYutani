package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Universe {
    private final Map<SolarSystem, int[]> map = new HashMap<>();
    private final Set<int[]> set = new HashSet<>();
    private final List<SolarSystem> list = SolarSystem.generateSolarySystem();

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
        return Collections.unmodifiableMap(map);
    }

    @NonNull
    public String toString() {
        StringBuilder half = new StringBuilder();
        Set<SolarSystem> keySet = map.keySet();
        Iterator<SolarSystem> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            SolarSystem s = iterator.next();
            int[] coordinate = map.get(s);
            half.append(s.toString()).append(" | location: (").append(coordinate[0])
                    .append(", ").append(coordinate[1]).append(").\n");
        }
        return "Universe: \n" + half;
    }

    public double distanceBetween(SolarSystem a, SolarSystem b) {
        int[] aCoordinates = map.get(a);
        int[] bCoordinates = map.get(b);
        double xdiff = Objects.requireNonNull(aCoordinates)[0] - Objects.requireNonNull(bCoordinates)[0];
        double ydiff = aCoordinates[1] - bCoordinates[1];
        return Math.sqrt(Math.pow(xdiff, 2) + Math.pow(ydiff, 2));
    }

    public List<SolarSystem> getList() {
        return Collections.unmodifiableList(list);
    }
}
