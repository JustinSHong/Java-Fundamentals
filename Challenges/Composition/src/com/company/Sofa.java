package com.company;

public class Sofa {
    private Dimensions dimensions;
    private Cost cost;
    private String type;
    private String color;
    private int seats;

    public Sofa(Dimensions dimensions, Cost cost, String type, String color, int seats) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.type = type;
        this.seats = seats;
    }

    public void reclineSofa() {
        System.out.println("SOFA IS NOW RECLINED");
    }

    public String getColor() {
        return color;
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

    public int getSeats() {
        return seats;
    }
}
