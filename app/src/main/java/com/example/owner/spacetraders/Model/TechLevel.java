package com.example.owner.spacetraders.Model;

import android.support.annotation.NonNull;

public enum TechLevel {
    PREAG("Pre-Agriculture", 0),
    AGRICULTURE("Agriculture", 1),
    MED("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLYIND("Early Industrial", 4),
    IND("Industrial", 5),
    POSTIND("Post-Industrial", 6),
    HITECH("Hi-Tech", 7);

    private final String name;
    private final int value;

    TechLevel(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public int getTechLevel() {
        return value;
    }
    @NonNull
    public String toString() {
        return name;
    }
}
