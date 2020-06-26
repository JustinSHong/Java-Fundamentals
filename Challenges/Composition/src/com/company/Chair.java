package com.company;

public class Chair {
    private Dimensions dimensions;
    private Cost cost;
    private String color;
    private boolean hasArmRests;
    private boolean isFoldable;
    private int numLegs;

    public Chair(Dimensions dimensions, Cost cost, String color, boolean hasArmRests, boolean isFoldable, int numLegs) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.color = color;
        this.hasArmRests = hasArmRests;
        this.isFoldable = isFoldable;
        this.numLegs = numLegs;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cost getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }

    public boolean isHasArmRests() {
        return hasArmRests;
    }

    public boolean isFoldable() {
        return isFoldable;
    }

    public int getNumLegs() {
        return numLegs;
    }
}
