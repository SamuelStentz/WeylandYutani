package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TraderInventory implements Inventory {
    private final Trader trader;
    private final Map<Item, Integer> map;
    private final Map<Item, Integer> cost;

    public TraderInventory(Trader t) {
        map = new HashMap<Item, Integer>();
        cost = new HashMap<Item, Integer>();
        trader = t;

        for (Item i : Item.ITEM_LIST) {
            if (trader.getPlanet().getTechLevel() >= i.getMTLP()) {
                if (trader.getPlanet().getTechLevel() >= i.getTTP()){
                    map.put(i, (int) (Math.random() * 6));
                } else {
                    map.put(i, (int) (Math.random() * 3));
                }
            }
        }

        for(Item i : map.keySet()){
            cost.put(i, i.getBasePrice()
                    + (i.getIPL() * (trader.getPlanet().getTechLevel()
                    - i.getMTLP())) + ((int) (Math.random() * i.getVar())));
        }

    }

    @Override
    public Set<Item> getItems() {
        return map.keySet();
    }

    @Override
    public int getPrice(Item i) {
        if (cost.containsKey(i)) {
            return cost.get(i);
        } else {
            return 0;
        }
    }

    @Override
    public int getQuantity(Item i) {
        if (map.containsKey(i)) {
            return map.get(i);
        } else {
            return 0;
        }
    }

    @Override
    public boolean validAdd (Item i, int k) {

        if (trader.getPlanet().getTechLevel() < i.getMTLU()) {
            return false;
        }

        return trader.getCredits() >= (getPrice(i) * k);
    }

    @Override
    public boolean addItem(Item i, int k) {

        if (trader.getPlanet().getTechLevel() < i.getMTLU()) {
            return false;
        }

        if(trader.getCredits() < (getPrice(i) * k)) {
            return false;
        }

        if (map.containsKey(i)) {
            map.put(i, map.get(i) + k);
        } else {
            map.put(i, k);
        }

        return true;
    }

    @Override
    public boolean validRemove(Item i, int k) {
        if (!map.containsKey(i)) {
            return false;
        }
        int temp = map.get(i);
        return temp >= k;
    }


    @Override
    public boolean removeItem(Item i, int k) {
        if (!map.containsKey(i)) {
            return false;
        }

        int temp = map.get(i);
        if (temp < k) {
            return false;
        }
        map.put(i, temp - k);
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item i : getItems()) {
            String itemName = i.toString();
            int num = getQuantity(i);
            int val = getPrice(i);
            String t = String.format("\t %s: Quantity: %d \tCost: %d\n", itemName, num, val);
            s.append("\t").append(t);
        }
        return s.toString();
    }
}