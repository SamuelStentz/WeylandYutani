package com.example.owner.spacetraders.Model;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class PlayerInventory implements Inventory {

    private Player player;
    private Map<Item, Integer> map;
    private int capacity;

    public PlayerInventory(Player p) {
        map = new HashMap<Item, Integer>();
        player = p;
        capacity = 0;
    }

    public Set<Item> getItems() {
        return map.keySet();
    }
    public int getPrice(Item i) {
        return i.getBasePrice();
    }
    public int getCapacity() {
        return capacity;
    }

    public int getQuantity(Item i) {
        if (map.containsKey(i)) {
            return map.get(i);
        } else {
            return 0;
        }
    }

    public boolean addItem(Item i, int k) {
        if (player.getShip().getCapacity() < capacity + k) {
            return false;
        }

        capacity += k;
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + k);
        } else {
            map.put(i, k);
        }
        return true;
    }

    public boolean validAdd(Item i, int k) {
        if (player.getShip().getCapacity() < capacity + k) {
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
        capacity -= k;
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

    public String toString () {
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
