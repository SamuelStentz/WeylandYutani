package com.example.owner.spacetraders.Model;

public enum ResourceLevel {
    NONE("NOSPECIALRESOURCES", 1),
    MINERALRICH("MINERALRICH", 2),
    MINERALPOOR("MINERALPOOR", 3),
    DESERT("DESERT", 4),
    WATER("LOTSOFWATER", 5),
    SRICH("RICHSOIL", 6),
    SPOOR("POORSOIL", 7),
    FAUNARICH("RICHFAUNA", 8),
    LIFELESS("LIFELESS", 9),
    MUSHROOMS("WEIRDMUSHROOMS", 10),
    HERBS("LOTSOFHERBS", 11),
    ARTISTIC("ARTISTIC", 12),
    WARLIKE("WARLIKE", 13);
    private final String name;
    private final int value;

    ResourceLevel(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public String toString() {
        return name;
    }
}