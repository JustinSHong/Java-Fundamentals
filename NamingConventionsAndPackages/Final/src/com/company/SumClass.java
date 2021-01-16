package com.company;

public class SumClass {

    private static int classCounter = 0;
    private final String name;
    public final int instanceNumber;

    public SumClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        // value is a result of a calculation -> reading from DB store class instances unique db key
            // key may not be available until read is complete

        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
