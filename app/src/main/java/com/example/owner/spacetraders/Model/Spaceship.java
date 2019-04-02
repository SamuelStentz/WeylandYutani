package com.example.owner.spacetraders.Model;

public class Spaceship {
    private SpaceshipType type;
    private double currentFuel;

    public Spaceship() {
        type = SpaceshipType.GNAT;
        currentFuel = type.getMaxFuel();
    }

    public int getCapacity() {
        return type.getCapacity();
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public double getMaxFuel() {
        return type.getMaxFuel();
    }

    public double refill(double f) {
        if(f > this.getMaxFuel() - this.getCurrentFuel()) {
            return this.fullRefill();
        }
        currentFuel += f;
        return f;
    }

    public double fullRefill() {
        return refill(this.getMaxFuel() - this.getCurrentFuel());
    }

    public boolean loseFuel(double f) {
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
        private double maxFuel;

        SpaceshipType (String s, int c, double f) {
            capacity = c;
            name = s;
            maxFuel = f;
        }

        public int getCapacity () {
            return capacity;
        }

        public double getMaxFuel() {
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
