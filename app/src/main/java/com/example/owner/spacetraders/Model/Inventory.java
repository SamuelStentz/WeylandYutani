package com.example.owner.spacetraders.Model;
import java.util.Set;

public interface Inventory {
    Set<Item> getItems();
    int getPrice(Item i);
    int getQuantity(Item i);
    boolean addItem(Item i, int k);
    boolean removeItem(Item i, int k);
    boolean validAdd(Item i, int k);
    boolean validRemove(Item i, int k);
}
