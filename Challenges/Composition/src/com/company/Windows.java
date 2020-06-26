package com.company;

public class Windows {
    private Dimensions dimensions;
    private Cost cost;
    private boolean isWeatherProof;
    private boolean isTinted;
    private int numLocks;
    private int numPanes;

    public Windows(Dimensions dimensions, Cost cost, boolean isWeatherProof, boolean isTinted, int numLocks, int numPanes) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.isWeatherProof = isWeatherProof;
        this.isTinted = isTinted;
        this.numLocks = numLocks;
        this.numPanes = numPanes;
    }

    public void openWindow() {
        System.out.println("WINDOW IS NOW OPEN");
    }

    public void closeWindow() {
        System.out.println("WINDOW IS NOW CLOSED");
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cost getCost() {
        return cost;
    }

    public boolean isWeatherProof() {
        return isWeatherProof;
    }

    public boolean isTinted() {
        return isTinted;
    }

    public int getNumLocks() {
        return numLocks;
    }

    public int getNumPanes() {
        return numPanes;
    }
}
