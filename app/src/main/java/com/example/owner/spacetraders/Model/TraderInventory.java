package com.example.owner.spacetraders.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TraderInventory implements Inventory {
    private Trader trader;
    private Map<Item, Integer> map;
    private Map<Item, Integer> cost;


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
                    + i.getIPL() * (trader.getPlanet().getTechLevel()
                    - i.getMTLP()) + (int) Math.random()*i.getVar());
        }

    }

    public Set<Item> getItems() {
        return map.keySet();
    }

    public int getPrice(Item i) {
        if (cost.containsKey(i)) {
            return cost.get(i);
        } else {
            return 0;
        }
    }

    public int getQuantity(Item i) {
        if (map.containsKey(i)) {
            return map.get(i);
        } else {
            return 0;
        }
    }

    public boolean validAdd (Item i, int k) {

        if (trader.getPlanet().getTechLevel() < i.getMTLU()) {
            return false;
        }

        if(trader.getCredits() < getPrice(i) * k) {
            return false;
        }

        return true;
    }

    public boolean addItem(Item i, int k) {

        if (trader.getPlanet().getTechLevel() < i.getMTLU()) {
            return false;
        }

        if(trader.getCredits() < getPrice(i) * k) {
            return false;
        }

        if (map.containsKey(i)) {
            map.put(i, map.get(i) + k);
        } else {
            map.put(i, k);
        }

        return true;
    }

    public boolean validRemove(Item i, int k) {
        if (!map.containsKey(i)) {
            return false;
        }
        int temp = map.get(i);
        if (temp < k) {
            return false;
        }
        return true;
    }


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

    public String toString() {
        String s = "";
        for (Item i : getItems()) {
            String itemName = i.toString();
            int num = getQuantity(i);
            int val = getPrice(i);
            String t = String.format("\t %s: Quantity: %d \tCost: %d\n", itemName, num, val);
            s = s + "\t" + t;
        }
        return s;
    }
}