package com.company;

public class Floor {
    private String type;
    private Dimensions dimensions;
    private String color;
    private Cost cost;

    public Floor(String type, Dimensions dimensions, String color, Cost cost) {
        this.type = type;
        this.dimensions = dimensions;
        this.color = color;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getColor() {
        return color;
    }

    public Cost getCost() {
        return cost;
    }
}
