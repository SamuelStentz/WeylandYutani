package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

public class Item {
    private int MTLP;
    private int MTLU;
    private int TTP;
    private int IPL;
    private int basePrice;
    private int var;
    private String name;
    private ItemType type;

    public Item () {

    }

    private Item(String n, ItemType type, int mtlp, int mtlu, int ttp, int ipl,
                 int basePrice, int var) {
        this.type = type;
        this.name = n;
        this.MTLP = mtlp;
        this.MTLU = mtlu;
        this.var = var;
        this.TTP = ttp;
        this.IPL = ipl;
        this.basePrice = basePrice;
    }

    public int getMTLP() {
        return MTLP;
    }

    public int getMTLU(){
        return MTLU;
    }

    public int getTTP(){
        return TTP;
    }

    public int getIPL() {
        return IPL;
    }

    public int getBasePrice(){
        return basePrice;
    }

    public int getVar() {
        return var;
    }

    @NonNull
    public String toString() {
        return String.format("%s of class %s",name, type.toString());
    }

    public static final List<Item> ITEM_LIST = generate();

    private static List<Item> generate() {
        List<Item> l = new LinkedList<>();
        l.add(new Item("Excalibur", ItemType.SWORD, 4, 3, 8,
                2, 500, 20));
        l.add(new Item("Clean Water", ItemType.WATER, 0, 0, 2,
                3, 30, 4));
        l.add(new Item("Chicken Leg", ItemType.FOOD, 1, 0, 1,
                5, 100, 5));
        l.add(new Item("Sheep Skin", ItemType.FURS, 0, 0, 0,
                3, 250, 10));
        l.add(new Item("Gold", ItemType.ORE, 2, 2, 3,
                20, 450, 10));
        l.add(new Item("Dungeons and Dragons", ItemType.GAMES, 3, 1, 6,
                -10, 150, 5));
        l.add(new Item("Bazooka", ItemType.FIREARMS, 3, 1, 5,
                -75, 1250, 100));
        l.add(new Item("Advil", ItemType.MEDICINE, 4, 1, 6,
                -20, 650, 10));
        l.add(new Item("Gameboy Color", ItemType.MACHINES, 4, 3, 5,
                -30, 900, 5));
        l.add(new Item("Slurp Juice", ItemType.NARCOTICS, 5, 0, 5,
                -125, 3500, 150));
        l.add(new Item("Terminator", ItemType.ROBOTS, 6, 4, 7,
                -150, 5000, 100));
        return l;
    }


}
