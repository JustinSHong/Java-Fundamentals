package com.company;

public class Door {
    private Dimensions dimensions;
    private Cost cost;
    private int numLocks;
    private boolean isElectronic;
    private boolean hasEyeHole;

    public Door(Dimensions dimensions, Cost cost, int numLocks, boolean isElectronic, boolean hasEyeHole) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.numLocks = numLocks;
        this.isElectronic = isElectronic;
        this.hasEyeHole = hasEyeHole;
    }

    public void openDoor() {
        System.out.println("DOOR IS NOW OPEN");
    }

    public void closeDoor() {
        System.out.println("DOOR IS NOW CLOSED");
    }

    public void lockDoor() {
        this.closeDoor();
        System.out.println("DOOR IS NOW LOCKED");
    }

    public void unlockDoor() {
        this.openDoor();
        System.out.println("DOOR IS NOW UNLOCKED");
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cost getCost() {
        return cost;
    }

    public int getNumLocks() {
        return numLocks;
    }

    public boolean isElectronic() {
        return isElectronic;
    }

    public boolean isHasEyeHole() {
        return hasEyeHole;
    }
}
