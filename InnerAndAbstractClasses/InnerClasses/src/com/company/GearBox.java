package com.company;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
//    private int gearNumber = 0;
    private int currentGear;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    // it doesn't make sense to talk about a gear except when talking about a gear box
    // instances of Gear have access to ALL members of GearBox

    // members with same name
        // to access member in parent: parent.this.member (gearbox.this.gearNumber)
        // "shadow the declaration of the outer class"
            // gearNumber shadows gearNumber in the oute  r class
        // DO NOT DO THIS - name things in a way that makes sense

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) {
        if (number > 0 && number <= maxGears) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if (newGear >= 0 && newGear < this.gears.size() && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else {
            System.out.println("GRIND");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(  int revs) {
        if (clutchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber; // in the Gear class
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * this.ratio;
        }

        public double getRatio() {
            return ratio;
        }
    }
}
