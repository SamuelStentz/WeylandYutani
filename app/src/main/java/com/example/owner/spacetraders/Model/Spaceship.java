package com.example.owner.spacetraders.Model;

public class Spaceship {
    private SpaceshipType type;

    public Spaceship() {
        type = SpaceshipType.GNAT;
    }

    public int getCapacity() {
        return type.getCapacity();
    }

    enum SpaceshipType {
        GNAT("gnat", 5);

        private String name;
        private int capacity;

        SpaceshipType (String s, int c) {
            capacity = c;
            name = s;
        }

        public int getCapacity () {
            return capacity;
        }

        public String toString () {
            return name;
        }
    }

    public SpaceshipType getSpaceshipType() {
        return this.type;
    }
}
