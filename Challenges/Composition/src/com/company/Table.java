package com.company;

public class Table {
    private Dimensions dimensions;
    private Cost cost;
    private String type; // round, square
    private String color;

    public Table(Dimensions dimensions, Cost cost, String type, String color) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.type = type;
        this.color = color;
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

    public String getColor() {
        return color;
    }
}
