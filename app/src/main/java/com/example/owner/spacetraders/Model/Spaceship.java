package com.example.owner.spacetraders.Model;

public class Spaceship {
    private final SpaceshipType type;
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

    private double getMaxFuel() {
        return type.getMaxFuel();
    }

    private double refill(double f) {
        if(f > (this.getMaxFuel() - this.getCurrentFuel())) {
            return this.fullRefill();
        }
        currentFuel += f;
        return f;
    }

    private double fullRefill() {
        return refill(this.getMaxFuel() - this.getCurrentFuel());
    }

    public boolean loseFuel(double f) {
        if ((currentFuel - f) < 0) {
            return false;
        }
        currentFuel -= f;
        return true;
    }

    enum SpaceshipType {
        GNAT();

        private final String name;
        private final int capacity;
        private final double maxFuel;

        SpaceshipType() {
            capacity = 5;
            name = "gnat";
            maxFuel = (double) 100;
        }

        int getCapacity() {
            return capacity;
        }

        double getMaxFuel() {
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
