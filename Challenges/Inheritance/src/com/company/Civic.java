package com.company;

public class Civic extends Car {
    private int roadServiceMonth;

    public Civic(int roadServiceMonth) {
        super("Tesla", 4, "2WD", 6, "combustion", false);
        this.roadServiceMonth = roadServiceMonth;
    }

    public int getRoadServiceMonth() {
        return roadServiceMonth;
    }

    public void setRoadServiceMonth(int roadServiceMonth) {
        this.roadServiceMonth = roadServiceMonth;
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        } else {
            changeGear(4);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}