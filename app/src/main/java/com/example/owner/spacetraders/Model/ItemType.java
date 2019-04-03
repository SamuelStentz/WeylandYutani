package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

public enum ItemType {
    WATER("water"),
    FURS("furs"),
    FOOD("food"),
    ORE("ore"),
    GAMES("games"),
    FIREARMS("firearms"),
    MEDICINE("medicine"),
    MACHINES("machines"),
    NARCOTICS("narcotics"),
    ROBOTS("robots"),
    SWORD("sword");

    private final String name;

    ItemType (String name) {
        this.name = name;
    }
    @NonNull
    public String toString() {
        return name;
    }
}
