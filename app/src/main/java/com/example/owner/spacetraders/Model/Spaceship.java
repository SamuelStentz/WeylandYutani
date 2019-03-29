package com.example.owner.spacetraders.Model;

public class Spaceship {
    private SpaceshipType type;
    private int currentFuel;

    public Spaceship() {
        type = SpaceshipType.GNAT;
        currentFuel = type.getMaxFuel();
    }

    public int getCapacity() {
        return type.getCapacity();
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public int getMaxFuel() {
        return type.getMaxFuel();
    }

    public int refill(int f) {
        if(f > this.getMaxFuel() - this.getCurrentFuel()) {
            return this.fullRefill();
        }
        currentFuel += f;
        return f;
    }

    public int fullRefill() {
        return refill(this.getMaxFuel() - this.getCurrentFuel());
    }

    public boolean loseFuel(int f) {
        if (currentFuel - f < 0) {
            return false;
        }
        currentFuel -= f;
        return true;
    }

    enum SpaceshipType {
        GNAT("gnat", 5, 100);

        private String name;
        private int capacity;
        private int maxFuel;

        SpaceshipType (String s, int c, int f) {
            capacity = c;
            name = s;
            maxFuel = f;
        }

        public int getCapacity () {
            return capacity;
        }

        public int getMaxFuel() {
            return maxFuel;
        }

        public String toString () {
            return name;
        }
    }

    public SpaceshipType getSpaceshipType() {
        return this.type;
    }
}
