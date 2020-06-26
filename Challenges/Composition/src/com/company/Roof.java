package com.company;

public class Roof {
    private Dimensions dimensions;
    private Cost cost;
    private String type;
    private boolean isWaterProof;
    private boolean isFlat;
    private int numberOfSolarPanels;
    private int timeToRepair;

    public Roof(Dimensions dimensions, Cost cost, String type, boolean isWaterProof, boolean isFlat, int numberOfSolarPanels, int timeToRepair) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.type = type;
        this.isWaterProof = isWaterProof;
        this.isFlat = isFlat;
        this.numberOfSolarPanels = numberOfSolarPanels;
        this.timeToRepair = timeToRepair;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cost getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public boolean isWaterProof() {
        return isWaterProof;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public int getNumberOfSolarPanels() {
        return numberOfSolarPanels;
    }

    public int getTimeToRepair() {
        return timeToRepair;
    }
}
