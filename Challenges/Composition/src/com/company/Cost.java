package com.company;

public class Cost {
    private double price;
    private double maintenanceCost;
    private double insuranceCost;

    public Cost(double price, double maintenanceCost, double insuranceCost) {
        this.price = price;
        this.maintenanceCost = maintenanceCost;
        this.insuranceCost = insuranceCost;
    }

    public double getPrice() {
        return price;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }
}
