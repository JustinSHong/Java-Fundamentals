package com.company;

public class Wall {
    private Dimensions dimensions;
    private Cost cost;
    private String color;
    private int numOfPaintCoatings;

    public Wall(Dimensions dimensions, Cost cost, String color, int numOfPaintCoatings) {
        this.dimensions = dimensions;
        this.cost = cost;
        this.color = color;
        this.numOfPaintCoatings = numOfPaintCoatings;
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

    public int getNumOfPaintCoatings() {
        return numOfPaintCoatings;
    }
}
